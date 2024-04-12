package ru.greenatom.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.greenatom.forum.model.Message;
import ru.greenatom.forum.repository.impl.MessageRepositoryImpl;

import java.time.LocalDateTime;
import java.util.UUID;

class MessageRepositoryTest {
    MessageRepository messageRepository;

    @BeforeEach
    void setUp() {
        messageRepository = new MessageRepositoryImpl();
    }

    @DisplayName("Save message")
    @Test
    void saveThenOk() {
        Message message = new Message(UUID.randomUUID(), UUID.randomUUID(), "Hello World", "User", LocalDateTime.now());
        Message saveMessage = messageRepository.save(message);

        Assertions.assertEquals(message.getUuid(), saveMessage.getUuid());

        Message getMessage = messageRepository.findById(message.getUuid());

        Assertions.assertEquals(message.getUuid(), getMessage.getUuid());
    }

    @DisplayName("Update message")
    @Test
    void updateThenOk() {
        String expectedText = "Edit test message";

        Message message = new Message(UUID.randomUUID(), UUID.randomUUID(), "Hello World", "User", LocalDateTime.now());
        Message saveMessage = messageRepository.save(message);

        saveMessage.setText(expectedText);
        Message updateMessage = messageRepository.update(saveMessage);

        Message getMessage = messageRepository.findById(message.getUuid());
        Assertions.assertEquals(saveMessage.getText(), getMessage.getText());
    }

}