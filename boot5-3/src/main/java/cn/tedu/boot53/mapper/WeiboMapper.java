package cn.tedu.boot53.mapper;

import cn.tedu.boot53.entity.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WeiboMapper {
    @Insert("insert into weibo values(null,#{content},#{urls})")
    void insert(Weibo weibo);
}
