package cn.tedu;

import java.sql.*;

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
//        s.executeUpdate("delete from emp where name='Jerry'");
        //执行查询
        ResultSet rs = s.executeQuery("select name,sal from emp");
        //遍历结果集对象 rs.next()让游标往下移动一格 并且返回true或false true代表有下一条数据
        while(rs.next()){
            String name = rs.getString("name");
            double sal = rs.getDouble("sal");
            System.out.println(name+":"+sal);
        }
        conn.close();
        System.out.println("执行完成!");
    }
}
