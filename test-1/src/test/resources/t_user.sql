/*
Navicat MySQL Data Transfer

Source Server         : 10.16.0.200-测试
Source Server Version : 50629
Source Host           : 10.16.0.200:3306
Source Database       : test1

Target Server Type    : MYSQL
Target Server Version : 50629
File Encoding         : 65001

Date: 2016-12-27 16:08:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `id` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
