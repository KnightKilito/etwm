package com.etcxm.www.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//ctrl+d 删除整行
public class DBUtil {
	
	private static String DRIVER;
	private static String URL;
	private static String DBUSER;
	private static String DBPWD;
	
	static{
		ResourceBundle resourceBundle=ResourceBundle.getBundle("db");
		DRIVER=resourceBundle.getString("driver");
		URL=resourceBundle.getString("url");
		DBUSER=resourceBundle.getString("dbUser");
		DBPWD=resourceBundle.getString("dbPwd");
	}
	
	private Connection connection;
	private PreparedStatement preparedStatement;
	private ResultSet resultSet;
	
	//执行新增、更新、删除
	public int update(String sql,Object... params){
		int r=0;	//最后结果
		try {
			getConnection();	//数据库连接
			preparedStatement=connection.prepareStatement(sql);		//实例语句
			if(params!=null){	//判断非空指针
				for(int i=0;i<params.length;i++){	//循环读取参数数据
					preparedStatement.setObject(i+1, params[i]);	//设置语句对应的值
				}
			}
			r=preparedStatement.executeUpdate();	//执行更新
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();	//关闭连接
		}
		return r;
	}
	
	//执行查询时调用
	public ResultSet query(String sql,Object... params){
		try {
			getConnection();
			preparedStatement=connection.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					preparedStatement.setObject(i+1, params[i]);
				}
			}
			resultSet=preparedStatement.executeQuery();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			//暂时不关闭，外边调用端手动关闭
			//一旦关闭数据库的连接，数据集中数据就清空了。
		}
		return resultSet;
	}
	
	//获取数据库连接
	public Connection getConnection(){
		try {
			Class.forName(DRIVER);
			connection=DriverManager.getConnection(URL,DBUSER,DBPWD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	//关闭对象
	public void close(){
		if(resultSet!=null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(preparedStatement!=null)
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		if(connection!=null)
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
	
	

}
