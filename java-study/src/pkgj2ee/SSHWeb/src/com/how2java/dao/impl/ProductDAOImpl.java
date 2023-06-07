package com.how2java.dao.impl;

import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Product;
import org.springframework.orm.hibernate3.HibernateTemplate;

import java.util.List;

public class ProductDAOImpl extends HibernateTemplate implements ProductDAO {
    @Override
    public List<Product> list() {
        return this.find("from Product");
    }

    @Override
    public void add(Product p) {
        this.save(p);
    }
}
