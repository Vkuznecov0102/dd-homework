package ru.digdes.domains;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Administrator {
    private Long id;
    private Long user_id;
    private Long moderator_id;
}
