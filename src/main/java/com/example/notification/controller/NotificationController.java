package com.example.notification.controller;

import com.example.notification.dto.Message;
import com.example.notification.dto.NotificationResponseMessage;
import com.example.notification.enums.ChannelType;
import com.example.notification.exception.InvalidFormatException;
import com.example.notification.service.NotificationService;
import com.example.notification.util.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/notification")
public class NotificationController {

    private static final Logger logger = LoggerFactory.getLogger(NotificationController.class);

    @Autowired
    private NotificationService service;


    @PostMapping("/notify/{channelType}")
    public NotificationResponseMessage notify(@PathVariable ChannelType channelType, @RequestBody Message message) {
        return service.notify(channelType, message);
    }

    @PostMapping("/notifyAll")
    public String notifyAll(@RequestBody Message message)
    {
        return  service.notifyAll(message);
    }


}
