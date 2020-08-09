package com.canon.concurrent.node;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @Author Canon
 * @Date:Created in 20:57 2020/8/8
 * @Modify By: canon
 * @Despricction:
 * @since 1.0
 */
public class Node {
    private volatile boolean aclive = true;

    private volatile long lastAcliveTime;

    private String point;

    private String uri;

    // 原子锁
    private AtomicBoolean acqiure = new AtomicBoolean(false);

    public boolean getAclive() {
        return aclive;
    }

    public void setAclive(boolean aclive) {
        this.aclive = aclive;
    }

    public String getPoint() {
        return point;
    }

    public Node setPoint(String point) {
        this.point = point;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public Node setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public long getLastAcliveTime() {
        return lastAcliveTime;
    }

    public Node setLastAcliveTime(long lastAcliveTime) {
        this.lastAcliveTime = lastAcliveTime;
        return this;
    }

    public boolean acqiure() {
        return acqiure.compareAndSet(false, true);
    }

    public void releaseLock() {
        acqiure.compareAndSet(true, false);
    }

    public boolean getAcqiure() {
        return acqiure.get();
    }
}
