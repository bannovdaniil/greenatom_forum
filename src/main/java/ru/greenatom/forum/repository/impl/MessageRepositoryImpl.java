package ru.greenatom.forum.repository.impl;

import ru.greenatom.forum.exception.NotFoundException;
import ru.greenatom.forum.model.Message;
import ru.greenatom.forum.repository.MessageRepository;

import java.util.*;

public class MessageRepositoryImpl implements MessageRepository {
    private final Map<String, Message> messages = new HashMap<>();

    @Override
    public Message save(Message Message) {
        UUID uuid = UUID.randomUUID();
        Message.setUuid(uuid);
        messages.put(uuid.toString(), Message);

        return Message;
    }

    @Override
    public Message update(Message Message) {
        UUID uuid = Message.getUuid();
        if (messages.containsKey(uuid.toString())) {
            messages.put(uuid.toString(), Message);
        } else {
            throw new NotFoundException("ID not found.");
        }
        return Message;
    }

    @Override
    public void delete(UUID uuid) {
        if (messages.containsKey(uuid.toString())) {
            messages.remove(uuid.toString());
        } else {
            throw new NotFoundException("ID not found.");
        }
    }

    @Override
    public Optional<Message> findById(UUID uuid) {
        if (messages.containsKey(uuid.toString())) {
            return Optional.of(messages.get(uuid.toString()));
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<Message> findAll() {
        return new ArrayList<>(messages.values());
    }
}
