package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.Version;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class VersionRepositoryImpl implements VersionRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Long countVersionByDocumentId(Long userId) {
        return (Long) entityManager.createQuery("select count(*) from Version v where user_id='" + userId + "'").getSingleResult();
    }

    @Override
    public Optional<Version> getVersionById(long id) {
        return Optional.ofNullable(entityManager.find(Version.class, id));
    }

    @Override
    public void insertVersion(Version version) {
        if (version.getId() == 0L) {
            entityManager.persist(version);
        }
        entityManager.merge(version);
    }

    @Override
    public void updateVersion(Version version) {
        entityManager.merge(version);
    }

    @Override
    public void deleteVersion(long id) {
        Version version = entityManager.find(Version.class, id);
        entityManager.remove(version);
    }

    @Override
    public List<Version> findAll() {
        Query query = entityManager.createQuery("SELECT v FROM Version v");
        return query.getResultList();
    }
}
