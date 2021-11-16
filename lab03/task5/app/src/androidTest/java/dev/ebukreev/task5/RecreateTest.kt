package dev.ebukreev.task5

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RecreateTest : AbstractTest() {
    @Test
    fun testRecreate1st() {
        isDisplayed(R.id.fragment1)
        rotateScreen()
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun testRecreate2nd() {
        toSecond()
        isDisplayed(R.id.fragment2)
        rotateScreen()
        isDisplayed(R.id.fragment2)
    }

    @Test
    fun testRecreate3rd() {
        toSecond()
        toThird()
        isDisplayed(R.id.fragment3)
        rotateScreen()
        isDisplayed(R.id.fragment3)
    }

    @Test
    fun testRecreate3rdTo1nd() {
        toSecond()
        toThird()
        toFirst()
        isDisplayed(R.id.fragment1)
        rotateScreen()
        isDisplayed(R.id.fragment1)
    }
}