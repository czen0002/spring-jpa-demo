package io.czen.springboot.controller;

import io.czen.springboot.entity.CourseEntity;
import io.czen.springboot.model.Course;
import io.czen.springboot.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/course")
public class CourseController {
  private final CourseService courseService;

  public CourseController(CourseService courseService) {
    this.courseService = courseService;
  }

  // Get all courses
  @GetMapping
  @ResponseStatus(HttpStatus.OK)
  public List<CourseEntity> getCourses() {
    return courseService.getAllCourses();
  }

  // Create a new course
  @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
  @ResponseStatus(HttpStatus.CREATED)
  public CourseEntity postCourse(@RequestBody Course course) {
    return courseService.createCourse(course);
  }

  // Delete a course by ID
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public Void deleteCourse(@PathVariable Long id) {
    courseService.deleteCourse(id);
    return null;
  }

  @GetMapping("/{id}")
  @ResponseStatus(HttpStatus.OK)
  public CourseEntity getCourse(@PathVariable Long id) {
    return courseService.getCourseById(id);
  }
}
