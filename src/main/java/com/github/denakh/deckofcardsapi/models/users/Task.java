package com.github.denakh.deckofcardsapi.models.users;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Task {

    private String title;

    private Integer id;

    private String name;

    public Task() {
    }

    public Task(String title, Integer id) {
        this.title = title;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
