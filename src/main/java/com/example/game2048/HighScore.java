package com.example.game2048;

public class HighScore {
    private String username;
    private String highScore;

    public HighScore(String username, String highScore) {
        this.username = username;
        this.highScore = highScore;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHighScore() {
        return highScore;
    }

    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }
}
