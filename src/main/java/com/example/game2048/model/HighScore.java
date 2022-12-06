package com.example.game2048.model;
/**
 * @author Ruland Muhammad Furqan
 */

public class HighScore {
    private String username;
    private String highScore;

    public HighScore(String username, String highScore) {
        this.username = username;
        this.highScore = highScore;
    }

    /**
     * This is the getter for the username
     * @return
     */
    public String getUsername() {
        return username;
    }

    /**
     * This is the setter for the username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * This is the getter for the highscore
     * @return
     */
    public String getHighScore() {
        return highScore;
    }

    /**
     * This is the setter for the highscore
     * @param highScore
     */
    public void setHighScore(String highScore) {
        this.highScore = highScore;
    }
}
