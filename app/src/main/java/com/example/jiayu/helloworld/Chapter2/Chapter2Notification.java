package com.example.jiayu.helloworld.Chapter2;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.jiayu.helloworld.R;

public class Chapter2Notification extends AppCompatActivity {

    static  final int NOTIFICATION_ID = 0X123;
    NotificationManager nm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_notification);

        nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
    }

    public void send(View source) {
        Intent intent = new Intent(Chapter2Notification.this, Chapter2ScrollView.class);
        PendingIntent pi = PendingIntent.getActivity(Chapter2Notification.this, 0, intent, 0);

        Notification notify = new Notification.Builder(this)
                .setAutoCancel(true)
                .setTicker("有新消息")
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("一条新通知")
                //.setSound(Uri.parse("android.resource://org.crazyit.ui/" + R.row.msg))
                .setWhen(System.currentTimeMillis())
                .setContentIntent(pi)
                .build();
        nm.notify(NOTIFICATION_ID, notify);
    }

    public void cancel(View view) {
        nm.cancel(NOTIFICATION_ID);
    }
}
