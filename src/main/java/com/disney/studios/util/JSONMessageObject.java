package com.disney.studios.util;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class JSONMessageObject {
    private String message;
    boolean success = false;

    public JSONMessageObject(String msg, boolean succ) {
        message = msg;
        success = succ;
    }

    public String getMessage() {
        return message;
    }

    public boolean getSuccess() {
        return success;
    }
}