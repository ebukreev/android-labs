package dev.ebukreev.task2

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTest : AbstractTest() {

    @Test
    fun test1st() {
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun test2nd() {
        toSecond()
        isDisplayed(R.id.fragment2)
    }

    @Test
    fun test3rd() {
        toSecond()
        toThird()
        isDisplayed(R.id.fragment3)
    }

    @Test
    fun test3rdTo1st() {
        toSecond()
        toThird()
        toFirst()
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun testRandomJumps() {
        toSecond()
        toThird()
        toFirst()
        toSecond()
        toFirst()
        toSecond()
        toFirst()
        toSecond()
        isDisplayed(R.id.fragment2)
    }

    private fun pressBackUpNav() {
        Espresso.onView(ViewMatchers.withContentDescription(R.string.nav_app_bar_navigate_up_description))
                .perform(ViewActions.click())
    }

    @Test
    fun testBackUpNav2nd() {
        toSecond()
        pressBackUpNav()
        isDisplayed(R.id.fragment1)
        checkBackstackSize(1)
    }

    @Test
    fun testBackUpNav3rd() {
        toSecond()
        toThird()
        pressBackUpNav()
        isDisplayed(R.id.fragment2)
        pressBackUpNav()
        isDisplayed(R.id.fragment1)
        checkBackstackSize(1)
    }

    @Test
    fun testBackUpNav2ndToAbout() {
        toSecond()
        openAbout()
        pressBackUpNav()
        isDisplayed(R.id.fragment2)
        pressBackUpNav()
        isDisplayed(R.id.fragment1)
        checkBackstackSize(1)
    }
}