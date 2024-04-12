package ru.greenatom.forum.service;

import ru.greenatom.forum.model.dto.*;

import java.util.List;
import java.util.UUID;

public interface TopicService {
    TopicOutFullDto save(TopicIncomingDto topicDto);

    TopicOutFullDto update(TopicUpdateDto topicUpdateDto);

    TopicOutFullDto findById(UUID uuid, int page, int pageSize);

    List<TopicOutDto> findAll(int page, int pageSize);

    TopicOutFullDto createMessage(UUID topicId, MessageIncomingDto messageIncomingDto);

    TopicOutFullDto updateMessage(UUID topicId, MessageUpdateDto messageUpdateDto);
}
