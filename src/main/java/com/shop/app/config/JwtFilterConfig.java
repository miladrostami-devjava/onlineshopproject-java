package com.shop.app.config;

import com.shop.app.config.filters.JwtRequestFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class JwtFilterConfig {

/*    @Autowired
    private JwtRequestFilter jwtRequestFilter;*/

/*    @Bean
    public FilterRegistrationBean<JwtRequestFilter> jwtFilterRegister() {
        FilterRegistrationBean<JwtRequestFilter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setName("jwtFilter");
        filterRegistrationBean.setFilter(jwtRequestFilter);
        filterRegistrationBean.addUrlPatterns("/api/*");
        filterRegistrationBean.setOrder(1);
        return filterRegistrationBean;

    }*/
}
