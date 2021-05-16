package ru.digdes.repository;

import ru.digdes.domains.Catalog;

import java.util.List;
import java.util.Optional;

public interface CatalogRepository {
    Long countCatalogByName(String name);

    Optional<Catalog> getCatalogById(long id);

    void insertCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    void deleteCatalog(long id);

    List<Catalog> findAll();
}
