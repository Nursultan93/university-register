package com.university.register.universityregister.controller;

import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.service.StudentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
  @GetMapping("/item")
  public List<Student> getByGrupNo(@RequestParam("grupNo") String grupNo){
    return studentService.findByStudentGropNo(grupNo);
  }
  @GetMapping("/{profession}")
  public List<Student> getByPrpfession(@PathVariable String profession){
    return studentService.finByStudentProfession(profession);
  }


}
