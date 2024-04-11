package ru.greenatom.forum.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicOutFullDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;
import ru.greenatom.forum.service.TopicService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/topic")
@AllArgsConstructor
public class ForumController {
    private final TopicService topicService;

    @PostMapping("/")
    public TopicOutFullDto createTopic(@Valid @RequestBody TopicIncomingDto topicIncomingDto) {
        return topicService.save(topicIncomingDto);
    }

    @PutMapping("/")
    public TopicOutFullDto updateTopic(@RequestBody TopicUpdateDto topicUpdateDto) {
        return topicService.update(topicUpdateDto);
    }

    @GetMapping("/")
    public List<TopicOutDto> getTopic() {
        return topicService.findAll();
    }

    @GetMapping("/{uuid}")
    public TopicOutFullDto getTopic(@PathVariable(name = "uuid") UUID uuid) {
        return topicService.findById(uuid);
    }

}
