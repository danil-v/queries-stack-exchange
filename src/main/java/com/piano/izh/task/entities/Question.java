package com.piano.izh.task.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Question {
    private String title;
    private Owner owner;
    private String link;
    @JsonIgnore
    private String[] tags;
    private Boolean is_answered;
    @JsonIgnore
    private Long view_count;
    private Integer answer_count;
    @JsonIgnore
    private Integer score;
    @JsonIgnore
    private Long last_activity_date;
    private String creation_date;
    @JsonIgnore
    private Long question_id;
    @JsonIgnore
    private Long accepted_answer_id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public Boolean getIs_answered() {
        return is_answered;
    }

    public void setIs_answered(Boolean is_answered) {
        this.is_answered = is_answered;
    }

    public Long getView_count() {
        return view_count;
    }

    public void setView_count(Long view_count) {
        this.view_count = view_count;
    }

    public Integer getAnswer_count() {
        return answer_count;
    }

    public void setAnswer_count(Integer answer_count) {
        this.answer_count = answer_count;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Long getLast_activity_date() {
        return last_activity_date;
    }

    public void setLast_activity_date(Long last_activity_date) {
        this.last_activity_date = last_activity_date;
    }

    public String getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Long creation_date) {
        Date date = new Date(creation_date * 1000);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        this.creation_date = dateFormat.format(date);
    }

    public Long getQuestion_id() {
        return question_id;
    }

    public void setQuestion_id(Long question_id) {
        this.question_id = question_id;
    }

    public Long getAccepted_answer_id() {
        return accepted_answer_id;
    }

    public void setAccepted_answer_id(Long accepted_answer_id) {
        this.accepted_answer_id = accepted_answer_id;
    }
}
