package com.nike.nordgym.error;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;

// This will disable the auto serialization and let us to control what to serialize.
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.NONE, getterVisibility = JsonAutoDetect.Visibility.NONE)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FrontEndException extends RuntimeException {

    private static final long serialVersionUID = 5544640120959837305L;
    private boolean shouldSerializeStackTrace = false;

    private final HttpStatus httpStatus;

    @JsonProperty
    private final Object errorCode;

    public FrontEndException(HttpStatus httpStatus, Object errorCode, String message) {
        super(message);

        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Object getErrorCode() {
        return errorCode;
    }

    public void setShouldSerializeStackTrace(boolean shouldSerializeStackTrace) {
        this.shouldSerializeStackTrace = shouldSerializeStackTrace;
    }

    @JsonProperty
    @Override
    public StackTraceElement[] getStackTrace() {
        return this.shouldSerializeStackTrace ? super.getStackTrace() : null;
    }
}
