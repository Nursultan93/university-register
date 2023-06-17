package com.university.register.universityregister;

import com.university.register.universityregister.domain.Student;
import com.university.register.universityregister.repository.StudentRepository;
import com.university.register.universityregister.service.StudentService;
import java.util.Arrays;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class UniversityRegisterApplication implements ApplicationRunner {

  private final StudentRepository studentRepository;

  public static void main(String[] args) {
    SpringApplication.run(UniversityRegisterApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {

    Student elcin = Student.builder()
        .name("Elcin")
        .lastName("Orceliyev")
        .birthDate("12.01.1992")
        .profession("IT")
        .groupNo("2RUDF")
        .studentCode("34DSW").build();

    Student ayaz = Student.builder()
        .name("Ayaz")
        .lastName("Mirzeyev")
        .birthDate("07.03.1994")
        .profession("DB")
        .groupNo("9ISB3")
        .studentCode("ASJOD4").build();

    Student arif = Student.builder()
            .name("arif")
            .lastName("agayev")
            .birthDate("07.03.1994")
            .profession("DB")
            .groupNo("9ISB3")
            .studentCode("4585285").build();

    studentRepository.saveAll(Arrays.asList(elcin, ayaz,arif));

  }

}
