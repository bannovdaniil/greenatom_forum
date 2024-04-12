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

    @GetMapping(value = "")
    public List<TopicOutDto> getAllTopic(@RequestParam(name = "page", defaultValue = "1") int page,
                                         @RequestParam(name = "size", defaultValue = "10") int pageSize) {
        return topicService.findAll(page, pageSize);
    }

    @PostMapping("")
    public TopicOutFullDto createTopic(@Valid @RequestBody TopicIncomingDto topicIncomingDto) {
        return topicService.save(topicIncomingDto);
    }

    @PutMapping("")
    public TopicOutFullDto updateTopic(@Valid @RequestBody TopicUpdateDto topicUpdateDto) {
        return topicService.update(topicUpdateDto);
    }

    @GetMapping("/{topicId}")
    public TopicOutFullDto getTopicById(@PathVariable(name = "topicId") UUID topicUuid,
                                        @RequestParam(name = "page", defaultValue = "1") int page,
                                        @RequestParam(name = "size", defaultValue = "10") int pageSize) {
        return topicService.findById(topicUuid, page, pageSize);
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
