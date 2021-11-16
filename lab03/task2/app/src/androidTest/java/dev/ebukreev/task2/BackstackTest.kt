package dev.ebukreev.task2

import androidx.test.espresso.Espresso
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BackstackTest : AbstractTest() {

    @Test
    fun testSimple2nd() {
        toSecond()
        Espresso.pressBack()
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun testSimple3rd() {
        toSecond()
        toThird()
        Espresso.pressBack()
        isDisplayed(R.id.fragment2)
        Espresso.pressBack()
        isDisplayed(R.id.fragment1)
    }

    @Test
    fun testSize1st() {
        checkBackstackSize(1)
    }

    @Test
    fun testSize2nd() {
        toSecond()
        checkBackstackSize(2)
    }

    @Test
    fun testSize3rd() {
        toSecond()
        toThird()
        checkBackstackSize(3)
    }

    @Test
    fun testSize3rdTo2nd() {
        toSecond()
        toThird()
        toSecond()
        checkBackstackSize(2)
    }

    @Test
    fun testSize3rdTo1st() {
        toSecond()
        toThird()
        toFirst()
        checkBackstackSize(1)
    }

    @Test
    fun testSize2ndTo1st() {
        toSecond()
        toFirst()
        checkBackstackSize(1)
    }

    @Test
    fun testSize3rdTo2ndTo1st() {
        toSecond()
        toThird()
        toSecond()
        toFirst()
        checkBackstackSize(1)
    }

    @Test
    fun testSize3rdTo1stTo2nd() {
        toSecond()
        toThird()
        toFirst()
        toSecond()
        checkBackstackSize(2)
    }

    @Test
    fun testSize1stWithRotation() {
        rotateScreen()
        checkBackstackSize(1)
    }

    @Test
    fun testSize2ndWithRotation() {
        toSecond()
        rotateScreen()
        checkBackstackSize(2)
    }

    @Test
    fun testSize3rdWithRotation() {
        toSecond()
        toThird()
        rotateScreen()
        checkBackstackSize(3)
    }

    @Test
    fun testSize3rdTo2ndWithRotation() {
        toSecond()
        toThird()
        toSecond()
        rotateScreen()
        checkBackstackSize(2)
    }

    @Test
    fun testSize3rdTo1stWithRotation() {
        toSecond()
        toThird()
        toFirst()
        rotateScreen()
        checkBackstackSize(1)
    }

    @Test
    fun testSize2ndTo1stWithRotation() {
        toSecond()
        toFirst()
        rotateScreen()
        checkBackstackSize(1)
    }

    @Test
    fun testSize3rdTo2ndTo1stWithRotation() {
        toSecond()
        toThird()
        toSecond()
        toFirst()
        rotateScreen()
        checkBackstackSize(1)
    }

    @Test
    fun testSize3rdTo1stTo2ndWithRotation() {
        toSecond()
        toThird()
        toFirst()
        toSecond()
        rotateScreen()
        checkBackstackSize(2)
    }
}