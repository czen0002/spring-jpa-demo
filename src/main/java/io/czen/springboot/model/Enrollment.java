package io.czen.springboot.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Enrollment {
  private Student student;
  private Course course;
  private LocalDate enrollmentDate;
}
