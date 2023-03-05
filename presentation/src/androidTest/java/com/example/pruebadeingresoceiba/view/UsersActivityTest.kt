package com.example.pruebadeingresoceiba.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.pruebadeingresoceiba.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class UsersActivityTest {

    @get:Rule var activityTestScenarioRule: ActivityScenarioRule<UsersActivity> = ActivityScenarioRule(UsersActivity::class.java)



    @Test
    fun dataEntryFilterName() {
        onView(withId(R.id.search_users))
            .perform(typeText("Nicholas "), closeSoftKeyboard())
    }
}