package com.example.tracker;

import org.springframework.boot.CommandLineRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;

public class DatabaseChecker implements CommandLineRunner {
    private final DataSource dataSource;

    public DatabaseChecker(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        try (Connection conn = dataSource.getConnection()) {
            System.out.println("=== DB CONNECTED TO: " + conn.getMetaData().getURL() + " ===");
            System.out.println("=== CURRENT USER: " + conn.getMetaData().getUserName() + " ===");

            // Cek daftar tabel yang terbaca oleh sistem
            ResultSet rs = conn.getMetaData().getTables(null, null, "%", new String[]{"TABLE"});
            System.out.println("=== TABLES FOUND IN DB ===");
            while (rs.next()) {
                System.out.println("TABLE: " + rs.getString("TABLE_NAME"));
            }
        }
    }
}
