import com.hans.mapper.BrandMapper;
import com.hans.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class Test {

    @org.junit.jupiter.api.Test
    public void test1() throws IOException {
//        1.获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        sqlSession.close();

    }


    @org.junit.jupiter.api.Test
    public void test2() throws IOException {
//        1.获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        Brand brand = mapper.selectById(3);
        System.out.println(brand);

        sqlSession.close();

    }

    @org.junit.jupiter.api.Test
    public void test3() throws IOException {
//        1.获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);
        Brand brand = new Brand();
        brand.setStatus(1);
        brand.setCompanyName("%华为%");
        brand.setBrandName("%华%");
        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition(brand);
        System.out.println(brands);

        sqlSession.close();

    }


    @org.junit.jupiter.api.Test
    public void test4() throws IOException {
//        1.获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);
        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" +companyName+"%";
        brandName = "%" +brandName+"%";

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition1(status,companyName,brandName);
        System.out.println(brands);

        sqlSession.close();

    }



    @org.junit.jupiter.api.Test
    public void test5() throws IOException {
//        1.获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);

        int status = 1;
        String companyName = "华为";
        String brandName = "华为";

        companyName = "%" +companyName+"%";
        brandName = "%" +brandName+"%";
        HashMap hashMap = new HashMap();
//        hashMap.put("status",status);
        hashMap.put("companyName",companyName);
//        hashMap.put("brandName",brandName);

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectByCondition2(hashMap);
        System.out.println(brands);

        sqlSession.close();

    }


    @org.junit.jupiter.api.Test
    public void test6() throws IOException {
//        1.获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);

        Brand brand = new Brand();
//        brand.setStatus(1);
//        brand.setCompanyName("%华为%");
//        brand.setBrandName("%华%");

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        List<Brand> brands = mapper.selectBySingleCondition(brand);
        System.out.println(brands);

        sqlSession.close();

    }


    @org.junit.jupiter.api.Test
    public void testadd1() throws IOException {
//        1.获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);

        Brand brand = new Brand();
        brand.setOrdered(34);
        brand.setBrandName("图森林");
        brand.setStatus(1);
        brand.setCompanyName("tusanlin");
        brand.setDescription("图森林，有你更精彩");

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int add = mapper.add(brand);
        Integer id = brand.getId();
        System.out.println(id);
        System.out.println(add);

        //手动提交事务
//        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }


    @org.junit.jupiter.api.Test
    public void testupdate() throws IOException {
//        1.获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);

        Brand brand = new Brand();
        brand.setId(12);
        brand.setOrdered(34234);
        brand.setBrandName("图森sdf林");
        brand.setStatus(0);
        brand.setCompanyName("tusasdfsdfnlin");
        brand.setDescription("图森林，sdfsdf有你更精彩");


        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int update = mapper.update(brand);
        System.out.println(update);


        //手动提交事务
//        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }


    @org.junit.jupiter.api.Test
    public void testupdate1() throws IOException {
//        1.获取sqlsessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);
//        List<Brand> brands = brandMapper.selectAll();
//        System.out.println(brands);

        Brand brand = new Brand();
        brand.setId(12);
//        brand.setOrdered(34234);
//        brand.setBrandName("图森sdf林");
//        brand.setStatus(0);
//        brand.setCompanyName("tusasdfsdfnlin");
        brand.setDescription("图森林，sdfsdf有ss你更精彩");

        BrandMapper mapper = sqlSession.getMapper(BrandMapper.class);
        int i = mapper.update1(brand);
        System.out.println(i);


        //手动提交事务
//        sqlSession.commit();
        //释放资源
        sqlSession.close();

    }
}
