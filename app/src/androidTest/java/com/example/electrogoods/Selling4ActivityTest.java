package com.example.electrogoods;

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
public class Selling4ActivityTest {
    @Rule
    public IntentsTestRule<Selling4> mActivity = new IntentsTestRule<>(Selling4.class);
    private String harga = "5000";

    @Test
    public void hargaEditable(){
        onView(withId(R.id.enter_price)).perform(typeText(harga), closeSoftKeyboard());
    }

    @Test
    public void buttonClickable() {
        onView(withId(R.id.posting4)).perform(click());
    }
}