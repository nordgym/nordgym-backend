package com.nike.nordgym.model;

import com.nike.nordgym.constant.Constants;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
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
    //TODO: uncomment when order is created
//  private List<OrderDto> orders;

    public UserDto(Long id, String subscriptionNumber, String firstName,
                   String lastName, String email, String password) {
        this.id = id;
        this.subscriptionNumber = subscriptionNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }
}
