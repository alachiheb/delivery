package com.carrefour.delivery.exception;

import lombok.Data;

@Data
public class ExceptionInfo {
    private  String description;
    private  String detail;

    public ExceptionInfo(String description, String detail) {
        this.description = description;
        this.detail = detail;

    }
}
