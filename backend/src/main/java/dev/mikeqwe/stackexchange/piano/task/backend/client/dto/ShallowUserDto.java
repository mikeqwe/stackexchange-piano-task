package dev.mikeqwe.stackexchange.piano.task.backend.client.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class ShallowUserDto {
    private Long userId;
    private Integer reputation;
    private Integer acceptRate;
    private String profileImage;
    private String displayName;
    private String link;
}
