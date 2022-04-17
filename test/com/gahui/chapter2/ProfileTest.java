package com.gahui.chapter2;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.*;

public class ProfileTest {
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;

    @Before
    public void create() {
        profile = new Profile("Bull Hockey, Inc.");
        question = new BooleanQuestion(1, "Got bonuses?");
        criteria = new Criteria();
    }

    @Test
    @DisplayName("[실패]")
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        // given
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        // act
        boolean matches = profile.matches(criteria);

        // assert
        assertFalse(matches);
    }

    @Test
    @DisplayName("[성공]")
    public void matchAnswersTrueWhenMustMatchCriteria() {
        // given
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        // act
        boolean matches = profile.matches(criteria);

        // assert
        assertTrue(matches);
    }

}