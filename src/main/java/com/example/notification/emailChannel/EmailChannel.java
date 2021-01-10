package com.example.notification.emailChannel;

import com.example.notification.channel.Channel;
import com.example.notification.enums.ChannelType;

public interface EmailChannel extends Channel {

    @Override
    default boolean supports(ChannelType type) {
        return ChannelType.EMAIL.equals(type);
    }
}
