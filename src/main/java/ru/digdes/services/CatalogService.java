package ru.digdes.services;

import ru.digdes.domains.Catalog;

import java.util.List;
import java.util.Optional;

public interface CatalogService {

    Long countCatalogByName(String name);

    Optional<Catalog> getCatalogById(long id);

    void insertCatalog(Catalog catalog);

    void updateCatalog(Catalog catalog);

    void deleteCatalog(long id);

    List<Catalog> findAll();
}
