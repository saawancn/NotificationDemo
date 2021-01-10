package com.example.notification.slackchannel;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class SlackConfiguration {

    @Bean
    public RestTemplate getRestTemplate() {

        return new RestTemplate();
    }

}
