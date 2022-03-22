package cn.tedu.boot52.mapper;

import cn.tedu.boot52.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

    @Select("select password from user where username=#{username}")
    User selectByUsername(String username);
}
