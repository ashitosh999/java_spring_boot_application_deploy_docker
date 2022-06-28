package com.houarizegai.tennis.service;

import java.util.HashMap;
import java.util.Map;

public class TennisGame {

    private final String firstPlayerName;
    private final String secondPlayerName;

    private int firstPlayerScore;
    private int secondPlayerScore;

    private static final Map<Integer, String> SCORES = new HashMap<>();

    static {
        SCORES.put(0, "Love");
        SCORES.put(1, "Fifteen");
        SCORES.put(2, "Thirty");
        SCORES.put(3, "Forty");
    }

    public TennisGame(String firstPlayerName, String secondPlayerName) {
        this.firstPlayerName = firstPlayerName;
        this.secondPlayerName = secondPlayerName;
    }

    public String getScore() {
        if(isDeuce()) {
            return "Deuce";
        }

        if(firstPlayerScore == secondPlayerScore) {
            return SCORES.get(firstPlayerScore) + " All";
        }

        String highestPlayerName = getHighestPlayerName();
        if(firstPlayerScore > 3 || secondPlayerScore > 3) {
            if(hasAdvantage()) {
                return highestPlayerName + " Advantage";
            }
            if(hasWinner()) {
                return highestPlayerName + " Win";
            }
        }

        return SCORES.get(firstPlayerScore) + " " + SCORES.get(secondPlayerScore);
    }

    public void firstPlayerWin() {
        firstPlayerScore++;
    }

    public void secondPlayerWin() {
        secondPlayerScore++;
    }

    private boolean isDeuce() {
        return firstPlayerScore == secondPlayerScore && firstPlayerScore >= 3;
    }

    private boolean hasAdvantage() {
        return Math.abs(firstPlayerScore - secondPlayerScore) == 1;
    }

    private boolean hasWinner() {
        return Math.abs(firstPlayerScore - secondPlayerScore) >= 2;
    }

    private String getHighestPlayerName() {
        return firstPlayerScore > secondPlayerScore ? firstPlayerName : secondPlayerName;
    }
}
