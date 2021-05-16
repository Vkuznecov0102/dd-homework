package ru.digdes.services.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digdes.domains.Administrator;
import ru.digdes.repository.AdministratorRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class AdministratorServiceImpl implements AdministratorService {

    private final AdministratorRepository repository;

    @Override
    public Long countAdministratorById(Long id) {
        return repository.countAdministratorById(id);
    }

    @Override
    public Optional<Administrator> getAdministratorById(long id) {
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

    @Override
    public List<Administrator> findAll() {
        return repository.findAll();
    }
}
