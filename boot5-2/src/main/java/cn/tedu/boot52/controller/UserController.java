package cn.tedu.boot52.controller;

import cn.tedu.boot52.entity.User;
import cn.tedu.boot52.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/login")
    public int login(@RequestBody User user, HttpServletResponse response){
        System.out.println("user = " + user);

        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                //判断是否需要记住用户名和密码
                if (user.isRem()){
                    //创建Cookie记住用户名和密码
                    Cookie c1 = new Cookie("username",user.getUsername());
                    Cookie c2 = new Cookie("password",user.getPassword());
                    //把cookie下发给客户端
                    response.addCookie(c1);
                    response.addCookie(c2);
                }
                return 1;
            }
            return 3;
        }
        return 2;
    }
}
