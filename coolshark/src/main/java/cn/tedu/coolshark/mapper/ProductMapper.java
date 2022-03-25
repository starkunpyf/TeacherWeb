package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{url},#{price},#{oldPrice}" +
            ",0,#{saleCount},#{created},#{categoryId})")
    void insert(Product product);

    //Result注解的作用是当属性名和表字段名不一致时进行的指定
    @Select("select id,title,url,price,sale_count,view_count,created from product")
    @Result(column = "sale_count",property = "saleCount")
    @Result(column = "view_count",property = "viewCount")
    List<Product> selectAdmin();

    @Select("select url from product where id=#{id}")
    String selectUrlById(int id);

    @Delete("delete from product where id=#{id}")
    void deleteById(int id);

}
