package org.happybaras.onlinecoursesystem.services;

import org.happybaras.onlinecoursesystem.domain.entities.Assignment;
import org.happybaras.onlinecoursesystem.domain.entities.Course;
import org.happybaras.onlinecoursesystem.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface OwnerService {
    void deleteOwnerByEmail(String email);
    User getOwnerByEmail(String email);
    List<Course> getOwnerCourses(String email);
    void createCourse(String ownerEmail, Course course);
    void deleteCourse(String ownerEmail, UUID courseId);
}
