package com.BowlingKata;

public class LastFrame extends Frame{

    private int firstRoll;
    private int secondRoll;
    private int thirdRoll;
    private boolean isStrike;
    private boolean isSpare;

    public LastFrame() {
        super();
    }

    @Override
    public int getFirstRoll() {
        return this.firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    @Override
    public int getSecondRoll() {
        return this.secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

    public int getThirdRoll() {
        return thirdRoll;
    }

    public void setThirdRoll(int thirdRoll) {
        this.thirdRoll = thirdRoll;
    }

    @Override
    public boolean isStrike() {
        return isStrike;
    }

    @Override
    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    @Override
    public boolean isSpare() {
        return isSpare;
    }

    @Override
    public void setSpare(boolean spare) {
        isSpare = spare;
    }
}
