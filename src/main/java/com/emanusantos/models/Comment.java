package com.emanusantos.models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Comment {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID id;
    private String content;

    @ManyToOne()
    @JoinColumn(name = "feedback_id")
    private Feedback feedback;

    @ManyToOne()
    @JoinColumn(name = "user_id")
    private FeedbackUser user;

    public Comment(UUID id, String content) {
        this.id = id;
        this.content = content;
    }

    public Comment() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) && Objects.equals(content, comment.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content);
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
