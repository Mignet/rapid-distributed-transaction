/*
Navicat PGSQL Data Transfer

Source Server         : 本机
Source Server Version : 90400
Source Host           : localhost:5432
Source Database       : test1
Source Schema         : public

Target Server Type    : PGSQL
Target Server Version : 90400
File Encoding         : 65001

Date: 2016-03-17 17:38:04
*/


-- ----------------------------
-- Table structure for t_ticket
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_ticket";
CREATE TABLE "public"."t_ticket" (
"id" varchar(100) COLLATE "default",
"create_time" timestamp(6),
"user_id" varchar(100) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_ticket
-- ----------------------------

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS "public"."t_user";
CREATE TABLE "public"."t_user" (
"id" varchar(255) COLLATE "default",
"username" varchar(255) COLLATE "default"
)
WITH (OIDS=FALSE)

;

-- ----------------------------
-- Records of t_user
-- ----------------------------

-- ----------------------------
-- Alter Sequences Owned By 
-- ----------------------------
