package com.example.jiayu.helloworld.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.jiayu.helloworld.R;

/**
 * TODO: document your custom view class.
 */
public class DrowView extends View {

    public float currentX = 40;
    public float currentY = 50;
    public Paint p = new Paint();

    public DrowView(Context context) {
        super(context);
    }

    public DrowView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        p.setColor(Color.RED);

        canvas.drawCircle(currentX, currentY, 15, p);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        currentX = event.getX();
        currentY = event.getY();

        invalidate();

        return  true;
    }

}
