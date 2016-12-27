/*
Navicat MySQL Data Transfer

Source Server         : 10.16.0.200-测试
Source Server Version : 50629
Source Host           : 10.16.0.200:3306
Source Database       : testmain

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-12-27 16:17:05
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_ticket
-- ----------------------------
DROP TABLE IF EXISTS `t_ticket`;
CREATE TABLE `t_ticket` (
  `id` varchar(100) DEFAULT NULL,
  `create_time` timestamp(6) NULL DEFAULT NULL,
  `user_id` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_ticket
-- ----------------------------
