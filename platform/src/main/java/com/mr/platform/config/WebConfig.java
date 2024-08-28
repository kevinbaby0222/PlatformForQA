package com.mr.platform.config;

import com.mr.platform.intercepetor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor()).addPathPatterns();
    }

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")  // 对所有路径应用此CORS配置
                        .allowedOrigins("http://10.8.71.7:3000")  // 允许的源
                        .allowedMethods("GET", "POST", "PUT", "DELETE")  // 允许的HTTP方法
                        .allowedHeaders("*")  // 允许的HTTP请求头
                        .allowCredentials(true);  // 允许发送Cookie
            }
        };
    }
}