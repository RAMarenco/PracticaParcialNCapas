package org.happybaras.onlinecoursesystem.repositories;

import org.happybaras.onlinecoursesystem.domain.entities.Token;
import org.happybaras.onlinecoursesystem.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TokenRepository extends JpaRepository<Token, UUID> {
    List<Token> findByUserAndActive(User user, Boolean active);
}
