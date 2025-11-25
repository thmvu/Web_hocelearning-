package com.example.servingwebcontent.repository;

import com.example.servingwebcontent.model.LearningLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface LearningLogRepository extends MongoRepository<LearningLog, String> {
    List<LearningLog> findByStudentId(String studentId);
    List<LearningLog> findByStudentIdAndAction(String studentId, String action);
    List<LearningLog> findByTimestampBetween(java.time.LocalDateTime start, java.time.LocalDateTime end);
}