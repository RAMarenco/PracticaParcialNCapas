package org.happybaras.onlinecoursesystem.services;

import org.happybaras.onlinecoursesystem.domain.dtos.UserLoginDTO;
import org.happybaras.onlinecoursesystem.domain.dtos.UserRegisterDTO;
import org.happybaras.onlinecoursesystem.domain.entities.Course;
import org.happybaras.onlinecoursesystem.domain.entities.Token;
import org.happybaras.onlinecoursesystem.domain.entities.User;

import java.util.List;

public interface UserService {
    // Token management
    Token registerToken(User user) throws Exception;

    Boolean isTokenValid(User user, String token);

    void cleanTokens(User user) throws Exception;

    User findUserAuthenticated() throws Exception;

    User findOneByIdentifier(String identifier);

    User findByUsernameOrEmail(UserRegisterDTO info);

    boolean checkPassword(User user, String password);

    void createUser(UserRegisterDTO info);

    List<Course> findAllCoursesByUser(User user);
}
