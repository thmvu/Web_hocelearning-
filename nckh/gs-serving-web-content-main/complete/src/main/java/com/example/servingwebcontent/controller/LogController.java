package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.LearningLog;
import com.example.servingwebcontent.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/logs")
@CrossOrigin(origins = "*")
public class LogController {

    @Autowired
    private LogService logService;

    // API để ghi log từ frontend
    @PostMapping("/video-watch")
    public String logVideoWatch(@RequestParam String studentId,
                               @RequestParam String videoId,
                               @RequestParam int duration,
                               @RequestParam int progress) {
        logService.logVideoWatch(studentId, videoId, duration, progress);
        return "Video watch logged successfully";
    }

    @PostMapping("/quiz-submit")
    public String logQuizSubmit(@RequestParam String studentId,
                               @RequestParam String quizId,
                               @RequestParam double score,
                               @RequestParam int timeSpent) {
        logService.logQuizSubmit(studentId, quizId, score, timeSpent);
        return "Quiz submit logged successfully";
    }

    // API để lấy log của student
    @GetMapping("/student/{studentId}")
    public List<LearningLog> getStudentLogs(@PathVariable String studentId) {
        return logService.getStudentLogs(studentId);
    }

    // API để lấy thống kê học tập
    @GetMapping("/stats/{studentId}")
    public Map<String, Object> getLearningStats(@PathVariable String studentId) {
        return logService.getLearningStats(studentId);
    }

    // API test log
    @PostMapping("/test")
    public String testLog(@RequestParam String studentId) {
        logService.logLogin(studentId);
        return "Test log created for student: " + studentId;
    }
}