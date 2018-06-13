package com.kokokozhina.converter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class DefaultConverter implements Converter {

    final static int BUFFER_SIZE = 1024;

    public String inputStreamToString(InputStream inputStream) {
        ByteArrayOutputStream result = new ByteArrayOutputStream();
        byte[] buffer = new byte[BUFFER_SIZE];
        int length;
        try {
            while ((length = inputStream.read(buffer)) != -1) {
                result.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();

    }

    public String convertTypeToJson(InputStream inputStream) {
        return inputStreamToString(inputStream);
    }

    public String convertJsonToType(InputStream inputStream) {
        return inputStreamToString(inputStream);
    }


}
