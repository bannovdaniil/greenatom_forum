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
import ru.greenatom.forum.service.MessageService;

import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class MessageControllerTest {
    MockMvc mvc;
    @Mock
    private MessageService mockMessageService;
    @InjectMocks
    private MessageController controller;

    @BeforeEach
    void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @DisplayName("Delete message by ID controller method")
    @Test
    void deleteMessageByIdInControllerThenOk() {
        UUID expectedId = UUID.randomUUID();

        controller.delete(expectedId);

        Mockito.verify(mockMessageService, Mockito.times(1)).delete(expectedId);
    }

    @DisplayName("Delete message by ID web /api/v1/message/{messageId}")
    @Test
    void deleteMessageByIdInUrlThenOk() throws Exception {
        UUID expectedId = UUID.randomUUID();

        mvc.perform(delete("/api/v1/message/" + expectedId)
                        .characterEncoding(StandardCharsets.UTF_8))
                .andDo(print())
                .andExpect(status().is2xxSuccessful());

        Mockito.verify(mockMessageService, Mockito.times(1)).delete(expectedId);
    }

}