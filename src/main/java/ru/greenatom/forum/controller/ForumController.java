package ru.greenatom.forum.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicOutFullDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;
import ru.greenatom.forum.service.TopicService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
@AllArgsConstructor
public class ForumController {
    private final TopicService topicService;

    @PostMapping("/topic")
    @PreAuthorize("hasAuthority('ROLE_USER') && hasAuthority('ROLE_ADMIN')")
    public Topic createTopic(@RequestBody TopicIncomingDto topicIncomingDto) {
        return new Topic();
    }

    @PutMapping("/topic")
    @PreAuthorize("hasAuthority('ROLE_USER') && hasAuthority('ROLE_ADMIN')")
    public Topic updateTopic(@RequestBody TopicUpdateDto topicUpdateDto) {
        return new Topic();
    }

    @GetMapping("/topic")
    @PreAuthorize("hasAuthority('ROLE_USER') && hasAuthority('ROLE_ADMIN')")
    public List<TopicOutDto> getTopic() {
        return topicService.findAll();
    }

    @GetMapping("/topic/{uuid}")
    @PreAuthorize("hasAuthority('ROLE_USER') && hasAuthority('ROLE_ADMIN')")
    public TopicOutFullDto getTopic(@PathVariable(name = "uuid") UUID uuid) {
//        UUID topicUuid = UUID.fromString(uuid);
        return topicService.findById(uuid);
    }

}
