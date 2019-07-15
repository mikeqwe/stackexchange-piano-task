package dev.mikeqwe.stackexchange.piano.task.backend.service;

import dev.mikeqwe.stackexchange.piano.task.backend.client.StackExchangeClient;
import dev.mikeqwe.stackexchange.piano.task.backend.client.dto.QuestionPageDto;
import dev.mikeqwe.stackexchange.piano.task.backend.client.dto.converter.QuestionConverter;
import dev.mikeqwe.stackexchange.piano.task.backend.controller.QuestionRequest;
import dev.mikeqwe.stackexchange.piano.task.backend.domain.Question;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class QuestionServiceImpl implements QuestionService {

    private final StackExchangeClient stackExchangeClient;

    private final QuestionConverter converter;

    public QuestionServiceImpl(StackExchangeClient stackExchangeClient,
                               QuestionConverter converter) {
        this.stackExchangeClient = stackExchangeClient;
        this.converter = converter;
    }

    @Override
    public Page<Question> findAll(QuestionRequest request) {
        final QuestionPageDto dto = stackExchangeClient.search(request);
        return converter.convert(dto, request.getPageable());
    }
}
