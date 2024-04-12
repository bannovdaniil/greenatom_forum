package ru.greenatom.forum.service;

import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.MessageOutDto;
import ru.greenatom.forum.model.dto.MessageUpdateDto;
import ru.greenatom.forum.model.dto.TopicOutFullDto;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    MessageOutDto save(MessageIncomingDto MessageDto);

    MessageOutDto update(MessageUpdateDto Message);

    void delete(UUID uuid);

    MessageOutDto findById(UUID uuid);

    List<MessageOutDto> findAll();

    List<MessageOutDto> findAllByTopic(UUID topicUuid);
}
