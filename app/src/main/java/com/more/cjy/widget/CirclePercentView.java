package com.more.cjy.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.more.cjy.R;


/**
 * {此处写描述信息}
 * <p>
 * <p>
 * 作者：cjy on 2018/2/1 16:23
 * 邮箱：cuijingyi@miao.cn
 */

public class CirclePercentView extends View {

    private int mRadius;
    //中心点坐标
    private int center_x, center_y;
    private float x, y;
    private int mWidth = 100, mHeight = 100;
    private Paint paintProgress, bgPaint, textPaint, percentPaint;
    //圆弧的范围
    private RectF rectf;
    private float angle;
    //100
    private int progress;
    private MyOnClickListener listener;

    private int state = 0;
    public static final int STATE_NORMAL = 0;
    public static final int STATE_SELECT = 1;
    public static final int STATE_CHANGE = 2;
    public static final int STATE_OVER = 3;
    private Bitmap b_select, b_tiaojie;
    private String text;
    private RectF textRectF, percentRectF;
    private int baseLineY, baseLineY2;
    private Handler handler;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public interface MyOnClickListener {
        void onClick();
        void onClickEnd();
    }

    public void setListener(MyOnClickListener listener) {
        this.listener = listener;
    }

    public CirclePercentView(Context context) {
        this(context, null);
    }

    public CirclePercentView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CirclePercentView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        handler = new Handler();

        paintProgress = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintProgress.setStyle(Paint.Style.STROKE);
        paintProgress.setStrokeCap(Paint.Cap.ROUND);
        paintProgress.setStrokeWidth(10);
        paintProgress.setColor(Color.parseColor("#fd6028"));
        paintProgress.setMaskFilter(new BlurMaskFilter(10, BlurMaskFilter.Blur.SOLID));

        bgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        bgPaint.setStyle(Paint.Style.STROKE);
        bgPaint.setStrokeWidth(3);
        bgPaint.setTextSize(16);
        bgPaint.setColor(Color.BLACK);

        textPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        textPaint.setColor(Color.BLACK);
        textPaint.setTextSize(20);
        //该方法即为设置基线上那个点究竟是left,center,还是right  这里我设置为center
        textPaint.setTextAlign(Paint.Align.CENTER);

        percentPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        percentPaint.setColor(Color.parseColor("#fd6028"));
        percentPaint.setTextSize(12);
        percentPaint.setTextAlign(Paint.Align.CENTER);

        b_select = BitmapFactory.decodeResource(getResources(), R.mipmap.xuanzhong);
        b_tiaojie = BitmapFactory.decodeResource(getResources(), R.mipmap.tiaojie);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(state == STATE_NORMAL) {
            canvas.drawCircle(center_x, center_y, mRadius, bgPaint);
            textPaint.setColor(Color.BLACK);
        } else if(state == STATE_SELECT) {
            canvas.drawBitmap(b_select, x, y, bgPaint);
            canvas.drawArc(rectf, 270, angle, false, paintProgress);
            textPaint.setColor(Color.parseColor("#fd6028"));
            percentPaint.setTextSize(16);
            canvas.drawText(progress + "%", percentRectF.centerX(), baseLineY2, percentPaint);
        } else if(state == STATE_CHANGE) {
            canvas.drawBitmap(b_tiaojie, x, y, bgPaint);
            canvas.drawArc(rectf, 270, angle, false, paintProgress);
            textPaint.setColor(Color.parseColor("#fd6028"));
            percentPaint.setTextSize(16);
            canvas.drawText(progress + "%", percentRectF.centerX(), baseLineY2, percentPaint);
        } else if(state == STATE_OVER) {
            canvas.drawBitmap(b_select, x, y, bgPaint);
            textPaint.setColor(Color.parseColor("#fd6028"));
            percentPaint.setTextSize(12);
            canvas.drawText(progress + "%", percentRectF.centerX(), baseLineY2, percentPaint);
        }

//        canvas.drawText(text, center_x, center_y, textPaint);
        canvas.drawText(text, textRectF.centerX(), baseLineY - 10, textPaint);
//        canvas.drawCircle(center_x, center_y, mRadius, bgPaint);
//        canvas.drawArc(rectf, 270, angle, false, paintProgress);
    }

//    @Override
//    public void setOnClickListener(@Nullable OnClickListener l) {
//        super.setOnClickListener(l);
//    }

    public void setState(int state) {
        this.state = state;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                if (x + getLeft() < getRight() && y + getTop() < getBottom()) {
                    if(listener != null) {
                        listener.onClick();
                    }
                }
                break;
        }
        return true;
    }

    public void setProgress(int progress) {
        this.progress = progress;
        handler.removeCallbacks(runnable);
        handler.postDelayed(runnable, 3000);
        angle = (((float) progress) * 3.6f);
        invalidate();
    }

    public float getProgress() {
        return progress;
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(getProgress() == 0) {
                setState(STATE_NORMAL);
            } else {
                setState(STATE_OVER);
            }
            if(listener != null) {
                listener.onClickEnd();
            }
        }
    };

    public void setBg(int progress) {
        if(progress == 0) {
            bgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            bgPaint.setStyle(Paint.Style.STROKE);
            bgPaint.setStrokeWidth(3);
            bgPaint.setColor(Color.BLACK);
        } else {
            bgPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
            bgPaint.setStyle(Paint.Style.STROKE);
            bgPaint.setColor(Color.parseColor("#fd6028"));
            bgPaint.setStrokeWidth(10);
            bgPaint.setMaskFilter(new BlurMaskFilter(5, BlurMaskFilter.Blur.SOLID));
        }
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        x = getX();
        y = getY();
        //获取view的宽高
        int width = getMeasuredWidth();
        int height = getMeasuredHeight();
        //圆圈的宽高
        mWidth = width - getPaddingLeft() - getPaddingRight();
        mHeight = height - getPaddingTop() - getPaddingBottom() - 20;
        mRadius = mWidth / 2;
        center_x = width / 2;
        center_y = mHeight / 2;

        rectf = new RectF(center_x - mRadius, center_y - mRadius,
                center_x + mRadius, center_y + mRadius);

        b_select = zoomImg(b_select, width, mHeight);
        b_tiaojie = zoomImg(b_tiaojie, width, mHeight);

        textRectF = new RectF(x, y, width, mHeight);
        Paint.FontMetrics fontMetrics = textPaint.getFontMetrics();
        float top = fontMetrics.top;//为基线到字体上边框的距离,即上图中的top
        float bottom = fontMetrics.bottom;//为基线到字体下边框的距离,即上图中的bottom
        baseLineY = (int) (textRectF.centerY() - top/2 - bottom/2);//基线中间点的y轴计算公式

        percentRectF = new RectF(x, mHeight, width, height);
        Paint.FontMetrics fontMetrics2 = percentPaint.getFontMetrics();
        float top2 = fontMetrics2.top;//为基线到字体上边框的距离,即上图中的top
        float bottom2 = fontMetrics2.bottom;//为基线到字体下边框的距离,即上图中的bottom
        baseLineY2 = (int) (percentRectF.centerY() - top2/2 - bottom2/2);//基线中间点的y轴计算公式

        //设置视图的大小
//        setMeasuredDimension(mWidth + 50, mHeight + 50);
    }

    //在代码中设置Bitmap图片的大小的方法以：
    public Bitmap zoomImg(Bitmap bm, int newWidth ,int newHeight){
        // 获得图片的宽高
        int width = bm.getWidth();
        int height = bm.getHeight();
        // 计算缩放比例
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        // 取得想要缩放的matrix参数
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);
        // 得到新的图片   www.2cto.com
        Bitmap newbm = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, true);
        return newbm;
    }
}
