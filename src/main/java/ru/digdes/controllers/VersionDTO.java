package ru.digdes.controllers;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ru.digdes.domains.Version;

@NoArgsConstructor
@Data
public class VersionDTO {
    private long id;
    private long documentId;

    private static ModelMapper modelMapper = new ModelMapper();

    public static Version toDomainObject(VersionDTO versionDTO) {
        return modelMapper.map(versionDTO, Version.class);
    }

    public static VersionDTO toDto(Version version) {
        return modelMapper.map(version, VersionDTO.class);
    }
}
