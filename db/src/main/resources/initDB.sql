/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : chat

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 25/06/2023 09:48:42
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth`  (
                         `id` int(0) NOT NULL AUTO_INCREMENT,
                         `uname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                         `userid` bigint(0) NOT NULL,
                         `scheme` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                         `authlvl` int(0) NOT NULL,
                         `secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                         `expires` datetime(0) NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE,
                         UNIQUE INDEX `auth_userid_scheme`(`userid`, `scheme`) USING BTREE,
                         UNIQUE INDEX `auth_uname`(`uname`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contracts
-- ----------------------------
DROP TABLE IF EXISTS `contracts`;
CREATE TABLE `contracts`  (
                              `id` bigint(0) NOT NULL,
                              `createdat` datetime(3) NOT NULL,
                              `updatedat` datetime(3) NOT NULL,
                              `userid` bigint(0) NOT NULL,
                              `shopid` bigint(0) NOT NULL,
                              `state` smallint(0) NOT NULL DEFAULT 0,
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `contracts_ifbk_1`(`userid`) USING BTREE,
                              INDEX `shopid`(`shopid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for credentials
-- ----------------------------
DROP TABLE IF EXISTS `credentials`;
CREATE TABLE `credentials`  (
                                `id` int(0) NOT NULL AUTO_INCREMENT,
                                `createdat` datetime(3) NOT NULL,
                                `updatedat` datetime(3) NOT NULL,
                                `deletedat` datetime(3) NULL DEFAULT NULL,
                                `method` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                `value` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                `synthetic` varchar(192) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                `userid` bigint(0) NOT NULL,
                                `resp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                `done` tinyint(0) NOT NULL DEFAULT 0,
                                `retries` int(0) NOT NULL DEFAULT 0,
                                PRIMARY KEY (`id`) USING BTREE,
                                UNIQUE INDEX `credentials_uniqueness`(`synthetic`) USING BTREE,
                                INDEX `userid`(`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customs
-- ----------------------------
DROP TABLE IF EXISTS `customs`;
CREATE TABLE `customs`  (
                            `id` int(0) NOT NULL AUTO_INCREMENT,
                            `createdat` datetime(3) NOT NULL,
                            `updatedat` datetime(3) NOT NULL,
                            `deletedat` datetime(3) NULL DEFAULT NULL,
                            `userid` bigint(0) NOT NULL,
                            `shopid` bigint(0) NOT NULL,
                            `state` smallint(0) NOT NULL DEFAULT 0,
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `customs_ifbk_1`(`userid`) USING BTREE,
                            INDEX `customs_ifbk_2`(`shopid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dellog
-- ----------------------------
DROP TABLE IF EXISTS `dellog`;
CREATE TABLE `dellog`  (
                           `id` int(0) NOT NULL AUTO_INCREMENT,
                           `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                           `deletedfor` bigint(0) NOT NULL DEFAULT 0,
                           `delid` int(0) NOT NULL,
                           `low` int(0) NOT NULL,
                           `hi` int(0) NOT NULL,
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `dellog_topic_delid_deletedfor`(`topic`, `delid`, `deletedfor`) USING BTREE,
                           INDEX `dellog_topic_deletedfor_low_hi`(`topic`, `deletedfor`, `low`, `hi`) USING BTREE,
                           INDEX `dellog_deletedfor`(`deletedfor`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices`  (
                            `id` int(0) NOT NULL AUTO_INCREMENT,
                            `userid` bigint(0) NOT NULL,
                            `hash` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                            `deviceid` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                            `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                            `lastseen` datetime(0) NOT NULL,
                            `lang` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE INDEX `devices_hash`(`hash`) USING BTREE,
                            INDEX `userid`(`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for filemsglinks
-- ----------------------------
DROP TABLE IF EXISTS `filemsglinks`;
CREATE TABLE `filemsglinks`  (
                                 `id` int(0) NOT NULL AUTO_INCREMENT,
                                 `createdat` datetime(3) NOT NULL,
                                 `fileid` bigint(0) NOT NULL,
                                 `msgid` int(0) NULL DEFAULT NULL,
                                 `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                 `userid` bigint(0) NULL DEFAULT NULL,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 INDEX `fileid`(`fileid`) USING BTREE,
                                 INDEX `msgid`(`msgid`) USING BTREE,
                                 INDEX `topic`(`topic`) USING BTREE,
                                 INDEX `userid`(`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fileuploads
-- ----------------------------
DROP TABLE IF EXISTS `fileuploads`;
CREATE TABLE `fileuploads`  (
                                `id` bigint(0) NOT NULL,
                                `createdat` datetime(3) NOT NULL,
                                `updatedat` datetime(3) NOT NULL,
                                `userid` bigint(0) NULL DEFAULT NULL,
                                `status` int(0) NOT NULL,
                                `mimetype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                `size` bigint(0) NOT NULL,
                                `location` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                PRIMARY KEY (`id`) USING BTREE,
                                INDEX `fileuploads_status`(`status`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for kvmeta
-- ----------------------------
DROP TABLE IF EXISTS `kvmeta`;
CREATE TABLE `kvmeta`  (
                           `key` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                           `value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,
                           PRIMARY KEY (`key`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for messages
-- ----------------------------
DROP TABLE IF EXISTS `messages`;
CREATE TABLE `messages`  (
                             `id` int(0) NOT NULL AUTO_INCREMENT,
                             `createdat` datetime(3) NOT NULL,
                             `updatedat` datetime(3) NOT NULL,
                             `deletedat` datetime(3) NULL DEFAULT NULL,
                             `delid` int(0) NULL DEFAULT 0,
                             `seqid` int(0) NOT NULL,
                             `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                             `from` bigint(0) NOT NULL,
                             `head` json NULL,
                             `content` json NULL,
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `messages_topic_seqid`(`topic`, `seqid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_bots
-- ----------------------------
DROP TABLE IF EXISTS `shop_bots`;
CREATE TABLE `shop_bots`  (
                              `id` int(0) NOT NULL,
                              `userid` bigint(0) NOT NULL,
                              `shopid` bigint(0) NOT NULL,
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `shop_users_1`(`userid`) USING BTREE,
                              INDEX `shop_users_2`(`shopid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_topics
-- ----------------------------
DROP TABLE IF EXISTS `shop_topics`;
CREATE TABLE `shop_topics`  (
                                `id` int(0) NOT NULL,
                                `shopid` bigint(0) NOT NULL,
                                `topicid` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                PRIMARY KEY (`id`) USING BTREE,
                                INDEX `shop_topics_1`(`shopid`) USING BTREE,
                                INDEX `shop_topics_2`(`topicid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shops
-- ----------------------------
DROP TABLE IF EXISTS `shops`;
CREATE TABLE `shops`  (
                          `id` bigint(0) NOT NULL,
                          `createdat` datetime(3) NOT NULL,
                          `updatedat` datetime(3) NOT NULL,
                          `deletedat` datetime(3) NULL DEFAULT NULL,
                          `shopname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `state` smallint(0) NOT NULL DEFAULT 0,
                          PRIMARY KEY (`id`) USING BTREE,
                          INDEX `shopname`(`shopname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for subscriptions
-- ----------------------------
DROP TABLE IF EXISTS `subscriptions`;
CREATE TABLE `subscriptions`  (
                                  `id` int(0) NOT NULL AUTO_INCREMENT,
                                  `createdat` datetime(3) NOT NULL,
                                  `updatedat` datetime(3) NOT NULL,
                                  `deletedat` datetime(3) NULL DEFAULT NULL,
                                  `userid` bigint(0) NOT NULL,
                                  `topic` bigint(0) NOT NULL,
                                  `delid` int(0) NULL DEFAULT 0,
                                  `recvseqid` int(0) NULL DEFAULT 0,
                                  `readseqid` int(0) NULL DEFAULT 0,
                                  `modewant` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                  `modegiven` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                  `private` json NULL,
                                  PRIMARY KEY (`id`) USING BTREE,
                                  UNIQUE INDEX `subscriptions_topic_userid`(`topic`, `userid`) USING BTREE,
                                  INDEX `userid`(`userid`) USING BTREE,
                                  INDEX `subscriptions_topic`(`topic`) USING BTREE,
                                  INDEX `subscriptions_deletedat`(`deletedat`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 108 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topics
-- ----------------------------
DROP TABLE IF EXISTS `topics`;
CREATE TABLE `topics`  (
                           `id` bigint(0) NOT NULL AUTO_INCREMENT,
                           `createdat` datetime(3) NOT NULL,
                           `updatedat` datetime(3) NOT NULL,
                           `state` smallint(0) NOT NULL DEFAULT 0,
                           `stateat` datetime(3) NULL DEFAULT NULL,
                           `touchedat` datetime(3) NULL DEFAULT NULL,
                           `name` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                           `usebt` tinyint(0) NULL DEFAULT 0,
                           `owner` bigint(0) NOT NULL DEFAULT 0,
                           `access` json NULL,
                           `seqid` int(0) NOT NULL DEFAULT 0,
                           `delid` int(0) NULL DEFAULT 0,
                           `public` json NULL,
                           `trusted` json NULL,
                           `tags` json NULL,
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE INDEX `topics_name`(`name`) USING BTREE,
                           INDEX `topics_owner`(`owner`) USING BTREE,
                           INDEX `topics_state_stateat`(`state`, `stateat`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2305061683363433745 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topictags
-- ----------------------------
DROP TABLE IF EXISTS `topictags`;
CREATE TABLE `topictags`  (
                              `id` int(0) NOT NULL AUTO_INCREMENT,
                              `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                              `tag` varchar(96) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                              PRIMARY KEY (`id`) USING BTREE,
                              UNIQUE INDEX `topictags_userid_tag`(`topic`, `tag`) USING BTREE,
                              INDEX `topictags_tag`(`tag`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
                          `id` bigint(0) NOT NULL,
                          `createdat` datetime(3) NOT NULL,
                          `updatedat` datetime(3) NOT NULL,
                          `state` smallint(0) NOT NULL DEFAULT 0,
                          `stateat` datetime(3) NULL DEFAULT NULL,
                          `access` json NULL,
                          `lastseen` datetime(0) NULL DEFAULT NULL,
                          `useragent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT '',
                          `public` json NULL,
                          `trusted` json NULL,
                          `tags` json NULL,
                          PRIMARY KEY (`id`) USING BTREE,
                          INDEX `users_state_stateat`(`state`, `stateat`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for usertags
-- ----------------------------
DROP TABLE IF EXISTS `usertags`;
CREATE TABLE `usertags`  (
                             `id` int(0) NOT NULL AUTO_INCREMENT,
                             `userid` bigint(0) NOT NULL,
                             `tag` varchar(96) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `usertags_userid_tag`(`userid`, `tag`) USING BTREE,
                             INDEX `usertags_tag`(`tag`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 31 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wx_users
-- ----------------------------
DROP TABLE IF EXISTS `wx_users`;
CREATE TABLE `wx_users`  (
                             `openid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                             `userid` bigint(0) NOT NULL,
                             `wxid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                             PRIMARY KEY (`openid`) USING BTREE,
                             INDEX `wx_users_ifbk_1`(`userid`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
