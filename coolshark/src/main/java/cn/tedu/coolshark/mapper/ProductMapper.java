package cn.tedu.coolshark.mapper;

import cn.tedu.coolshark.entity.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {
    @Insert("insert into product values(null,#{title},#{url},#{price},#{oldPrice}" +
            ",0,#{saleCount},#{created},#{categoryId})")
    void insert(Product product);


}
