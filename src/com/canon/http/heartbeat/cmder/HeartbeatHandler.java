package com.canon.http.heartbeat.cmder;

import com.canon.http.heartbeat.entity.HeartbeatEntity;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/12 14:56
 * @Description:
 */
public interface HeartbeatHandler {
    public Cmder sendHeartBeat(HeartbeatEntity info);
}
