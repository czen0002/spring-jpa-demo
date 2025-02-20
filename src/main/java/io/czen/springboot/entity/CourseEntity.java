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
@Table(name = "Course")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CourseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "courseid")
  private Long courseId;

  @Column(name = "coursename", nullable = false, length = 100)
  private String courseName;

  @Column(nullable = false)
  private int credits;

  @OneToMany(mappedBy = "courseEntity", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonManagedReference
  private List<EnrollmentEntity> enrollmentEntities = new ArrayList<>();
}