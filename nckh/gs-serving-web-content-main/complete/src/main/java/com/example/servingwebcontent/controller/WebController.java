package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/videos")
    public String videos() {
        return "videos";
    }

    @GetMapping("/video/{id}")
    public String videoPlayer(@PathVariable String id, Model model) {
        model.addAttribute("videoId", id);
        model.addAttribute("videoTitle", "Bài giảng " + id + " - Spring Boot");
        return "video-player";
    }

    @GetMapping("/quizzes")
    public String quizzes() {
        return "quizzes";
    }

    @GetMapping("/quiz/{id}")
    public String quizPage(@PathVariable String id, Model model) {
        model.addAttribute("quizId", id);
        return "quiz";
    }

    @GetMapping("/students")
    public String students() {
        return "students";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "dashboard";
    }
}