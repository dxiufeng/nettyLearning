package com.netty.demo2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TimeServerHandlerExecutePool {

    private ExecutorService executor;

    public TimeServerHandlerExecutePool(int maxPoolSiez ,int queueSize) {
        executor=new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),maxPoolSiez,120L
                , TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(queueSize));
    }


    public void execute(Runnable task){
        executor.execute(task);

    }

}
