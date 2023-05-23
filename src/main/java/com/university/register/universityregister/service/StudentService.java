package com.university.register.universityregister.service;

import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;

  public Student create(Student student) {
    var studentNew = studentRepository.save(student);

    return studentNew;
  }

  public List<Student> getAllStudent() {
    return studentRepository.findAll();
  }

  public Student update(Student student) {
    var studentNew = studentRepository.save(student);

    return studentNew;
  }

  public void delete(Integer id){
    studentRepository.deleteById(id);
  }

  public List<Student> findByStudentGropNo(String gruoNo){
    return studentRepository.findStudentByGroupNo(gruoNo);
  }

  public List<Student> finByStudentProfession(String profession){
    return studentRepository.findStudentByProfession(profession);
  }

  public Student getStudentById(Integer id){
    return studentRepository.findById(id).get();
  }

}


