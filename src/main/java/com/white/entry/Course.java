package com.white.entry;

public class Course {

    private int id;
    private String courseTitle;
    private String courseDesc;
    private String subjectId;

    public Course() {
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public Course(int id, String courseTitle, String courseDesc) {
        this.id = id;
        this.courseTitle = courseTitle;
        this.courseDesc = courseDesc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseDesc() {
        return courseDesc;
    }

    public void setCourseDesc(String courseDesc) {
        this.courseDesc = courseDesc;
    }
}
