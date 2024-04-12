package ru.greenatom.forum.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.greenatom.forum.mapper.MessageMapper;
import ru.greenatom.forum.model.Message;
import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.MessageOutDto;
import ru.greenatom.forum.model.dto.MessageUpdateDto;
import ru.greenatom.forum.repository.MessageRepository;
import ru.greenatom.forum.service.MessageService;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {
    private MessageRepository messageRepository;
    private MessageMapper messageMapper;

    @Override
    public MessageOutDto save(MessageIncomingDto messageDto) {
        Message message = messageMapper.map(messageDto);

        return messageMapper.map(messageRepository.save(message));
    }

    @Override
    public MessageOutDto update(MessageUpdateDto messageDto) {
        Message message = messageMapper.map(messageDto);

        return messageMapper.map(messageRepository.save(message));
    }

    @Override
    public void delete(UUID uuid) {
        messageRepository.delete(uuid);
    }

    @Override
    public MessageOutDto findById(UUID uuid) {
        return messageMapper.map(messageRepository.findById(uuid));
    }

    @Override
    public List<MessageOutDto> findAll() {
        return messageMapper.map(messageRepository.findAll());
    }

    @Override
    public List<MessageOutDto> findAllByTopic(UUID topicUuid) {
        return messageMapper.map(messageRepository.findAllByTopicId(topicUuid));
    }

}
