package ru.greenatom.forum.mapper;

import org.mapstruct.Mapper;
import ru.greenatom.forum.model.Message;
import ru.greenatom.forum.model.dto.MessageIncomingDto;
import ru.greenatom.forum.model.dto.MessageOutDto;
import ru.greenatom.forum.model.dto.MessageUpdateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MessageMapper {
    Message map(MessageIncomingDto dto);

    Message map(MessageUpdateDto dto);

    MessageOutDto map(Message message);

    List<MessageOutDto> map(List<Message> messages);
}
