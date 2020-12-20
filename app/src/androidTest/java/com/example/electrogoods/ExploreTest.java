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
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class ExploreTest {

    @Rule
    public ActivityTestRule<Explore> activityTestRule = new ActivityTestRule<>(Explore.class);

    private String type = "Smartphone";

    @Test
    public void navTest(){
        onView(withId(R.id.navigation_chat)).perform(click());
        onView(withId(R.id.navigation_sell)).perform(click());
        onView(withId(R.id.navigation_ads)).perform(click());
        onView(withId(R.id.navigation_account)).perform(click());
        onView(withId(R.id.navigation_home)).perform(click());
    }

    @Test
    public void toolbarTest(){
        onView(withId(R.id.toolbar_title)).perform(click());
        Espresso.pressBackUnconditionally();
        onView(withId(R.id.notifikasi)).perform(click());
        Espresso.pressBackUnconditionally();
        onView(withId(R.id.editSearch)).perform(click());
        onView(withId(R.id.editSearch)).perform(typeText(type), closeSoftKeyboard());
    }

    @Test
    public void categoryTest(){
        onView(withId(R.id.gadget)).perform(click());
        Espresso.pressBackUnconditionally();
        onView(withId(R.id.office)).perform(click());
        Espresso.pressBackUnconditionally();
        onView(withId(R.id.household)).perform(click());
        Espresso.pressBackUnconditionally();
    }

    @Test
    public void recyclerTest() throws InterruptedException {
        Thread.sleep(3000);
        onView(withId(R.id.recyclerIklan)).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
    }
}
