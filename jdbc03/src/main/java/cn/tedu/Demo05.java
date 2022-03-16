package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        try (Connection conn = DBUtils.getConn()){
            String sql = "select password from user where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            //替换掉?
            ps.setString(1,username);
            //执行查询
            ResultSet rs = ps.executeQuery();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
