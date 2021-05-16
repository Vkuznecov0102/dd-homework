package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.Administrator;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class AdministratorRepositoryImpl implements AdministratorRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Long countAdministratorById(Long id) {
        return (Long) entityManager.createQuery("select count(*) from Administrator a where user_id='" + id + "'").getSingleResult();
    }


    @Override
    public Optional<Administrator> getAdministratorById(long id) {
        return Optional.ofNullable(entityManager.find(Administrator.class, id));
    }

    @Override
    public void insertAdministrator(Administrator administrator) {
        if (administrator.getId() == 0L) {
            entityManager.persist(administrator);
        }
        entityManager.merge(administrator);
    }

    @Override
    public void updateAdministrator(Administrator administrator) {
        entityManager.merge(administrator);
    }

    @Override
    public void deleteAdministrator(long id) {
        Administrator administrator = entityManager.find(Administrator.class, id);
        entityManager.remove(administrator);
    }

    @Override
    public List<Administrator> findAll() {
        Query query = entityManager.createQuery("SELECT a FROM Administrator a");
        return query.getResultList();
    }
}
