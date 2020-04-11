package com.nike.nordgym.error;

import org.springframework.http.HttpStatus;

public class ResourceNotFoundException extends FrontEndException {
    private static final long serialVersionUID = 1823334861407113735L;

    public ResourceNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, ErrorCode.RESOURCE_NOT_FOUND, message);
    }
}
