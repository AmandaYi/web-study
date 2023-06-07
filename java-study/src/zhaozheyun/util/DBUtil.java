package com.zhaozheyun.util;

import com.zhaozheyun.annotation.JDBCConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@JDBCConfig(ip = "103.79.53.80", database = "java-study", port = 3306, username = "java-study", password = "TR4rZxdmhmYBikEA", encoding = "UTF-8")
public class DBUtil {
    static {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        JDBCConfig config = DBUtil.class.getAnnotation(JDBCConfig.class);
        String ip = config.ip();
        String database = config.database();
        String username = config.username();
        String password = config.password();
        int port = config.port();
        String encoding = config.encoding();
        String url= String.format("jdbc:mysql://%s:%d/%s?characterEncoding=%s", ip, port, database, encoding);
        try {
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        Connection c = DBUtil.getConnection();
        System.out.println(c);
    }

}
