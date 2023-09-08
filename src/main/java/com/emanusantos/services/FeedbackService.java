package com.emanusantos.services;

import com.emanusantos.dtos.CreateFeedbackDto;
import com.emanusantos.dtos.EditFeedbackDto;
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
        feedback.setTitle(dto.getTitle());
        feedback.setCategory(dto.getCategory());
        feedback.setDescription(dto.getDescription());
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

    public void editFeedback(UUID feedbackId, EditFeedbackDto dto) {
        Optional<Feedback> opt = feedbackRepository.findById(feedbackId);

        if (opt.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Feedback not found");

        Feedback feedback = opt.get();

        if (!dto.getTitle().isEmpty()) feedback.setTitle(dto.getTitle());
        if (!dto.getCategory().isEmpty()) feedback.setCategory(dto.getCategory());
        if (!dto.getDescription().isEmpty()) feedback.setDescription(dto.getDescription());
        if (!dto.getStatus().isEmpty()) feedback.setStatus(dto.getStatus());

        feedbackRepository.save(feedback);
    }
}
