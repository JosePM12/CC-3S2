package com.example.demo;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class MoodAnalyserTest {
    @Test
    void HappyMoods() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is a happy message");
        assertThat(mood, CoreMatchers.is("HAPPY"));
    }

    @Test
    void testMoodAnalysis() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyseMood("This is a sad message");
        assertThat(mood, CoreMatchers.is("SAD"));
    }
}
