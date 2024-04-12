package ru.greenatom.forum.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.service.TopicService;

import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class TopicControllerTest {
    MockMvc mvc;
    @Mock
    private TopicService mockTopicService;
    @InjectMocks
    private TopicController controller;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @DisplayName("Get All topics list in controller")
    @Test
    void getAllTopicThenOk() {
        UUID expectedId = UUID.randomUUID();
        MessageIncomingDto message = new MessageIncomingDto("Message text test", "User test");
        TopicIncomingDto topic = new TopicIncomingDto("test topic", message);
        int expectedSize = 3;
        int expectedPage = 1;

        TopicOutDto topic1 = new TopicOutDto();
        TopicOutDto topic2 = new TopicOutDto();
        TopicOutDto topic3 = new TopicOutDto();

        Mockito.doReturn(List.of(topic1, topic2, topic3)).when(mockTopicService).findAll(expectedPage, expectedSize);

        controller.getAllTopic(expectedPage, expectedSize);

        Mockito.verify(mockTopicService, Mockito.times(1)).findAll(expectedPage, expectedSize);
    }

    @DisplayName("Get All topics list in web /api/v1/topic")
    @Test
    void getAllTopicInUrlThenOk() throws Exception {
        int expectedSize = 3;
        int expectedPage = 1;

        mvc.perform(get("/api/v1/topic?page=" + expectedPage + "&size=" + expectedSize)
                        .characterEncoding(StandardCharsets.UTF_8))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        Mockito.verify(mockTopicService, Mockito.times(1)).findAll(expectedPage, expectedSize);
    }

}