package cn.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) {
        //  创建一个hero表 有id,name,money  三个字段
        try (Connection conn = DBUtils.getConn()){
            //创建执行SQL语句的对象
            Statement s = conn.createStatement();
            //执行创建表的SQL语句
            s.execute("create table hero(id int primary key auto_increment," +
                    "name varchar(20),money double(10,2))");
            System.out.println("创建完成!");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
