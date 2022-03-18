package cn.tedu.boot32.controller;

import cn.tedu.boot32.entity.User;
import cn.tedu.boot32.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;
    @RequestMapping("/reg")
    public String reg(User user){
        System.out.println("user = " + user);
        return "";
    }
}
