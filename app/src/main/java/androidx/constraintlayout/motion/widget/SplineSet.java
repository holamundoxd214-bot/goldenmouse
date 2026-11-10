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
import java.util.Arrays;

public abstract class SplineSet {
    class AlphaSet extends SplineSet {
        AlphaSet() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setAlpha(this.get(arg2));
        }
    }

    class CustomSet extends SplineSet {
        String mAttributeName;
        SparseArray mConstraintAttributeList;
        float[] mTempValues;

        public CustomSet(String arg2, SparseArray arg3) {
            super();
            this.mAttributeName = arg2.split(",")[1];
            this.mConstraintAttributeList = arg3;
        }

        public void setPoint(int arg1, ConstraintAttribute arg2) {
            this.mConstraintAttributeList.append(arg1, arg2);
        }

        public void setPoint(int arg1, float arg2) {
            throw new RuntimeException("don\'t call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        public void setProperty(View arg4, float arg5) {
            this.mCurveFit.getPos(((double)arg5), this.mTempValues);
            this.mConstraintAttributeList.valueAt(0).setInterpolatedValue(arg4, this.mTempValues);
        }

        public void setup(int arg12) {
            int v0 = this.mConstraintAttributeList.size();
            int v1 = this.mConstraintAttributeList.valueAt(0).noOfInterpValues();
            double[] v3 = new double[v0];
            this.mTempValues = new float[v1];
            int[] v4 = new int[2];
            v4[1] = v1;
            v4[0] = v0;
            Object v1_1 = Array.newInstance(Double.TYPE, v4);
            int v4_1;
            for(v4_1 = 0; v4_1 < v0; ++v4_1) {
                int v5 = this.mConstraintAttributeList.keyAt(v4_1);
                Object v6 = this.mConstraintAttributeList.valueAt(v4_1);
                v3[v4_1] = (((double)v5)) * 0.01;
                ((ConstraintAttribute)v6).getValuesToInterpolate(this.mTempValues);
                for(v5 = 0; true; ++v5) {
                    float[] v6_1 = this.mTempValues;
                    if(v5 >= v6_1.length) {
                        break;
                    }

                    v1_1[v4_1][v5] = ((double)v6_1[v5]);
                }
            }

            this.mCurveFit = CurveFit.get(arg12, v3, ((double[][])v1_1));
        }
    }

    class ElevationSet extends SplineSet {
        ElevationSet() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setElevation(this.get(arg2));
        }
    }

    class PathRotate extends SplineSet {
        PathRotate() {
            super();
        }

        public void setPathRotate(View arg1, float arg2, double arg3, double arg5) {
            arg1.setRotation(this.get(arg2) + (((float)Math.toDegrees(Math.atan2(arg5, arg3)))));
        }

        public void setProperty(View arg1, float arg2) {
        }
    }

    class PivotXset extends SplineSet {
        PivotXset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setPivotX(this.get(arg2));
        }
    }

    class PivotYset extends SplineSet {
        PivotYset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setPivotY(this.get(arg2));
        }
    }

    class ProgressSet extends SplineSet {
        boolean mNoMethod;

        ProgressSet() {
            super();
            this.mNoMethod = false;
        }

        public void setProperty(View arg9, float arg10) {
            Method v2;
            String v0 = "unable to setProgress";
            String v1 = "SplineSet";
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

    class RotationSet extends SplineSet {
        RotationSet() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setRotation(this.get(arg2));
        }
    }

    class RotationXset extends SplineSet {
        RotationXset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setRotationX(this.get(arg2));
        }
    }

    class RotationYset extends SplineSet {
        RotationYset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setRotationY(this.get(arg2));
        }
    }

    class ScaleXset extends SplineSet {
        ScaleXset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setScaleX(this.get(arg2));
        }
    }

    class ScaleYset extends SplineSet {
        ScaleYset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setScaleY(this.get(arg2));
        }
    }

    class Sort {
        private Sort() {
            super();
        }

        static void doubleQuickSort(int[] arg7, float[] arg8, int arg9, int arg10) {
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

        private static int partition(int[] arg3, float[] arg4, int arg5, int arg6) {
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

        private static void swap(int[] arg2, float[] arg3, int arg4, int arg5) {
            int v0 = arg2[arg4];
            arg2[arg4] = arg2[arg5];
            arg2[arg5] = v0;
            float v2 = arg3[arg4];
            arg3[arg4] = arg3[arg5];
            arg3[arg5] = v2;
        }
    }

    class TranslationXset extends SplineSet {
        TranslationXset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setTranslationX(this.get(arg2));
        }
    }

    class TranslationYset extends SplineSet {
        TranslationYset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setTranslationY(this.get(arg2));
        }
    }

    class TranslationZset extends SplineSet {
        TranslationZset() {
            super();
        }

        public void setProperty(View arg1, float arg2) {
            arg1.setTranslationZ(this.get(arg2));
        }
    }

    private static final String TAG = "SplineSet";
    private int count;
    protected CurveFit mCurveFit;
    protected int[] mTimePoints;
    private String mType;
    protected float[] mValues;

    public SplineSet() {
        super();
        this.mTimePoints = new int[10];
        this.mValues = new float[10];
    }

    public float get(float arg3) {
        return ((float)this.mCurveFit.getPos(((double)arg3), 0));
    }

    public CurveFit getCurveFit() {
        return this.mCurveFit;
    }

    public float getSlope(float arg3) {
        return ((float)this.mCurveFit.getSlope(((double)arg3), 0));
    }

    static SplineSet makeCustomSpline(String arg1, SparseArray arg2) {
        return new CustomSet(arg1, arg2);
    }

    static SplineSet makeSpline(String arg2) {
        arg2.hashCode();
        int v1 = -1;
        switch(arg2.hashCode()) {
            case -1249320806: {
                if(!arg2.equals("rotationX")) {
                    goto label_100;
                }

                v1 = 0;
                break;
            }
            case -1249320805: {
                if(!arg2.equals("rotationY")) {
                    goto label_100;
                }

                v1 = 1;
                break;
            }
            case -1225497657: {
                if(!arg2.equals("translationX")) {
                    goto label_100;
                }

                v1 = 2;
                break;
            }
            case -1225497656: {
                if(!arg2.equals("translationY")) {
                    goto label_100;
                }

                v1 = 3;
                break;
            }
            case -1225497655: {
                if(!arg2.equals("translationZ")) {
                    goto label_100;
                }

                v1 = 4;
                break;
            }
            case -1001078227: {
                if(!arg2.equals("progress")) {
                    goto label_100;
                }

                v1 = 5;
                break;
            }
            case -908189618: {
                if(!arg2.equals("scaleX")) {
                    goto label_100;
                }

                v1 = 6;
                break;
            }
            case -908189617: {
                if(!arg2.equals("scaleY")) {
                    goto label_100;
                }

                v1 = 7;
                break;
            }
            case -797520672: {
                if(!arg2.equals("waveVariesBy")) {
                    goto label_100;
                }

                v1 = 8;
                break;
            }
            case -760884510: {
                if(!arg2.equals("transformPivotX")) {
                    goto label_100;
                }

                v1 = 9;
                break;
            }
            case -760884509: {
                if(!arg2.equals("transformPivotY")) {
                    goto label_100;
                }

                v1 = 10;
                break;
            }
            case -40300674: {
                if(!arg2.equals("rotation")) {
                    goto label_100;
                }

                v1 = 11;
                break;
            }
            case -4379043: {
                if(!arg2.equals("elevation")) {
                    goto label_100;
                }

                v1 = 12;
                break;
            }
            case 37232917: {
                if(!arg2.equals("transitionPathRotate")) {
                    goto label_100;
                }

                v1 = 13;
                break;
            }
            case 92909918: {
                if(!arg2.equals("alpha")) {
                    goto label_100;
                }

                v1 = 14;
                break;
            }
            case 156108012: {
                if(!arg2.equals("waveOffset")) {
                    goto label_100;
                }

                v1 = 15;
                break;
            }
            default: {
                break;
            }
        }

    label_100:
        switch(v1) {
            case 0: {
                goto label_148;
            }
            case 1: {
                goto label_145;
            }
            case 2: {
                goto label_142;
            }
            case 3: {
                goto label_139;
            }
            case 4: {
                goto label_136;
            }
            case 5: {
                goto label_133;
            }
            case 6: {
                goto label_130;
            }
            case 7: {
                goto label_127;
            }
            case 8: {
                goto label_124;
            }
            case 9: {
                goto label_121;
            }
            case 10: {
                goto label_118;
            }
            case 11: {
                goto label_115;
            }
            case 12: {
                goto label_112;
            }
            case 13: {
                goto label_109;
            }
            case 14: {
                goto label_106;
            }
            case 15: {
                goto label_103;
            }
        }

        return null;
    label_130:
        return new ScaleXset();
    label_133:
        return new ProgressSet();
    label_103:
        return new AlphaSet();
    label_136:
        return new TranslationZset();
    label_106:
        return new AlphaSet();
    label_139:
        return new TranslationYset();
    label_109:
        return new PathRotate();
    label_142:
        return new TranslationXset();
    label_112:
        return new ElevationSet();
    label_145:
        return new RotationYset();
    label_115:
        return new RotationSet();
    label_148:
        return new RotationXset();
    label_118:
        return new PivotYset();
    label_121:
        return new PivotXset();
    label_124:
        return new AlphaSet();
    label_127:
        return new ScaleYset();
    }

    public void setPoint(int arg4, float arg5) {
        int[] v0 = this.mTimePoints;
        if(v0.length < this.count + 1) {
            this.mTimePoints = Arrays.copyOf(v0, v0.length * 2);
            this.mValues = Arrays.copyOf(this.mValues, this.mValues.length * 2);
        }

        v0 = this.mTimePoints;
        int v1 = this.count;
        v0[v1] = arg4;
        this.mValues[v1] = arg5;
        this.count = v1 + 1;
    }

    public abstract void setProperty(View arg1, float arg2);

    public void setType(String arg1) {
        this.mType = arg1;
    }

    public void setup(int arg10) {
        int v0 = this.count;
        if(v0 == 0) {
            return;
        }

        Sort.doubleQuickSort(this.mTimePoints, this.mValues, 0, v0 - 1);
        v0 = 1;
        int v1 = 1;
        while(v0 < this.count) {
            if(this.mTimePoints[v0 - 1] != this.mTimePoints[v0]) {
                ++v1;
            }

            ++v0;
        }

        double[] v0_1 = new double[v1];
        int[] v2 = new int[2];
        v2[1] = 1;
        v2[0] = v1;
        Object v1_1 = Array.newInstance(Double.TYPE, v2);
        int v2_1 = 0;
        int v3 = 0;
        while(v2_1 < this.count) {
            if(v2_1 <= 0 || this.mTimePoints[v2_1] != this.mTimePoints[v2_1 - 1]) {
                v0_1[v3] = (((double)this.mTimePoints[v2_1])) * 0.01;
                v1_1[v3][0] = ((double)this.mValues[v2_1]);
                ++v3;
            }
            else {
            }

            ++v2_1;
        }

        this.mCurveFit = CurveFit.get(arg10, v0_1, ((double[][])v1_1));
    }

    public String toString() {
        String v0 = this.mType;
        DecimalFormat v1 = new DecimalFormat("##.##");
        int v2;
        for(v2 = 0; v2 < this.count; ++v2) {
            v0 = v0 + "[" + this.mTimePoints[v2] + " , " + v1.format(((double)this.mValues[v2])) + "] ";
        }

        return v0;
    }
}

