package com.community.demo.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
//@EnableWebMvc 会有一个方法自动加载系统默认路径，把我们的路径覆盖掉，导致加载不出css等静态文件
public class Webconfig implements WebMvcConfigurer {

    @Autowired
    private SessionInterceptor sessionInterceptor;//使用spring的依赖自动注入，否则sessionIntercept接受不到UserMapper


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sessionInterceptor).addPathPatterns("/**");
    }
}
