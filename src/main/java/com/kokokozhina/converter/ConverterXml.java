package com.kokokozhina.converter;

import org.json.JSONObject;
import org.json.XML;

import java.io.*;

public class ConverterXml extends DefaultConverter {
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
