package com.university.register.universityregister.service;

import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.domain.Teacher;
import com.university.register.universityregister.dto.request.StudentRequest;
import com.university.register.universityregister.dto.request.StudentUpdateRequest;
import com.university.register.universityregister.dto.request.TeacherRequest;
import com.university.register.universityregister.dto.request.TeacherUpadateRequest;
import com.university.register.universityregister.dto.response.StudentResponse;
import com.university.register.universityregister.dto.response.TeacherResponse;
import com.university.register.universityregister.repository.ProfessionRepository;
import com.university.register.universityregister.repository.StudentRepository;
import com.university.register.universityregister.repository.TecaherRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TecaherRepository tecaherRepository;
    private final ProfessionRepository professionRepository;
    private final ModelMapper mapper;

    public TeacherResponse create(TeacherRequest request) {

        var teacher = mapper.map(request, Teacher.class);

        var teachertNew = tecaherRepository.save(teacher);

        var response = mapper.map(teachertNew, TeacherResponse.class);

        return response;
    }

    public List<TeacherResponse> getAllStudent() {

        List<Teacher> teacherList = tecaherRepository.findAll();

        List<TeacherResponse> teacherResponseList = teacherList.stream().map(itm ->
                mapper.map(itm, TeacherResponse.class)
        ).collect(Collectors.toList());

        return teacherResponseList;
    }

    public void delete(Integer id){
        tecaherRepository.deleteById(id);
    }
}

