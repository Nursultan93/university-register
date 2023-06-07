package com.university.register.universityregister.dto.request;

import lombok.Data;

@Data
public class StudentUpdateRequest {

  private String name;
  private String lastName;
  private String birthDate;
  private String profession;
  private String groupNo;
  private String studentCode;

}
