package com.university.register.universityregister.service;

import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.dto.request.StudentRequest;
import com.university.register.universityregister.dto.response.StudentResponse;
import com.university.register.universityregister.repository.StudentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;
  private final ModelMapper mapper;

  public StudentResponse create(StudentRequest request) {

    var student = mapper.map(request, Student.class);

    var studentNew = studentRepository.save(student);

    var response = mapper.map(studentNew, StudentResponse.class);

    return response;
  }

  public List<Student> getAllStudent() {
    return studentRepository.findAll();
  }

  public Student update(Student student, Integer id) {

//    var studentDb = studentRepository.findById(id).get();
//
//    return studentNew;
    return null;
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


