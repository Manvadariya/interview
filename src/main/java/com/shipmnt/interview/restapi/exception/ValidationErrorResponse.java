package com.shipmnt.interview.restapi.exception;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationErrorResponse {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private Map<String, String> violations;

    public ValidationErrorResponse(int status, String error, Map<String, String> violations) {
        this.timestamp = LocalDateTime.now();
        this.status = status;
        this.error = error;
        this.violations = violations;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Map<String, String> getViolations() {
        return violations;
    }

    public void setViolations(Map<String, String> violations) {
        this.violations = violations;
    }
}
