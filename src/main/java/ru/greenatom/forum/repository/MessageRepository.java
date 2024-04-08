package ru.greenatom.forum.repository;

import ru.greenatom.forum.model.Message;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface MessageRepository {
    Message save(Message Message);

    Message update(Message Message);

    void delete(UUID uuid);

    Optional<Message> findById(UUID uuid);

    List<Message> findAll();
}
