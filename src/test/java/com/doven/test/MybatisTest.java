package com.doven.test;

import com.doven.dao.IUserDao;
import com.doven.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author dyt
 * @version 1.0
 * @date 2021/5/19 22:28
 */
public class MybatisTest {
    public static void main(String[] args) throws Exception{
        //加载主配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");

        //创建sqlsessionfacorybuilder
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        //创建sqlsessionfactory
        SqlSessionFactory factory = builder.build(is);
        //创建sqlsession
        SqlSession sqlSession = factory.openSession();

        //得到代理对象,此处使用jdk动态代理
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);



        //调用方法
        List<User> users = userDao.findAll();

        //处理结果集
        for (User user : users) {
            System.out.println(user);
        }

        //关闭资源
        sqlSession.close();
        is.close();
    }
}
