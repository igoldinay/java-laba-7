package com.example.testsequrity2dbthemelyf.repository;

import com.example.testsequrity2dbthemelyf.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
