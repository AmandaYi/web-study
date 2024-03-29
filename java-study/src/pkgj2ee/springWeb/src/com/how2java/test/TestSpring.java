package com.how2java.test;

import com.how2java.pojo.Product;
import com.how2java.service.ProductService;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.how2java.pojo.Category;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });

//        Category c = (Category) context.getBean("c");
//
//        System.out.println(c.getName());
//
//        Product p = (Product) context.getBean("p");
//
//        p.setName("产品名称");
//
//        System.out.println(p.getName());
//        System.out.println(p.getCategory().getName());

        ProductService s = (ProductService) context.getBean("s");
        s.doSomeService();
    }
}