package cn.tedu.boot32.mapper;

import cn.tedu.boot32.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    //注册方法
    @Insert("insert into user values(null,#{username},#{password},#{nick})")
    void insert(User user);

    //登录方法 通过用户名查询到密码 并且把密码封装到了User对象里面
    @Select("select password from user where username=#{username}")
    User selectByUsername(String username);

}
