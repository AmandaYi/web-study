package com.how2java.springboot.web;

//import com.how2java.springboot.dao.CategoryDAO;

import com.how2java.springboot.dao.CategoryDAO;
import com.how2java.springboot.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.PageRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

// JPA模式
@Controller
public class CategoryController {
    @Autowired
    CategoryDAO categoryDAO;

    public List<Category> listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        start = start < 0 ? 0 : start;

//        start = 0;
//        size = 2;
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Pageable pageable = PageRequest.of(start, size, sort);

        Page<Category> page = categoryDAO.findAll(pageable);

        m.addAttribute("page", page);

//        return "listCategory";
        return page.getContent();
    }

    @PostMapping("/categories")
    public String addCategory(Category c) throws Exception {
        categoryDAO.save(c);
        return "redirect:/categories";
    }

    @DeleteMapping("/categories/{id}")
    public String deleteCategory(Category c) throws Exception {
        categoryDAO.delete(c);
        return "redirect:/categories";
    }

//    @PutMapping("/categories/{id}")
//    public String updateCategory(Category c) throws Exception {
//        categoryDAO.save(c);
//        return "redirect:/categories";
//    }

//    @GetMapping("/categories/{id}")
//    public String getCategory(@PathVariable("id") int id, Model m) throws Exception {
//        Category c = categoryDAO.getById(id);
//        m.addAttribute("c", c);
//        return "editCategory";
//    }

    @GetMapping("/category/{id}")
    public Category getCategory(@PathVariable("id") int id) throws Exception {
        Category c= categoryDAO.getOne(id);
        System.out.println(c);
        return c;
    }

    @PutMapping("/category")
    public void addCategory1(@RequestBody Category category) throws Exception {
        System.out.println("springboot接受到浏览器以JSON格式提交的数据："+category);
    }

}

//MyBatis模式
//@Controller
//public class CategoryController {
//    @Autowired
//    CategoryMapper categoryMapper;
//
//    @RequestMapping("/listCategory")
//    public String listCategory(Model m) throws Exception {
//        List<Category> cs = categoryMapper.findAll();
//        m.addAttribute("cs", cs);
//        return "listCategory";
//    }
//}

