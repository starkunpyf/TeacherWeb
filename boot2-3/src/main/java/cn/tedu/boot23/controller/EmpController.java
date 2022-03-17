package cn.tedu.boot23.controller;

import cn.tedu.boot23.entity.Emp;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpController {
    @RequestMapping("/insert")
    public String insert(Emp emp){
        System.out.println("emp = " + emp);

        return "添加完成!";
    }
}
