package com.university.register.universityregister.dto.request;

import com.university.register.universityregister.annotation.Phone;
import com.university.register.universityregister.dto.response.ProfessionResponse;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentRequest {

  @NotNull(message = "Ad bos ola bilmez")
  private String name;
  @NotNull(message = "Soyad bos ola bilmez")
  private String lastName;
  private String birthDate;
  private String groupNo;
  private String studentCode;
  @Phone
  private String phone;
  @Email(message = "email formata uygun deyil")
  private String email;
  private ProfessionResponse profession;

}
