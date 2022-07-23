package com.itheima.service;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class BrandService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();

    public List<Brand> selectAll() {

        //2.2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        //2.3 获取Mapper
        BrandMapper Mapper = sqlSession.getMapper(BrandMapper.class);
        //2.4 调用方法
        List<Brand> brands = Mapper.selectAll();
        //2.5 释放资源
        sqlSession.close();
        return brands;
    }
    public void add(Brand brand){
        //2.2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        //2.3 获取Mapper
        BrandMapper Mapper = sqlSession.getMapper(BrandMapper.class);
        //2.4 调用方法
         Mapper.add(brand);

        //提交事务
        sqlSession.commit();
        //2.5 释放资源
        sqlSession.close();

    }
    public Brand selectById(int id){
        //2.2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        //2.3 获取Mapper
        BrandMapper Mapper = sqlSession.getMapper(BrandMapper.class);
        //2.4 调用方法
        Brand brand = Mapper.selectById(id);

        //提交事务
        sqlSession.commit();
        //2.5 释放资源
        sqlSession.close();
        return brand;

    }
    public void update(Brand brand){
        //2.2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        //2.3 获取Mapper
        BrandMapper Mapper = sqlSession.getMapper(BrandMapper.class);
        //2.4 调用方法
         Mapper.update(brand);

        //提交事务
        sqlSession.commit();
        //2.5 释放资源
        sqlSession.close();


    }
    public void   delete(int id){
        //2.2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        //2.3 获取Mapper
        BrandMapper Mapper = sqlSession.getMapper(BrandMapper.class);
        //2.4 调用方法
        Mapper.delete(id);

        //提交事务
        sqlSession.commit();
        //2.5 释放资源
        sqlSession.close();


    }
}
