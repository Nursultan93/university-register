package com.university.register.universityregister.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "Students")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Integer id;
  @Column(name = "first_name")
  private String name;
  private String lastName;
  private String birthDate;
  private String groupNo;
  @Column(unique = true)
  private String studentCode;
  @ManyToOne(cascade = CascadeType.MERGE)
  @JoinColumn(name = "profession_id")
  private Profession profession;

}
