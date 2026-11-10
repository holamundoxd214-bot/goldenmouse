package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.motion.utils.CurveFit;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KeyTimeCycle extends Key {
    class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_ROTATION = 4;
        private static final int ANDROID_ROTATION_X = 5;
        private static final int ANDROID_ROTATION_Y = 6;
        private static final int ANDROID_SCALE_X = 7;
        private static final int ANDROID_SCALE_Y = 14;
        private static final int ANDROID_TRANSLATION_X = 15;
        private static final int ANDROID_TRANSLATION_Y = 16;
        private static final int ANDROID_TRANSLATION_Z = 17;
        private static final int CURVE_FIT = 13;
        private static final int FRAME_POSITION = 12;
        private static final int PROGRESS = 18;
        private static final int TARGET_ID = 10;
        private static final int TRANSITION_EASING = 9;
        private static final int TRANSITION_PATH_ROTATE = 8;
        private static final int WAVE_OFFSET = 21;
        private static final int WAVE_PERIOD = 20;
        private static final int WAVE_SHAPE = 19;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray v0 = new SparseIntArray();
            Loader.mAttrMap = v0;
            v0.append(styleable.KeyTimeCycle_android_alpha, 1);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_android_elevation, 2);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_android_rotation, 4);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_android_rotationX, 5);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_android_rotationY, 6);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_android_scaleX, 7);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_transitionPathRotate, 8);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_transitionEasing, 9);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_motionTarget, 10);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_framePosition, 12);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_curveFit, 13);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_android_scaleY, 14);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_android_translationX, 15);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_android_translationY, 16);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_android_translationZ, 17);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_motionProgress, 18);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_wavePeriod, 20);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_waveOffset, 21);
            Loader.mAttrMap.append(styleable.KeyTimeCycle_waveShape, 19);
        }

        private Loader() {
            super();
        }

        public static void read(KeyTimeCycle arg5, TypedArray arg6) {
            int v0 = arg6.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = arg6.getIndex(v1);
                switch(Loader.mAttrMap.get(v2)) {
                    case 1: {
                        arg5.mAlpha = arg6.getFloat(v2, arg5.mAlpha);
                        break;
                    }
                    case 2: {
                        arg5.mElevation = arg6.getDimension(v2, arg5.mElevation);
                        break;
                    }
                    case 4: {
                        arg5.mRotation = arg6.getFloat(v2, arg5.mRotation);
                        break;
                    }
                    case 5: {
                        arg5.mRotationX = arg6.getFloat(v2, arg5.mRotationX);
                        break;
                    }
                    case 6: {
                        arg5.mRotationY = arg6.getFloat(v2, arg5.mRotationY);
                        break;
                    }
                    case 7: {
                        arg5.mScaleX = arg6.getFloat(v2, arg5.mScaleX);
                        break;
                    }
                    case 8: {
                        arg5.mTransitionPathRotate = arg6.getFloat(v2, arg5.mTransitionPathRotate);
                        break;
                    }
                    case 9: {
                        arg5.mTransitionEasing = arg6.getString(v2);
                        break;
                    }
                    case 10: {
                        if(MotionLayout.IS_IN_EDIT_MODE) {
                            arg5.mTargetId = arg6.getResourceId(v2, arg5.mTargetId);
                            if(arg5.mTargetId != -1) {
                                goto label_121;
                            }

                            arg5.mTargetString = arg6.getString(v2);
                            goto label_121;
                        }

                        if(arg6.peekValue(v2).type == 3) {
                            arg5.mTargetString = arg6.getString(v2);
                            goto label_121;
                        }

                        arg5.mTargetId = arg6.getResourceId(v2, arg5.mTargetId);
                        break;
                    }
                    case 12: {
                        arg5.mFramePosition = arg6.getInt(v2, arg5.mFramePosition);
                        break;
                    }
                    case 13: {
                        arg5.mCurveFit = arg6.getInteger(v2, arg5.mCurveFit);
                        break;
                    }
                    case 14: {
                        arg5.mScaleY = arg6.getFloat(v2, arg5.mScaleY);
                        break;
                    }
                    case 15: {
                        arg5.mTranslationX = arg6.getDimension(v2, arg5.mTranslationX);
                        break;
                    }
                    case 16: {
                        arg5.mTranslationY = arg6.getDimension(v2, arg5.mTranslationY);
                        break;
                    }
                    case 17: {
                        arg5.mTranslationZ = arg6.getDimension(v2, arg5.mTranslationZ);
                        break;
                    }
                    case 18: {
                        arg5.mProgress = arg6.getFloat(v2, arg5.mProgress);
                        break;
                    }
                    case 19: {
                        arg5.mWaveShape = arg6.getInt(v2, arg5.mWaveShape);
                        break;
                    }
                    case 20: {
                        arg5.mWavePeriod = arg6.getFloat(v2, arg5.mWavePeriod);
                        break;
                    }
                    case 21: {
                        if(arg6.peekValue(v2).type == 5) {
                            arg5.mWaveOffset = arg6.getDimension(v2, arg5.mWaveOffset);
                            goto label_121;
                        }

                        arg5.mWaveOffset = arg6.getFloat(v2, arg5.mWaveOffset);
                        break;
                    }
                    default: {
                        Log.e("KeyTimeCycle", "unused attribute 0x" + Integer.toHexString(v2) + "   " + Loader.mAttrMap.get(v2));
                        break;
                    }
                }

            label_121:
            }
        }
    }

    public static final int KEY_TYPE = 3;
    static final String NAME = "KeyTimeCycle";
    private static final String TAG = "KeyTimeCycle";
    private float mAlpha;
    private int mCurveFit;
    private float mElevation;
    private float mProgress;
    private float mRotation;
    private float mRotationX;
    private float mRotationY;
    private float mScaleX;
    private float mScaleY;
    private String mTransitionEasing;
    private float mTransitionPathRotate;
    private float mTranslationX;
    private float mTranslationY;
    private float mTranslationZ;
    private float mWaveOffset;
    private CurveFit mWaveOffsetSpline;
    private float mWavePeriod;
    private CurveFit mWavePeriodSpline;
    private int mWaveShape;

    public KeyTimeCycle() {
        super();
        this.mCurveFit = -1;
        this.mAlpha = NaNf;
        this.mElevation = NaNf;
        this.mRotation = NaNf;
        this.mRotationX = NaNf;
        this.mRotationY = NaNf;
        this.mTransitionPathRotate = NaNf;
        this.mScaleX = NaNf;
        this.mScaleY = NaNf;
        this.mTranslationX = NaNf;
        this.mTranslationY = NaNf;
        this.mTranslationZ = NaNf;
        this.mProgress = NaNf;
        this.mWaveShape = 0;
        this.mWavePeriod = NaNf;
        this.mWaveOffset = 0f;
        this.mType = 3;
        this.mCustomConstraints = new HashMap();
    }

    static float access$000(KeyTimeCycle arg0) {
        return arg0.mAlpha;
    }

    static float access$002(KeyTimeCycle arg0, float arg1) {
        arg0.mAlpha = arg1;
        return arg1;
    }

    static float access$100(KeyTimeCycle arg0) {
        return arg0.mElevation;
    }

    static String access$1002(KeyTimeCycle arg0, String arg1) {
        arg0.mTransitionEasing = arg1;
        return arg1;
    }

    static float access$102(KeyTimeCycle arg0, float arg1) {
        arg0.mElevation = arg1;
        return arg1;
    }

    static float access$1100(KeyTimeCycle arg0) {
        return arg0.mScaleY;
    }

    static float access$1102(KeyTimeCycle arg0, float arg1) {
        arg0.mScaleY = arg1;
        return arg1;
    }

    static float access$1200(KeyTimeCycle arg0) {
        return arg0.mTransitionPathRotate;
    }

    static float access$1202(KeyTimeCycle arg0, float arg1) {
        arg0.mTransitionPathRotate = arg1;
        return arg1;
    }

    static float access$1300(KeyTimeCycle arg0) {
        return arg0.mTranslationX;
    }

    static float access$1302(KeyTimeCycle arg0, float arg1) {
        arg0.mTranslationX = arg1;
        return arg1;
    }

    static float access$1400(KeyTimeCycle arg0) {
        return arg0.mTranslationY;
    }

    static float access$1402(KeyTimeCycle arg0, float arg1) {
        arg0.mTranslationY = arg1;
        return arg1;
    }

    static float access$1500(KeyTimeCycle arg0) {
        return arg0.mTranslationZ;
    }

    static float access$1502(KeyTimeCycle arg0, float arg1) {
        arg0.mTranslationZ = arg1;
        return arg1;
    }

    static float access$1600(KeyTimeCycle arg0) {
        return arg0.mProgress;
    }

    static float access$1602(KeyTimeCycle arg0, float arg1) {
        arg0.mProgress = arg1;
        return arg1;
    }

    static float access$200(KeyTimeCycle arg0) {
        return arg0.mRotation;
    }

    static float access$202(KeyTimeCycle arg0, float arg1) {
        arg0.mRotation = arg1;
        return arg1;
    }

    static int access$300(KeyTimeCycle arg0) {
        return arg0.mCurveFit;
    }

    static int access$302(KeyTimeCycle arg0, int arg1) {
        arg0.mCurveFit = arg1;
        return arg1;
    }

    static int access$400(KeyTimeCycle arg0) {
        return arg0.mWaveShape;
    }

    static int access$402(KeyTimeCycle arg0, int arg1) {
        arg0.mWaveShape = arg1;
        return arg1;
    }

    static float access$500(KeyTimeCycle arg0) {
        return arg0.mWavePeriod;
    }

    static float access$502(KeyTimeCycle arg0, float arg1) {
        arg0.mWavePeriod = arg1;
        return arg1;
    }

    static float access$600(KeyTimeCycle arg0) {
        return arg0.mWaveOffset;
    }

    static float access$602(KeyTimeCycle arg0, float arg1) {
        arg0.mWaveOffset = arg1;
        return arg1;
    }

    static float access$700(KeyTimeCycle arg0) {
        return arg0.mScaleX;
    }

    static float access$702(KeyTimeCycle arg0, float arg1) {
        arg0.mScaleX = arg1;
        return arg1;
    }

    static float access$800(KeyTimeCycle arg0) {
        return arg0.mRotationX;
    }

    static float access$802(KeyTimeCycle arg0, float arg1) {
        arg0.mRotationX = arg1;
        return arg1;
    }

    static float access$900(KeyTimeCycle arg0) {
        return arg0.mRotationY;
    }

    static float access$902(KeyTimeCycle arg0, float arg1) {
        arg0.mRotationY = arg1;
        return arg1;
    }

    public void addTimeValues(HashMap arg11) {
        Iterator v0 = arg11.keySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v3 = arg11.get(v1);
            String v2 = "CUSTOM";
            int v5 = 1;
            if(((String)v1).startsWith(v2)) {
                Object v6 = this.mCustomConstraints.get(((String)v1).substring(v2.length() + 1));
                if(v6 == null) {
                    continue;
                }

                v3.setPoint(this.mFramePosition, ((ConstraintAttribute)v6), this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
                continue;
            }

            ((String)v1).hashCode();
            int v4 = -1;
            switch(((String)v1).hashCode()) {
                case -1249320806: {
                    if(!((String)v1).equals("rotationX")) {
                        goto label_29;
                    }

                    v5 = 0;
                    break;
                }
                case -1249320805: {
                    if(((String)v1).equals("rotationY")) {
                        goto label_100;
                    }

                    goto label_29;
                }
                case -1225497657: {
                    if(!((String)v1).equals("translationX")) {
                        goto label_29;
                    }

                    v5 = 2;
                    break;
                }
                case -1225497656: {
                    if(!((String)v1).equals("translationY")) {
                        goto label_29;
                    }

                    v5 = 3;
                    break;
                }
                case -1225497655: {
                    if(!((String)v1).equals("translationZ")) {
                        goto label_29;
                    }

                    v5 = 4;
                    break;
                }
                case -1001078227: {
                    if(!((String)v1).equals("progress")) {
                        goto label_29;
                    }

                    v5 = 5;
                    break;
                }
                case -908189618: {
                    if(!((String)v1).equals("scaleX")) {
                        goto label_29;
                    }

                    v5 = 6;
                    break;
                }
                case -908189617: {
                    if(!((String)v1).equals("scaleY")) {
                        goto label_29;
                    }

                    v5 = 7;
                    break;
                }
                case -40300674: {
                    if(!((String)v1).equals("rotation")) {
                        goto label_29;
                    }

                    v5 = 8;
                    break;
                }
                case -4379043: {
                    if(!((String)v1).equals("elevation")) {
                        goto label_29;
                    }

                    v5 = 9;
                    break;
                }
                case 37232917: {
                    if(!((String)v1).equals("transitionPathRotate")) {
                        goto label_29;
                    }

                    v5 = 10;
                    break;
                }
                case 92909918: {
                    if(((String)v1).equals("alpha")) {
                        goto label_35;
                    }

                    goto label_29;
                }
                default: {
                label_29:
                    v5 = v4;
                    goto label_100;
                label_35:
                    v5 = 11;
                    break;
                }
            }

        label_100:
            switch(v5) {
                case 0: {
                    goto label_221;
                }
                case 1: {
                    goto label_211;
                }
                case 2: {
                    goto label_201;
                }
                case 3: {
                    goto label_191;
                }
                case 4: {
                    goto label_181;
                }
                case 5: {
                    goto label_171;
                }
                case 6: {
                    goto label_161;
                }
                case 7: {
                    goto label_151;
                }
                case 8: {
                    goto label_141;
                }
                case 9: {
                    goto label_131;
                }
                case 10: {
                    goto label_121;
                }
                case 11: {
                    goto label_111;
                }
            }

            Log.e("KeyTimeCycles", "UNKNOWN addValues \"" + (((String)v1)) + "\"");
            continue;
        label_161:
            if(Float.isNaN(this.mScaleX)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mScaleX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_131:
            if(Float.isNaN(this.mElevation)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mElevation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_201:
            if(Float.isNaN(this.mTranslationX)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mTranslationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_171:
            if(Float.isNaN(this.mProgress)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mProgress, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_141:
            if(Float.isNaN(this.mRotation)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mRotation, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_111:
            if(Float.isNaN(this.mAlpha)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mAlpha, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_211:
            if(Float.isNaN(this.mRotationY)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mRotationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_181:
            if(Float.isNaN(this.mTranslationZ)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mTranslationZ, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_151:
            if(Float.isNaN(this.mScaleY)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mScaleY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_121:
            if(Float.isNaN(this.mTransitionPathRotate)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mTransitionPathRotate, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_221:
            if(Float.isNaN(this.mRotationX)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mRotationX, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
            continue;
        label_191:
            if(Float.isNaN(this.mTranslationY)) {
                continue;
            }

            ((TimeCycleSplineSet)v3).setPoint(this.mFramePosition, this.mTranslationY, this.mWavePeriod, this.mWaveShape, this.mWaveOffset);
        }
    }

    public void addValues(HashMap arg1) {
        throw new IllegalArgumentException(" KeyTimeCycles do not support SplineSet");
    }

    public void getAttributeNames(HashSet arg4) {
        if(!Float.isNaN(this.mAlpha)) {
            arg4.add("alpha");
        }

        if(!Float.isNaN(this.mElevation)) {
            arg4.add("elevation");
        }

        if(!Float.isNaN(this.mRotation)) {
            arg4.add("rotation");
        }

        if(!Float.isNaN(this.mRotationX)) {
            arg4.add("rotationX");
        }

        if(!Float.isNaN(this.mRotationY)) {
            arg4.add("rotationY");
        }

        if(!Float.isNaN(this.mTranslationX)) {
            arg4.add("translationX");
        }

        if(!Float.isNaN(this.mTranslationY)) {
            arg4.add("translationY");
        }

        if(!Float.isNaN(this.mTranslationZ)) {
            arg4.add("translationZ");
        }

        if(!Float.isNaN(this.mTransitionPathRotate)) {
            arg4.add("transitionPathRotate");
        }

        if(!Float.isNaN(this.mScaleX)) {
            arg4.add("scaleX");
        }

        if(!Float.isNaN(this.mScaleY)) {
            arg4.add("scaleY");
        }

        if(!Float.isNaN(this.mProgress)) {
            arg4.add("progress");
        }

        if(this.mCustomConstraints.size() > 0) {
            Iterator v3 = this.mCustomConstraints.keySet().iterator();
            while(v3.hasNext()) {
                arg4.add("CUSTOM," + v3.next());
            }
        }
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    public void load(Context arg2, AttributeSet arg3) {
        Loader.read(this, arg2.obtainStyledAttributes(arg3, styleable.KeyTimeCycle));
    }

    public void setInterpolation(HashMap arg5) {
        if(this.mCurveFit == -1) {
        }
        else {
            if(!Float.isNaN(this.mAlpha)) {
                arg5.put("alpha", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mElevation)) {
                arg5.put("elevation", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mRotation)) {
                arg5.put("rotation", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mRotationX)) {
                arg5.put("rotationX", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mRotationY)) {
                arg5.put("rotationY", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mTranslationX)) {
                arg5.put("translationX", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mTranslationY)) {
                arg5.put("translationY", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mTranslationZ)) {
                arg5.put("translationZ", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mTransitionPathRotate)) {
                arg5.put("transitionPathRotate", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mScaleX)) {
                arg5.put("scaleX", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mScaleX)) {
                arg5.put("scaleY", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mProgress)) {
                arg5.put("progress", Integer.valueOf(this.mCurveFit));
            }

            if(this.mCustomConstraints.size() <= 0) {
                return;
            }

            Iterator v0 = this.mCustomConstraints.keySet().iterator();
            while(v0.hasNext()) {
                arg5.put("CUSTOM," + v0.next(), Integer.valueOf(this.mCurveFit));
            }
        }
    }

    public void setValue(String arg3, Object arg4) {
        arg3.hashCode();
        int v1 = -1;
        switch(arg3.hashCode()) {
            case 1317633238: {
                if(!arg3.equals("mTranslationZ")) {
                    goto label_88;
                }

                v1 = 13;
                break;
            }
            case -1812823328: {
                if(!arg3.equals("transitionEasing")) {
                    goto label_88;
                }

                v1 = 0;
                break;
            }
            case -1249320806: {
                if(!arg3.equals("rotationX")) {
                    goto label_88;
                }

                v1 = 1;
                break;
            }
            case -1249320805: {
                if(!arg3.equals("rotationY")) {
                    goto label_88;
                }

                v1 = 2;
                break;
            }
            case -1225497657: {
                if(!arg3.equals("translationX")) {
                    goto label_88;
                }

                v1 = 3;
                break;
            }
            case -1225497656: {
                if(!arg3.equals("translationY")) {
                    goto label_88;
                }

                v1 = 4;
                break;
            }
            case -1001078227: {
                if(!arg3.equals("progress")) {
                    goto label_88;
                }

                v1 = 5;
                break;
            }
            case -908189618: {
                if(!arg3.equals("scaleX")) {
                    goto label_88;
                }

                v1 = 6;
                break;
            }
            case -908189617: {
                if(!arg3.equals("scaleY")) {
                    goto label_88;
                }

                v1 = 7;
                break;
            }
            case -40300674: {
                if(!arg3.equals("rotation")) {
                    goto label_88;
                }

                v1 = 8;
                break;
            }
            case -4379043: {
                if(!arg3.equals("elevation")) {
                    goto label_88;
                }

                v1 = 9;
                break;
            }
            case 37232917: {
                if(!arg3.equals("transitionPathRotate")) {
                    goto label_88;
                }

                v1 = 10;
                break;
            }
            case 92909918: {
                if(!arg3.equals("alpha")) {
                    goto label_88;
                }

                v1 = 11;
                break;
            }
            case 579057826: {
                if(!arg3.equals("curveFit")) {
                    goto label_88;
                }

                v1 = 12;
                break;
            }
            default: {
                break;
            }
        }

    label_88:
        switch(v1) {
            case 0: {
                goto label_129;
            }
            case 1: {
                goto label_126;
            }
            case 2: {
                goto label_123;
            }
            case 3: {
                goto label_120;
            }
            case 4: {
                goto label_117;
            }
            case 5: {
                goto label_114;
            }
            case 6: {
                goto label_111;
            }
            case 7: {
                goto label_108;
            }
            case 8: {
                goto label_105;
            }
            case 9: {
                goto label_102;
            }
            case 10: {
                goto label_99;
            }
            case 11: {
                goto label_96;
            }
            case 12: {
                goto label_93;
            }
            case 13: {
                goto label_90;
            }
        }

        return;
    label_129:
        this.mTransitionEasing = arg4.toString();
        return;
    label_99:
        this.mTransitionPathRotate = this.toFloat(arg4);
        return;
    label_102:
        this.mElevation = this.toFloat(arg4);
        return;
    label_105:
        this.mRotation = this.toFloat(arg4);
        return;
    label_108:
        this.mScaleY = this.toFloat(arg4);
        return;
    label_111:
        this.mScaleX = this.toFloat(arg4);
        return;
    label_114:
        this.mProgress = this.toFloat(arg4);
        return;
    label_117:
        this.mTranslationY = this.toFloat(arg4);
        return;
    label_120:
        this.mTranslationX = this.toFloat(arg4);
        return;
    label_90:
        this.mTranslationZ = this.toFloat(arg4);
        return;
    label_123:
        this.mRotationY = this.toFloat(arg4);
        return;
    label_93:
        this.mCurveFit = this.toInt(arg4);
        return;
    label_126:
        this.mRotationX = this.toFloat(arg4);
        return;
    label_96:
        this.mAlpha = this.toFloat(arg4);
    }
}

