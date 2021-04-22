package ru.digdes.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Document {
    long id;
    String name;
    String priority;
    long version_id;
    long catalog_id;
}
