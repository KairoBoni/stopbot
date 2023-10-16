package com.kairoboni.stopbot.app.dependencies.exeptions;

import java.io.Serializable;
import java.util.Date;

public class BaseException implements Serializable {
    private static final long SerialVersionUID = 1L;

    private final Date timestamp;
    private final String message;
    private final String datails;

    public BaseException(Date timestamp, String message, String datails) {
        this.timestamp = timestamp;
        this.message = message;
        this.datails = datails;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public String getMessage() {
        return message;
    }

    public String getDatails() {
        return datails;
    }
}
