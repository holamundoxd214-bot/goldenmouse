package androidx.appcompat.graphics.drawable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint$Cap;
import android.graphics.Paint$Join;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.appcompat.R$attr;
import androidx.appcompat.R$style;
import androidx.appcompat.R$styleable;
import androidx.core.graphics.drawable.DrawableCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class DrawerArrowDrawable extends Drawable {
    @Retention(value=RetentionPolicy.SOURCE) @public interface ArrowDirection {
    }

    public static final int ARROW_DIRECTION_END = 3;
    public static final int ARROW_DIRECTION_LEFT = 0;
    public static final int ARROW_DIRECTION_RIGHT = 1;
    public static final int ARROW_DIRECTION_START = 2;
    private static final float ARROW_HEAD_ANGLE;
    private float mArrowHeadLength;
    private float mArrowShaftLength;
    private float mBarGap;
    private float mBarLength;
    private int mDirection;
    private float mMaxCutForBarSize;
    private final Paint mPaint;
    private final Path mPath;
    private float mProgress;
    private final int mSize;
    private boolean mSpin;
    private boolean mVerticalMirror;

    static {
        DrawerArrowDrawable.ARROW_HEAD_ANGLE = ((float)Math.toRadians(45));
    }

    public DrawerArrowDrawable(Context arg7) {
        super();
        Paint v0 = new Paint();
        this.mPaint = v0;
        this.mPath = new Path();
        this.mVerticalMirror = false;
        this.mDirection = 2;
        v0.setStyle(Paint$Style.STROKE);
        v0.setStrokeJoin(Paint$Join.MITER);
        v0.setStrokeCap(Paint$Cap.BUTT);
        v0.setAntiAlias(true);
        TypedArray v7 = arg7.getTheme().obtainStyledAttributes(null, styleable.DrawerArrowToggle, attr.drawerArrowStyle, style.Base_Widget_AppCompat_DrawerArrowToggle);
        this.setColor(v7.getColor(styleable.DrawerArrowToggle_color, 0));
        this.setBarThickness(v7.getDimension(styleable.DrawerArrowToggle_thickness, 0f));
        this.setSpinEnabled(v7.getBoolean(styleable.DrawerArrowToggle_spinBars, true));
        this.setGapSize(((float)Math.round(v7.getDimension(styleable.DrawerArrowToggle_gapBetweenBars, 0f))));
        this.mSize = v7.getDimensionPixelSize(styleable.DrawerArrowToggle_drawableSize, 0);
        this.mBarLength = ((float)Math.round(v7.getDimension(styleable.DrawerArrowToggle_barLength, 0f)));
        this.mArrowHeadLength = ((float)Math.round(v7.getDimension(styleable.DrawerArrowToggle_arrowHeadLength, 0f)));
        this.mArrowShaftLength = v7.getDimension(styleable.DrawerArrowToggle_arrowShaftLength, 0f);
        v7.recycle();
    }

    public void draw(Canvas arg19) {
        DrawerArrowDrawable v0 = this;
        Canvas v1 = arg19;
        Rect v2 = v0.getBounds();
        int v3 = v0.mDirection;
        int v4 = 0;
        if(v3 != 0) {
            if(v3 != 1) {
                if(v3 == 3) {
                    if(DrawableCompat.getLayoutDirection(((Drawable)v0)) == 0) {
                        goto label_15;
                    }

                    goto label_16;
                }
                else if(DrawableCompat.getLayoutDirection(((Drawable)v0)) == 1) {
                }
                else {
                    goto label_16;
                }
            }

        label_15:
            v4 = 1;
        }

    label_16:
        float v6 = 2f;
        float v3_1 = DrawerArrowDrawable.lerp(v0.mBarLength, ((float)Math.sqrt(((double)(v0.mArrowHeadLength * v0.mArrowHeadLength * v6)))), v0.mProgress);
        float v7 = DrawerArrowDrawable.lerp(v0.mBarLength, v0.mArrowShaftLength, v0.mProgress);
        float v8 = ((float)Math.round(DrawerArrowDrawable.lerp(0f, v0.mMaxCutForBarSize, v0.mProgress)));
        float v9 = DrawerArrowDrawable.lerp(0f, DrawerArrowDrawable.ARROW_HEAD_ANGLE, v0.mProgress);
        float v11 = v4 != 0 ? 0f : -180f;
        float v12 = 180f;
        float v13 = v4 != 0 ? v12 : 0f;
        v11 = DrawerArrowDrawable.lerp(v11, v13, v0.mProgress);
        double v13_1 = ((double)v3_1);
        float v15 = v6;
        double v5 = ((double)v9);
        int v9_1 = v4;
        v3_1 = ((float)Math.round(Math.cos(v5) * v13_1));
        float v4_1 = ((float)Math.round(v13_1 * Math.sin(v5)));
        v0.mPath.rewind();
        float v5_1 = DrawerArrowDrawable.lerp(v0.mBarGap + v0.mPaint.getStrokeWidth(), -v0.mMaxCutForBarSize, v0.mProgress);
        v6 = -v7 / v15;
        v0.mPath.moveTo(v6 + v8, 0f);
        v0.mPath.rLineTo(v7 - v8 * v15, 0f);
        v0.mPath.moveTo(v6, v5_1);
        v0.mPath.rLineTo(v3_1, v4_1);
        v0.mPath.moveTo(v6, -v5_1);
        v0.mPath.rLineTo(v3_1, -v4_1);
        v0.mPath.close();
        v1.save();
        v3_1 = v0.mPaint.getStrokeWidth();
        v1.translate(((float)v2.centerX()), (((float)((((int)((((float)v2.height())) - 3f * v3_1 - v0.mBarGap * v15))) / 4 * 2))) + (v3_1 * 1.5f + v0.mBarGap));
        if(v0.mSpin) {
            int v5_2 = (v0.mVerticalMirror ^ v9_1) != 0 ? -1 : 1;
            v1.rotate(v11 * (((float)v5_2)));
        }
        else {
            if(v9_1 == 0) {
                goto label_129;
            }

            v1.rotate(v12);
        }

    label_129:
        v1.drawPath(v0.mPath, v0.mPaint);
        v1.restore();
    }

    public float getArrowHeadLength() {
        return this.mArrowHeadLength;
    }

    public float getArrowShaftLength() {
        return this.mArrowShaftLength;
    }

    public float getBarLength() {
        return this.mBarLength;
    }

    public float getBarThickness() {
        return this.mPaint.getStrokeWidth();
    }

    public int getColor() {
        return this.mPaint.getColor();
    }

    public int getDirection() {
        return this.mDirection;
    }

    public float getGapSize() {
        return this.mBarGap;
    }

    public int getIntrinsicHeight() {
        return this.mSize;
    }

    public int getIntrinsicWidth() {
        return this.mSize;
    }

    public int getOpacity() {
        return -3;
    }

    public final Paint getPaint() {
        return this.mPaint;
    }

    public float getProgress() {
        return this.mProgress;
    }

    public boolean isSpinEnabled() {
        return this.mSpin;
    }

    private static float lerp(float arg0, float arg1, float arg2) {
        return arg0 + (arg1 - arg0) * arg2;
    }

    public void setAlpha(int arg2) {
        if(arg2 != this.mPaint.getAlpha()) {
            this.mPaint.setAlpha(arg2);
            this.invalidateSelf();
        }
    }

    public void setArrowHeadLength(float arg2) {
        if(this.mArrowHeadLength != arg2) {
            this.mArrowHeadLength = arg2;
            this.invalidateSelf();
        }
    }

    public void setArrowShaftLength(float arg2) {
        if(this.mArrowShaftLength != arg2) {
            this.mArrowShaftLength = arg2;
            this.invalidateSelf();
        }
    }

    public void setBarLength(float arg2) {
        if(this.mBarLength != arg2) {
            this.mBarLength = arg2;
            this.invalidateSelf();
        }
    }

    public void setBarThickness(float arg5) {
        if(this.mPaint.getStrokeWidth() != arg5) {
            this.mPaint.setStrokeWidth(arg5);
            this.mMaxCutForBarSize = ((float)((((double)(arg5 / 2f))) * Math.cos(((double)DrawerArrowDrawable.ARROW_HEAD_ANGLE))));
            this.invalidateSelf();
        }
    }

    public void setColor(int arg2) {
        if(arg2 != this.mPaint.getColor()) {
            this.mPaint.setColor(arg2);
            this.invalidateSelf();
        }
    }

    public void setColorFilter(ColorFilter arg2) {
        this.mPaint.setColorFilter(arg2);
        this.invalidateSelf();
    }

    public void setDirection(int arg2) {
        if(arg2 != this.mDirection) {
            this.mDirection = arg2;
            this.invalidateSelf();
        }
    }

    public void setGapSize(float arg2) {
        if(arg2 != this.mBarGap) {
            this.mBarGap = arg2;
            this.invalidateSelf();
        }
    }

    public void setProgress(float arg2) {
        if(this.mProgress != arg2) {
            this.mProgress = arg2;
            this.invalidateSelf();
        }
    }

    public void setSpinEnabled(boolean arg2) {
        if(this.mSpin != arg2) {
            this.mSpin = arg2;
            this.invalidateSelf();
        }
    }

    public void setVerticalMirror(boolean arg2) {
        if(this.mVerticalMirror != arg2) {
            this.mVerticalMirror = arg2;
            this.invalidateSelf();
        }
    }
}

