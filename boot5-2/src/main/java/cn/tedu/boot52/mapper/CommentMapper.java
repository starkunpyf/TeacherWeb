package cn.tedu.boot52.mapper;

import cn.tedu.boot52.entity.Comment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Insert("insert into comment values(null,#{content},#{nick},#{weiboId})")
    void insert(Comment comment);

    @Select("select * from comment where weibo_id=#{weiboId}")
    List<Comment> selectByWeiboId(int weiboId);

}
