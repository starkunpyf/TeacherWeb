package cn.tedu.boot52.mapper;

import cn.tedu.boot52.entity.Weibo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeiboMapper {
    @Insert("insert into weibo values(null,#{content},#{urls}," +
            "#{nick},#{created},#{userId})")
    void insert(Weibo weibo);

    @Select("select * from weibo order by created desc")
    List<Weibo> select();

    @Select("select * from weibo where id=#{id}")
    Weibo selectById(int id);

    @Select("select * from weibo where user_id=#{id}")
    List<Weibo> selectByUserId(Integer id);

    @Delete("delete from weibo where id=#{id}")
    void deleteById(int id);
}
