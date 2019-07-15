package dev.mikeqwe.stackexchange.piano.task.backend.controller;

import dev.mikeqwe.stackexchange.piano.task.backend.domain.Question;
import dev.mikeqwe.stackexchange.piano.task.backend.service.QuestionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

import static dev.mikeqwe.stackexchange.piano.task.backend.controller.QuestionRequest.DEFAULT_SITE;

@RestController
@RequestMapping("questions")
public class QuestionController {

    private final QuestionService questionService;

    public QuestionController(QuestionService questionService) {
        this.questionService = questionService;
    }

    @GetMapping
    public Page<Question> getQuestions(String intitle, Pageable pageable, @RequestParam(required = false) String site) {
        final QuestionRequest request = QuestionRequest.builder()
                .intitle(intitle)
                .pageable(pageable)
                .site(Optional.ofNullable(site)
                        .orElse(DEFAULT_SITE))
                .build();
        return questionService.findAll(request);
    }
}
