package com.lazy1ron.spring.core.ioc.container.listeners;

import com.lazy1ron.spring.core.ioc.container.events.BlackListEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author:Lazy1ron
 * @date:2019/12/27 5:04
 */

@Component
@EnableAsync
public class AsychronousBlackListNotifier {

    private static final String address = "1605125086@qq.com";


    @EventListener(BlackListEvent.class)
    @Async("taskExecutor")
    public void handleEvent(BlackListEvent event) {
        if (event.getAddress().equals(address)) {
            System.out.println("address: " + address + "----content: " + event.getContent());
            System.out.println(Thread.currentThread().getName());
        }
    }

    @Bean("taskExecutor")
    public Executor taskExecutor() {
        AtomicInteger i = new AtomicInteger(0);
        return new ThreadPoolExecutor(10, 15,
                5L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10));
    }


}
