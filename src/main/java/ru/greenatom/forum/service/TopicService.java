package ru.greenatom.forum.service;

import ru.greenatom.forum.model.dto.*;

import java.util.List;
import java.util.UUID;

public interface TopicService {
    TopicOutFullDto save(TopicIncomingDto topicDto);

    TopicOutFullDto update(TopicUpdateDto topicUpdateDto);

    TopicOutFullDto findById(UUID uuid);

    List<TopicOutDto> findAll();

    TopicOutFullDto createMessage(UUID topicId, MessageIncomingDto messageIncomingDto);

    TopicOutFullDto updateMessage(UUID topicId, MessageUpdateDto messageUpdateDto);
}
