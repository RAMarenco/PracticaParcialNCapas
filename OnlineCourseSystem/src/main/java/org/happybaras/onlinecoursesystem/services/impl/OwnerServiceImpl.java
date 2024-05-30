package org.happybaras.onlinecoursesystem.services.impl;

import org.happybaras.onlinecoursesystem.domain.entities.Course;
import org.happybaras.onlinecoursesystem.domain.entities.User;
import org.happybaras.onlinecoursesystem.repositories.OwnerRepository;
import org.happybaras.onlinecoursesystem.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerServiceImpl(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public void deleteOwnerByEmail(String email) {
        ownerRepository.deleteOwnerByEmail(email);
    }

    @Override
    public User getOwnerByEmail(String email) {
        return ownerRepository.getOwnerByEmail(email);
    }

    @Override
    public List<Course> getOwnerCourses(String email) {
        return ownerRepository.getOwnerCourses(email);
    }

    @Override
    public void createCourse(String ownerEmail, Course course) {
        ownerRepository.createCourse(ownerEmail, course);
    }

    @Override
    public void deleteCourse(String ownerEmail, UUID courseId) {
        ownerRepository.deleteCourse(ownerEmail, courseId);
    }
}
