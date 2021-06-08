package com.BowlingKata;

import java.util.LinkedList;
import java.util.regex.Pattern;

public class Main {

    private static int getStrikeScore(LinkedList<Frame> framesList, int index) {
        int score = 0;
        Frame nextFrame = framesList.get(index + 1);
        if (nextFrame.isStrike()) {
            Frame theSecondFrame = framesList.get(index + 2);
            score += 10 + nextFrame.getFirstRoll() + theSecondFrame.getFirstRoll();
        } else if(nextFrame.isSpare()) {
            score += 20;
        } else {
            score = 10 + nextFrame.getFirstRoll() + nextFrame.getSecondRoll();
        }
        return score;
    }

    private static int getSpareScore(LinkedList<Frame> framesList, int index) {
        Frame nextFrame = framesList.get(index + 1);
        return (10 + nextFrame.getFirstRoll());
    }

    private static Frame setFrame(int firstRoll, int secondRoll, boolean isStrike, boolean isSpare) {
        Frame frame = new Frame();

        frame.setFirstRoll(firstRoll);
        frame.setSecondRoll(secondRoll);
        frame.setStrike(isStrike);
        frame.setSpare(isSpare);

        return frame;
    }

    private static int strToInteger(char ch) {

        return Integer.parseInt(Character.toString(ch));
    }

    public static Frame getFrame(String str) {

        Frame frame = new Frame();
        int firstRoll, secondRoll;
        boolean strike = false, spare;

        if(str.charAt(0) == 'X') {
            frame = setFrame(10, 0, true, false);
            return frame;
        }
        if(str.charAt(1) == '/') {
            spare = true;
            if(str.charAt(0) == '-') {
                firstRoll = 0;
            } else {
                char ch = str.charAt(0);
                firstRoll = strToInteger(ch);
            }
            secondRoll = 10-firstRoll;
            frame = setFrame(firstRoll, secondRoll, strike, spare);
            return frame;
        }
        char chOne = str.charAt(0);
        char chTwo = str.charAt(1);
        if(chOne == '-' && Character.isDigit(chTwo)) {
            firstRoll = 0;
            secondRoll = strToInteger(chTwo);
            frame = setFrame(firstRoll, secondRoll, false, false);
            return frame;
        }
        if(chTwo == '-' && Character.isDigit(chOne)) {
            firstRoll = strToInteger(chOne);
            secondRoll = 0;
            frame = setFrame(firstRoll, secondRoll, false, false);
            return frame;
        }
        if(Character.isDigit(chOne) && Character.isDigit(chTwo)) {
            firstRoll = strToInteger(chOne);
            secondRoll = strToInteger(chTwo);
            frame = setFrame(firstRoll, secondRoll, false, false);
            return frame;
        }
        return frame;
    }

    public static LastFrame getLastFrame(String str) {

        LastFrame lastFrame = new LastFrame();

        if(str.charAt(0) == 'X') {
            lastFrame.setFirstRoll(10);
            if(str.charAt(1) == 'X') {
                if(str.charAt(2) == 'X') {
                    //Roll1: X Roll2: X Roll3: X
                    lastFrame.setSecondRoll(10);
                    lastFrame.setThirdRoll(10);
                }
                else if(str.charAt(2) == '-') {
                    //Roll1: X Roll2: X Roll3: -
                    lastFrame.setSecondRoll(10);
                    lastFrame.setThirdRoll(0);
                }
                else {
                    //Roll1: X Roll2: - Roll3: [1-9]
                    char ch = str.charAt(2);
                    lastFrame.setSecondRoll(0);
                    lastFrame.setThirdRoll(Integer.parseInt(Character.toString(ch)));
                }
            } else if (str.charAt(1) == '-') {
                if(str.charAt(2) == '/') {
                    //Roll1: X Roll2: - Roll3: /
                    lastFrame.setSecondRoll(0);
                    lastFrame.setThirdRoll(10);
                }
                else if(str.charAt(2) == '-') {
                    //Roll1: X Roll2: - Roll3: -
                    lastFrame.setSecondRoll(0);
                    lastFrame.setThirdRoll(0);
                }
                else {
                    //Roll1: X Roll2: - Roll3: [1-9]
                    lastFrame.setSecondRoll(0);
                    char ch = str.charAt(2);
                    lastFrame.setThirdRoll(Integer.parseInt(Character.toString(ch)));
                }
            } else {
                if(str.charAt(2) == '/') {
                    //Roll1: X Roll2: [1-9] Roll3: /
                    lastFrame.setSecondRoll(0);
                    lastFrame.setThirdRoll(10);
                }
                else if(str.charAt(2) == '-') {
                    //Roll1: X Roll2: [1-9] Roll3: -
                    char ch = str.charAt(1);
                    lastFrame.setSecondRoll(Integer.parseInt(Character.toString(ch)));
                    lastFrame.setThirdRoll(0);
                }
                else {
                    //Roll1: X Roll2: [1-9] Roll3: [1-9]
                    char chOne = str.charAt(1);
                    char chTwo = str.charAt(2);
                    lastFrame.setSecondRoll(Integer.parseInt(Character.toString(chOne)));
                    lastFrame.setThirdRoll(Integer.parseInt(Character.toString(chTwo)));
                }
            }
        } else if(str.charAt(0) == '-') {
            lastFrame.setFirstRoll(0);
            if(str.charAt(1) == '/') {
                if(str.charAt(2) == 'X'){
                    //Roll1: - Roll2: / Roll3: X
                    lastFrame.setSecondRoll(10);
                    lastFrame.setThirdRoll(10);
                }
                else if(str.charAt(2) == '-') {
                    //Roll1: - Roll2: / Roll3: -
                    lastFrame.setSecondRoll(10);
                    lastFrame.setThirdRoll(0);
                } else {
                    //Roll1: - Roll2: / Roll3: [1-9]
                    lastFrame.setSecondRoll(10);
                    char ch = str.charAt(2);
                    lastFrame.setThirdRoll(Integer.parseInt(Character.toString(ch)));
                }
            } else {
                //Roll1: - Roll2: [1-9]
                char ch = str.charAt(1);
                lastFrame.setSecondRoll(Integer.parseInt(Character.toString(ch)));
                lastFrame.setThirdRoll(0);
            }
        } else {
            char ch = str.charAt(0);
            char chOne = str.charAt(1);
            lastFrame.setFirstRoll(Integer.parseInt(Character.toString(ch)));
            if(str.charAt(1) == '/') {
                if(str.charAt(2) == 'X'){
                    //Roll1: [1-9] Roll2: / Roll3: X
                    lastFrame.setSecondRoll(10 - lastFrame.getFirstRoll());
                    lastFrame.setThirdRoll(10);
                }
                else if(str.charAt(2) == '-') {
                    //Roll1: [1-9] Roll2: / Roll3: -
                    lastFrame.setSecondRoll(10  - lastFrame.getFirstRoll());
                    lastFrame.setThirdRoll(0);
                }
                else {
                    //Roll1: [1-9] Roll2: / Roll3: [1-9]
                    lastFrame.setSecondRoll(10 - lastFrame.getFirstRoll());
                    char chTwo = str.charAt(2);
                    lastFrame.setThirdRoll(Integer.parseInt(Character.toString(chTwo)));
                }
            } else if(Character.isDigit(chOne)) {
                lastFrame.setSecondRoll(Integer.parseInt(Character.toString(chOne)));
                lastFrame.setThirdRoll(0);
            }
        }
        return lastFrame;
    }

    public static LinkedList<Frame> parseInputString(String[] strArray) {

        LinkedList<Frame> scoreList = new LinkedList<>();

        for (String s : strArray) {
            if (scoreList.size() < 9) {
                Frame frame = getFrame(s);
                scoreList.add(frame);
            }
        }
        return scoreList;
    }

    public static boolean areAllStrikes(String[] strArray) {

        boolean allStrikes = false;

        for (String s : strArray) {
            allStrikes = s.equals("X");
        }
        return allStrikes;
    }

    public static int getFinalScore(String inputString) {

        //validate input string before parsing

        //check if all are strikes
        String[] strArray = inputString.split(" ");
        int finalScore = 0;
        if(areAllStrikes(strArray)){
            finalScore = 300;
        } else {
            LinkedList<Frame> framesList = parseInputString(strArray);
            LastFrame lastFrame = getLastFrame(strArray[9]);
            framesList.add(lastFrame);
            int frameScore;

            for(int i=0; i < 9; i++) {
                if(framesList.get(i).isStrike()) {
                    frameScore = getStrikeScore(framesList, i);
                    finalScore += frameScore;
                }
                else if (framesList.get(i).isSpare()) {
                    frameScore = getSpareScore(framesList, i);
                    finalScore += frameScore;
                }
                else {
                    frameScore = framesList.get(i).getFirstRoll() + framesList.get(i).getSecondRoll();
                    finalScore += frameScore;
                }
            }
            finalScore += lastFrame.getFirstRoll() + lastFrame.getSecondRoll() + lastFrame.getThirdRoll();
        }

        System.out.println("Final Score is " + finalScore);
        return finalScore;
    }
}
