package com.canon.java.io;

/**
 * @PackageName: com.canon.java.io
 * @Description:
 * @author: canon
 * @date: 2020/9/14 9:57
 * @Version: 1.0
 */
public class TryWithSourceDemo implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("关闭流操作");
    }
}
