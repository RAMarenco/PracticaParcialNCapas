package org.happybaras.onlinecoursesystem.repositories;

import org.happybaras.onlinecoursesystem.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findOneByUsernameOrEmail(String username, String email);
    Optional<User> findOneByActiveAndUsernameOrEmail(Boolean active, String username, String email);
}
