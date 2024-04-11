package ru.greenatom.forum.util;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.service.TopicService;

import java.util.UUID;

@Component
@AllArgsConstructor
public class FakeDataLoad {
    //    private final MessageRepository messageRepository;
    private final TopicService topicService;

    @PostConstruct
    public void loadData() {
        for (int i = 1; i < 10; i++) {
            MessageIncomingDto message = new MessageIncomingDto("Message 1, topic " + i, "Author " + i);
            TopicIncomingDto topicDto = new TopicIncomingDto(
                    "Topic " + i + " name",
                    message
            );

            UUID topicId = topicService.save(topicDto).getUuid();

            for (int j = 2; j < 20; j++) {
                MessageIncomingDto messageInTopic = new MessageIncomingDto("Message " + j + ", topic " + i, "Author " + j);
//                messageService.save(topicId, messageInTopic);
            }
        }
    }
}
