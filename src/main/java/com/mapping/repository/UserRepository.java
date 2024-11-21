package com.mapping.repository;

import com.mapping.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    public User findByMobile(String mobile);
    public User findByEmail(String email);
}