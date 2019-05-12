package com.cm.controller;

import com.cm.service.IProductService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;

@CrossOrigin(origins = "*",maxAge = 3600)
@Controller
@RequestMapping(value = "/product")
@ResponseBody
public class ProductController {

    @Resource(name="productService")
    private IProductService productService;

    @RequestMapping(value="/getProductOptions", method = RequestMethod.GET)
    public Object getProductOptions(){
        HashMap<String, Object>ans = new HashMap<>();
        ans.put("productsList",productService.getProductOptions());
        return ans;
    }
}
