package com.example.testsequrity2dbthemelyf.repository;

import com.example.testsequrity2dbthemelyf.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
}
