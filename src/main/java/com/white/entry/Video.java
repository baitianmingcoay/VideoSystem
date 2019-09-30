package com.white.entry;

import com.white.utils.TimeShowUtils;

public class Video {


    private int id;
    private String title;
    private String detail;

    private String speakerName;
    private int spearkerId;
    private int courseId;
    private int time;
    private String videoUrl;
    private String videoImageUrl;

    private String imageUrl;
    private String showTime;
    private int playNum;
    public Video() {

    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }

    public int getSpearkerId() {
        return spearkerId;
    }

    public void setSpearkerId(int spearkerId) {
        this.spearkerId = spearkerId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getVideoImageUrl() {
        return videoImageUrl;
    }

    public void setVideoImageUrl(String videoImageUrl) {
        this.videoImageUrl = videoImageUrl;
    }

    public String getShowTime() {
        return TimeShowUtils.newSetTime(time);
    }

    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public int getPlayNum() {
        return playNum;
    }

    public void setPlayNum(int playNum) {
        this.playNum = playNum;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", detail='" + detail + '\'' +
                ", speakerName='" + speakerName + '\'' +
                ", spearkerId=" + spearkerId +
                ", courseId=" + courseId +
                ", time=" + time +
                ", videoUrl='" + videoUrl + '\'' +
                ", videoImageUrl='" + videoImageUrl + '\'' +
                ", showTime='" + showTime + '\'' +
                ", playNum=" + playNum +
                '}';
    }
}
