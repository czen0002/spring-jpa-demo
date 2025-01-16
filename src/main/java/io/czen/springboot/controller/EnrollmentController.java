package io.czen.springboot.controller;

import io.czen.springboot.entity.EnrollmentEntity;
import io.czen.springboot.model.Enrollment;
import io.czen.springboot.service.EnrollmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/enrollment")
public class EnrollmentController {
  private final EnrollmentService enrollmentService;

  public EnrollmentController(EnrollmentService enrollmentService) {
    this.enrollmentService = enrollmentService;
  }

  // Get all enrollments
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<EnrollmentEntity> getEnrollments() {
    return enrollmentService.getAllEnrollments();
  }

  // Create a new enrollment
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public EnrollmentEntity postEnrollment(@RequestBody Enrollment enrollment) {
    return enrollmentService.createEnrollment(enrollment);
  }

  // Delete an enrollment by ID
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Void deleteEnrollment(@PathVariable Long id) {
    enrollmentService.deleteEnrollment(id);
    return null;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public EnrollmentEntity getEnrollment(@PathVariable Long id) {
    return enrollmentService.getEnrollmentById(id);
  }
}
