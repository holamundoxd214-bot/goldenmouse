package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;

public abstract class TimeCycleSplineSet {
    class AlphaSet extends TimeCycleSplineSet {
        AlphaSet() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setAlpha(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    class CustomSet extends TimeCycleSplineSet {
        String mAttributeName;
        float[] mCache;
        SparseArray mConstraintAttributeList;
        float[] mTempValues;
        SparseArray mWaveProperties;

        public CustomSet(String arg2, SparseArray arg3) {
            super();
            this.mWaveProperties = new SparseArray();
            this.mAttributeName = arg2.split(",")[1];
            this.mConstraintAttributeList = arg3;
        }

        public void setPoint(int arg3, ConstraintAttribute arg4, float arg5, int arg6, float arg7) {
            this.mConstraintAttributeList.append(arg3, arg4);
            this.mWaveProperties.append(arg3, new float[]{arg5, arg7});
            this.mWaveShape = Math.max(this.mWaveShape, arg6);
        }

        public void setPoint(int arg1, float arg2, float arg3, int arg4, float arg5) {
            throw new RuntimeException("don\'t call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        public boolean setProperty(View arg9, float arg10, long arg11, KeyCache arg13) {
            this.mCurveFit.getPos(((double)arg10), this.mTempValues);
            float[] v10 = this.mTempValues;
            float v13 = v10[v10.length - 2];
            arg10 = v10[v10.length - 1];
            this.last_cycle = ((float)(((((double)this.last_cycle)) + (((double)(arg11 - this.last_time))) * 1.000000E-09 * (((double)v13))) % 1));
            this.last_time = arg11;
            float v11 = this.calcWave(this.last_cycle);
            this.mContinue = false;
            int v0;
            for(v0 = 0; v0 < this.mCache.length; ++v0) {
                boolean v2 = this.mContinue;
                int v3 = (((double)this.mTempValues[v0])) != 0 ? 1 : 0;
                this.mContinue = (((int)v2)) | v3;
                this.mCache[v0] = this.mTempValues[v0] * v11 + arg10;
            }

            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(arg9, this.mCache);
            if(v13 != 0f) {
                this.mContinue = true;
            }

            return this.mContinue;
        }

        public void setup(int arg15) {
            int v0 = this.mConstraintAttributeList.size();
            int v1 = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] v3 = new double[v0];
            int v4 = v1 + 2;
            this.mTempValues = new float[v4];
            this.mCache = new float[v1];
            int[] v5 = new int[2];
            v5[1] = v4;
            v5[0] = v0;
            Object v4_1 = Array.newInstance(Double.TYPE, v5);
            int v5_1;
            for(v5_1 = 0; v5_1 < v0; ++v5_1) {
                int v7 = this.mConstraintAttributeList.keyAt(v5_1);
                Object v8 = this.mConstraintAttributeList.valueAt(v5_1);
                Object v9 = this.mWaveProperties.valueAt(v5_1);
                v3[v5_1] = (((double)v7)) * 0.01;
                ((ConstraintAttribute)v8).getValuesToInterpolate(this.mTempValues);
                for(v7 = 0; true; ++v7) {
                    float[] v8_1 = this.mTempValues;
                    if(v7 >= v8_1.length) {
                        break;
                    }

                    v4_1[v5_1][v7] = ((double)v8_1[v7]);
                }

                Object v7_1 = v4_1[v5_1];
                v7_1[v1] = ((double)v9[0]);
                v7_1[v1 + 1] = ((double)v9[1]);
            }

            this.mCurveFit = CurveFit.get(arg15, v3, ((double[][])v4_1));
        }
    }

    class ElevationSet extends TimeCycleSplineSet {
        ElevationSet() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setElevation(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    class PathRotate extends TimeCycleSplineSet {
        PathRotate() {
            super();
        }

        public boolean setPathRotate(View arg3, KeyCache arg4, float arg5, long arg6, double arg8, double arg10) {
            arg3.setRotation(this.get(arg5, arg6, arg3, arg4) + (((float)Math.toDegrees(Math.atan2(arg10, arg8)))));
            return this.mContinue;
        }

        public boolean setProperty(View arg1, float arg2, long arg3, KeyCache arg5) {
            return this.mContinue;
        }
    }

    class ProgressSet extends TimeCycleSplineSet {
        boolean mNoMethod;

        ProgressSet() {
            super();
            this.mNoMethod = false;
        }

        public boolean setProperty(View arg11, float arg12, long arg13, KeyCache arg15) {
            Method v0;
            String v1 = "unable to setProgress";
            String v2 = "SplineSet";
            if((arg11 instanceof MotionLayout)) {
                arg11.setProgress(this.get(arg12, arg13, arg11, arg15));
                goto label_43;
            }

            long v8 = arg13;
            View v14 = arg11;
            float v11 = arg12;
            long v12 = v8;
            if(this.mNoMethod) {
                return 0;
            }

            try {
                v0 = v14.getClass().getMethod("setProgress", Float.TYPE);
            }
            catch(NoSuchMethodException ) {
                this.mNoMethod = ((boolean)v0);
                v0 = null;
            }

            if(v0 != null) {
                try {
                    v0.invoke(v14, Float.valueOf(this.get(v11, v12, v14, arg15)));
                }
                catch(InvocationTargetException v0_1) {
                    Log.e(v2, v1, v0_1);
                }
                catch(IllegalAccessException v0_2) {
                    Log.e(v2, v1, v0_2);
                }
            }

        label_43:
            return this.mContinue;
        }
    }

    class RotationSet extends TimeCycleSplineSet {
        RotationSet() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setRotation(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    class RotationXset extends TimeCycleSplineSet {
        RotationXset() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setRotationX(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    class RotationYset extends TimeCycleSplineSet {
        RotationYset() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setRotationY(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    class ScaleXset extends TimeCycleSplineSet {
        ScaleXset() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setScaleX(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    class ScaleYset extends TimeCycleSplineSet {
        ScaleYset() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setScaleY(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    class Sort {
        private Sort() {
            super();
        }

        static void doubleQuickSort(int[] arg7, float[][] arg8, int arg9, int arg10) {
            int[] v0 = new int[arg7.length + 10];
            v0[0] = arg10;
            v0[1] = arg9;
            for(arg9 = 2; arg9 > 0; arg9 = v2) {
                int v1 = v0[arg9 - 1];
                int v2 = arg9 - 2;
                int v3 = v0[v2];
                if(v1 < v3) {
                    int v4 = Sort.partition(arg7, arg8, v1, v3);
                    v0[v2] = v4 - 1;
                    v0[arg9 - 1] = v1;
                    v1 = arg9 + 1;
                    v0[arg9] = v3;
                    arg9 += 2;
                    v0[v1] = v4 + 1;
                    continue;
                }
            }
        }

        private static int partition(int[] arg3, float[][] arg4, int arg5, int arg6) {
            int v0 = arg3[arg6];
            int v1 = arg5;
            while(arg5 < arg6) {
                if(arg3[arg5] <= v0) {
                    Sort.swap(arg3, arg4, v1, arg5);
                    ++v1;
                }

                ++arg5;
            }

            Sort.swap(arg3, arg4, v1, arg6);
            return v1;
        }

        private static void swap(int[] arg2, float[][] arg3, int arg4, int arg5) {
            int v0 = arg2[arg4];
            arg2[arg4] = arg2[arg5];
            arg2[arg5] = v0;
            float[] v2 = arg3[arg4];
            arg3[arg4] = arg3[arg5];
            arg3[arg5] = v2;
        }
    }

    class TranslationXset extends TimeCycleSplineSet {
        TranslationXset() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setTranslationX(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    class TranslationYset extends TimeCycleSplineSet {
        TranslationYset() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setTranslationY(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    class TranslationZset extends TimeCycleSplineSet {
        TranslationZset() {
            super();
        }

        public boolean setProperty(View arg3, float arg4, long arg5, KeyCache arg7) {
            arg3.setTranslationZ(this.get(arg4, arg5, arg3, arg7));
            return this.mContinue;
        }
    }

    private static final int CURVE_OFFSET = 2;
    private static final int CURVE_PERIOD = 1;
    private static final int CURVE_VALUE = 0;
    private static final String TAG = "SplineSet";
    private static float VAL_2PI = 6.283185f;
    private int count;
    float last_cycle;
    long last_time;
    private float[] mCache;
    protected boolean mContinue;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    private String mType;
    protected float[][] mValues;
    protected int mWaveShape;

    static {
    }

    public TimeCycleSplineSet() {
        super();
        this.mWaveShape = 0;
        this.mTimePoints = new int[10];
        int[] v2 = new int[2];
        v2[1] = 3;
        v2[0] = 10;
        this.mValues = Array.newInstance(Float.TYPE, v2);
        this.mCache = new float[3];
        this.mContinue = false;
        this.last_cycle = NaNf;
    }

    protected float calcWave(float arg3) {
        float v0 = 2f;
        float v1 = 1f;
        switch(this.mWaveShape) {
            case 1: {
                goto label_38;
            }
            case 2: {
                goto label_35;
            }
            case 3: {
                goto label_30;
            }
            case 4: {
                goto label_25;
            }
            case 5: {
                goto label_19;
            }
            case 6: {
                goto label_10;
            }
        }

        return ((float)Math.sin(((double)(arg3 * TimeCycleSplineSet.VAL_2PI))));
    label_35:
        return v1 - Math.abs(arg3);
    label_19:
        return ((float)Math.cos(((double)(arg3 * TimeCycleSplineSet.VAL_2PI))));
    label_38:
        return Math.signum(arg3 * TimeCycleSplineSet.VAL_2PI);
    label_25:
        return v1 - (arg3 * v0 + v1) % v0;
    label_10:
        float v2 = v1 - Math.abs(arg3 * 4f % 4f - v0);
        return v1 - v2 * v2;
    label_30:
        return (arg3 * v0 + v1) % v0 - v1;
    }

    public float get(float arg19, long arg20, View arg22, KeyCache arg23) {
        float v5_1;
        TimeCycleSplineSet v0 = this;
        long v1 = arg20;
        View v3 = arg22;
        KeyCache v4 = arg23;
        v0.mCurveFit.getPos(((double)arg19), v0.mCache);
        float[] v5 = v0.mCache;
        float v7 = v5[1];
        int v9 = Float.compare(v7, 0f);
        int v10 = 2;
        if(v9 == 0) {
            v0.mContinue = false;
            return v5[v10];
        }

        if(Float.isNaN(v0.last_cycle)) {
            v5_1 = v4.getFloatValue(v3, v0.mType, 0);
            v0.last_cycle = v5_1;
            if(Float.isNaN(v5_1)) {
                v0.last_cycle = 0f;
            }
        }

        v5_1 = ((float)(((((double)v0.last_cycle)) + (((double)(v1 - v0.last_time))) * 1.000000E-09 * (((double)v7))) % 1));
        v0.last_cycle = v5_1;
        v4.setFloatValue(v3, v0.mType, 0, v5_1);
        v0.last_time = v1;
        float v1_1 = v0.mCache[0];
        float v2 = v0.calcWave(v0.last_cycle) * v1_1 + v0.mCache[v10];
        boolean v6 = v1_1 != 0f || v9 != 0 ? true : false;
        v0.mContinue = v6;
        return v2;
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    static TimeCycleSplineSet makeCustomSpline(String arg1, SparseArray arg2) {
        return new CustomSet(arg1, arg2);
    }

    static TimeCycleSplineSet makeSpline(String arg2, long arg3) {
        arg2.hashCode();
        int v1 = -1;
        switch(arg2.hashCode()) {
            case -1249320806: {
                if(!arg2.equals("rotationX")) {
                    goto label_76;
                }

                v1 = 0;
                break;
            }
            case -1249320805: {
                if(!arg2.equals("rotationY")) {
                    goto label_76;
                }

                v1 = 1;
                break;
            }
            case -1225497657: {
                if(!arg2.equals("translationX")) {
                    goto label_76;
                }

                v1 = 2;
                break;
            }
            case -1225497656: {
                if(!arg2.equals("translationY")) {
                    goto label_76;
                }

                v1 = 3;
                break;
            }
            case -1225497655: {
                if(!arg2.equals("translationZ")) {
                    goto label_76;
                }

                v1 = 4;
                break;
            }
            case -1001078227: {
                if(!arg2.equals("progress")) {
                    goto label_76;
                }

                v1 = 5;
                break;
            }
            case -908189618: {
                if(!arg2.equals("scaleX")) {
                    goto label_76;
                }

                v1 = 6;
                break;
            }
            case -908189617: {
                if(!arg2.equals("scaleY")) {
                    goto label_76;
                }

                v1 = 7;
                break;
            }
            case -40300674: {
                if(!arg2.equals("rotation")) {
                    goto label_76;
                }

                v1 = 8;
                break;
            }
            case -4379043: {
                if(!arg2.equals("elevation")) {
                    goto label_76;
                }

                v1 = 9;
                break;
            }
            case 37232917: {
                if(!arg2.equals("transitionPathRotate")) {
                    goto label_76;
                }

                v1 = 10;
                break;
            }
            case 92909918: {
                if(!arg2.equals("alpha")) {
                    goto label_76;
                }

                v1 = 11;
                break;
            }
            default: {
                break;
            }
        }

    label_76:
        switch(v1) {
            case 0: {
                goto label_112;
            }
            case 1: {
                goto label_109;
            }
            case 2: {
                goto label_106;
            }
            case 3: {
                goto label_103;
            }
            case 4: {
                goto label_100;
            }
            case 5: {
                goto label_97;
            }
            case 6: {
                goto label_94;
            }
            case 7: {
                goto label_91;
            }
            case 8: {
                goto label_88;
            }
            case 9: {
                goto label_85;
            }
            case 10: {
                goto label_82;
            }
            case 11: {
                goto label_79;
            }
        }

        return null;
    label_97:
        ProgressSet v2 = new ProgressSet();
        goto label_114;
    label_100:
        TranslationZset v2_1 = new TranslationZset();
        goto label_114;
    label_103:
        TranslationYset v2_2 = new TranslationYset();
        goto label_114;
    label_106:
        TranslationXset v2_3 = new TranslationXset();
        goto label_114;
    label_109:
        RotationYset v2_4 = new RotationYset();
        goto label_114;
    label_79:
        AlphaSet v2_5 = new AlphaSet();
        goto label_114;
    label_112:
        RotationXset v2_6 = new RotationXset();
        goto label_114;
    label_82:
        PathRotate v2_7 = new PathRotate();
        goto label_114;
    label_85:
        ElevationSet v2_8 = new ElevationSet();
        goto label_114;
    label_88:
        RotationSet v2_9 = new RotationSet();
        goto label_114;
    label_91:
        ScaleYset v2_10 = new ScaleYset();
        goto label_114;
    label_94:
        ScaleXset v2_11 = new ScaleXset();
    label_114:
        ((TimeCycleSplineSet)v2_10).setStartTime(arg3);
        return ((TimeCycleSplineSet)v2_10);
    }

    public void setPoint(int arg3, float arg4, float arg5, int arg6, float arg7) {
        int[] v0 = this.mTimePoints;
        int v1 = this.count;
        v0[v1] = arg3;
        float[] v3 = this.mValues[v1];
        v3[0] = arg4;
        v3[1] = arg5;
        v3[2] = arg7;
        this.mWaveShape = Math.max(this.mWaveShape, arg6);
        ++this.count;
    }

    public abstract boolean setProperty(View arg1, float arg2, long arg3, KeyCache arg4);

    protected void setStartTime(long arg1) {
        this.last_time = arg1;
    }

    public void setType(String arg1) {
        this.mType = arg1;
    }

    public void setup(int arg12) {
        int v0 = this.count;
        if(v0 == 0) {
            Log.e("SplineSet", "Error no points added to " + this.mType);
            return;
        }

        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, v0 - 1);
        v0 = 1;
        int v1 = 0;
        while(true) {
            int[] v2 = this.mTimePoints;
            if(v0 >= v2.length) {
                break;
            }

            if(v2[v0] != v2[v0 - 1]) {
                ++v1;
            }

            ++v0;
        }

        if(v1 == 0) {
            v1 = 1;
        }

        double[] v0_1 = new double[v1];
        int v2_1 = 2;
        int[] v5 = new int[v2_1];
        v5[1] = 3;
        v5[0] = v1;
        Object v1_1 = Array.newInstance(Double.TYPE, v5);
        int v5_1 = 0;
        int v6 = 0;
        while(v5_1 < this.count) {
            if(v5_1 <= 0 || this.mTimePoints[v5_1] != this.mTimePoints[v5_1 - 1]) {
                v0_1[v6] = (((double)this.mTimePoints[v5_1])) * 0.01;
                Object v7 = v1_1[v6];
                float[] v8 = this.mValues[v5_1];
                v7[0] = ((double)v8[0]);
                v7[1] = ((double)v8[1]);
                v7[v2_1] = ((double)v8[v2_1]);
                ++v6;
            }
            else {
            }

            ++v5_1;
        }

        this.mCurveFit = CurveFit.get(arg12, v0_1, ((double[][])v1_1));
    }

    public String toString() {
        String v0 = this.mType;
        DecimalFormat v1 = new DecimalFormat("##.##");
        int v2;
        for(v2 = 0; v2 < this.count; ++v2) {
            v0 = v0 + "[" + this.mTimePoints[v2] + " , " + v1.format(this.mValues[v2]) + "] ";
        }

        return v0;
    }
}

