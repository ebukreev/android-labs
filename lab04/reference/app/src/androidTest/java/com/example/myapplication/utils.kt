package com.example.myapplication

import android.content.Context
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import android.view.Gravity
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.openContextualActionModeOverflowMenu
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import org.junit.Assert

private fun openAboutViaBottomNav() {
    onView(withId(R.id.nav_view)).perform(click())
}

private fun openAboutViaDrawer() {
    // Open Drawer to click on navigation.
    onView(withId(R.id.drawer_layout))
        .check(matches(isClosed(Gravity.LEFT))) // Left Drawer should be closed.
        .perform(DrawerActions.open()); // Open Drawer

    // Start the screen of your activity.
    onView(withId(R.id.drawer_nav_view))
        .perform(NavigationViewActions.navigateTo(R.id.aboutActivity))
}

private fun openAboutViaOptions() {
    openContextualActionModeOverflowMenu()
    onView(withText(R.string.title_about))
        .perform(click())
}

fun openAbout() = openAboutViaDrawer()

fun toFirst() {
    onView(withId(R.id.bnToFirst)).perform(click())
}

fun toSecond() {
    onView(withId(R.id.bnToSecond)).perform(click())
}

fun toThird() {
    onView(withId(R.id.bnToThird)).perform(click())
}

fun isDisplayed(id: Int) {
    onView(withId(id)).check(matches(isDisplayed()))
}

fun checkBackstackSize(size: Int) {
    repeat(size) {
        Espresso.pressBackUnconditionally()
    }
    Assert.assertEquals(AbstractTest.scenario.state, Lifecycle.State.DESTROYED)
}

fun rotateScreen() {
    AbstractTest.scenario.onActivity {
        val orientation = ApplicationProvider.getApplicationContext<Context>().resources.configuration.orientation

        it.requestedOrientation =
            if (orientation == Configuration.ORIENTATION_PORTRAIT)
                ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
             else
                ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    }

    Thread.sleep(1000)
}