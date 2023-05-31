package com.project1.entity.payload;

import java.util.Arrays;

public class RequestData {

    private String format;
    private String[] data;

    public RequestData() {
        super();
    }

    public RequestData(String format, String[] data) {
        super();
        this.format = format;
        this.data = data;
    }

    public String getFormat() {
        return format;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public String[] getData() {
        return data;
    }
    public void setData(String[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RequestData [format=" + format + ", data=" + Arrays.toString(data) + "]";
    }

}