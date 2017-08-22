package com.hencoder.hencoderpracticedraw5.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

import com.hencoder.hencoderpracticedraw5.R;
/*
*
* 总调度方法:
* draw 调用所有绘制流程的相关方法
* 在 ViewGroup 的子类中重写除 dispatchDraw() 以外的绘制方法时，可能需要调用 setWillNotDraw(false)；
* s在重写的方法有多个选择时，优先选择 onDraw()。
*
*绘制流程
* 1.背景 drawBackground 不可重写
* 2.主体
* 3.子view
* 4.滑动边缘渐变滑动条 onDrawForeGround 可重写
* 5.前景 onDrawForeGround 可重写
* */
public class Practice01AfterOnDrawView extends AppCompatImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);

    public Practice01AfterOnDrawView(Context context) {
        super(context);
    }

    public Practice01AfterOnDrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice01AfterOnDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint.setColor(Color.parseColor("#FFC107"));
        paint.setTextSize(28);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 在 super.onDraw() 的下方插入绘制代码，让绘制内容盖住原主体内容
        // 由于这期的重点是绘制代码的位置而不是绘制代码本身，所以直接给出绘制代码，你只要解除注释就好
        // 爽吧？

        Drawable drawable = getDrawable();
        if (drawable != null) {
            canvas.save();
            canvas.concat(getImageMatrix());
            Rect bounds = drawable.getBounds();
            canvas.drawText(getResources().getString(R.string.image_size, bounds.width(), bounds.height()), 20, 40, paint);
            canvas.restore();
        }
    }
}