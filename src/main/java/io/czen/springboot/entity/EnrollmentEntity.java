package io.czen.springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "Enrollment", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"student_id", "course_id"})
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnrollmentEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "enrollmentid")
  private Long enrollmentId;

  @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.REMOVE,  CascadeType.PERSIST})
  @JoinColumn(name = "studentid", nullable = false, foreignKey = @ForeignKey(name = "fk_student"))
  @JsonBackReference
  private StudentEntity studentEntity;

  @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "courseid", nullable = false, foreignKey = @ForeignKey(name = "fk_course"))
  @JsonBackReference
  private CourseEntity courseEntity;

  @Column(name = "enrollmentdate", nullable = false)
  private LocalDate enrollmentDate = LocalDate.now();
}