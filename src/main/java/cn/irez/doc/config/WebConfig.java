package cn.irez.doc.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // 允许跨域访问的路径
        registry.addMapping("/**")
                // 允许跨域访问的源
                .allowedOriginPatterns("*")
                // 允许请求方法
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                // 预检请求的有效期，单位为秒
                .maxAge(3600)
                // 允许携带cookie
                .allowCredentials(true);
    }

}
