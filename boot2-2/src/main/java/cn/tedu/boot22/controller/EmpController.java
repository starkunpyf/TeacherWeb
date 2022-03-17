package cn.tedu.boot22.controller;

import cn.tedu.boot22.entity.Emp;
import cn.tedu.boot22.utils.DBUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@RestController
public class EmpController {

    @RequestMapping("/insert")
    public String insert(Emp emp){
        System.out.println("emp = " + emp);
        //获取数据库连接 把员工信息保存到数据库myemp表中
        try (Connection conn = DBUtils.getConn()){
            String sql = "insert into myemp values(null,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,emp.getName());
            ps.setInt(2,emp.getSal());
            ps.setString(3,emp.getJob());
            ps.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "添加完成!";
    }
}
