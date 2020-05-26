package com.utils;

import org.apache.ibatis.session.SqlSession;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(urlPatterns = "/test")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        SqlSession sqlSession = MybatisUtil.getSession();
        try {
            filterChain.doFilter(servletRequest,servletResponse);
            sqlSession.commit();
        } catch (Exception e){
            sqlSession.rollback();
        }finally {
            MybatisUtil.closeSession();
        }
    }

    @Override
    public void destroy() {
        System.out.println("销魂");
    }
}
