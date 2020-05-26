package com.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ApplicationContextUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        if (applicationContext!=null){
            this.applicationContext=applicationContext;
        }
    }

    public static ApplicationContext getApplicationContext() throws BeansException {

        if ( applicationContext!=null){
            return  applicationContext;
        }else {
            return null;
        }
    }
}
