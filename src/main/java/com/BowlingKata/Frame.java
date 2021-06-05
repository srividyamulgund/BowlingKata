package com.BowlingKata;

public class Frame {

    private int firstRoll;
    private int secondRoll;
    private boolean isStrike = false;
    private boolean isSpare = false;

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public boolean isSpare() {
        return isSpare;
    }

    public void setSpare(boolean spare) {
        isSpare = spare;
    }

    public Frame() {
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }
}
