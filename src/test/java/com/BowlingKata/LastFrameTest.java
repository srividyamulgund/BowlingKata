package com.BowlingKata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LastFrameTest {

    @Test
    @DisplayName("Returns First Frame object")

    public void getFirstFrame() {
        LastFrame lastFrame = new LastFrame();
        lastFrame.setFirstRoll('3');
        lastFrame.setSecondRoll('3');
        lastFrame.setThirdRoll('0');

        assertEquals('3', lastFrame.getFirstRoll());
        assertEquals('3', lastFrame.getSecondRoll());
        assertEquals('0', lastFrame.getThirdRoll());
    }

}