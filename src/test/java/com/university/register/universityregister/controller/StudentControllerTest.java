package com.university.register.universityregister.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.university.register.universityregister.dto.request.StudentRequest;
import com.university.register.universityregister.dto.request.StudentUpdateRequest;
import com.university.register.universityregister.dto.response.StudentResponse;
import com.university.register.universityregister.repository.StudentRepository;
import com.university.register.universityregister.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(StudentController.class)
public class StudentControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private StudentService studentService;

  @MockBean
  private StudentRepository studentRepository;

  @Test
  void create() throws Exception{

    when(studentService.create(any(StudentRequest.class))).thenReturn(getStudentResponse());

    mockMvc.perform(
        MockMvcRequestBuilders
            .post("/v1/api/student")
            .contentType("application/json")
            .content(asJsonString(getStudentUpdateRequest()))
    ).andExpect(MockMvcResultMatchers.status().isCreated())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists());
  }


  private StudentUpdateRequest getStudentUpdateRequest() {
    StudentUpdateRequest studentUpdateRequest = new StudentUpdateRequest();
    studentUpdateRequest.setName("Elcin");
    studentUpdateRequest.setLastName("Orceliyev");
    studentUpdateRequest.setGroupNo("32eef43");
    studentUpdateRequest.setStudentCode("4564f3");

    return studentUpdateRequest;
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

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
