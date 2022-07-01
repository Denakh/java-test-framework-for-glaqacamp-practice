package com.github.denakh.deckofcardsapi.models.users;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@XmlRootElement
public class User {

    private String name;

    @JsonProperty("date_updated")
    private Map<String, Long> dateUpdated;

    private List<String> role = new ArrayList<>();

    @JsonProperty("date_register")
    private Map<String, Long> dateRegister;

    private String date;

    private String email;

    @JsonProperty("by_user")
    private String byUser;

    private Object companies;

    private List<Task> tasks = new ArrayList<>();

    public User() {
    }

    public User(String name, String email, List<Task> tasks) {
        this.name = name;
        this.email = email;
        this.tasks = tasks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("date_updated")
    public Map<String, Long> getDateUpdated() {
        return dateUpdated;
    }

    @JsonProperty("date_updated")
    public void setDateUpdated(Map<String, Long> dateUpdated) {
        this.dateUpdated = dateUpdated;
    }

    public List<String> getRole() {
        return role;
    }

    public void setRole(List<String> role) {
        this.role = role;
    }

    @JsonProperty("date_register")
    public Map<String, Long> getDateRegister() {
        return dateRegister;
    }

    @JsonProperty("date_register")
    public void setDateRegister(Map<String, Long> dateRegister) {
        this.dateRegister = dateRegister;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @JsonProperty("by_user")
    public String getByUser() {
        return byUser;
    }

    @JsonProperty("by_user")
    public void setByUser(String byUser) {
        this.byUser = byUser;
    }

    public Object getCompanies() {
        return companies;
    }

    public void setCompanies(Object companies) {
        this.companies = companies;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}
