package com.kairoboni.stopbot.app.dependencies.exeptions.http;

public class InternalServerErrorException extends RuntimeException {
    public InternalServerErrorException(String message) {
        super(message);
    }
}
