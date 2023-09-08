package com.emanusantos.dtos;

import jakarta.validation.constraints.NotEmpty;

public class CreateFeedbackDto {
        @NotEmpty
        String title;

        @NotEmpty
        String category;

        @NotEmpty
        String description;

        public CreateFeedbackDto(String title, String category, String description) {
                this.title = title;
                this.category = category;
                this.description = description;
        }

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public String getCategory() {
                return category;
        }

        public void setCategory(String category) {
                this.category = category;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }
}
