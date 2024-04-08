package ru.greenatom.forum.repository;

import ru.greenatom.forum.model.Topic;

import java.util.List;
import java.util.UUID;

public interface TopicRepository {
    Topic save(Topic topic);

    Topic update(Topic topic);

    void delete(UUID uuid);

    Topic findById(UUID uuid);

    List<Topic> findAll();

    boolean isExists(UUID uuid);
}
