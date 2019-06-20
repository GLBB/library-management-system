package cn.gl.librarymanagementsystem.config;

import cn.gl.librarymanagementsystem.interceptor.BookAdminInteceptor;
import cn.gl.librarymanagementsystem.interceptor.SystemAdminInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class InteceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BookAdminInteceptor()).addPathPatterns("/bookadmin/**");
        registry.addInterceptor(new SystemAdminInterceptor()).addPathPatterns("/systemadmin/**");
    }
}
