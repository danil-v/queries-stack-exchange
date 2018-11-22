package com.piano.izh.task.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Owner {
    @JsonIgnore
    private Long reputation;
    @JsonIgnore
    private Long user_id;
    @JsonIgnore
    private String user_type;
    @JsonIgnore
    private String profile_image;
    private String display_name;
    @JsonIgnore
    private String link;

    public Long getReputation() {
        return reputation;
    }

    public void setReputation(Long reputation) {
        this.reputation = reputation;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getUser_type() {
        return user_type;
    }

    public void setUser_type(String user_type) {
        this.user_type = user_type;
    }

    public String getProfile_image() {
        return profile_image;
    }

    public void setProfile_image(String profile_image) {
        this.profile_image = profile_image;
    }

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
