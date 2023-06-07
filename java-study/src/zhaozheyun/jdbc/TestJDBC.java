package com.zhaozheyun.jdbc;

import java.sql.*;

public class TestJDBC {
    public static void main(String[] args) throws SQLException {
        Connection c = null;
        Statement s = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String host = "103.79.53.80";
            String port = "3306";
            String databaseName = "java-study";
            String username = "java-study";
            String password = "TR4rZxdmhmYBikEA";
            String jdbcConnection = "jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?" + "characterEncoding=UTF-8";
            System.out.println("jdbcConnection " + jdbcConnection);
            c = DriverManager.getConnection(jdbcConnection, username, password);
            System.out.println("link success！" + c);
            System.out.println("Java Database connection load ok!");
            s = c.createStatement();
            System.out.println("获取Statement对象" + s);
            String sql = "";
//            for (int i = 0; i < 10; i++) {
//                sql = "INSERT INTO hero(name,hp,damage) values('英雄" + (i + 1) + "'," + 313.0f + "," + 50 + ")";
//                s.execute(sql);
//            }
//            System.out.println("执行插入语句成功");
            sql = "SELECT * FROM hero";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                float hp = rs.getFloat("hp");
                int damage = rs.getInt("damage");
                System.out.println("英雄:" + name + ", 生命值:" + hp + "护甲" + damage);

            }
//


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                s.close();
            }
            if (c != null) {
                c.close();
            }
        }
    }
}
