package com.udacity.gradle.builditbigger.main;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import android.util.Log;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTesting {

    private static final String TAG = "AsyncTaskTest";

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void checkTaskResult() {

        try {
            new EndpointsAsyncTask(new EndpointsAsyncTask.JokeCallback() {
                @Override
                public void onGetJoke(String joke) {
                    Assert.assertTrue(joke.length() > 0);
                }
            }).execute();
        } catch (Exception e) {
            Log.d(TAG, e.getMessage() );
        }
    }
}
