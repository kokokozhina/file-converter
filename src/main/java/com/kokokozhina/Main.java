package com.kokokozhina;

import com.kokokozhina.converter.Converter;
import com.kokokozhina.converter.ConverterXml;
import com.kokokozhina.handler.Handler;
import com.kokokozhina.task.Task;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = Main.class.getClassLoader();

        InputStream in = new FileInputStream(classLoader
                .getResource("json/quiz.json").getFile());
        OutputStream out = new FileOutputStream(classLoader
                .getResource("xml/quiz.xml").getFile());
        Handler handler = new Handler();

        handler.addTask(new Task(in, out, new Converter(), new ConverterXml()));

        in.close();
        out.close();

    }
}
