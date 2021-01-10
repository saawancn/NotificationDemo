package com.example.notification.slackchannel;

import com.example.notification.channel.Channel;
import com.example.notification.enums.ChannelType;

public interface SlackChannel extends Channel {

    @Override
    default boolean supports(ChannelType type) {
        return ChannelType.SLACK.equals(type);
    }
}
