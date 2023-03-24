package com.ligen;

import com.ligen.db.InitDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.io.IOException;
import java.sql.SQLException;

@SpringBootApplication
public class DBApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext application = SpringApplication.run(DBApplication.class, args);
        InitDB initDB = application.getBean(InitDB.class);

        try {
            initDB.initDB();
            initDB.dropTables();
            initDB.createTables();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }

    }
}
