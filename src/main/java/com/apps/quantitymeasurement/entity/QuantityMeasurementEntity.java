package com.apps.quantitymeasurement.entity;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    private String operation;
    private String result;
    private boolean error;
    private String message;

    public QuantityMeasurementEntity(String operation, String result) {
        this.operation = operation;
        this.result = result;
        this.error = false;
    }

    public QuantityMeasurementEntity(String message, boolean error) {
        this.message = message;
        this.error = error;
    }

    public String getOperation() {
        return operation;
    }

    public String getResult() {
        return result;
    }

    public boolean isError() {
        return error;
    }

    public String getMessage() {
        return message;
    }
}