package com.example.school.exception;

import java.time.LocalDateTime;

public class ErrorException {
    private LocalDateTime timestate;
    private int status;
    private String error;
    private String path;
    public ErrorException(LocalDateTime timestate, int status, String error, String path) {
        this.timestate = timestate;
        this.status = status;
        this.error = error;
        this.path = path;
    }
    public LocalDateTime getTimestate() {
        return timestate;
    }
    public int getStatus() {
        return status;
    }
    public String getError() {
        return error;
    }
    public String getPath() {
        return path;
    }
    

}
