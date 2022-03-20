package cn.tedu.boot42.controller;

import cn.tedu.boot42.entity.Emp;
import cn.tedu.boot42.mapper.EmpMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @Autowired(required = false)
    EmpMapper mapper;

    @RequestMapping("/insert")
    public void insert(Emp emp){
        mapper.insert(emp);
    }
}
