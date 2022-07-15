package com.zh.sofa_consumer;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@NacosPropertySource(dataId = "nacos_sofa_demo_consumer", groupId="sofa_demo",autoRefreshed = true)
public class SofaConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(SofaConsumerApplication.class, args);
    }
}
