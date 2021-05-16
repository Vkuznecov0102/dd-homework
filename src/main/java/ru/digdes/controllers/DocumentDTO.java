package ru.digdes.controllers;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ru.digdes.domains.Document;

@NoArgsConstructor
@Data
public class DocumentDTO {
    private long id;
    private String name;
    private String description;
    private String priority;
    private String typeOfView;
    private long catalog_id;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Document toDomainObject(DocumentDTO documentDTO) {
        return modelMapper.map(documentDTO, Document.class);
    }

    public static DocumentDTO toDto(Document document) {
        return modelMapper.map(document, DocumentDTO.class);
    }
}