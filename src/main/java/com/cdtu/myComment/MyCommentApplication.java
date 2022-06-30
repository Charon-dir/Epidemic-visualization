package com.cdtu.myComment;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
@MapperScan("com.cdtu.MyComment.dao")
@EnableRedisHttpSession
public class MyCommentApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyCommentApplication.class, args);

    }


}
