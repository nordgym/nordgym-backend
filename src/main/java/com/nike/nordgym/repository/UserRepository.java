package com.nike.nordgym.repository;

import com.nike.nordgym.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findBySubscriptionNumber(String subscriptionNumber);
}
