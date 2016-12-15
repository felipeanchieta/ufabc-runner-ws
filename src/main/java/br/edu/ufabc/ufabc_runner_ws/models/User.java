package br.edu.ufabc.ufabc_runner_ws.models;

import org.springframework.data.annotation.Id;

public class User {

    @Id
    private String id;
    private long score;

    public User() {

    }

    public User(String id) {
        this.id = id;
        this.score = 0;
    }

    public User(String id, long score) {
        this.id = id;
        this.score = score;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getScore() {
        return score;
    }

    public void setScore(long score) {
        this.score = score;
    }
}
