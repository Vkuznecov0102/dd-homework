package ru.digdes.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Version {
    private Long id;
    private Long document_id;
}
