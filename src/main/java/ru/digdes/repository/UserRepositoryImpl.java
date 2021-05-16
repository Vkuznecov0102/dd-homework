package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Long countUserByLogin(String login) {
        return (Long) entityManager.createQuery("select count(*) from User u where name='" + login + "'").getSingleResult();
    }

    @Override
    public Optional<User> getUserById(long id) {
        return Optional.ofNullable(entityManager.find(User.class, id));
    }

    @Override
    public void saveUser(User user) {
        if (user.getId() == 0L) {
            entityManager.persist(user);
        }
        entityManager.merge(user);
    }

    @Override
    public void updateUserByPassword(User user) {
        entityManager.merge(user);
    }

    @Override
    public void updateUserByLogin(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = entityManager.find(User.class, id);
        entityManager.remove(user);
    }

    @Override
    public List<User> findAll() {
        Query query = entityManager.createQuery("SELECT u FROM User u");
        return query.getResultList();
    }

    @Override
    public Object getUserByLogin(String login) {
        return entityManager.createQuery("select u from User u where user.login='" + login + "'").getSingleResult();
    }
}
