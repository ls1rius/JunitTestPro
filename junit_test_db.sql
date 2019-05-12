/*
 Navicat Premium Data Transfer

 Source Server         : root
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : junit_test_db

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 12/05/2019 18:17:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `owner_id` bigint(11) NOT NULL,
  `product_id` bigint(11) NOT NULL,
  `product_count` int(11) NOT NULL,
  `finish_user_id` bigint(11) NOT NULL DEFAULT '-1',
  `is_finished` tinyint(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------
BEGIN;
INSERT INTO `order` VALUES (1, 1, 1, 3, 11, 1);
INSERT INTO `order` VALUES (2, 1, 1, 3, -1, 0);
INSERT INTO `order` VALUES (3, 1, 3, 1, -1, 0);
INSERT INTO `order` VALUES (4, 1, 1, 123, -1, 0);
INSERT INTO `order` VALUES (5, 1, 2, 999, -1, 0);
INSERT INTO `order` VALUES (6, 1, 4, 456, -1, 0);
INSERT INTO `order` VALUES (7, 1, 2, 222, -1, 0);
INSERT INTO `order` VALUES (8, 1, 2, 123, -1, 0);
INSERT INTO `order` VALUES (9, 1, 2, 123, -1, 0);
INSERT INTO `order` VALUES (10, 1, 5, 123, -1, 0);
INSERT INTO `order` VALUES (11, 1, 2, 567, 1, 1);
INSERT INTO `order` VALUES (12, 1, 2, 777, -1, 0);
INSERT INTO `order` VALUES (13, 1, 3, 555, 1, 1);
INSERT INTO `order` VALUES (14, 1, 1, 66, 1, 1);
INSERT INTO `order` VALUES (15, 1, 1, 66, -1, 0);
INSERT INTO `order` VALUES (16, 1, 1, 66, 1, 1);
INSERT INTO `order` VALUES (17, 1, 1, 66, -1, 0);
INSERT INTO `order` VALUES (18, 1, 1, 66, 1, 1);
INSERT INTO `order` VALUES (19, 1, 1, 66, -1, 0);
INSERT INTO `order` VALUES (20, 1, 1, 66, -1, 0);
INSERT INTO `order` VALUES (21, 1, 3, 3, 1, 1);
COMMIT;

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `product_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
BEGIN;
INSERT INTO `product` VALUES (1, '包子');
INSERT INTO `product` VALUES (2, '馒头');
INSERT INTO `product` VALUES (3, '油条');
INSERT INTO `product` VALUES (4, '小笼包');
INSERT INTO `product` VALUES (5, '豆浆');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=COMPACT;

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'root', '123456');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
