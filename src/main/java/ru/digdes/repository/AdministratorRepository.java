package ru.digdes.repository;

import ru.digdes.domains.Administrator;

import java.util.List;
import java.util.Optional;

public interface AdministratorRepository {

    Long countAdministratorById(Long id);

    Optional<Administrator> getAdministratorById(long id);

    void insertAdministrator(Administrator administrator);

    void updateAdministrator(Administrator administrator);

    void deleteAdministrator(long id);

    List<Administrator> findAll();
}
