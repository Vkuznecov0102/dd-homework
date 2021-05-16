package ru.digdes.controllers;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;
import ru.digdes.domains.User;

@NoArgsConstructor
@Data
public class UserDTO {
    private long id;
    private String login;
    private String password;
    private long administratorId;

    private static ModelMapper modelMapper = new ModelMapper();

    public static User toDomainObject(UserDTO userDTO) {
        return modelMapper.map(userDTO, User.class);
    }

    public static UserDTO toDto(User user) {
        return modelMapper.map(user, UserDTO.class);
    }
}
