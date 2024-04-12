package ru.greenatom.forum.repository;

import ru.greenatom.forum.model.Topic;

import java.util.List;
import java.util.UUID;

public interface TopicRepository {
    Topic save(Topic topic);

    Topic update(Topic topic);

    Topic findById(UUID uuid);

    List<Topic> findAll(int page, int pageSize);
}
