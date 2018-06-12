package com.kokokozhina.handler;

import com.kokokozhina.task.Task;
import com.kokokozhina.task.TaskRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Handler {

    ExecutorService service;

    public Handler() {
        this.service = Executors.newCachedThreadPool();
    }

    public Handler(int n) {
        this.service = Executors.newFixedThreadPool(n);
    }

    public void addTask(Task t) {
        service.submit(new TaskRunnable(t));
    }


}
