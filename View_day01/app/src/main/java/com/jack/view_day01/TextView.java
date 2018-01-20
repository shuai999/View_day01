package com.jack.view_day01;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Email 2185134304@qq.com
 * Created by Jack on 2018/1/20.
 * Version 1.0
 * Description:  自定义View
 */
public class TextView extends View {


    private String mText ;
    private int mTextSize = 15 ; //默认是15sp
    private int mTextColor = Color.BLACK ; // 默认给文字设置颜色为黑色


    //和系统一样，将此构造方法的super(context)改为this(context , null)，默认会调用第二个构造方法
    //此方法会在代码中new的时候调用
    //TextView tv = new TextView(this)
    public TextView(Context context) {
        this(context , null);
    }


    //和系统一样，将此构造方法的super(context,attrs)改为this(context , attrs , 0)，默认会调用第三个构造方法
    //这样的话，无论你写的是哪个构造方法，都会默认去调用第三个构造发方法
    //此方法在布局文件Layout中使用
    /*<com.jack.view.MyTextView
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:text="我爱王子文"
            />*/
    public TextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }


    //此方法在布局文件Layout中使用  但是会有style
    public TextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        //获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TextView);
        mText = typedArray.getString(R.styleable.TextView_text) ;
        mTextColor = typedArray.getColor(R.styleable.TextView_textColor, mTextColor);
        //15sp
        mTextSize = typedArray.getDimensionPixelSize(R.styleable.TextView_textSize , mTextSize) ;

        typedArray.recycle();
    }


    /**
     *  自定义View的测量方法
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        //获取宽高的模式
        int widthMode = MeasureSpec.getMode(widthMeasureSpec) ;
        int heightMode = MeasureSpec.getMode(heightMeasureSpec) ;


        //表示在布局中给宽高指定的是 wrap_content
        if (widthMode == MeasureSpec.AT_MOST){

        }

        //表示在布局中给宽高指定的是具体的值  如100dp、match_parent、fill_parent
        if (widthMode == MeasureSpec.EXACTLY){

        }

        //尽可能的大 很少用到 一般系统会用到 如ListView、ScrollView
        if (widthMode == MeasureSpec.UNSPECIFIED){
        }
    }


    /**
     * 用于绘制
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /*//绘制文字
        canvas.drawText();
        //绘制弧
        canvas.drawArc();
        //绘制圆
        canvas.drawCircle();*/
    }


    /**
     * 处理跟用户交互的、手指触摸等等
     * @param event  事件分发、事件拦截
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN :
                 //手指按下
                 Log.e("TAG" , "手指按下") ;
                 break;
            case MotionEvent.ACTION_MOVE :
                 //手指移动
                 Log.e("TAG" , "手指移动") ;
                 break;
            case MotionEvent.ACTION_UP :
                 //手指抬起
                 Log.e("TAG" , "手指抬起") ;
                 break;
        }
        return super.onTouchEvent(event);
    }
}
