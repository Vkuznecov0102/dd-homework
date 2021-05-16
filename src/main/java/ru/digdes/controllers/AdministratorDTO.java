package ru.digdes.controllers;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ru.digdes.domains.Administrator;

@NoArgsConstructor
@Data
public class AdministratorDTO {
    private long id;
    private long userId;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Administrator toDomainObject(AdministratorDTO adminDTO) {
        return modelMapper.map(adminDTO, Administrator.class);
    }

    public static AdministratorDTO toDto(Administrator admin) {
        return modelMapper.map(admin, AdministratorDTO.class);
    }
}
