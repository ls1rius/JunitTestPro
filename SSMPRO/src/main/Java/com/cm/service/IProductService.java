package com.cm.service;

import com.cm.entity.Product;

import java.lang.reflect.Array;
import java.util.ArrayList;

public interface IProductService {
    ArrayList<Product> getProductOptions();
}
