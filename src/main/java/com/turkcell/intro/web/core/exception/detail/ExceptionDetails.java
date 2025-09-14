package com.turkcell.intro.web.core.exception.detail;

public class ExceptionDetails
{
    private String message;

    public ExceptionDetails() {
    }

    public ExceptionDetails(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
