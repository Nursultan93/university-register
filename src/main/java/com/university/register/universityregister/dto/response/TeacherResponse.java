package com.university.register.universityregister.dto.response;

import com.university.register.universityregister.domain.Profession;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class TeacherResponse {
    private Integer id;
    private String firstName;
    private String lastName;
    private ProfessionResponse professionResponse;
}
