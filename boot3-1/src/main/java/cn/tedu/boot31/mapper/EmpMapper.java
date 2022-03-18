package cn.tedu.boot31.mapper;

import cn.tedu.boot31.entity.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpMapper {
    @Insert("insert into myemp values(null,#{name},#{sal},#{job})")
    void insert(Emp emp);

}
