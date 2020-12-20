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
public class myadsedittest {

    @Rule
    public ActivityTestRule<Myadsedit1> activityTestRule = new ActivityTestRule<>(Myadsedit1.class);

    private String merk = "asus";
    private String tittle = "jual laptop";
    private String deskripsi = "mulus";
    private String harga = "200.000";

    @Test
    public void editiklan(){
        onView(withId(R.id.editText)).perform(click());
        onView(withId(R.id.editText)).perform(typeText(merk), closeSoftKeyboard());

        onView(withId(R.id.editText2)).perform(click());
        onView(withId(R.id.editText2)).perform(typeText(tittle), closeSoftKeyboard());

        onView(withId(R.id.editText3)).perform(click());
        onView(withId(R.id.editText3)).perform(typeText(deskripsi), closeSoftKeyboard());

        onView(withId(R.id.editText12)).perform(click());
        onView(withId(R.id.editText12)).perform(typeText(harga), closeSoftKeyboard());
    }


    @Test
    public void buttontest(){
        onView(withId(R.id.button)).perform(click());
    }

}
