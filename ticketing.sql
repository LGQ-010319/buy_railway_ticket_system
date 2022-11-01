/*
Navicat MySQL Data Transfer

Source Server         : root1
Source Server Version : 80026
Source Host           : localhost:3306
Source Database       : ticketing

Target Server Type    : MYSQL
Target Server Version : 80026
File Encoding         : 65001

Date: 2022-06-08 16:01:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admins`
-- ----------------------------
DROP TABLE IF EXISTS `admins`;
CREATE TABLE `admins` (
  `adminid` int NOT NULL AUTO_INCREMENT COMMENT '管理员ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员姓名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '管理员密码',
  `creattime` datetime NOT NULL COMMENT '鍒涘缓鏃堕棿',
  `flag` int NOT NULL COMMENT '管理员权限',
  `isuse` int NOT NULL COMMENT '管理员状态',
  `logintime` datetime NOT NULL COMMENT '鐧诲綍鏃堕棿',
  PRIMARY KEY (`adminid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of admins
-- ----------------------------
INSERT INTO `admins` VALUES ('1', 'root', '123456', '2022-06-02 07:40:41', '1', '1', '2022-06-02 07:47:46');
INSERT INTO `admins` VALUES ('2', 'admin', 'admin', '2022-06-02 21:43:20', '1', '1', '2022-06-08 06:50:15');
INSERT INTO `admins` VALUES ('3', 'ljy', '123456', '2022-06-02 21:43:47', '1', '0', '2022-06-02 21:43:47');
INSERT INTO `admins` VALUES ('4', 'testadmin', '123456', '2022-06-02 21:44:07', '1', '0', '2022-06-02 21:44:07');
INSERT INTO `admins` VALUES ('5', 'admin2', 'admin2', '2022-06-02 12:34:09', '1', '0', '2022-06-02 12:34:09');

-- ----------------------------
-- Table structure for `member`
-- ----------------------------
DROP TABLE IF EXISTS `member`;
CREATE TABLE `member` (
  `memberid` int NOT NULL AUTO_INCREMENT COMMENT '会员ID',
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会员姓名',
  `password` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会员密码',
  `registertime` datetime NOT NULL COMMENT '娉ㄥ唽鏃堕棿',
  `ifuse` int NOT NULL COMMENT '会员状态',
  `logintimes` datetime NOT NULL COMMENT '鐧诲綍鏃堕棿',
  PRIMARY KEY (`memberid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of member
-- ----------------------------
INSERT INTO `member` VALUES ('2', 'user2', 'user2', '2022-06-02 13:06:06', '1', '2022-06-04 13:45:50');
INSERT INTO `member` VALUES ('19', 'user19', 'user19', '2022-06-01 21:45:16', '1', '2022-06-02 13:28:40');
INSERT INTO `member` VALUES ('21', 'user1', 'user1', '2022-06-04 13:53:11', '1', '2022-06-08 06:52:04');

-- ----------------------------
-- Table structure for `pmember`
-- ----------------------------
DROP TABLE IF EXISTS `pmember`;
CREATE TABLE `pmember` (
  `pmemberid` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `memberid` int NOT NULL COMMENT '会员ID',
  `realname` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '真实姓名',
  `sex` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '会员性别',
  `age` int NOT NULL COMMENT '会员年龄',
  `idcard` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '身份证号',
  PRIMARY KEY (`pmemberid`) USING BTREE,
  KEY `mid` (`memberid`) USING BTREE,
  CONSTRAINT `pmember_ibfk_1` FOREIGN KEY (`memberid`) REFERENCES `member` (`memberid`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of pmember
-- ----------------------------
INSERT INTO `pmember` VALUES ('2', '2', '杜甫', '男', '19', '360732200203122222');
INSERT INTO `pmember` VALUES ('19', '19', '李白', '男', '18', '360412199904062105');
INSERT INTO `pmember` VALUES ('20', '21', '王维', '男', '22', '320374488485932270');

-- ----------------------------
-- Table structure for `prep`
-- ----------------------------
DROP TABLE IF EXISTS `prep`;
CREATE TABLE `prep` (
  `prepid` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `trainid` int NOT NULL COMMENT '车次id',
  `pmemberid` int NOT NULL COMMENT '会员信息ID',
  `startstation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '起始站',
  `endstation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '终点站',
  `trainnumber` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '火车车次',
  `starttime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '寮€杞︽椂闂?',
  `endtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '鍒扮珯鏃堕棿',
  `price` int NOT NULL COMMENT '车票价格',
  `way` bit(1) NOT NULL DEFAULT b'0' COMMENT '付款情况',
  `booktime` datetime NOT NULL COMMENT '订票时间',
  PRIMARY KEY (`prepid`) USING BTREE,
  KEY `trainid` (`trainid`) USING BTREE,
  KEY `pmemberid` (`pmemberid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=136 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of prep
-- ----------------------------
INSERT INTO `prep` VALUES ('131', '1', '2', '南昌', '九江', 'T23', '2022-06-02 10:12:00', '2022-06-02 13:12:00', '100', '', '2022-06-04 06:53:46');
INSERT INTO `prep` VALUES ('132', '2', '20', '九江', '北京', 'K10086', '2022-06-03 20:11:11', '2022-06-04 05:11:11', '99', '', '2022-06-04 14:20:15');
INSERT INTO `prep` VALUES ('133', '1', '2', '南昌', '九江', 'T23', '2022-06-02 10:12:00', '2022-06-02 13:12:00', '100', '', '2022-06-05 03:12:43');
INSERT INTO `prep` VALUES ('134', '1', '2', '南昌', '九江', 'T23', '2022-06-02 10:12:00', '2022-06-02 13:12:00', '100', '', '2022-06-05 03:14:41');
INSERT INTO `prep` VALUES ('135', '2', '2', '九江', '北京', 'K10086', '2022-06-03 20:11:11', '2022-06-04 05:11:11', '99', '', '2022-06-06 07:56:33');

-- ----------------------------
-- Table structure for `train`
-- ----------------------------
DROP TABLE IF EXISTS `train`;
CREATE TABLE `train` (
  `trainid` int NOT NULL AUTO_INCREMENT COMMENT '序号',
  `trainnumber` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '车次',
  `startstation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '起始站',
  `endstation` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '终点站',
  `starttime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '瀵偓鏉烇附妞傞梻?',
  `endtime` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '閸掓壆鐝弮鍫曟？',
  `price` int NOT NULL COMMENT '车票价格',
  `seatnumber` int NOT NULL COMMENT '座位数量',
  `addtime` datetime NOT NULL COMMENT '娣诲姞鏃ユ湡',
  PRIMARY KEY (`trainid`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=339 DEFAULT CHARSET=utf8mb3 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of train
-- ----------------------------
INSERT INTO `train` VALUES ('1', 'T23', '南昌', '九江', '2022-06-02 10:12:00', '2022-06-02 13:12:00', '100', '89', '2022-06-02 00:03:03');
INSERT INTO `train` VALUES ('2', 'K10086', '九江', '北京', '2022-06-03 20:11:11', '2022-06-04 05:11:11', '99', '98', '2022-06-02 00:04:20');
INSERT INTO `train` VALUES ('3', 'K33', '上海', '北京', '2022-06-07 10:22:22', '2022-06-08', '66', '100', '2022-06-04 00:00:00');
INSERT INTO `train` VALUES ('335', 'K520', '九江', '拉萨', '2022-06-05 16:41:00', '2022-06-08 17:41:00', '520', '520', '2022-06-05 08:42:12');
INSERT INTO `train` VALUES ('336', 'K1314', '深圳', '九江', '2022-06-05 16:43:00', '2022-06-06 16:43:00', '120', '100', '2022-06-05 08:43:22');
INSERT INTO `train` VALUES ('337', 'K666', '九江', '赣州', '2022-06-13 16:44:00', '2022-06-14 16:44:00', '66', '99', '2022-06-05 08:44:30');
INSERT INTO `train` VALUES ('338', 'K1314', '深圳', '赣州', '2022-06-11 16:44:00', '2022-06-12 16:44:00', '120', '100', '2022-06-05 08:45:00');
