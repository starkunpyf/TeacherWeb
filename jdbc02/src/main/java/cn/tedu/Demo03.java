package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03 {
    public static void main(String[] args) {
        //在里面查询出英雄表的所有信息并在控制台输出
        try(Connection conn = DBUtils.getConn()) {
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery("select * from hero");
            while (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                double money = rs.getDouble(3);
                System.out.println(id+":"+name+":"+money);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
