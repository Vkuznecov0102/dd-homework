package ru.digdes.repository;

import ru.digdes.domains.User;

import java.util.List;

public interface UserRepository {
    User getUserById(long id);

    void insertUser(User user);

    void updateUserByPassword(User user);

    void updateUserByLogin(User user);

    void deleteUser(long id);

    List<User> findAll();
}
