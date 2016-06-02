package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.QuickContactBadge;

import com.example.jiayu.helloworld.R;


public class Chapter2QuickContactBadge extends AppCompatActivity {

    QuickContactBadge badge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_quick_contact_badge);

        badge = (QuickContactBadge) findViewById(R.id.badge);
        badge.assignContactFromPhone("020-88888888", false);
    }
}
