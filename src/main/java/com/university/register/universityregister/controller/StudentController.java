package com.university.register.universityregister.controller;

import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/api/student")
@RequiredArgsConstructor
public class StudentController {

  private final StudentService studentService;

  @PostMapping
  public Student create(@RequestBody Student student){
    return studentService.create(student);
  }

  @GetMapping
  public List<Student> getAll(){
    return studentService.getAllStudent();
  }

  @PutMapping
  public Student update(@RequestBody Student student){
    return studentService.update(student);
  }

  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id) {
    studentService.delete(id);
  }

}
