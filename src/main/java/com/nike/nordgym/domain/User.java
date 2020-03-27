package com.nike.nordgym.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String subscriptionNumber;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column()
    private String password;
    //TODO: uncomment when order is created
//  @OneToMany(targetEntity = Order.class, mappedBy = "user", fetch = FetchType.EAGER)
//  private List<Order> orders;

}
