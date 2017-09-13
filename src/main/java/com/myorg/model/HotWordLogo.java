package com.myorg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hotwordlogo")
public class HotWordLogo {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "action")
    private String action;

    @Column(name = "url")
    private String url;

    @Column(name = "category_id")
    private int category_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public HotWordLogo() {
    }

    public HotWordLogo(int id, String name, String action, String url, int category_id) {
        this.id = id;
        this.name = name;
        this.action = action;
        this.url = url;
        this.category_id = category_id;
    }
}
