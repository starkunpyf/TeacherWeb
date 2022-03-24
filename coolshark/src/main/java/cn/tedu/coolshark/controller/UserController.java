package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.entity.User;
import cn.tedu.coolshark.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;
    @RequestMapping("/login")
    public int login(@RequestBody User user){
        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                return 1;//登录成功
            }
            return 3;//密码错误
        }
        return 2;//用户名不存在
    }
}
