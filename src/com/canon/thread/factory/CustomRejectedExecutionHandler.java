package com.canon.thread.factory;

import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @program: dataStructuresAndAlgorithms
 * @Auther: canon
 * @Date: 2019/2/26 09:58
 * @Description:
 */
public class CustomRejectedExecutionHandler implements RejectedExecutionHandler {

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {


        throw new RejectedExecutionException("中文 : 线程请求被拒绝;\n" +
                "English : sorry,you request can not executor");
    }
}
