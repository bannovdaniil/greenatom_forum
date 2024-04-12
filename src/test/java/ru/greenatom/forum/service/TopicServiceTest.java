package ru.greenatom.forum.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.greenatom.forum.mapper.MessageMapper;
import ru.greenatom.forum.mapper.TopicMapper;
import ru.greenatom.forum.model.Message;
import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.repository.MessageRepository;
import ru.greenatom.forum.repository.TopicRepository;
import ru.greenatom.forum.service.impl.TopicServiceImpl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ExtendWith(MockitoExtension.class)
class TopicServiceTest {
    @Mock
    private TopicMapper mockTopicMapper;
    @Mock
    private MessageMapper mockMessageMapper;
    @Mock
    private MessageRepository mockMessageRepository;
    @Mock
    private TopicRepository mockTopicRepository;
    @InjectMocks
    private TopicServiceImpl topicService;

    @BeforeEach
    void setUp() {
        topicService = new TopicServiceImpl(mockTopicMapper, mockMessageMapper, mockMessageRepository, mockTopicRepository);
    }

    @DisplayName("Save topic")
    @Test
    void save() {
        MessageIncomingDto messageIncoming = new MessageIncomingDto("text messageIncoming", "user");
        TopicIncomingDto topicIncomingDto = new TopicIncomingDto("Test topic", messageIncoming);

        UUID topicId = UUID.randomUUID();
        Message message = new Message(UUID.randomUUID(), topicId, "text", "author", LocalDateTime.now());

        Topic topic = new Topic(topicId,
                topicIncomingDto.getTopicName(),
                LocalDateTime.now(),
                new ArrayList<>(List.of(message)));

        Mockito.doReturn(topic).when(mockTopicMapper).map(topicIncomingDto);
        Mockito.doReturn(topic).when(mockTopicRepository).save(topic);
        Mockito.doReturn(message).when(mockMessageMapper).map(messageIncoming);
        Mockito.doReturn(message).when(mockMessageRepository).save(message);

        topicService.save(topicIncomingDto);

        Mockito.verify(mockTopicRepository).save(Mockito.any());
        Mockito.verify(mockMessageRepository).save(Mockito.any());
    }
}