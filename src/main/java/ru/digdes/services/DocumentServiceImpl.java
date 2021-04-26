package ru.digdes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digdes.domains.Document;
import ru.digdes.repository.DocumentRepository;

@RequiredArgsConstructor
@Service
public class DocumentServiceImpl implements DocumentService {

    private final DocumentRepository repository;

    @Override
    public Document getDocumentById(long id) {
        return repository.getDocumentById(id);
    }

    @Override
    public void insertDocument(Document document) {
        repository.insertDocument(document);
    }

    @Override
    public void updateDocument(Document document) {
        repository.updateDocument(document);
    }

    @Override
    public void deleteDocument(long id) {
        repository.deleteDocument(id);
    }
}
