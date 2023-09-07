package com.emanusantos.dtos;

import jakarta.validation.constraints.NotEmpty;

public class EditFeedbackDto extends CreateFeedbackDto {
    @NotEmpty
    String status;

    public EditFeedbackDto(String title, String category, String description, String status) {
        super(title, category, description);
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
