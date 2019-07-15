package dev.mikeqwe.stackexchange.piano.task.backend.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShallowUser {
    private String displayName;
    private Integer reputation;
}
