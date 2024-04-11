package ru.greenatom.forum.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;
import ru.greenatom.forum.service.TopicService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ForumController {
    private final TopicService topicService;

    @PostMapping("/topic")

    public Topic createTopic(@RequestBody TopicIncomingDto topicIncomingDto) {
        return new Topic();
    }

    @PutMapping("/topic")
    public Topic updateTopic(@RequestBody TopicUpdateDto topicUpdateDto) {
        return new Topic();
    }

    @GetMapping("/topic")
    public List<TopicOutDto> getTopic() {
        return topicService.findAll();
    }

    @GetMapping("/topic/{id}")
    public Topic getTopic(@PathVariable String uuid) {
        return new Topic();
    }

}
