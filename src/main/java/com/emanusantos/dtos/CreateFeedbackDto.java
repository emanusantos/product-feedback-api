package com.emanusantos.dtos;

import jakarta.validation.constraints.NotEmpty;

public record CreateFeedbackDto(
        @NotEmpty
        String title,

        @NotEmpty
        String category,

        @NotEmpty
        String description
) {

}
