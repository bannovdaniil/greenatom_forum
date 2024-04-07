package ru.greenatom.forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topic {
    private UUID uuid;
    private User name;
    private LocalDateTime created;
    private List<Message> messages;
}
