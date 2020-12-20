package com.example.electrogoods;

import android.app.Activity;
import android.view.KeyEvent;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.provider.Settings.System.getString;
import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.pressKey;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.action.ViewActions.pressBack;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class LocationTest {

    @Rule
    public ActivityTestRule<Location> activityTestRule = new ActivityTestRule<>(Location.class);

    private String search = "Aceh";
    private String test = "B";

    @Test
    public void searchView(){
        onView(withId(R.id.cariLokasi)).perform(click());
        onView(withId(R.id.cariLokasi)).perform(typeText(search), closeSoftKeyboard());
        onView(withId(R.id.cariLokasi))
                .perform(click())
                .perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL));
        onView(withId(R.id.cariLokasi)).perform(typeText(test), closeSoftKeyboard());
        onData(anything()).inAdapterView(withId(R.id.daftarLokasi)).atPosition(0).perform(click());
        onView(withId(R.id.cariLokasi))
                .perform(click())
                .perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL))
                .perform(pressKey(KeyEvent.KEYCODE_DEL));
        onView(withId(R.id.cariLokasi)).perform(typeText("Z"), closeSoftKeyboard());
        onView(withId(R.id.cariLokasi))
                .perform(click())
                .perform(pressKey(KeyEvent.KEYCODE_ENTER), closeSoftKeyboard());
    }

    @Test
    public void textClickYes(){
        back();
        onView(withId(R.id.currentLocation)).perform(click());
        onView(withId(android.R.id.button1)).perform(click());
    }

    @Test
    public void textClickNo(){
        back();
        onView(withId(R.id.currentLocation)).perform(click());
        onView(withId(android.R.id.button2)).perform(click());
    }

    @Test
    public void back() {
        Espresso.pressBackUnconditionally();
    }
}
