package com.yoga.yoga_tracker_service.DTO;

import org.springframework.http.HttpStatusCode;

import java.util.Map;

public class GlobalExceptionDTO {

    private HttpStatusCode statusCode;
    private String message;
    private Map<String, String> errors;

    public GlobalExceptionDTO() {
    }

    public GlobalExceptionDTO(HttpStatusCode statusCode, String message, Map<String, String> errors) {
        this.statusCode = statusCode;
        this.message = message;
        this.errors = errors;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, String> errors) {
        this.errors = errors;
    }
}
