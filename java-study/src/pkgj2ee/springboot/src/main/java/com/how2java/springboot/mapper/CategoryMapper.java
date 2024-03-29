package com.how2java.springboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.how2java.springboot.pojo.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {

    @Select("select * from category_ ")
    List<Category> findAll();

}