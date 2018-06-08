package com.example.aayushi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = new Intent(this,MyAccessibilityService.class);
        startService(intent);
        //startActivityForResult(settingsIntent,0);
        mButton = (Button) findViewById(R.id.click_me);
        mButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.aayushi.firstapp");
        startActivity(launchIntent);
    }
}
