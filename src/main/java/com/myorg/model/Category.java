package com.myorg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "title1")
    private String title1;

    @Column(name = "title2")
    private String title2;

    @Column(name = "title3")
    private String title3;

    @Column(name = "action1")
    private String action1;

    @Column(name = "action2")
    private String action2;

    @Column(name = "action3")
    private String action3;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle1() {
        return title1;
    }

    public void setTitle1(String title1) {
        this.title1 = title1;
    }

    public String getTitle2() {
        return title2;
    }

    public void setTitle2(String title2) {
        this.title2 = title2;
    }

    public String getTitle3() {
        return title3;
    }

    public void setTitle3(String title3) {
        this.title3 = title3;
    }

    public String getAction1() {
        return action1;
    }

    public void setAction1(String action1) {
        this.action1 = action1;
    }

    public String getAction2() {
        return action2;
    }

    public void setAction2(String action2) {
        this.action2 = action2;
    }

    public String getAction3() {
        return action3;
    }

    public void setAction3(String action3) {
        this.action3 = action3;
    }

    public Category() {
    }

    public Category(int id, String title1, String title2, String title3, String action1, String action2, String action3) {
        this.id = id;
        this.title1 = title1;
        this.title2 = title2;
        this.title3 = title3;
        this.action1 = action1;
        this.action2 = action2;
        this.action3 = action3;
    }
}
