package com.kokokozhina.handler;

import com.kokokozhina.task.Task;
import org.apache.log4j.Logger;

import java.util.concurrent.*;

public class Handler {

    private final static Logger logger = Logger.getLogger(Task.class);

    private ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(4);

    public void addTask(Task t) {
        executor.submit(t);
    }

    public void killExecutor() {
        while(executor.getActiveCount() > 0 || executor.getQueue().size() > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                logger.error("Interrupting sleep of a thread: ", ex);
            }
        }
        executor.shutdown();
    }

    public void printCurrentTasks() {
        System.out.println("Tasks that are being executed : " + executor.getActiveCount());
    }

    public void printTasksInQueue() {
        System.out.println("Tasks in queue : " + executor.getQueue());
    }
}
