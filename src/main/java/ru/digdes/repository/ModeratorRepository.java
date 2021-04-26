package ru.digdes.repository;

import ru.digdes.domains.Moderator;

public interface ModeratorRepository {
    Moderator getModeratorById(long id);

    void insertModerator(Moderator moderator);

    void updateModerator(Moderator moderator);

    void deleteModerator(long id);
}
