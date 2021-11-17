package com.cse412team18.pos.services;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class DatabaseService {
    @Value("${db.url}")
    private String url;

    @Value("${db.username}")
    private String user;

    @Value("${db.password}")
    private String password;

    Connection conn;

    public DatabaseService() throws SQLException {
        conn = DriverManager
            .getConnection(url, user, password);
    }
}
