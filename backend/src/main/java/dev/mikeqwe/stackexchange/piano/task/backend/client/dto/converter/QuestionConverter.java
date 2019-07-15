package dev.mikeqwe.stackexchange.piano.task.backend.client.dto.converter;

import dev.mikeqwe.stackexchange.piano.task.backend.client.dto.QuestionPageDto;
import dev.mikeqwe.stackexchange.piano.task.backend.domain.Question;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class QuestionConverter {

    private final ModelMapper mapper;

    public QuestionConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Page<Question> convert(QuestionPageDto dto, Pageable pageable) {
        return new PageImpl<>(
                dto.getItems().stream()
                        .map(questionDto -> mapper.map(questionDto, Question.class))
                        .collect(Collectors.toList()),
                pageable,
                dto.getQuotaRemaining()
        );
    }
}
