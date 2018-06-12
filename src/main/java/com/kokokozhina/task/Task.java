package com.kokokozhina.task;


import com.kokokozhina.converter.Converter;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;

public class Task {
    private InputStream in;
    private OutputStream out;
    private Converter converterIn;
    private Converter converterOut;
    private Boolean status;

    public Task(InputStream in, OutputStream out, Converter cIn, Converter cOut) {
        this.in = in;
        this.out = out;
        this.converterIn = cIn;
        this.converterOut = cOut;
        this.status = false;
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

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}

