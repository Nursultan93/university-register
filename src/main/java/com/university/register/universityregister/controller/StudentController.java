package com.university.register.universityregister.controller;

import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.dto.request.StudentRequest;
import com.university.register.universityregister.dto.response.StudentResponse;
import com.university.register.universityregister.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/student")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @PostMapping
  public ResponseEntity<StudentResponse> create(@RequestBody StudentRequest student){
    return new ResponseEntity<>(studentService.create(student), HttpStatus.CREATED);
  }

  @GetMapping
  public List<Student> getAll(){
    return studentService.getAllStudent();
  }

  @PutMapping("/{id}")
  public Student update(@RequestBody Student student, @PathVariable Integer id){
    return studentService.update(student, id);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    studentService.delete(id);
  }

}
