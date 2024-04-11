package ru.greenatom.forum.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import ru.greenatom.forum.model.Topic;
import ru.greenatom.forum.model.dto.TopicIncomingDto;
import ru.greenatom.forum.model.dto.TopicOutDto;
import ru.greenatom.forum.model.dto.TopicOutFullDto;
import ru.greenatom.forum.model.dto.TopicUpdateDto;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TopicMapper {
    Topic map(TopicIncomingDto dto);

    Topic map(TopicUpdateDto dto);

    @Mapping(source = "topicName", target = "name")
    TopicOutDto map(Topic topic);

    @Mapping(source = "topicName", target = "name")
    TopicOutFullDto mapAllFields(Topic topic);

    List<TopicOutDto> map(List<Topic> topics);
}
