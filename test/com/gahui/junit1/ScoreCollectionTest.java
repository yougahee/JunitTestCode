package com.gahui.junit1;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class ScoreCollectionTest {

    @Test
    @DisplayName("[정상] 5+7/2 = 6 작동 정상 여부")
    public void answersArithmeticMeanOfTwoNumbers() {
        //given
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        //act
        int actualResult = collection.arithmeticMean();

        //then
        assertEquals(actualResult, 6);
    }
}