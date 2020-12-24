package com.fancv.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class guavaTest {
    public static void main(String[] args) {


        //一秒0.5个   2秒一个 QPS

        RateLimiter rateLimiter = RateLimiter.create(10);
        List<Runnable> tasks = new ArrayList<Runnable>();
        for (int i = 0; i < 100; i++) {
            tasks.add(new UserRequest(i));
        }
        ExecutorService threadPool = Executors.newCachedThreadPool();
        for (Runnable runnable : tasks) {
            System.out.println("获取锁结果：" + rateLimiter.tryAcquire());
            System.out.println("等待时间：" + rateLimiter.acquire());

            threadPool.execute(runnable);
        }


    }

    public static void testSmoothBursty2() {
        RateLimiter r = RateLimiter.create(2);
        while (true) {
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
            }
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("get 1 tokens: " + r.acquire(1) + "s");
            System.out.println("end");
            /**
             * output:
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             * end
             * get 1 tokens: 0.499796s
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             * get 1 tokens: 0.0s
             */
        }
    }

    private static class UserRequest implements Runnable {
        private int id;

        public UserRequest(int id) {
            this.id = id;
        }

        public void run() {
            System.out.println(id);
        }
    }

}