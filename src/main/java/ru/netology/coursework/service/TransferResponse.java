package ru.netology.coursework.service;

public class TransferResponse {
    public String operationId;

    public TransferResponse(String operationId) {
        this.operationId = operationId;
    }

    public TransferResponse() {

    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }
}
