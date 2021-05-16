package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.Catalog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class CatalogRepositoryImpl implements CatalogRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Long countCatalogByName(String name) {
        return (Long) entityManager.createQuery("select count(*) from Catalog c where name='" + name + "'").getSingleResult();
    }

    @Override
    public Optional<Catalog> getCatalogById(long id) {
        return Optional.ofNullable(entityManager.find(Catalog.class, id));
    }

    @Override
    public void insertCatalog(Catalog catalog) {
        if (catalog.getId() == 0L) {
            entityManager.persist(catalog);
        }
        entityManager.merge(catalog);
    }

    @Override
    public void updateCatalog(Catalog catalog) {
        entityManager.merge(catalog);
    }

    @Override
    public void deleteCatalog(long id) {
        Catalog catalog = entityManager.find(Catalog.class, id);
        entityManager.remove(catalog);
    }

    @Override
    public List<Catalog> findAll() {
        Query query = entityManager.createQuery("SELECT c FROM Catalog c");
        return query.getResultList();
    }
}
