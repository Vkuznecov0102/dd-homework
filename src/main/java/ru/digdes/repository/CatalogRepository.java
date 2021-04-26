package ru.digdes.repository;

import ru.digdes.domains.Catalog;

public interface CatalogRepository {

    Catalog getCatalogById(long id);

    void insertCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    void deleteCatalog(long id);
}
