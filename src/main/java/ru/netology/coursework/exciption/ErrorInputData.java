package ru.netology.coursework.exciption;

public class ErrorInputData extends RuntimeException {
    public ErrorInputData(String msg) {
        super(msg);
    }
}
