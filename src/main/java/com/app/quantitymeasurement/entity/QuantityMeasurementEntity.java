package com.app.quantitymeasurement.entity;

import java.io.Serializable;

public class QuantityMeasurementEntity implements Serializable {

    private String operand1;
    private String operand2;

    private String measurementType;
    private String operationType;

    private String resultValue;

    private boolean errorFlag;
    private String message;

    public QuantityMeasurementEntity(
            String operand1,
            String operand2,
            String measurementType,
            String operationType,
            String resultValue,
            boolean errorFlag,
            String message) {

        this.operand1 = operand1;
        this.operand2 = operand2;
        this.measurementType = measurementType;
        this.operationType = operationType;
        this.resultValue = resultValue;
        this.errorFlag = errorFlag;
        this.message = message;
    }

    public String getOperand1() {
        return operand1;
    }

    public String getOperand2() {
        return operand2;
    }

    public String getMeasurementType() {
        return measurementType;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getResultValue() {
        return resultValue;
    }

    public boolean isErrorFlag() {
        return errorFlag;
    }

    public String getMessage() {
        return message;
    }
}