package ru.greenatom.forum.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.greenatom.forum.model.dto.*;
import ru.greenatom.forum.service.TopicService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/topic")
@AllArgsConstructor
public class TopicController {
    private final TopicService topicService;

    @PostMapping("/")
    public TopicOutFullDto createTopic(@Valid @RequestBody TopicIncomingDto topicIncomingDto) {
        return topicService.save(topicIncomingDto);
    }

    @PutMapping("/")
    public TopicOutFullDto updateTopic(@Valid @RequestBody TopicUpdateDto topicUpdateDto) {
        return topicService.update(topicUpdateDto);
    }

    @GetMapping("/")
    public List<TopicOutDto> getTopic() {
        return topicService.findAll();
    }

    @GetMapping("/{topicId}")
    public TopicOutFullDto getTopic(@PathVariable(name = "topicId") UUID topicUuid) {
        return topicService.findById(topicUuid);
    }


    @PostMapping("/{topicId}/message")
    public TopicOutFullDto createMessageInTopic(@PathVariable(name = "topicId") UUID topicId,
                                                @Valid @RequestBody MessageIncomingDto messageIncomingDto) {
        return topicService.createMessage(topicId, messageIncomingDto);
    }

    @PutMapping("/{topicId}/message")
    public TopicOutFullDto updateMessageInTopic(@PathVariable(name = "topicId") UUID topicId,
                                                @Valid @RequestBody MessageUpdateDto messageUpdateDto) {
        return topicService.updateMessage(topicId, messageUpdateDto);
    }

}
