package com.sy.biz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

@EnableDiscoveryClient
@SpringBootApplication
public class Application {
    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(Application.class, args);
//
//
//        ConfigurableApplicationContext applicationContext = SpringApplication.run(Application.class, args);
//        while(true) {
//            //当动态配置刷新时，会更新到 Enviroment中，
//            //因此这里每隔一秒中从Enviroment中获取配置
//
//            String userName = applicationContext.getEnvironment().getProperty("user.name");
//            System.err.println("user name :"+userName);
//            TimeUnit.SECONDS.sleep(1);
//        }
    }
}

