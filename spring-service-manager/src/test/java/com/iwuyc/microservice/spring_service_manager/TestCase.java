package com.iwuyc.microservice.spring_service_manager;

import org.junit.Test;

public class TestCase
{

    @SuppressWarnings("unused")
    @Test
    public void test()
    {
        TestClass t = new TestClass();
        t.setA(10);
        long begin = System.currentTimeMillis();
        int a = 0;
        int b = 0;
        int c = 0;
        // int temp = t.getA();
        for (int i = Integer.MIN_VALUE; i < Integer.MAX_VALUE; i++)
        {
            a += t.getA();
            b += t.getA();
            c += t.getA();

            // a += temp;
            // b += temp;
            // c += temp;
        }

        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    static class TestClass
    {
        private int a;

        public int getA()
        {
            return a;
        }

        public void setA(int a)
        {
            this.a = a;
        }
    }
}
