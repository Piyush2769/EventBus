package com.piyush.eventbus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends AppCompatActivity {

    Button launch;
    EditText results;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);
        results=findViewById(R.id.editText1);
        launch=findViewById(R.id.button2);

        launch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainActivity.this,ChildActivity.class);
                startActivity(i);
            }
        });


    }

    @Subscribe
    public void onEvent(CustomMessageEvent event)
    {
        Log.d("Piyush","event fired"+event.getCustomMessage());
        results.setText(event.getCustomMessage());
    }
}
