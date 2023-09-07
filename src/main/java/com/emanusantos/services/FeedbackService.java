package com.emanusantos.services;

import com.emanusantos.dtos.CreateFeedbackDto;
import com.emanusantos.models.Feedback;
import com.emanusantos.repositories.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class FeedbackService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public FeedbackService(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    public Feedback createFeedback(CreateFeedbackDto dto) {
        Feedback feedback = new Feedback();
        feedback.setTitle(dto.title());
        feedback.setCategory(dto.category());
        feedback.setDescription(dto.description());
        feedback.setUpvotes(0);
        feedback.setStatus("suggestion");

        return feedbackRepository.save(feedback);
    }

    public List<Feedback> findAllFeedbacks() {
        return feedbackRepository.findAll();
    }

    public Optional<Feedback> findOneFeedback(UUID feedbackId) {
        Optional<Feedback> opt = feedbackRepository.findById(feedbackId);

        if (opt.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found");

        return opt;
    }
}
