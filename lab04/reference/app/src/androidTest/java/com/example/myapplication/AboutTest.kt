package com.example.myapplication

import androidx.test.espresso.Espresso
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AboutTest : AbstractTest() {
    @Test
    fun testAboutFrom1st() {
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun testAboutFrom2nd() {
        toSecond()
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        isDisplayed(R.id.fragment2)
    }

    @Test
    fun testAboutFrom3rd() {
        toSecond()
        toThird()
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        isDisplayed(R.id.fragment3)
    }

    @Test
    fun testAbout2ndTo1st() {
        toSecond()
        Espresso.pressBack()
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun testAbout3rdTo2nd() {
        toSecond()
        toThird()
        Espresso.pressBack()
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        isDisplayed(R.id.fragment2)
    }

    @Test
    fun testAbout3rdTo1st() {
        toSecond()
        toThird()
        toFirst()
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun testAbout2ndWithFragments() {
        toSecond()
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        isDisplayed(R.id.fragment2)
        Espresso.pressBack()
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun testAbout3rdWithFragments() {
        toSecond()
        toThird()
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        isDisplayed(R.id.fragment3)
        Espresso.pressBack()
        isDisplayed(R.id.fragment2)
        Espresso.pressBack()
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun testBackstackSize1stAbout() {
        openAbout()
        checkBackstackSize(2)
    }

    @Test
    fun testBackstackSize2ndAbout() {
        toSecond()
        openAbout()
        checkBackstackSize(3)
    }

    @Test
    fun testBackstackSize3rdAbout() {
        toSecond()
        toThird()
        openAbout()
        checkBackstackSize(4)
    }

    @Test
    fun testRecreateAbout() {
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        rotateScreen()
        openAbout()
        isDisplayed(R.id.activity_about)
        Espresso.pressBack()
        openAbout()
        isDisplayed(R.id.activity_about)
        rotateScreen()
        isDisplayed(R.id.activity_about)
    }
}