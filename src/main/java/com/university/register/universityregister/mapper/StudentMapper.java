package com.university.register.universityregister.mapper;

import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.dto.request.StudentRequest;
import com.university.register.universityregister.dto.response.StudentResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
    unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StudentMapper {

  StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

  @Mapping(target = "firstName", source = "name")
  @Mapping(target = "lastName", source = "lastName")
  @Mapping(target = "birthDate", source = "birthDate")
  @Mapping(target = "profession", source = "profession")
  @Mapping(target = "groupNo", source = "groupNo")
  @Mapping(target = "studentCode", source = "studentCode")
  Student mapRequestToStudent(StudentRequest request);

  @Mapping(target = "id", source = "id")
  @Mapping(target = "name", source = "firstName")
  @Mapping(target = "lastName", source = "lastName")
  @Mapping(target = "groupNo", source = "groupNo")
  @Mapping(target = "studentCode", source = "studentCode")
  StudentResponse mapStudentToResponse(Student student);

}
