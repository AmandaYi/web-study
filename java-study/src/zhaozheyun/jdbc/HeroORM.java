package com.zhaozheyun.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

class Hero {
    private int id;
    private String name;
    private float hp;
    private int damage;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public float getHp() {
        return hp;
    }

    public int getDamage() {
        return damage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHp(float hp) {
        this.hp = hp;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}

public class HeroORM {

    Connection c = null;

    public HeroORM() {
        if (c == null) {

            try {
                Class.forName("com.mysql.jdbc.Driver");
                String host = "103.79.53.80";
                String port = "3306";
                String databaseName = "java-study";
                String username = "java-study";
                String password = "TR4rZxdmhmYBikEA";
                String jdbcConnection = "jdbc:mysql://" + host + ":" + port + "/" + databaseName + "?" + "characterEncoding=UTF-8";
//            System.out.println("jdbcConnection " + jdbcConnection);
                c = DriverManager.getConnection(jdbcConnection, username, password);
//            System.out.println("link success！" + c);
//            System.out.println("Java Database connection load ok!");
//            s = c.createStatement();
//            System.out.println("获取Statement对象" + s);
//            String sql = "";
//            sql = "SELECT * FROM hero";
//            ResultSet rs = s.executeQuery(sql);
//            while (rs.next()) {
//                int id = rs.getInt("id");
//                String name = rs.getString("name");
//                float hp = rs.getFloat("hp");
//                int damage = rs.getInt("damage");
//                System.out.println("英雄:" + name + ", 生命值:" + hp + "护甲" + damage);
//
//            }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
//            if (s != null) {
//                try {
//                    s.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (c != null) {
//                try {
//                    c.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
            }
        }

    }


    //    把一个Hero对象插入到数据库中
    public void add(Hero h) {
        try {
            String sql = "INSERT INTO hero values (null,?,?,?)";
            PreparedStatement ps = c.prepareStatement(sql);

            int id = h.getId();
            String name = h.getName();
            float hp = h.getHp();
            int damage = h.getDamage();

            ps.setString(1, name);
            ps.setFloat(2, hp);
            ps.setInt(3, damage);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //    把这个Hero对象对应的数据删除掉
    public void delete(Hero h) {
        int id = h.getId();
        String sql = "DELETE from hero where id = ?";
        try {
            PreparedStatement ps = c.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    更新这条Hero对象
    public void update(Hero h) {
        try {
            String sql = "UPDATE hero set name = ?, hp = ?, damage = ? WHERE id = ?";

            PreparedStatement ps = c.prepareStatement(sql);

            int id = h.getId();
            String name = h.getName();
            float hp = h.getHp();
            int damage = h.getDamage();

            ps.setString(1, name);
            ps.setFloat(2, hp);
            ps.setInt(3, damage);
            ps.setInt(4, id);

            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //    把所有的Hero数据查询出来，转换为Hero对象后，放在一个集合中返回
    public ArrayList<Hero> list() {
        ArrayList<Hero> heros = new ArrayList();

        String sql = "SELECT * FROM hero";
        Statement s = null;
        try {
            s = c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()) {
                Hero h = new Hero();
                h.setId(rs.getInt("id"));
                h.setName(rs.getString("name"));
                h.setHp(rs.getFloat("hp"));
                h.setDamage(rs.getInt("damage"));
                heros.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return heros;
    }

}
