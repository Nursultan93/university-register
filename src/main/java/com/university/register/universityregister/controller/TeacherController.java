package com.university.register.universityregister.controller;

import com.university.register.universityregister.dto.request.StudentRequest;
import com.university.register.universityregister.dto.request.TeacherRequest;
import com.university.register.universityregister.dto.response.StudentResponse;
import com.university.register.universityregister.dto.response.TeacherResponse;
import com.university.register.universityregister.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/teacher")
@RequiredArgsConstructor
public class TeacherController {
    private  final TeacherService teacherService;

    @PostMapping
    public ResponseEntity<TeacherResponse> create(@RequestBody TeacherRequest tecar){
        return new ResponseEntity<>(teacherService.create(tecar), HttpStatus.CREATED);
    }

    @GetMapping
    public List<TeacherResponse> getAll(){
        return teacherService.getAllStudent();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        teacherService.delete(id);
    }
}
