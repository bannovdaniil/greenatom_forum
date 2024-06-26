package ru.greenatom.forum.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageOutDto {
    private UUID uuid;
    private String text;
    private String author;
    private LocalDateTime created;
}
