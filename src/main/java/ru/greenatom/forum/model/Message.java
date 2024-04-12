package ru.greenatom.forum.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Message {
    private UUID uuid;
    private UUID topicUuid;
    private String text;
    private String author;
    private LocalDateTime created;
}
