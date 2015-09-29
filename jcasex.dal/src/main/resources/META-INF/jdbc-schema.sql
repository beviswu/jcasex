/*
Navicat MySQL Data Transfer

Source Server         : dev-mysql
Source Server Version : 50531
Source Host           : localhost:3306
Source Database       : casex

Target Server Type    : MYSQL
Target Server Version : 50531
File Encoding         : 65001

Date: 2013-07-21 23:54:31
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for casex_user
-- ----------------------------
DROP TABLE IF EXISTS `casex_user`;
CREATE TABLE `casex_user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(128) NOT NULL,
  `password` varchar(128) NOT NULL,
  `delete_date` datetime DEFAULT NULL COMMENT '删除时间',
  `creator` varchar(128) NOT NULL,
  `gmt_created` datetime NOT NULL,
  `modifier` varchar(128) DEFAULT NULL,
  `gmt_mofified` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `casex_user__idx_uk` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
