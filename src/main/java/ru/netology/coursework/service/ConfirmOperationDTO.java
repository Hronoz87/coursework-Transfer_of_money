package ru.netology.coursework.service;

public class ConfirmOperationDTO {
    public String operationId;
    public String code;

    public ConfirmOperationDTO(String operationId, String code) {
        this.operationId = operationId;
        this.code = code;
    }

    public ConfirmOperationDTO() {

    }

    public String getOperationId() {
        return operationId;
    }

    public void setOperationId(String operationId) {
        this.operationId = operationId;
    }

    public String getVerificationCode() {
        return code;
    }

    public void setVerificationCode(String verificationCode) {
        this.code = verificationCode;
    }

    @Override
    public String toString() {
        return "ConfirmOperationDTO{" +
                "operationId='" + operationId + '\'' +
                ", verificationCode='" + code + '\'' +
                '}';
    }
}
