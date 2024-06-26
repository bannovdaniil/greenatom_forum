package ru.greenatom.forum.repository.impl;

import org.springframework.stereotype.Repository;
import ru.greenatom.forum.exception.NotFoundException;
import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.repository.TopicRepository;

import java.util.*;

@Repository
public class TopicRepositoryImpl implements TopicRepository {
    private final Map<UUID, Topic> topics = new HashMap<>();

    @Override
    public Topic save(Topic topic) {
        UUID uuid = UUID.randomUUID();
        topic.setUuid(uuid);
        topics.put(uuid, topic);

        return topic;
    }

    /**
     * В топике можно изменить только название, т.к. дата создания и id константы
     */
    @Override
    public Topic update(Topic topic) {
        UUID uuid = topic.getUuid();
        if (!isExists(uuid)) {
            throw new NotFoundException("TopicRepository update: ID not found.");
        }
        Topic oldTopic = topics.get(uuid);
        oldTopic.setTopicName(topic.getTopicName());

        return oldTopic;
    }

    @Override
    public Topic findById(UUID uuid) {
        if (!isExists(uuid)) {
            throw new NotFoundException("TopicRepository findById: ID not found.");
        }

        return topics.get(uuid);
    }

    @Override
    public List<Topic> findAll(int page, int pageSize) {
        int start = (page - 1) * pageSize;
        return new ArrayList<>(topics.values().stream().skip(start).limit(pageSize).toList());
    }

    private boolean isExists(UUID uuid) {
        return topics.containsKey(uuid);
    }
}
