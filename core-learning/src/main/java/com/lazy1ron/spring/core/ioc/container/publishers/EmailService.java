package com.lazy1ron.spring.core.ioc.container.publishers;

import com.lazy1ron.spring.core.ioc.container.events.BlackListEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author:Lazy1ron
 * @date:2019/12/27 3:53
 */

@Service("aep")
public class EmailService implements ApplicationEventPublisherAware {


    private List<String> blacklist;

    private ApplicationEventPublisher publisher;


    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.publisher = applicationEventPublisher;
    }

    public void setBlacklist(List<String> blacklist) {
        this.blacklist = blacklist;
    }

    public void sendEmail(String address, String content) {
        if (blacklist.contains(address)) {
            publisher.publishEvent(new BlackListEvent(this, address, content));
        }
    }


}
