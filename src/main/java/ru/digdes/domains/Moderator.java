package ru.digdes.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Moderator {
    private Long id;
    private Long administrator_id;
}
