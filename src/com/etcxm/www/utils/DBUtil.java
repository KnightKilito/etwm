package com.etcxm.www.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

//ctrl+d ɾ������
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
	
	//ִ�����������¡�ɾ��
	public int update(String sql,Object... params){
		int r=0;	//�����
		try {
			getConnection();	//���ݿ�����
			preparedStatement=connection.prepareStatement(sql);		//ʵ�����
			if(params!=null){	//�жϷǿ�ָ��
				for(int i=0;i<params.length;i++){	//ѭ����ȡ��������
					preparedStatement.setObject(i+1, params[i]);	//��������Ӧ��ֵ
				}
			}
			r=preparedStatement.executeUpdate();	//ִ�и���
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();	//�ر�����
		}
		return r;
	}
	
	//ִ�в�ѯʱ����
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
			//��ʱ���رգ���ߵ��ö��ֶ��ر�
			//һ���ر����ݿ�����ӣ����ݼ������ݾ�����ˡ�
		}
		return resultSet;
	}
	
	//��ȡ���ݿ�����
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
	
	//�رն���
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
