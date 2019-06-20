/*
 Navicat Premium Data Transfer

 Source Server         : mysql2
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : 192.168.9.130:3307
 Source Schema         : library-management-system

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 23/05/2019 15:24:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book_admin
-- ----------------------------
DROP TABLE IF EXISTS `book_admin`;
CREATE TABLE `book_admin`  (
  `admin_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT,
  `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '图书管理员名称',
  `admin_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_admin
-- ----------------------------
INSERT INTO `book_admin` VALUES (1, '倪超', '123', '15589766932', '987@qq.com');

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info`  (
  `book_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `book_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `author` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `translater` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `price` float(10, 2) NOT NULL,
  `ISBN` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `come_up_time` datetime(0) NOT NULL COMMENT '出版日期',
  `publish_company` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `state` int(255) NOT NULL COMMENT '借出0, 在库1',
  `entering_man_id` int(20) UNSIGNED NOT NULL COMMENT '入库者 id',
  `entering_date` datetime(0) NOT NULL COMMENT '入库日期',
  PRIMARY KEY (`book_id`) USING BTREE,
  INDEX `entering_man_id`(`entering_man_id`) USING BTREE,
  CONSTRAINT `entering_man_id` FOREIGN KEY (`entering_man_id`) REFERENCES `book_admin` (`admin_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES (1, '狂人日记', '鲁迅', NULL, 69.36, '978-7-121-2496-9', '2019-01-23 15:20:47', '电子工业出版社', 1, 1, '2019-05-23 15:20:18');

-- ----------------------------
-- Table structure for borrow_record
-- ----------------------------
DROP TABLE IF EXISTS `borrow_record`;
CREATE TABLE `borrow_record`  (
  `user_id` int(10) UNSIGNED NOT NULL,
  `book_id` int(10) UNSIGNED NOT NULL,
  `borrow_time` datetime(0) NOT NULL,
  `should_time` datetime(0) NOT NULL COMMENT '预计还书时间',
  `return_time` datetime(0) NULL DEFAULT NULL COMMENT '实际还书时间',
  PRIMARY KEY (`user_id`, `book_id`) USING BTREE,
  INDEX `book_id`(`book_id`) USING BTREE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE RESTRICT ON UPDATE CASCADE,
  CONSTRAINT `book_id` FOREIGN KEY (`book_id`) REFERENCES `book_info` (`book_id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for system_admin
-- ----------------------------
DROP TABLE IF EXISTS `system_admin`;
CREATE TABLE `system_admin`  (
  `admin_id` int(20) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '系统管理员id',
  `admin_name` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `admin_email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`admin_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of system_admin
-- ----------------------------
INSERT INTO `system_admin` VALUES (1, '张淳嫔', '123', '13836958796', '568@qq.com');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `user_id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户ID（学号）',
  `user_number` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '学号',
  `username` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `pwd` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `department` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '院',
  `major` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '专业',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `email` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `max` int(255) NOT NULL COMMENT '最大可借数量',
  `time` int(11) NOT NULL COMMENT '可借天数',
  `borrowing_num` int(11) NOT NULL COMMENT '在借数量',
  PRIMARY KEY (`user_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, '11603990110', 'lei', '122', '计算机科学与工程', '计算机科学与技术', '15503060258', '12345@qq.com', 10, 10, 1);

SET FOREIGN_KEY_CHECKS = 1;
