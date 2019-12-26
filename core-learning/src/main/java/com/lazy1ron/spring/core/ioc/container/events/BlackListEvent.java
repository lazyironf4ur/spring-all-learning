package com.lazy1ron.spring.core.ioc.container.events;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.context.ApplicationEvent;

/**
 * @author:Lazy1ron
 * @date:2019/12/27 3:50
 */
@Data
@Accessors
public class BlackListEvent extends ApplicationEvent {

    private final String address;

    private final String content;

    /**
     * Create a new {@code ApplicationEvent}.
     *
     * @param source the object on which the event initially occurred or with
     *               which the event is associated (never {@code null})
     */
    public BlackListEvent(Object source, String address, String content) {
        super(source);
        this.address = address;
        this.content = content;
    }


}
