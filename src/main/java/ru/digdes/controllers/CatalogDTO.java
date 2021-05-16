package ru.digdes.controllers;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ru.digdes.domains.Catalog;

@NoArgsConstructor
@Data
public class CatalogDTO {
    private long id;
    private String name;
    private long userId;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Catalog toDomainObject(CatalogDTO catalogDTO) {
        return modelMapper.map(catalogDTO, Catalog.class);
    }

    public static CatalogDTO toDto(Catalog catalog) {
        return modelMapper.map(catalog, CatalogDTO.class);
    }
}
