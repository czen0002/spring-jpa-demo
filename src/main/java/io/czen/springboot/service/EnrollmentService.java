package io.czen.springboot.service;

import io.czen.springboot.entity.CourseEntity;
import io.czen.springboot.entity.EnrollmentEntity;
import io.czen.springboot.entity.StudentEntity;
import io.czen.springboot.model.Course;
import io.czen.springboot.model.Enrollment;
import io.czen.springboot.model.Student;
import io.czen.springboot.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnrollmentService {
  private final EnrollmentRepository enrollmentRepository;

  public EnrollmentService(EnrollmentRepository enrollmentRepository) {
    this.enrollmentRepository = enrollmentRepository;
  }

  // Retrieve all enrollments
  public List<EnrollmentEntity> getAllEnrollments() {
    return enrollmentRepository.findAll();
  }

  // Create a new enrollment
  public EnrollmentEntity createEnrollment(Enrollment enrollment) {
    // Ensure the student and course exist
    Student student = enrollment.getStudent();
    Course course = enrollment.getCourse();
    StudentEntity studentEntity =
        StudentEntity.builder().name(student.getName()).email(student.getEmail()).build();

    CourseEntity courseEntity =
        CourseEntity.builder()
            .courseName(course.getCourseName())
            .credits(course.getCredits())
            .build();

    EnrollmentEntity enrollmentEntity =
        EnrollmentEntity.builder()
            .studentEntity(studentEntity)
            .courseEntity(courseEntity)
            .enrollmentDate(enrollment.getEnrollmentDate())
            .build();
    return enrollmentRepository.save(enrollmentEntity);
  }

  // Delete an enrollment by ID
  public void deleteEnrollment(Long id) {
    enrollmentRepository.deleteById(id);
  }

  // Optional: Retrieve a specific enrollment by ID
  public EnrollmentEntity getEnrollmentById(Long id) {
    return enrollmentRepository.findById(id).orElse(null);
  }
}
