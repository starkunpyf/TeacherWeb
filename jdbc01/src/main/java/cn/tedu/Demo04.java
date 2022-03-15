package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo04 {
    public static void main(String[] args) {
        //获取连接 如果下面代码报错 alt+回车 选择 set language level to 7
        try (Connection conn = DBUtils.getConn()){
            //创建执行SQL语句对象
            Statement s = conn.createStatement();
            //执行查询
            ResultSet rs = s.executeQuery("select name from emp");
            while(rs.next()){
                String name = rs.getString(1);
                System.out.println(name);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
