package ru.greenatom.forum.repository;

import ru.greenatom.forum.model.Message;

import java.util.List;
import java.util.UUID;

public interface MessageRepository {
    Message save(Message message);

    Message update(Message message);

    void delete(UUID uuid);

    Message findById(UUID uuid);

    List<Message> findAll();

    List<Message> findAllByTopicId(UUID topicUuid);
}
