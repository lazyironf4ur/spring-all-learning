package com.lazy1ron.spring.core.ioc.container;

import com.lazy1ron.spring.core.ioc.container.listeners.AsychronousBlackListNotifier;
import org.junit.Test;

import java.util.concurrent.Executor;

/**
 * @author:Lazy1ron
 * @date:2019/12/27 6:51
 */
public class ExecutorText {

    @Test
    public void test() {
        Executor executor = new AsychronousBlackListNotifier().taskExecutor();
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
}
