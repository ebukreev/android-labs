package dev.ebukreev.task5

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.launchActivity
import org.junit.Before

abstract class AbstractTest {
    @Before
    fun setUp() {
        scenario = launchActivity()
    }

    companion object {
        lateinit var scenario: ActivityScenario<MainActivity>
    }
}