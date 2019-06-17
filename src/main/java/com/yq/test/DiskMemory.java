package com.yq.test;

import java.util.Random;

public class DiskMemory {
    private int totalSize;

    public int getSize() {
        return (new Random().nextInt(3) + 1) * 100;
    }

    public synchronized void setSize(int size, int threadNum) {
        totalSize += size;
        System.out.println("第" + threadNum + "根线程：此时磁盘总大小是：" + getTotalSize());
    }

    public int getTotalSize() {
        return totalSize;
    }


}
