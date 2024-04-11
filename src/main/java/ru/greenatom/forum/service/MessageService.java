package ru.greenatom.forum.service;

import ru.greenatom.forum.model.Message;
import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.MessageOutDto;
import ru.greenatom.forum.model.dto.MessageUpdateDto;

import java.util.List;
import java.util.UUID;

public interface MessageService {
    MessageOutDto save(MessageIncomingDto MessageDto);

    MessageOutDto update(MessageUpdateDto Message);

    Message findById(UUID uuid);

    List<Message> findAll();
}
