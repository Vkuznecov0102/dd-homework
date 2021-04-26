package ru.digdes.services.security;

import ru.digdes.domains.Administrator;

public interface AdministratorService {
    Administrator getAdministratorById(long id);

    void insertAdministrator(Administrator administrator);

    void updateAdministrator(Administrator administrator);

    void deleteAdministrator(long id);
}
