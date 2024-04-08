package ru.greenatom.forum.mapper;

import org.mapstruct.Mapper;
import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TopicMapper {
//    Topic map(TopicIncomingDto dto);

//    Topic map(TopicUpdateDto dto);

    TopicOutDto map(Topic topic);

    List<TopicOutDto> map(List<Topic> topics);
}
