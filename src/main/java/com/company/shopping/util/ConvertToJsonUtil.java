package com.company.shopping.util;

import com.google.gson.Gson;

public class ConvertToJsonUtil {

    private final Gson convertor = new Gson();

    public String convertToJson(Object object) {
        return convertor.toJson(object);
    }
}
