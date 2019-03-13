package com.apifan.framework.aliyunsms;

import com.apifan.framework.aliyunsms.component.AliyunSmsHelper;
import com.apifan.framework.aliyunsms.config.AliyunSmsProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类
 *
 * @author yinzl
 */
@Configuration
@ConditionalOnProperty(prefix = "aliyunsms", name = "access-key-id")
@EnableConfigurationProperties(AliyunSmsProperties.class)
@ComponentScan(basePackages = "com.apifan.framework.aliyunsms")
public class AliyunSmsAutoConfiguration {

    private final AliyunSmsProperties aliyunSmsProperties;

    public AliyunSmsAutoConfiguration(final AliyunSmsProperties aliyunSmsProperties) {
        this.aliyunSmsProperties = aliyunSmsProperties;
    }

    /**
     * 阿里云短信辅助工具
     *
     * @return
     */
    @Bean
    public AliyunSmsHelper aliyunSmsHelper() {
        final AliyunSmsHelper helper = new AliyunSmsHelper(aliyunSmsProperties);
        helper.init();
        return helper;
    }
}
