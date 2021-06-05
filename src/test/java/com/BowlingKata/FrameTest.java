package com.BowlingKata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FrameTest {

    @Test
    @DisplayName("Returns First Frame object")

    public void getFirstFrame() {
        Frame firstFrame = new Frame();
        firstFrame.setFirstRoll('3');
        firstFrame.setSecondRoll('3');

        assertEquals('3', firstFrame.getFirstRoll());
        assertEquals('3', firstFrame.getSecondRoll());
    }
}

