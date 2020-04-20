package com.nike.nordgym.error;

import com.nike.nordgym.constant.Constants;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = Constants.DUPLICATED_RESOURCE
)
public class DuplicatedResourceException extends RuntimeException {

    private int statusCode = HttpStatus.NOT_FOUND.value();

    public DuplicatedResourceException(String message) {
        super(message);
    }
}
