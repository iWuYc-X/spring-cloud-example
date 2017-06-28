package com.iwuyc.microservice.spring_service_manager;

import java.util.Collections;
import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;

import ch.qos.logback.core.util.TimeUtil;

public class BootstrapTest
{

    @Test
    public void test()
    {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
        MyTask task = new MyTask(executor);
        executor.schedule(task, 1, TimeUnit.SECONDS);
        new Scanner(System.in).nextLine();
    }

    static class MyTask implements Runnable
    {
        ScheduledExecutorService executor;
        AtomicInteger count;

        public MyTask(ScheduledExecutorService executor)
        {
            super();
            this.executor = executor;
            this.count = new AtomicInteger(0);
        }

        @Override
        public void run()
        {
            try
            {
                System.out.println("Beat" + this.count.getAndIncrement());
            }
            finally
            {
                executor.schedule(this, 1, TimeUnit.SECONDS);
            }
        }
    }
}
