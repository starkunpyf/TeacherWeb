package cn.tedu.boot24.controller;

import cn.tedu.boot24.entity.Emp;
import cn.tedu.boot24.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    //把EmpMapper装配进来
    @Autowired(required = false)
    EmpMapper mapper;

    @RequestMapping("/insert")
    public String insert(Emp emp){
        mapper.insert(emp);
        return "添加完成!";
    }




}
