/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.88.100
 Source Server Type    : MySQL
 Source Server Version : 80020 (8.0.20)
 Source Host           : 192.168.88.100:3306
 Source Schema         : demo_db

 Target Server Type    : MySQL
 Target Server Version : 80020 (8.0.20)
 File Encoding         : 65001

 Date: 14/03/2024 09:29:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for app_user
-- ----------------------------
DROP TABLE IF EXISTS `app_user`;
CREATE TABLE `app_user`
(
    `id`                int                                                           NOT NULL AUTO_INCREMENT COMMENT '用户ID，主键',
    `username`          varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NOT NULL COMMENT '用户名，不允许为空',
    `password`          varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码，不允许为空',
    `email`             varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '邮箱，不允许为空',
    `phone`             varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '手机号码',
    `name`              varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci  NULL DEFAULT NULL COMMENT '姓名',
    `gender`            tinyint(1)                                                    NULL DEFAULT 0 COMMENT '性别，0表示未知，1表示男性，2表示女性',
    `birthday`          date                                                          NULL DEFAULT NULL COMMENT '出生日期',
    `registration_time` timestamp                                                     NULL DEFAULT CURRENT_TIMESTAMP COMMENT '注册时间，默认为当前时间',
    `last_login_time`   timestamp                                                     NULL DEFAULT NULL COMMENT '最后登录时间',
    `status`            tinyint(1)                                                    NULL DEFAULT 1 COMMENT '用户状态，0表示禁用，1表示启用，2表示已删除',
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  AUTO_INCREMENT = 678001
  CHARACTER SET = utf8mb4
  COLLATE = utf8mb4_0900_ai_ci
  ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
