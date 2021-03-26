package ru.netology.coursework.service;

public class TransferResponse {
    public String operationId;
    public String varificationCode;

    public TransferResponse(String operationId, String varificationCode) {
        this.operationId = operationId;
        this.varificationCode = varificationCode;
    }

    public TransferResponse() {

    }

    public String getVarificationCode() {
        return varificationCode;
    }

    public void setVarificationCode(String varificationCode) {
        this.varificationCode = varificationCode;
    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
}
