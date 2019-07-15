package dev.mikeqwe.stackexchange.piano.task.backend.client.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
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
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class QuestionDto {
    private Long questionId;
    private List<String> tags;
    private ShallowUserDto owner;
    private Boolean isAnswered;
    private Long acceptedAnswerId;
    private Integer viewCount;
    private Integer upVoteCount;
    private Integer answerCount;
    private Integer score;
    private Instant lastActivityDate;
    private Instant creationDate;
    private String link;
    private String title;
}
