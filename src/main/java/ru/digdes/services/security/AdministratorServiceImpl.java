package ru.digdes.services.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digdes.domains.Administrator;
import ru.digdes.repository.AdministratorRepository;

@RequiredArgsConstructor
@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository repository;

    @Override
    public Administrator getAdministratorById(long id) {
        return repository.getAdministratorById(id);
    }

    @Override
    public void insertAdministrator(Administrator administrator) {
        repository.insertAdministrator(administrator);
    }

    @Override
    public void updateAdministrator(Administrator administrator) {
        repository.updateAdministrator(administrator);
    }

    @Override
    public void deleteAdministrator(long id) {
        repository.deleteAdministrator(id);
    }
}
