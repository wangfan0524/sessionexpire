package com.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.io.InputStream;


public class MybatisUtil {

    private static SqlSessionFactory sqlSessionFactory;
    private static ThreadLocal<SqlSession> threadLocal =new ThreadLocal<>();

    static {
           ApplicationContext applicationContext = ApplicationContextUtil.getApplicationContext();
            System.out.println(applicationContext.getBeanDefinitionNames());
        sqlSessionFactory=applicationContext.getBean(SqlSessionFactory.class);

    }

    public static SqlSession getSession(){
        if (threadLocal.get() ==null){
            threadLocal.set(sqlSessionFactory.openSession());
        }
        return threadLocal.get();
    }

    public static void closeSession(){
        if (threadLocal.get() !=null){
            threadLocal.get().close();
        }
    }
}
