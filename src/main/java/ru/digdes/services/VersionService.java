package ru.digdes.services;

import ru.digdes.domains.Version;

import java.util.List;
import java.util.Optional;

public interface VersionService {

    Long countVersionByDocumentId(Long userId);

    Optional<Version> getVersionById(long id);

    void insertVersion(Version version);

    void updateVersion(Version version);

    void deleteVersion(long id);

    List<Version> findAll();
}
