package com.example.jiayu.helloworld.Chapter2;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.jiayu.helloworld.R;

import java.util.ArrayList;

public class Chapter2ViewSwitcher extends AppCompatActivity {

    public static final int NUMBER_PER_SCREEN = 12;

    public class DataItem {

        public String dataName;

        public Drawable drawable;
    }

    private ArrayList<DataItem> items = new ArrayList<>();

    private int screenNo = -1;

    private int screenCount;

    ViewSwitcher switcher;

    LayoutInflater inflater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_view_switcher);

        inflater = LayoutInflater.from(Chapter2ViewSwitcher.this);

        for(int i =0; i < 40; i++) {
            String label = "" + i;
            Drawable drawable = getResources().getDrawable(R.mipmap.ic_launcher, null);

            DataItem item = new DataItem();
            item.dataName = label;
            item.drawable = drawable;
            items.add(item);
        }

        screenCount = items.size() % NUMBER_PER_SCREEN == 0 ?
                items.size() / NUMBER_PER_SCREEN :
                items.size() / NUMBER_PER_SCREEN + 1;

        switcher = (ViewSwitcher) findViewById(R.id.viewSwitcher);

        switcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                return inflater.inflate(R.layout.slidelistview, null);
            }
        });

        next(null);
    }

    public void next(View view) {
        if (screenNo < screenCount - 1) {
            screenNo++;
            switcher.setInAnimation(this, R.anim.slide_in_right);
            switcher.setOutAnimation(this, R.anim.slide_out_left);

            ((GridView) switcher.getNextView()).setAdapter(adapter);
            switcher.showNext();
        }
    }

    public void prev(View view) {
        if (screenNo > 0) {
            screenNo--;
            switcher.setInAnimation(this, android.R.anim.slide_in_left);
            switcher.setOutAnimation(this, android.R.anim.slide_out_right);

            ((GridView) switcher.getNextView()).setAdapter(adapter);
            switcher.showPrevious();
        }
    }

    private BaseAdapter adapter = new BaseAdapter() {
        @Override
        public int getCount() {
            if (screenNo == screenCount - 1 && items.size() % NUMBER_PER_SCREEN != 0) {
                return items.size() % NUMBER_PER_SCREEN;
            }
            return NUMBER_PER_SCREEN;
        }

        @Override
        public DataItem getItem(int position) {
            return items.get(screenNo * NUMBER_PER_SCREEN + position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (convertView == null) {
                view = inflater.inflate(R.layout.labelicon, null);
            }
            ImageView imageView = (ImageView) view.findViewById(R.id.imageview);
            imageView.setImageDrawable(getItem(position).drawable);

            TextView textView = (TextView) view.findViewById(R.id.testview);
            textView.setText(getItem(position).dataName);

            return view;
        }
    };
}
