package com.cm.service.impl;

import com.cm.dao.IProductDao;
import com.cm.entity.Product;
import com.cm.service.IProductService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;

@Service("productService")
public class ProductServiceImpl implements IProductService{

    @Resource
    private IProductDao productDao;
    @Override
    public ArrayList<Product> getProductOptions() {
        return productDao.getProductOptions();
    }
}
