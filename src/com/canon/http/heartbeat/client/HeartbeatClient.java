package com.canon.http.heartbeat.client;

import com.canon.http.heartbeat.cmder.Cmder;
import com.canon.http.heartbeat.cmder.HeartbeatHandler;
import com.canon.http.heartbeat.entity.HeartbeatEntity;
import com.canon.http.heartbeat.utils.RPClient;

import java.net.InetSocketAddress;
import java.util.UUID;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/12 14:35
 * @Description:
 */
public class HeartbeatClient implements Runnable {
    private String serverIP = "127.0.0.1";
    private int serverPort = 8080;
    private String nodeID = UUID.randomUUID().toString();

    private boolean isRunning = true;

    private long lastHeartbeat;

    private long heartBeatInterval = 10 * 1000;


    @Override
    public void run() {
        while (isRunning) {
            HeartbeatHandler handler = RPClient.getRemoteProxyObj(HeartbeatHandler.class, new InetSocketAddress(serverIP, serverPort));
            long startTime = System.currentTimeMillis();

            if (startTime - lastHeartbeat > heartBeatInterval) {
                System.out.println("send a heart beat");
                lastHeartbeat = startTime;

                HeartbeatEntity entity = new HeartbeatEntity();
                entity.setTime(startTime);
                entity.setNodeID(nodeID);

                // 向服务器发送心跳，并返回需要执行的命令
                Cmder cmds = handler.sendHeartBeat(entity);

                if (!processCommand(cmds))
                    continue;
            }
        }

    }

    private boolean processCommand(Cmder cmds) {
        // ...
        return true;
    }
}
