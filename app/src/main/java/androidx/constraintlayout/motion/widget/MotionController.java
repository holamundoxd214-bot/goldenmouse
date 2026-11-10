package androidx.constraintlayout.motion.widget;

import android.graphics.RectF;
import android.util.Log;
import android.util.SparseArray;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.motion.utils.VelocityMatrix;
import androidx.constraintlayout.solver.widgets.ConstraintWidget;
import androidx.constraintlayout.widget.ConstraintLayout$LayoutParams;
import androidx.constraintlayout.widget.ConstraintSet$Constraint;
import androidx.constraintlayout.widget.ConstraintSet;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class MotionController {
    private static final boolean DEBUG = false;
    public static final int DRAW_PATH_AS_CONFIGURED = 4;
    public static final int DRAW_PATH_BASIC = 1;
    public static final int DRAW_PATH_CARTESIAN = 3;
    public static final int DRAW_PATH_NONE = 0;
    public static final int DRAW_PATH_RECTANGLE = 5;
    public static final int DRAW_PATH_RELATIVE = 2;
    public static final int DRAW_PATH_SCREEN = 6;
    private static final boolean FAVOR_FIXED_SIZE_VIEWS = false;
    public static final int HORIZONTAL_PATH_X = 2;
    public static final int HORIZONTAL_PATH_Y = 3;
    private int MAX_DIMENSION;
    public static final int PATH_PERCENT = 0;
    public static final int PATH_PERPENDICULAR = 1;
    private static final String TAG = "MotionController";
    public static final int VERTICAL_PATH_X = 4;
    public static final int VERTICAL_PATH_Y = 5;
    String[] attributeTable;
    private CurveFit mArcSpline;
    private int[] mAttributeInterpCount;
    private String[] mAttributeNames;
    private HashMap mAttributesMap;
    String mConstraintTag;
    private int mCurveFitType;
    private HashMap mCycleMap;
    private MotionPaths mEndMotionPath;
    private MotionConstrainedPoint mEndPoint;
    int mId;
    private double[] mInterpolateData;
    private int[] mInterpolateVariables;
    private double[] mInterpolateVelocity;
    private ArrayList mKeyList;
    private KeyTrigger[] mKeyTriggers;
    private ArrayList mMotionPaths;
    float mMotionStagger;
    private int mPathMotionArc;
    private CurveFit[] mSpline;
    float mStaggerOffset;
    float mStaggerScale;
    private MotionPaths mStartMotionPath;
    private MotionConstrainedPoint mStartPoint;
    private HashMap mTimeCycleAttributesMap;
    private float[] mValuesBuff;
    private float[] mVelocity;
    View mView;

    MotionController(View arg2) {
        super();
        this.mCurveFitType = -1;
        this.mStartMotionPath = new MotionPaths();
        this.mEndMotionPath = new MotionPaths();
        this.mStartPoint = new MotionConstrainedPoint();
        this.mEndPoint = new MotionConstrainedPoint();
        this.mMotionStagger = NaNf;
        this.mStaggerOffset = 0f;
        this.mStaggerScale = 1f;
        this.MAX_DIMENSION = 4;
        this.mValuesBuff = new float[4];
        this.mMotionPaths = new ArrayList();
        this.mVelocity = new float[1];
        this.mKeyList = new ArrayList();
        this.mPathMotionArc = Key.UNSET;
        this.setView(arg2);
    }

    void addKey(Key arg1) {
        this.mKeyList.add(arg1);
    }

    void addKeys(ArrayList arg1) {
        this.mKeyList.addAll(((Collection)arg1));
    }

    void buildBounds(float[] arg17, int arg18) {
        MotionController v0 = this;
        int v1 = arg18;
        float v3 = 1f;
        float v2 = v3 / (((float)(v1 - 1)));
        HashMap v4 = v0.mAttributesMap;
        String v5 = "translationX";
        if(v4 == null) {
        }
        else {
            v4.get(v5);
        }

        v4 = v0.mAttributesMap;
        String v6 = "translationY";
        if(v4 == null) {
        }
        else {
            v4.get(v6);
        }

        v4 = v0.mCycleMap;
        if(v4 == null) {
        }
        else {
            v4.get(v5);
        }

        v4 = v0.mCycleMap;
        if(v4 == null) {
        }
        else {
            v4.get(v6);
        }

        int v5_1;
        for(v5_1 = 0; v5_1 < v1; ++v5_1) {
            float v6_1 = (((float)v5_1)) * v2;
            float v7 = v0.mStaggerScale;
            float v9 = 0f;
            if(Float.compare(v7, v3) != 0) {
                float v8 = v0.mStaggerOffset;
                if(v6_1 < v8) {
                    v6_1 = 0f;
                }

                if(v6_1 <= v8) {
                    goto label_42;
                }

                if((((double)v6_1)) >= 1) {
                    goto label_42;
                }

                v6_1 = (v6_1 - v8) * v7;
            }

        label_42:
            double v7_1 = ((double)v6_1);
            Easing v10 = v0.mStartMotionPath.mKeyFrameEasing;
            Iterator v11 = v0.mMotionPaths.iterator();
            float v12;
            for(v12 = NaNf; v11.hasNext(); v12 = ((MotionPaths)v13).time) {
                Object v13 = v11.next();
                if(((MotionPaths)v13).mKeyFrameEasing == null) {
                    continue;
                }

                if(((MotionPaths)v13).time < v6_1) {
                    v10 = ((MotionPaths)v13).mKeyFrameEasing;
                    v9 = ((MotionPaths)v13).time;
                    continue;
                }

                if(!Float.isNaN(v12)) {
                    continue;
                }
            }

            if(v10 != null) {
                if(Float.isNaN(v12)) {
                    v12 = v3;
                }

                v12 -= v9;
                v7_1 = ((double)((((float)v10.get(((double)((v6_1 - v9) / v12))))) * v12 + v9));
            }

            v0.mSpline[0].getPos(v7_1, v0.mInterpolateData);
            CurveFit v6_2 = v0.mArcSpline;
            if(v6_2 != null) {
                double[] v9_1 = v0.mInterpolateData;
                if(v9_1.length > 0) {
                    v6_2.getPos(v7_1, v9_1);
                }
            }

            v0.mStartMotionPath.getBounds(v0.mInterpolateVariables, v0.mInterpolateData, arg17, v5_1 * 2);
        }
    }

    int buildKeyBounds(float[] arg8, int[] arg9) {
        if(arg8 != null) {
            double[] v1 = this.mSpline[0].getTimePoints();
            if(arg9 != null) {
                Iterator v2 = this.mMotionPaths.iterator();
                int v3;
                for(v3 = 0; v2.hasNext(); ++v3) {
                    arg9[v3] = v2.next().mMode;
                }
            }

            int v9 = 0;
            int v2_1 = 0;
            while(v9 < v1.length) {
                this.mSpline[0].getPos(v1[v9], this.mInterpolateData);
                this.mStartMotionPath.getBounds(this.mInterpolateVariables, this.mInterpolateData, arg8, v2_1);
                v2_1 += 2;
                ++v9;
            }

            return v2_1 / 2;
        }

        return 0;
    }

    int buildKeyFrames(float[] arg8, int[] arg9) {
        if(arg8 != null) {
            double[] v1 = this.mSpline[0].getTimePoints();
            if(arg9 != null) {
                Iterator v2 = this.mMotionPaths.iterator();
                int v3;
                for(v3 = 0; v2.hasNext(); ++v3) {
                    arg9[v3] = v2.next().mMode;
                }
            }

            int v9 = 0;
            int v2_1 = 0;
            while(v9 < v1.length) {
                this.mSpline[0].getPos(v1[v9], this.mInterpolateData);
                this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, arg8, v2_1);
                v2_1 += 2;
                ++v9;
            }

            return v2_1 / 2;
        }

        return 0;
    }

    void buildPath(float[] arg20, int arg21) {
        int v18;
        int v15;
        int v16;
        MotionController v0 = this;
        float[] v1 = arg20;
        int v2 = arg21;
        float v4 = 1f;
        float v3 = v4 / (((float)(v2 - 1)));
        HashMap v5 = v0.mAttributesMap;
        String v6 = "translationX";
        Object v7 = null;
        Object v5_1 = v5 == null ? v7 : v5.get(v6);
        HashMap v8 = v0.mAttributesMap;
        String v9 = "translationY";
        Object v8_1 = v8 == null ? v7 : v8.get(v9);
        HashMap v10 = v0.mCycleMap;
        Object v6_1 = v10 == null ? v7 : v10.get(v6);
        v10 = v0.mCycleMap;
        if(v10 == null) {
        }
        else {
            v7 = v10.get(v9);
        }

        int v10_1 = 0;
        while(v10_1 < v2) {
            float v11 = (((float)v10_1)) * v3;
            float v12 = v0.mStaggerScale;
            float v14 = 0f;
            if(Float.compare(v12, v4) != 0) {
                float v13 = v0.mStaggerOffset;
                if(v11 < v13) {
                    v11 = 0f;
                }

                if(v11 <= v13) {
                    goto label_49;
                }

                v16 = v10_1;
                v15 = 0;
                if((((double)v11)) >= 1) {
                    goto label_51;
                }

                v11 = (v11 - v13) * v12;
            }
            else {
            label_49:
                v16 = v10_1;
                v15 = 0;
            }

        label_51:
            double v9_1 = ((double)v11);
            Easing v12_1 = v0.mStartMotionPath.mKeyFrameEasing;
            Iterator v13_1 = v0.mMotionPaths.iterator();
            float v17 = NaNf;
            while(v13_1.hasNext()) {
                Object v4_1 = v13_1.next();
                v18 = v15;
                if(((MotionPaths)v4_1).mKeyFrameEasing != null) {
                    if(((MotionPaths)v4_1).time < v11) {
                        v12_1 = ((MotionPaths)v4_1).mKeyFrameEasing;
                        v14 = ((MotionPaths)v4_1).time;
                    }
                    else if(Float.isNaN(v17)) {
                        v17 = ((MotionPaths)v4_1).time;
                    }
                }

                v15 = v18;
            }

            v18 = v15;
            if(v12_1 != null) {
                if(Float.isNaN(v17)) {
                    v17 = 1f;
                }

                v17 -= v14;
                v9_1 = ((double)((((float)v12_1.get(((double)((v11 - v14) / v17))))) * v17 + v14));
            }

            v0.mSpline[v18].getPos(v9_1, v0.mInterpolateData);
            CurveFit v4_2 = v0.mArcSpline;
            if(v4_2 != null) {
                double[] v12_2 = v0.mInterpolateData;
                if(v12_2.length > 0) {
                    v4_2.getPos(v9_1, v12_2);
                }
            }

            int v12_3 = v16 * 2;
            v0.mStartMotionPath.getCenter(v0.mInterpolateVariables, v0.mInterpolateData, v1, v12_3);
            if(v6_1 != null) {
                v1[v12_3] += ((KeyCycleOscillator)v6_1).get(v11);
            }
            else if(v5_1 != null) {
                v1[v12_3] += ((SplineSet)v5_1).get(v11);
            }

            if(v7 != null) {
                ++v12_3;
                v1[v12_3] += ((KeyCycleOscillator)v7).get(v11);
            }
            else if(v8_1 != null) {
                ++v12_3;
                v1[v12_3] += ((SplineSet)v8_1).get(v11);
            }

            v10_1 = v16 + 1;
            v4 = 1f;
        }
    }

    void buildRect(float arg4, float[] arg5, int arg6) {
        this.mSpline[0].getPos(((double)this.getAdjustedPosition(arg4, null)), this.mInterpolateData);
        this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, arg5, arg6);
    }

    void buildRectangles(float[] arg8, int arg9) {
        float v1 = 1f / (((float)(arg9 - 1)));
        int v2;
        for(v2 = 0; v2 < arg9; ++v2) {
            this.mSpline[0].getPos(((double)this.getAdjustedPosition((((float)v2)) * v1, null)), this.mInterpolateData);
            this.mStartMotionPath.getRect(this.mInterpolateVariables, this.mInterpolateData, arg8, v2 * 8);
        }
    }

    private float getAdjustedPosition(float arg12, float[] arg13) {
        float v4;
        float v0 = 0f;
        float v1 = 1f;
        if(arg13 != null) {
            arg13[0] = v1;
        }
        else {
            float v3 = this.mStaggerScale;
            double v6 = 1;
            if((((double)v3)) != v6) {
                v4 = this.mStaggerOffset;
                if(arg12 < v4) {
                    arg12 = 0f;
                }

                if(0f <= v4) {
                    goto label_18;
                }

                if((((double)0f)) >= v6) {
                    goto label_18;
                }

                arg12 = (0f - v4) * v3;
            }
        }

    label_18:
        Easing v3_1 = this.mStartMotionPath.mKeyFrameEasing;
        Iterator v11 = this.mMotionPaths.iterator();
        for(v4 = NaNf; v11.hasNext(); v4 = ((MotionPaths)v5).time) {
            Object v5 = v11.next();
            if(((MotionPaths)v5).mKeyFrameEasing == null) {
                continue;
            }

            if(((MotionPaths)v5).time < arg12) {
                v3_1 = ((MotionPaths)v5).mKeyFrameEasing;
                v0 = ((MotionPaths)v5).time;
                continue;
            }

            if(!Float.isNaN(v4)) {
                continue;
            }
        }

        if(v3_1 != null) {
            if(Float.isNaN(v4)) {
            }
            else {
                v1 = v4;
            }

            v1 -= v0;
            double v11_1 = ((double)((arg12 - v0) / v1));
            v4 = (((float)v3_1.get(v11_1))) * v1 + v0;
            if(arg13 != null) {
                arg13[0] = ((float)v3_1.getDiff(v11_1));
            }

            return v4;
        }

        return arg12;
    }

    int getAttributeValues(String arg1, float[] arg2, int arg3) {
        Object v0 = this.mAttributesMap.get(arg1);
        if(v0 == null) {
            return -1;
        }

        int v1;
        for(v1 = 0; v1 < arg2.length; ++v1) {
            arg2[v1] = ((SplineSet)v0).get(((float)(v1 / (arg2.length - 1))));
        }

        return arg2.length;
    }

    void getDpDt(float arg12, float arg13, float arg14, float[] arg15) {
        double[] v9;
        arg12 = this.getAdjustedPosition(arg12, this.mVelocity);
        CurveFit[] v0 = this.mSpline;
        int v1 = 0;
        if(v0 != null) {
            double v2 = ((double)arg12);
            v0[0].getSlope(v2, this.mInterpolateVelocity);
            this.mSpline[0].getPos(v2, this.mInterpolateData);
            arg12 = this.mVelocity[0];
            while(true) {
                v9 = this.mInterpolateVelocity;
                if(v1 >= v9.length) {
                    break;
                }

                v9[v1] *= ((double)arg12);
                ++v1;
            }

            CurveFit v12 = this.mArcSpline;
            if(v12 != null) {
                double[] v0_1 = this.mInterpolateData;
                if(v0_1.length > 0) {
                    v12.getPos(v2, v0_1);
                    this.mArcSpline.getSlope(v2, this.mInterpolateVelocity);
                    this.mStartMotionPath.setDpDt(arg13, arg14, arg15, this.mInterpolateVariables, this.mInterpolateVelocity, this.mInterpolateData);
                }

                return;
            }

            this.mStartMotionPath.setDpDt(arg13, arg14, arg15, this.mInterpolateVariables, v9, this.mInterpolateData);
            return;
        }

        float v5 = arg13;
        float v6 = arg14;
        float[] v7 = arg15;
        arg12 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        arg13 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        arg14 = this.mEndMotionPath.width - this.mStartMotionPath.width;
        float v15 = this.mEndMotionPath.height - this.mStartMotionPath.height + arg13;
        v7[0] = arg12 * (1f - v5) + (arg14 + arg12) * v5;
        v7[1] = arg13 * (1f - v6) + v15 * v6;
    }

    public int getDrawPath() {
        int v0 = this.mStartMotionPath.mDrawPath;
        Iterator v1 = this.mMotionPaths.iterator();
        while(v1.hasNext()) {
            v0 = Math.max(v0, v1.next().mDrawPath);
        }

        return Math.max(v0, this.mEndMotionPath.mDrawPath);
    }

    float getFinalX() {
        return this.mEndMotionPath.x;
    }

    float getFinalY() {
        return this.mEndMotionPath.y;
    }

    MotionPaths getKeyFrame(int arg1) {
        return this.mMotionPaths.get(arg1);
    }

    public int getKeyFrameInfo(int arg11, int[] arg12) {
        float[] v0 = new float[2];
        Iterator v1 = this.mKeyList.iterator();
        int v3 = 0;
        int v4;
        for(v4 = 0; v1.hasNext(); v4 = v6) {
            Object v5 = v1.next();
            if(((Key)v5).mType != arg11 && arg11 == -1) {
                continue;
            }

            arg12[v4] = 0;
            arg12[v4 + 1] = ((Key)v5).mType;
            arg12[v4 + 2] = ((Key)v5).mFramePosition;
            this.mSpline[0].getPos(((double)((((float)((Key)v5).mFramePosition)) / 100f)), this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, v0, 0);
            arg12[v4 + 3] = Float.floatToIntBits(v0[0]);
            int v6 = v4 + 4;
            arg12[v6] = Float.floatToIntBits(v0[1]);
            if((v5 instanceof KeyPosition)) {
                arg12[v4 + 5] = ((KeyPosition)v5).mPositionType;
                arg12[v4 + 6] = Float.floatToIntBits(((KeyPosition)v5).mPercentX);
                v6 = v4 + 7;
                arg12[v6] = Float.floatToIntBits(((KeyPosition)v5).mPercentY);
            }

            ++v6;
            arg12[v4] = v6 - v4;
            ++v3;
        }

        return v3;
    }

    float getKeyFrameParameter(int arg9, float arg10, float arg11) {
        float v0 = this.mEndMotionPath.x - this.mStartMotionPath.x;
        float v1 = this.mEndMotionPath.y - this.mStartMotionPath.y;
        float v2 = this.mStartMotionPath.x + this.mStartMotionPath.width / 2f;
        float v3 = this.mStartMotionPath.y + this.mStartMotionPath.height / 2f;
        float v8 = ((float)Math.hypot(((double)v0), ((double)v1)));
        if((((double)v8)) < 1.000000E-07) {
            return NaNf;
        }

        arg10 -= v2;
        arg11 -= v3;
        if((((float)Math.hypot(((double)arg10), ((double)arg11)))) == 0f) {
            return 0;
        }

        v2 = arg10 * v0 + arg11 * v1;
        if(arg9 != 0) {
            if(arg9 != 1) {
                if(arg9 != 2) {
                    if(arg9 != 3) {
                        if(arg9 != 4) {
                            if(arg9 != 5) {
                                return 0;
                            }

                            return arg11 / v1;
                        }

                        return arg10 / v1;
                    }

                    return arg11 / v0;
                }

                return arg10 / v0;
            }

            return ((float)Math.sqrt(((double)(v8 * v8 - v2 * v2))));
        }

        return v2 / v8;
    }

    KeyPositionBase getPositionKeyframe(int arg8, int arg9, float arg10, float arg11) {
        float v6;
        float v5;
        int v2;
        int v1;
        RectF v3 = new RectF();
        v3.left = this.mStartMotionPath.x;
        v3.top = this.mStartMotionPath.y;
        v3.right = v3.left + this.mStartMotionPath.width;
        v3.bottom = v3.top + this.mStartMotionPath.height;
        RectF v4 = new RectF();
        v4.left = this.mEndMotionPath.x;
        v4.top = this.mEndMotionPath.y;
        v4.right = v4.left + this.mEndMotionPath.width;
        v4.bottom = v4.top + this.mEndMotionPath.height;
        Iterator v7 = this.mKeyList.iterator();
        while(v7.hasNext()) {
            Object v0 = v7.next();
            if((v0 instanceof KeyPositionBase)) {
                v1 = arg8;
                v2 = arg9;
                v5 = arg10;
                v6 = arg11;
                if(((KeyPositionBase)v0).intersects(v1, v2, v3, v4, v5, v6)) {
                    return ((KeyPositionBase)v0);
                }
            }
            else {
                v1 = arg8;
                v2 = arg9;
                v5 = arg10;
                v6 = arg11;
            }

            arg8 = v1;
            arg9 = v2;
            arg10 = v5;
            arg11 = v6;
        }

        return null;
    }

    void getPostLayoutDvDp(float arg21, int arg22, int arg23, float arg24, float arg25, float[] arg26) {
        double v3_3;
        double[] v2_3;
        KeyCycleOscillator v10_1;
        KeyCycleOscillator v8_1;
        Object v6_2;
        Object v3_2;
        Object v11_2;
        Object v9_2;
        SplineSet v7_1;
        SplineSet v5_1;
        Object v2_2;
        MotionController v0 = this;
        float v1 = v0.getAdjustedPosition(arg21, v0.mVelocity);
        HashMap v2 = v0.mAttributesMap;
        String v3 = "translationX";
        KeyCycleOscillator v4 = null;
        if(v2 == null) {
            SplineSet v2_1 = ((SplineSet)v4);
        }
        else {
            v2_2 = v2.get(v3);
        }

        HashMap v5 = v0.mAttributesMap;
        String v6 = "translationY";
        if(v5 == null) {
            v5_1 = ((SplineSet)v4);
        }
        else {
            Object v5_2 = v5.get(v6);
        }

        HashMap v7 = v0.mAttributesMap;
        String v8 = "rotation";
        if(v7 == null) {
            v7_1 = ((SplineSet)v4);
        }
        else {
            Object v7_2 = v7.get(v8);
        }

        HashMap v9 = v0.mAttributesMap;
        String v10 = "scaleX";
        if(v9 == null) {
            SplineSet v9_1 = ((SplineSet)v4);
        }
        else {
            v9_2 = v9.get(v10);
        }

        HashMap v11 = v0.mAttributesMap;
        String v12 = "scaleY";
        if(v11 == null) {
            SplineSet v11_1 = ((SplineSet)v4);
        }
        else {
            v11_2 = v11.get(v12);
        }

        HashMap v13 = v0.mCycleMap;
        if(v13 == null) {
            KeyCycleOscillator v3_1 = v4;
        }
        else {
            v3_2 = v13.get(v3);
        }

        v13 = v0.mCycleMap;
        if(v13 == null) {
            KeyCycleOscillator v6_1 = v4;
        }
        else {
            v6_2 = v13.get(v6);
        }

        v13 = v0.mCycleMap;
        if(v13 == null) {
            v8_1 = v4;
        }
        else {
            Object v8_2 = v13.get(v8);
        }

        v13 = v0.mCycleMap;
        if(v13 == null) {
            v10_1 = v4;
        }
        else {
            Object v10_2 = v13.get(v10);
        }

        v13 = v0.mCycleMap;
        if(v13 == null) {
        }
        else {
            Object v4_1 = v13.get(v12);
        }

        VelocityMatrix v12_1 = new VelocityMatrix();
        v12_1.clear();
        v12_1.setRotationVelocity(v7_1, v1);
        v12_1.setTranslationVelocity(((SplineSet)v2_2), v5_1, v1);
        v12_1.setScaleVelocity(((SplineSet)v9_2), ((SplineSet)v11_2), v1);
        v12_1.setRotationVelocity(v8_1, v1);
        v12_1.setTranslationVelocity(((KeyCycleOscillator)v3_2), ((KeyCycleOscillator)v6_2), v1);
        v12_1.setScaleVelocity(v10_1, v4, v1);
        CurveFit v13_1 = v0.mArcSpline;
        if(v13_1 != null) {
            v2_3 = v0.mInterpolateData;
            if(v2_3.length > 0) {
                v3_3 = ((double)v1);
                v13_1.getPos(v3_3, v2_3);
                v0.mArcSpline.getSlope(v3_3, v0.mInterpolateVelocity);
                v0.mStartMotionPath.setDpDt(arg24, arg25, arg26, v0.mInterpolateVariables, v0.mInterpolateVelocity, v0.mInterpolateData);
            }

            v12_1.applyTransform(arg24, arg25, arg22, arg23, arg26);
            return;
        }

        int v14 = 0;
        if(v0.mSpline != null) {
            v3_3 = ((double)v0.getAdjustedPosition(v1, v0.mVelocity));
            v0.mSpline[0].getSlope(v3_3, v0.mInterpolateVelocity);
            v0.mSpline[0].getPos(v3_3, v0.mInterpolateData);
            v1 = v0.mVelocity[0];
            while(true) {
                v2_3 = v0.mInterpolateVelocity;
                if(v14 >= v2_3.length) {
                    break;
                }

                v2_3[v14] *= ((double)v1);
                ++v14;
            }

            v0.mStartMotionPath.setDpDt(arg24, arg25, arg26, v0.mInterpolateVariables, v2_3, v0.mInterpolateData);
            v12_1.applyTransform(arg24, arg25, arg22, arg23, arg26);
            return;
        }

        float v13_2 = v0.mEndMotionPath.x - v0.mStartMotionPath.x;
        float v15 = v0.mEndMotionPath.y - v0.mStartMotionPath.y;
        float v16 = v13_2;
        float v14_1 = v0.mEndMotionPath.width - v0.mStartMotionPath.width;
        v13_2 = v0.mEndMotionPath.height - v0.mStartMotionPath.height;
        arg26[0] = v16 * (1f - arg24) + (v16 + v14_1) * arg24;
        arg26[1] = v15 * (1f - arg25) + (v13_2 + v15) * arg25;
        v12_1.clear();
        v12_1.setRotationVelocity(v7_1, v1);
        v12_1.setTranslationVelocity(((SplineSet)v2_2), v5_1, v1);
        v12_1.setScaleVelocity(((SplineSet)v9_2), ((SplineSet)v11_2), v1);
        v12_1.setRotationVelocity(v8_1, v1);
        v12_1.setTranslationVelocity(((KeyCycleOscillator)v3_2), ((KeyCycleOscillator)v6_2), v1);
        v12_1.setScaleVelocity(v10_1, v4, v1);
        v12_1.applyTransform(arg24, arg25, arg22, arg23, arg26);
    }

    private float getPreCycleDistance() {
        MotionController v0 = this;
        float[] v1 = new float[2];
        double v3 = 0;
        double v6 = v3;
        int v8 = 0;
        float v9 = 0f;
        while(v8 < 100) {
            float v10 = (((float)v8)) * 0.010101f;
            double v11 = ((double)v10);
            Easing v13 = v0.mStartMotionPath.mKeyFrameEasing;
            Iterator v14 = v0.mMotionPaths.iterator();
            float v15 = NaNf;
            float v16 = 0f;
            while(v14.hasNext()) {
                Object v2 = v14.next();
                if(((MotionPaths)v2).mKeyFrameEasing == null) {
                    continue;
                }

                if(((MotionPaths)v2).time < v10) {
                    Easing v5 = ((MotionPaths)v2).mKeyFrameEasing;
                    v16 = ((MotionPaths)v2).time;
                    v13 = v5;
                    continue;
                }

                if(!Float.isNaN(v15)) {
                    continue;
                }

                v15 = ((MotionPaths)v2).time;
            }

            if(v13 != null) {
                if(Float.isNaN(v15)) {
                    v15 = 1f;
                }

                v15 -= v16;
                v11 = ((double)((((float)v13.get(((double)((v10 - v16) / v15))))) * v15 + v16));
            }

            v0.mSpline[0].getPos(v11, v0.mInterpolateData);
            v0.mStartMotionPath.getCenter(v0.mInterpolateVariables, v0.mInterpolateData, v1, 0);
            if(v8 > 0) {
                v9 = ((float)((((double)v9)) + Math.hypot(v6 - (((double)v1[1])), v3 - (((double)v1[0])))));
            }

            v3 = ((double)v1[0]);
            v6 = ((double)v1[1]);
            ++v8;
        }

        return v9;
    }

    float getStartX() {
        return this.mStartMotionPath.x;
    }

    float getStartY() {
        return this.mStartMotionPath.y;
    }

    public int getkeyFramePositions(int[] arg9, float[] arg10) {
        Iterator v0 = this.mKeyList.iterator();
        int v2 = 0;
        int v3 = 0;
        while(v0.hasNext()) {
            Object v4 = v0.next();
            arg9[v2] = ((Key)v4).mFramePosition + ((Key)v4).mType * 1000;
            this.mSpline[0].getPos(((double)((((float)((Key)v4).mFramePosition)) / 100f)), this.mInterpolateData);
            this.mStartMotionPath.getCenter(this.mInterpolateVariables, this.mInterpolateData, arg10, v3);
            v3 += 2;
            ++v2;
        }

        return v2;
    }

    private void insertKey(MotionPaths arg4) {
        int v0 = Collections.binarySearch(this.mMotionPaths, arg4);
        if(v0 == 0) {
            Log.e("MotionController", " KeyPath positon \"" + arg4.position + "\" outside of range");
        }

        this.mMotionPaths.add(-v0 - 1, arg4);
    }

    boolean interpolate(View arg17, float arg18, long arg19, KeyCache arg21) {
        float v4_3;
        HashMap v1_4;
        int v12;
        Object v1_1;
        Object v8;
        MotionController v0 = this;
        View v2 = arg17;
        float[] v1 = null;
        float v3 = v0.getAdjustedPosition(arg18, v1);
        HashMap v4 = v0.mAttributesMap;
        if(v4 != null) {
            Iterator v4_1 = v4.values().iterator();
            while(v4_1.hasNext()) {
                v4_1.next().setProperty(v2, v3);
            }
        }

        v4 = v0.mTimeCycleAttributesMap;
        if(v4 != null) {
            Iterator v7 = v4.values().iterator();
            v8 = v1;
            int v9 = 0;
            while(v7.hasNext()) {
                v1_1 = v7.next();
                if((v1_1 instanceof PathRotate)) {
                    v8 = v1_1;
                }
                else {
                    v9 |= ((TimeCycleSplineSet)v1_1).setProperty(v2, v3, arg19, arg21);
                    v2 = arg17;
                }
            }

            v12 = v9;
        }
        else {
            v8 = v1;
            v12 = 0;
        }

        float v10 = v3;
        CurveFit[] v1_2 = v0.mSpline;
        if(v1_2 != null) {
            double v14 = ((double)v10);
            v1_2[0].getPos(v14, v0.mInterpolateData);
            v0.mSpline[0].getSlope(v14, v0.mInterpolateVelocity);
            CurveFit v1_3 = v0.mArcSpline;
            if(v1_3 != null) {
                double[] v2_1 = v0.mInterpolateData;
                if(v2_1.length > 0) {
                    v1_3.getPos(v14, v2_1);
                    v0.mArcSpline.getSlope(v14, v0.mInterpolateVelocity);
                }
            }

            v0.mStartMotionPath.setView(arg17, v0.mInterpolateVariables, v0.mInterpolateData, v0.mInterpolateVelocity, null);
            v1_4 = v0.mAttributesMap;
            if(v1_4 != null) {
                Iterator v9_1 = v1_4.values().iterator();
                while(v9_1.hasNext()) {
                    v1_1 = v9_1.next();
                    if((v1_1 instanceof androidx.constraintlayout.motion.widget.SplineSet$PathRotate)) {
                        v3 = v10;
                        ((androidx.constraintlayout.motion.widget.SplineSet$PathRotate)v1_1).setPathRotate(arg17, v3, v0.mInterpolateVelocity[0], v0.mInterpolateVelocity[1]);
                    }
                    else {
                        v3 = v10;
                    }

                    v10 = v3;
                }
            }

            v3 = v10;
            if(v8 != null) {
                double[] v1_5 = v0.mInterpolateVelocity;
                double v4_2 = v1_5[0];
                double v9_2 = v1_5[1];
                v2 = arg17;
                v1_1 = v8;
                double v7_1 = v4_2;
                v4_3 = v3;
                v3 = v4_3;
                v12 |= ((PathRotate)v1_1).setPathRotate(v2, arg21, v4_3, arg19, v7_1, v9_2);
            }
            else {
                v2 = arg17;
            }

            int v1_6;
            for(v1_6 = 1; true; ++v1_6) {
                CurveFit[] v4_4 = v0.mSpline;
                if(v1_6 >= v4_4.length) {
                    break;
                }

                v4_4[v1_6].getPos(v14, v0.mValuesBuff);
                v0.mStartMotionPath.attributes.get(v0.mAttributeNames[v1_6 - 1]).setInterpolatedValue(v2, v0.mValuesBuff);
            }

            if(v0.mStartPoint.mVisibilityMode == 0) {
                if(v3 <= 0f) {
                    v2.setVisibility(v0.mStartPoint.visibility);
                }
                else {
                    v1_6 = Float.compare(v3, 1f);
                    MotionConstrainedPoint v4_5 = v0.mEndPoint;
                    if(v1_6 >= 0) {
                        v2.setVisibility(v4_5.visibility);
                    }
                    else if(v4_5.visibility != v0.mStartPoint.visibility) {
                        v2.setVisibility(0);
                    }
                }
            }

            if(v0.mKeyTriggers == null) {
                goto label_215;
            }

            for(v1_6 = 0; true; ++v1_6) {
                KeyTrigger[] v4_6 = v0.mKeyTriggers;
                if(v1_6 >= v4_6.length) {
                    break;
                }

                v4_6[v1_6].conditionallyFire(v3, v2);
            }
        }
        else {
            v2 = arg17;
            v3 = v10;
            float v1_7 = v0.mStartMotionPath.x + (v0.mEndMotionPath.x - v0.mStartMotionPath.x) * v3 + 0.5f;
            int v8_1 = ((int)v1_7);
            v4_3 = v0.mStartMotionPath.y + (v0.mEndMotionPath.y - v0.mStartMotionPath.y) * v3 + 0.5f;
            int v7_2 = ((int)v4_3);
            v1_6 = ((int)(v1_7 + (v0.mStartMotionPath.width + (v0.mEndMotionPath.width - v0.mStartMotionPath.width) * v3)));
            int v4_7 = ((int)(v4_3 + (v0.mStartMotionPath.height + (v0.mEndMotionPath.height - v0.mStartMotionPath.height) * v3)));
            int v5 = v1_6 - v8_1;
            int v6 = v4_7 - v7_2;
            if(v0.mEndMotionPath.width != v0.mStartMotionPath.width || v0.mEndMotionPath.height != v0.mStartMotionPath.height) {
                v2.measure(View$MeasureSpec.makeMeasureSpec(v5, 0x40000000), View$MeasureSpec.makeMeasureSpec(v6, 0x40000000));
            }

            v2.layout(v8_1, v7_2, v1_6, v4_7);
        }

    label_215:
        v1_4 = v0.mCycleMap;
        if(v1_4 != null) {
            Iterator v8_2 = v1_4.values().iterator();
            while(v8_2.hasNext()) {
                v1_1 = v8_2.next();
                if((v1_1 instanceof PathRotateSet)) {
                    ((PathRotateSet)v1_1).setPathRotate(v2, v3, v0.mInterpolateVelocity[0], v0.mInterpolateVelocity[1]);
                }
                else {
                    ((KeyCycleOscillator)v1_1).setProperty(v2, v3);
                }
            }
        }

        return ((boolean)v12);
    }

    String name() {
        return this.mView.getContext().getResources().getResourceEntryName(this.mView.getId());
    }

    void positionKeyframe(View arg9, KeyPositionBase arg10, float arg11, float arg12, String[] arg13, float[] arg14) {
        RectF v2 = new RectF();
        v2.left = this.mStartMotionPath.x;
        v2.top = this.mStartMotionPath.y;
        v2.right = v2.left + this.mStartMotionPath.width;
        v2.bottom = v2.top + this.mStartMotionPath.height;
        RectF v3 = new RectF();
        v3.left = this.mEndMotionPath.x;
        v3.top = this.mEndMotionPath.y;
        v3.right = v3.left + this.mEndMotionPath.width;
        v3.bottom = v3.top + this.mEndMotionPath.height;
        arg10.positionAttributes(arg9, v2, v3, arg11, arg12, arg13, arg14);
    }

    private void readView(MotionPaths arg4) {
        arg4.setBounds(((float)(((int)this.mView.getX()))), ((float)(((int)this.mView.getY()))), ((float)this.mView.getWidth()), ((float)this.mView.getHeight()));
    }

    public void setDrawPath(int arg1) {
        this.mStartMotionPath.mDrawPath = arg1;
    }

    void setEndState(ConstraintWidget arg6, ConstraintSet arg7) {
        this.mEndMotionPath.time = 1f;
        this.mEndMotionPath.position = 1f;
        this.readView(this.mEndMotionPath);
        this.mEndMotionPath.setBounds(((float)arg6.getX()), ((float)arg6.getY()), ((float)arg6.getWidth()), ((float)arg6.getHeight()));
        this.mEndMotionPath.applyParameters(arg7.getParameters(this.mId));
        this.mEndPoint.setState(arg6, arg7, this.mId);
    }

    public void setPathMotionArc(int arg1) {
        this.mPathMotionArc = arg1;
    }

    void setStartCurrentState(View arg6) {
        this.mStartMotionPath.time = 0f;
        this.mStartMotionPath.position = 0f;
        this.mStartMotionPath.setBounds(arg6.getX(), arg6.getY(), ((float)arg6.getWidth()), ((float)arg6.getHeight()));
        this.mStartPoint.setState(arg6);
    }

    void setStartState(ConstraintWidget arg6, ConstraintSet arg7) {
        this.mStartMotionPath.time = 0f;
        this.mStartMotionPath.position = 0f;
        this.readView(this.mStartMotionPath);
        this.mStartMotionPath.setBounds(((float)arg6.getX()), ((float)arg6.getY()), ((float)arg6.getWidth()), ((float)arg6.getHeight()));
        Constraint v0 = arg7.getParameters(this.mId);
        this.mStartMotionPath.applyParameters(v0);
        this.mMotionStagger = v0.motion.mMotionStagger;
        this.mStartPoint.setState(arg6, arg7, this.mId);
    }

    public void setView(View arg2) {
        this.mView = arg2;
        this.mId = arg2.getId();
        ViewGroup$LayoutParams v2 = arg2.getLayoutParams();
        if((v2 instanceof LayoutParams)) {
            this.mConstraintTag = ((LayoutParams)v2).getConstraintTag();
        }
    }

    public void setup(int arg17, int arg18, float arg19, long arg20) {
        Object v3_1;
        Object v14_1;
        int v7_5;
        TimeCycleSplineSet v7_4;
        Iterator v12_1;
        String v11_2;
        SparseArray v7_3;
        Iterator v1_1;
        int v11_1;
        Object v7_2;
        Iterator v6_3;
        double[] v19;
        SplineSet v6_1;
        Object v6;
        Iterator v7_1;
        Object v13;
        Object v8;
        ArrayList v7;
        MotionController v0 = this;
        new HashSet();
        HashSet v1 = new HashSet();
        HashSet v2 = new HashSet();
        HashSet v3 = new HashSet();
        HashMap v4 = new HashMap();
        if(v0.mPathMotionArc != Key.UNSET) {
            v0.mStartMotionPath.mPathMotionArc = v0.mPathMotionArc;
        }

        v0.mStartPoint.different(v0.mEndPoint, v2);
        ArrayList v5 = v0.mKeyList;
        if(v5 != null) {
            Iterator v5_1 = v5.iterator();
            v7 = null;
            while(v5_1.hasNext()) {
                v8 = v5_1.next();
                if((v8 instanceof KeyPosition)) {
                    v13 = v8;
                    v0.insertKey(new MotionPaths(arg17, arg18, ((KeyPosition)v13), v0.mStartMotionPath, v0.mEndMotionPath));
                    if(((KeyPosition)v13).mCurveFit == Key.UNSET) {
                        continue;
                    }

                    v0.mCurveFitType = ((KeyPosition)v13).mCurveFit;
                }
                else if((v8 instanceof KeyCycle)) {
                    ((Key)v8).getAttributeNames(v3);
                }
                else if((v8 instanceof KeyTimeCycle)) {
                    ((Key)v8).getAttributeNames(v1);
                }
                else if((v8 instanceof KeyTrigger)) {
                    if(v7 == null) {
                        v7 = new ArrayList();
                    }

                    v7.add(v8);
                }
                else {
                    ((Key)v8).setInterpolation(v4);
                    ((Key)v8).getAttributeNames(v2);
                }
            }
        }
        else {
            v7 = null;
        }

        if(v7 != null) {
            v0.mKeyTriggers = v7.toArray(new KeyTrigger[0]);
        }

        String v8_1 = ",";
        String v9 = "CUSTOM,";
        int v10 = 1;
        if(!v2.isEmpty()) {
            v0.mAttributesMap = new HashMap();
            v7_1 = v2.iterator();
            while(v7_1.hasNext()) {
                Object v11 = v7_1.next();
                if(((String)v11).startsWith(v9)) {
                    SparseArray v12 = new SparseArray();
                    String v13_1 = ((String)v11).split(v8_1)[1];
                    Iterator v14 = v0.mKeyList.iterator();
                    while(v14.hasNext()) {
                        Object v15 = v14.next();
                        if(((Key)v15).mCustomConstraints == null) {
                        }
                        else {
                            v6 = ((Key)v15).mCustomConstraints.get(v13_1);
                            if(v6 == null) {
                                continue;
                            }

                            v12.append(((Key)v15).mFramePosition, v6);
                        }
                    }

                    v6_1 = SplineSet.makeCustomSpline(((String)v11), v12);
                }
                else {
                    v6_1 = SplineSet.makeSpline(((String)v11));
                }

                if(v6_1 == null) {
                    continue;
                }

                v6_1.setType(((String)v11));
                v0.mAttributesMap.put(v11, v6_1);
            }

            v19 = null;
            ArrayList v6_2 = v0.mKeyList;
            if(v6_2 != null) {
                v6_3 = v6_2.iterator();
                while(v6_3.hasNext()) {
                    v7_2 = v6_3.next();
                    if(!(v7_2 instanceof KeyAttributes)) {
                        continue;
                    }

                    ((Key)v7_2).addValues(v0.mAttributesMap);
                }
            }

            v0.mStartPoint.addValues(v0.mAttributesMap, 0);
            v0.mEndPoint.addValues(v0.mAttributesMap, 100);
            v6_3 = v0.mAttributesMap.keySet().iterator();
            while(v6_3.hasNext()) {
                v7_2 = v6_3.next();
                v11_1 = v4.containsKey(v7_2) ? v4.get(v7_2).intValue() : 0;
                v0.mAttributesMap.get(v7_2).setup(v11_1);
            }
        }
        else {
            v19 = null;
        }

        if(!v1.isEmpty()) {
            if(v0.mTimeCycleAttributesMap == null) {
                v0.mTimeCycleAttributesMap = new HashMap();
            }

            v1_1 = v1.iterator();
            while(true) {
            label_155:
                if(!v1_1.hasNext()) {
                    goto label_193;
                }

                v6 = v1_1.next();
                if(!v0.mTimeCycleAttributesMap.containsKey(v6)) {
                    break;
                }
            }

            if(((String)v6).startsWith(v9)) {
                v7_3 = new SparseArray();
                v11_2 = ((String)v6).split(v8_1)[1];
                v12_1 = v0.mKeyList.iterator();
                goto label_170;
            }
            else {
                v7_4 = TimeCycleSplineSet.makeSpline(((String)v6), arg20);
                goto label_187;
            label_193:
                ArrayList v1_2 = v0.mKeyList;
                if(v1_2 != null) {
                    v1_1 = v1_2.iterator();
                    while(v1_1.hasNext()) {
                        v6 = v1_1.next();
                        if(!(v6 instanceof KeyTimeCycle)) {
                            continue;
                        }

                        ((KeyTimeCycle)v6).addTimeValues(v0.mTimeCycleAttributesMap);
                    }
                }

                v1_1 = v0.mTimeCycleAttributesMap.keySet().iterator();
                while(true) {
                    if(!v1_1.hasNext()) {
                        goto label_220;
                    }

                    v6 = v1_1.next();
                    v7_5 = v4.containsKey(v6) ? v4.get(v6).intValue() : 0;
                    v0.mTimeCycleAttributesMap.get(v6).setup(v7_5);
                }

            label_170:
                while(v12_1.hasNext()) {
                    v13 = v12_1.next();
                    if(((Key)v13).mCustomConstraints == null) {
                        continue;
                    }

                    v14_1 = ((Key)v13).mCustomConstraints.get(v11_2);
                    if(v14_1 == null) {
                        continue;
                    }

                    v7_3.append(((Key)v13).mFramePosition, v14_1);
                }

                v7_4 = TimeCycleSplineSet.makeCustomSpline(((String)v6), v7_3);
            }

        label_187:
            if(v7_4 == null) {
                goto label_155;
            }

            v7_4.setType(((String)v6));
            v0.mTimeCycleAttributesMap.put(v6, v7_4);
            goto label_155;
        }

    label_220:
        int v1_3 = v0.mMotionPaths.size();
        int v4_1 = v1_3 + 2;
        MotionPaths[] v6_4 = new MotionPaths[v4_1];
        v6_4[0] = v0.mStartMotionPath;
        v6_4[v1_3 + 1] = v0.mEndMotionPath;
        if(v0.mMotionPaths.size() > 0 && v0.mCurveFitType == -1) {
            v0.mCurveFitType = 0;
        }

        v1_1 = v0.mMotionPaths.iterator();
        for(v7_5 = 1; v1_1.hasNext(); ++v7_5) {
            v6_4[v7_5] = v1_1.next();
        }

        v1 = new HashSet();
        v7_1 = v0.mEndMotionPath.attributes.keySet().iterator();
        while(v7_1.hasNext()) {
            v8 = v7_1.next();
            if(!v0.mStartMotionPath.attributes.containsKey(v8)) {
                continue;
            }

            if(v2.contains(v9 + (((String)v8)))) {
                continue;
            }

            v1.add(v8);
        }

        Object[] v1_4 = v1.toArray(new String[0]);
        v0.mAttributeNames = ((String[])v1_4);
        v0.mAttributeInterpCount = new int[v1_4.length];
        for(v1_3 = 0; true; ++v1_3) {
            String[] v2_1 = v0.mAttributeNames;
            if(v1_3 >= v2_1.length) {
                break;
            }

            String v2_2 = v2_1[v1_3];
            v0.mAttributeInterpCount[v1_3] = 0;
            v7_5 = 0;
            while(v7_5 < v4_1) {
                if(v6_4[v7_5].attributes.containsKey(v2_2)) {
                    v0.mAttributeInterpCount[v1_3] += v6_4[v7_5].attributes.get(v2_2).noOfInterpValues();
                }
                else {
                    ++v7_5;
                    continue;
                }

                break;
            }
        }

        boolean v1_5 = v6_4[0].mPathMotionArc != Key.UNSET ? true : false;
        v7_5 = 18 + v0.mAttributeNames.length;
        boolean[] v2_3 = new boolean[v7_5];
        int v8_2;
        for(v8_2 = 1; v8_2 < v4_1; ++v8_2) {
            v6_4[v8_2].different(v6_4[v8_2 - 1], v2_3, v0.mAttributeNames, v1_5);
        }

        v8_2 = 0;
        for(v1_3 = 1; v1_3 < v7_5; ++v1_3) {
            if(v2_3[v1_3]) {
                ++v8_2;
            }
        }

        int[] v1_6 = new int[v8_2];
        v0.mInterpolateVariables = v1_6;
        v0.mInterpolateData = new double[v1_6.length];
        v0.mInterpolateVelocity = new double[v1_6.length];
        v8_2 = 0;
        for(v1_3 = 1; v1_3 < v7_5; ++v1_3) {
            if(v2_3[v1_3]) {
                v0.mInterpolateVariables[v8_2] = v1_3;
                ++v8_2;
            }
        }

        v1_3 = v0.mInterpolateVariables.length;
        int v2_4 = 2;
        int[] v7_6 = new int[v2_4];
        v7_6[1] = v1_3;
        v7_6[0] = v4_1;
        Object v1_7 = Array.newInstance(Double.TYPE, v7_6);
        double[] v7_7 = new double[v4_1];
        for(v8_2 = 0; v8_2 < v4_1; ++v8_2) {
            v6_4[v8_2].fillStandard(v1_7[v8_2], v0.mInterpolateVariables);
            v7_7[v8_2] = ((double)v6_4[v8_2].time);
        }

        for(v8_2 = 0; true; ++v8_2) {
            int[] v9_1 = v0.mInterpolateVariables;
            if(v8_2 >= v9_1.length) {
                break;
            }

            if(v9_1[v8_2] < MotionPaths.names.length) {
                v9 = MotionPaths.names[v0.mInterpolateVariables[v8_2]] + " [";
                for(v11_1 = 0; v11_1 < v4_1; ++v11_1) {
                    v9 = v9 + v1_7[v11_1][v8_2];
                }
            }
        }

        v0.mSpline = new CurveFit[v0.mAttributeNames.length + 1];
        v8_2 = 0;
        while(true) {
            String[] v9_2 = v0.mAttributeNames;
            if(v8_2 >= v9_2.length) {
                break;
            }

            v9 = v9_2[v8_2];
            double[] v12_2 = v19;
            v14_1 = v12_2;
            v11_1 = 0;
            int v13_2 = 0;
            while(v11_1 < v4_1) {
                if(v6_4[v11_1].hasCustomData(v9)) {
                    if(v14_1 == null) {
                        v12_2 = new double[v4_1];
                        int v14_2 = v6_4[v11_1].getCustomDataCount(v9);
                        int[] v15_1 = new int[v2_4];
                        v15_1[v10] = v14_2;
                        v15_1[0] = v4_1;
                        v14_1 = Array.newInstance(Double.TYPE, v15_1);
                    }

                    arg17 = v10;
                    arg18 = v11_1;
                    v12_2[v13_2] = ((double)v6_4[v11_1].time);
                    v6_4[arg18].getCustomData(v9, v14_1[v13_2], 0);
                    ++v13_2;
                }
                else {
                    arg17 = v10;
                    arg18 = v11_1;
                }

                v11_1 = arg18 + 1;
                v10 = arg17;
            }

            ++v8_2;
            v0.mSpline[v8_2] = CurveFit.get(v0.mCurveFitType, Arrays.copyOf(v12_2, v13_2), Arrays.copyOf(((Object[])v14_1), v13_2));
            v10 = v10;
        }

        arg17 = v10;
        v0.mSpline[0] = CurveFit.get(v0.mCurveFitType, v7_7, ((double[][])v1_7));
        if(v6_4[0].mPathMotionArc != Key.UNSET) {
            v1_6 = new int[v4_1];
            v7_7 = new double[v4_1];
            int[] v8_3 = new int[v2_4];
            v8_3[arg17] = v2_4;
            v8_3[0] = v4_1;
            Object v2_5 = Array.newInstance(Double.TYPE, v8_3);
            for(v8_2 = 0; v8_2 < v4_1; ++v8_2) {
                v1_6[v8_2] = v6_4[v8_2].mPathMotionArc;
                v7_7[v8_2] = ((double)v6_4[v8_2].time);
                v2_5[v8_2][0] = ((double)v6_4[v8_2].x);
                v2_5[v8_2][arg17] = ((double)v6_4[v8_2].y);
            }

            v0.mArcSpline = CurveFit.getArc(v1_6, v7_7, ((double[][])v2_5));
        }

        v0.mCycleMap = new HashMap();
        if(v0.mKeyList != null) {
            v1_1 = v3.iterator();
            float v2_6 = NaNf;
            while(v1_1.hasNext()) {
                v3_1 = v1_1.next();
                KeyCycleOscillator v4_2 = KeyCycleOscillator.makeSpline(((String)v3_1));
                if(v4_2 == null) {
                }
                else {
                    if((v4_2.variesByPath()) && (Float.isNaN(v2_6))) {
                        v2_6 = v0.getPreCycleDistance();
                    }

                    v4_2.setType(((String)v3_1));
                    v0.mCycleMap.put(v3_1, v4_2);
                }
            }

            v1_1 = v0.mKeyList.iterator();
            while(v1_1.hasNext()) {
                v3_1 = v1_1.next();
                if(!(v3_1 instanceof KeyCycle)) {
                    continue;
                }

                ((KeyCycle)v3_1).addCycleValues(v0.mCycleMap);
            }

            Iterator v0_1 = v0.mCycleMap.values().iterator();
            while(v0_1.hasNext()) {
                v0_1.next().setup(v2_6);
            }
        }
    }

    public String toString() {
        return " start: x: " + this.mStartMotionPath.x + " y: " + this.mStartMotionPath.y + " end: x: " + this.mEndMotionPath.x + " y: " + this.mEndMotionPath.y;
    }
}

