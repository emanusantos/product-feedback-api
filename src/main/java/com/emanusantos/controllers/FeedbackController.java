package com.emanusantos.controllers;

import com.emanusantos.models.Feedback;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "feedback")
public class FeedbackController {
    @GetMapping
    public List<Feedback> findAll() {
        return List.of(new Feedback());
    }
}
