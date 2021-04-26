package ru.digdes.services;

import ru.digdes.domains.Catalog;

public interface CatalogService {
    Catalog getCatalogById(long id);

    void insertCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    void deleteCatalog(long id);
}
