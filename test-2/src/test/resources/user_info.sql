/*
Navicat MySQL Data Transfer

Source Server         : 10.16.0.200-测试
Source Server Version : 50629
Source Host           : 10.16.0.200:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-12-27 16:14:10
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS `user_info`;
CREATE TABLE `user_info` (
  `id` varchar(255) DEFAULT NULL,
  `info` varchar(255) DEFAULT NULL,
  `user_id` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
