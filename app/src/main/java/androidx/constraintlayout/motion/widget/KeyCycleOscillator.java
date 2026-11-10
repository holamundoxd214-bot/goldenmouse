package androidx.constraintlayout.motion.widget;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.motion.utils.Oscillator;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;

public abstract class KeyCycleOscillator {
    class AlphaSet extends KeyCycleOscillator {
        AlphaSet() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setAlpha(this.get(arg2));
        }
    }

    class CustomSet extends KeyCycleOscillator {
        float[] value;

        CustomSet() {
            super();
            this.value = new float[1];
        }

        public void setProperty(View arg3, float arg4) {
            this.value[0] = this.get(arg4);
            this.mCustom.setInterpolatedValue(arg3, this.value);
        }
    }

    class CycleOscillator {
        private static final String TAG = "CycleOscillator";
        static final int UNSET = -1;
        CurveFit mCurveFit;
        public HashMap mCustomConstraints;
        float[] mOffset;
        Oscillator mOscillator;
        float mPathLength;
        float[] mPeriod;
        double[] mPosition;
        float[] mScale;
        double[] mSplineSlopeCache;
        double[] mSplineValueCache;
        float[] mValues;
        private final int mVariesBy;
        int mWaveShape;

        CycleOscillator(int arg2, int arg3, int arg4) {
            super();
            this.mOscillator = new Oscillator();
            this.mCustomConstraints = new HashMap();
            this.mWaveShape = arg2;
            this.mVariesBy = arg3;
            this.mOscillator.setType(arg2);
            this.mValues = new float[arg4];
            this.mPosition = new double[arg4];
            this.mPeriod = new float[arg4];
            this.mOffset = new float[arg4];
            this.mScale = new float[arg4];
        }

        private ConstraintAttribute get(String arg2, AttributeType arg3) {
            if(this.mCustomConstraints.containsKey(arg2)) {
                Object v1 = this.mCustomConstraints.get(arg2);
                if(((ConstraintAttribute)v1).getType() == arg3) {
                    return ((ConstraintAttribute)v1);
                }

                throw new IllegalArgumentException("ConstraintAttribute is already a " + ((ConstraintAttribute)v1).getType().name());
            }

            ConstraintAttribute v0 = new ConstraintAttribute(arg2, arg3);
            this.mCustomConstraints.put(arg2, v0);
            return v0;
        }

        public double getSlope(float arg11) {
            double v4;
            CurveFit v0 = this.mCurveFit;
            double[] v1 = this.mSplineSlopeCache;
            if(v0 != null) {
                v4 = ((double)arg11);
                v0.getSlope(v4, v1);
                this.mCurveFit.getPos(v4, this.mSplineValueCache);
            }
            else {
                v1[0] = 0;
                v1[1] = 0;
            }

            v4 = ((double)arg11);
            return this.mSplineSlopeCache[0] + this.mOscillator.getValue(v4) * this.mSplineSlopeCache[1] + this.mOscillator.getSlope(v4) * this.mSplineValueCache[1];
        }

        public double getValues(float arg8) {
            CurveFit v0 = this.mCurveFit;
            double[] v1 = this.mSplineValueCache;
            if(v0 != null) {
                v0.getPos(((double)arg8), v1);
            }
            else {
                v1[0] = ((double)this.mOffset[0]);
                v1[1] = ((double)this.mValues[0]);
            }

            return this.mSplineValueCache[0] + this.mOscillator.getValue(((double)arg8)) * this.mSplineValueCache[1];
        }

        public void setPoint(int arg6, int arg7, float arg8, float arg9, float arg10) {
            this.mPosition[arg6] = (((double)arg7)) / 100;
            this.mPeriod[arg6] = arg8;
            this.mOffset[arg6] = arg9;
            this.mValues[arg6] = arg10;
        }

        public void setup(float arg9) {
            this.mPathLength = arg9;
            int v9 = this.mPosition.length;
            int[] v1 = new int[2];
            v1[1] = 2;
            v1[0] = v9;
            Object v9_1 = Array.newInstance(Double.TYPE, v1);
            float[] v1_1 = this.mValues;
            this.mSplineValueCache = new double[v1_1.length + 1];
            this.mSplineSlopeCache = new double[v1_1.length + 1];
            double v5 = 0;
            if(this.mPosition[0] > v5) {
                this.mOscillator.addPoint(v5, this.mPeriod[0]);
            }

            double[] v1_2 = this.mPosition;
            int v3 = v1_2.length - 1;
            double v6 = 1;
            if(v1_2[v3] < v6) {
                this.mOscillator.addPoint(v6, this.mPeriod[v3]);
            }

            int v1_3;
            for(v1_3 = 0; v1_3 < v9_1.length; ++v1_3) {
                v9_1[v1_3][0] = ((double)this.mOffset[v1_3]);
                for(v3 = 0; true; ++v3) {
                    float[] v4 = this.mValues;
                    if(v3 >= v4.length) {
                        break;
                    }

                    v9_1[v3][1] = ((double)v4[v3]);
                }

                this.mOscillator.addPoint(this.mPosition[v1_3], this.mPeriod[v1_3]);
            }

            this.mOscillator.normalize();
            v1_2 = this.mPosition;
            if(v1_2.length > 1) {
                this.mCurveFit = CurveFit.get(0, v1_2, ((double[][])v9_1));
                return;
            }

            this.mCurveFit = null;
        }
    }

    class ElevationSet extends KeyCycleOscillator {
        ElevationSet() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setElevation(this.get(arg2));
        }
    }

    class IntDoubleSort {
        private IntDoubleSort() {
            super();
        }

        private static int partition(int[] arg3, float[] arg4, int arg5, int arg6) {
            int v0 = arg3[arg6];
            int v1 = arg5;
            while(arg5 < arg6) {
                if(arg3[arg5] <= v0) {
                    IntDoubleSort.swap(arg3, arg4, v1, arg5);
                    ++v1;
                }

                ++arg5;
            }

            IntDoubleSort.swap(arg3, arg4, v1, arg6);
            return v1;
        }

        static void sort(int[] arg7, float[] arg8, int arg9, int arg10) {
            int[] v0 = new int[arg7.length + 10];
            v0[0] = arg10;
            v0[1] = arg9;
            for(arg9 = 2; arg9 > 0; arg9 = v2) {
                int v1 = v0[arg9 - 1];
                int v2 = arg9 - 2;
                int v3 = v0[v2];
                if(v1 < v3) {
                    int v4 = IntDoubleSort.partition(arg7, arg8, v1, v3);
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

        private static void swap(int[] arg2, float[] arg3, int arg4, int arg5) {
            int v0 = arg2[arg4];
            arg2[arg4] = arg2[arg5];
            arg2[arg5] = v0;
            float v2 = arg3[arg4];
            arg3[arg4] = arg3[arg5];
            arg3[arg5] = v2;
        }
    }

    class IntFloatFloatSort {
        private IntFloatFloatSort() {
            super();
        }

        private static int partition(int[] arg3, float[] arg4, float[] arg5, int arg6, int arg7) {
            int v0 = arg3[arg7];
            int v1 = arg6;
            while(arg6 < arg7) {
                if(arg3[arg6] <= v0) {
                    IntFloatFloatSort.swap(arg3, arg4, arg5, v1, arg6);
                    ++v1;
                }

                ++arg6;
            }

            IntFloatFloatSort.swap(arg3, arg4, arg5, v1, arg7);
            return v1;
        }

        static void sort(int[] arg7, float[] arg8, float[] arg9, int arg10, int arg11) {
            int[] v0 = new int[arg7.length + 10];
            v0[0] = arg11;
            v0[1] = arg10;
            for(arg10 = 2; arg10 > 0; arg10 = v2) {
                int v1 = v0[arg10 - 1];
                int v2 = arg10 - 2;
                int v3 = v0[v2];
                if(v1 < v3) {
                    int v4 = IntFloatFloatSort.partition(arg7, arg8, arg9, v1, v3);
                    v0[v2] = v4 - 1;
                    v0[arg10 - 1] = v1;
                    v1 = arg10 + 1;
                    v0[arg10] = v3;
                    arg10 += 2;
                    v0[v1] = v4 + 1;
                    continue;
                }
            }
        }

        private static void swap(int[] arg2, float[] arg3, float[] arg4, int arg5, int arg6) {
            int v0 = arg2[arg5];
            arg2[arg5] = arg2[arg6];
            arg2[arg6] = v0;
            float v2 = arg3[arg5];
            arg3[arg5] = arg3[arg6];
            arg3[arg6] = v2;
            v2 = arg4[arg5];
            arg4[arg5] = arg4[arg6];
            arg4[arg6] = v2;
        }
    }

    class PathRotateSet extends KeyCycleOscillator {
        PathRotateSet() {
            super();
        }

        public void setPathRotate(View arg1, float arg2, double arg3, double arg5) {
            arg1.setRotation(this.get(arg2) + (((float)Math.toDegrees(Math.atan2(arg5, arg3)))));
        }

        public void setProperty(View arg1, float arg2) {
        }
    }

    class ProgressSet extends KeyCycleOscillator {
        boolean mNoMethod;

        ProgressSet() {
            super();
            this.mNoMethod = false;
        }

        public void setProperty(View arg9, float arg10) {
            Method v2;
            String v0 = "unable to setProgress";
            String v1 = "KeyCycleOscillator";
            if((arg9 instanceof MotionLayout)) {
                ((MotionLayout)arg9).setProgress(this.get(arg10));
                return;
            }

            if(!this.mNoMethod) {
                try {
                    v2 = arg9.getClass().getMethod("setProgress", Float.TYPE);
                }
                catch(NoSuchMethodException ) {
                    this.mNoMethod = ((boolean)v2);
                    v2 = null;
                }

                if(v2 != null) {
                    try {
                        v2.invoke(arg9, Float.valueOf(this.get(arg10)));
                    }
                    catch(InvocationTargetException v8) {
                        Log.e(v1, v0, ((Throwable)v8));
                    }
                    catch(IllegalAccessException v8_1) {
                        Log.e(v1, v0, ((Throwable)v8_1));
                    }
                }
            }
        }
    }

    class RotationSet extends KeyCycleOscillator {
        RotationSet() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setRotation(this.get(arg2));
        }
    }

    class RotationXset extends KeyCycleOscillator {
        RotationXset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setRotationX(this.get(arg2));
        }
    }

    class RotationYset extends KeyCycleOscillator {
        RotationYset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setRotationY(this.get(arg2));
        }
    }

    class ScaleXset extends KeyCycleOscillator {
        ScaleXset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setScaleX(this.get(arg2));
        }
    }

    class ScaleYset extends KeyCycleOscillator {
        ScaleYset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setScaleY(this.get(arg2));
        }
    }

    class TranslationXset extends KeyCycleOscillator {
        TranslationXset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setTranslationX(this.get(arg2));
        }
    }

    class TranslationYset extends KeyCycleOscillator {
        TranslationYset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setTranslationY(this.get(arg2));
        }
    }

    class TranslationZset extends KeyCycleOscillator {
        TranslationZset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setTranslationZ(this.get(arg2));
        }
    }

    class WavePoint {
        float mOffset;
        float mPeriod;
        int mPosition;
        float mValue;

        public WavePoint(int arg1, float arg2, float arg3, float arg4) {
            super();
            this.mPosition = arg1;
            this.mValue = arg4;
            this.mOffset = arg3;
            this.mPeriod = arg2;
        }
    }

    private static final String TAG = "KeyCycleOscillator";
    private CurveFit mCurveFit;
    protected ConstraintAttribute mCustom;
    private CycleOscillator mCycleOscillator;
    private String mType;
    public int mVariesBy;
    ArrayList mWavePoints;
    private int mWaveShape;

    public KeyCycleOscillator() {
        super();
        this.mWaveShape = 0;
        this.mVariesBy = 0;
        this.mWavePoints = new ArrayList();
    }

    public float get(float arg1) {
        return ((float)this.mCycleOscillator.getValues(arg1));
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float arg1) {
        return ((float)this.mCycleOscillator.getSlope(arg1));
    }

    static KeyCycleOscillator makeSpline(String arg2) {
        if(arg2.startsWith("CUSTOM")) {
            return new CustomSet();
        }

        arg2.hashCode();
        int v1 = -1;
        switch(arg2.hashCode()) {
            case -1249320806: {
                if(!arg2.equals("rotationX")) {
                    goto label_94;
                }

                v1 = 0;
                break;
            }
            case -1249320805: {
                if(!arg2.equals("rotationY")) {
                    goto label_94;
                }

                v1 = 1;
                break;
            }
            case -1225497657: {
                if(!arg2.equals("translationX")) {
                    goto label_94;
                }

                v1 = 2;
                break;
            }
            case -1225497656: {
                if(!arg2.equals("translationY")) {
                    goto label_94;
                }

                v1 = 3;
                break;
            }
            case -1225497655: {
                if(!arg2.equals("translationZ")) {
                    goto label_94;
                }

                v1 = 4;
                break;
            }
            case -1001078227: {
                if(!arg2.equals("progress")) {
                    goto label_94;
                }

                v1 = 5;
                break;
            }
            case -908189618: {
                if(!arg2.equals("scaleX")) {
                    goto label_94;
                }

                v1 = 6;
                break;
            }
            case -908189617: {
                if(!arg2.equals("scaleY")) {
                    goto label_94;
                }

                v1 = 7;
                break;
            }
            case -797520672: {
                if(!arg2.equals("waveVariesBy")) {
                    goto label_94;
                }

                v1 = 8;
                break;
            }
            case -40300674: {
                if(!arg2.equals("rotation")) {
                    goto label_94;
                }

                v1 = 9;
                break;
            }
            case -4379043: {
                if(!arg2.equals("elevation")) {
                    goto label_94;
                }

                v1 = 10;
                break;
            }
            case 37232917: {
                if(!arg2.equals("transitionPathRotate")) {
                    goto label_94;
                }

                v1 = 11;
                break;
            }
            case 92909918: {
                if(!arg2.equals("alpha")) {
                    goto label_94;
                }

                v1 = 12;
                break;
            }
            case 156108012: {
                if(!arg2.equals("waveOffset")) {
                    goto label_94;
                }

                v1 = 13;
                break;
            }
            default: {
                break;
            }
        }

    label_94:
        switch(v1) {
            case 0: {
                goto label_136;
            }
            case 1: {
                goto label_133;
            }
            case 2: {
                goto label_130;
            }
            case 3: {
                goto label_127;
            }
            case 4: {
                goto label_124;
            }
            case 5: {
                goto label_121;
            }
            case 6: {
                goto label_118;
            }
            case 7: {
                goto label_115;
            }
            case 8: {
                goto label_112;
            }
            case 9: {
                goto label_109;
            }
            case 10: {
                goto label_106;
            }
            case 11: {
                goto label_103;
            }
            case 12: {
                goto label_100;
            }
            case 13: {
                goto label_97;
            }
        }

        return null;
    label_97:
        return new AlphaSet();
    label_130:
        return new TranslationXset();
    label_100:
        return new AlphaSet();
    label_133:
        return new RotationYset();
    label_103:
        return new PathRotateSet();
    label_136:
        return new RotationXset();
    label_106:
        return new ElevationSet();
    label_109:
        return new RotationSet();
    label_112:
        return new AlphaSet();
    label_115:
        return new ScaleYset();
    label_118:
        return new ScaleXset();
    label_121:
        return new ProgressSet();
    label_124:
        return new TranslationZset();
    label_127:
        return new TranslationYset();
    }

    public void setPoint(int arg3, int arg4, int arg5, float arg6, float arg7, float arg8, ConstraintAttribute arg9) {
        this.mWavePoints.add(new WavePoint(arg3, arg6, arg7, arg8));
        if(arg5 != -1) {
            this.mVariesBy = arg5;
        }

        this.mWaveShape = arg4;
        this.mCustom = arg9;
    }

    public void setPoint(int arg3, int arg4, int arg5, float arg6, float arg7, float arg8) {
        this.mWavePoints.add(new WavePoint(arg3, arg6, arg7, arg8));
        if(arg5 != -1) {
            this.mVariesBy = arg5;
        }

        this.mWaveShape = arg4;
    }

    public abstract void setProperty(View arg1, float arg2);

    public void setType(String arg1) {
        this.mType = arg1;
    }

    public void setup(float arg12) {
        int v0 = this.mWavePoints.size();
        if(v0 == 0) {
            return;
        }

        Collections.sort(this.mWavePoints, new Comparator() {
            public int compare(WavePoint arg1, WavePoint arg2) {
                return Integer.compare(arg1.mPosition, arg2.mPosition);
            }

            public int compare(Object arg1, Object arg2) {
                return this.compare(((WavePoint)arg1), ((WavePoint)arg2));
            }
        });
        double[] v1 = new double[v0];
        int[] v3 = new int[2];
        v3[1] = 2;
        v3[0] = v0;
        Object v3_1 = Array.newInstance(Double.TYPE, v3);
        this.mCycleOscillator = new CycleOscillator(this.mWaveShape, this.mVariesBy, v0);
        Iterator v0_1 = this.mWavePoints.iterator();
        int v6;
        for(v6 = 0; v0_1.hasNext(); ++v6) {
            Object v5 = v0_1.next();
            v1[v6] = (((double)((WavePoint)v5).mPeriod)) * 0.01;
            v3_1[v6][0] = ((double)((WavePoint)v5).mValue);
            v3_1[v6][1] = ((double)((WavePoint)v5).mOffset);
            this.mCycleOscillator.setPoint(v6, v5.mPosition, v5.mPeriod, v5.mOffset, v5.mValue);
        }

        this.mCycleOscillator.setup(arg12);
        this.mCurveFit = CurveFit.get(0, v1, ((double[][])v3_1));
    }

    public String toString() {
        String v0 = this.mType;
        DecimalFormat v1 = new DecimalFormat("##.##");
        Iterator v4 = this.mWavePoints.iterator();
        while(v4.hasNext()) {
            Object v2 = v4.next();
            v0 = v0 + "[" + ((WavePoint)v2).mPosition + " , " + v1.format(((double)((WavePoint)v2).mValue)) + "] ";
        }

        return v0;
    }

    public boolean variesByPath() {
        if(this.mVariesBy == 1) {
            return 1;
        }

        return 0;
    }
}

