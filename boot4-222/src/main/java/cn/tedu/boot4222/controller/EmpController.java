package cn.tedu.boot4222.controller;

import cn.tedu.boot4222.entity.Emp;
import cn.tedu.boot4222.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @Autowired(required = false)
    EmpMapper mapper;

    @RequestMapping("/insert")
    public void insert(Emp emp){
        System.out.println("emp = " + emp);
        mapper.insert(emp);
    }
}
