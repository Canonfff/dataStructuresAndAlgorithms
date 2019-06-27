package com.canon.http.heartbeat.test;

import com.canon.http.heartbeat.center.ServiceCenter;
import com.canon.http.heartbeat.client.HeartbeatClient;
import com.canon.http.heartbeat.cmder.HeartbeatHandler;
import com.canon.http.heartbeat.cmder.HeartbeatHandlerImpl;

import java.io.IOException;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/12 15:26
 * @Description:
 */
public class HeartbeatTest {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    ServiceCenter serviceServer = ServiceCenter.getInstance();
                    serviceServer.register(HeartbeatHandler.class, HeartbeatHandlerImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread client1 = new Thread(new HeartbeatClient());
        client1.start();
        Thread client2 = new Thread(new HeartbeatClient());
        client2.start();
    }
}
