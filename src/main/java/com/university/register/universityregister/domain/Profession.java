package com.university.register.universityregister.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Professions")
@NoArgsConstructor
@AllArgsConstructor
public class Profession {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String name;
  @OneToMany(cascade = CascadeType.MERGE, mappedBy = "profession")
  private List<Student> student;
  @OneToMany(cascade = CascadeType.MERGE, mappedBy = "profession")
  private List<Teacher> teacher;

}
