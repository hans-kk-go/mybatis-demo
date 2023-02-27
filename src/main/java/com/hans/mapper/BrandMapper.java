package com.hans.mapper;

import com.hans.pojo.Brand;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface BrandMapper {
//    List<com.itheima.pojo.Brand> selectAll();
    List<Brand> selectAll();
    Brand selectById(int id);

    List<Brand> selectByCondition(Brand brand);
    List<Brand> selectByCondition1(@Param("status")int status,@Param("companyName")String companyName,@Param("brandName") String brandName);
    List<Brand> selectByCondition2(Map map);

    List<Brand> selectBySingleCondition(Brand brand);

    int add(Brand brand);

    int update(Brand brand);

    int update1(Brand brand);


    int deleteById(int id);
}
