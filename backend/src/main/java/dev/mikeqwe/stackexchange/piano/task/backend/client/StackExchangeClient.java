package dev.mikeqwe.stackexchange.piano.task.backend.client;

import dev.mikeqwe.stackexchange.piano.task.backend.client.dto.QuestionPageDto;
import dev.mikeqwe.stackexchange.piano.task.backend.controller.QuestionRequest;

public interface StackExchangeClient {
    QuestionPageDto search(QuestionRequest request);
}
