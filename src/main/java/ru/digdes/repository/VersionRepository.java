package ru.digdes.repository;

import ru.digdes.domains.Version;

public interface VersionRepository {
    Version getVersionById(long id);

    void insertVersion(Version version);

    void updateVersion(Version version);

    void deleteVersion(long id);
}
