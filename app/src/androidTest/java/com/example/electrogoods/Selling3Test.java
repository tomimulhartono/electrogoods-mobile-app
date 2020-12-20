package com.example.electrogoods;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;

@RunWith(AndroidJUnit4.class)
public class Selling3Test {

    @Rule
    public ActivityTestRule<Selling3> activityTestRule = new ActivityTestRule<>(Selling3.class);


    @Test
    public void openGallery() {
        onView(withId(R.id.upload_picture)).perform(click());
    }

    @Test
    public void postSelling3() {
        onView(withId(R.id.posting3)).perform(click());
    }
}