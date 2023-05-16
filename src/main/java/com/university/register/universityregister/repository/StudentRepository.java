package com.university.register.universityregister.repository;

import com.university.register.universityregister.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
