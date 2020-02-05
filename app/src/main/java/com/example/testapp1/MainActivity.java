package com.example.testapp1;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;
import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.analytics.Analytics;
import com.microsoft.appcenter.crashes.Crashes;

import com.microsoft.appcenter.AppCenter;
import com.microsoft.appcenter.push.Push;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

       FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //analytics
        //AppCenter.start(getApplication(), "233cfe00-a6b7-40cf-9a18-334b4eeca51c",
        //        Analytics.class, Crashes.class);

        //push
        AppCenter.start(getApplication(), "e540a7f6-2597-4e55-84a1-87014f6e9db9", Push.class);

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

    public void onClickEventTrigger(View view) {
        // Do something in response to button click

        java.util.Map<String, String> properties = new java.util.HashMap<>();
        properties.put("Category", "Music");
        properties.put("FileName", "favorite.avi");

        Analytics.trackEvent("Button clicked", properties);
        System.out.println("Event triggered");

    }

    public void onClickCrash(View view) {
        System.out.println("Crash Event triggered");

        java.util.List<Integer> num = new java.util.ArrayList<>();

        for (int i = 0; i < 3; i++) {
            int n = (int)Math.random();
            num.add(n);
        }
        System.out.println("Crashing app");
        System.out.println(num.get(4));
    }
}


