package br.com.treinaweb.backend.api.common.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class corsConfig implements WebMvcConfigurer{

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
            .allowedOrigins("*")
                .allowedMethods("*")
                    .allowedHeaders("*");
    }
    
}
