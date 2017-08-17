/*
Navicat MySQL Data Transfer

Source Server         : zjwlgr
Source Server Version : 50615
Source Host           : 123.57.233.23:3306
Source Database       : springboot

Target Server Type    : MYSQL
Target Server Version : 50615
File Encoding         : 65001

Date: 2017-08-17 16:48:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for fo_class
-- ----------------------------
DROP TABLE IF EXISTS `fo_class`;
CREATE TABLE `fo_class` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `fid` int(11) NOT NULL DEFAULT '0',
  `nexus` varchar(2048) DEFAULT NULL COMMENT '关系ID',
  `depth` int(11) NOT NULL DEFAULT '0' COMMENT '深度',
  `name` varchar(64) DEFAULT NULL,
  `sort` int(10) NOT NULL DEFAULT '0',
  `ctime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=208 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fo_class
-- ----------------------------
INSERT INTO `fo_class` VALUES ('140', '135', '135,', '2', 'Style', '2', null);
INSERT INTO `fo_class` VALUES ('141', '135', '135,', '2', 'Javascript', '3', null);
INSERT INTO `fo_class` VALUES ('165', '164', '135,164,', '3', 'Java', '0', null);
INSERT INTO `fo_class` VALUES ('164', '135', '135,', '2', 'Java', '0', null);
INSERT INTO `fo_class` VALUES ('163', '160', '135,160,', '3', 'Swift+IOS', '0', null);
INSERT INTO `fo_class` VALUES ('144', '136', '135,136,', '3', 'Nginx', '0', null);
INSERT INTO `fo_class` VALUES ('145', '136', '135,136,', '3', 'Apache', '0', null);
INSERT INTO `fo_class` VALUES ('135', '0', '', '1', '技术文章分类', '0', null);
INSERT INTO `fo_class` VALUES ('162', '136', '135,136,', '3', 'Sphinx', '0', null);
INSERT INTO `fo_class` VALUES ('161', '160', '135,160,', '3', 'CourseRecord', '0', null);
INSERT INTO `fo_class` VALUES ('160', '135', '135,', '2', 'Swift', '0', null);
INSERT INTO `fo_class` VALUES ('155', '137', '135,137,', '3', 'Mongodb', '0', null);
INSERT INTO `fo_class` VALUES ('156', '141', '135,141,', '3', 'JS', '0', null);
INSERT INTO `fo_class` VALUES ('157', '136', '135,136,', '3', 'Command', '0', null);
INSERT INTO `fo_class` VALUES ('158', '139', '135,139,', '3', 'PHPcode', '0', null);
INSERT INTO `fo_class` VALUES ('159', '136', '135,136,', '3', 'Memcached', '0', null);
INSERT INTO `fo_class` VALUES ('139', '135', '135,', '2', 'PHP', '4', null);
INSERT INTO `fo_class` VALUES ('137', '135', '135,', '2', 'Database', '5', null);
INSERT INTO `fo_class` VALUES ('136', '135', '135,', '2', 'Linux', '6', null);
INSERT INTO `fo_class` VALUES ('154', '137', '135,137,', '3', 'Redis', '0', null);
INSERT INTO `fo_class` VALUES ('153', '136', '135,136,', '3', 'GIT', '0', null);
INSERT INTO `fo_class` VALUES ('152', '136', '135,136,', '3', 'SVN', '0', null);
INSERT INTO `fo_class` VALUES ('151', '140', '135,140,', '3', 'Html5', '0', null);
INSERT INTO `fo_class` VALUES ('150', '140', '135,140,', '3', 'Bootstrap', '0', null);
INSERT INTO `fo_class` VALUES ('149', '140', '135,140,', '3', 'Css', '0', null);
INSERT INTO `fo_class` VALUES ('148', '141', '135,141,', '3', 'Jquery', '0', null);
INSERT INTO `fo_class` VALUES ('147', '139', '135,139,', '3', 'Thinkphp', '2', null);
INSERT INTO `fo_class` VALUES ('146', '139', '135,139,', '3', 'Yii2', '1', null);
INSERT INTO `fo_class` VALUES ('143', '137', '135,137,', '3', 'Mysql', '0', null);
INSERT INTO `fo_class` VALUES ('166', '0', '', '1', '2221', '0', null);
INSERT INTO `fo_class` VALUES ('167', '166', '166,', '2', '111', '0', null);
INSERT INTO `fo_class` VALUES ('168', '167', '166,167,', '3', '33334234', '3', null);
INSERT INTO `fo_class` VALUES ('169', '168', '166,167,168,', '4', '555', '0', null);
INSERT INTO `fo_class` VALUES ('170', '169', '166,167,168,169,', '5', '666', '0', null);
INSERT INTO `fo_class` VALUES ('172', '167', '166,167,', '3', '333378', '5', null);
INSERT INTO `fo_class` VALUES ('173', '167', '166,167,', '3', '44444', '0', null);
INSERT INTO `fo_class` VALUES ('174', '170', '166,167,168,169,170,', '6', 'sdf', '0', null);
INSERT INTO `fo_class` VALUES ('175', '169', '166,167,168,169,', '5', 'sdfsdf', '0', null);
INSERT INTO `fo_class` VALUES ('176', '168', '166,167,168,', '4', 'sdfsdf', '0', null);
INSERT INTO `fo_class` VALUES ('177', '172', '166,167,172,', '4', 'sdf', '0', null);
INSERT INTO `fo_class` VALUES ('178', '169', '166,167,168,169,', '5', '234234', '0', null);
INSERT INTO `fo_class` VALUES ('179', '168', '166,167,168,', '4', '234', '0', null);
INSERT INTO `fo_class` VALUES ('180', '177', '166,167,172,177,', '5', '234', '0', null);
INSERT INTO `fo_class` VALUES ('181', '173', '166,167,173,', '4', '234', '0', null);
INSERT INTO `fo_class` VALUES ('182', '177', '166,167,172,177,', '5', '234', '0', null);
INSERT INTO `fo_class` VALUES ('183', '172', '166,167,172,', '4', '234', '0', null);
INSERT INTO `fo_class` VALUES ('184', '173', '166,167,173,', '4', '24', '0', null);
INSERT INTO `fo_class` VALUES ('185', '181', '166,167,173,181,', '5', '234', '0', null);
INSERT INTO `fo_class` VALUES ('186', '167', '166,167,', '3', '234', '0', null);
INSERT INTO `fo_class` VALUES ('187', '184', '166,167,173,184,', '5', '234', '0', null);
INSERT INTO `fo_class` VALUES ('188', '173', '166,167,173,', '4', '234', '0', null);
INSERT INTO `fo_class` VALUES ('189', '167', '166,167,', '3', '234', '0', null);

-- ----------------------------
-- Table structure for fo_function
-- ----------------------------
DROP TABLE IF EXISTS `fo_function`;
CREATE TABLE `fo_function` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `fid` int(10) NOT NULL DEFAULT '0',
  `fname` varchar(64) DEFAULT NULL,
  `furi` varchar(128) DEFAULT NULL,
  `sort` int(5) NOT NULL DEFAULT '0',
  `candel` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0可以删除，1不可以删除',
  `state` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0显示，1不显示',
  `ctime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=73 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fo_function
-- ----------------------------
INSERT INTO `fo_function` VALUES ('12', '0', '系统常规功能', 'none', '1', '1', '0', '2017-08-10 16:43:03');
INSERT INTO `fo_function` VALUES ('13', '12', '系统信息查看', '/admin/index', '0', '1', '0', '2017-08-10 16:43:03');
INSERT INTO `fo_function` VALUES ('14', '0', '信息系统管理', 'none', '2', '0', '0', '2017-08-10 16:43:03');
INSERT INTO `fo_function` VALUES ('16', '12', '管理员登录日志', '/admin/managerrecord/list', '1', '1', '0', '2017-08-10 16:43:03');
INSERT INTO `fo_function` VALUES ('17', '12', '管理员管理', '/admin/manager/list', '3', '1', '0', '2017-08-10 16:43:03');
INSERT INTO `fo_function` VALUES ('18', '12', '管理员分组管理', '/admin/managergroup/list', '4', '1', '0', '2017-08-10 16:43:03');
INSERT INTO `fo_function` VALUES ('19', '12', '系统功能管理', '/admin/function/list', '5', '1', '0', '2017-08-10 16:43:03');
INSERT INTO `fo_function` VALUES ('43', '14', '技术文章管理', '#', '0', '0', '0', '2017-08-10 16:43:03');
INSERT INTO `fo_function` VALUES ('45', '12', '系统分类管理', '/admin/class/list', '7', '0', '0', '2017-08-10 16:43:03');

-- ----------------------------
-- Table structure for fo_manager
-- ----------------------------
DROP TABLE IF EXISTS `fo_manager`;
CREATE TABLE `fo_manager` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(32) NOT NULL,
  `password` varchar(64) NOT NULL,
  `uname` varchar(32) NOT NULL COMMENT '管理员姓名',
  `group_id` int(5) NOT NULL DEFAULT '0' COMMENT '管理员分组ID',
  `locking` tinyint(1) NOT NULL DEFAULT '0' COMMENT '0为正常，1为锁定',
  `number` int(10) DEFAULT '0' COMMENT '登录次数',
  `login_ip` varchar(15) DEFAULT NULL COMMENT '最后一次登录IP',
  `login_time` datetime DEFAULT NULL COMMENT '最后一次登录时间',
  `ctime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=215 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fo_manager
-- ----------------------------
INSERT INTO `fo_manager` VALUES ('1', 'zjwlgr', '02bbc9253fb630843b6af6a95a501908', '张健', '1', '0', '643', '0:0:0:0:0:0:0:1', '2017-08-17 11:22:28', '1985-11-04 00:43:03');
INSERT INTO `fo_manager` VALUES ('19', 'admin', 'e10adc3949ba59abbe56e057f20f883e', 'adminz', '2', '0', '8', '0:0:0:0:0:0:0:1', '2017-08-16 17:30:15', '2017-08-10 16:43:03');
INSERT INTO `fo_manager` VALUES ('20', 'lwqbj', 'e10adc3949ba59abbe56e057f20f883e', '阿苏', '1', '0', '7', '0:0:0:0:0:0:0:1', '2017-08-14 14:01:47', '2017-08-10 16:43:03');

-- ----------------------------
-- Table structure for fo_manager_group
-- ----------------------------
DROP TABLE IF EXISTS `fo_manager_group`;
CREATE TABLE `fo_manager_group` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `gname` varchar(32) DEFAULT NULL,
  `function` varchar(1024) DEFAULT '' COMMENT '存功能的FID，FID',
  `ctime` datetime DEFAULT NULL,
  `childtion` varchar(1024) DEFAULT NULL COMMENT '存功能子ID，ID',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fo_manager_group
-- ----------------------------
INSERT INTO `fo_manager_group` VALUES ('1', '超级管理员', 'CJ', '1985-11-04 00:43:03', null);
INSERT INTO `fo_manager_group` VALUES ('2', '运营部', '12,14,', '2017-08-16 17:54:46', '16,43,');

-- ----------------------------
-- Table structure for fo_manager_record
-- ----------------------------
DROP TABLE IF EXISTS `fo_manager_record`;
CREATE TABLE `fo_manager_record` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) DEFAULT NULL,
  `username` varchar(32) DEFAULT NULL,
  `uname` varchar(32) DEFAULT NULL,
  `ip` varchar(15) DEFAULT NULL,
  `ctime` datetime DEFAULT '0000-00-00 00:00:00',
  `browser` varchar(512) DEFAULT NULL COMMENT '浏览器信息',
  `system` varchar(512) DEFAULT NULL COMMENT '系统信息',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=350 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of fo_manager_record
-- ----------------------------
INSERT INTO `fo_manager_record` VALUES ('274', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-10 16:43:03', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('275', '2', 'houjiandong', '候建东', '0:0:0:0:0:0:0:1', '2017-08-10 16:46:29', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('276', '19', 'admin', 'admin', '0:0:0:0:0:0:0:1', '2017-08-10 17:01:08', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('277', '20', 'lwqbj', '阿苏', '0:0:0:0:0:0:0:1', '2017-08-10 17:20:09', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('282', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 10:44:37', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('279', '1', 'zjwlgr', '张健', '127.0.0.1', '2017-08-10 21:31:17', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('281', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 08:51:31', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('280', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-10 22:55:20', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('286', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 16:26:09', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('6', '2', 'houjiandong', '候建东', '0:0:0:0:0:0:0:1', '2017-08-10 16:46:29', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('7', '19', 'admin', 'admin', '0:0:0:0:0:0:0:1', '2017-08-10 17:01:08', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('8', '20', 'lwqbj', '阿苏', '0:0:0:0:0:0:0:1', '2017-08-10 17:20:09', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('298', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-12 15:43:49', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('283', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 13:59:15', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('284', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 14:48:52', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('285', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 15:57:54', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('287', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 19:49:23', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('288', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 20:53:37', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('289', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 21:21:39', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('290', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 22:01:09', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('291', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 22:24:20', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('292', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 22:27:30', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('293', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 23:21:31', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('294', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-11 23:59:54', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('295', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-12 08:42:05', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('296', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-12 10:21:25', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('297', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-12 14:39:41', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('299', '20', 'lwqbj', '阿苏', '0:0:0:0:0:0:0:1', '2017-08-12 16:20:40', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('300', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-12 20:34:00', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('301', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-12 20:47:02', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('302', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-12 21:29:52', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('303', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-13 09:39:12', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('304', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-13 10:09:27', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('305', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-13 10:42:09', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('306', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-13 11:19:42', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('307', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-13 14:26:52', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('308', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-14 11:48:04', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('309', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-14 13:34:04', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('310', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-14 13:50:30', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('311', '20', 'lwqbj', '阿苏', '0:0:0:0:0:0:0:1', '2017-08-14 13:51:02', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('312', '20', 'lwqbj', '阿苏', '0:0:0:0:0:0:0:1', '2017-08-14 14:01:11', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('313', '20', 'lwqbj', '阿苏', '0:0:0:0:0:0:0:1', '2017-08-14 14:01:47', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('314', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-14 15:56:01', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('315', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-14 20:08:04', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('316', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-14 20:23:36', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('317', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-14 20:43:19', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('318', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-14 23:36:55', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('319', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 09:20:11', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('320', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 10:22:55', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('321', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 10:46:33', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('322', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 11:16:06', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('323', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 11:25:16', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('324', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 14:06:18', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('325', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 14:31:53', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('326', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 15:29:36', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('327', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 15:54:24', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('328', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 16:17:00', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('329', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 19:45:29', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('330', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-15 20:37:42', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('331', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-16 15:59:02', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('332', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-16 16:39:44', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('333', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-16 16:43:43', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('334', '19', 'admin', 'adminz', '0:0:0:0:0:0:0:1', '2017-08-16 16:46:14', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('335', '19', 'admin', 'adminz', '0:0:0:0:0:0:0:1', '2017-08-16 16:50:02', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('336', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-16 16:58:56', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('337', '19', 'admin', 'adminz', '0:0:0:0:0:0:0:1', '2017-08-16 16:59:43', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('338', '19', 'admin', 'adminz', '0:0:0:0:0:0:0:1', '2017-08-16 17:00:16', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('339', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-16 17:00:45', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('340', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-16 17:10:58', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('341', '19', 'admin', 'adminz', '0:0:0:0:0:0:0:1', '2017-08-16 17:30:15', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('342', '1', 'zjwlgr', '张健', '127.0.0.1', '2017-08-16 17:31:36', 'Firefox/54', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('343', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-16 20:52:02', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('344', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-16 20:53:36', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('345', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-16 21:21:37', 'Chrome/59', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('346', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-17 10:05:42', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('347', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-17 10:24:06', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('348', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-17 11:00:02', 'Chrome/57', 'Windows');
INSERT INTO `fo_manager_record` VALUES ('349', '1', 'zjwlgr', '张健', '0:0:0:0:0:0:0:1', '2017-08-17 11:22:28', 'Chrome/57', 'Windows');
