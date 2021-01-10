package com.example.notification.channel;

import com.example.notification.dto.Message;
import com.example.notification.enums.ChannelType;



public interface Channel {
     String sendNotification(Message msg) ;

     boolean supports(ChannelType type);
}
