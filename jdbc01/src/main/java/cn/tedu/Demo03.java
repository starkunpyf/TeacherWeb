package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03 {
    public static void main(String[] args) throws SQLException {
        Connection conn =  DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empdb?" +
                        "characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root","root");
        Statement s = conn.createStatement();
        //执行插入数据SQL
        //s.executeUpdate("insert into emp(name) values('Tom')");
        //执行修改数据的SQL
//        s.executeUpdate("update emp set name='Jerry' where name='Tom'");
        //执行删除
        s.executeUpdate("delete from emp where name='Jerry'");
        conn.close();
        System.out.println("执行完成!");
    }
}
