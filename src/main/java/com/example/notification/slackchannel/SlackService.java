package com.example.notification.slackchannel;

import com.example.notification.dto.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
public class SlackService implements SlackChannel {

    @Value("${slack.channel.api}")
    String url;

    @Autowired
    RestTemplate restTemplate;

    @Override
    public String sendNotification(Message slackMessage) {
        HttpEntity<Message> request =
                new HttpEntity<>(slackMessage);
        if(slackMessage.getText()==null){
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST);
        }
        ResponseEntity<String> message= restTemplate.exchange(URI.create(url), HttpMethod.POST, request ,String.class);
        return  message.getBody();
    }
}
