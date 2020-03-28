package com.nike.nordgym.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String subscriptionNumber;
    private String firstName;
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
