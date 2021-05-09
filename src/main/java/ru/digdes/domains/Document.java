package ru.digdes.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Document {
    private Long id;
    private String name;
    private String priority;
    private Long version_id;
    private Long catalog_id;
}
