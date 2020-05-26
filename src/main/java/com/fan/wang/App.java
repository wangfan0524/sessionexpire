package com.fan.wang;

import com.dto.ClmStatementRela;
import com.mapper.ClmStatementRelaMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.Queue;
import sun.rmi.runtime.Log;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.CountDownLatch;

/**
 * Hello world!
 *
 */

public class App 
{
    static ThreadLocal<String> threadLocal = new ThreadLocal<>();
    public static void main( String[] args ) throws IOException, InterruptedException {
        /*Logger logger = LoggerFactory.getLogger(App.class);
        String path="spring/mybatis.xml";
        InputStream inputStream = Resources.getResourceAsStream(path);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=sqlSessionFactory.openSession();
        System.out.println(sqlSession);
        ClmStatementRelaMapper mapper = sqlSession.getMapper(ClmStatementRelaMapper.class);

        List<ClmStatementRela>  clmStatementRelas5= sqlSession.selectList("com.mapper.ClmStatementRelaMapper.selectLocal",101);
        List<ClmStatementRela> clmStatementRelas = mapper.selectLocal(101);

        //清除缓存后，相同的SQL会重复执行，不清除的情况下，相同的SQL只会执行一次
        sqlSession.clearCache();

        Map map = new HashMap<>();
        map.put("row",100);
        List<ClmStatementRela> clmStatementRelas4 = mapper.selectLocal2(map);
        logger.error("我错了");*/


        final CountDownLatch countDownLatch =new CountDownLatch(1);


        new Thread(){
            public void run(){
                threadLocal.set("测试啦");

                System.out.println(threadLocal.get());
                countDownLatch.countDown();
            }
        }.start();
        countDownLatch.await();
        System.out.println(threadLocal.get());
    }

}
