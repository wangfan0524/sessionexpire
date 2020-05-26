package com.conf;

import com.utils.MyFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class MyConf {

    @Bean
    public Filter getFilter(){
        return new MyFilter();
    }
}

