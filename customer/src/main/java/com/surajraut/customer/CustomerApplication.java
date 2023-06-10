package com.surajraut.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;

@SpringBootApplication(scanBasePackages = {"com.surajraut.customer","com.surajraut.amqp"})
@EnableDiscoveryClient
@EnableFeignClients(
        basePackages = "com.surajraut.clients"
)
@ImportAutoConfiguration({FeignAutoConfiguration.class})

public class CustomerApplication {
//    @Bean
//    public WebClient.Builder getWebClient() {
//        return WebClient.builder();
//    }
//    @Bean
//    public DiscoveryClient discoveryClient() {
//        return new DiscoveryClient(;
//    }

    public static void main(String[] args) {
        SpringApplication.run(CustomerApplication.class, args);
    }

}
