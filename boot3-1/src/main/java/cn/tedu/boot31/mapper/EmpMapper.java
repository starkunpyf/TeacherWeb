package cn.tedu.boot31.mapper;

import cn.tedu.boot31.entity.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpMapper {
    @Insert("insert into myemp values(null,#{name},#{sal},#{job})")
    void insert(Emp emp);

    //@Select是查询的注解,返回值为集合,Mybatis框架生成的jdbc代表会
    //将查询到的数据封装到Emp对象中,然后把Emp对象装进list集合 通过方法返回
    @Select("select * from myemp")
    List<Emp> select();

}
