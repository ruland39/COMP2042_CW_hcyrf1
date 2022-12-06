package com.example.game2048.model;
/**
 * @author Ruland Muhammad Furqan-modified
 */

import java.util.ArrayList;

/**
 * This is the function of the account feature used in the List of Table View of the Rank.
 */
public class Account implements Comparable<Account> {
    private long score = 0;
    private final String userName ;
    private static final ArrayList<Account> accounts = new ArrayList<>();

    /**
     * This is to initialize the account username object.
     * @param userName
     */
    public Account(String userName){
        this.userName=userName;
    }

    /**
     * This is the function to compare the score in the List of Table View of Rank.
     * @param o the object to be compared.
     * @return
     */
    @Override
    public int compareTo(Account o) {
        return Long.compare(o.getScore(), score);
    }

    /**
     * This is the function that add the scores.
     * @param score
     */
    public void addToScore(long score) {
        this.score += score;
    }

    /**
     * This is the getter for the score.
     * @return
     */
    private long getScore() {
        return score;
    }

    /**
     * This is the getter for the username.
     * @return
     */
    private String getUserName() {
        return userName;
    }

    /**
     * This is the function that checks whether an account have existed or not.
     * @param userName
     * @return
     */
    static Account accountHaveBeenExist(String userName){
        for(Account account : accounts){
            if(account.getUserName().equals(userName)){
                return account;
            }
        }
        return null;

    }

    /**
     * This is the function to make a new account.
     * @param userName
     * @return
     */
    static Account makeNewAccount(String userName){
        Account account = new Account(userName);
        accounts.add(account);
        return account;
    }

}
