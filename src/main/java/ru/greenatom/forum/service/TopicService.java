package ru.greenatom.forum.service;

import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;

import java.util.List;
import java.util.UUID;

public interface TopicService {
    TopicOutDto save(TopicIncomingDto topicDto);

    TopicOutDto update(TopicUpdateDto topic);

    Topic findById(UUID uuid);

    List<Topic> findAll();
}
