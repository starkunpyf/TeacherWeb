package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Demo02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入英雄名");
        String name = sc.nextLine();
        System.out.println("请输入价格");
        double money = sc.nextDouble();
        //获取数据库连接
        try (Connection conn = DBUtils.getConn()){
            //创建执行SQL语句的对象
            Statement s = conn.createStatement();
            s.executeUpdate("insert into hero values(null,'"+name+"',"+money+")");
            System.out.println("添加完成!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
