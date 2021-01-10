package com.example.notification.channel;

import com.example.notification.dto.Message;
import com.example.notification.enums.ChannelType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ChannelFactory {

    private final List<Channel> channelList;


    @Autowired
    public ChannelFactory(List<Channel> channelList) {
        this.channelList = channelList;
    }

    public Channel get(ChannelType channelType) {
        return channelList
                .stream()
                .filter(service -> service.supports(channelType))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No channel found for type : "+ channelType));
    }


    public List<Channel> getChannels() {
        return channelList;
    }

}
