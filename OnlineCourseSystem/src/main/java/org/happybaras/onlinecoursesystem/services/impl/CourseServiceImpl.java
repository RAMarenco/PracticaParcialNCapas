package org.happybaras.onlinecoursesystem.services.impl;

import org.happybaras.onlinecoursesystem.domain.dtos.CourseDTO;
import org.happybaras.onlinecoursesystem.domain.entities.Course;
import org.happybaras.onlinecoursesystem.domain.entities.User;
import org.happybaras.onlinecoursesystem.repositories.CourseRepository;
import org.happybaras.onlinecoursesystem.services.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;

    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<User> findAllByCourse(Course course) {
        return course.getUsers();
    }

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Course findById(UUID id) {
        return courseRepository.findById(id).orElse(null);
    }

    @Override
    public void create(CourseDTO info, User user) {
        Course course = new Course();

        course.setName(info.getName());
        course.setOwner(user);

        courseRepository.save(course);
    }
}
