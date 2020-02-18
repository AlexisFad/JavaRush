package com.javarush.task.task22.task2201;

public class StringForFirstThreadTooShortException extends RuntimeException {
    @Override
    public synchronized Throwable getCause() {
        return super.getCause();
    }
}
