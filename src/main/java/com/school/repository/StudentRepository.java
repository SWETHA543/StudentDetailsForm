package com.school.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.school.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, Integer>{

	Optional<Student> findByName(String stuname);

	Optional<Student> findByNumber(Long stunumber);

}
