package com.kokokozhina;

import com.kokokozhina.converter.ConverterXml;
import com.kokokozhina.converter.DefaultConverter;
import com.kokokozhina.handler.Handler;
import com.kokokozhina.task.Task;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.PropertyConfigurator;

import java.io.*;
import java.util.logging.Logger;

public class Main {
//    static final Logger LOG = log4j, sl4j

    public static void main(String[] args) throws IOException, InterruptedException {

//        BasicConfigurator.configure();

        String pathPrefix = "./";

        Handler handler = new Handler();

        Task t = new Task(
                new FileInputStream(new File(pathPrefix + "/json/quiz.json")),
                new FileOutputStream(new File(pathPrefix + "/xml/quiz.xml")),
                new DefaultConverter(),
                new ConverterXml());

        handler.addTask(t);
        System.out.println(t.getStatus());

        Thread.sleep(1);
        handler.addTask(t);
        System.out.println(t.getStatus());


        handler.addTask(new Task(
                new FileInputStream(new File(pathPrefix + "/xml/house.xml")),
                new FileOutputStream(new File(pathPrefix + "/json/house.json")), // /json/house.json
                new ConverterXml(),
                new DefaultConverter())
        );



        handler.printCurrentTasks();
        handler.printTasksInQueue();

        handler.killExecutor();




    }
}
