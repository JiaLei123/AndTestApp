package com.example.jiayu.helloworld.Chapter2;

import android.support.v4.widget.PopupWindowCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.PopupWindow;

import com.example.jiayu.helloworld.R;

public class Chapter2PopupWindow extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_popup_window);

        View root = this.getLayoutInflater().inflate(R.layout.popup, null);
        final PopupWindow popup = new PopupWindow(root, 560, 720);

        Button button = (Button) findViewById(R.id.bn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //popup.showAsDropDown(v);

                popup.showAtLocation(findViewById(R.id.bn), Gravity.CENTER, 20, 20);
            }
        });

        root.findViewById(R.id.close).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popup.dismiss();
            }
        });

    }
}
