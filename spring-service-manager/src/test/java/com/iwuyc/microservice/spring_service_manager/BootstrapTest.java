package com.iwuyc.microservice.spring_service_manager;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Test;

public class BootstrapTest
{

    @Test
    public void test()
    {
        try (Scanner scanner = new Scanner(System.in);)
        {
            ScheduledExecutorService executor = Executors.newScheduledThreadPool(10);
            MyTask task = new MyTask(executor);
            executor.schedule(task, 1, TimeUnit.SECONDS);
            scanner.nextLine();
        }
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
