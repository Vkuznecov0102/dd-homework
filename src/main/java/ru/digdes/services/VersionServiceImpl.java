package ru.digdes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digdes.domains.Version;
import ru.digdes.repository.VersionRepository;

@RequiredArgsConstructor
@Service
public class VersionServiceImpl implements VersionService{

    private final VersionRepository repository;

    @Override
    public Version getVersionById(long id) {
        return repository.getVersionById(id);
    }

    @Override
    public void insertVersion(Version version) {
        repository.insertVersion(version);
    }

    @Override
    public void updateVersion(Version version) {
        repository.updateVersion(version);
    }

    @Override
    public void deleteVersion(long id) {
        repository.deleteVersion(id);
    }
}
