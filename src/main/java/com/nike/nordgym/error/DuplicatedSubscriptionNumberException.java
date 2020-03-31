package com.nike.nordgym.error;

import com.nike.nordgym.constant.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@NoArgsConstructor
@ResponseStatus(
        value = HttpStatus.NOT_FOUND,
        reason = Constants.INVALID_SUBSCRIPTION_NUMBER_DUPLICATED
)
public class DuplicatedSubscriptionNumberException extends RuntimeException {

    private int statusCode = HttpStatus.NOT_FOUND.value();

    public DuplicatedSubscriptionNumberException(String message) {
        super(message);
    }
}
