package com.emanusantos.models;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.UUID;

@Entity
public class Reply {
    @Id
    @GeneratedValue(
            strategy = GenerationType.UUID
    )
    private UUID id;
    private String content;
    private String replyingTo;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private FeedbackUser user;

    public Reply(UUID id, String content, String replyingTo, Comment comment, FeedbackUser user) {
        this.id = id;
        this.content = content;
        this.replyingTo = replyingTo;
        this.comment = comment;
        this.user = user;
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

    public String getReplyingTo() {
        return replyingTo;
    }

    public void setReplyingTo(String replyingTo) {
        this.replyingTo = replyingTo;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public FeedbackUser getUser() {
        return user;
    }

    public void setUser(FeedbackUser user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reply reply = (Reply) o;
        return Objects.equals(id, reply.id) && Objects.equals(content, reply.content) && Objects.equals(replyingTo, reply.replyingTo) && Objects.equals(comment, reply.comment) && Objects.equals(user, reply.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, replyingTo, comment, user);
    }

    @Override
    public String toString() {
        return "Reply{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", replyingTo='" + replyingTo + '\'' +
                ", comment=" + comment +
                ", user=" + user +
                '}';
    }
}
