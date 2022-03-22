package cn.tedu.boot51.mapper;

import cn.tedu.boot51.entity.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeiboMapper {
    @Insert("insert into weibo values(null,#{content},#{urls})")
    void insert(Weibo weibo);

    @Select("select * from weibo")
    List<Weibo> select();

}
