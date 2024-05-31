package org.happybaras.onlinecoursesystem.repositories;

import org.happybaras.onlinecoursesystem.domain.entities.Course;
import org.happybaras.onlinecoursesystem.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findOneByUsernameOrEmail(String username, String email);
    Optional<User> findOneByActiveAndUsernameOrEmail(Boolean active, String username, String email);
}
