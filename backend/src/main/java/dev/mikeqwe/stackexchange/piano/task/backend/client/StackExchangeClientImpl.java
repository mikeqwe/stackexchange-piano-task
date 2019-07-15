package dev.mikeqwe.stackexchange.piano.task.backend.client;

import dev.mikeqwe.stackexchange.piano.task.backend.client.dto.QuestionPageDto;
import dev.mikeqwe.stackexchange.piano.task.backend.controller.QuestionRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Slf4j
@Component
public class StackExchangeClientImpl implements StackExchangeClient {

    private final RestTemplate restTemplate;

    private final String baseUrl;

    private final String searchEndpoint;

    public StackExchangeClientImpl(@Value("${stackexchange.baseurl}") String baseUrl,
                                   @Value("${stackexchange.endpoint.search}") String searchEndpoint,
                                   RestTemplate restTemplate) {
        this.searchEndpoint = searchEndpoint;
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public QuestionPageDto search(QuestionRequest request) {
        final String url = requestToUri(request);
        try {
            return restTemplate.getForObject(url, QuestionPageDto.class);
        } catch (RestClientException exception) {
            log.error("StackExchange call failure: {}", url, exception);
            throw exception;
        }
    }

    private String requestToUri(QuestionRequest request) {
        return UriComponentsBuilder.fromHttpUrl(baseUrl + searchEndpoint)
                .queryParam("intitle", request.getIntitle())
                .queryParam("site", request.getSite())
                .queryParam("page", request.getPageable().getPageNumber() + 1)
                .queryParam("pagesize", request.getPageable().getPageSize())
                .toUriString();
    }
}
