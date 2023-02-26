package com.hans;

import com.hans.mapper.BrandMapper;
import com.hans.mapper.UserMapper;
import com.hans.pojo.Brand;
import com.hans.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatisdemo2 {
    public static void main(String[] args) throws IOException {
        //        1.加载mybatis核心配置文件
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

//        2.获取sqlsession对象，用它来执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        3，执行sql
//        List<User> User = sqlSession.selectList("user.selectAllUser");

//        3.1获取UserMapper接口的代理对象
//        UserMapper usermapper = sqlSession.getMapper(UserMapper.class);
//        List<Brand> brands = usermapper.selectAll();
//        System.out.println(brands);
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectAll();
        System.out.println(brands);

//        4,释放资源
        sqlSession.close();
    }

}
