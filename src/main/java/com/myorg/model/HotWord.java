package com.myorg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotword")
public class HotWord {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "color")
    private String color;

    @Column(name = "action")
    private String action;

    @Column(name = "hotwordtitle_id")
    private int hotwordtitle_id;

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

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public int getHotwordtitle_id() {
        return hotwordtitle_id;
    }

    public void setHotwordtitle_id(int hotwordtitle_id) {
        this.hotwordtitle_id = hotwordtitle_id;
    }

    public HotWord() {
    }

    public HotWord(int id, String title, String color, String action, int hotwordtitle_id) {
        this.id = id;
        this.title = title;
        this.color = color;
        this.action = action;
        this.hotwordtitle_id = hotwordtitle_id;
    }
}
