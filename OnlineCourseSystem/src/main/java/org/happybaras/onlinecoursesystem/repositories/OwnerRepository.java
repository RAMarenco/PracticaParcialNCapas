package org.happybaras.onlinecoursesystem.repositories;

import org.happybaras.onlinecoursesystem.domain.entities.Course;
import org.happybaras.onlinecoursesystem.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OwnerRepository extends JpaRepository<User, UUID>{
    void deleteOwnerByEmail(String email);

    User getOwnerByEmail(String email);

    List<Course> getOwnerCourses(String email);

    void createCourse(String ownerEmail, Course course);

    void deleteCourse(String ownerEmail, UUID courseId);
}
