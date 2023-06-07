package com.how2java.springboot.test;

import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import java.util.Optional;

//Junit5使用ExtendWith加载Spring测试模块
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class TestJPA {

    @Autowired
    CategoryDAO dao;

    @BeforeEach
    public void before() {
        List<Category> cs = dao.findAll();
        for (Category c : cs) {
            dao.delete(c);
        }

        for (int i = 0; i < 10; i++) {
            Category c = new Category();
            c.setName("category" + i);
            dao.save(c);
        }
    }

    @Test
    public void test1() {
        List<Category> cs = dao.findAll();
        System.out.println("所有的分类信息：");
        for (Category c : cs) {
            System.out.println(c.getName());
        }
        System.out.println();
    }

    @Test
    public void test2() {
        System.out.println("查询名称是 \"category 1 \"的分类:");
        List<Category> cs = dao.findByName("category 1");
        for (Category c : cs) {
            System.out.println("c.getName():" + c.getName());
        }
    }

    @Test
    public void test3() {
        System.out.println("根据名称模糊查询，id 大于5, 并且名称正排序查询");
        List<Category> cs = dao.findByNameLikeAndIdGreaterThanOrderByNameAsc("%3%", 5);
        for (Category c : cs) {
            System.out.println(c);
        }

    }
}