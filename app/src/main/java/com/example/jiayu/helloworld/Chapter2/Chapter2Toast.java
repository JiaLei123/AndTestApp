package com.example.jiayu.helloworld.Chapter2;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jiayu.helloworld.R;

public class Chapter2Toast extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_toast);

        Button simple = (Button) findViewById(R.id.simple);
        assert simple != null;
        simple.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = Toast.makeText(Chapter2Toast.this, "简单信息提示", Toast.LENGTH_SHORT);
                toast.show();
            }
        });


        Button bn = (Button) findViewById(R.id.bn);
        assert bn != null;
        bn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(Chapter2Toast.this);
                toast.setGravity(Gravity.CENTER, 0, 0);
                ImageView image = new ImageView(Chapter2Toast.this);
                image.setImageResource(R.drawable.tools);
                LinearLayout li = new LinearLayout(Chapter2Toast.this);
                li.addView(image);
                TextView textView = new TextView(Chapter2Toast.this);
                textView.setText("带图片的提示信息");
                textView.setTextSize(24);
                textView.setTextColor(Color.MAGENTA);
                li.addView(textView);
                toast.setView(li);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });

        Button bn2 = (Button) findViewById(R.id.bn2);
        assert bn2 != null;
        bn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast = new Toast(Chapter2Toast.this);
                toast.setGravity(Gravity.CENTER, 0, 0);
                LayoutInflater inflater = LayoutInflater.from(Chapter2Toast.this);
                View li = inflater.inflate(R.layout.cell_with_text, null);
                ImageView imageView = (ImageView) li.findViewById(R.id.cellImage);
                imageView.setImageResource(R.drawable.tools);
                TextView textView = (TextView) li.findViewById(R.id.cellText);
                textView.setText("带图片的文字");

                toast.setView(li);
                toast.setDuration(Toast.LENGTH_LONG);
                toast.show();
            }
        });
    }
}
