package com.udacity.gradle.builditbigger.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.example.android.androidjokes.AndJokeActivity;
import com.udacity.gradle.builditbigger.R;

public class MainActivity extends AppCompatActivity implements EndpointsAsyncTask.JokeCallback {

    private ProgressBar spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.progressBar);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

//    public void tellJoke(View view) {
//        String Joke = new JokeTeller().Joke();
//        Toast.makeText(this, Joke, Toast.LENGTH_SHORT).show();
//    }

    public void launchLibraryActivity(View view) {
        spinner.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask(this).execute();
    }

    @Override
    public void onGetJoke(String joke) {
        spinner.setVisibility(View.GONE);
        Intent myIntent = new Intent(this, AndJokeActivity.class);
        myIntent.putExtra("Joke Extra", joke);
        startActivity(myIntent);
    }
}
