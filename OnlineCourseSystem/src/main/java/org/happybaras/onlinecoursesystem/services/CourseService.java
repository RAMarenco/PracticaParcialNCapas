package org.happybaras.onlinecoursesystem.services;

import org.happybaras.onlinecoursesystem.domain.dtos.CourseDTO;
import org.happybaras.onlinecoursesystem.domain.entities.Course;
import org.happybaras.onlinecoursesystem.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface CourseService {
    List<User> findAllByCourse(Course course);
    List<Course> findAll();
    Course findById(UUID id);
    void create(CourseDTO info, User user);
}
