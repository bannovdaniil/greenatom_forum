package ru.greenatom.forum.service;

import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicOutFullDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;

import java.util.List;
import java.util.UUID;

public interface TopicService {
    TopicOutDto save(TopicIncomingDto topicDto, String author);

    TopicOutFullDto update(TopicUpdateDto topic);

    TopicOutFullDto findById(UUID uuid);

    List<TopicOutDto> findAll();
}
