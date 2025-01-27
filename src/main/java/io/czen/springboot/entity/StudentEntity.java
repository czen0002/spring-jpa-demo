package io.czen.springboot.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Student")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "studentid")
  private Long studentId;

  @Column(nullable = false, length = 100)
  private String name;

  @Column(nullable = false, unique = true, length = 150)
  private String email;

  @Column
  private Integer age;

  @OneToMany(mappedBy = "studentEntity", cascade = CascadeType.PERSIST, orphanRemoval = true)
  @JsonManagedReference
  private List<EnrollmentEntity> enrollmentEntities = new ArrayList<>();
}