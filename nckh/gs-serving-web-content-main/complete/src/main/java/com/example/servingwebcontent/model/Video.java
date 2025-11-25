package com.example.servingwebcontent.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

    @Document(collection = "videos")
public class Video {
    @Id
    private String id;

    private String videoId;          // Mã video (unique)
    private String title;
    private String description;
    private String url;
    private Integer duration;        // thời lượng (giây)
    private String category;

    // Constructors
    public Video() {}

    public Video(String videoId, String title, String description, String url, Integer duration, String category) {
        this.videoId = videoId;
        this.title = title;
        this.description = description;
        this.url = url;
        this.duration = duration;
        this.category = category;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getVideoId() { return videoId; }
    public void setVideoId(String videoId) { this.videoId = videoId; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getUrl() { return url; }
    public void setUrl(String url) { this.url = url; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", videoId='" + videoId + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", duration=" + duration +
                ", category='" + category + '\'' +
                '}';
    }
}
