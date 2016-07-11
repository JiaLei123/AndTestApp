package com.example.jiayu.helloworld.Chapter2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.jiayu.helloworld.R;

public class Chapter2SearchView extends AppCompatActivity {

    private SearchView sv;
    private ListView lv;

    private final String[] mString = {"aaaaaa", "bbbbbbb", "ccccccc"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_search_view);

        lv = (ListView) findViewById(R.id.lv);
        lv.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mString));
        lv.setTextFilterEnabled(true);

        sv = (SearchView) findViewById(R.id.sv);
        sv.setIconifiedByDefault(true);
        sv.setSubmitButtonEnabled(true);
        sv.setQueryHint("查找");
        sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(Chapter2SearchView.this, "你的选择是：" + query, Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {

                if (TextUtils.isEmpty(newText)) {
                    lv.clearTextFilter();
                } else {
                    lv.setFilterText(newText);
                }
                return true;
            }
        });
    }
}
