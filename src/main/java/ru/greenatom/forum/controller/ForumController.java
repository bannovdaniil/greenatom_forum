package ru.greenatom.forum.controller;

import org.springframework.web.bind.annotation.*;
import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ForumController {

    @PostMapping("/topic")
    public Topic createTopic(@RequestBody TopicIncomingDto topicIncomingDto) {
        return new Topic();
    }

    @PutMapping("/topic")
    public Topic updateTopic(@RequestBody TopicUpdateDto topicUpdateDto) {
        return new Topic();
    }

    @GetMapping("/topic")
    public List<Topic> getTopic() {
        return List.of(new Topic());
    }

    @GetMapping("/topic/{id}")
    public Topic getTopic(@PathVariable String uuid) {
        return new Topic();
    }

}
