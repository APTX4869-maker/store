package com.cy.store;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//todo 这个exclude排除检查数据库配置 后续配置mysql后再去掉 (exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
@MapperScan("com.cy.store.mapper") //指定当前项目中mapper接口路径位置，在项目启动时候会启动加载所有接口
public class StoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

}
