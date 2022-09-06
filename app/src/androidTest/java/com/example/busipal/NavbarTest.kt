package com.example.busipal

import android.view.View
import android.widget.ScrollView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
class NavbarTest {

    @Rule @JvmField
    var activityTestRule = ActivityTestRule(Navbar::class.java)

    @Test
    fun a_homeFragmentVisibleTest(){
        onView(withId(R.id.homeFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun b_navbarTest(){
        onView(withId(R.id.navigation_calender)).perform(ViewActions.click())
        onView(withId(R.id.calenderFragment)).check(matches(isDisplayed()))

        onView(withId(R.id.navigation_staff)).perform(ViewActions.click())
        onView(withId(R.id.staffFragment)).check(matches(isDisplayed()))

        onView(withId(R.id.navigation_profile)).perform(ViewActions.click())
        onView(withId(R.id.profileFragment)).check(matches(isDisplayed()))

        onView(withId(R.id.navigation_home)).perform(ViewActions.click())
        onView(withId(R.id.homeFragment)).check(matches(isDisplayed()))
    }

    @Test
    fun c_homeFragmentButtonTest(){
        onView(withId(R.id.btnCatatanTransaksi)).perform(ViewActions.click())
        onView(withId(R.id.catatanTransaksi)).check(matches(isDisplayed()))

        onView(withId(R.id.btnBack)).perform(ViewActions.click())

        onView(withId(R.id.btnCatatanHutang)).perform(ViewActions.click())
        onView(withId(R.id.catatanHutang)).check(matches(isDisplayed()))

        onView(withId(R.id.btnBack)).perform(ViewActions.click())

        onView(withId(R.id.btnStokBarang)).perform(ViewActions.click())
        onView(withId(R.id.stokBarang)).check(matches(isDisplayed()))

        onView(withId(R.id.btnBack)).perform(ViewActions.click())
    }

    @Test
    fun d_calenderFragmentButtonTest(){
        onView(withId(R.id.navigation_calender)).perform(ViewActions.click())
        onView(withId(R.id.calenderFragment)).check(matches(isDisplayed()))

        onView(withId(R.id.btnJatuhTempo)).perform(ViewActions.click())
        onView(withId(R.id.calenderJatuhTempo)).check(matches(isDisplayed()))

        onView(withId(R.id.btnBack)).perform(ViewActions.click())

        onView(withId(R.id.navigation_calender)).perform(ViewActions.click())
        onView(withId(R.id.calenderFragment)).check(matches(isDisplayed()))

        onView(withId(R.id.btnPlus)).perform(ViewActions.click())
        onView(withId(R.id.calenderNew)).check(matches(isDisplayed()))
    }

    @Test
    fun e_staffFragmentButtonTest(){
        onView(withId(R.id.navigation_staff)).perform(ViewActions.click())
        onView(withId(R.id.staffFragment)).check(matches(isDisplayed()))

        onView(withId(R.id.btnStaffList)).perform(ViewActions.click())
        onView(withId(R.id.staffList)).check(matches(isDisplayed()))

        onView(withId(R.id.btnBack)).perform(ViewActions.click())

        onView(withId(R.id.navigation_staff)).perform(ViewActions.click())
        onView(withId(R.id.staffFragment)).check(matches(isDisplayed()))

        onView(withId(R.id.btnStaffNew)).perform(ViewActions.click())
        onView(withId(R.id.staffNew)).check(matches(isDisplayed()))
    }

    @Test
    fun f_profileButtonTest(){
        onView(withId(R.id.navigation_profile)).perform(ViewActions.click())
        onView(withId(R.id.profileFragment)).check(matches(isDisplayed()))

        onView(withId(R.id.btnUnduhLaporan)).perform(ViewActions.click())
        onView(withId(R.id.unduhLaporan)).check(matches(isDisplayed()))

    }

    @Test
    fun g_logOut(){
        onView(withId(R.id.navigation_profile)).perform(ViewActions.click())
        onView(withId(R.id.dummy)).perform(scrollTo())
        onView(withId(R.id.btnLogOut)).perform(click())
        onView(withId(R.id.mainActivity)).check(matches(isDisplayed()))
    }


    @Before
    fun setUp(){
        Intents.init()
    }

    @After
    fun tearDown(){
        Intents.release()
    }

}