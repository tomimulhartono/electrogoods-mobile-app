package com.example.electrogoods;

import android.app.Activity;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.contrib.RecyclerViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.provider.Settings.System.getString;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.pressBack;

@RunWith(AndroidJUnit4.class)
public class DetailIklanTest {

    @Rule
    public ActivityTestRule<Explore> activityTestRule = new ActivityTestRule<>(Explore.class);

    @Test
    public void detailTest() throws InterruptedException {
        Thread.sleep(3000);
        onView(withId(R.id.recyclerIklan)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withId(R.id.textView19)).perform(click());
        onView(withId(R.id.btnfollow)).perform(click());
        onView(withId(R.id.btnunfollow)).perform(click());
        onView(withId(android.R.id.button2)).perform(click());
        onView(withId(R.id.btnunfollow)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());
    }
}
