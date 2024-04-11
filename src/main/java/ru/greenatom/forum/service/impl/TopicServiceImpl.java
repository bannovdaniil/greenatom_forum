package ru.greenatom.forum.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.greenatom.forum.mapper.MessageMapper;
import ru.greenatom.forum.mapper.TopicMapper;
import ru.greenatom.forum.model.Message;
import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicOutFullDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;
import ru.greenatom.forum.repository.MessageRepository;
import ru.greenatom.forum.repository.TopicRepository;
import ru.greenatom.forum.service.TopicService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class TopicServiceImpl implements TopicService {
    private final TopicMapper topicMapper;
    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;
    private final TopicRepository topicRepository;

    /**
     * Сохраняет топик - это все доложно быть в 1 транзакции.
     * 1. сохраняем, Получаем ID
     * 2. Получаем сообщение из топика
     * 3. устанавливем ID
     * 4. сохраняем
     * 5. генерируем топик.

     */
    @Override
    public TopicOutFullDto save(TopicIncomingDto topicDto) {
        if (topicDto.getMessage() == null ||
                topicDto.getMessage().getText() == null ||
                topicDto.getMessage().getText().isBlank()) {
            throw new IllegalArgumentException("Topic don't have any Message");
        }

        Topic topic = topicMapper.map(topicDto);
        topic.setCreated(LocalDateTime.now());
        topic = topicRepository.save(topic);

        Message message = messageMapper.map(topicDto.getMessage());
        message.setTopic_uuid(topic.getUuid());
        message.setCreated(topic.getCreated());
        message = messageRepository.save(message);

        topic.getMessages().add(message);

        return topicMapper.mapAllFields(topic);
    }

    /**
     * Изменяем топик, меняется только название
     */
    @Override
    public TopicOutFullDto update(TopicUpdateDto topicUpdateDto) {
        Topic topic = topicMapper.map(topicUpdateDto);

        return topicMapper.mapAllFields(topicRepository.update(topic));
    }

    /**
     * Получить топик по ID
     */
    @Override
    public TopicOutFullDto findById(UUID uuid) {
        return topicMapper.mapAllFields(topicRepository.findById(uuid));
    }

    /**
     * Получить список топиков
     */
    @Override
    public List<TopicOutDto> findAll() {
        return topicMapper.map(topicRepository.findAll());
    }
}
