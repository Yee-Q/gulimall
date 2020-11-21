package com.zk.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author yeeq
 * @date 2020/11/19
 */
@Configuration
public class GulimallCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter() {
        // 配置跨域请求信息
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 配置允许所有请求头跨域
        corsConfiguration.addAllowedHeader("*");
        // 配置允许所有请求方式跨域
        corsConfiguration.addAllowedMethod("*");
        // 配置允许所有请求来源跨域
        corsConfiguration.addAllowedOrigin("*");
        // 配置允许携带 cookie 跨域
        corsConfiguration.setAllowCredentials(true);
        // 对任意路径进行跨域配置
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }
}
