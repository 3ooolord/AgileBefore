/*
 Navicat Premium Data Transfer

 Source Server         : 3306
 Source Server Type    : MySQL
 Source Server Version : 50525
 Source Host           : localhost:3306
 Source Schema         : test

 Target Server Type    : MySQL
 Target Server Version : 50525
 File Encoding         : 65001

 Date: 19/04/2021 00:12:14
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` varchar(10) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '1', '1', '1');

-- ----------------------------
-- Table structure for grade
-- ----------------------------
DROP TABLE IF EXISTS `grade`;
CREATE TABLE `grade`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `grade` int(11) DEFAULT NULL,
  `moudle_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `semester_year_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE,
  INDEX `moudle_id`(`moudle_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of grade
-- ----------------------------
INSERT INTO `grade` VALUES ('1', 50, '1', '1', '1');
INSERT INTO `grade` VALUES ('2', 60, '1', '1', '2');
INSERT INTO `grade` VALUES ('3', 60, '1', '1', '3');
INSERT INTO `grade` VALUES ('4', 60, '1', '1', '4');
INSERT INTO `grade` VALUES ('5', 50, '2', '1', '1');
INSERT INTO `grade` VALUES ('6', 0, '2', '1', '2');
INSERT INTO `grade` VALUES ('7', 65, '3', '1', '1');
INSERT INTO `grade` VALUES ('8', 90, '4', '1', '1');

-- ----------------------------
-- Table structure for lecturer
-- ----------------------------
DROP TABLE IF EXISTS `lecturer`;
CREATE TABLE `lecturer`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lecturer
-- ----------------------------
INSERT INTO `lecturer` VALUES ('1', '1', '1', '1');
INSERT INTO `lecturer` VALUES ('2', '2', '2', '2');
INSERT INTO `lecturer` VALUES ('3', '3', '3', '3');
INSERT INTO `lecturer` VALUES ('4', '4', '4', '4');
INSERT INTO `lecturer` VALUES ('5', '5', '5', '5');
INSERT INTO `lecturer` VALUES ('6', '6', '6', '6');

-- ----------------------------
-- Table structure for lecturer_moudle
-- ----------------------------
DROP TABLE IF EXISTS `lecturer_moudle`;
CREATE TABLE `lecturer_moudle`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `lecturer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `moudle_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `semester_year_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `moudle_id`(`moudle_id`) USING BTREE,
  INDEX `lecturer_id`(`lecturer_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of lecturer_moudle
-- ----------------------------
INSERT INTO `lecturer_moudle` VALUES (1, '1', '1', '1');
INSERT INTO `lecturer_moudle` VALUES (2, '2', '2', '1');
INSERT INTO `lecturer_moudle` VALUES (3, '3', '3', '1');
INSERT INTO `lecturer_moudle` VALUES (4, '4', '4', '1');
INSERT INTO `lecturer_moudle` VALUES (5, '5', '5', '2');
INSERT INTO `lecturer_moudle` VALUES (6, '6', '6', '2');

-- ----------------------------
-- Table structure for moudle
-- ----------------------------
DROP TABLE IF EXISTS `moudle`;
CREATE TABLE `moudle`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `moudle_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `moudle_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `semester_year_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `semester_year_id`(`semester_year_id`) USING BTREE,
  INDEX `moudle_id`(`moudle_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of moudle
-- ----------------------------
INSERT INTO `moudle` VALUES ('1', 'Database', '1', '1');
INSERT INTO `moudle` VALUES ('2', 'Module2', '2', '1');
INSERT INTO `moudle` VALUES ('3', 'RIA', '3', '1');
INSERT INTO `moudle` VALUES ('4', 'Module4', '4', '1');
INSERT INTO `moudle` VALUES ('5', 'CyberSecurity', '5', '2');
INSERT INTO `moudle` VALUES ('6', 'Module6', '6', '2');

-- ----------------------------
-- Table structure for name
-- ----------------------------
DROP TABLE IF EXISTS `name`;
CREATE TABLE `name`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `last_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Table structure for semester_year
-- ----------------------------
DROP TABLE IF EXISTS `semester_year`;
CREATE TABLE `semester_year`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `end_year` int(11) DEFAULT NULL,
  `semester` int(11) DEFAULT NULL,
  `start_year` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of semester_year
-- ----------------------------
INSERT INTO `semester_year` VALUES ('1', 2021, 1, 2020);
INSERT INTO `semester_year` VALUES ('2', 2021, 2, 2020);
INSERT INTO `semester_year` VALUES ('3', 2022, 1, 2021);
INSERT INTO `semester_year` VALUES ('4', 2022, 2, 2021);

-- ----------------------------
-- Table structure for semester_year_moudle
-- ----------------------------
DROP TABLE IF EXISTS `semester_year_moudle`;
CREATE TABLE `semester_year_moudle`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `moudle_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `semester_year_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `moudle_id`(`moudle_id`) USING BTREE,
  INDEX `semester_year_id`(`semester_year_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of semester_year_moudle
-- ----------------------------
INSERT INTO `semester_year_moudle` VALUES ('1', '1', '1');
INSERT INTO `semester_year_moudle` VALUES ('2', '2', '1');
INSERT INTO `semester_year_moudle` VALUES ('3', '3', '1');
INSERT INTO `semester_year_moudle` VALUES ('4', '4', '1');
INSERT INTO `semester_year_moudle` VALUES ('5', '5', '2');
INSERT INTO `semester_year_moudle` VALUES ('6', '6', '2');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', 's1', '1', '1');
INSERT INTO `student` VALUES ('2', 's2', '2', '2');
INSERT INTO `student` VALUES ('3', 's3', '3', '3');
INSERT INTO `student` VALUES ('4', 's4', '4', '4');
INSERT INTO `student` VALUES ('5', 's5', '5', '5');
INSERT INTO `student` VALUES ('6', 's6', '6', '6');

-- ----------------------------
-- Table structure for student_lecturer
-- ----------------------------
DROP TABLE IF EXISTS `student_lecturer`;
CREATE TABLE `student_lecturer`  (
  `id` int(255) NOT NULL AUTO_INCREMENT,
  `lecturer_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `student_id` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `lecturer_id`(`lecturer_id`) USING BTREE,
  INDEX `student_id`(`student_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 40 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Compact;

-- ----------------------------
-- Records of student_lecturer
-- ----------------------------
INSERT INTO `student_lecturer` VALUES (1, '1', '1');
INSERT INTO `student_lecturer` VALUES (2, '1', '2');
INSERT INTO `student_lecturer` VALUES (3, '1', '3');
INSERT INTO `student_lecturer` VALUES (4, '1', '4');
INSERT INTO `student_lecturer` VALUES (5, '2', '1');
INSERT INTO `student_lecturer` VALUES (6, '2', '2');
INSERT INTO `student_lecturer` VALUES (7, '3', '1');
INSERT INTO `student_lecturer` VALUES (8, '4', '1');

-- ----------------------------
-- Triggers structure for table moudle
-- ----------------------------
DROP TRIGGER IF EXISTS `ins_lm`;
delimiter ;;
CREATE DEFINER = `root`@`localhost` TRIGGER `ins_lm` AFTER INSERT ON `moudle` FOR EACH ROW insert into lecturer_moudle	( id,moudle_id)
        values( new.id, new.moudle_id)
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
