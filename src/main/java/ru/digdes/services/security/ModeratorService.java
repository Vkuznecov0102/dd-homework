package ru.digdes.services.security;

import ru.digdes.domains.Moderator;

public interface ModeratorService {
    Moderator getModeratorById(long id);

    void insertModerator(Moderator moderator);

    void updateModerator(Moderator moderator);

    void deleteModerator(long id);
}
