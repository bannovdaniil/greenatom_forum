package ru.greenatom.forum.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MessageUpdateDto {
    @NotNull
    @NotBlank
    private UUID uuid;
    @NotNull
    @NotBlank
    private String text;
}
