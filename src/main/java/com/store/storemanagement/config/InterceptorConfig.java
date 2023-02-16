package com.store.storemanagement.config;

import com.store.storemanagement.common.interceptor.JwtInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor())
                .addPathPatterns("/**") //拦截所有请求，通过判断token是否合法来决定是否登录
                .excludePathPatterns("/user/login","/user/register"); //排除拦截
    }

    @Bean
    public JwtInterceptor jwtInterceptor(){
        return new JwtInterceptor();
    }
}
