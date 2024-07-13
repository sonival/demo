package com.demojwt.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demojwt.security.user.User;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);

}
