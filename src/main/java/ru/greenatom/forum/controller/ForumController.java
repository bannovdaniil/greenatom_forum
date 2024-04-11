package ru.greenatom.forum.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicOutFullDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;
import ru.greenatom.forum.service.TopicService;

import java.security.Principal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ForumController {
    private final TopicService topicService;

    @PostMapping("/topic")
    public TopicOutFullDto createTopic(@Valid @RequestBody TopicIncomingDto topicIncomingDto, Principal principal) {
        return topicService.save(topicIncomingDto);
    }

    @PutMapping("/topic")
    public TopicOutFullDto updateTopic(@RequestBody TopicUpdateDto topicUpdateDto) {
        return topicService.update(topicUpdateDto);
    }

    @GetMapping("/topic")
    public List<TopicOutDto> getTopic() {
        return topicService.findAll();
    }

    @GetMapping("/topic/{uuid}")
    public TopicOutFullDto getTopic(@PathVariable(name = "uuid") UUID uuid) {
        return topicService.findById(uuid);
    }

}
