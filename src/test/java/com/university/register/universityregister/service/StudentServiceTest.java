package com.university.register.universityregister.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.dto.request.StudentRequest;
import com.university.register.universityregister.dto.request.StudentUpdateRequest;
import com.university.register.universityregister.dto.response.StudentResponse;
import com.university.register.universityregister.mapper.StudentMapper;
import com.university.register.universityregister.repository.StudentRepository;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

  @InjectMocks
  private StudentService studentService;

  @Mock
  private StudentRepository studentRepository;

  @Mock
  private ModelMapper mapper;

  @Test
  void givenValidParameterThenCreateSuccess() {

    var result = getStudentResponse();

    when(studentRepository.save(any(Student.class))).thenReturn(getStudent());
    when(mapper.map(any(StudentRequest.class), eq(Student.class))).thenReturn(getStudent());
    when(mapper.map(any(Student.class), eq(StudentResponse.class))).thenReturn(getStudentResponse());

    StudentResponse response = studentService.create(getStudentRequest());

    assertEquals(result.getId(), response.getId());
    assertEquals(result.getName(), response.getName());
    assertEquals(result.getGroupNo(), response.getGroupNo());

  }

  @Test
  void givenValidParamThenUpdateSuccess() {

    var result = getStudentResponse();

    when(studentRepository.findById(any(Integer.class))).thenReturn(Optional.of(getStudent()));
    when(mapper.map(any(StudentUpdateRequest.class), eq(Student.class))).thenReturn(getStudent());
    when(studentRepository.save(any(Student.class))).thenReturn(getStudent());
    when(mapper.map(any(Student.class), eq(StudentResponse.class))).thenReturn(getStudentResponse());

    var response = studentService.update(getStudentUpdateRequest(), 1);

    assertEquals(result.getId(), response.getId());
    assertEquals(result.getName(), response.getName());
    assertEquals(result.getGroupNo(), response.getGroupNo());

  }

  @Test
  void givenValidParamThenUpdateException() {
    when(studentRepository.findById(any(Integer.class))).thenReturn(Optional.empty());

    assertThatThrownBy(() -> studentService.update(getStudentUpdateRequest(), 1))
        .hasMessage("Bazada telebe yoxdur")
        .isInstanceOf(RuntimeException.class);
  }


  private Student getStudent() {
    Student student = new Student();
    student.setId(1);
    student.setName("Elcin");
    student.setLastName("Orceliyev");
    student.setGroupNo("32eef43");
    student.setStudentCode("4564f3");

    return student;
  }

  private StudentUpdateRequest getStudentUpdateRequest() {
    StudentUpdateRequest studentUpdateRequest = new StudentUpdateRequest();
    studentUpdateRequest.setName("Elcin");
    studentUpdateRequest.setLastName("Orceliyev");
    studentUpdateRequest.setGroupNo("32eef43");
    studentUpdateRequest.setStudentCode("4564f3");

    return studentUpdateRequest;
  }



  private StudentRequest getStudentRequest() {
    StudentRequest studentRequest = new StudentRequest();
    studentRequest.setName("Elcin");
    studentRequest.setLastName("Orceliyev");
    studentRequest.setEmail("elcin@gmail.com");
    studentRequest.setPhone("+994444444");
    studentRequest.setGroupNo("32eef43");
    studentRequest.setStudentCode("4564f3");

    return studentRequest;
  }


  private StudentResponse getStudentResponse() {
    StudentResponse studentResponse = new StudentResponse();
    studentResponse.setId(1);
    studentResponse.setName("Elcin");
    studentResponse.setLastName("Orceliyev");
    studentResponse.setGroupNo("32eef43");
    studentResponse.setStudentCode("4564f3");


    return studentResponse;
  }

}
