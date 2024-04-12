package ru.greenatom.forum.repository.impl;

import org.springframework.stereotype.Repository;
import ru.greenatom.forum.exception.NotFoundException;
import ru.greenatom.forum.model.Message;
import ru.greenatom.forum.repository.MessageRepository;

import java.util.*;

@Repository
public class MessageRepositoryImpl implements MessageRepository {
    private final Map<UUID, Message> messages = new HashMap<>();

    @Override
    public Message save(Message message) {
        UUID uuid = UUID.randomUUID();
        message.setUuid(uuid);
        messages.put(uuid, message);

        return message;
    }

    @Override
    public Message update(Message message) {
        UUID uuid = message.getUuid();
        if (messages.containsKey(uuid)) {
            Message oldMessage = messages.get(uuid);
            oldMessage.setText(message.getText());
        } else {
            throw new NotFoundException("MessageRepository update: ID not found.");
        }
        return message;
    }

    @Override
    public void delete(UUID uuid) {
        if (messages.containsKey(uuid)) {
            messages.remove(uuid);
        } else {
            throw new NotFoundException("MessageRepository delete: ID not found.");
        }
    }

    @Override
    public Message findById(UUID uuid) {
        if (messages.containsKey(uuid)) {
            return messages.get(uuid);
        } else {
            throw new NotFoundException("MessageRepository findById: ID not found.");
        }
    }

    @Override
    public List<Message> findAll(int page, int pageSize) {
        int start = (page - 1) * pageSize;

        return new ArrayList<>(messages.values().stream().skip(start).limit(pageSize).toList());
    }

    @Override
    public List<Message> findAllByTopicId(UUID topicId, int page, int pageSize) {
        int start = (page - 1) * pageSize;

        return messages.values().stream()
                .filter(message -> topicId.equals(message.getTopicUuid()))
                .skip(start)
                .limit(pageSize)
                .toList();
    }
}
