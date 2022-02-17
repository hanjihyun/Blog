package com.springboot.blog;

import com.springboot.blog.config.auth.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

//@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
@EnableConfigurationProperties(AppProperties.class)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
