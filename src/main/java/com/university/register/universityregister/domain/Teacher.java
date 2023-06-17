package com.university.register.universityregister.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Teachers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  private String firstName;
  private String lastName;
  @ManyToOne
  private Profession profession;
}
