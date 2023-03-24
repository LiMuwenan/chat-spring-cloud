package com.ligen.db;

import jdk.internal.util.xml.impl.Input;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

@Component
public class InitDB {

    @Value("${spring.datasource-root.url}")
    String rootUrl;

    @Value("${spring.datasource-root.username}")
    String rootUsername;

    @Value("${spring.datasource-root.password}")
    String rootPassword;

    @Value("${spring.datasource-root.scheme}")
    String rootScheme;

    @Value("${spring.datasource.url}")
    String url;

    @Value("${spring.datasource.username}")
    String username;

    @Value("${spring.datasource.password}")
    String password;

    public void initDB() throws IOException, SQLException {
        System.out.println("Create database.");
        System.out.println("Database url：" + rootUrl);
        Connection conn = DriverManager.getConnection(rootUrl, rootUsername, rootPassword);
        Statement stmt = conn.createStatement();
        String sql = "CREATE DATABASE IF NOT EXISTS " + rootScheme; // 创建数据库
        stmt.execute(sql);
        System.out.println("Database " + rootScheme + " created.");
        stmt.close();
        conn.close();
    }

    public void createTables() throws SQLException {
        System.out.println("Create tables.");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();

        stmt.execute("DROP TABLE IF EXISTS users");
        String users =
                "CREATE TABLE `users`  (" +
                "  `id` bigint NOT NULL," +
                "  `createdat` datetime(3) NOT NULL," +
                "  `updatedat` datetime(3) NOT NULL," +
                "  `state` smallint NOT NULL DEFAULT 0," +
                "  `stateat` datetime(3) NULL DEFAULT NULL," +
                "  `access` json NULL," +
                "  `lastseen` datetime NULL DEFAULT NULL," +
                "  `useragent` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT ''," +
                "  `public` json NULL," +
                "  `trusted` json NULL," +
                "  `tags` json NULL," +
                "  PRIMARY KEY (`id`) USING BTREE," +
                "  INDEX `users_state_stateat`(`state`, `stateat`) USING BTREE" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(users);
        System.out.println("Create table users.");

        stmt.execute("DROP TABLE IF EXISTS auth");
        String auth = "CREATE TABLE `auth`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `uname` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `userid` bigint NOT NULL,\n" +
                "  `scheme` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `authlvl` int NOT NULL,\n" +
                "  `secret` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `expires` datetime NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE INDEX `auth_userid_scheme`(`userid`, `scheme`) USING BTREE,\n" +
                "  UNIQUE INDEX `auth_uname`(`uname`) USING BTREE,\n" +
                "  CONSTRAINT `auth_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 10 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(auth);
        System.out.println("Create table auth");

        stmt.execute("DROP TABLE IF EXISTS credentials");
        String credentials = "CREATE TABLE `credentials`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `createdat` datetime(3) NOT NULL,\n" +
                "  `updatedat` datetime(3) NOT NULL,\n" +
                "  `deletedat` datetime(3) NULL DEFAULT NULL,\n" +
                "  `method` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `value` varchar(128) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `synthetic` varchar(192) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `userid` bigint NOT NULL,\n" +
                "  `resp` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,\n" +
                "  `done` tinyint NOT NULL DEFAULT 0,\n" +
                "  `retries` int NOT NULL DEFAULT 0,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE INDEX `credentials_uniqueness`(`synthetic`) USING BTREE,\n" +
                "  INDEX `userid`(`userid`) USING BTREE,\n" +
                "  CONSTRAINT `credentials_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(credentials);
        System.out.println("Create table credentials.");

        stmt.execute("DROP TABLE IF EXISTS devices");
        String devices = "CREATE TABLE `devices`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `userid` bigint NOT NULL,\n" +
                "  `hash` char(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `deviceid` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `platform` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,\n" +
                "  `lastseen` datetime NOT NULL,\n" +
                "  `lang` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE INDEX `devices_hash`(`hash`) USING BTREE,\n" +
                "  INDEX `userid`(`userid`) USING BTREE,\n" +
                "  CONSTRAINT `devices_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(devices);
        System.out.println("Create table devices.");

        stmt.execute("DROP TABLE IF EXISTS subscriptions");
        String subscriptions = "CREATE TABLE `subscriptions`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `createdat` datetime(3) NOT NULL,\n" +
                "  `updatedat` datetime(3) NOT NULL,\n" +
                "  `deletedat` datetime(3) NULL DEFAULT NULL,\n" +
                "  `userid` bigint NOT NULL,\n" +
                "  `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `delid` int NULL DEFAULT 0,\n" +
                "  `recvseqid` int NULL DEFAULT 0,\n" +
                "  `readseqid` int NULL DEFAULT 0,\n" +
                "  `modewant` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,\n" +
                "  `modegiven` char(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,\n" +
                "  `private` json NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE INDEX `subscriptions_topic_userid`(`topic`, `userid`) USING BTREE,\n" +
                "  INDEX `userid`(`userid`) USING BTREE,\n" +
                "  INDEX `subscriptions_topic`(`topic`) USING BTREE,\n" +
                "  INDEX `subscriptions_deletedat`(`deletedat`) USING BTREE,\n" +
                "  CONSTRAINT `subscriptions_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 77 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(subscriptions);
        System.out.println("Create table subscriptions.");

        stmt.execute("DROP TABLE IF EXISTS usertags");
        String userTags = "CREATE TABLE `usertags`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `userid` bigint NOT NULL,\n" +
                "  `tag` varchar(96) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE INDEX `usertags_userid_tag`(`userid`, `tag`) USING BTREE,\n" +
                "  INDEX `usertags_tag`(`tag`) USING BTREE,\n" +
                "  CONSTRAINT `usertags_ibfk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 26 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(userTags);
        System.out.println("Create table usertags");

        stmt.execute("DROP TABLE IF EXISTS wx_users");
        String wxUsers = "CREATE TABLE `wx_users`  (\n" +
                "  `openid` varchar(40) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `userid` bigint NOT NULL,\n" +
                "  `wxid` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  PRIMARY KEY (`openid`) USING BTREE,\n" +
                "  INDEX `wx_users_ifbk_1`(`userid`) USING BTREE,\n" +
                "  CONSTRAINT `wx_users_ifbk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(wxUsers);
        System.out.println("Create table wx_users");

        stmt.execute("DROP TABLE IF EXISTS topics");
        String topics = "CREATE TABLE `topics`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `createdat` datetime(3) NOT NULL,\n" +
                "  `updatedat` datetime(3) NOT NULL,\n" +
                "  `state` smallint NOT NULL DEFAULT 0,\n" +
                "  `stateat` datetime(3) NULL DEFAULT NULL,\n" +
                "  `touchedat` datetime(3) NULL DEFAULT NULL,\n" +
                "  `name` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `usebt` tinyint NULL DEFAULT 0,\n" +
                "  `owner` bigint NOT NULL DEFAULT 0,\n" +
                "  `access` json NULL,\n" +
                "  `seqid` int NOT NULL DEFAULT 0,\n" +
                "  `delid` int NULL DEFAULT 0,\n" +
                "  `public` json NULL,\n" +
                "  `trusted` json NULL,\n" +
                "  `tags` json NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE INDEX `topics_name`(`name`) USING BTREE,\n" +
                "  INDEX `topics_owner`(`owner`) USING BTREE,\n" +
                "  INDEX `topics_state_stateat`(`state`, `stateat`) USING BTREE\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(topics);
        System.out.println("Create table topics.");

        stmt.execute("DROP TABLE IF EXISTS topictags");
        String topicTags = "CREATE TABLE `topictags`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `tag` varchar(96) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE INDEX `topictags_userid_tag`(`topic`, `tag`) USING BTREE,\n" +
                "  INDEX `topictags_tag`(`tag`) USING BTREE,\n" +
                "  CONSTRAINT `topictags_ibfk_1` FOREIGN KEY (`topic`) REFERENCES `topics` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(topicTags);
        System.out.println("Create table topictags");

        stmt.execute("DROP TABLE IF EXISTS dellog");
        String dellog = "CREATE TABLE `dellog`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `deletedfor` bigint NOT NULL DEFAULT 0,\n" +
                "  `delid` int NOT NULL,\n" +
                "  `low` int NOT NULL,\n" +
                "  `hi` int NOT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `dellog_topic_delid_deletedfor`(`topic`, `delid`, `deletedfor`) USING BTREE,\n" +
                "  INDEX `dellog_topic_deletedfor_low_hi`(`topic`, `deletedfor`, `low`, `hi`) USING BTREE,\n" +
                "  INDEX `dellog_deletedfor`(`deletedfor`) USING BTREE,\n" +
                "  CONSTRAINT `dellog_ibfk_1` FOREIGN KEY (`topic`) REFERENCES `topics` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(dellog);
        System.out.println("Create table dellog");

        stmt.execute("DROP TABLE IF EXISTS shops");
        String shops = "CREATE TABLE `shops`  (\n" +
                "  `id` bigint NOT NULL,\n" +
                "  `createdat` datetime(3) NOT NULL,\n" +
                "  `updatedat` datetime(3) NOT NULL,\n" +
                "  `deletedat` datetime(3) NULL DEFAULT NULL,\n" +
                "  `shopname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,\n" +
                "  `desc` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,\n" +
                "  `state` smallint NOT NULL DEFAULT 0,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `shopname`(`shopname`) USING BTREE\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;\n";
        stmt.execute(shops);
        System.out.println("Create table shops.");

        stmt.execute("DROP TABLE IF EXISTS shop_topics");
        String shopTopics = "CREATE TABLE `shop_topics`  (\n" +
                "  `id` int NOT NULL,\n" +
                "  `shopid` bigint NOT NULL,\n" +
                "  `topicid` varchar(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `shop_topics_1`(`shopid`) USING BTREE,\n" +
                "  INDEX `shop_topics_2`(`topicid`) USING BTREE,\n" +
                "  CONSTRAINT `shop_topics_1` FOREIGN KEY (`shopid`) REFERENCES `shops` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `shop_topics_2` FOREIGN KEY (`topicid`) REFERENCES `topics` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(shopTopics);
        System.out.println("Create table shop_topics.");

        stmt.execute("DROP TABLE IF EXISTS shop_bots");
        String shopBots = "CREATE TABLE `shop_bots`  (\n" +
                "  `id` int NOT NULL,\n" +
                "  `userid` bigint NOT NULL,\n" +
                "  `shopid` bigint NOT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `shop_users_1`(`userid`) USING BTREE,\n" +
                "  INDEX `shop_users_2`(`shopid`) USING BTREE,\n" +
                "  CONSTRAINT `shop_users_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `shop_users_2` FOREIGN KEY (`shopid`) REFERENCES `shops` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(shopBots);
        System.out.println("Create table shop_bots.");

        stmt.execute("DROP TABLE IF EXISTS customs");
        String customs = "CREATE TABLE `customs`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `createdat` datetime(3) NOT NULL,\n" +
                "  `updatedat` datetime(3) NOT NULL,\n" +
                "  `deletedat` datetime(3) NULL DEFAULT NULL,\n" +
                "  `userid` bigint NOT NULL,\n" +
                "  `shopid` bigint NOT NULL,\n" +
                "  `state` smallint NOT NULL DEFAULT 0,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `customs_ifbk_1`(`userid`) USING BTREE,\n" +
                "  INDEX `customs_ifbk_2`(`shopid`) USING BTREE,\n" +
                "  CONSTRAINT `customs_ifbk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `customs_ifbk_2` FOREIGN KEY (`shopid`) REFERENCES `shops` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;\n";
        stmt.execute(customs);
        System.out.println("Create table customs.");

        stmt.execute("DROP TABLE IF EXISTS contracts");
        String contracts = "CREATE TABLE `contracts`  (\n" +
                "  `id` bigint NOT NULL,\n" +
                "  `createdat` datetime(3) NOT NULL,\n" +
                "  `updatedat` datetime(3) NOT NULL,\n" +
                "  `userid` bigint NOT NULL,\n" +
                "  `shopid` bigint NOT NULL,\n" +
                "  `state` smallint NOT NULL DEFAULT 0,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `contracts_ifbk_1`(`userid`) USING BTREE,\n" +
                "  INDEX `shopid`(`shopid`) USING BTREE,\n" +
                "  CONSTRAINT `contracts_ibfk_1` FOREIGN KEY (`shopid`) REFERENCES `shops` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `contracts_ifbk_1` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(contracts);
        System.out.println("Create table contracts.");

        stmt.execute("DROP TABLE IF EXISTS messages");
        String messages = "CREATE TABLE `messages`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `createdat` datetime(3) NOT NULL,\n" +
                "  `updatedat` datetime(3) NOT NULL,\n" +
                "  `deletedat` datetime(3) NULL DEFAULT NULL,\n" +
                "  `delid` int NULL DEFAULT 0,\n" +
                "  `seqid` int NOT NULL,\n" +
                "  `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `from` bigint NOT NULL,\n" +
                "  `head` json NULL,\n" +
                "  `content` json NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  UNIQUE INDEX `messages_topic_seqid`(`topic`, `seqid`) USING BTREE,\n" +
                "  CONSTRAINT `messages_ibfk_1` FOREIGN KEY (`topic`) REFERENCES `topics` (`name`) ON DELETE RESTRICT ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 287 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(messages);
        System.out.println("Create table messages.");

        stmt.execute("DROP TABLE IF EXISTS fileuploads");
        String fileUploads = "CREATE TABLE `fileuploads`  (\n" +
                "  `id` bigint NOT NULL,\n" +
                "  `createdat` datetime(3) NOT NULL,\n" +
                "  `updatedat` datetime(3) NOT NULL,\n" +
                "  `userid` bigint NULL DEFAULT NULL,\n" +
                "  `status` int NOT NULL,\n" +
                "  `mimetype` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `size` bigint NOT NULL,\n" +
                "  `location` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `fileuploads_status`(`status`) USING BTREE\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(fileUploads);
        System.out.println("Create table fileUploads.");

        stmt.execute("DROP TABLE IF EXISTS filemsglinks");
        String fileMsgLinks = "CREATE TABLE `filemsglinks`  (\n" +
                "  `id` int NOT NULL AUTO_INCREMENT,\n" +
                "  `createdat` datetime(3) NOT NULL,\n" +
                "  `fileid` bigint NOT NULL,\n" +
                "  `msgid` int NULL DEFAULT NULL,\n" +
                "  `topic` char(25) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL DEFAULT NULL,\n" +
                "  `userid` bigint NULL DEFAULT NULL,\n" +
                "  PRIMARY KEY (`id`) USING BTREE,\n" +
                "  INDEX `fileid`(`fileid`) USING BTREE,\n" +
                "  INDEX `msgid`(`msgid`) USING BTREE,\n" +
                "  INDEX `topic`(`topic`) USING BTREE,\n" +
                "  INDEX `userid`(`userid`) USING BTREE,\n" +
                "  CONSTRAINT `filemsglinks_ibfk_1` FOREIGN KEY (`fileid`) REFERENCES `fileuploads` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `filemsglinks_ibfk_2` FOREIGN KEY (`msgid`) REFERENCES `messages` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `filemsglinks_ibfk_3` FOREIGN KEY (`topic`) REFERENCES `topics` (`name`) ON DELETE CASCADE ON UPDATE RESTRICT,\n" +
                "  CONSTRAINT `filemsglinks_ibfk_4` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 3 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(fileMsgLinks);
        System.out.println("Create table filemsglinks.");

        stmt.execute("DROP TABLE IF EXISTS kvmeta");
        String kvmeta = "CREATE TABLE `kvmeta`  (\n" +
                "  `key` char(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,\n" +
                "  `value` text CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NULL,\n" +
                "  PRIMARY KEY (`key`) USING BTREE\n" +
                ") ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_unicode_ci ROW_FORMAT = Dynamic;";
        stmt.execute(kvmeta);
        System.out.println("Create table kvmeta.");



        stmt.close();
        conn.close();
    }

    public void dropTables() throws SQLException {
        System.out.println("Drop tables.");
        Connection conn = DriverManager.getConnection(url, username, password);
        Statement stmt = conn.createStatement();

        // users foreign key
        stmt.execute("DROP TABLE IF EXISTS auth");
        stmt.execute("DROP TABLE IF EXISTS usertags");
        stmt.execute("DROP TABLE IF EXISTS subscriptions");
        stmt.execute("DROP TABLE IF EXISTS wx_users");
        stmt.execute("DROP TABLE IF EXISTS credentials");
        stmt.execute("DROP TABLE IF EXISTS devices");

        // shops foreign key
        stmt.execute("DROP TABLE IF EXISTS customs");
        stmt.execute("DROP TABLE IF EXISTS shop_bots");
        stmt.execute("DROP TABLE IF EXISTS shop_topics");
        stmt.execute("DROP TABLE IF EXISTS contracts");

        // messages foreign key
        stmt.execute("DROP TABLE IF EXISTS filemsglinks");

        // topics foreign key
        stmt.execute("DROP TABLE IF EXISTS topictags");
        stmt.execute("DROP TABLE IF EXISTS dellog");
        stmt.execute("DROP TABLE IF EXISTS shop_topics");
        stmt.execute("DROP TABLE IF EXISTS messages");

        stmt.execute("DROP TABLE IF EXISTS users");
        stmt.execute("DROP TABLE IF EXISTS topics");
        stmt.execute("DROP TABLE IF EXISTS shops");
        stmt.execute("DROP TABLE IF EXISTS fileuploads");
        stmt.execute("DROP TABLE IF EXISTS kvmeta");

        stmt.close();
        conn.close();
    }
}
