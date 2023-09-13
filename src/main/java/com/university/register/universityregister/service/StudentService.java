package com.university.register.universityregister.service;

import com.university.register.universityregister.domain.Profession;
import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.dto.request.StudentRequest;
import com.university.register.universityregister.dto.request.StudentUpdateRequest;
import com.university.register.universityregister.dto.response.StudentResponse;
import com.university.register.universityregister.exception.StudentNotFound;
import com.university.register.universityregister.repository.ProfessionRepository;
import com.university.register.universityregister.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StudentService {

  private final StudentRepository studentRepository;
  private final ProfessionRepository professionRepository;
  private final ModelMapper mapper;

  public StudentResponse create(StudentRequest request) {

    var student = mapper.map(request, Student.class);

    var studentNew = studentRepository.save(student);

    var response = mapper.map(studentNew, StudentResponse.class);

    return response;
  }

  public List<StudentResponse> getAllStudent() {

    List<Student> studentList = studentRepository.findAll();

    List<StudentResponse> studentResponseList = studentList.stream().map(itm ->
      mapper.map(itm, StudentResponse.class)
    ).collect(Collectors.toList());

    return studentResponseList;
  }

  public StudentResponse update(StudentUpdateRequest request, Integer id) {

    var student = studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Bazada telebe yoxdur"));

    student = mapper.map(request, Student.class);
    student.setId(id);

    var studentNew =  studentRepository.save(student);

    var studentResponse = mapper.map(studentNew, StudentResponse.class);

    return studentResponse;

  }

  public void delete(Integer id){
    studentRepository.deleteById(id);
  }

  public StudentResponse getStudentByGroupNoAndStudentCode(String groupNo, String studentCode) {

    var student = studentRepository.findStudentByGroupNoAndStudentCode(groupNo, studentCode)
        .orElseThrow(() -> new StudentNotFound("Bazada melumat yoxdur"));

    var studentResponse = mapper.map(student, StudentResponse.class);

    return studentResponse;
  }

  public List<StudentResponse> findByStudentGroupNo(String groupNo){

    List<Student> studentList = studentRepository.findStudentByGroupNo(groupNo);

    List<StudentResponse> studentResponseList = studentList.stream().map(itm ->
            mapper.map(itm, StudentResponse.class)
    ).collect(Collectors.toList());

    return studentResponseList;
  }

  public List<StudentResponse> finByStudentProfession(String name){

    Profession profession = professionRepository.findProfessionByName(name).orElseThrow(() -> new RuntimeException("Yoxudur"));

    var studentList = studentRepository.findStudentByProfession(profession);

    List<StudentResponse> studentResponseList = studentList.stream().map(itm ->
        mapper.map(itm, StudentResponse.class)
    ).collect(Collectors.toList());

    return studentResponseList;

  }

  public Student getStudentById(Integer id){

    return studentRepository.findById(id).get();

  }

}


