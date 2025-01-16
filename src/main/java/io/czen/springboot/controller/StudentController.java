package io.czen.springboot.controller;

import io.czen.springboot.entity.StudentEntity;
import io.czen.springboot.model.Student;
import io.czen.springboot.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/student")
@Validated
public class StudentController {
  private final StudentService studentService;

  public StudentController(StudentService studentService) {
    this.studentService = studentService;
  }

  // Get all students
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<StudentEntity> getStudents() {
    return studentService.getAllStudents();
  }

  // Create a new student
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public StudentEntity postStudent(@Valid @RequestBody Student student) {
    return studentService.createStudent(student);
  }

  // Delete a student by ID
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Void deleteStudent(@PathVariable Long id) {
    studentService.deleteStudent(id);
    return null;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public StudentEntity getStudent(@PathVariable Long id) {
    return studentService.getStudentById(id);
  }
}
