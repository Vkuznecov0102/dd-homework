package ru.digdes.repository;

import ru.digdes.domains.Administrator;

public interface AdministratorRepository {
    Administrator getAdministratorById(long id);

    void insertAdministrator(Administrator administrator);

    void updateAdministrator(Administrator administrator);

    void deleteAdministrator(long id);
}
