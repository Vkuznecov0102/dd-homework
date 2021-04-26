package ru.digdes.services.security;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.digdes.domains.Moderator;
import ru.digdes.repository.ModeratorRepository;

@RequiredArgsConstructor
@Service
public class ModeratorServiceImpl implements ModeratorService{

    private final ModeratorRepository repository;

    @Override
    public Moderator getModeratorById(long id) {
        return repository.getModeratorById(id);
    }

    @Override
    public void insertModerator(Moderator moderator) {
        repository.insertModerator(moderator);
    }

    @Override
    public void updateModerator(Moderator moderator) {
        repository.updateModerator(moderator);
    }

    @Override
    public void deleteModerator(long id) {
        repository.deleteModerator(id);
    }
}
