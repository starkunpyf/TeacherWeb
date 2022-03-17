package cn.tedu.boot21.controller;

import cn.tedu.boot21.entity.User;
import cn.tedu.boot21.utils.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//相当于在Controller注解基础上 给所有方法都添加了 @ResponseBody注解
@RestController
public class UserController {
    @RequestMapping("/reg")
    public String reg(User user){
        System.out.println("user = " + user);
        //获取数据库连接
        try (Connection conn = DBUtils.getConn()){
            String sql = "insert into user values(null,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getNick());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "注册成功!";
    }
}
