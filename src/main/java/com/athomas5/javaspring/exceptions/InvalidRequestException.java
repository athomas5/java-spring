package com.athomas5.javaspring.exceptions;

public final class InvalidRequestException extends RuntimeException {
    public InvalidRequestException() {}

    public InvalidRequestException(String message) {
        super(message);
    }
}
