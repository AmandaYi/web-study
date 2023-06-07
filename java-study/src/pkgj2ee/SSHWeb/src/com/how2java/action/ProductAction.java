package com.how2java.action;

import com.how2java.pojo.Product;
import com.how2java.service.ProductService;

import java.util.List;
//这里可以理解为是控制器模式
//ProductAction提供对ProductService的注入，借助SSH的整合，ProductAction就充当非常单纯的控制层的角色：
public class ProductAction {
    private ProductService productService;
    private List<Product> products;

    public String list(){
        products = productService.list();
        return "listJSP";
    }

    public ProductService getProductService(){
        return productService;
    }
    public void setProductService(ProductService productService) {
        this.productService = productService;
    }
    public List<Product> getProducts() {
        return  products;
    }
    public void setProducts(List<Product> products) {
        this.products = products;
    }

}
