package com.kokokozhina.converter;

import java.io.InputStream;

public interface Converter {

    String convertTypeToJson(InputStream inputStream);

    String convertJsonToType(InputStream inputStream);

}
