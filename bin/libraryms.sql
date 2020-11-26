/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50731
Source Host           : localhost:3306
Source Database       : libraryms

Target Server Type    : MYSQL
Target Server Version : 50731
File Encoding         : 65001

Date: 2020-11-23 10:55:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `book_id` int(20) NOT NULL AUTO_INCREMENT,
  `book_name` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `book_author` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `book_pub` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `book_num` int(20) DEFAULT NULL,
  `book_sort` varchar(30) CHARACTER SET utf8mb4 DEFAULT NULL,
  `book_record` datetime DEFAULT NULL,
  `book_left` int(20) DEFAULT NULL,
  PRIMARY KEY (`book_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('2', '三国志', '苏斯', '爸爸出版社', '5', '历史', '2020-11-17 00:00:00', '4');
INSERT INTO `book` VALUES ('3', '水浒传', '马保国', '弟弟出版社', '6', '武侠', '2020-11-17 00:00:00', '3');
INSERT INTO `book` VALUES ('4', '火影', '条野太长', '弟弟出版社', '4', '动漫', '2020-11-17 00:00:00', '2');
INSERT INTO `book` VALUES ('5', '三国转', null, null, null, null, null, null);
INSERT INTO `book` VALUES ('6', '三国', null, null, null, null, '2020-11-23 09:33:55', null);

-- ----------------------------
-- Table structure for booksort
-- ----------------------------
DROP TABLE IF EXISTS `booksort`;
CREATE TABLE `booksort` (
  `sort_id` int(20) NOT NULL AUTO_INCREMENT,
  `sort_name` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  PRIMARY KEY (`sort_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of booksort
-- ----------------------------
INSERT INTO `booksort` VALUES ('1', '武侠');
INSERT INTO `booksort` VALUES ('2', '文学');
INSERT INTO `booksort` VALUES ('3', '历史');
INSERT INTO `booksort` VALUES ('4', '动漫');
INSERT INTO `booksort` VALUES ('5', '爱情');
INSERT INTO `booksort` VALUES ('6', '科学');
INSERT INTO `booksort` VALUES ('7', '计算机');

-- ----------------------------
-- Table structure for borrow_history
-- ----------------------------
DROP TABLE IF EXISTS `borrow_history`;
CREATE TABLE `borrow_history` (
  `user_id` int(20) DEFAULT NULL,
  `book_id` int(20) DEFAULT NULL,
  `borrow_date` datetime DEFAULT NULL,
  `return_date` datetime DEFAULT NULL,
  `isreturn` int(10) DEFAULT NULL,
  `history_id` int(10) NOT NULL AUTO_INCREMENT,
  `validity_date` int(20) DEFAULT NULL,
  PRIMARY KEY (`history_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of borrow_history
-- ----------------------------
INSERT INTO `borrow_history` VALUES ('1', '1', '2020-11-17 00:00:00', null, '0', '1', null);
INSERT INTO `borrow_history` VALUES ('2', '2', '2020-11-17 00:00:00', '2020-11-17 00:00:00', '1', '2', null);
INSERT INTO `borrow_history` VALUES ('1', '2', null, null, '1', '3', null);
INSERT INTO `borrow_history` VALUES ('3', '4', '2020-11-17 00:00:00', null, null, '4', null);
INSERT INTO `borrow_history` VALUES ('5', '5', '2020-11-19 09:01:36', '2020-11-19 09:17:03', '1', '5', null);
INSERT INTO `borrow_history` VALUES ('4', null, '2020-11-19 09:09:59', null, null, '6', null);
INSERT INTO `borrow_history` VALUES ('5', null, '2020-11-19 09:10:15', null, null, '7', null);
INSERT INTO `borrow_history` VALUES ('6', null, '2020-11-19 09:10:23', null, null, '8', null);
INSERT INTO `borrow_history` VALUES ('7', null, '2020-11-19 09:12:20', null, null, '9', null);
INSERT INTO `borrow_history` VALUES ('8', null, '2020-11-19 09:12:49', null, null, '10', null);
INSERT INTO `borrow_history` VALUES ('8', null, '2020-11-19 09:13:55', null, null, '11', null);
INSERT INTO `borrow_history` VALUES ('9', null, '2020-11-19 09:14:51', null, null, '12', null);
INSERT INTO `borrow_history` VALUES ('5', null, '2020-11-23 09:16:02', '2020-11-23 09:16:27', '1', '20', null);

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `notice_id` int(20) NOT NULL AUTO_INCREMENT,
  `notice_content` varchar(500) CHARACTER SET utf8mb4 DEFAULT NULL,
  `notice_createtime` datetime DEFAULT NULL,
  `user_id` int(20) DEFAULT NULL,
  PRIMARY KEY (`notice_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of notice
-- ----------------------------
INSERT INTO `notice` VALUES ('1', '借书不还，天族地灭', '2020-11-17 00:00:00', '8');
INSERT INTO `notice` VALUES ('2', '借书还不换，你是弟弟', '2020-11-17 00:00:00', '8');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(20) NOT NULL AUTO_INCREMENT,
  `user_age` int(10) DEFAULT NULL,
  `user_email` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `user_sex` varchar(10) CHARACTER SET utf8mb4 DEFAULT NULL,
  `user_name` varchar(20) CHARACTER SET utf8mb4 DEFAULT NULL,
  `user_phone` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `user_password` varchar(50) CHARACTER SET utf8mb4 DEFAULT NULL,
  `user_category` int(10) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=latin1;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '21', '13172256229@163.com', '男', '李宏裕', '15219567334', '123456', '0');
INSERT INTO `user` VALUES ('3', '22', '1610049531@qq.com', '男', '李康远', '1610049531', '123456', '0');
INSERT INTO `user` VALUES ('4', '22', '1264584869@qq.com', '男', '林杰烽', '1521956733', '123456', '0');
INSERT INTO `user` VALUES ('5', '22', '1425123770@qq.com', '男', '彭志权', '1425123770', '123456', '0');
INSERT INTO `user` VALUES ('6', '22', 'Wyulijunfei', '男', '李俊斐', '1231542134', '123456', '0');
INSERT INTO `user` VALUES ('7', '22', '2609484548@qq.com', '女', '张绮雯', '2609484548', '123456', '0');
INSERT INTO `user` VALUES ('8', '22', 'jeffrey-0@foxmail.com', '男', '李记峰', '213452134', '123456', '1');
INSERT INTO `user` VALUES ('9', '22', '502009541@qq.com', '女', 'adc', '21354213414', '123456', '0');
INSERT INTO `user` VALUES ('10', '22', '2508926778@qq.com', '男', '容泽军', '2508215441', '123456', '0');
INSERT INTO `user` VALUES ('11', null, null, null, '123', null, '81DC9BDB52D04DC20036DBD8313ED055', null);
INSERT INTO `user` VALUES ('12', '20', null, null, '测试', null, 'B5186FF6949B32ACD81D93940C142023', null);
