package com.university.register.universityregister.dto.request;


import com.university.register.universityregister.domain.Profession;
import com.university.register.universityregister.dto.response.ProfessionResponse;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Data;


@Data

public class TeacherUpadateRequest {

    private String firstName;
    private String lastName;
    private ProfessionResponse profession;
}
