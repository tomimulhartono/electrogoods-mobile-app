package com.example.electrogoods;

import android.app.Activity;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
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
public class loginwphonetest {

    @Rule
    public ActivityTestRule<loginwphone> activityTestRule = new ActivityTestRule<>(loginwphone.class);

    private String no = "089131084727";
    private String no2 = "08";
    private String ver = "1234";

    @Test
    public void nohp(){
        onView(withId(R.id.editTextPhone)).perform(click());
        onView(withId(R.id.editTextPhone)).perform(typeText(no), closeSoftKeyboard());

        onView(withId(R.id.editTextCode)).perform(click());
        onView(withId(R.id.editTextCode)).perform(typeText(ver), closeSoftKeyboard());
    }

    @Test
    public void nohp2() {
        onView(withId(R.id.editTextPhone)).perform(click());
        onView(withId(R.id.editTextPhone)).perform(typeText(no2), closeSoftKeyboard());
    }


}
