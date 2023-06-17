package com.university.register.universityregister.repository;

import com.university.register.universityregister.domain.Student;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

   List<Student>  findStudentByGroupNo(String grupNo);

   List<Student> findStudentByProfession(String profession);

    Optional<Student> findStudentByGroupNoAndStudentCode(String groupNo, String studentCode);

}
