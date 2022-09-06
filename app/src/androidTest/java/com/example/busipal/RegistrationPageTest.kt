package com.example.busipal

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import junit.framework.TestCase
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4::class)
class RegistrationPageTest {

    @Rule @JvmField
    var activityTestRule = ActivityTestRule(RegistrationPage::class.java)

    @Test
    fun a_registerTest() {
        Espresso.onView(ViewMatchers.withId(R.id.etUsername)).perform(ViewActions.typeText("dario"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.etEmail))
            .perform(ViewActions.typeText("dario@gmail.com"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.etPassword)).perform(ViewActions.typeText("dario"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.etRetype)).perform(ViewActions.typeText("dario"))
        Espresso.closeSoftKeyboard()
        Espresso.onView(ViewMatchers.withId(R.id.btnRegister)).perform(ViewActions.click())

    }
}