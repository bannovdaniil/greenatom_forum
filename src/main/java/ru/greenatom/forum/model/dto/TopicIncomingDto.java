package ru.greenatom.forum.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TopicIncomingDto {
    @NotNull
    @NotBlank
    private String topicName;
    @NotNull
    private MessageIncomingDto message;
}
