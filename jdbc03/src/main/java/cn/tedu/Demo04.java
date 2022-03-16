package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();
        try (Connection conn = DBUtils.getConn()){
            Statement s = conn.createStatement();
            ResultSet rs =
                    s.executeQuery("select count(*) from user where username='"
                            +username+"' and password='"+password+"'");
            //结果集对象 游标默认没有指向任何一条数据
            rs.next(); //游标下移指向查询到的数量
            int count = rs.getInt(1);
            if (count>0){
                System.out.println("登录成功");
            }else System.out.println("用户名或密码错误!");

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
