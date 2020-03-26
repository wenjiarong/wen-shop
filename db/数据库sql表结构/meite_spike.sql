/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : meite_spike

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2019-04-28 18:52:27
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for meite_order
-- ----------------------------
DROP TABLE IF EXISTS `meite_order`;
CREATE TABLE `meite_order` (
  `seckill_id` bigint(20) NOT NULL COMMENT '秒杀商品id',
  `user_phone` bigint(20) NOT NULL COMMENT '用户手机号',
  `state` tinyint(4) NOT NULL DEFAULT '-1' COMMENT '状态标示:-1:无效 0:成功 1:已付款 2:已发货',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  KEY `idx_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='秒杀成功明细表';

-- ----------------------------
-- Records of meite_order
-- ----------------------------
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:33');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:34');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:34');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:34');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:34');
INSERT INTO `meite_order` VALUES ('10001', '15921009248', '1', '2019-04-21 21:30:34');

-- ----------------------------
-- Table structure for meite_seckill
-- ----------------------------
DROP TABLE IF EXISTS `meite_seckill`;
CREATE TABLE `meite_seckill` (
  `seckill_id` bigint(20) NOT NULL COMMENT '商品库存id',
  `name` varchar(120) CHARACTER SET utf8 NOT NULL COMMENT '商品名称',
  `inventory` int(11) NOT NULL COMMENT '库存数量',
  `start_time` datetime NOT NULL COMMENT '秒杀开启时间',
  `end_time` datetime NOT NULL COMMENT '秒杀结束时间',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `version` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`seckill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='秒杀库存表';

-- ----------------------------
-- Records of meite_seckill
-- ----------------------------
INSERT INTO `meite_seckill` VALUES ('10001', '苹果7P手机', '0', '2019-04-17 14:18:10', '2020-12-20 00:00:00', '2019-04-18 15:31:43', '101');
INSERT INTO `meite_seckill` VALUES ('10002', '苹果7X手机', '100', '2019-04-17 14:18:10', '2020-12-20 00:00:00', '2019-04-18 15:31:43', '11');
INSERT INTO `meite_seckill` VALUES ('10003', '每特第五期课程', '100', '2019-04-17 14:18:10', '2020-12-20 00:00:00', '2019-04-18 15:31:43', '11');
