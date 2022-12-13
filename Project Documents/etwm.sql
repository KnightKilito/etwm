/*
 Navicat Premium Data Transfer

 Source Server         : Local
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : etwm

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 25/06/2021 01:27:06
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for guest_shop_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `guest_shop_shopcar`;
CREATE TABLE `guest_shop_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kfc_product
-- ----------------------------
DROP TABLE IF EXISTS `kfc_product`;
CREATE TABLE `kfc_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  `shopcar_order_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kfc_product
-- ----------------------------
INSERT INTO `kfc_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL, NULL);
INSERT INTO `kfc_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL, NULL);
INSERT INTO `kfc_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL, NULL);

-- ----------------------------
-- Table structure for kfc_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `kfc_shopcar`;
CREATE TABLE `kfc_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kfc_shopcar
-- ----------------------------
INSERT INTO `kfc_shopcar` VALUES (68, 1, '双层吉士汉堡', 15.00, 3);

-- ----------------------------
-- Table structure for kfc_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `kfc_shopcar_history`;
CREATE TABLE `kfc_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of kfc_shopcar_history
-- ----------------------------
INSERT INTO `kfc_shopcar_history` VALUES (78, 3, '香炸鸡腿堡', 14.00, 1, 10, 'wjxx', '13709090909', '福建省泉州市南安区某栋楼楼下');
INSERT INTO `kfc_shopcar_history` VALUES (79, 1, '双层吉士汉堡', 15.00, 1, 10, 'wjxx', '13709090909', '福建省泉州市南安区某栋楼楼下');

-- ----------------------------
-- Table structure for mcdonald_product
-- ----------------------------
DROP TABLE IF EXISTS `mcdonald_product`;
CREATE TABLE `mcdonald_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mcdonald_product
-- ----------------------------
INSERT INTO `mcdonald_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL);
INSERT INTO `mcdonald_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL);
INSERT INTO `mcdonald_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL);

-- ----------------------------
-- Table structure for mcdonald_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `mcdonald_shopcar`;
CREATE TABLE `mcdonald_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of mcdonald_shopcar
-- ----------------------------
INSERT INTO `mcdonald_shopcar` VALUES (68, 1, '双层吉士汉堡', 15.00, 3);

-- ----------------------------
-- Table structure for mcdonald_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `mcdonald_shopcar_history`;
CREATE TABLE `mcdonald_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop
-- ----------------------------
DROP TABLE IF EXISTS `shop`;
CREATE TABLE `shop`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `shop_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shopkeeper` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shop_address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `connect_phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `avg_price` decimal(10, 2) NOT NULL,
  `shop_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `shop_star` decimal(10, 1) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_shop_name`(`shop_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of shop
-- ----------------------------
INSERT INTO `shop` VALUES (1, 'KFC', 'wjx', '小高五1703', '18011111111', 45.00, 'KFC.jpg', 3.8);
INSERT INTO `shop` VALUES (2, 'McDonald', 'wjx', '小高五1703', '18011111112', 200.50, 'McDonald.jpg', 3.9);
INSERT INTO `shop` VALUES (3, '德克士', 'xys', '黄石镇东井街路口', '15080111111', 50.80, 'Dicos.jpg', 4.2);
INSERT INTO `shop` VALUES (4, '树树牛排店', 'xys', '集源路356号', '18030184444', 190.80, 'ShuShuBeef.jpg', 3.7);
INSERT INTO `shop` VALUES (5, '枫枫沙县小吃', 'yf', '孙厝路口38号', '15011881199', 10.20, 'FFsxxc.jpg', 4.3);
INSERT INTO `shop` VALUES (6, '东东家常菜', 'zxd', '孙厝小铁门1号', '19077332288', 40.60, 'ddjcc.jpg', 5.0);
INSERT INTO `shop` VALUES (7, '斌哥烧烤', 'cxb', '泉州府1号大豪宅花园', '15088997777', 300.50, 'bgsk.jpg', 5.0);
INSERT INTO `shop` VALUES (8, '斌哥卤味', 'cxb', '泉州府1号大豪宅餐厅', '15088993333', 2000.30, 'bglw.jpg', 5.0);
INSERT INTO `shop` VALUES (9, '东东小炒', 'zxd', '河南宝马车上', '17099886666', 1599.40, 'ddxc.jpg', 4.7);
INSERT INTO `shop` VALUES (10, '枫枫牛子铺', 'yf', '小高五1703 04号床', '19088881112', 290.00, 'FFBeef.jpg', 4.8);
INSERT INTO `shop` VALUES (13, '树树卤味', 'xys', '大东北', '180191919191', 90.00, 'bglw.jpg', 4.3);
INSERT INTO `shop` VALUES (14, '轩轩麦片', '吴俊轩', '小高五1703', '15080110099', 20000.00, 'ShuShuBeef.jpg', 1.2);
INSERT INTO `shop` VALUES (15, '树树牛肉店', 'xys', '福建省泉州市安溪县xxx', '180191919191', 30.00, 'FFBeef.jpg', 4.3);

-- ----------------------------
-- Table structure for shop_product
-- ----------------------------
DROP TABLE IF EXISTS `shop_product`;
CREATE TABLE `shop_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `realname` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `type` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'sunny', '123456', '', '', 'guest', '福建省泉州市南安区某栋楼楼下', 10, 'wjx123.jpg');
INSERT INTO `user` VALUES (2, 'glasscomet', '123456', 'xys', '18010090901', 'shopkeeper', NULL, 0, 'wjx123.jpg');
INSERT INTO `user` VALUES (3, 'kilo', '123456', 'Kilo', '150 8037 66666', 'guest', NULL, 1, NULL);
INSERT INTO `user` VALUES (4, '大蓝趴', '1111', 'wjxx', '13709090910', 'guest', '福建省泉州市南安区某栋楼楼下', 2, NULL);

-- ----------------------------
-- Table structure for 东东家常菜_product
-- ----------------------------
DROP TABLE IF EXISTS `东东家常菜_product`;
CREATE TABLE `东东家常菜_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 东东家常菜_product
-- ----------------------------
INSERT INTO `东东家常菜_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL);
INSERT INTO `东东家常菜_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL);
INSERT INTO `东东家常菜_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL);

-- ----------------------------
-- Table structure for 东东家常菜_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `东东家常菜_shopcar`;
CREATE TABLE `东东家常菜_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 东东家常菜_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `东东家常菜_shopcar_history`;
CREATE TABLE `东东家常菜_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 东东小炒_product
-- ----------------------------
DROP TABLE IF EXISTS `东东小炒_product`;
CREATE TABLE `东东小炒_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 东东小炒_product
-- ----------------------------
INSERT INTO `东东小炒_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL);
INSERT INTO `东东小炒_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL);
INSERT INTO `东东小炒_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL);

-- ----------------------------
-- Table structure for 东东小炒_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `东东小炒_shopcar`;
CREATE TABLE `东东小炒_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 东东小炒_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `东东小炒_shopcar_history`;
CREATE TABLE `东东小炒_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 德克士_product
-- ----------------------------
DROP TABLE IF EXISTS `德克士_product`;
CREATE TABLE `德克士_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 德克士_product
-- ----------------------------
INSERT INTO `德克士_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL);
INSERT INTO `德克士_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL);
INSERT INTO `德克士_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL);

-- ----------------------------
-- Table structure for 德克士_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `德克士_shopcar`;
CREATE TABLE `德克士_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 德克士_shopcar
-- ----------------------------
INSERT INTO `德克士_shopcar` VALUES (68, 1, '双层吉士汉堡', 15.00, 3);

-- ----------------------------
-- Table structure for 德克士_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `德克士_shopcar_history`;
CREATE TABLE `德克士_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 82 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 德克士_shopcar_history
-- ----------------------------
INSERT INTO `德克士_shopcar_history` VALUES (34, 3, '香炸鸡腿堡', 14.00, 1, 1, 'wjx', '12233333333', '福建省厦门市');
INSERT INTO `德克士_shopcar_history` VALUES (35, 2, '板烧鸡腿堡', 13.00, 1, 2, 'wjxx', '11111111111', '福建省泉州市');
INSERT INTO `德克士_shopcar_history` VALUES (36, 1, '双层吉士汉堡', 15.00, 1, 3, 'wjxxx', '14444444444', '福建省福州市');
INSERT INTO `德克士_shopcar_history` VALUES (37, 2, '板烧鸡腿堡', 13.00, 1, 3, 'wjxxx', '14444444444', '福建省福州市');
INSERT INTO `德克士_shopcar_history` VALUES (58, 2, '板烧鸡腿堡', 13.00, 1, 3, 'wjxxx', '14444444444', '福建省福州市');
INSERT INTO `德克士_shopcar_history` VALUES (78, 2, '板烧鸡腿堡', 13.00, 1, 8, 'wjxx', '13709090909', '福建省泉州市南安区某栋楼楼下');
INSERT INTO `德克士_shopcar_history` VALUES (79, 1, '双层吉士汉堡', 15.00, 1, 9, 'wjxxxxx', '13709090910', 'LONGGAN');
INSERT INTO `德克士_shopcar_history` VALUES (80, 2, '板烧鸡腿堡', 13.00, 4, 2, 'wjxx', '13709090910', '福建省泉州市南安区某栋楼楼下');
INSERT INTO `德克士_shopcar_history` VALUES (81, 2, '板烧鸡腿堡', 13.00, 4, 2, 'wjxx', '13709090910', '福建省泉州市南安区某栋楼楼下');

-- ----------------------------
-- Table structure for 斌哥卤味_product
-- ----------------------------
DROP TABLE IF EXISTS `斌哥卤味_product`;
CREATE TABLE `斌哥卤味_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 斌哥卤味_product
-- ----------------------------
INSERT INTO `斌哥卤味_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL);
INSERT INTO `斌哥卤味_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL);
INSERT INTO `斌哥卤味_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL);

-- ----------------------------
-- Table structure for 斌哥卤味_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `斌哥卤味_shopcar`;
CREATE TABLE `斌哥卤味_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 斌哥卤味_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `斌哥卤味_shopcar_history`;
CREATE TABLE `斌哥卤味_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 斌哥烧烤_product
-- ----------------------------
DROP TABLE IF EXISTS `斌哥烧烤_product`;
CREATE TABLE `斌哥烧烤_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 斌哥烧烤_product
-- ----------------------------
INSERT INTO `斌哥烧烤_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL);
INSERT INTO `斌哥烧烤_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL);
INSERT INTO `斌哥烧烤_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL);

-- ----------------------------
-- Table structure for 斌哥烧烤_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `斌哥烧烤_shopcar`;
CREATE TABLE `斌哥烧烤_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 斌哥烧烤_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `斌哥烧烤_shopcar_history`;
CREATE TABLE `斌哥烧烤_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 枫枫沙县小吃_product
-- ----------------------------
DROP TABLE IF EXISTS `枫枫沙县小吃_product`;
CREATE TABLE `枫枫沙县小吃_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 枫枫沙县小吃_product
-- ----------------------------
INSERT INTO `枫枫沙县小吃_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL);
INSERT INTO `枫枫沙县小吃_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL);
INSERT INTO `枫枫沙县小吃_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL);

-- ----------------------------
-- Table structure for 枫枫沙县小吃_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `枫枫沙县小吃_shopcar`;
CREATE TABLE `枫枫沙县小吃_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 枫枫沙县小吃_shopcar
-- ----------------------------
INSERT INTO `枫枫沙县小吃_shopcar` VALUES (71, 1, '双层吉士汉堡', 15.00, 1);

-- ----------------------------
-- Table structure for 枫枫沙县小吃_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `枫枫沙县小吃_shopcar_history`;
CREATE TABLE `枫枫沙县小吃_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 枫枫牛子铺_product
-- ----------------------------
DROP TABLE IF EXISTS `枫枫牛子铺_product`;
CREATE TABLE `枫枫牛子铺_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 枫枫牛子铺_product
-- ----------------------------
INSERT INTO `枫枫牛子铺_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL);
INSERT INTO `枫枫牛子铺_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL);
INSERT INTO `枫枫牛子铺_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL);

-- ----------------------------
-- Table structure for 枫枫牛子铺_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `枫枫牛子铺_shopcar`;
CREATE TABLE `枫枫牛子铺_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 枫枫牛子铺_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `枫枫牛子铺_shopcar_history`;
CREATE TABLE `枫枫牛子铺_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 树树卤味_product
-- ----------------------------
DROP TABLE IF EXISTS `树树卤味_product`;
CREATE TABLE `树树卤味_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 树树卤味_product
-- ----------------------------
INSERT INTO `树树卤味_product` VALUES (4, 'ps6', 1112.00, '好玩，很好看，跟空气一样看不见', 'latest-listings-img-3.jpg', 1.20, NULL);

-- ----------------------------
-- Table structure for 树树卤味_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `树树卤味_shopcar`;
CREATE TABLE `树树卤味_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 树树卤味_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `树树卤味_shopcar_history`;
CREATE TABLE `树树卤味_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 树树牛排店_product
-- ----------------------------
DROP TABLE IF EXISTS `树树牛排店_product`;
CREATE TABLE `树树牛排店_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of 树树牛排店_product
-- ----------------------------
INSERT INTO `树树牛排店_product` VALUES (1, '双层吉士汉堡', 15.00, '口味一般，杨枫喜欢吃', 'hamburger-doubleJiShi.jpg', 4.20, NULL);
INSERT INTO `树树牛排店_product` VALUES (2, '板烧鸡腿堡', 13.00, '好吃', 'hamburger-burnChicken.jpg', 4.40, NULL);
INSERT INTO `树树牛排店_product` VALUES (3, '香炸鸡腿堡', 14.00, '热量极高', 'hamburger-frychicken.jpg', 4.60, NULL);

-- ----------------------------
-- Table structure for 树树牛排店_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `树树牛排店_shopcar`;
CREATE TABLE `树树牛排店_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 树树牛排店_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `树树牛排店_shopcar_history`;
CREATE TABLE `树树牛排店_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 树树牛肉店_product
-- ----------------------------
DROP TABLE IF EXISTS `树树牛肉店_product`;
CREATE TABLE `树树牛肉店_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 树树牛肉店_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `树树牛肉店_shopcar`;
CREATE TABLE `树树牛肉店_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 树树牛肉店_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `树树牛肉店_shopcar_history`;
CREATE TABLE `树树牛肉店_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 轩轩麦片_product
-- ----------------------------
DROP TABLE IF EXISTS `轩轩麦片_product`;
CREATE TABLE `轩轩麦片_product`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `product_introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `product_pic_file` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_star` decimal(10, 2) NULL DEFAULT NULL,
  `shopcar_product_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `uni_product_productname`(`product_name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 轩轩麦片_shopcar
-- ----------------------------
DROP TABLE IF EXISTS `轩轩麦片_shopcar`;
CREATE TABLE `轩轩麦片_shopcar`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 71 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for 轩轩麦片_shopcar_history
-- ----------------------------
DROP TABLE IF EXISTS `轩轩麦片_shopcar_history`;
CREATE TABLE `轩轩麦片_shopcar_history`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `product_id` int(0) NOT NULL,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `product_price` decimal(10, 2) NOT NULL,
  `guest_id` int(0) NULL DEFAULT NULL,
  `order_id` int(0) NULL DEFAULT NULL,
  `addressee` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `phone` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `address` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 78 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
