package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.Product;
import cn.tedu.coolshark.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
public class ProductController {
    @Autowired(required = false)
    ProductMapper mapper;

    @RequestMapping("/product/insert")
    public void insert(@RequestBody Product product){
        System.out.println("product = " + product);
        product.setCreated(new Date());

        mapper.insert(product);
    }
    @RequestMapping("/product/select/admin")
    public List<Product> selectAdmin(){
        return mapper.selectAdmin();
    }
}
