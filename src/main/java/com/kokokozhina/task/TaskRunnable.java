package com.kokokozhina.task;

import java.io.ByteArrayInputStream;
import java.io.IOException;

public class TaskRunnable implements Runnable {

    private final Task task;

    public TaskRunnable(Task task) {
        this.task = task;
    }

    @Override
    public void run() {
        try {
            task.getIn().reset();
            String s = task.getConverterIn().convertTypeToJson(task.getIn());
            s = task.getConverterOut().convertJsonToType(new ByteArrayInputStream(s.getBytes()));
            task.getOut().write(s.getBytes());
            task.setStatus(true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
