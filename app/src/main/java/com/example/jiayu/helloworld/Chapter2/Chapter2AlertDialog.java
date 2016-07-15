package com.example.jiayu.helloworld.Chapter2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.jiayu.helloworld.R;
import com.example.jiayu.helloworld.Uiltity.Constants;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Chapter2AlertDialog extends AppCompatActivity {

    TextView show;
    String[] items = Constants.books;
    boolean[] choices = new boolean[]{false, true, false, true};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chapter2_alert_dialog);

        show = (TextView) findViewById(R.id.show);
    }

    public void simple(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单对话框")
                .setIcon(R.drawable.tools)
                .setMessage("对话框的测试内容\n第二行内容");
        setPositiveButton(builder);
        setNegativeButton(builder).create().show();
    }


    public void simpleList(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("简单列表对话框")
                .setIcon(R.drawable.tools)
                .setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("你选中了《" + items[which] + "》");
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();

    }

    public void singleChoice(View source) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("单选列表对话框")
                .setIcon(R.drawable.tools)
                .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("你选中了《" + items[which] + "》");
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void multiChoice(View suorce) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("多选列表项对话框")
                .setIcon(R.drawable.tools)
                .setMultiChoiceItems(items, choices, new DialogInterface.OnMultiChoiceClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                        show.setText("你选中了《" + items[which] + "》。 当然状态是" +items [0] + "是" + choices[0] + "; "+ items [1] + "是" + choices[1] );
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void customList(View srouce) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this)
                .setTitle("自定义列表项对话框")
                .setIcon(R.drawable.tools)
                .setAdapter( new ArrayAdapter<String>(this, R.layout.array_item, items) ,  new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        show.setText("你选中了《" + items[which] + "》" );
                    }
                });
        setPositiveButton(builder);
        setNegativeButton(builder)
                .create()
                .show();
    }

    public void customView(View source) {
        TableLayout loginForm = (TableLayout) getLayoutInflater().inflate(R.layout.login, null);

        new AlertDialog.Builder(this)
                .setTitle("自定义View对话框")
                .setIcon(R.drawable.tools)
                .setView(loginForm)
                .setPositiveButton("登陆", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .create()
                .show();
    }

    private AlertDialog.Builder setPositiveButton(AlertDialog.Builder builder) {
        return builder.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【确定】按钮！");
            }
        });
    }

    private AlertDialog.Builder setNegativeButton(AlertDialog.Builder builder) {
        return builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                show.setText("单击了【取消】按钮！");
            }
        });
    }
}
