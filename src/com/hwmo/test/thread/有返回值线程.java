package com.hwmo.test.thread;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

public class 有返回值线程 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        int taskSize = 5;
        List<Future> list = new ArrayList<Future>();
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i = 0; i < taskSize; i++){


            Callable callable = new MyCallable(i+"");

            Future f = service.submit(callable);
            System.out.println(f.get().toString());
        }

    }
}

class MyCallable implements Callable {
    private String taskNum;

    MyCallable(String taskNum) {
        this.taskNum = taskNum;
    }

    public Object call() throws Exception {
        System.out.println(">>>" + taskNum + "任务启动");
        Date dateTmp1 = new Date();
        Thread.sleep(1000);
        Date dateTmp2 = new Date();
        long time = dateTmp2.getTime() - dateTmp1.getTime();
        System.out.println(">>>" + taskNum + "任务终止");
        return taskNum + "任务返回运行结果,当前任务时间【" + time + "毫秒】";
    }
}