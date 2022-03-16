package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        try (Connection conn = DBUtils.getConn()){
            Statement s = conn.createStatement();
            s.executeUpdate("insert into user values(null,'"
                    +username+"','"+password+"',null)");
            System.out.println("注册完成!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
