package com.yq.zookeeper;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class TestZookeeper {

    private String connectString = "192.168.10.129:2181,192.168.10.130:2181,192.168.10.132:2181";
    private int sessionTimeOut = 3000;
    private ZooKeeper zkClient;

    public static void main(String[] args) {
        System.out.println(args);
    }

    /**
     * 连接zookeeper集群
     * @throws Exception
     */
    @Before
    public void init() throws Exception{
        zkClient = new ZooKeeper(connectString, sessionTimeOut, new Watcher() {
            @Override
            public void process(WatchedEvent watchedEvent) {
                try {
                    System.out.println("######################start#########################");
                    List<String> nodes = zkClient.getChildren("/", false);
                    for (String node : nodes) {
                        System.out.println(node);
                    }
                    System.out.println("######################end#########################");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * 创建节点
     */
    @Test
    public void createNode() throws Exception{
        Thread.sleep(10000);
        String path = zkClient.create("/cyq", "chenyouquanhenshaui".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println(path);
    }

    /**
     * 获取节点并监控节点的变化
     * @throws Exception
     */
    @Test
    public void getDateAndWatch() throws Exception{
        Thread.sleep(8000);
        List<String> nodes = zkClient.getChildren("/", true);
        for (String node : nodes) {
            System.out.println(node);
        }
        Thread.sleep(Long.MAX_VALUE);
    }

    /**
     * 判断节点是否存在
     * @throws Exception
     */
    @Test
    public void exist() throws Exception{
        Thread.sleep(5000);
        Stat stat = zkClient.exists("/tt", false);
        System.out.println(stat == null ? "notExists" : "isExists");
    }


    @After
    public void close() {
        try {
            zkClient.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
