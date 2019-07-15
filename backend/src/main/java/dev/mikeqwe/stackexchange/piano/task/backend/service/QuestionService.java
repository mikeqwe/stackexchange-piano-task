package dev.mikeqwe.stackexchange.piano.task.backend.service;

import dev.mikeqwe.stackexchange.piano.task.backend.controller.QuestionRequest;
import dev.mikeqwe.stackexchange.piano.task.backend.domain.Question;
import org.springframework.data.domain.Page;

public interface QuestionService {
    Page<Question> findAll(QuestionRequest request);
}
