package ru.digdes.services;

import ru.digdes.domains.User;

import java.util.List;

public interface UserService {
    User getUserById(long id);

    void insertUser(User user);

    void updateUserByPassword(User user);

    void updateUserByLogin(User user);

    void deleteUser(long id);

    List<User> findAll();
}
