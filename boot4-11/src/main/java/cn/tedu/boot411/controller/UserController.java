package cn.tedu.boot411.controller;

import cn.tedu.boot411.entity.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/reg")
    public String reg(User user){


        return "注册成功!";
    }
}
