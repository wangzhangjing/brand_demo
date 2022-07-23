package com.itheima.mapper;


import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface BrandMapper {


    @Select("select * from tb_brand")

    List<Brand> selectAll();

    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    void add(Brand brand);
    //id查询
    @Select("select * from tb_brand where id=#{id}")

    Brand selectById(int id);
    @Update("update tb_brand set brandName=#{brandName},companyName=#{companyName},ordered=#{ordered},description=#{description},status=#{status} where id =#{id}")
    void update(Brand brand);

    @Delete("delete from tb_brand where id=#{id}")
    void delete(int id);

}
