package ru.digdes.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Catalog {
    private Long id;
    private String name;
    private String typeOfView;
}
