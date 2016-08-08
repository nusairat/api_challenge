package com.disney.studios.util;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class JSONMessageObject {
    private String message;

    public JSONMessageObject(String msg) {
        message = msg;
    }

    public String getMessage() {
        return message;
    }
}