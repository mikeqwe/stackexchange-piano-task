package dev.mikeqwe.stackexchange.piano.task.backend.controller;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.domain.Pageable;

@Data
@Builder
public class QuestionRequest {

    public static final String DEFAULT_SITE = "stackoverflow";

    private final String intitle;
    private final String site;
    private final Pageable pageable;
}
