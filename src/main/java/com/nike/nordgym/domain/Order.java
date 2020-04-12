package com.nike.nordgym.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = User.class)
    private User user;

    @CreationTimestamp
    private Instant dateTime;

    @Column(columnDefinition = "boolean default true")
    private Boolean isOpen = true;

    @ManyToMany(targetEntity = Product.class, fetch = FetchType.LAZY)
    @JoinTable(name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "product_id", referencedColumnName = "id")
    )
    private List<Product> products;

    @ManyToMany(targetEntity = Membership.class, fetch = FetchType.LAZY)
    @JoinTable(name = "orders_memberships",
            joinColumns = @JoinColumn(name = "order_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "membership_id", referencedColumnName = "id")
    )
    private List<Membership> memberships;
}
