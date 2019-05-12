package com.cm.dao;

import com.cm.entity.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IProductDao {
    ArrayList<Product> getProductOptions();
}
