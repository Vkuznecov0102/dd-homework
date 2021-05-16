package ru.digdes.repository;

import ru.digdes.domains.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentRepository {

    Long countDocumentByName(String name);

    Optional<Document> getDocumentById(long id);

    void insertDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(long id);

    List<Document> findAll();
}
