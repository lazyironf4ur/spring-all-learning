package com.lazy1ron.spring.core.ioc.container.listeners;

import com.lazy1ron.spring.core.ioc.container.events.BlackListEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author:Lazy1ron
 * @date:2019/12/27 4:05
 */

@Service("bln")
public class BlackListNotifier implements ApplicationListener<BlackListEvent> {

    private static final String address = "lazy1ron.s3efun@gmail.com";

    @Override
    public void onApplicationEvent(BlackListEvent event) {
        if (event.getAddress().equals(address)) {
            System.out.println(event.getContent());
        }
    }
}
