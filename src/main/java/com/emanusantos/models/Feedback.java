package com.emanusantos.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID id;
    private String title;
    private String category;
    private Integer upvotes;
    private String status;
    private String description;

    @OneToMany
    private List<Comment> comments;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private FeedbackUser user;
    public Feedback(
            UUID id,
            String title,
            String category,
            Integer upvotes,
            String status,
            String description
    ) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.upvotes = upvotes;
        this.status = status;
        this.description = description;
    }

    public Feedback() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
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

    public Integer getUpvotes() {
        return upvotes;
    }

    public void setUpvotes(Integer upvotes) {
        this.upvotes = upvotes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Feedback feedback = (Feedback) o;
        return Objects.equals(id, feedback.id) && Objects.equals(title, feedback.title) && Objects.equals(category, feedback.category) && Objects.equals(upvotes, feedback.upvotes) && Objects.equals(status, feedback.status) && Objects.equals(description, feedback.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, category, upvotes, status, description);
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", upvotes=" + upvotes +
                ", status='" + status + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}


