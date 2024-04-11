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
    public Message save(Message Message) {
        UUID uuid = UUID.randomUUID();
        Message.setUuid(uuid);
        messages.put(uuid, Message);

        return Message;
    }

    @Override
    public Message update(Message Message) {
        UUID uuid = Message.getUuid();
        if (messages.containsKey(uuid)) {
            messages.put(uuid, Message);
        } else {
            throw new NotFoundException("ID not found.");
        }
        return Message;
    }

    @Override
    public void delete(UUID uuid) {
        if (messages.containsKey(uuid)) {
            messages.remove(uuid);
        } else {
            throw new NotFoundException("ID not found.");
        }
    }

    @Override
    public Optional<Message> findById(UUID uuid) {
        if (messages.containsKey(uuid)) {
            return Optional.of(messages.get(uuid));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(messages.values());
    }

    @Override
    public List<Message> findAllByTopicId(UUID topicUuid) {
        return messages.values().stream()
                .filter(message -> topicUuid.equals(message.getTopic_uuid()))
                .toList();
    }
}
