package ru.digdes.repository;

import ru.digdes.domains.Version;

import java.util.List;
import java.util.Optional;

public interface VersionRepository {
    Long countVersionByDocumentId(Long userId);

    Optional<Version> getVersionById(long id);

    void insertVersion(Version version);

    void updateVersion(Version version);

    void deleteVersion(long id);

    List<Version> findAll();
}
