package com.fancv;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.fancv.*"}, exclude = {DataSourceAutoConfiguration.class})
@ServletComponentScan(basePackages = {"com.fancv.filter", "com.fancv.listener"})
@EnableSwagger2
@MapperScan("com.fancv.dao")
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }


}
