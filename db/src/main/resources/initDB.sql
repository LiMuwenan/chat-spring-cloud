/*
 Navicat Premium Data Transfer

 Source Server         : mysql
 Source Server Type    : MySQL
 Source Server Version : 80021
 Source Host           : localhost:3306
 Source Schema         : tinode

 Target Server Type    : MySQL
 Target Server Version : 80021
 File Encoding         : 65001

 Date: 24/03/2023 09:38:21
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for auth
-- ----------------------------
DROP TABLE IF EXISTS `auth`;
CREATE TABLE `auth`  (
                         `id` int NOT NULL AUTO_INCREMENT,
                         `uname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                         `userid` bigint NOT NULL,
                         `scheme` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                         `authlvl` int NOT NULL,
                         `secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                         `expires` datetime NULL DEFAULT NULL,
                         PRIMARY KEY (`id`) USING BTREE,
                         UNIQUE INDEX `auth_userid_scheme`(`userid`, `scheme`) USING BTREE,
                         UNIQUE INDEX `auth_uname`(`uname`) USING BTREE,
                         CONSTRAINT `auth_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for contracts
-- ----------------------------
DROP TABLE IF EXISTS `contracts`;
CREATE TABLE `contracts`  (
                              `id` bigint NOT NULL,
                              `createdat` datetime(3) NOT NULL,
                              `updatedat` datetime(3) NOT NULL,
                              `userid` bigint NOT NULL,
                              `shopid` bigint NOT NULL,
                              `state` smallint NOT NULL DEFAULT 0,
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `contracts_ifbk_1`(`userid`) USING BTREE,
                              INDEX `shopid`(`shopid`) USING BTREE,
                              CONSTRAINT `contracts_ibfk_1` FOREIGN KEY (`shopid`) REFERENCES `shops` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                              CONSTRAINT `contracts_ifbk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for credentials
-- ----------------------------
DROP TABLE IF EXISTS `credentials`;
CREATE TABLE `credentials`  (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `createdat` datetime(3) NOT NULL,
                                `updatedat` datetime(3) NOT NULL,
                                `deletedat` datetime(3) NULL DEFAULT NULL,
                                `method` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                `value` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                `synthetic` varchar(192) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                `userid` bigint NOT NULL,
                                `resp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                `done` tinyint NOT NULL DEFAULT 0,
                                `retries` int NOT NULL DEFAULT 0,
                                PRIMARY KEY (`id`) USING BTREE,
                                UNIQUE INDEX `credentials_uniqueness`(`synthetic`) USING BTREE,
                                INDEX `userid`(`userid`) USING BTREE,
                                CONSTRAINT `credentials_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for customs
-- ----------------------------
DROP TABLE IF EXISTS `customs`;
CREATE TABLE `customs`  (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `createdat` datetime(3) NOT NULL,
                            `updatedat` datetime(3) NOT NULL,
                            `deletedat` datetime(3) NULL DEFAULT NULL,
                            `userid` bigint NOT NULL,
                            `shopid` bigint NOT NULL,
                            `state` smallint NOT NULL DEFAULT 0,
                            PRIMARY KEY (`id`) USING BTREE,
                            INDEX `customs_ifbk_1`(`userid`) USING BTREE,
                            INDEX `customs_ifbk_2`(`shopid`) USING BTREE,
                            CONSTRAINT `customs_ifbk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                            CONSTRAINT `customs_ifbk_2` FOREIGN KEY (`shopid`) REFERENCES `shops` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for dellog
-- ----------------------------
DROP TABLE IF EXISTS `dellog`;
CREATE TABLE `dellog`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                           `deletedfor` bigint NOT NULL DEFAULT 0,
                           `delid` int NOT NULL,
                           `low` int NOT NULL,
                           `hi` int NOT NULL,
                           PRIMARY KEY (`id`) USING BTREE,
                           INDEX `dellog_topic_delid_deletedfor`(`topic`, `delid`, `deletedfor`) USING BTREE,
                           INDEX `dellog_topic_deletedfor_low_hi`(`topic`, `deletedfor`, `low`, `hi`) USING BTREE,
                           INDEX `dellog_deletedfor`(`deletedfor`) USING BTREE,
                           CONSTRAINT `dellog_ibfk_1` FOREIGN KEY (`topic`) REFERENCES `topics` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for devices
-- ----------------------------
DROP TABLE IF EXISTS `devices`;
CREATE TABLE `devices`  (
                            `id` int NOT NULL AUTO_INCREMENT,
                            `userid` bigint NOT NULL,
                            `hash` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                            `deviceid` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                            `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                            `lastseen` datetime NOT NULL,
                            `lang` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                            PRIMARY KEY (`id`) USING BTREE,
                            UNIQUE INDEX `devices_hash`(`hash`) USING BTREE,
                            INDEX `userid`(`userid`) USING BTREE,
                            CONSTRAINT `devices_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for filemsglinks
-- ----------------------------
DROP TABLE IF EXISTS `filemsglinks`;
CREATE TABLE `filemsglinks`  (
                                 `id` int NOT NULL AUTO_INCREMENT,
                                 `createdat` datetime(3) NOT NULL,
                                 `fileid` bigint NOT NULL,
                                 `msgid` int NULL DEFAULT NULL,
                                 `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                 `userid` bigint NULL DEFAULT NULL,
                                 PRIMARY KEY (`id`) USING BTREE,
                                 INDEX `fileid`(`fileid`) USING BTREE,
                                 INDEX `msgid`(`msgid`) USING BTREE,
                                 INDEX `topic`(`topic`) USING BTREE,
                                 INDEX `userid`(`userid`) USING BTREE,
                                 CONSTRAINT `filemsglinks_ibfk_1` FOREIGN KEY (`fileid`) REFERENCES `fileuploads` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
                                 CONSTRAINT `filemsglinks_ibfk_2` FOREIGN KEY (`msgid`) REFERENCES `messages` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
                                 CONSTRAINT `filemsglinks_ibfk_3` FOREIGN KEY (`topic`) REFERENCES `topics` (`name`) ON DELETE CASCADE ON UPDATE RESTRICT,
                                 CONSTRAINT `filemsglinks_ibfk_4` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for fileuploads
-- ----------------------------
DROP TABLE IF EXISTS `fileuploads`;
CREATE TABLE `fileuploads`  (
                                `id` bigint NOT NULL,
                                `createdat` datetime(3) NOT NULL,
                                `updatedat` datetime(3) NOT NULL,
                                `userid` bigint NULL DEFAULT NULL,
                                `status` int NOT NULL,
                                `mimetype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                `size` bigint NOT NULL,
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
                             `id` int NOT NULL AUTO_INCREMENT,
                             `createdat` datetime(3) NOT NULL,
                             `updatedat` datetime(3) NOT NULL,
                             `deletedat` datetime(3) NULL DEFAULT NULL,
                             `delid` int NULL DEFAULT 0,
                             `seqid` int NOT NULL,
                             `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                             `from` bigint NOT NULL,
                             `head` json NULL,
                             `content` json NULL,
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `messages_topic_seqid`(`topic`, `seqid`) USING BTREE,
                             CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`topic`) REFERENCES `topics` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 287 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_bots
-- ----------------------------
DROP TABLE IF EXISTS `shop_bots`;
CREATE TABLE `shop_bots`  (
                              `id` int NOT NULL,
                              `userid` bigint NOT NULL,
                              `shopid` bigint NOT NULL,
                              PRIMARY KEY (`id`) USING BTREE,
                              INDEX `shop_users_1`(`userid`) USING BTREE,
                              INDEX `shop_users_2`(`shopid`) USING BTREE,
                              CONSTRAINT `shop_users_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                              CONSTRAINT `shop_users_2` FOREIGN KEY (`shopid`) REFERENCES `shops` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shop_topics
-- ----------------------------
DROP TABLE IF EXISTS `shop_topics`;
CREATE TABLE `shop_topics`  (
                                `id` int NOT NULL,
                                `shopid` bigint NOT NULL,
                                `topicid` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                PRIMARY KEY (`id`) USING BTREE,
                                INDEX `shop_topics_1`(`shopid`) USING BTREE,
                                INDEX `shop_topics_2`(`topicid`) USING BTREE,
                                CONSTRAINT `shop_topics_1` FOREIGN KEY (`shopid`) REFERENCES `shops` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
                                CONSTRAINT `shop_topics_2` FOREIGN KEY (`topicid`) REFERENCES `topics` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for shops
-- ----------------------------
DROP TABLE IF EXISTS `shops`;
CREATE TABLE `shops`  (
                          `id` bigint NOT NULL,
                          `createdat` datetime(3) NOT NULL,
                          `updatedat` datetime(3) NOT NULL,
                          `deletedat` datetime(3) NULL DEFAULT NULL,
                          `shopname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                          `state` smallint NOT NULL DEFAULT 0,
                          PRIMARY KEY (`id`) USING BTREE,
                          INDEX `shopname`(`shopname`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for subscriptions
-- ----------------------------
DROP TABLE IF EXISTS `subscriptions`;
CREATE TABLE `subscriptions`  (
                                  `id` int NOT NULL AUTO_INCREMENT,
                                  `createdat` datetime(3) NOT NULL,
                                  `updatedat` datetime(3) NOT NULL,
                                  `deletedat` datetime(3) NULL DEFAULT NULL,
                                  `userid` bigint NOT NULL,
                                  `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                                  `delid` int NULL DEFAULT 0,
                                  `recvseqid` int NULL DEFAULT 0,
                                  `readseqid` int NULL DEFAULT 0,
                                  `modewant` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                  `modegiven` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,
                                  `private` json NULL,
                                  PRIMARY KEY (`id`) USING BTREE,
                                  UNIQUE INDEX `subscriptions_topic_userid`(`topic`, `userid`) USING BTREE,
                                  INDEX `userid`(`userid`) USING BTREE,
                                  INDEX `subscriptions_topic`(`topic`) USING BTREE,
                                  INDEX `subscriptions_deletedat`(`deletedat`) USING BTREE,
                                  CONSTRAINT `subscriptions_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topics
-- ----------------------------
DROP TABLE IF EXISTS `topics`;
CREATE TABLE `topics`  (
                           `id` int NOT NULL AUTO_INCREMENT,
                           `createdat` datetime(3) NOT NULL,
                           `updatedat` datetime(3) NOT NULL,
                           `state` smallint NOT NULL DEFAULT 0,
                           `stateat` datetime(3) NULL DEFAULT NULL,
                           `touchedat` datetime(3) NULL DEFAULT NULL,
                           `name` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                           `usebt` tinyint NULL DEFAULT 0,
                           `owner` bigint NOT NULL DEFAULT 0,
                           `access` json NULL,
                           `seqid` int NOT NULL DEFAULT 0,
                           `delid` int NULL DEFAULT 0,
                           `public` json NULL,
                           `trusted` json NULL,
                           `tags` json NULL,
                           PRIMARY KEY (`id`) USING BTREE,
                           UNIQUE INDEX `topics_name`(`name`) USING BTREE,
                           INDEX `topics_owner`(`owner`) USING BTREE,
                           INDEX `topics_state_stateat`(`state`, `stateat`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for topictags
-- ----------------------------
DROP TABLE IF EXISTS `topictags`;
CREATE TABLE `topictags`  (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                              `tag` varchar(96) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                              PRIMARY KEY (`id`) USING BTREE,
                              UNIQUE INDEX `topictags_userid_tag`(`topic`, `tag`) USING BTREE,
                              INDEX `topictags_tag`(`tag`) USING BTREE,
                              CONSTRAINT `topictags_ibfk_1` FOREIGN KEY (`topic`) REFERENCES `topics` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
                          `id` bigint NOT NULL,
                          `createdat` datetime(3) NOT NULL,
                          `updatedat` datetime(3) NOT NULL,
                          `state` smallint NOT NULL DEFAULT 0,
                          `stateat` datetime(3) NULL DEFAULT NULL,
                          `access` json NULL,
                          `lastseen` datetime NULL DEFAULT NULL,
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
                             `id` int NOT NULL AUTO_INCREMENT,
                             `userid` bigint NOT NULL,
                             `tag` varchar(96) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                             PRIMARY KEY (`id`) USING BTREE,
                             UNIQUE INDEX `usertags_userid_tag`(`userid`, `tag`) USING BTREE,
                             INDEX `usertags_tag`(`tag`) USING BTREE,
                             CONSTRAINT `usertags_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for wx_users
-- ----------------------------
DROP TABLE IF EXISTS `wx_users`;
CREATE TABLE `wx_users`  (
                             `openid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                             `userid` bigint NOT NULL,
                             `wxid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
                             PRIMARY KEY (`openid`) USING BTREE,
                             INDEX `wx_users_ifbk_1`(`userid`) USING BTREE,
                             CONSTRAINT `wx_users_ifbk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
