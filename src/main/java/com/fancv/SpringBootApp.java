package com.fancv;


import com.fancv.config.GuavaConfig;
import com.fancv.config.MyConfig;
import com.fancv.config.PooledHttpClientFactory;
import com.google.common.math.IntMath;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.context.annotation.Import;
import org.springframework.jmx.support.RegistrationPolicy;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.fancv.*", "com.google.common.*"}, exclude = {DataSourceAutoConfiguration.class})
@ServletComponentScan(basePackages = {"com.fancv.filter", "com.fancv.listener"})
@EnableSwagger2
@MapperScan("com.fancv.dao")
@Import({MyConfig.class, GuavaConfig.class, IntMath.class, PooledHttpClientFactory.class})
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)
public class SpringBootApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootApp.class, args);
    }
}
