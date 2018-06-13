package com.kokokozhina.task;

import com.kokokozhina.converter.Converter;
import org.apache.log4j.Logger;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class Task implements Runnable {

    private final static Logger logger = Logger.getLogger(Task.class);

    private InputStream in;
    private OutputStream out;
    private Converter converterIn;
    private Converter converterOut;
    private String status;

    public Task(InputStream in, OutputStream out, Converter cIn, Converter cOut) {
        this.in = in;
        this.out = out;
        this.converterIn = cIn;
        this.converterOut = cOut;
        this.status = "Raw";
    }

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }

    public OutputStream getOut() {
        return out;
    }

    public void setOut(OutputStream out) {
        this.out = out;
    }

    public Converter getConverterIn() {
        return converterIn;
    }

    public void setConverterIn(Converter converterIn) {
        this.converterIn = converterIn;
    }

    public Converter getConverterOut() {
        return converterOut;
    }

    public void setConverterOut(Converter converterOut) {
        this.converterOut = converterOut;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public void run() {
        if (getStatus() != "Raw") {
            System.out.println(getStatus());
            return;
        }

        try {
            setStatus("In progress");
            String s = converterIn.convertTypeToJson(in);
            s = converterOut.convertJsonToType(new ByteArrayInputStream(s.getBytes()));
            out.write(s.getBytes());
            setStatus("Done");
        } catch (IOException ex) {
            logger.error("Exception in writing to file: ", ex);
        }

    }

}

