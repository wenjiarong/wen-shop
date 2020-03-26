/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : meite_gateway

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2019-04-28 18:51:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for gateway_handler
-- ----------------------------
DROP TABLE IF EXISTS `gateway_handler`;
CREATE TABLE `gateway_handler` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `handler_name` varchar(32) DEFAULT NULL COMMENT 'handler名称',
  `handler_id` varchar(32) DEFAULT NULL COMMENT 'handler主键id',
  `prev_handler_id` varchar(32) DEFAULT NULL,
  `next_handler_id` varchar(32) DEFAULT NULL COMMENT '下一个handler',
  `is_open` int(11) DEFAULT '1' COMMENT '是否打开',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COMMENT='权限表';

-- ----------------------------
-- Records of gateway_handler
-- ----------------------------
INSERT INTO `gateway_handler` VALUES ('12', '黑名单拦截', 'blacklistHandler', 'currentLimitHandler', 'toVerifyMapHandler', '1', null, null, null, null, null);
INSERT INTO `gateway_handler` VALUES ('13', 'API接口参数验证签名', 'toVerifyMapHandler', 'blacklistHandler', 'apiAuthorityHandler', '1', null, null, null, null, null);
INSERT INTO `gateway_handler` VALUES ('14', 'API接口验证Token', 'apiAuthorityHandler', 'toVerifyMapHandler', null, '1', null, null, null, null, null);
INSERT INTO `gateway_handler` VALUES ('15', 'API接口实现限流', 'currentLimitHandler', null, 'blacklistHandler', '1', null, null, null, null, null);

-- ----------------------------
-- Table structure for meite_app_info
-- ----------------------------
DROP TABLE IF EXISTS `meite_app_info`;
CREATE TABLE `meite_app_info` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `app_name` varchar(108) DEFAULT NULL COMMENT '应用名称',
  `app_id` varchar(128) DEFAULT NULL COMMENT '应用id',
  `app_secret` varchar(32) DEFAULT NULL COMMENT '应用密钥',
  `availability` varchar(128) DEFAULT NULL COMMENT '是否可用',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COMMENT='应用机构表';

-- ----------------------------
-- Records of meite_app_info
-- ----------------------------
INSERT INTO `meite_app_info` VALUES ('6', '蚂蚁课堂', '111', '222', '0', null, null, null, null, null);
INSERT INTO `meite_app_info` VALUES ('7', '621a6ab1-f696-4e92-bdc5-90b325d1c323', '每特教育', '298319481BA5D881415C2088FB66BD37', '0', null, null, null, null, null);
INSERT INTO `meite_app_info` VALUES ('8', '每特教育', 'af9ea873-c174-40ab-81ff-4a04c04b4077', '47757DB0BED', '0', null, null, null, null, null);
INSERT INTO `meite_app_info` VALUES ('9', '每特教育', '0525dac1-ecef-4ecb-a251-9a11bb6264af', '74B12C257E8DEC5805DAA96AD6D902F4', '0', null, null, null, null, null);
INSERT INTO `meite_app_info` VALUES ('10', '每特教育集团', 'c49ba111-1fa9-46f1-b8d1-8759f1da2db0', '7F9F229DCD9FF75AE407684AFB437047', '0', null, null, null, null, null);
INSERT INTO `meite_app_info` VALUES ('11', '蚂蚁课堂集团', 'b56989c0-128e-48b1-8e75-f61dd47621cf', 'FDB1CF42D6F8D6A18C7E72D229E13BF7', '0', null, null, null, null, null);

-- ----------------------------
-- Table structure for meite_blacklist
-- ----------------------------
DROP TABLE IF EXISTS `meite_blacklist`;
CREATE TABLE `meite_blacklist` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键ID',
  `ip_addres` varchar(128) DEFAULT NULL COMMENT 'ip地址',
  `restriction_type` int(11) DEFAULT NULL COMMENT '限制类型',
  `availability` int(11) DEFAULT '1' COMMENT '是否可用',
  `REVISION` int(11) DEFAULT NULL COMMENT '乐观锁',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1 COMMENT=' ';

-- ----------------------------
-- Records of meite_blacklist
-- ----------------------------
INSERT INTO `meite_blacklist` VALUES ('1', '127.0.0.1', '0', '1', null, null, null, null, null);
