package org.happybaras.onlinecoursesystem.services.impl;

import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.happybaras.onlinecoursesystem.domain.dtos.UserRegisterDTO;
import org.happybaras.onlinecoursesystem.domain.entities.Course;
import org.happybaras.onlinecoursesystem.domain.entities.Token;
import org.happybaras.onlinecoursesystem.domain.entities.User;
import org.happybaras.onlinecoursesystem.repositories.TokenRepository;
import org.happybaras.onlinecoursesystem.repositories.UserRepository;
import org.happybaras.onlinecoursesystem.services.UserService;
import org.happybaras.onlinecoursesystem.utils.JWTTools;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final JWTTools jwtTools;
    private final PasswordEncoder passwordEncoder;

    private final TokenRepository tokenRepository;

    public UserServiceImpl(JWTTools jwtTools, TokenRepository tokenRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.jwtTools = jwtTools;
        this.tokenRepository = tokenRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public Token registerToken(User user) throws Exception {
        cleanTokens(user);

        String tokenString = jwtTools.generateToken(user);
        Token token = new Token(tokenString, user);

        tokenRepository.save(token);

        return token;
    }

    @Override
    public Boolean isTokenValid(User user, String token) {
        try {
            cleanTokens(user);
            List<Token> tokens = tokenRepository.findByUserAndActive(user, true);

            tokens.stream()
                    .filter(tk -> tk.getContent().equals(token))
                    .findAny()
                    .orElseThrow(Exception::new);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void cleanTokens(User user) throws Exception {
        List<Token> tokens = tokenRepository.findByUserAndActive(user, true);

        tokens.forEach(token -> {
            if (!jwtTools.verifyToken(token.getContent())) {
                token.setActive(false);
                tokenRepository.save(token);
            }
        });
    }

    @Override
    public User findUserAuthenticated() {
        String identifier = SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();

        return userRepository.findOneByUsernameOrEmail(identifier, identifier).orElse(null);
    }

    @Override
    public User findOneByIdentifier(String identifier) {
        return userRepository.findOneByActiveAndUsernameOrEmail(true, identifier, identifier).orElse(null);
    }

    @Override
    public User findByUsernameOrEmail(UserRegisterDTO info) {
        return userRepository.findOneByUsernameOrEmail(info.getUsername(), info.getEmail()).orElse(null);
    }

    @Override
    public boolean checkPassword(User user, String password) {
        return passwordEncoder.matches(password, user.getPassword());
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public void createUser(UserRegisterDTO info) {
        User user = new User();

        user.setUsername(info.getUsername());
        user.setEmail(info.getEmail());
        String encryptedPassword = passwordEncoder.encode(info.getPassword());
        user.setPassword(encryptedPassword);

        userRepository.save(user);
    }

    @Override
    public List<Course> findAllCoursesByUser(User user) {
        return user.getCourses();
    }
}