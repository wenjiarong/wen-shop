/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50556
Source Host           : localhost:3306
Source Database       : meite_member

Target Server Type    : MYSQL
Target Server Version : 50556
File Encoding         : 65001

Date: 2019-04-28 18:52:15
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for meite_user
-- ----------------------------
DROP TABLE IF EXISTS `meite_user`;
CREATE TABLE `meite_user` (
  `USER_ID` int(12) NOT NULL AUTO_INCREMENT COMMENT 'user_id',
  `MOBILE` varchar(11) NOT NULL COMMENT '手机号',
  `EMAIL` varchar(50) DEFAULT NULL COMMENT '邮箱号',
  `PASSWORD` varchar(64) NOT NULL COMMENT '密码',
  `USER_NAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  `SEX` tinyint(1) DEFAULT '0' COMMENT '性别  1男  2女',
  `AGE` tinyint(3) DEFAULT '0' COMMENT '年龄',
  `CREATE_TIME` timestamp NULL DEFAULT NULL COMMENT '注册时间',
  `IS_AVALIBLE` tinyint(1) DEFAULT '1' COMMENT '是否可用 1正常  2冻结',
  `PIC_IMG` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `QQ_OPENID` varchar(50) DEFAULT NULL COMMENT 'QQ联合登陆id',
  `WX_OPENID` varchar(50) DEFAULT NULL COMMENT '微信公众号关注id',
  PRIMARY KEY (`USER_ID`),
  UNIQUE KEY `MOBILE_UNIQUE` (`MOBILE`),
  UNIQUE KEY `EMAIL_UNIQUE` (`EMAIL`)
) ENGINE=InnoDB AUTO_INCREMENT=55 DEFAULT CHARSET=utf8 COMMENT='用户会员表';

-- ----------------------------
-- Records of meite_user
-- ----------------------------
INSERT INTO `meite_user` VALUES ('8', '15921009853', '644064779@qq.com', '123456', 'yushengjun644', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('13', '15921009854', '6440647791@qq.com', 'AAA42296669B958C3CEE6C0475C8093E', 'yushengjun6441', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('24', '15921009858', '6440647798@qq.com', 'AAA42296669B958C3CEE6C0475C8093E', 'yushengjun6441', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('25', '15921009859', '6440647710@qq.com', 'AAA42296669B958C3CEE6C0475C8093E', 'yushengjun6441', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('27', '15921009810', '6440647721@qq.com', 'AAA42296669B958C3CEE6C0475C8093E', 'yushengjun6441', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('28', '15921009861', '15921009861@qq.com', 'AAA42296669B958C3CEE6C0475C8093E', '15921009861', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('31', '15921009862', '15921009862@qq.com', '6978915EE7DBC5AFF1BC34B59E8C0FC5', '15921009863', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('34', '15921009865', '15921009865@qq.com', '6978915EE7DBC5AFF1BC34B59E8C0FC5', '15921009865', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('35', '15921009866', '15921009866@qq.com', '6978915EE7DBC5AFF1BC34B59E8C0FC5', '15921009866', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('47', '15921009867', '15921009867@qq.com', '649DB3B84CA99497AD666F8EE6BCAD2C', '15921009867', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('48', '15527339672', '15527339672@qq.com', '8C5E7BAEDCA727C45DCF240D530BFCD7', '15527339672', null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('50', '18215344111', null, 'E10ADC3949BA59ABBE56E057F20F883E', null, null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('51', '18215344112', null, 'E10ADC3949BA59ABBE56E057F20F883E', null, null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('52', '15921009245', null, 'E10ADC3949BA59ABBE56E057F20F883E', 'yushengjun', null, null, null, '1', null, '4130A96EDE4187C8FD6BB055CC542B40', null);
INSERT INTO `meite_user` VALUES ('53', '15921009258', null, 'E10ADC3949BA59ABBE56E057F20F883E', null, null, null, null, '1', null, null, null);
INSERT INTO `meite_user` VALUES ('54', '15921009259', null, 'E10ADC3949BA59ABBE56E057F20F883E', null, null, null, null, '1', null, null, null);

-- ----------------------------
-- Table structure for meite_user_token
-- ----------------------------
DROP TABLE IF EXISTS `meite_user_token`;
CREATE TABLE `meite_user_token` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `login_type` varchar(255) DEFAULT NULL,
  `device_infor` varchar(255) DEFAULT NULL,
  `is_availability` int(2) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=118 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of meite_user_token
-- ----------------------------
INSERT INTO `meite_user_token` VALUES ('91', 'mt.mb.loginAndroiddccc3c55724c4bb3b060cec5df3a87bc', 'Android', '苹果手机7', '1', '48', '2019-01-24 21:24:25', '2019-01-24 21:26:39');
INSERT INTO `meite_user_token` VALUES ('92', 'mt.mb.loginAndroid8735ce40754d41e5b4f93d52b338f178', 'Android', '苹果手机7', '0', '48', '2019-01-24 21:27:13', null);
INSERT INTO `meite_user_token` VALUES ('93', 'mt.mb.loginPC94f1f6bceee24c7184a58818fb540fbc', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 15:51:37', '2019-01-26 15:51:51');
INSERT INTO `meite_user_token` VALUES ('94', 'mt.mb.loginPC5ecb952674ba4b0ab5e1e3d13bbb9613', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 15:51:51', '2019-01-26 15:53:39');
INSERT INTO `meite_user_token` VALUES ('95', 'mt.mb.loginPC6dbb6df67d6244f99209a6911df19bb4', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 15:53:39', '2019-01-26 15:54:02');
INSERT INTO `meite_user_token` VALUES ('96', 'mt.mb.loginPC1fd1cf11f06a444697c1702982c19d51', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 15:54:02', '2019-01-26 15:58:42');
INSERT INTO `meite_user_token` VALUES ('97', 'mt.mb.loginPCcd4d1ca6739c4df4859fef8a45e0e70f', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 15:58:42', '2019-01-26 16:15:28');
INSERT INTO `meite_user_token` VALUES ('98', 'mt.mb.loginPC9ef724d7885f4b39844718cf219b5a68', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 16:15:28', '2019-01-26 16:17:06');
INSERT INTO `meite_user_token` VALUES ('99', 'mt.mb.loginPCa342faefaa4c445ca39cb1fb6fe3a8cc', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 16:17:06', '2019-01-26 16:22:29');
INSERT INTO `meite_user_token` VALUES ('100', 'mt.mb.loginPC1fe9f775a2134aa29578f9451175b17a', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 16:22:29', '2019-01-26 16:42:12');
INSERT INTO `meite_user_token` VALUES ('101', 'mt.mb.loginPCb3d7056d6e434c8f8e78a086887d94e9', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 16:42:12', '2019-01-26 16:45:38');
INSERT INTO `meite_user_token` VALUES ('102', 'mt.mb.loginPCc6e2f247d498466f8ca07a59006ce821', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 16:45:38', '2019-01-26 17:08:14');
INSERT INTO `meite_user_token` VALUES ('103', 'mt.mb.loginPC89e387759f694a18aa22138f3f4c123c', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 17:08:14', '2019-01-26 22:12:35');
INSERT INTO `meite_user_token` VALUES ('104', 'mt.mb.loginPC1652c3894d5e4b1e989f5701e4f3e7e4', 'PC', 'Chrome/71.0.3578.98', '1', '53', '2019-01-26 19:43:01', '2019-01-26 19:43:25');
INSERT INTO `meite_user_token` VALUES ('105', 'mt.mb.loginPCebc4e61e250242a099e94f139b74a386', 'PC', 'Chrome/71.0.3578.98', '0', '53', '2019-01-26 19:43:25', null);
INSERT INTO `meite_user_token` VALUES ('106', 'mt.mb.loginPC3ec0b3a5a9b04922a9efc383ae05a294', 'PC', 'Chrome/71.0.3578.98', '1', '54', '2019-01-26 20:36:16', '2019-02-14 14:02:40');
INSERT INTO `meite_user_token` VALUES ('107', 'mt.mb.loginPC9b9eafb0fd8d48ab920ed8e49588dfdb', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 22:12:35', '2019-01-26 22:12:42');
INSERT INTO `meite_user_token` VALUES ('108', 'mt.mb.loginPCe4be570ebee7477e8370d983a3705aa8', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 22:12:42', '2019-01-26 22:17:20');
INSERT INTO `meite_user_token` VALUES ('109', 'mt.mb.loginPC4e6768e02cc94e71a31a2ab00e52d7ce', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-01-26 22:17:20', '2019-02-14 18:00:22');
INSERT INTO `meite_user_token` VALUES ('110', 'mt.mb.loginPC6865ec79805e46a78582f7c514db6603', 'PC', 'Chrome/71.0.3578.98', '1', '54', '2019-02-14 14:02:40', '2019-02-14 14:03:05');
INSERT INTO `meite_user_token` VALUES ('111', 'mt.mb.loginPCa4a387cd6fb44e7ea4d734e0e8111ee9', 'PC', 'Chrome/71.0.3578.98', '0', '54', '2019-02-14 14:03:05', null);
INSERT INTO `meite_user_token` VALUES ('112', 'mt.mb.loginPC1a77b54d339840779c5867bcc1df5929', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-02-14 18:00:22', '2019-02-14 18:07:21');
INSERT INTO `meite_user_token` VALUES ('113', 'mt.mb.loginPC04db98c17b4d44f7afc1cd92b69a5695', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-02-14 18:07:21', '2019-02-14 18:16:10');
INSERT INTO `meite_user_token` VALUES ('114', 'mt.mb.loginPC0171882418194923b9e413567fc5f7a7', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-02-14 18:16:10', '2019-02-14 18:29:57');
INSERT INTO `meite_user_token` VALUES ('115', 'mt.mb.loginPC805a4951cbf3470d91702b75777509f5', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-02-14 18:29:57', '2019-02-14 20:38:01');
INSERT INTO `meite_user_token` VALUES ('116', 'mt.mb.loginPC8c783d8e4ced471e8f8037e181b4bfee', 'PC', 'Chrome/71.0.3578.98', '1', '52', '2019-02-14 20:38:01', '2019-02-14 22:09:06');
INSERT INTO `meite_user_token` VALUES ('117', 'mt.mb.loginPCbe573990e8974d76831dbe04f2d2273e', 'PC', 'Chrome/71.0.3578.98', '0', '52', '2019-02-14 22:09:06', null);
