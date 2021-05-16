package ru.digdes.services;

import ru.digdes.domains.Document;

import java.util.List;
import java.util.Optional;

public interface DocumentService {

    Long countDocumentByName(String name);

    Optional<Document> getDocumentById(long id);

    void insertDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(long id);

    List<Document> findAll();
}
