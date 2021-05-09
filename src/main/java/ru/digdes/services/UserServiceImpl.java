package ru.digdes.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digdes.domains.User;
import ru.digdes.repository.UserRepository;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {
    private final UserRepository repository;


    @Override
    public User getUserById(long id) {
        return repository.getUserById(id);
    }

    @Override
    public void insertUser(User user) {
        repository.insertUser(user);
    }

    @Override
    public void updateUserByPassword(User user) {
        repository.updateUserByPassword(user);
    }

    @Override
    public void updateUserByLogin(User user) {
        repository.updateUserByLogin(user);
    }

    @Override
    public void deleteUser(long id) {
        repository.deleteUser(id);
    }

    @Override
    public List<User> findAll() {
        return repository.findAll();
    }
}