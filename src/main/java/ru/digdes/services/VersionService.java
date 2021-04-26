package ru.digdes.services;

import ru.digdes.domains.Version;

public interface VersionService {
    Version getVersionById(long id);

    void insertVersion(Version version);

    void updateVersion(Version version);

    void deleteVersion(long id);
}
