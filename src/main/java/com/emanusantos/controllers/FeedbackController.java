package com.emanusantos.controllers;

import com.emanusantos.dtos.CreateFeedbackDto;
import com.emanusantos.models.Feedback;
import com.emanusantos.services.FeedbackService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    @Autowired
    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public Feedback create(@Valid @RequestBody CreateFeedbackDto dto) {
        return feedbackService.createFeedback(dto);
    }

    @GetMapping
    public List<Feedback> findAll() {
        return feedbackService.findAllFeedbacks();
    }
}
