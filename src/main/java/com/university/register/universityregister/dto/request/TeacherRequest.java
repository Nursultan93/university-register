package com.university.register.universityregister.dto.request;

import com.university.register.universityregister.domain.Profession;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
public class TeacherRequest {

    private String firstName;
    private String lastName;

}
