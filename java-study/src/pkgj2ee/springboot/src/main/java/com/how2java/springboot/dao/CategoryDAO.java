package com.how2java.springboot.dao;

import com.how2java.springboot.pojo.Category;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//增加一个包：com.how2java.springboot.dao，然后创建dao接口CategoryDAO，继承了JpaRepository，并且提供泛型<Category,Integer> 表示这个是针对Category类的DAO,Integer表示主键是Integer类型。
//        JpaRepository 这个父接口，就提供了CRUD, 分页等等一系列的查询了，直接拿来用，都不需要二次开发的了。
public interface CategoryDAO extends JpaRepository<Category, Integer> {
    public List<Category> findByName(String name);

    public List<Category> findByNameLikeAndIdGreaterThanOrderByNameAsc(String name, int id);
}
