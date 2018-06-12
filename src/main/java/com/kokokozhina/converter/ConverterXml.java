package com.kokokozhina.converter;

import org.json.JSONObject;
import org.json.XML;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ConverterXml extends Converter {
    @Override
    public String convertJsonToType(InputStream inputStream) {
        String str = inputStreamToString(inputStream);
        JSONObject json = new JSONObject(str);

        return XML.toString(json);
    }

    @Override
    public String convertTypeToJson(InputStream inputStream) {
        String xml = inputStreamToString(inputStream);

        return XML.toJSONObject(xml).toString();
    }

}
