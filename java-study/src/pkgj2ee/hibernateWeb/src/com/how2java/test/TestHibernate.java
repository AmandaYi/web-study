package com.how2java.test;

import com.how2java.pojo.Category;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.how2java.pojo.Product;

import java.util.List;

public class TestHibernate {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

//        String name = "iphone";
//        Query q = s.createQuery("from Product p where p.name like ?");
//        q.setString(0, "%" + name + "%");
//        List<Product> ps = q.list();
//        for( Product p : ps) {
//            System.out.printf(p.getName());
//        }
//        s.getTransaction().commit();
//        s.close();
//        sf.close();
        Category c =new Category();
        c.setName("c1");
        s.save(c);

        Product p = (Product) s.get(Product.class, 8);
        p.setCategory(c);
        s.update(p);
//        Product p = (Product) s.get(Product.class, 6);
//        System.out.printf("id = 6的产品名称是: " + p.getName());
//        s.getTransaction().commit();
//        s.close();
//        sf.close();

//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session s = sf.openSession();
//        s.beginTransaction();
//        for(int i = 0 ; i < 5; i ++) {
//            // 瞬时的
//            Product p = new Product();
//            p.setName("iphone" + i);
//            p.setPrice(7000);
//            // Session的save把该对象保存在了数据库中，该对象也和Session之间产生了联系，此时状态是持久的
//            s.save(p);
//        }
//        s.getTransaction().commit();
//        // Session关闭了，这个对象在数据库中虽然有对应的数据，但是已经和Session失去了联系，相当于脱离了管理，状态就是脱管的
//        s.close();
//        sf.close();
    }
}
