package com.university.register.universityregister.dto.request;

import com.university.register.universityregister.dto.response.ProfessionResponse;
import lombok.Data;

@Data
public class StudentRequest {

  private String name;
  private String lastName;
  private String birthDate;
  private String groupNo;
  private String studentCode;
  private ProfessionResponse profession;

}
