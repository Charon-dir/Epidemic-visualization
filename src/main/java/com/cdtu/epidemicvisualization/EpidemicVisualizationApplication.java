package com.cdtu.epidemicvisualization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;



@SpringBootApplication(exclude= {SecurityAutoConfiguration.class })
@MapperScan("com.cdtu.epidemicvisualization.dao")
public class EpidemicVisualizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(EpidemicVisualizationApplication.class, args);
    }

}
