package dev.mikeqwe.stackexchange.piano.task.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Question {
    private List<String> tags;
    private ShallowUser owner;
    private Boolean isAnswered;
    private Integer viewCount;
    private Integer upVoteCount;
    private Integer answerCount;
    private Integer score;
    private Instant creationDate;
    private String link;
    private String title;
}
