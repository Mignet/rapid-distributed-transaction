/*
Navicat PGSQL Data Transfer

Source Server         : 本机
Source Server Version : 90400
Source Host           : localhost:5432
Source Database       : test2
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90400
File Encoding         : 65001

Date: 2016-03-17 17:38:24
*/


-- ----------------------------
-- Table structure for user_info
-- ----------------------------
DROP TABLE IF EXISTS "public"."user_info";
CREATE TABLE "public"."user_info" (
"id" varchar(255) COLLATE "default",
"info" varchar(255) COLLATE "default",
"user_id" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of user_info
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
