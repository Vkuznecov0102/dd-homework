package ru.digdes.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import ru.digdes.domains.Document;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Repository
public class DocumentRepositoryImpl implements DocumentRepository {

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public Long countDocumentByName(String name) {
        return (Long) entityManager.createQuery("select count(*) from Document d where name='" + name + "'").getSingleResult();
    }

    @Override
    public Optional<Document> getDocumentById(long id) {
        return Optional.ofNullable(entityManager.find(Document.class, id));
    }

    @Override
    public void insertDocument(Document document) {
        if (document.getId() == 0L) {
            entityManager.persist(document);
        }
        entityManager.merge(document);
    }

    @Override
    public void updateDocument(Document document) {
        entityManager.merge(document);
    }

    @Override
    public void deleteDocument(long id) {
        Document document = entityManager.find(Document.class, id);
        entityManager.remove(document);
    }

    @Override
    public List<Document> findAll() {
        Query query = entityManager.createQuery("SELECT d FROM Document d");
        return query.getResultList();
    }
}
