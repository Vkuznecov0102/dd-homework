package ru.digdes.services.security;

import ru.digdes.domains.Administrator;

import java.util.List;
import java.util.Optional;

public interface AdministratorService {

    Long countAdministratorById(Long id);

    Optional<Administrator> getAdministratorById(long id);

    void insertAdministrator(Administrator administrator);

    void updateAdministrator(Administrator administrator);

    void deleteAdministrator(long id);

    List<Administrator> findAll();
}
