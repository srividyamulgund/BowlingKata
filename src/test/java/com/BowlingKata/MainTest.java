package com.BowlingKata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    @DisplayName("Returns calculated score when no spare or strike")
    public void testFinalScoreWithNoSpareNoStrike() {

        String inputString = "54 43 43 43 43 43 43 43 43 24";

        assertEquals(71, Main.getFinalScore(inputString), "Calculation Mismatch");

    }

    @Test
    @DisplayName("Returns calculated score when all are strikes")
    public void testFinalScoreWithAllStrike() {

        String inputString = "X X X X X X X X X X X X";

        assertEquals(300, Main.getFinalScore(inputString), "Calculation Mismatch");
    }

    @Test
    @DisplayName("Returns calculated score when no strikes and all spare")
    public void testFinalScoreWithNoStrikeOnlySpare() {

        String inputString = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5";

        assertEquals(150, Main.getFinalScore(inputString), "Calculation Mismatch");
    }

    @Test
    @DisplayName("Returns calculated score when no strikes and no spares")
    public void testFinalScoreWithNoStrikeNoSpare() {

        String inputString = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-";

        assertEquals(90, Main.getFinalScore(inputString), "Calculation Mismatch");
    }

}