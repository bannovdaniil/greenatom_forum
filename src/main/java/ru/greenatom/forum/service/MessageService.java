package ru.greenatom.forum.service;

import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.MessageOutDto;
import ru.greenatom.forum.model.dto.MessageUpdateDto;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    MessageOutDto save(MessageIncomingDto messageDto);

    MessageOutDto update(MessageUpdateDto message);

    void delete(UUID uuid);

    MessageOutDto findById(UUID uuid);

    List<MessageOutDto> findAll(int page, int pageSize);

    List<MessageOutDto> findAllByTopic(UUID topicUuid, int page, int pageSize);
}
