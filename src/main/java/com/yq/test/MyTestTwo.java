package com.yq.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyTestTwo {

    public static void main(String[] args) {
        CountDownLatch countDownLatch = null;
        DiskMemory diskMemory = null;
        ExecutorService threadPool = null;
        try {
            countDownLatch = new CountDownLatch(4);
            threadPool = Executors.newFixedThreadPool(6);
            diskMemory = new DiskMemory();
            threadPool.execute(newRunnable(countDownLatch, diskMemory, 1));
            threadPool.execute(newRunnable(countDownLatch, diskMemory, 2));
            threadPool.execute(newRunnable(countDownLatch, diskMemory, 3));
            threadPool.execute(newRunnable(countDownLatch, diskMemory, 4));
            countDownLatch.await();
            System.out.println("总线程：磁盘总大小：" + diskMemory.getTotalSize());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (threadPool != null) {
                threadPool.shutdown();
            }
        }

    }

    private static Runnable newRunnable(final CountDownLatch countDownLatch, final DiskMemory diskMemory, final int threadNum) {
        return new Runnable() {
            @Override
            public void run() {
               try {
                   diskMemory.setSize(diskMemory.getSize(), threadNum);
               } catch (Exception e) {
                    e.printStackTrace();
               } finally {
                    if (countDownLatch != null) {
                        countDownLatch.countDown();
                    }
               }
            }
        };
    }

}
