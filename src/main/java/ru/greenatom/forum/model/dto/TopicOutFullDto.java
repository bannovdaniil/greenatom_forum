package ru.greenatom.forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TopicOutFullDto {
    private UUID uuid;
    private String name;
    private LocalDateTime created;
    private List<MessageOutDto> messages;
}
