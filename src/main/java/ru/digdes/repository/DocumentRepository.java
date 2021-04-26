package ru.digdes.repository;

import ru.digdes.domains.Document;

public interface DocumentRepository {
    Document getDocumentById(long id);

    void insertDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(long id);
}
