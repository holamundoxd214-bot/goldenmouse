package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathEffect;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.widget.TextView;
import androidx.constraintlayout.motion.utils.StopLogic;
import androidx.constraintlayout.solver.widgets.Barrier;
import androidx.constraintlayout.solver.widgets.ConstraintAnchor$Type;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$DimensionBehaviour;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.solver.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.solver.widgets.Flow;
import androidx.constraintlayout.solver.widgets.Guideline;
import androidx.constraintlayout.solver.widgets.Helper;
import androidx.constraintlayout.solver.widgets.HelperWidget;
import androidx.constraintlayout.solver.widgets.VirtualLayout;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$styleable;
import androidx.core.view.NestedScrollingParent3;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class MotionLayout extends ConstraintLayout implements NestedScrollingParent3 {
    class androidx.constraintlayout.motion.widget.MotionLayout$2 {
        static {
            int[] v0 = new int[TransitionState.values().length];
            androidx.constraintlayout.motion.widget.MotionLayout$2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState = v0;
            try {
                v0[TransitionState.UNDEFINED.ordinal()] = 1;
                goto label_8;
            }
            catch(NoSuchFieldError ) {
                try {
                label_8:
                    androidx.constraintlayout.motion.widget.MotionLayout$2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.SETUP.ordinal()] = 2;
                    goto label_13;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_13:
                        androidx.constraintlayout.motion.widget.MotionLayout$2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.MOVING.ordinal()] = 3;
                        goto label_18;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_18:
                            androidx.constraintlayout.motion.widget.MotionLayout$2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[TransitionState.FINISHED.ordinal()] = 4;
                            return;
                        }
                        catch(NoSuchFieldError ) {
                            return;
                        }
                    }
                }
            }
        }
    }

    class DecelerateInterpolator extends MotionInterpolator {
        float currentP;
        float initalV;
        float maxA;

        DecelerateInterpolator(MotionLayout arg1) {
            MotionLayout.this = arg1;
            super();
            this.initalV = 0f;
            this.currentP = 0f;
        }

        public void config(float arg1, float arg2, float arg3) {
            this.initalV = arg1;
            this.currentP = arg2;
            this.maxA = arg3;
        }

        public float getInterpolation(float arg5) {
            float v4;
            float v0 = this.initalV;
            int v1 = Float.compare(v0, 0f);
            float v2 = this.maxA;
            float v3 = 2f;
            if(v1 > 0) {
                if(v0 / v2 < arg5) {
                    arg5 = v0 / v2;
                }

                MotionLayout.this.mLastVelocity = v0 - v2 * arg5;
                v0 = this.initalV * arg5 - this.maxA * arg5 * arg5 / v3;
                v4 = this.currentP;
            }
            else {
                if(-v0 / v2 < arg5) {
                    arg5 = -v0 / v2;
                }

                MotionLayout.this.mLastVelocity = v0 + v2 * arg5;
                v0 = this.initalV * arg5 + this.maxA * arg5 * arg5 / v3;
                v4 = this.currentP;
            }

            return v0 + v4;
        }

        public float getVelocity() {
            return MotionLayout.this.mLastVelocity;
        }
    }

    class DevModeDraw {
        private static final int DEBUG_PATH_TICKS_PER_MS = 16;
        final int DIAMOND_SIZE;
        final int GRAPH_COLOR;
        final int KEYFRAME_COLOR;
        final int RED_COLOR;
        final int SHADOW_COLOR;
        Rect mBounds;
        DashPathEffect mDashPathEffect;
        Paint mFillPaint;
        int mKeyFrameCount;
        float[] mKeyFramePoints;
        Paint mPaint;
        Paint mPaintGraph;
        Paint mPaintKeyframes;
        Path mPath;
        int[] mPathMode;
        float[] mPoints;
        boolean mPresentationMode;
        private float[] mRectangle;
        int mShadowTranslate;
        Paint mTextPaint;

        public DevModeDraw(MotionLayout arg7) {
            MotionLayout.this = arg7;
            super();
            this.RED_COLOR = 0xFFFFAA33;
            this.KEYFRAME_COLOR = -2067046;
            this.GRAPH_COLOR = 0xFF33AA00;
            this.SHADOW_COLOR = 0x77000000;
            this.DIAMOND_SIZE = 10;
            this.mBounds = new Rect();
            this.mPresentationMode = false;
            this.mShadowTranslate = 1;
            Paint v4 = new Paint();
            this.mPaint = v4;
            v4.setAntiAlias(true);
            this.mPaint.setColor(0xFFFFAA33);
            this.mPaint.setStrokeWidth(2f);
            this.mPaint.setStyle(Paint$Style.STROKE);
            Paint v0 = new Paint();
            this.mPaintKeyframes = v0;
            v0.setAntiAlias(true);
            this.mPaintKeyframes.setColor(-2067046);
            this.mPaintKeyframes.setStrokeWidth(2f);
            this.mPaintKeyframes.setStyle(Paint$Style.STROKE);
            v0 = new Paint();
            this.mPaintGraph = v0;
            v0.setAntiAlias(true);
            this.mPaintGraph.setColor(0xFF33AA00);
            this.mPaintGraph.setStrokeWidth(2f);
            this.mPaintGraph.setStyle(Paint$Style.STROKE);
            v0 = new Paint();
            this.mTextPaint = v0;
            v0.setAntiAlias(true);
            this.mTextPaint.setColor(0xFF33AA00);
            this.mTextPaint.setTextSize(arg7.getContext().getResources().getDisplayMetrics().density * 12f);
            this.mRectangle = new float[8];
            Paint v7 = new Paint();
            this.mFillPaint = v7;
            v7.setAntiAlias(true);
            DashPathEffect v7_1 = new DashPathEffect(new float[]{4f, 8f}, 0f);
            this.mDashPathEffect = v7_1;
            this.mPaintGraph.setPathEffect(((PathEffect)v7_1));
            this.mKeyFramePoints = new float[100];
            this.mPathMode = new int[50];
            if(this.mPresentationMode) {
                this.mPaint.setStrokeWidth(8f);
                this.mFillPaint.setStrokeWidth(8f);
                this.mPaintKeyframes.setStrokeWidth(8f);
                this.mShadowTranslate = 4;
            }
        }

        public void draw(Canvas arg6, HashMap arg7, int arg8, int arg9) {
            if(arg7 != null) {
                if(arg7.size() == 0) {
                }
                else {
                    arg6.save();
                    if(!MotionLayout.this.isInEditMode() && (arg9 & 1) == 2) {
                        String v0 = MotionLayout.this.getContext().getResources().getResourceName(MotionLayout.this.mEndState) + ":" + MotionLayout.this.getProgress();
                        arg6.drawText(v0, 10f, ((float)(MotionLayout.this.getHeight() - 30)), this.mTextPaint);
                        arg6.drawText(v0, 11f, ((float)(MotionLayout.this.getHeight() - 29)), this.mPaint);
                    }

                    Iterator v7 = arg7.values().iterator();
                    while(v7.hasNext()) {
                        Object v0_1 = v7.next();
                        int v1 = ((MotionController)v0_1).getDrawPath();
                        if(arg9 > 0 && v1 == 0) {
                            v1 = 1;
                        }

                        if(v1 == 0) {
                            continue;
                        }

                        this.mKeyFrameCount = ((MotionController)v0_1).buildKeyFrames(this.mKeyFramePoints, this.mPathMode);
                        if(v1 < 1) {
                            continue;
                        }

                        int v2 = arg8 / 16;
                        float[] v3 = this.mPoints;
                        if(v3 == null || v3.length != v2 * 2) {
                            this.mPoints = new float[v2 * 2];
                            this.mPath = new Path();
                        }

                        arg6.translate(((float)this.mShadowTranslate), ((float)this.mShadowTranslate));
                        this.mPaint.setColor(0x77000000);
                        this.mFillPaint.setColor(0x77000000);
                        this.mPaintKeyframes.setColor(0x77000000);
                        this.mPaintGraph.setColor(0x77000000);
                        ((MotionController)v0_1).buildPath(this.mPoints, v2);
                        this.drawAll(arg6, v1, this.mKeyFrameCount, ((MotionController)v0_1));
                        this.mPaint.setColor(0xFFFFAA33);
                        this.mPaintKeyframes.setColor(-2067046);
                        this.mFillPaint.setColor(-2067046);
                        this.mPaintGraph.setColor(0xFF33AA00);
                        arg6.translate(((float)(-this.mShadowTranslate)), ((float)(-this.mShadowTranslate)));
                        this.drawAll(arg6, v1, this.mKeyFrameCount, ((MotionController)v0_1));
                        if(v1 != 5) {
                            continue;
                        }

                        this.drawRectangle(arg6, ((MotionController)v0_1));
                    }

                    arg6.restore();
                }
            }
        }

        public void drawAll(Canvas arg2, int arg3, int arg4, MotionController arg5) {
            if(arg3 == 4) {
                this.drawPathAsConfigured(arg2);
            }

            if(arg3 == 2) {
                this.drawPathRelative(arg2);
            }

            if(arg3 == 3) {
                this.drawPathCartesian(arg2);
            }

            this.drawBasicPath(arg2);
            this.drawTicks(arg2, arg3, arg4, arg5);
        }

        private void drawBasicPath(Canvas arg2) {
            arg2.drawLines(this.mPoints, this.mPaint);
        }

        private void drawPathAsConfigured(Canvas arg7) {
            int v0 = 0;
            int v1 = 0;
            int v2 = 0;
            while(v0 < this.mKeyFrameCount) {
                int v3 = this.mPathMode[v0];
                if(v3 == 1) {
                    v1 = 1;
                }

                if(v3 == 2) {
                    v2 = 1;
                }

                ++v0;
            }

            if(v1 != 0) {
                this.drawPathRelative(arg7);
            }

            if(v2 != 0) {
                this.drawPathCartesian(arg7);
            }
        }

        private void drawPathCartesian(Canvas arg19) {
            float[] v1 = this.mPoints;
            float v2 = v1[0];
            float v4 = v1[1];
            float v5 = v1[v1.length - 2];
            float v1_1 = v1[v1.length - 1];
            arg19.drawLine(Math.min(v2, v5), Math.max(v4, v1_1), Math.max(v2, v5), Math.max(v4, v1_1), this.mPaintGraph);
            arg19.drawLine(Math.min(v2, v5), Math.min(v4, v1_1), Math.min(v2, v5), Math.max(v4, v1_1), this.mPaintGraph);
        }

        private void drawPathCartesianTicks(Canvas arg18, float arg19, float arg20) {
            float[] v2 = this.mPoints;
            float v3 = v2[0];
            float v7 = v2[1];
            float v5 = v2[v2.length - 2];
            float v8 = v2[v2.length - 1];
            float v2_1 = Math.min(v3, v5);
            float v9 = Math.max(v7, v8);
            float v4 = arg19 - Math.min(v3, v5);
            float v10 = Math.max(v7, v8) - arg20;
            String v6 = "" + (((float)(((int)((((double)(v4 * 100f / Math.abs(v5 - v3)))) + 0.5))))) / 100f;
            this.getTextBounds(v6, this.mTextPaint);
            arg18.drawText(v6, v4 / 2f - (((float)(this.mBounds.width() / 2))) + v2_1, arg20 - 20f, this.mTextPaint);
            arg18.drawLine(arg19, arg20, Math.min(v3, v5), arg20, this.mPaintGraph);
            String v2_2 = "" + (((float)(((int)((((double)(v10 * 100f / Math.abs(v8 - v7)))) + 0.5))))) / 100f;
            this.getTextBounds(v2_2, this.mTextPaint);
            arg18.drawText(v2_2, arg19 + 5f, v9 - (v10 / 2f - (((float)(this.mBounds.height() / 2)))), this.mTextPaint);
            arg18.drawLine(arg19, arg20, arg19, Math.max(v7, v8), this.mPaintGraph);
        }

        private void drawPathRelative(Canvas arg9) {
            arg9.drawLine(this.mPoints[0], this.mPoints[1], this.mPoints[this.mPoints.length - 2], this.mPoints[this.mPoints.length - 1], this.mPaintGraph);
        }

        private void drawPathRelativeTicks(Canvas arg13, float arg14, float arg15) {
            float[] v0 = this.mPoints;
            float v1 = v0[0];
            float v3 = v0[1];
            float v4 = v0[v0.length - 2];
            float v0_1 = v0[v0.length - 1];
            float v2 = ((float)Math.hypot(((double)(v1 - v4)), ((double)(v3 - v0_1))));
            v4 -= v1;
            v0_1 -= v3;
            float v5 = ((arg14 - v1) * v4 + (arg15 - v3) * v0_1) / (v2 * v2);
            float v9 = v1 + v4 * v5;
            float v10 = v3 + v5 * v0_1;
            Path v5_1 = new Path();
            v5_1.moveTo(arg14, arg15);
            v5_1.lineTo(v9, v10);
            v0_1 = ((float)Math.hypot(((double)(v9 - arg14)), ((double)(v10 - arg15))));
            String v4_1 = "" + (((float)(((int)(v0_1 * 100f / v2))))) / 100f;
            this.getTextBounds(v4_1, this.mTextPaint);
            arg13.drawTextOnPath(v4_1, v5_1, v0_1 / 2f - (((float)(this.mBounds.width() / 2))), -20f, this.mTextPaint);
            arg13.drawLine(arg14, arg15, v9, v10, this.mPaintGraph);
        }

        private void drawPathScreenTicks(Canvas arg15, float arg16, float arg17, int arg18, int arg19) {
            String v2 = "" + (((float)(((int)((((double)((arg16 - (((float)(arg18 / 2)))) * 100f / (((float)(MotionLayout.this.getWidth() - arg18)))))) + 0.5))))) / 100f;
            this.getTextBounds(v2, this.mTextPaint);
            arg15.drawText(v2, arg16 / 2f - (((float)(this.mBounds.width() / 2))) + 0f, arg17 - 20f, this.mTextPaint);
            arg15.drawLine(arg16, arg17, Math.min(0f, 1f), arg17, this.mPaintGraph);
            v2 = "" + (((float)(((int)((((double)((arg17 - (((float)(arg19 / 2)))) * 100f / (((float)(MotionLayout.this.getHeight() - arg19)))))) + 0.5))))) / 100f;
            this.getTextBounds(v2, this.mTextPaint);
            arg15.drawText(v2, arg16 + 5f, 0f - (arg17 / 2f - (((float)(this.mBounds.height() / 2)))), this.mTextPaint);
            arg15.drawLine(arg16, arg17, arg16, Math.max(0f, 1f), this.mPaintGraph);
        }

        private void drawRectangle(Canvas arg7, MotionController arg8) {
            this.mPath.reset();
            int v1;
            for(v1 = 0; v1 <= 50; ++v1) {
                arg8.buildRect((((float)v1)) / 50f, this.mRectangle, 0);
                this.mPath.moveTo(this.mRectangle[0], this.mRectangle[1]);
                this.mPath.lineTo(this.mRectangle[2], this.mRectangle[3]);
                this.mPath.lineTo(this.mRectangle[4], this.mRectangle[5]);
                this.mPath.lineTo(this.mRectangle[6], this.mRectangle[7]);
                this.mPath.close();
            }

            this.mPaint.setColor(0x44000000);
            arg7.translate(2f, 2f);
            arg7.drawPath(this.mPath, this.mPaint);
            arg7.translate(-2f, -2f);
            this.mPaint.setColor(0xFFFF0000);
            arg7.drawPath(this.mPath, this.mPaint);
        }

        private void drawTicks(Canvas arg17, int arg18, int arg19, MotionController arg20) {
            int v11;
            int v5;
            int v4;
            DevModeDraw v0 = this;
            Canvas v1 = arg17;
            int v6 = arg18;
            MotionController v7 = arg20;
            if(v7.mView != null) {
                v4 = v7.mView.getWidth();
                v5 = v7.mView.getHeight();
            }
            else {
                v4 = 0;
                v5 = 0;
            }

            int v10;
            for(v10 = 1; true; ++v10) {
                v11 = 2;
                if(v10 >= arg19 - 1) {
                    break;
                }

                int v2 = 4;
                if(v6 != v2 || v0.mPathMode[v10 - 1] != 0) {
                    float[] v3 = v0.mKeyFramePoints;
                    int v12 = v10 * 2;
                    float v13 = v3[v12];
                    float v12_1 = v3[v12 + 1];
                    v0.mPath.reset();
                    v0.mPath.moveTo(v13, v12_1 + 10f);
                    v0.mPath.lineTo(v13 + 10f, v12_1);
                    v0.mPath.lineTo(v13, v12_1 - 10f);
                    v0.mPath.lineTo(v13 - 10f, v12_1);
                    v0.mPath.close();
                    int v3_1 = v10 - 1;
                    v7.getKeyFrame(v3_1);
                    int v14 = 3;
                    if(v6 == v2) {
                        v2 = v0.mPathMode[v3_1];
                        if(v2 == 1) {
                            v0.drawPathRelativeTicks(v1, v13 - 0f, v12_1 - 0f);
                        }
                        else if(v2 == v11) {
                            v0.drawPathCartesianTicks(v1, v13 - 0f, v12_1 - 0f);
                        }
                        else if(v2 == v14) {
                            v0.drawPathScreenTicks(v1, v13 - 0f, v12_1 - 0f, v4, v5);
                        }

                        v1.drawPath(v0.mPath, v0.mFillPaint);
                    }

                    if(v6 == v11) {
                        v0.drawPathRelativeTicks(v1, v13 - 0f, v12_1 - 0f);
                    }

                    if(v6 == v14) {
                        v0.drawPathCartesianTicks(v1, v13 - 0f, v12_1 - 0f);
                    }

                    if(v6 == 6) {
                        v0.drawPathScreenTicks(v1, v13 - 0f, v12_1 - 0f, v4, v5);
                    }

                    v1.drawPath(v0.mPath, v0.mFillPaint);
                }
                else {
                }
            }

            float[] v2_1 = v0.mPoints;
            if(v2_1.length > 1) {
                v1.drawCircle(v2_1[0], v2_1[1], 8f, v0.mPaintKeyframes);
                v1.drawCircle(v0.mPoints[v0.mPoints.length - v11], v0.mPoints[v0.mPoints.length - 1], 8f, v0.mPaintKeyframes);
            }
        }

        private void drawTranslation(Canvas arg7, float arg8, float arg9, float arg10, float arg11) {
            arg7.drawRect(arg8, arg9, arg10, arg11, this.mPaintGraph);
            arg7.drawLine(arg8, arg9, arg10, arg11, this.mPaintGraph);
        }

        void getTextBounds(String arg3, Paint arg4) {
            arg4.getTextBounds(arg3, 0, arg3.length(), this.mBounds);
        }
    }

    class Model {
        ConstraintSet mEnd;
        int mEndId;
        ConstraintWidgetContainer mLayoutEnd;
        ConstraintWidgetContainer mLayoutStart;
        ConstraintSet mStart;
        int mStartId;

        Model(MotionLayout arg1) {
            MotionLayout.this = arg1;
            super();
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mStart = null;
            this.mEnd = null;
        }

        public void build() {
            ConstraintWidget v4;
            int v0 = MotionLayout.this.getChildCount();
            MotionLayout.this.mFrameArrayList.clear();
            int v1 = 0;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                View v3 = MotionLayout.this.getChildAt(v2);
                MotionLayout.this.mFrameArrayList.put(v3, new MotionController(v3));
            }

            while(v1 < v0) {
                View v2_1 = MotionLayout.this.getChildAt(v1);
                Object v3_1 = MotionLayout.this.mFrameArrayList.get(v2_1);
                if(v3_1 == null) {
                }
                else {
                    String v5 = ")";
                    String v6 = " (";
                    String v7 = "no widget for  ";
                    String v8 = "MotionLayout";
                    if(this.mStart != null) {
                        v4 = this.getWidget(this.mLayoutStart, v2_1);
                        if(v4 != null) {
                            ((MotionController)v3_1).setStartState(v4, this.mStart);
                        }
                        else if(MotionLayout.this.mDebugPath != 0) {
                            Log.e(v8, Debug.getLocation() + v7 + Debug.getName(v2_1) + v6 + v2_1.getClass().getName() + v5);
                        }
                    }

                    if(this.mEnd == null) {
                        goto label_79;
                    }

                    v4 = this.getWidget(this.mLayoutEnd, v2_1);
                    if(v4 != null) {
                        ((MotionController)v3_1).setEndState(v4, this.mEnd);
                        goto label_79;
                    }

                    if(MotionLayout.this.mDebugPath == 0) {
                        goto label_79;
                    }

                    Log.e(v8, Debug.getLocation() + v7 + Debug.getName(v2_1) + v6 + v2_1.getClass().getName() + v5);
                }

            label_79:
                ++v1;
            }
        }

        void copy(ConstraintWidgetContainer arg4, ConstraintWidgetContainer arg5) {
            Flow v2_2;
            ArrayList v3 = arg4.getChildren();
            HashMap v0 = new HashMap();
            v0.put(arg4, arg5);
            arg5.getChildren().clear();
            arg5.copy(((ConstraintWidget)arg4), v0);
            Iterator v4 = v3.iterator();
            while(v4.hasNext()) {
                Object v1 = v4.next();
                if((v1 instanceof Barrier)) {
                    Barrier v2 = new Barrier();
                }
                else if((v1 instanceof Guideline)) {
                    Guideline v2_1 = new Guideline();
                }
                else if((v1 instanceof Flow)) {
                    v2_2 = new Flow();
                }
                else if((v1 instanceof Helper)) {
                    HelperWidget v2_3 = new HelperWidget();
                }
                else {
                    ConstraintWidget v2_4 = new ConstraintWidget();
                }

                arg5.add(((ConstraintWidget)v2_2));
                v0.put(v1, v2_2);
            }

            Iterator v3_1 = v3.iterator();
            while(v3_1.hasNext()) {
                Object v4_1 = v3_1.next();
                v0.get(v4_1).copy(((ConstraintWidget)v4_1), v0);
            }
        }

        private void debugLayout(String arg10, ConstraintWidgetContainer arg11) {
            String v0 = " ";
            String v9 = arg10 + v0 + Debug.getName(arg11.getCompanionWidget());
            String v1 = "MotionLayout";
            Log.v(v1, v9 + "  ========= " + arg11);
            int v10 = arg11.getChildren().size();
            int v2;
            for(v2 = 0; v2 < v10; ++v2) {
                String v3 = v9 + "[" + v2 + "] ";
                Object v4 = arg11.getChildren().get(v2);
                String v6 = "_";
                String v5 = ((ConstraintWidget)v4).mTop.mTarget != null ? "T" : v6;
                StringBuilder v5_1 = new StringBuilder().append(v5);
                String v7 = ((ConstraintWidget)v4).mBottom.mTarget != null ? "B" : v6;
                v5_1 = new StringBuilder().append(v5_1.append(v7).toString());
                v7 = ((ConstraintWidget)v4).mLeft.mTarget != null ? "L" : v6;
                v5_1 = new StringBuilder().append(v5_1.append(v7).toString());
                if(((ConstraintWidget)v4).mRight.mTarget != null) {
                    v6 = "R";
                }

                v5 = v5_1.append(v6).toString();
                Object v6_1 = ((ConstraintWidget)v4).getCompanionWidget();
                v7 = Debug.getName(((View)v6_1));
                if((v6_1 instanceof TextView)) {
                    v7 = v7 + "(" + ((TextView)v6_1).getText() + ")";
                }

                Log.v(v1, v3 + "  " + v7 + v0 + v4 + v0 + v5);
            }

            Log.v(v1, v9 + " done. ");
        }

        private void debugLayoutParam(String arg4, LayoutParams arg5) {
            int v0 = -1;
            String v3 = arg5.startToStart != v0 ? "SS" : "__";
            StringBuilder v3_1 = new StringBuilder().append(" ".concat(v3));
            String v2 = "|__";
            String v1 = arg5.startToEnd != v0 ? "|SE" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            v1 = arg5.endToStart != v0 ? "|ES" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            v1 = arg5.endToEnd != v0 ? "|EE" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            v1 = arg5.leftToLeft != v0 ? "|LL" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            v1 = arg5.leftToRight != v0 ? "|LR" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            v1 = arg5.rightToLeft != v0 ? "|RL" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            v1 = arg5.rightToRight != v0 ? "|RR" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            v1 = arg5.topToTop != v0 ? "|TT" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            v1 = arg5.topToBottom != v0 ? "|TB" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            v1 = arg5.bottomToTop != v0 ? "|BT" : v2;
            v3_1 = new StringBuilder().append(v3_1.append(v1).toString());
            if(arg5.bottomToBottom != v0) {
                v2 = "|BB";
            }

            Log.v("MotionLayout", arg4 + v3_1.append(v2).toString());
        }

        private void debugWidget(String arg6, ConstraintWidget arg7) {
            String v0;
            StringBuilder v5 = new StringBuilder(" ");
            String v1 = "T";
            String v2 = "B";
            String v3 = "__";
            if(arg7.mTop.mTarget != null) {
                v0 = arg7.mTop.mTarget.mType == Type.TOP ? v1 : v2;
                v0 = v1.concat(v0);
            }
            else {
                v0 = v3;
            }

            v5 = new StringBuilder().append(v5.append(v0).toString());
            if(arg7.mBottom.mTarget != null) {
                if(arg7.mBottom.mTarget.mType == Type.TOP) {
                }
                else {
                    v1 = v2;
                }

                v0 = v2.concat(v1);
            }
            else {
                v0 = v3;
            }

            v5 = new StringBuilder().append(v5.append(v0).toString());
            v1 = "L";
            v2 = "R";
            if(arg7.mLeft.mTarget != null) {
                v0 = arg7.mLeft.mTarget.mType == Type.LEFT ? v1 : v2;
                v0 = v1.concat(v0);
            }
            else {
                v0 = v3;
            }

            v5 = new StringBuilder().append(v5.append(v0).toString());
            if(arg7.mRight.mTarget != null) {
                if(arg7.mRight.mTarget.mType == Type.LEFT) {
                }
                else {
                    v1 = v2;
                }

                v3 = v2.concat(v1);
            }

            Log.v("MotionLayout", arg6 + v5.append(v3).toString() + " ---  " + arg7);
        }

        ConstraintWidget getWidget(ConstraintWidgetContainer arg4, View arg5) {
            if(arg4.getCompanionWidget() == arg5) {
                return arg4;
            }

            ArrayList v3 = arg4.getChildren();
            int v4 = v3.size();
            int v0;
            for(v0 = 0; v0 < v4; ++v0) {
                Object v1 = v3.get(v0);
                if(((ConstraintWidget)v1).getCompanionWidget() == arg5) {
                    return ((ConstraintWidget)v1);
                }
            }

            return null;
        }

        void initFrom(ConstraintWidgetContainer arg5, ConstraintSet arg6, ConstraintSet arg7) {
            this.mStart = arg6;
            this.mEnd = arg7;
            this.mLayoutStart = new ConstraintWidgetContainer();
            this.mLayoutEnd = new ConstraintWidgetContainer();
            this.mLayoutStart.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.mLayoutEnd.setMeasurer(MotionLayout.this.mLayoutWidget.getMeasurer());
            this.mLayoutStart.removeAllChildren();
            this.mLayoutEnd.removeAllChildren();
            this.copy(MotionLayout.this.mLayoutWidget, this.mLayoutStart);
            this.copy(MotionLayout.this.mLayoutWidget, this.mLayoutEnd);
            if((((double)MotionLayout.this.mTransitionLastPosition)) > 0.5) {
                if(arg6 != null) {
                    this.setupConstraintWidget(this.mLayoutStart, arg6);
                }

                this.setupConstraintWidget(this.mLayoutEnd, arg7);
            }
            else {
                this.setupConstraintWidget(this.mLayoutEnd, arg7);
                if(arg6 == null) {
                    goto label_46;
                }

                this.setupConstraintWidget(this.mLayoutStart, arg6);
            }

        label_46:
            this.mLayoutStart.setRtl(MotionLayout.this.isRtl());
            this.mLayoutStart.updateHierarchy();
            this.mLayoutEnd.setRtl(MotionLayout.this.isRtl());
            this.mLayoutEnd.updateHierarchy();
            ViewGroup$LayoutParams v5 = MotionLayout.this.getLayoutParams();
            if(v5 != null) {
                int v7 = -2;
                if(v5.width == v7) {
                    this.mLayoutStart.setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                    this.mLayoutEnd.setHorizontalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                }

                if(v5.height != v7) {
                    return;
                }

                this.mLayoutStart.setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
                this.mLayoutEnd.setVerticalDimensionBehaviour(DimensionBehaviour.WRAP_CONTENT);
            }
        }

        public boolean isNotConfiguredWith(int arg2, int arg3) {
            if(arg2 == this.mStartId) {
                if(arg3 != this.mEndId) {
                }
                else {
                    return 0;
                }
            }

            return 1;
        }

        public void measure(int arg14, int arg15) {
            int v3;
            int v0 = View$MeasureSpec.getMode(arg14);
            int v1 = View$MeasureSpec.getMode(arg15);
            MotionLayout.this.mWidthMeasureMode = v0;
            MotionLayout.this.mHeightMeasureMode = v1;
            int v2 = MotionLayout.this.getOptimizationLevel();
            if(MotionLayout.this.mCurrentState == MotionLayout.this.getStartState()) {
                MotionLayout.this.resolveSystem(this.mLayoutEnd, v2, arg14, arg15);
                if(this.mStart != null) {
                    MotionLayout.this.resolveSystem(this.mLayoutStart, v2, arg14, arg15);
                }
            }
            else {
                if(this.mStart != null) {
                    MotionLayout.this.resolveSystem(this.mLayoutStart, v2, arg14, arg15);
                }

                MotionLayout.this.resolveSystem(this.mLayoutEnd, v2, arg14, arg15);
            }

            if((MotionLayout.this.getParent() instanceof MotionLayout)) {
                v3 = 0x40000000;
                if(v0 != v3) {
                    goto label_40;
                }
                else if(v1 == v3) {
                }
                else {
                    goto label_40;
                }
            }
            else {
            label_40:
                MotionLayout.this.mWidthMeasureMode = v0;
                MotionLayout.this.mHeightMeasureMode = v1;
                if(MotionLayout.this.mCurrentState == MotionLayout.this.getStartState()) {
                    MotionLayout.this.resolveSystem(this.mLayoutEnd, v2, arg14, arg15);
                    if(this.mStart != null) {
                        MotionLayout.this.resolveSystem(this.mLayoutStart, v2, arg14, arg15);
                    }
                }
                else {
                    if(this.mStart != null) {
                        MotionLayout.this.resolveSystem(this.mLayoutStart, v2, arg14, arg15);
                    }

                    MotionLayout.this.resolveSystem(this.mLayoutEnd, v2, arg14, arg15);
                }

                MotionLayout.this.mStartWrapWidth = this.mLayoutStart.getWidth();
                MotionLayout.this.mStartWrapHeight = this.mLayoutStart.getHeight();
                MotionLayout.this.mEndWrapWidth = this.mLayoutEnd.getWidth();
                MotionLayout.this.mEndWrapHeight = this.mLayoutEnd.getHeight();
                MotionLayout v0_1 = MotionLayout.this;
                boolean v1_1 = v0_1.mStartWrapWidth != MotionLayout.this.mEndWrapWidth || MotionLayout.this.mStartWrapHeight != MotionLayout.this.mEndWrapHeight ? true : false;
                v0_1.mMeasureDuringTransition = v1_1;
            }

            v0 = MotionLayout.this.mStartWrapWidth;
            v1 = MotionLayout.this.mStartWrapHeight;
            v3 = 0x80000000;
            if(MotionLayout.this.mWidthMeasureMode == v3 || MotionLayout.this.mWidthMeasureMode == 0) {
                v0 = ((int)((((float)MotionLayout.this.mStartWrapWidth)) + MotionLayout.this.mPostInterpolationPosition * (((float)(MotionLayout.this.mEndWrapWidth - MotionLayout.this.mStartWrapWidth)))));
            }

            int v9 = v0;
            if(MotionLayout.this.mHeightMeasureMode == v3 || MotionLayout.this.mHeightMeasureMode == 0) {
                v1 = ((int)((((float)MotionLayout.this.mStartWrapHeight)) + MotionLayout.this.mPostInterpolationPosition * (((float)(MotionLayout.this.mEndWrapHeight - MotionLayout.this.mStartWrapHeight)))));
            }

            int v10 = v1;
            boolean v11 = (this.mLayoutStart.isWidthMeasuredTooSmall()) || (this.mLayoutEnd.isWidthMeasuredTooSmall()) ? true : false;
            boolean v12 = (this.mLayoutStart.isHeightMeasuredTooSmall()) || (this.mLayoutEnd.isHeightMeasuredTooSmall()) ? true : false;
            MotionLayout.this.resolveMeasuredDimension(arg14, arg15, v9, v10, v11, v12);
        }

        public void reEvaluateState() {
            this.measure(MotionLayout.this.mLastWidthMeasureSpec, MotionLayout.this.mLastHeightMeasureSpec);
            MotionLayout.this.setupMotionViews();
        }

        public void setMeasuredId(int arg1, int arg2) {
            this.mStartId = arg1;
            this.mEndId = arg2;
        }

        private void setupConstraintWidget(ConstraintWidgetContainer arg8, ConstraintSet arg9) {
            SparseArray v5 = new SparseArray();
            androidx.constraintlayout.widget.Constraints$LayoutParams v4 = new androidx.constraintlayout.widget.Constraints$LayoutParams(-2, -2);
            v5.clear();
            v5.put(0, arg8);
            v5.put(MotionLayout.this.getId(), arg8);
            Iterator v0 = arg8.getChildren().iterator();
            while(v0.hasNext()) {
                Object v1 = v0.next();
                v5.put(((ConstraintWidget)v1).getCompanionWidget().getId(), v1);
            }

            Iterator v6 = arg8.getChildren().iterator();
            while(v6.hasNext()) {
                Object v3 = v6.next();
                Object v2 = ((ConstraintWidget)v3).getCompanionWidget();
                arg9.applyToLayoutParams(((View)v2).getId(), ((LayoutParams)v4));
                ((ConstraintWidget)v3).setWidth(arg9.getWidth(((View)v2).getId()));
                ((ConstraintWidget)v3).setHeight(arg9.getHeight(((View)v2).getId()));
                if((v2 instanceof ConstraintHelper)) {
                    arg9.applyToHelper(v2, ((ConstraintWidget)v3), ((LayoutParams)v4), v5);
                    if((v2 instanceof androidx.constraintlayout.widget.Barrier)) {
                        v2.validateParams();
                    }
                }

                v4.resolveLayoutDirection(MotionLayout.this.getLayoutDirection());
                MotionLayout.this.applyConstraintsFromLayoutParams(false, ((View)v2), ((ConstraintWidget)v3), ((LayoutParams)v4), v5);
                if(arg9.getVisibilityMode(((View)v2).getId()) == 1) {
                    ((ConstraintWidget)v3).setVisibility(((View)v2).getVisibility());
                    continue;
                }

                ((ConstraintWidget)v3).setVisibility(arg9.getVisibility(((View)v2).getId()));
            }

            Iterator v7 = arg8.getChildren().iterator();
            while(v7.hasNext()) {
                Object v9 = v7.next();
                if(!(v9 instanceof VirtualLayout)) {
                    continue;
                }

                ((ConstraintWidget)v9).getCompanionWidget().updatePreLayout(arg8, ((Helper)v9), v5);
                ((VirtualLayout)v9).captureWidgets();
            }
        }
    }

    public interface MotionTracker {
        void addMovement(MotionEvent arg1);

        void clear();

        void computeCurrentVelocity(int arg1);

        void computeCurrentVelocity(int arg1, float arg2);

        float getXVelocity();

        float getXVelocity(int arg1);

        float getYVelocity();

        float getYVelocity(int arg1);

        void recycle();
    }

    class MyTracker implements MotionTracker {
        private static MyTracker me;
        VelocityTracker tracker;

        static {
            MyTracker.me = new MyTracker();
        }

        private MyTracker() {
            super();
        }

        public void addMovement(MotionEvent arg1) {
            VelocityTracker v0 = this.tracker;
            if(v0 != null) {
                v0.addMovement(arg1);
            }
        }

        public void clear() {
            this.tracker.clear();
        }

        public void computeCurrentVelocity(int arg1) {
            this.tracker.computeCurrentVelocity(arg1);
        }

        public void computeCurrentVelocity(int arg1, float arg2) {
            this.tracker.computeCurrentVelocity(arg1, arg2);
        }

        public float getXVelocity() {
            return this.tracker.getXVelocity();
        }

        public float getXVelocity(int arg1) {
            return this.tracker.getXVelocity(arg1);
        }

        public float getYVelocity() {
            return this.tracker.getYVelocity();
        }

        public float getYVelocity(int arg1) {
            return this.getYVelocity(arg1);
        }

        public static MyTracker obtain() {
            MyTracker.me.tracker = VelocityTracker.obtain();
            return MyTracker.me;
        }

        public void recycle() {
            this.tracker.recycle();
            this.tracker = null;
        }
    }

    class StateCache {
        final String KeyEndState;
        final String KeyProgress;
        final String KeyStartState;
        final String KeyVelocity;
        int endState;
        float mProgress;
        float mVelocity;
        int startState;

        StateCache(MotionLayout arg1) {
            MotionLayout.this = arg1;
            super();
            this.mProgress = NaNf;
            this.mVelocity = NaNf;
            this.startState = -1;
            this.endState = -1;
            this.KeyProgress = "motion.progress";
            this.KeyVelocity = "motion.velocity";
            this.KeyStartState = "motion.StartState";
            this.KeyEndState = "motion.EndState";
        }

        void apply() {
            int v0 = this.startState;
            int v1 = -1;
            if(v0 != v1 || this.endState != v1) {
                if(v0 == v1) {
                    MotionLayout.this.transitionToState(this.endState);
                }
                else {
                    int v2 = this.endState;
                    MotionLayout v3 = MotionLayout.this;
                    if(v2 == v1) {
                        v3.setState(v0, v1, v1);
                    }
                    else {
                        v3.setTransition(v0, v2);
                    }
                }

                MotionLayout.this.setState(TransitionState.SETUP);
            }

            if(Float.isNaN(this.mVelocity)) {
                if(Float.isNaN(this.mProgress)) {
                    return;
                }

                MotionLayout.this.setProgress(this.mProgress);
                return;
            }

            MotionLayout.this.setProgress(this.mProgress, this.mVelocity);
            this.mProgress = NaNf;
            this.mVelocity = NaNf;
            this.startState = v1;
            this.endState = v1;
        }

        public Bundle getTransitionState() {
            Bundle v0 = new Bundle();
            v0.putFloat("motion.progress", this.mProgress);
            v0.putFloat("motion.velocity", this.mVelocity);
            v0.putInt("motion.StartState", this.startState);
            v0.putInt("motion.EndState", this.endState);
            return v0;
        }

        public void recordState() {
            this.endState = MotionLayout.this.mEndState;
            this.startState = MotionLayout.this.mBeginState;
            this.mVelocity = MotionLayout.this.getVelocity();
            this.mProgress = MotionLayout.this.getProgress();
        }

        public void setEndState(int arg1) {
            this.endState = arg1;
        }

        public void setProgress(float arg1) {
            this.mProgress = arg1;
        }

        public void setStartState(int arg1) {
            this.startState = arg1;
        }

        public void setTransitionState(Bundle arg2) {
            this.mProgress = arg2.getFloat("motion.progress");
            this.mVelocity = arg2.getFloat("motion.velocity");
            this.startState = arg2.getInt("motion.StartState");
            this.endState = arg2.getInt("motion.EndState");
        }

        public void setVelocity(float arg1) {
            this.mVelocity = arg1;
        }
    }

    public interface TransitionListener {
        void onTransitionChange(MotionLayout arg1, int arg2, int arg3, float arg4);

        void onTransitionCompleted(MotionLayout arg1, int arg2);

        void onTransitionStarted(MotionLayout arg1, int arg2, int arg3);

        void onTransitionTrigger(MotionLayout arg1, int arg2, boolean arg3, float arg4);
    }

    enum TransitionState {
        public static final enum TransitionState FINISHED;
        public static final enum TransitionState MOVING;
        public static final enum TransitionState SETUP;
        public static final enum TransitionState UNDEFINED;

        static {
            TransitionState v0 = new TransitionState("UNDEFINED", 0);
            TransitionState.UNDEFINED = v0;
            TransitionState v1 = new TransitionState("SETUP", 1);
            TransitionState.SETUP = v1;
            TransitionState v2 = new TransitionState("MOVING", 2);
            TransitionState.MOVING = v2;
            TransitionState v3 = new TransitionState("FINISHED", 3);
            TransitionState.FINISHED = v3;
            TransitionState.$VALUES = new TransitionState[]{v0, v1, v2, v3};
        }

        private TransitionState(String arg1, int arg2) {
            super(arg1, arg2);
        }

        public static TransitionState valueOf(String arg1) {
            return Enum.valueOf(TransitionState.class, arg1);
        }

        public static TransitionState[] values() {
            return TransitionState.$VALUES.clone();
        }
    }

    private static final boolean DEBUG = false;
    public static final int DEBUG_SHOW_NONE = 0;
    public static final int DEBUG_SHOW_PATH = 2;
    public static final int DEBUG_SHOW_PROGRESS = 1;
    private static final float EPSILON = 0.00001f;
    public static boolean IS_IN_EDIT_MODE = false;
    static final int MAX_KEY_FRAMES = 50;
    static final String TAG = "MotionLayout";
    public static final int TOUCH_UP_COMPLETE = 0;
    public static final int TOUCH_UP_COMPLETE_TO_END = 2;
    public static final int TOUCH_UP_COMPLETE_TO_START = 1;
    public static final int TOUCH_UP_DECELERATE = 4;
    public static final int TOUCH_UP_DECELERATE_AND_COMPLETE = 5;
    public static final int TOUCH_UP_STOP = 3;
    public static final int VELOCITY_LAYOUT = 1;
    public static final int VELOCITY_POST_LAYOUT = 0;
    public static final int VELOCITY_STATIC_LAYOUT = 3;
    public static final int VELOCITY_STATIC_POST_LAYOUT = 2;
    boolean firstDown;
    private float lastPos;
    private float lastY;
    private long mAnimationStartTime;
    private int mBeginState;
    private RectF mBoundsCheck;
    int mCurrentState;
    int mDebugPath;
    private DecelerateInterpolator mDecelerateLogic;
    private DesignTool mDesignTool;
    DevModeDraw mDevModeDraw;
    private int mEndState;
    int mEndWrapHeight;
    int mEndWrapWidth;
    HashMap mFrameArrayList;
    private int mFrames;
    int mHeightMeasureMode;
    private boolean mInLayout;
    boolean mInTransition;
    boolean mIndirectTransition;
    private boolean mInteractionEnabled;
    Interpolator mInterpolator;
    boolean mIsAnimating;
    private boolean mKeepAnimating;
    private KeyCache mKeyCache;
    private long mLastDrawTime;
    private float mLastFps;
    private int mLastHeightMeasureSpec;
    int mLastLayoutHeight;
    int mLastLayoutWidth;
    float mLastVelocity;
    private int mLastWidthMeasureSpec;
    private float mListenerPosition;
    private int mListenerState;
    protected boolean mMeasureDuringTransition;
    Model mModel;
    private boolean mNeedsFireTransitionCompleted;
    int mOldHeight;
    int mOldWidth;
    private ArrayList mOnHideHelpers;
    private ArrayList mOnShowHelpers;
    float mPostInterpolationPosition;
    private View mRegionView;
    MotionScene mScene;
    float mScrollTargetDT;
    float mScrollTargetDX;
    float mScrollTargetDY;
    long mScrollTargetTime;
    int mStartWrapHeight;
    int mStartWrapWidth;
    private StateCache mStateCache;
    private StopLogic mStopLogic;
    private boolean mTemporalInterpolator;
    ArrayList mTransitionCompleted;
    private float mTransitionDuration;
    float mTransitionGoalPosition;
    private boolean mTransitionInstantly;
    float mTransitionLastPosition;
    private long mTransitionLastTime;
    private TransitionListener mTransitionListener;
    private ArrayList mTransitionListeners;
    float mTransitionPosition;
    TransitionState mTransitionState;
    boolean mUndergoingMotion;
    int mWidthMeasureMode;

    public MotionLayout(Context arg5) {
        super(arg5);
        this.mLastVelocity = 0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1f;
        this.mTransitionPosition = 0f;
        this.mTransitionLastPosition = 0f;
        this.mTransitionGoalPosition = 0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList();
        this.init(null);
    }

    public MotionLayout(Context arg5, AttributeSet arg6) {
        super(arg5, arg6);
        this.mLastVelocity = 0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1f;
        this.mTransitionPosition = 0f;
        this.mTransitionLastPosition = 0f;
        this.mTransitionGoalPosition = 0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList();
        this.init(arg6);
    }

    public MotionLayout(Context arg4, AttributeSet arg5, int arg6) {
        super(arg4, arg5, arg6);
        this.mLastVelocity = 0f;
        this.mBeginState = -1;
        this.mCurrentState = -1;
        this.mEndState = -1;
        this.mLastWidthMeasureSpec = 0;
        this.mLastHeightMeasureSpec = 0;
        this.mInteractionEnabled = true;
        this.mFrameArrayList = new HashMap();
        this.mAnimationStartTime = 0;
        this.mTransitionDuration = 1f;
        this.mTransitionPosition = 0f;
        this.mTransitionLastPosition = 0f;
        this.mTransitionGoalPosition = 0f;
        this.mInTransition = false;
        this.mIndirectTransition = false;
        this.mDebugPath = 0;
        this.mTemporalInterpolator = false;
        this.mStopLogic = new StopLogic();
        this.mDecelerateLogic = new DecelerateInterpolator(this);
        this.firstDown = true;
        this.mUndergoingMotion = false;
        this.mKeepAnimating = false;
        this.mOnShowHelpers = null;
        this.mOnHideHelpers = null;
        this.mTransitionListeners = null;
        this.mFrames = 0;
        this.mLastDrawTime = -1;
        this.mLastFps = 0f;
        this.mListenerState = 0;
        this.mListenerPosition = 0f;
        this.mIsAnimating = false;
        this.mMeasureDuringTransition = false;
        this.mKeyCache = new KeyCache();
        this.mInLayout = false;
        this.mTransitionState = TransitionState.UNDEFINED;
        this.mModel = new Model(this);
        this.mNeedsFireTransitionCompleted = false;
        this.mBoundsCheck = new RectF();
        this.mRegionView = null;
        this.mTransitionCompleted = new ArrayList();
        this.init(arg5);
    }

    static int access$000(MotionLayout arg0) {
        return arg0.mEndState;
    }

    static int access$100(MotionLayout arg0) {
        return arg0.mBeginState;
    }

    static int access$1000(MotionLayout arg0) {
        return arg0.mLastHeightMeasureSpec;
    }

    static void access$1100(MotionLayout arg0) {
        arg0.setupMotionViews();
    }

    static void access$1200(MotionLayout arg0, ConstraintWidgetContainer arg1, int arg2, int arg3, int arg4) {
        arg0.resolveSystem(arg1, arg2, arg3, arg4);
    }

    static void access$1300(MotionLayout arg0, ConstraintWidgetContainer arg1, int arg2, int arg3, int arg4) {
        arg0.resolveSystem(arg1, arg2, arg3, arg4);
    }

    static void access$1400(MotionLayout arg0, ConstraintWidgetContainer arg1, int arg2, int arg3, int arg4) {
        arg0.resolveSystem(arg1, arg2, arg3, arg4);
    }

    static void access$1500(MotionLayout arg0, ConstraintWidgetContainer arg1, int arg2, int arg3, int arg4) {
        arg0.resolveSystem(arg1, arg2, arg3, arg4);
    }

    static void access$1600(MotionLayout arg0, ConstraintWidgetContainer arg1, int arg2, int arg3, int arg4) {
        arg0.resolveSystem(arg1, arg2, arg3, arg4);
    }

    static void access$1700(MotionLayout arg0, ConstraintWidgetContainer arg1, int arg2, int arg3, int arg4) {
        arg0.resolveSystem(arg1, arg2, arg3, arg4);
    }

    static void access$1800(MotionLayout arg0, ConstraintWidgetContainer arg1, int arg2, int arg3, int arg4) {
        arg0.resolveSystem(arg1, arg2, arg3, arg4);
    }

    static void access$1900(MotionLayout arg0, ConstraintWidgetContainer arg1, int arg2, int arg3, int arg4) {
        arg0.resolveSystem(arg1, arg2, arg3, arg4);
    }

    static ConstraintWidgetContainer access$200(MotionLayout arg0) {
        return arg0.mLayoutWidget;
    }

    static void access$2000(MotionLayout arg0, int arg1, int arg2, int arg3, int arg4, boolean arg5, boolean arg6) {
        arg0.resolveMeasuredDimension(arg1, arg2, arg3, arg4, arg5, arg6);
    }

    static ConstraintWidgetContainer access$300(MotionLayout arg0) {
        return arg0.mLayoutWidget;
    }

    static ConstraintWidgetContainer access$400(MotionLayout arg0) {
        return arg0.mLayoutWidget;
    }

    static ConstraintWidgetContainer access$500(MotionLayout arg0) {
        return arg0.mLayoutWidget;
    }

    static boolean access$600(MotionLayout arg0) {
        return arg0.isRtl();
    }

    static boolean access$700(MotionLayout arg0) {
        return arg0.isRtl();
    }

    static void access$800(MotionLayout arg0, boolean arg1, View arg2, ConstraintWidget arg3, LayoutParams arg4, SparseArray arg5) {
        arg0.applyConstraintsFromLayoutParams(arg1, arg2, arg3, arg4, arg5);
    }

    static int access$900(MotionLayout arg0) {
        return arg0.mLastWidthMeasureSpec;
    }

    public void addTransitionListener(TransitionListener arg2) {
        ArrayList v0 = this.mTransitionListeners;
        if(v0 == null) {
            v0 = new ArrayList();
            this.mTransitionListeners = v0;
        }

        v0.add(arg2);
    }

    void animateTo(float arg5) {
        float v1;
        MotionScene v0 = this.mScene;
        if(v0 == null) {
        }
        else {
            v1 = this.mTransitionLastPosition;
            float v2 = this.mTransitionPosition;
            if(v1 != v2 && (this.mTransitionInstantly)) {
                this.mTransitionLastPosition = v2;
                v1 = v2;
            }

            if(v1 != arg5) {
                goto label_12;
            }
        }

        return;
    label_12:
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = arg5;
        this.mTransitionDuration = (((float)v0.getDuration())) / 1000f;
        this.setProgress(this.mTransitionGoalPosition);
        this.mInterpolator = this.mScene.getInterpolator();
        this.mTransitionInstantly = false;
        this.mAnimationStartTime = this.getNanoTime();
        this.mInTransition = true;
        this.mTransitionPosition = v1;
        this.mTransitionLastPosition = v1;
        this.invalidate();
    }

    private void checkStructure() {
        MotionScene v0 = this.mScene;
        String v1 = "MotionLayout";
        if(v0 == null) {
            Log.e(v1, "CHECK: motion scene not set! set \"app:layoutDescription=\"@xml/file\"");
            return;
        }

        this.checkStructure(v0.getStartId(), this.mScene.getConstraintSet(this.mScene.getStartId()));
        SparseIntArray v0_1 = new SparseIntArray();
        SparseIntArray v2 = new SparseIntArray();
        Iterator v3 = this.mScene.getDefinedTransitions().iterator();
        while(v3.hasNext()) {
            Object v4 = v3.next();
            if(v4 == this.mScene.mCurrentTransition) {
                Log.v(v1, "CHECK: CURRENT");
            }

            this.checkStructure(((Transition)v4));
            int v5 = ((Transition)v4).getStartConstraintSetId();
            int v4_1 = ((Transition)v4).getEndConstraintSetId();
            String v6 = Debug.getName(this.getContext(), v5);
            String v7 = Debug.getName(this.getContext(), v4_1);
            String v9 = "->";
            if(v0_1.get(v5) == v4_1) {
                Log.e(v1, "CHECK: two transitions with the same start and end " + v6 + v9 + v7);
            }

            if(v2.get(v4_1) == v5) {
                Log.e(v1, "CHECK: you can\'t have reverse transitions" + v6 + v9 + v7);
            }

            v0_1.put(v5, v4_1);
            v2.put(v4_1, v5);
            if(this.mScene.getConstraintSet(v5) == null) {
                Log.e(v1, " no such constraintSetStart " + v6);
            }

            if(this.mScene.getConstraintSet(v4_1) != null) {
                continue;
            }

            Log.e(v1, " no such constraintSetEnd " + v6);
        }
    }

    private void checkStructure(int arg11, ConstraintSet arg12) {
        String v5;
        String v4;
        String v11 = Debug.getName(this.getContext(), arg11);
        int v0 = this.getChildCount();
        int v1 = 0;
        int v2;
        for(v2 = 0; true; ++v2) {
            int v3 = -1;
            v4 = "CHECK: ";
            v5 = "MotionLayout";
            if(v2 >= v0) {
                break;
            }

            View v6 = this.getChildAt(v2);
            int v7 = v6.getId();
            if(v7 == v3) {
                Log.w(v5, v4 + v11 + " ALL VIEWS SHOULD HAVE ID\'s " + v6.getClass().getName() + " does not!");
            }

            if(arg12.getConstraint(v7) == null) {
                Log.w(v5, v4 + v11 + " NO CONSTRAINTS for " + Debug.getName(v6));
            }
        }

        int[] v0_1 = arg12.getKnownIds();
        while(v1 < v0_1.length) {
            v2 = v0_1[v1];
            String v6_1 = Debug.getName(this.getContext(), v2);
            if(this.findViewById(v0_1[v1]) == null) {
                Log.w(v5, v4 + v11 + " NO View matches id " + v6_1);
            }

            String v8 = ") no LAYOUT_HEIGHT";
            String v9 = "(";
            if(arg12.getHeight(v2) == v3) {
                Log.w(v5, v4 + v11 + v9 + v6_1 + v8);
            }

            if(arg12.getWidth(v2) == v3) {
                Log.w(v5, v4 + v11 + v9 + v6_1 + v8);
            }

            ++v1;
        }
    }

    private void checkStructure(Transition arg3) {
        String v0 = "MotionLayout";
        Log.v(v0, "CHECK: transition = " + arg3.debugString(this.getContext()));
        Log.v(v0, "CHECK: transition.setDuration = " + arg3.getDuration());
        if(arg3.getStartConstraintSetId() == arg3.getEndConstraintSetId()) {
            Log.e(v0, "CHECK: start and end constraint set should not be the same!");
        }
    }

    private void computeCurrentPositions() {
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            View v2 = this.getChildAt(v1);
            Object v3 = this.mFrameArrayList.get(v2);
            if(v3 == null) {
            }
            else {
                ((MotionController)v3).setStartCurrentState(v2);
            }
        }
    }

    private void debugPos() {
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            View v1 = this.getChildAt(v0);
            Log.v("MotionLayout", " " + Debug.getLocation() + " " + Debug.getName(((View)this)) + " " + Debug.getName(this.getContext(), this.mCurrentState) + " " + Debug.getName(v1) + v1.getLeft() + " " + v1.getTop());
        }
    }

    void disableAutoTransition(boolean arg1) {
        MotionScene v0 = this.mScene;
        if(v0 == null) {
            return;
        }

        v0.disableAutoTransition(arg1);
    }

    protected void dispatchDraw(Canvas arg10) {
        this.evaluate(false);
        super.dispatchDraw(arg10);
        if(this.mScene == null) {
        }
        else {
            if((this.mDebugPath & 1) == 1 && !this.isInEditMode()) {
                ++this.mFrames;
                long v3 = this.getNanoTime();
                long v5 = this.mLastDrawTime;
                if(v5 != -1) {
                    v5 = v3 - v5;
                    if(v5 > 200000000) {
                        this.mLastFps = (((float)(((int)((((float)this.mFrames)) / ((((float)v5)) * 1.000000E-09f) * 100f))))) / 100f;
                        this.mFrames = 0;
                        this.mLastDrawTime = v3;
                    }
                }
                else {
                    this.mLastDrawTime = v3;
                }

                Paint v0 = new Paint();
                v0.setTextSize(42f);
                float v3_1 = 10f;
                StringBuilder v1 = new StringBuilder().append(this.mLastFps + " fps " + Debug.getState(this, this.mBeginState) + " -> ").append(Debug.getState(this, this.mEndState)).append(" (progress: ").append((((float)(((int)(this.getProgress() * 1000f))))) / v3_1).append(" ) state=");
                int v4 = this.mCurrentState;
                String v4_1 = v4 == -1 ? "undefined" : Debug.getState(this, v4);
                String v1_1 = v1.append(v4_1).toString();
                v0.setColor(0xFF000000);
                arg10.drawText(v1_1, 11f, ((float)(this.getHeight() - 29)), v0);
                v0.setColor(0xFF880088);
                arg10.drawText(v1_1, v3_1, ((float)(this.getHeight() - 30)), v0);
            }

            if(this.mDebugPath <= 1) {
                return;
            }

            DevModeDraw v0_1 = this.mDevModeDraw;
            if(v0_1 == null) {
                v0_1 = new DevModeDraw(this);
                this.mDevModeDraw = v0_1;
            }

            v0_1.draw(arg10, this.mFrameArrayList, this.mScene.getDuration(), this.mDebugPath);
        }
    }

    public void enableTransition(int arg3, boolean arg4) {
        Object v0;
        Transition v3 = this.getTransition(arg3);
        if(arg4) {
            v3.setEnable(true);
            return;
        }

        if(v3 == this.mScene.mCurrentTransition) {
            Iterator v4 = this.mScene.getTransitionsWithState(this.mCurrentState).iterator();
            do {
                if(v4.hasNext()) {
                    v0 = v4.next();
                    if(!((Transition)v0).isEnabled()) {
                        continue;
                    }

                    break;
                }

                goto label_19;
            }
            while(true);

            this.mScene.mCurrentTransition = ((Transition)v0);
        }

    label_19:
        v3.setEnable(false);
    }

    void evaluate(boolean arg21) {
        int v2;
        int v1_1;
        Interpolator v8_1;
        float v3_1;
        int v14_1;
        float v14;
        float v10;
        MotionLayout v0 = this;
        if(v0.mTransitionLastTime == -1) {
            v0.mTransitionLastTime = v0.getNanoTime();
        }

        float v1 = v0.mTransitionLastPosition;
        int v4 = -1;
        float v5 = 1f;
        if(Float.compare(v1, 0f) > 0 && v1 < v5) {
            v0.mCurrentState = v4;
        }

        int v6 = 1;
        int v7 = 0;
        if(v0.mKeepAnimating) {
        label_23:
            v1 = Math.signum(v0.mTransitionGoalPosition - v1);
            long v8 = v0.getNanoTime();
            Interpolator v3 = v0.mInterpolator;
            float v11 = 1.000000E-09f;
            if(!(v3 instanceof MotionInterpolator)) {
                v10 = (((float)(v8 - v0.mTransitionLastTime))) * v1 * v11 / v0.mTransitionDuration;
                v0.mLastVelocity = v10;
            }
            else {
                v10 = 0f;
            }

            float v12 = v0.mTransitionLastPosition + v10;
            if(v0.mTransitionInstantly) {
                v12 = v0.mTransitionGoalPosition;
            }

            int v13 = Float.compare(v1, 0f);
            if(v13 > 0) {
                v14 = v0.mTransitionGoalPosition;
                if(v12 < v14) {
                    goto label_53;
                }
                else {
                    goto label_51;
                }
            }
            else {
            label_53:
                if(v1 <= 0f) {
                    v14 = v0.mTransitionGoalPosition;
                    if(v12 <= v14) {
                    label_51:
                        v12 = v14;
                        v0.mInTransition = false;
                        v14_1 = 1;
                        goto label_61;
                    }
                }

                v14_1 = 0;
            }

        label_61:
            v0.mTransitionLastPosition = v12;
            v0.mTransitionPosition = v12;
            v0.mTransitionLastTime = v8;
            float v15 = 0.00001f;
            if(v3 != null && v14_1 == 0) {
                if(v0.mTemporalInterpolator) {
                    v3_1 = v3.getInterpolation((((float)(v8 - v0.mAnimationStartTime))) * v11);
                    v0.mTransitionLastPosition = v3_1;
                    v0.mTransitionLastTime = v8;
                    v8_1 = v0.mInterpolator;
                    if((v8_1 instanceof MotionInterpolator)) {
                        float v8_2 = ((MotionInterpolator)v8_1).getVelocity();
                        v0.mLastVelocity = v8_2;
                        if(Math.abs(v8_2) * v0.mTransitionDuration <= v15) {
                            v0.mInTransition = false;
                        }

                        if(v8_2 > 0f && v3_1 >= v5) {
                            v0.mTransitionLastPosition = v5;
                            v0.mInTransition = false;
                            v3_1 = v5;
                        }

                        if(v8_2 >= 0f) {
                            goto label_111;
                        }

                        if(v3_1 > 0f) {
                            goto label_111;
                        }

                        v0.mTransitionLastPosition = 0f;
                        v0.mInTransition = false;
                        v12 = 0f;
                        goto label_112;
                    }
                }
                else {
                    v3_1 = v3.getInterpolation(v12);
                    v8_1 = v0.mInterpolator;
                    if((v8_1 instanceof MotionInterpolator)) {
                        v0.mLastVelocity = ((MotionInterpolator)v8_1).getVelocity();
                        goto label_111;
                    }

                    v0.mLastVelocity = (v8_1.getInterpolation(v12 + v10) - v3_1) * v1 / v10;
                }

            label_111:
                v12 = v3_1;
            }

        label_112:
            if(Math.abs(v0.mLastVelocity) > v15) {
                v0.setState(TransitionState.MOVING);
            }

            if(v13 > 0) {
                v3_1 = v0.mTransitionGoalPosition;
                if(v12 < v3_1) {
                    goto label_123;
                }
                else {
                    goto label_121;
                }
            }
            else {
            label_123:
                if(v1 <= 0f) {
                    v3_1 = v0.mTransitionGoalPosition;
                    if(v12 <= v3_1) {
                    label_121:
                        v12 = v3_1;
                        v0.mInTransition = false;
                    }
                }
            }

            int v3_2 = Float.compare(v12, v5);
            if(v3_2 >= 0 || v12 <= 0f) {
                v0.mInTransition = false;
                v0.setState(TransitionState.FINISHED);
            }

            int v8_3 = v0.getChildCount();
            v0.mKeepAnimating = false;
            long v17 = v0.getNanoTime();
            v0.mPostInterpolationPosition = v12;
            int v9;
            for(v9 = 0; v9 < v8_3; ++v9) {
                View v15_1 = v0.getChildAt(v9);
                Object v14_2 = v0.mFrameArrayList.get(v15_1);
                if(v14_2 != null) {
                    v0.mKeepAnimating |= ((MotionController)v14_2).interpolate(v15_1, v12, v17, v0.mKeyCache);
                }
            }

            if(v13 <= 0 || v12 < v0.mTransitionGoalPosition) {
                if(v1 <= 0f && v12 <= v0.mTransitionGoalPosition) {
                label_160:
                    v8_3 = 1;
                    goto label_163;
                }

                v8_3 = 0;
            }
            else {
                goto label_160;
            }

        label_163:
            if(!v0.mKeepAnimating && !v0.mInTransition && v8_3 != 0) {
                v0.setState(TransitionState.FINISHED);
            }

            if(v0.mMeasureDuringTransition) {
                v0.requestLayout();
            }

            v0.mKeepAnimating |= v8_3 ^ 1;
            if(v12 <= 0f) {
                v8_3 = v0.mBeginState;
                if(v8_3 != v4 && v0.mCurrentState != v8_3) {
                    v0.mCurrentState = v8_3;
                    v0.mScene.getConstraintSet(v8_3).applyCustomAttributes(((ConstraintLayout)v0));
                    v0.setState(TransitionState.FINISHED);
                    v7 = 1;
                }
            }

            if((((double)v12)) >= 1) {
                v4 = v0.mCurrentState;
                v8_3 = v0.mEndState;
                if(v4 != v8_3) {
                    v0.mCurrentState = v8_3;
                    v0.mScene.getConstraintSet(v8_3).applyCustomAttributes(((ConstraintLayout)v0));
                    v0.setState(TransitionState.FINISHED);
                    v7 = 1;
                }
            }

            if((v0.mKeepAnimating) || (v0.mInTransition)) {
                v0.invalidate();
            }
            else {
                if(v13 <= 0 || v3_2 != 0) {
                    if(v1 >= 0f) {
                    }
                    else if(v12 == 0f) {
                        goto label_211;
                    }

                    goto label_215;
                }

            label_211:
                v0.setState(TransitionState.FINISHED);
            }

        label_215:
            if((v0.mKeepAnimating) || !v0.mInTransition || v13 <= 0 || v3_2 != 0) {
                if(v1 >= 0f) {
                }
                else if(v12 == 0f) {
                    goto label_223;
                }

                goto label_224;
            }

        label_223:
            v0.onNewStateAttachHandlers();
        }
        else if(v0.mInTransition) {
            if(arg21) {
                goto label_23;
            }
            else if(v0.mTransitionGoalPosition != v1) {
                goto label_23;
            }
        }

    label_224:
        v1 = v0.mTransitionLastPosition;
        if(v1 >= v5) {
            v1_1 = v0.mCurrentState;
            v2 = v0.mEndState;
            if(v1_1 != v2) {
            }
            else {
                v6 = v7;
            }

            v0.mCurrentState = v2;
            goto label_232;
        }
        else {
            if(v1 > 0f) {
                goto label_242;
            }

            v1_1 = v0.mCurrentState;
            v2 = v0.mBeginState;
            if(v1_1 != v2) {
            }
            else {
                v6 = v7;
            }

            v0.mCurrentState = v2;
        label_232:
            v7 = v6;
        }

    label_242:
        v0.mNeedsFireTransitionCompleted |= v7;
        if(v7 != 0 && !v0.mInLayout) {
            v0.requestLayout();
        }

        v0.mTransitionPosition = v0.mTransitionLastPosition;
    }

    private void evaluateLayout() {
        int v9_1;
        float v9;
        float v0 = Math.signum(this.mTransitionGoalPosition - this.mTransitionLastPosition);
        long v1 = this.getNanoTime();
        Interpolator v3 = this.mInterpolator;
        float v5 = 1.000000E-09f;
        float v4 = !(v3 instanceof StopLogic) ? (((float)(v1 - this.mTransitionLastTime))) * v0 * v5 / this.mTransitionDuration : 0f;
        float v7 = this.mTransitionLastPosition + v4;
        if(this.mTransitionInstantly) {
            v7 = this.mTransitionGoalPosition;
        }

        int v4_1 = Float.compare(v0, 0f);
        int v8 = 0;
        if(v4_1 > 0) {
            v9 = this.mTransitionGoalPosition;
            if(v7 < v9) {
                goto label_32;
            }
            else {
                goto label_30;
            }
        }
        else {
        label_32:
            if(v0 <= 0f) {
                v9 = this.mTransitionGoalPosition;
                if(v7 <= v9) {
                label_30:
                    v7 = v9;
                    v9_1 = 1;
                    goto label_39;
                }
            }

            v9_1 = 0;
        }

    label_39:
        if(v3 != null && v9_1 == 0) {
            v7 = this.mTemporalInterpolator ? v3.getInterpolation((((float)(v1 - this.mAnimationStartTime))) * v5) : v3.getInterpolation(v7);
        }

        if(v4_1 > 0) {
            float v1_1 = this.mTransitionGoalPosition;
            if(v7 < v1_1) {
                goto label_56;
            }
            else {
                v7 = v1_1;
            }
        }
        else {
        label_56:
            if(v0 <= 0f) {
                v0 = this.mTransitionGoalPosition;
                if(v7 <= v0) {
                    v7 = v0;
                }
            }
        }

        float v2 = v7;
        this.mPostInterpolationPosition = v2;
        int v6 = this.getChildCount();
        long v3_1 = this.getNanoTime();
        while(v8 < v6) {
            View v1_2 = this.getChildAt(v8);
            Object v0_1 = this.mFrameArrayList.get(v1_2);
            if(v0_1 != null) {
                ((MotionController)v0_1).interpolate(v1_2, v2, v3_1, this.mKeyCache);
            }

            ++v8;
        }

        if(this.mMeasureDuringTransition) {
            this.requestLayout();
        }
    }

    private void fireTransitionChange() {
        Iterator v0_2;
        ArrayList v0;
        if(this.mTransitionListener == null) {
            v0 = this.mTransitionListeners;
            if(v0 != null && !v0.isEmpty()) {
                goto label_6;
            }
        }
        else {
        label_6:
            if(this.mListenerPosition != this.mTransitionPosition) {
                int v2 = -1;
                if(this.mListenerState != v2) {
                    TransitionListener v0_1 = this.mTransitionListener;
                    if(v0_1 != null) {
                        v0_1.onTransitionStarted(this, this.mBeginState, this.mEndState);
                    }

                    v0 = this.mTransitionListeners;
                    if(v0 != null) {
                        v0_2 = v0.iterator();
                        while(v0_2.hasNext()) {
                            v0_2.next().onTransitionStarted(this, this.mBeginState, this.mEndState);
                        }
                    }

                    this.mIsAnimating = true;
                }

                this.mListenerState = v2;
                float v0_3 = this.mTransitionPosition;
                this.mListenerPosition = v0_3;
                TransitionListener v2_1 = this.mTransitionListener;
                if(v2_1 != null) {
                    v2_1.onTransitionChange(this, this.mBeginState, this.mEndState, v0_3);
                }

                v0 = this.mTransitionListeners;
                if(v0 != null) {
                    v0_2 = v0.iterator();
                    while(v0_2.hasNext()) {
                        v0_2.next().onTransitionChange(this, this.mBeginState, this.mEndState, this.mTransitionPosition);
                    }
                }

                this.mIsAnimating = true;
            }
        }
    }

    protected void fireTransitionCompleted() {
        if(this.mTransitionListener == null) {
            ArrayList v0 = this.mTransitionListeners;
            if(v0 != null && !v0.isEmpty()) {
                goto label_6;
            }
        }
        else {
        label_6:
            int v1 = -1;
            if(this.mListenerState == v1) {
                this.mListenerState = this.mCurrentState;
                int v0_1 = !this.mTransitionCompleted.isEmpty() ? this.mTransitionCompleted.get(this.mTransitionCompleted.size() - 1).intValue() : v1;
                int v2 = this.mCurrentState;
                if(v0_1 == v2) {
                    goto label_27;
                }

                if(v2 == v1) {
                    goto label_27;
                }

                this.mTransitionCompleted.add(Integer.valueOf(v2));
            }
        }

    label_27:
        this.processTransitionCompleted();
    }

    private void fireTransitionStarted(MotionLayout arg2, int arg3, int arg4) {
        TransitionListener v0 = this.mTransitionListener;
        if(v0 != null) {
            v0.onTransitionStarted(this, arg3, arg4);
        }

        ArrayList v1 = this.mTransitionListeners;
        if(v1 != null) {
            Iterator v1_1 = v1.iterator();
            while(v1_1.hasNext()) {
                v1_1.next().onTransitionStarted(arg2, arg3, arg4);
            }
        }
    }

    public void fireTrigger(int arg3, boolean arg4, float arg5) {
        TransitionListener v0 = this.mTransitionListener;
        if(v0 != null) {
            v0.onTransitionTrigger(this, arg3, arg4, arg5);
        }

        ArrayList v0_1 = this.mTransitionListeners;
        if(v0_1 != null) {
            Iterator v0_2 = v0_1.iterator();
            while(v0_2.hasNext()) {
                v0_2.next().onTransitionTrigger(this, arg3, arg4, arg5);
            }
        }
    }

    void getAnchorDpDt(int arg3, float arg4, float arg5, float arg6, float[] arg7) {
        HashMap v0 = this.mFrameArrayList;
        View v1 = this.getViewById(arg3);
        Object v0_1 = v0.get(v1);
        if(v0_1 != null) {
            ((MotionController)v0_1).getDpDt(arg4, arg5, arg6, arg7);
            float v3 = v1.getY();
            this.lastPos = arg4;
            this.lastY = v3;
            return;
        }

        String v2 = v1 == null ? "" + arg3 : v1.getContext().getResources().getResourceName(arg3);
        Log.w("MotionLayout", "WARNING could not find view id " + v2);
    }

    public ConstraintSet getConstraintSet(int arg1) {
        MotionScene v0 = this.mScene;
        if(v0 == null) {
            return null;
        }

        return v0.getConstraintSet(arg1);
    }

    public int[] getConstraintSetIds() {
        MotionScene v0 = this.mScene;
        if(v0 == null) {
            return null;
        }

        return v0.getConstraintSetIds();
    }

    String getConstraintSetNames(int arg1) {
        MotionScene v0 = this.mScene;
        if(v0 == null) {
            return null;
        }

        return v0.lookUpConstraintName(arg1);
    }

    public int getCurrentState() {
        return this.mCurrentState;
    }

    public void getDebugMode(boolean arg1) {
        int v1 = arg1 ? 2 : 1;
        this.mDebugPath = v1;
        this.invalidate();
    }

    public ArrayList getDefinedTransitions() {
        MotionScene v0 = this.mScene;
        if(v0 == null) {
            return null;
        }

        return v0.getDefinedTransitions();
    }

    public DesignTool getDesignTool() {
        DesignTool v0 = this.mDesignTool;
        if(v0 == null) {
            v0 = new DesignTool(this);
            this.mDesignTool = v0;
        }

        return v0;
    }

    public int getEndState() {
        return this.mEndState;
    }

    protected long getNanoTime() {
        return System.nanoTime();
    }

    public float getProgress() {
        return this.mTransitionLastPosition;
    }

    public int getStartState() {
        return this.mBeginState;
    }

    public float getTargetPosition() {
        return this.mTransitionGoalPosition;
    }

    public Transition getTransition(int arg1) {
        return this.mScene.getTransitionById(arg1);
    }

    public Bundle getTransitionState() {
        StateCache v0 = this.mStateCache;
        if(v0 == null) {
            v0 = new StateCache(this);
            this.mStateCache = v0;
        }

        v0.recordState();
        return this.mStateCache.getTransitionState();
    }

    public long getTransitionTimeMs() {
        MotionScene v0 = this.mScene;
        float v1 = 1000f;
        if(v0 != null) {
            this.mTransitionDuration = (((float)v0.getDuration())) / v1;
        }

        return ((long)(this.mTransitionDuration * v1));
    }

    public float getVelocity() {
        return this.mLastVelocity;
    }

    public void getViewVelocity(View arg9, float arg10, float arg11, float[] arg12, int arg13) {
        float[] v7;
        float v2;
        float v0 = this.mLastVelocity;
        float v1 = this.mTransitionLastPosition;
        if(this.mInterpolator != null) {
            v0 = Math.signum(this.mTransitionGoalPosition - v1);
            v1 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition + 0.00001f);
            v2 = this.mInterpolator.getInterpolation(this.mTransitionLastPosition);
            v0 = v0 * ((v1 - v2) / 0.00001f) / this.mTransitionDuration;
        }
        else {
            v2 = v1;
        }

        Interpolator v1_1 = this.mInterpolator;
        if((v1_1 instanceof MotionInterpolator)) {
            v0 = ((MotionInterpolator)v1_1).getVelocity();
        }

        Object v1_2 = this.mFrameArrayList.get(arg9);
        if((arg13 & 1) == 0) {
            v7 = arg12;
            ((MotionController)v1_2).getPostLayoutDvDp(v2, arg9.getWidth(), arg9.getHeight(), arg10, arg11, v7);
        }
        else {
            v7 = arg12;
            ((MotionController)v1_2).getDpDt(v2, arg10, arg11, v7);
        }

        if(arg13 < 2) {
            v7[0] *= v0;
            v7[1] *= v0;
        }
    }

    private boolean handlesTouchEvent(float arg9, float arg10, View arg11, MotionEvent arg12) {
        if((arg11 instanceof ViewGroup)) {
            View v0 = arg11;
            int v3 = ((ViewGroup)v0).getChildCount();
            int v4 = 0;
            while(v4 < v3) {
                if(this.handlesTouchEvent((((float)arg11.getLeft())) + arg9, (((float)arg11.getTop())) + arg10, ((ViewGroup)v0).getChildAt(v4), arg12)) {
                    return 1;
                }
                else {
                    ++v4;
                    continue;
                }

                break;
            }
        }

        this.mBoundsCheck.set((((float)arg11.getLeft())) + arg9, (((float)arg11.getTop())) + arg10, arg9 + (((float)arg11.getRight())), arg10 + (((float)arg11.getBottom())));
        if(arg12.getAction() == 0) {
            if((this.mBoundsCheck.contains(arg12.getX(), arg12.getY())) && (arg11.onTouchEvent(arg12))) {
                return 1;
            }
        }
        else if(arg11.onTouchEvent(arg12)) {
            return 1;
        }

        return 0;
    }

    private void init(AttributeSet arg10) {
        MotionLayout.IS_IN_EDIT_MODE = this.isInEditMode();
        int v0 = -1;
        if(arg10 != null) {
            TypedArray v10 = this.getContext().obtainStyledAttributes(arg10, styleable.MotionLayout);
            int v1 = v10.getIndexCount();
            boolean v5 = true;
            int v4;
            for(v4 = 0; v4 < v1; ++v4) {
                int v6 = v10.getIndex(v4);
                if(v6 == styleable.MotionLayout_layoutDescription) {
                    this.mScene = new MotionScene(this.getContext(), this, v10.getResourceId(v6, v0));
                }
                else if(v6 == styleable.MotionLayout_currentState) {
                    this.mCurrentState = v10.getResourceId(v6, v0);
                }
                else if(v6 == styleable.MotionLayout_motionProgress) {
                    this.mTransitionGoalPosition = v10.getFloat(v6, 0f);
                    this.mInTransition = true;
                }
                else if(v6 == styleable.MotionLayout_applyMotionScene) {
                    v5 = v10.getBoolean(v6, v5);
                }
                else if(v6 != styleable.MotionLayout_showPaths) {
                    if(v6 != styleable.MotionLayout_motionDebug) {
                        goto label_53;
                    }

                    this.mDebugPath = v10.getInt(v6, 0);
                }
                else if(this.mDebugPath == 0) {
                    v6 = v10.getBoolean(v6, false) ? 2 : 0;
                    this.mDebugPath = v6;
                }

            label_53:
            }

            v10.recycle();
            if(this.mScene == null) {
                Log.e("MotionLayout", "WARNING NO app:layoutDescription tag");
            }

            if(v5) {
                goto label_64;
            }

            this.mScene = null;
        }

    label_64:
        if(this.mDebugPath != 0) {
            this.checkStructure();
        }

        if(this.mCurrentState == v0) {
            MotionScene v10_1 = this.mScene;
            if(v10_1 != null) {
                this.mCurrentState = v10_1.getStartId();
                this.mBeginState = this.mScene.getStartId();
                this.mEndState = this.mScene.getEndId();
            }
        }
    }

    public boolean isAttachedToWindow() {
        return super.isAttachedToWindow();
    }

    public boolean isInteractionEnabled() {
        return this.mInteractionEnabled;
    }

    public void loadLayoutDescription(int arg5) {
        if(arg5 != 0) {
            try {
                this.mScene = new MotionScene(this.getContext(), this, arg5);
                if(this.isAttachedToWindow()) {
                    this.mScene.readFallback(this);
                    this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
                    this.rebuildScene();
                    this.mScene.setRtl(this.isRtl());
                }
            }
            catch(Exception v4) {
                throw new IllegalArgumentException("unable to parse MotionScene file", ((Throwable)v4));
            }

            return;
        }

        this.mScene = null;
    }

    int lookUpConstraintId(String arg1) {
        MotionScene v0 = this.mScene;
        if(v0 == null) {
            return 0;
        }

        return v0.lookUpConstraintId(arg1);
    }

    protected MotionTracker obtainVelocityTracker() {
        return MyTracker.obtain();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MotionScene v0 = this.mScene;
        if(v0 != null) {
            int v1 = this.mCurrentState;
            if(v1 != -1) {
                ConstraintSet v0_1 = v0.getConstraintSet(v1);
                this.mScene.readFallback(this);
                if(v0_1 != null) {
                    v0_1.applyTo(((ConstraintLayout)this));
                }

                this.mBeginState = this.mCurrentState;
            }
        }

        this.onNewStateAttachHandlers();
        StateCache v3 = this.mStateCache;
        if(v3 != null) {
            v3.apply();
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent arg7) {
        MotionScene v0 = this.mScene;
        if(v0 != null) {
            if(!this.mInteractionEnabled) {
            }
            else {
                Transition v0_1 = v0.mCurrentTransition;
                if(v0_1 != null && (v0_1.isEnabled())) {
                    TouchResponse v0_2 = v0_1.getTouchResponse();
                    if(v0_2 != null) {
                        if(arg7.getAction() == 0) {
                            RectF v2 = v0_2.getTouchRegion(((ViewGroup)this), new RectF());
                            if(v2 != null && !v2.contains(arg7.getX(), arg7.getY())) {
                                return 0;
                            }
                        }

                        int v0_3 = v0_2.getTouchRegionId();
                        if(v0_3 == -1) {
                            return 0;
                        }

                        View v2_1 = this.mRegionView;
                        if(v2_1 == null || v2_1.getId() != v0_3) {
                            this.mRegionView = this.findViewById(v0_3);
                        }

                        View v0_4 = this.mRegionView;
                        if(v0_4 == null) {
                            return 0;
                        }

                        this.mBoundsCheck.set(((float)v0_4.getLeft()), ((float)this.mRegionView.getTop()), ((float)this.mRegionView.getRight()), ((float)this.mRegionView.getBottom()));
                        if(!this.mBoundsCheck.contains(arg7.getX(), arg7.getY())) {
                            return 0;
                        }

                        if(this.handlesTouchEvent(0f, 0f, this.mRegionView, arg7)) {
                            return 0;
                        }

                        return this.onTouchEvent(arg7);
                    }
                }
            }
        }

        return 0;
    }

    protected void onLayout(boolean arg4, int arg5, int arg6, int arg7, int arg8) {
        this.mInLayout = true;
        try {
            if(this.mScene != null) {
                goto label_8;
            }

            super.onLayout(arg4, arg5, arg6, arg7, arg8);
        }
        catch(Throwable v0) {
            goto label_24;
        }

        this.mInLayout = false;
        return;
    label_8:
        arg7 -= arg5;
        arg8 -= arg6;
        try {
            if(this.mLastLayoutWidth != arg7 || this.mLastLayoutHeight != arg8) {
                this.rebuildScene();
                this.evaluate(true);
            }

            this.mLastLayoutWidth = arg7;
            this.mLastLayoutHeight = arg8;
            this.mOldWidth = arg7;
            this.mOldHeight = arg8;
        }
        catch(Throwable v0) {
        label_24:
            this.mInLayout = false;
            throw v0;
        }

        this.mInLayout = false;
    }

    protected void onMeasure(int arg7, int arg8) {
        if(this.mScene == null) {
            super.onMeasure(arg7, arg8);
            return;
        }

        int v1 = 0;
        int v0 = this.mLastWidthMeasureSpec != arg7 || this.mLastHeightMeasureSpec != arg8 ? 1 : 0;
        if(this.mNeedsFireTransitionCompleted) {
            this.mNeedsFireTransitionCompleted = false;
            this.onNewStateAttachHandlers();
            this.processTransitionCompleted();
            v0 = 1;
        }

        if(this.mDirtyHierarchy) {
            v0 = 1;
        }

        this.mLastWidthMeasureSpec = arg7;
        this.mLastHeightMeasureSpec = arg8;
        int v3 = this.mScene.getStartId();
        int v4 = this.mScene.getEndId();
        if(v0 == 0 && !this.mModel.isNotConfiguredWith(v3, v4)) {
            goto label_49;
        }
        else if(this.mBeginState != -1) {
            super.onMeasure(arg7, arg8);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(v3), this.mScene.getConstraintSet(v4));
            this.mModel.reEvaluateState();
            this.mModel.setMeasuredId(v3, v4);
        }
        else {
        label_49:
            v1 = 1;
        }

        if((this.mMeasureDuringTransition) || v1 != 0) {
            arg7 = this.getPaddingTop() + this.getPaddingBottom();
            v0 = this.mLayoutWidget.getWidth() + (this.getPaddingLeft() + this.getPaddingRight());
            arg8 = this.mLayoutWidget.getHeight() + arg7;
            arg7 = this.mWidthMeasureMode;
            v1 = 0x80000000;
            if(arg7 == v1 || arg7 == 0) {
                v0 = ((int)((((float)this.mStartWrapWidth)) + this.mPostInterpolationPosition * (((float)(this.mEndWrapWidth - this.mStartWrapWidth)))));
                this.requestLayout();
            }

            arg7 = this.mHeightMeasureMode;
            if(arg7 == v1 || arg7 == 0) {
                arg8 = ((int)((((float)this.mStartWrapHeight)) + this.mPostInterpolationPosition * (((float)(this.mEndWrapHeight - this.mStartWrapHeight)))));
                this.requestLayout();
            }

            this.setMeasuredDimension(v0, arg8);
        }

        this.evaluateLayout();
    }

    public boolean onNestedFling(View arg1, float arg2, float arg3, boolean arg4) {
        return 0;
    }

    public boolean onNestedPreFling(View arg1, float arg2, float arg3) {
        return 0;
    }

    public void onNestedPreScroll(View arg10, int arg11, int arg12, int[] arg13, int arg14) {
        float v4;
        float v14_2;
        MotionScene v14 = this.mScene;
        if(v14 != null) {
            if(v14.mCurrentTransition == null) {
            }
            else if(!this.mScene.mCurrentTransition.isEnabled()) {
            }
            else {
                Transition v14_1 = this.mScene.mCurrentTransition;
                int v0 = -1;
                if(v14_1 != null && (v14_1.isEnabled())) {
                    TouchResponse v1 = v14_1.getTouchResponse();
                    if(v1 != null) {
                        int v1_1 = v1.getTouchRegionId();
                        if(v1_1 != v0 && arg10.getId() != v1_1) {
                            return;
                        }
                    }
                }

                MotionScene v1_2 = this.mScene;
                float v2 = 1f;
                if(v1_2 != null && (v1_2.getMoveWhenScrollAtTop())) {
                    float v1_3 = this.mTransitionPosition;
                    if(v1_3 != v2 && v1_3 != 0f) {
                        goto label_35;
                    }

                    if(!arg10.canScrollVertically(v0)) {
                        goto label_35;
                    }

                    return;
                }

            label_35:
                if(v14_1.getTouchResponse() != null && (this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 1) != 0) {
                    v14_2 = this.mScene.getProgressDirection(((float)arg11), ((float)arg12));
                    v4 = this.mTransitionLastPosition;
                    if(v4 > 0f || v14_2 >= 0f) {
                        if(v4 < v2) {
                        }
                        else if(v14_2 > 0f) {
                            goto label_54;
                        }

                        goto label_59;
                    }

                label_54:
                    arg10.setNestedScrollingEnabled(false);
                    arg10.post(new Runnable(arg10) {
                        public void run() {
                            this.val$target.setNestedScrollingEnabled(true);
                        }
                    });
                    return;
                }

            label_59:
                float v10 = this.mTransitionPosition;
                long v2_1 = this.getNanoTime();
                v14_2 = ((float)arg11);
                this.mScrollTargetDX = v14_2;
                v4 = ((float)arg12);
                this.mScrollTargetDY = v4;
                this.mScrollTargetDT = ((float)((((double)(v2_1 - this.mScrollTargetTime))) * 1.000000E-09));
                this.mScrollTargetTime = v2_1;
                this.mScene.processScrollMove(v14_2, v4);
                if(v10 != this.mTransitionPosition) {
                    arg13[0] = arg11;
                    arg13[1] = arg12;
                }

                this.evaluate(false);
                if(arg13[0] == 0 && arg13[1] == 0) {
                    return;
                }

                this.mUndergoingMotion = true;
            }
        }
    }

    public void onNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6) {
    }

    public void onNestedScroll(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int[] arg7) {
        if((this.mUndergoingMotion) || arg2 != 0 || arg3 != 0) {
            arg7[0] += arg4;
            arg7[1] += arg5;
        }

        this.mUndergoingMotion = false;
    }

    public void onNestedScrollAccepted(View arg1, View arg2, int arg3, int arg4) {
    }

    private void onNewStateAttachHandlers() {
        MotionScene v0 = this.mScene;
        if(v0 == null) {
        }
        else if(v0.autoTransition(this, this.mCurrentState)) {
            this.requestLayout();
            return;
        }
        else {
            int v0_1 = this.mCurrentState;
            if(v0_1 != -1) {
                this.mScene.addOnClickListeners(this, v0_1);
            }

            if(!this.mScene.supportTouch()) {
                return;
            }

            this.mScene.setupTouch();
        }
    }

    public void onRtlPropertiesChanged(int arg1) {
        MotionScene v1 = this.mScene;
        if(v1 != null) {
            v1.setRtl(this.isRtl());
        }
    }

    public boolean onStartNestedScroll(View arg1, View arg2, int arg3, int arg4) {
        MotionScene v1 = this.mScene;
        if(v1 != null && v1.mCurrentTransition != null && this.mScene.mCurrentTransition.getTouchResponse() != null) {
            if((this.mScene.mCurrentTransition.getTouchResponse().getFlags() & 2) != 0) {
            }
            else {
                return 1;
            }
        }

        return 0;
    }

    public void onStopNestedScroll(View arg2, int arg3) {
        MotionScene v2 = this.mScene;
        if(v2 == null) {
            return;
        }

        v2.processScrollUp(this.mScrollTargetDX / this.mScrollTargetDT, this.mScrollTargetDY / this.mScrollTargetDT);
    }

    public boolean onTouchEvent(MotionEvent arg3) {
        MotionScene v0 = this.mScene;
        if(v0 != null && (this.mInteractionEnabled) && (v0.supportTouch())) {
            Transition v0_1 = this.mScene.mCurrentTransition;
            if(v0_1 != null && !v0_1.isEnabled()) {
                return super.onTouchEvent(arg3);
            }

            this.mScene.processTouchEvent(arg3, this.getCurrentState(), this);
            return 1;
        }

        return super.onTouchEvent(arg3);
    }

    public void onViewAdded(View arg2) {
        super.onViewAdded(arg2);
        if((arg2 instanceof MotionHelper)) {
            ArrayList v0 = this.mTransitionListeners;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mTransitionListeners = v0;
            }

            v0.add(arg2);
            if(((MotionHelper)arg2).isUsedOnShow()) {
                v0 = this.mOnShowHelpers;
                if(v0 == null) {
                    v0 = new ArrayList();
                    this.mOnShowHelpers = v0;
                }

                v0.add(arg2);
            }

            if(!((MotionHelper)arg2).isUseOnHide()) {
                return;
            }

            v0 = this.mOnHideHelpers;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mOnHideHelpers = v0;
            }

            v0.add(arg2);
        }
    }

    public void onViewRemoved(View arg2) {
        super.onViewRemoved(arg2);
        ArrayList v0 = this.mOnShowHelpers;
        if(v0 != null) {
            v0.remove(arg2);
        }

        ArrayList v1 = this.mOnHideHelpers;
        if(v1 != null) {
            v1.remove(arg2);
        }
    }

    protected void parseLayoutDescription(int arg1) {
        this.mConstraintLayoutSpec = null;
    }

    private void processTransitionCompleted() {
        ArrayList v2_1;
        Object v1;
        if(this.mTransitionListener == null) {
            ArrayList v0 = this.mTransitionListeners;
            if(v0 != null && !v0.isEmpty()) {
                goto label_7;
            }

            return;
        }

    label_7:
        this.mIsAnimating = false;
        Iterator v0_1 = this.mTransitionCompleted.iterator();
        do {
        label_11:
            if(!v0_1.hasNext()) {
                goto label_27;
            }

            v1 = v0_1.next();
            TransitionListener v2 = this.mTransitionListener;
            if(v2 != null) {
                v2.onTransitionCompleted(this, ((Integer)v1).intValue());
            }

            v2_1 = this.mTransitionListeners;
        }
        while(v2_1 == null);

        Iterator v2_2 = v2_1.iterator();
        goto label_21;
    label_27:
        this.mTransitionCompleted.clear();
        return;
        while(true) {
        label_21:
            if(!v2_2.hasNext()) {
                goto label_11;
            }

            v2_2.next().onTransitionCompleted(this, ((Integer)v1).intValue());
        }
    }

    @Deprecated public void rebuildMotion() {
        Log.e("MotionLayout", "This method is deprecated. Please call rebuildScene() instead.");
        this.rebuildScene();
    }

    public void rebuildScene() {
        this.mModel.reEvaluateState();
        this.invalidate();
    }

    public boolean removeTransitionListener(TransitionListener arg1) {
        ArrayList v0 = this.mTransitionListeners;
        if(v0 == null) {
            return 0;
        }

        return v0.remove(arg1);
    }

    public void requestLayout() {
        if(!this.mMeasureDuringTransition && this.mCurrentState == -1) {
            MotionScene v0 = this.mScene;
            if(v0 != null && v0.mCurrentTransition != null && this.mScene.mCurrentTransition.getLayoutDuringTransition() == 0) {
                return;
            }
        }

        super.requestLayout();
    }

    public void setDebugMode(int arg1) {
        this.mDebugPath = arg1;
        this.invalidate();
    }

    public void setInteractionEnabled(boolean arg1) {
        this.mInteractionEnabled = arg1;
    }

    public void setInterpolatedProgress(float arg2) {
        if(this.mScene != null) {
            this.setState(TransitionState.MOVING);
            Interpolator v0 = this.mScene.getInterpolator();
            if(v0 != null) {
                this.setProgress(v0.getInterpolation(arg2));
                return;
            }
        }

        this.setProgress(arg2);
    }

    public void setOnHide(float arg4) {
        ArrayList v0 = this.mOnHideHelpers;
        if(v0 != null) {
            int v0_1 = v0.size();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                this.mOnHideHelpers.get(v1).setProgress(arg4);
            }
        }
    }

    public void setOnShow(float arg4) {
        ArrayList v0 = this.mOnShowHelpers;
        if(v0 != null) {
            int v0_1 = v0.size();
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                this.mOnShowHelpers.get(v1).setProgress(arg4);
            }
        }
    }

    public void setProgress(float arg4) {
        if(!this.isAttachedToWindow()) {
            StateCache v0 = this.mStateCache;
            if(v0 == null) {
                v0 = new StateCache(this);
                this.mStateCache = v0;
            }

            v0.setProgress(arg4);
            return;
        }

        if(arg4 <= 0f) {
            this.mCurrentState = this.mBeginState;
            if(this.mTransitionLastPosition == 0f) {
                this.setState(TransitionState.FINISHED);
            }
        }
        else {
            float v0_1 = 1f;
            if(arg4 >= v0_1) {
                this.mCurrentState = this.mEndState;
                if(this.mTransitionLastPosition == v0_1) {
                    this.setState(TransitionState.FINISHED);
                }
            }
            else {
                this.mCurrentState = -1;
                this.setState(TransitionState.MOVING);
            }
        }

        if(this.mScene == null) {
            return;
        }

        this.mTransitionInstantly = true;
        this.mTransitionGoalPosition = arg4;
        this.mTransitionPosition = arg4;
        this.mTransitionLastTime = -1;
        this.mAnimationStartTime = -1;
        this.mInterpolator = null;
        this.mInTransition = true;
        this.invalidate();
    }

    public void setProgress(float arg2, float arg3) {
        if(!this.isAttachedToWindow()) {
            StateCache v0 = this.mStateCache;
            if(v0 == null) {
                v0 = new StateCache(this);
                this.mStateCache = v0;
            }

            v0.setProgress(arg2);
            this.mStateCache.setVelocity(arg3);
            return;
        }

        this.setProgress(arg2);
        this.setState(TransitionState.MOVING);
        this.mLastVelocity = arg3;
        this.animateTo(1f);
    }

    public void setScene(MotionScene arg2) {
        this.mScene = arg2;
        arg2.setRtl(this.isRtl());
        this.rebuildScene();
    }

    void setState(TransitionState arg3) {
        if(arg3 != TransitionState.FINISHED || this.mCurrentState != -1) {
            TransitionState v0 = this.mTransitionState;
            this.mTransitionState = arg3;
            if(v0 == TransitionState.MOVING && arg3 == TransitionState.MOVING) {
                this.fireTransitionChange();
            }

            int v0_1 = androidx.constraintlayout.motion.widget.MotionLayout$2.$SwitchMap$androidx$constraintlayout$motion$widget$MotionLayout$TransitionState[v0.ordinal()];
            if(v0_1 != 1 && v0_1 != 2) {
                if(v0_1 != 3) {
                    return;
                }
                else if(arg3 == TransitionState.FINISHED) {
                    this.fireTransitionCompleted();
                    return;
                }
                else {
                    return;
                }
            }

            if(arg3 == TransitionState.MOVING) {
                this.fireTransitionChange();
            }

            if(arg3 != TransitionState.FINISHED) {
                return;
            }

            this.fireTransitionCompleted();
        }
        else {
        }
    }

    public void setState(int arg2, int arg3, int arg4) {
        this.setState(TransitionState.SETUP);
        this.mCurrentState = arg2;
        this.mBeginState = -1;
        this.mEndState = -1;
        if(this.mConstraintLayoutSpec != null) {
            this.mConstraintLayoutSpec.updateConstraints(arg2, ((float)arg3), ((float)arg4));
            return;
        }

        MotionScene v3 = this.mScene;
        if(v3 != null) {
            v3.getConstraintSet(arg2).applyTo(((ConstraintLayout)this));
        }
    }

    public void setTransition(int arg4, int arg5) {
        if(!this.isAttachedToWindow()) {
            StateCache v0 = this.mStateCache;
            if(v0 == null) {
                v0 = new StateCache(this);
                this.mStateCache = v0;
            }

            v0.setStartState(arg4);
            this.mStateCache.setEndState(arg5);
            return;
        }

        MotionScene v0_1 = this.mScene;
        if(v0_1 != null) {
            this.mBeginState = arg4;
            this.mEndState = arg5;
            v0_1.setTransition(arg4, arg5);
            this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(arg4), this.mScene.getConstraintSet(arg5));
            this.rebuildScene();
            this.mTransitionLastPosition = 0f;
            this.transitionToStart();
        }
    }

    public void setTransition(int arg7) {
        float v0_1;
        if(this.mScene != null) {
            Transition v7 = this.getTransition(arg7);
            this.mBeginState = v7.getStartConstraintSetId();
            this.mEndState = v7.getEndConstraintSetId();
            if(!this.isAttachedToWindow()) {
                StateCache v7_1 = this.mStateCache;
                if(v7_1 == null) {
                    v7_1 = new StateCache(this);
                    this.mStateCache = v7_1;
                }

                v7_1.setStartState(this.mBeginState);
                this.mStateCache.setEndState(this.mEndState);
                return;
            }
            else {
                int v0 = this.mCurrentState;
                float v2 = 0f;
                if(v0 == this.mBeginState) {
                    v0_1 = 0f;
                }
                else if(v0 == this.mEndState) {
                    v0_1 = 1f;
                }
                else {
                    v0_1 = NaNf;
                }

                this.mScene.setTransition(v7);
                this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
                this.rebuildScene();
                if(Float.isNaN(v0_1)) {
                }
                else {
                    v2 = v0_1;
                }

                this.mTransitionLastPosition = v2;
                if(Float.isNaN(v0_1)) {
                    Log.v("MotionLayout", Debug.getLocation() + " transitionToStart ");
                    this.transitionToStart();
                    return;
                }

                this.setProgress(v0_1);
            }
        }
    }

    protected void setTransition(Transition arg5) {
        this.mScene.setTransition(arg5);
        this.setState(TransitionState.SETUP);
        if(this.mCurrentState == this.mScene.getEndId()) {
            this.mTransitionLastPosition = 1f;
            this.mTransitionPosition = 1f;
            this.mTransitionGoalPosition = 1f;
        }
        else {
            this.mTransitionLastPosition = 0f;
            this.mTransitionPosition = 0f;
            this.mTransitionGoalPosition = 0f;
        }

        long v0 = arg5.isTransitionFlag(1) ? -1 : this.getNanoTime();
        this.mTransitionLastTime = v0;
        int v5 = this.mScene.getStartId();
        int v0_1 = this.mScene.getEndId();
        if(v5 == this.mBeginState && v0_1 == this.mEndState) {
            return;
        }

        this.mBeginState = v5;
        this.mEndState = v0_1;
        this.mScene.setTransition(v5, v0_1);
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.mModel.setMeasuredId(this.mBeginState, this.mEndState);
        this.mModel.reEvaluateState();
        this.rebuildScene();
    }

    public void setTransitionDuration(int arg1) {
        MotionScene v0 = this.mScene;
        if(v0 == null) {
            Log.e("MotionLayout", "MotionScene not defined");
            return;
        }

        v0.setDuration(arg1);
    }

    public void setTransitionListener(TransitionListener arg1) {
        this.mTransitionListener = arg1;
    }

    public void setTransitionState(Bundle arg2) {
        StateCache v0 = this.mStateCache;
        if(v0 == null) {
            v0 = new StateCache(this);
            this.mStateCache = v0;
        }

        v0.setTransitionState(arg2);
        if(this.isAttachedToWindow()) {
            this.mStateCache.apply();
        }
    }

    private void setupMotionViews() {
        float v9_1;
        Object v6;
        int v0 = this.getChildCount();
        this.mModel.build();
        int v1 = 1;
        this.mInTransition = true;
        int v3 = this.getWidth();
        int v4 = this.getHeight();
        int v2 = this.mScene.gatPathMotionArc();
        int v8 = 0;
        if(v2 != -1) {
            int v5;
            for(v5 = 0; v5 < v0; ++v5) {
                v6 = this.mFrameArrayList.get(this.getChildAt(v5));
                if(v6 != null) {
                    ((MotionController)v6).setPathMotionArc(v2);
                }
            }
        }

        int v9;
        for(v9 = 0; v9 < v0; ++v9) {
            Object v2_1 = this.mFrameArrayList.get(this.getChildAt(v9));
            if(v2_1 != null) {
                this.mScene.getKeyFrames(((MotionController)v2_1));
                ((MotionController)v2_1).setup(v3, v4, this.mTransitionDuration, this.getNanoTime());
            }
        }

        float v2_2 = this.mScene.getStaggered();
        if(v2_2 != 0f) {
            if((((double)v2_2)) < 0) {
            }
            else {
                v1 = 0;
            }

            v2_2 = Math.abs(v2_2);
            float v3_1 = -3.402823E+38f;
            float v4_1 = 3.402823E+38f;
            float v7 = v3_1;
            float v6_1 = v4_1;
            v5 = 0;
            while(true) {
                v9_1 = 1f;
                if(v5 < v0) {
                    Object v10 = this.mFrameArrayList.get(this.getChildAt(v5));
                    if(!Float.isNaN(((MotionController)v10).mMotionStagger)) {
                        v5 = 0;
                        break;
                    }
                    else {
                        v9_1 = ((MotionController)v10).getFinalX();
                        float v10_1 = ((MotionController)v10).getFinalY();
                        if(v1 != 0) {
                            v10_1 -= v9_1;
                        }
                        else {
                            v10_1 += v9_1;
                        }

                        v6_1 = Math.min(v6_1, v10_1);
                        v7 = Math.max(v7, v10_1);
                        ++v5;
                        continue;
                    }
                }

                goto label_109;
            }

            while(v5 < v0) {
                v6 = this.mFrameArrayList.get(this.getChildAt(v5));
                if(!Float.isNaN(((MotionController)v6).mMotionStagger)) {
                    v4_1 = Math.min(v4_1, ((MotionController)v6).mMotionStagger);
                    v3_1 = Math.max(v3_1, ((MotionController)v6).mMotionStagger);
                }

                ++v5;
            }

            while(true) {
                if(v8 >= v0) {
                    return;
                }

                Object v5_1 = this.mFrameArrayList.get(this.getChildAt(v8));
                if(!Float.isNaN(((MotionController)v5_1).mMotionStagger)) {
                    ((MotionController)v5_1).mStaggerScale = v9_1 / (v9_1 - v2_2);
                    ((MotionController)v5_1).mStaggerOffset = v1 != 0 ? v2_2 - (v3_1 - ((MotionController)v5_1).mMotionStagger) / (v3_1 - v4_1) * v2_2 : v2_2 - (((MotionController)v5_1).mMotionStagger - v4_1) * v2_2 / (v3_1 - v4_1);
                }

                ++v8;
            }

        label_109:
            while(v8 < v0) {
                Object v3_2 = this.mFrameArrayList.get(this.getChildAt(v8));
                v4_1 = ((MotionController)v3_2).getFinalX();
                float v5_2 = ((MotionController)v3_2).getFinalY();
                if(v1 != 0) {
                    v5_2 -= v4_1;
                }
                else {
                    v5_2 += v4_1;
                }

                ((MotionController)v3_2).mStaggerScale = v9_1 / (v9_1 - v2_2);
                ((MotionController)v3_2).mStaggerOffset = v2_2 - (v5_2 - v6_1) * v2_2 / (v7 - v6_1);
                ++v8;
            }
        }
    }

    public String toString() {
        Context v0 = this.getContext();
        return Debug.getName(v0, this.mBeginState) + "->" + Debug.getName(v0, this.mEndState) + " (pos:" + this.mTransitionLastPosition + " Dpos/Dt:" + this.mLastVelocity;
    }

    public void touchAnimateTo(int arg11, float arg12, float arg13) {
        if(this.mScene == null) {
        }
        else {
            if(this.mTransitionLastPosition == arg12) {
                return;
            }

            goto label_6;
        }

        return;
    label_6:
        this.mTemporalInterpolator = true;
        this.mAnimationStartTime = this.getNanoTime();
        float v7 = (((float)this.mScene.getDuration())) / 1000f;
        this.mTransitionDuration = v7;
        this.mTransitionGoalPosition = arg12;
        this.mInTransition = true;
        int v2 = 2;
        if(arg11 == 0 || arg11 == 1 || arg11 == v2) {
            float v4 = arg12;
            float v5 = arg13;
            if(arg11 == 1) {
                arg12 = 0f;
            }
            else if(arg11 == v2) {
                arg12 = 1f;
            }
            else {
                arg12 = v4;
            }

            this.mStopLogic.config(this.mTransitionLastPosition, arg12, v5, v7, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
            arg11 = this.mCurrentState;
            this.mTransitionGoalPosition = arg12;
            this.mCurrentState = arg11;
            this.mInterpolator = this.mStopLogic;
        }
        else if(arg11 == 4) {
            this.mDecelerateLogic.config(arg13, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
            this.mInterpolator = this.mDecelerateLogic;
        }
        else if(arg11 != 5) {
        }
        else if(MotionLayout.willJump(arg13, this.mTransitionLastPosition, this.mScene.getMaxAcceleration())) {
            this.mDecelerateLogic.config(arg13, this.mTransitionLastPosition, this.mScene.getMaxAcceleration());
            this.mInterpolator = this.mDecelerateLogic;
        }
        else {
            this.mStopLogic.config(this.mTransitionLastPosition, arg12, arg13, this.mTransitionDuration, this.mScene.getMaxAcceleration(), this.mScene.getMaxVelocity());
            this.mLastVelocity = 0f;
            arg11 = this.mCurrentState;
            this.mTransitionGoalPosition = arg12;
            this.mCurrentState = arg11;
            this.mInterpolator = this.mStopLogic;
        }

        this.mTransitionInstantly = false;
        this.mAnimationStartTime = this.getNanoTime();
        this.invalidate();
    }

    public void transitionToEnd() {
        this.animateTo(1f);
    }

    public void transitionToStart() {
        this.animateTo(0f);
    }

    public void transitionToState(int arg2) {
        if(!this.isAttachedToWindow()) {
            StateCache v0 = this.mStateCache;
            if(v0 == null) {
                v0 = new StateCache(this);
                this.mStateCache = v0;
            }

            v0.setEndState(arg2);
            return;
        }

        this.transitionToState(arg2, -1, -1);
    }

    public void transitionToState(int arg11, int arg12, int arg13) {
        float v6_2;
        MotionScene v0 = this.mScene;
        int v1 = -1;
        if(v0 != null && v0.mStateSet != null) {
            arg12 = this.mScene.mStateSet.convertToConstraintSet(this.mCurrentState, arg11, ((float)arg12), ((float)arg13));
            if(arg12 != v1) {
                arg11 = arg12;
            }
        }

        arg12 = this.mCurrentState;
        if(arg12 == arg11) {
            return;
        }

        if(this.mBeginState == arg11) {
            this.animateTo(0f);
            return;
        }

        float v2 = 1f;
        if(this.mEndState == arg11) {
            this.animateTo(v2);
            return;
        }

        this.mEndState = arg11;
        if(arg12 != v1) {
            this.setTransition(arg12, arg11);
            this.animateTo(v2);
            this.mTransitionLastPosition = 0f;
            this.transitionToEnd();
            return;
        }

        arg12 = 0;
        this.mTemporalInterpolator = false;
        this.mTransitionGoalPosition = v2;
        this.mTransitionPosition = 0f;
        this.mTransitionLastPosition = 0f;
        this.mTransitionLastTime = this.getNanoTime();
        this.mAnimationStartTime = this.getNanoTime();
        this.mTransitionInstantly = false;
        Interpolator v13 = null;
        this.mInterpolator = v13;
        this.mTransitionDuration = (((float)this.mScene.getDuration())) / 1000f;
        this.mBeginState = v1;
        this.mScene.setTransition(v1, this.mEndState);
        this.mScene.getStartId();
        v1 = this.getChildCount();
        this.mFrameArrayList.clear();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            View v4 = this.getChildAt(v3);
            this.mFrameArrayList.put(v4, new MotionController(v4));
        }

        this.mInTransition = true;
        this.mModel.initFrom(this.mLayoutWidget, ((ConstraintSet)v13), this.mScene.getConstraintSet(arg11));
        this.rebuildScene();
        this.mModel.build();
        this.computeCurrentPositions();
        int v5 = this.getWidth();
        int v6 = this.getHeight();
        for(arg11 = 0; arg11 < v1; ++arg11) {
            Object v4_1 = this.mFrameArrayList.get(this.getChildAt(arg11));
            this.mScene.getKeyFrames(((MotionController)v4_1));
            ((MotionController)v4_1).setup(v5, v6, this.mTransitionDuration, this.getNanoTime());
        }

        float v11 = this.mScene.getStaggered();
        if(v11 != 0f) {
            float v13_1 = 3.402823E+38f;
            float v4_2 = -3.402823E+38f;
            for(v5 = 0; v5 < v1; ++v5) {
                Object v6_1 = this.mFrameArrayList.get(this.getChildAt(v5));
                v6_2 = ((MotionController)v6_1).getFinalY() + ((MotionController)v6_1).getFinalX();
                v13_1 = Math.min(v13_1, v6_2);
                v4_2 = Math.max(v4_2, v6_2);
            }

            while(arg12 < v1) {
                Object v5_1 = this.mFrameArrayList.get(this.getChildAt(arg12));
                v6_2 = ((MotionController)v5_1).getFinalX();
                float v7 = ((MotionController)v5_1).getFinalY();
                ((MotionController)v5_1).mStaggerScale = v2 / (v2 - v11);
                ((MotionController)v5_1).mStaggerOffset = v11 - (v6_2 + v7 - v13_1) * v11 / (v4_2 - v13_1);
                ++arg12;
            }
        }

        this.mTransitionPosition = 0f;
        this.mTransitionLastPosition = 0f;
        this.mInTransition = true;
        this.invalidate();
    }

    public void updateState(int arg2, ConstraintSet arg3) {
        MotionScene v0 = this.mScene;
        if(v0 != null) {
            v0.setConstraintSet(arg2, arg3);
        }

        this.updateState();
        if(this.mCurrentState == arg2) {
            arg3.applyTo(((ConstraintLayout)this));
        }
    }

    public void updateState() {
        this.mModel.initFrom(this.mLayoutWidget, this.mScene.getConstraintSet(this.mBeginState), this.mScene.getConstraintSet(this.mEndState));
        this.rebuildScene();
    }

    private static boolean willJump(float arg5, float arg6, float arg7) {
        float v4 = 2f;
        if(Float.compare(arg5, 0f) > 0) {
            float v0 = arg5 / arg7;
            if(arg6 + (arg5 * v0 - arg7 * v0 * v0 / v4) > 1f) {
                return 1;
            }

            return 0;
        }

        float v1 = -arg5 / arg7;
        if(arg6 + (arg5 * v1 + arg7 * v1 * v1 / v4) < 0f) {
            return 1;
        }

        return 0;
    }
}

