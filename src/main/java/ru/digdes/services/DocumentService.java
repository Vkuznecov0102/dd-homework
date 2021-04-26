package ru.digdes.services;

import ru.digdes.domains.Document;

public interface DocumentService {
    Document getDocumentById(long id);

    void insertDocument(Document document);

    void updateDocument(Document document);

    void deleteDocument(long id);
}
