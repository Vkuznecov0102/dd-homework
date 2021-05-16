package ru.digdes.services;

import ru.digdes.domains.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Long countUserByLogin(String login);

    Optional<User> getUserById(long id);

    void insertUser(User user);

    void updateUserByPassword(User user);

    void updateUserByLogin(User user);

    void deleteUser(long id);

    List<User> findAll();

    Object getUserByLogin(String login);
}
