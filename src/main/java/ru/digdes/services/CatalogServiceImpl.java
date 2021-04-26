package ru.digdes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digdes.domains.Catalog;
import ru.digdes.repository.CatalogRepository;

@RequiredArgsConstructor
@Service
public class CatalogServiceImpl implements CatalogService{

    private final CatalogRepository repository;


    @Override
    public Catalog getCatalogById(long id) {
        return repository.getCatalogById(id);
    }

    @Override
    public void insertCatalog(Catalog catalog) {
        repository.insertCatalog(catalog);
    }

    @Override
    public void updateCatalog(Catalog catalog) {
        repository.updateCatalog(catalog);
    }

    @Override
    public void deleteCatalog(long id) {
        repository.deleteCatalog(id);
    }
}
