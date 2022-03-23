package cn.tedu.boot52.controller;

import cn.tedu.boot52.entity.User;
import cn.tedu.boot52.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {
    @Autowired(required = false)
    UserMapper mapper;

    @RequestMapping("/login")
    public int login(@RequestBody User user, HttpSession session, HttpServletResponse response){
        System.out.println("user = " + user);

        User u = mapper.selectByUsername(user.getUsername());
        if (u!=null){
            if (u.getPassword().equals(user.getPassword())){
                //登录成功后把从数据库里面查询到的用户对象保存到Session会话对象中
                session.setAttribute("user",u);



                //判断是否需要记住用户名和密码
                if (user.isRem()){
                    //创建Cookie记住用户名和密码
                    Cookie c1 = new Cookie("username",user.getUsername());
                    Cookie c2 = new Cookie("password",user.getPassword());
                    //设置Cookie保存数据的时长
                    c1.setMaxAge(60*60*24*30);
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
    @RequestMapping("/currentUser")
    public User currentUser(HttpSession session){
        //获取登录成功时保存的用户对象
        return (User) session.getAttribute("user");
    }
    @RequestMapping("/logout")
    public void logout(HttpSession session){
        //删除登录成功时保存的用户对象
        session.removeAttribute("user");
    }
}
