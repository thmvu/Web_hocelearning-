package com.example.servingwebcontent.service;

import com.example.servingwebcontent.model.LearningLog;
import com.example.servingwebcontent.repository.LearningLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LogService {

    @Autowired
    private LearningLogRepository learningLogRepository;

    // Ghi log đăng nhập
    public void logLogin(String studentId) {
        LearningLog log = new LearningLog();
        log.setStudentId(studentId);
        log.setAction("login");
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("ip", "127.0.0.1");
        metadata.put("user_agent", "Web Browser");
        log.setMetadata(metadata);
        
        learningLogRepository.save(log);
        System.out.println("📝 Logged login for student: " + studentId);
    }

    // Ghi log đăng xuất
    public void logLogout(String studentId) {
        LearningLog log = new LearningLog();
        log.setStudentId(studentId);
        log.setAction("logout");
        learningLogRepository.save(log);
        System.out.println("📝 Logged logout for student: " + studentId);
    }

    // Ghi log xem video
    public void logVideoWatch(String studentId, String videoId, int duration, int progress) {
        LearningLog log = new LearningLog();
        log.setStudentId(studentId);
        log.setAction("watch_video");
        log.setResourceId(videoId);
        log.setDuration(duration);
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("video_id", videoId);
        metadata.put("progress", progress);
        metadata.put("duration_watched", duration);
        log.setMetadata(metadata);
        
        learningLogRepository.save(log);
        System.out.println("🎬 Logged video watch - Student: " + studentId + ", Video: " + videoId + ", Progress: " + progress + "%");
    }

    // Ghi log làm quiz
    public void logQuizSubmit(String studentId, String quizId, double score, int timeSpent) {
        LearningLog log = new LearningLog();
        log.setStudentId(studentId);
        log.setAction("submit_quiz");
        log.setResourceId(quizId);
        log.setScore(score);
        log.setDuration(timeSpent);
        
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("quiz_id", quizId);
        metadata.put("score", score);
        metadata.put("time_spent", timeSpent);
        log.setMetadata(metadata);
        
        learningLogRepository.save(log);
        System.out.println("📝 Logged quiz submit - Student: " + studentId + ", Quiz: " + quizId + ", Score: " + score);
    }

    // Lấy log của student
    public List<LearningLog> getStudentLogs(String studentId) {
        return learningLogRepository.findByStudentId(studentId);
    }

    // Thống kê hoạt động học tập
    public Map<String, Object> getLearningStats(String studentId) {
        List<LearningLog> allLogs = learningLogRepository.findByStudentId(studentId);
        
        long videoWatchCount = allLogs.stream()
                .filter(log -> "watch_video".equals(log.getAction()))
                .count();
                
        long quizSubmitCount = allLogs.stream()
                .filter(log -> "submit_quiz".equals(log.getAction()))
                .count();
                
        double averageScore = allLogs.stream()
                .filter(log -> log.getScore() != null)
                .mapToDouble(LearningLog::getScore)
                .average()
                .orElse(0.0);
        
        Map<String, Object> stats = new HashMap<>();
        stats.put("total_videos_watched", videoWatchCount);
        stats.put("total_quizzes_submitted", quizSubmitCount);
        stats.put("average_score", averageScore);
        stats.put("total_learning_sessions", allLogs.size());
        
        return stats;
    }
}
