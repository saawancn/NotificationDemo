package com.example.notification.service;

import com.example.notification.channel.Channel;
import com.example.notification.channel.ChannelFactory;
import com.example.notification.dto.Message;
import com.example.notification.dto.NotificationResponseMessage;
import com.example.notification.enums.ChannelType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class NotificationService {

    private static final Logger logger = LoggerFactory.getLogger(NotificationService.class);

    @Autowired
   private ChannelFactory factory;

    public NotificationService(ChannelFactory factory) {
        this.factory = factory;
    }

    private AtomicInteger notificationId = new AtomicInteger(1);

    /**
     * sends notification to the given channelType
     * @param message The message includes from, to, subject, text
     */
    public String notifyAll(Message message)  {

        for(Channel channel : factory.getChannels()) {
            message.setId(notificationId.getAndIncrement());
            channel.sendNotification(message);
            logger.info("ID = {} Message sent = {} ",notificationId, message);
        }
        return "message sent to all channels";
    }

    /**
     * sends notifcation to all supported channels
     * @param channelType Type of chanel to notify - slack and email
     * @param message The message includes from, to, subject, body
     */
    public NotificationResponseMessage notify(ChannelType channelType, Message message) {
        message.setId(notificationId.getAndIncrement());
        String successMessage = factory.get(channelType).sendNotification(message);
        logger.info("ID = {} Message sent = {} ",notificationId, message);
        return NotificationResponseMessage.newNotificationResponseBuilder().withId(notificationId.longValue())
                .withMessage(successMessage).build();
    }
}
