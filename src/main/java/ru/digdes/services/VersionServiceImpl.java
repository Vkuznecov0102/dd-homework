package ru.digdes.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digdes.domains.Version;
import ru.digdes.repository.VersionRepository;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class VersionServiceImpl implements VersionService {

    private final VersionRepository repository;

    @Override
    public Long countVersionByDocumentId(Long userId) {
        return repository.countVersionByDocumentId(userId);
    }

    @Override
    public Optional<Version> getVersionById(long id) {
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

    @Override
    public List<Version> findAll() {
        return repository.findAll();
    }
}
