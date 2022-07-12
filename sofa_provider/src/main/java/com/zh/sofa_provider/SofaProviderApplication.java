package com.zh.sofa_provider;

import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.zh.sofa_provider.mapper")
@NacosPropertySource(dataId = "nacos_sofa_demo_provider", groupId="sofa_demo",autoRefreshed = true)
public class SofaProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(SofaProviderApplication.class, args);
    }
}
