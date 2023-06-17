package com.university.register.universityregister.repository;

import com.university.register.universityregister.domain.Profession;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessionRepository extends JpaRepository<Profession, Integer> {

  Optional<Profession> findProfessionByName(String name);
}
