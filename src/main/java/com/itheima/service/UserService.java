package com.itheima.service;


import com.itheima.mapper.UserMapper;
import com.itheima.pojo.User;
import com.itheima.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserService {

    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    public User longin(String username ,String password){
        //登入
        //2.2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        //2.3 获取Mapper
        UserMapper Mapper = sqlSession.getMapper(UserMapper.class);
        //调用方法
        User user = Mapper.select(username,password);
        sqlSession.close();
        return user;
    }
    public boolean register(User user){
        //登入
        //2.2 获取SqlSession对象
        SqlSession sqlSession = factory.openSession();
        //        //2.3 获取Mapper
        UserMapper Mapper = sqlSession.getMapper(UserMapper.class);
        //判断用户是否存在
        User u = Mapper.selectByUsername(user.getUsername());
        if (u==null) {
            //用户名不存在
            Mapper.add(user);
            sqlSession.commit();

        }
          sqlSession.close();
            return u == null;



    }
}
