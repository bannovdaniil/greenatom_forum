package ru.greenatom.forum.service.impl;

import ru.greenatom.forum.model.Message;
import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.MessageOutDto;
import ru.greenatom.forum.model.dto.MessageUpdateDto;
import ru.greenatom.forum.service.MessageService;

import java.util.List;
import java.util.UUID;

public class MessageServiceImpl implements MessageService {
    @Override
    public MessageOutDto save(MessageIncomingDto MessageDto) {
        return null;
    }

    @Override
    public MessageOutDto update(MessageUpdateDto Message) {
        return null;
    }

    @Override
    public Message findById(UUID uuid) {
        return null;
    }

    @Override
    public List<Message> findAll() {
        return List.of();
    }
}
