package org.happybaras.onlinecoursesystem.controllers;

import org.happybaras.onlinecoursesystem.domain.entities.Course;
import org.happybaras.onlinecoursesystem.domain.entities.User;
import org.happybaras.onlinecoursesystem.services.OwnerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @DeleteMapping("/{email}")
    public void deleteOwnerByEmail(@PathVariable String email) {
        ownerService.deleteOwnerByEmail(email);
    }

    @GetMapping("/{email}")
    public User getOwnerByEmail(@PathVariable String email) {
        return ownerService.getOwnerByEmail(email);
    }

    @GetMapping("/{email}/courses")
    public List<Course> getOwnerCourses(@PathVariable String email) {
        return ownerService.getOwnerCourses(email);
    }

    @PostMapping("/{email}/courses")
    public void createCourse(@PathVariable String email, @RequestBody Course course) {
        ownerService.createCourse(email, course);
    }

    @DeleteMapping("/{email}/courses/{courseId}")
    public void deleteCourse(@PathVariable String email, @PathVariable UUID courseId) {
        ownerService.deleteCourse(email, courseId);
    }
}
