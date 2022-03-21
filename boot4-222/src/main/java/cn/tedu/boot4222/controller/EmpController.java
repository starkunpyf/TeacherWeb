package cn.tedu.boot4222.controller;

import cn.tedu.boot4222.entity.Emp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @RequestMapping("/insert")
    public void insert(Emp emp){
        System.out.println("emp = " + emp);
    }
}
