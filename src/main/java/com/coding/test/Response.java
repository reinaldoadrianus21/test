package com.coding.test;

import lombok.Data;

@Data
public class Response<T> {
    private boolean status;
    private String message;
    private T result;
}