package ru.greenatom.forum.service.impl;

import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;
import ru.greenatom.forum.service.TopicService;

import java.util.List;
import java.util.UUID;

public class TopicServiceImpl implements TopicService {

    @Override
    public TopicOutDto save(TopicIncomingDto topicDto) {
        return null;
    }

    @Override
    public TopicOutDto update(TopicUpdateDto topic) {
        return null;
    }

    @Override
    public Topic findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Topic> findAll() {
        return List.of();
    }
}
