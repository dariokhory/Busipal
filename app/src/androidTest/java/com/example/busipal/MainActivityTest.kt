package com.example.busipal

import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import junit.framework.JUnit4TestAdapter
import junit.framework.TestCase
import org.junit.*
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4::class)
class MainActivityTest{
    @Rule @JvmField
    var activityTestRule = ActivityTestRule(MainActivity::class.java)

    @Test
    fun a_loginPageVisibility() {
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()))
    }

    @Test
    fun b_loginTest(){
        onView(withId(R.id.etUsername)).perform(ViewActions.click()).perform(ViewActions.typeText("admin"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.etPw)).perform(ViewActions.click()).perform(ViewActions.typeText("admin"))
        Espresso.closeSoftKeyboard()
        onView(withId((R.id.btnLogin))).perform(ViewActions.click())
        onView(withId(R.id.nav_host_fragment_activity_navbar)).check(matches(isDisplayed()))
    }

    @Before
    fun set(){
        Intents.init()
    }

    @After
    fun tearDown(){
        Intents.release()
    }

}