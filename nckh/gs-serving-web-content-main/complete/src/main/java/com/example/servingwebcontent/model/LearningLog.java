package com.example.servingwebcontent.model;

// TẠM THỜI COMMENT MONGODB IMPORTS
// import org.springframework.data.annotation.Id;
// import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;
import java.util.Map;

//@Document(collection = "learning_logs")
public class LearningLog {
    // @Id
    private String id;
    private String studentId;
    private String action;
    private String resourceId;
    private LocalDateTime timestamp;
    private Integer duration;
    private Double score;
    private Map<String, Object> metadata;

    public LearningLog() {
        this.timestamp = LocalDateTime.now();
    }

    public LearningLog(String studentId, String action, String resourceId) {
        this();
        this.studentId = studentId;
        this.action = action;
        this.resourceId = resourceId;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getStudentId() { return studentId; }
    public void setStudentId(String studentId) { this.studentId = studentId; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }
    public String getResourceId() { return resourceId; }
    public void setResourceId(String resourceId) { this.resourceId = resourceId; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }
    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }

    @Override
    public String toString() {
        return "LearningLog{" +
                "studentId='" + studentId + '\'' +
                ", action='" + action + '\'' +
                ", resourceId='" + resourceId + '\'' +
                ", timestamp=" + timestamp +
                ", duration=" + duration +
                ", score=" + score +
                '}';
    }
}
