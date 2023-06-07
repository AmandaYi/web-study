package com.how2java.dao;

import com.how2java.pojo.Product;

import java.util.List;

public interface ProductDAO {
    public List<Product> list();
    public void add(Product p);

}
