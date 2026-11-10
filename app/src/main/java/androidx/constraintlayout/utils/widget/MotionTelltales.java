package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;

public class MotionTelltales extends MockView {
    private static final String TAG = "MotionTelltales";
    Matrix mInvertMatrix;
    MotionLayout mMotionLayout;
    private Paint mPaintTelltales;
    int mTailColor;
    float mTailScale;
    int mVelocityMode;
    float[] velocity;

    public MotionTelltales(Context arg2) {
        super(arg2);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = 0xFFFF00FF;
        this.mTailScale = 0.25f;
        this.init(arg2, null);
    }

    public MotionTelltales(Context arg2, AttributeSet arg3) {
        super(arg2, arg3);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = 0xFFFF00FF;
        this.mTailScale = 0.25f;
        this.init(arg2, arg3);
    }

    public MotionTelltales(Context arg1, AttributeSet arg2, int arg3) {
        super(arg1, arg2, arg3);
        this.mPaintTelltales = new Paint();
        this.velocity = new float[2];
        this.mInvertMatrix = new Matrix();
        this.mVelocityMode = 0;
        this.mTailColor = 0xFFFF00FF;
        this.mTailScale = 0.25f;
        this.init(arg1, arg2);
    }

    private void init(Context arg4, AttributeSet arg5) {
        if(arg5 != null) {
            TypedArray v4 = arg4.obtainStyledAttributes(arg5, styleable.MotionTelltales);
            int v5 = v4.getIndexCount();
            int v0;
            for(v0 = 0; v0 < v5; ++v0) {
                int v1 = v4.getIndex(v0);
                if(v1 == styleable.MotionTelltales_telltales_tailColor) {
                    this.mTailColor = v4.getColor(v1, this.mTailColor);
                }
                else if(v1 == styleable.MotionTelltales_telltales_velocityMode) {
                    this.mVelocityMode = v4.getInt(v1, this.mVelocityMode);
                }
                else if(v1 == styleable.MotionTelltales_telltales_tailScale) {
                    this.mTailScale = v4.getFloat(v1, this.mTailScale);
                }
            }
        }

        this.mPaintTelltales.setColor(this.mTailColor);
        this.mPaintTelltales.setStrokeWidth(5f);
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    public void onDraw(Canvas arg20) {
        MotionTelltales v1 = this;
        super.onDraw(arg20);
        v1.getMatrix().invert(v1.mInvertMatrix);
        if(v1.mMotionLayout == null) {
            ViewParent v0 = v1.getParent();
            if((v0 instanceof MotionLayout)) {
                v1.mMotionLayout = ((MotionLayout)v0);
                return;
            }
        }
        else {
            int v6 = v1.getWidth();
            int v7 = v1.getHeight();
            int v8 = 5;
            float[] v9 = new float[]{0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
            int v11;
            for(v11 = 0; v11 < v8; ++v11) {
                float v3 = v9[v11];
                int v12;
                for(v12 = 0; v12 < v8; ++v12) {
                    float v2 = v9[v12];
                    v1.mMotionLayout.getViewVelocity(((View)v1), v2, v3, v1.velocity, v1.mVelocityMode);
                    v1.mInvertMatrix.mapVectors(v1.velocity);
                    float v14 = (((float)v6)) * v2;
                    float v15 = (((float)v7)) * v3;
                    float[] v0_1 = v1.velocity;
                    float v16 = v14 - v0_1[0] * v1.mTailScale;
                    float v17 = v15 - v0_1[1] * v1.mTailScale;
                    v1.mInvertMatrix.mapVectors(v0_1);
                    arg20.drawLine(v14, v15, v16, v17, v1.mPaintTelltales);
                }
            }
        }
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        this.postInvalidate();
    }

    public void setText(CharSequence arg1) {
        this.mText = arg1.toString();
        this.requestLayout();
    }
}

