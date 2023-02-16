package com.store.storemanagement.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

//解决前端跨域问题
@Configuration
public class CorsConfig {
    //设置一天有效时长
    private static final long MAX_AGE=24*60*60;

//    private CorsConfiguration buildConfig(){
//        CorsConfiguration corsConfiguration=new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("*");//设置访问源地址
//        corsConfiguration.addAllowedHeader("*");//设置访问源请求头
//        corsConfiguration.addAllowedMethod("*");//设置访问源请求方法
//        corsConfiguration.setMaxAge(MAX_AGE);
//        return corsConfiguration;
//    }

    @Bean
    public CorsFilter corsFilter(){
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration=new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("http://localhost:8080");//设置访问源地址
        corsConfiguration.addAllowedHeader("*");//设置访问源请求头
        corsConfiguration.addAllowedMethod("*");//设置访问源请求方法
        corsConfiguration.setMaxAge(MAX_AGE);
        source.registerCorsConfiguration("/**",corsConfiguration);//对接口配置跨域设置
        return new CorsFilter(source);
    }
}
