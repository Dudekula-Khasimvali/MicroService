package com.spring.micro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.micro.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}
