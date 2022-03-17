package cn.tedu.boot21.controller;

import cn.tedu.boot21.entity.User;
import cn.tedu.boot21.utils.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

    @RequestMapping("/login")
    public String login(User user){
        System.out.println("user = " + user);
        //获取数据库连接
        try (Connection conn = DBUtils.getConn()){
            //准备通过用户名查询密码的SQL语句
            String sql = "select password from user where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //替换?为用户名
            ps.setString(1,user.getUsername());
            ResultSet rs = ps.executeQuery();
            //判断是否查询到了内容
            if (rs.next()){
                //得到查询回来的正确密码
                String pw = rs.getString(1);
                //拿用户输入的密码和正确密码判断是否一样
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "登录成功!";
    }
}
