package com.BowlingKata;

public class LastFrame extends Frame{

    private int firstRoll;
    private int secondRoll;
    private int thirdRoll;

    public LastFrame() {
        super();
    }

    public LastFrame(int firstRoll, int secondRoll, int thirdRoll) {
        super(firstRoll, secondRoll);
        this.firstRoll = firstRoll;
        this.secondRoll = secondRoll;
        this.thirdRoll = thirdRoll;
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
}
