package com.example.portfolio.controller;

import com.example.portfolio.entity.Feedback;
import com.example.portfolio.repository.FeedbackRepository;
import org.springframework.web.bind.annotation.*;
import com.example.portfolio.service.EmailService;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin(
    origins = {
        "http://localhost:5173",
        "https://the-portfolio-frontend.vercel.app"
    }
)
public class FeedbackController {

    private final FeedbackRepository feedbackRepository;

    private EmailService emailService;

    public FeedbackController(
            FeedbackRepository feedbackRepository,
            EmailService emailService) {

        this.feedbackRepository = feedbackRepository;
        this.emailService = emailService;
    }

    @PostMapping
    public Feedback saveFeedback(
            @RequestBody Feedback feedback) {

        Feedback savedFeedback =
                feedbackRepository.save(feedback);

        emailService.sendFeedbackNotification(
                feedback.getName(),
                feedback.getEmail(),
                feedback.getRole(),
                feedback.getCompany(),
                feedback.getRating(),
                feedback.getMessage()
        );

        return savedFeedback;
    }

    @GetMapping
    public java.util.List<Feedback> getAllFeedback() {

        return feedbackRepository.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteFeedback(
            @PathVariable Long id) {

        feedbackRepository.deleteById(id);
    }

}
