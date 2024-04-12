package ru.greenatom.forum.service;

import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.MessageOutDto;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    MessageOutDto save(MessageIncomingDto messageDto);

    void delete(UUID uuid);

    List<MessageOutDto> findAll(int page, int pageSize);
}
