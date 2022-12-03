package com.example.testsequrity2dbthemelyf.repository;

import com.example.testsequrity2dbthemelyf.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
