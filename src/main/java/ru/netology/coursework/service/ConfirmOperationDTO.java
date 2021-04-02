package ru.netology.coursework.service;

public class ConfirmOperationDTO {
    public String operationId;
    public String verificationCode;

    public ConfirmOperationDTO(String operationId, String verificationCode) {
        this.operationId = operationId;
        this.verificationCode = verificationCode;
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
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    @Override
    public String toString() {
        return "ConfirmOperationDTO{" +
                "operationId='" + operationId + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                '}';
    }
}
