package io.czen.springboot.service;

import io.czen.springboot.entity.CourseEntity;
import io.czen.springboot.model.Course;
import io.czen.springboot.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
  private final CourseRepository courseRepository;

  public CourseService(CourseRepository courseRepository) {
    this.courseRepository = courseRepository;
  }

  public List<CourseEntity> getAllCourses() {
    return courseRepository.findAll();
  }

  public CourseEntity createCourse(Course course) {
    CourseEntity courseEntity =
        CourseEntity.builder()
            .courseName(course.getCourseName())
            .credits(course.getCredits())
            .build();
    return courseRepository.save(courseEntity);
  }

  public void deleteCourse(Long id) {
    courseRepository.deleteById(id);
  }

  public CourseEntity getCourseById(Long id) {
    return courseRepository.findById(id).orElse(null);
  }
}
