package com.nike.nordgym.model;

import com.nike.nordgym.constant.Constants;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
public class UserDto {

    private Long id;
    @NotBlank
    @Pattern(regexp = "^[\\d]{10}$", message = Constants.USER_SUBSCRIPTION_NUMBER_ERROR_MESSAGE)
    private String subscriptionNumber;
    @NotBlank
    @Pattern(regexp = "^[A-Z-a-z]{2,15}$", message = Constants.USER_FIRST_NAME_ERROR_MESSAGE)
    private String firstName;
    @NotBlank
    @Pattern(regexp = "^[A-Z-a-z]{2,15}$", message = Constants.USER_LAST_NAME_ERROR_MESSAGE)
    private String lastName;
    private String email;
    private String password;
}
