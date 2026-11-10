package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute$AttributeType;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KeyCycle extends Key {
    class Loader {
        private static final int ANDROID_ALPHA = 9;
        private static final int ANDROID_ELEVATION = 10;
        private static final int ANDROID_ROTATION = 11;
        private static final int ANDROID_ROTATION_X = 12;
        private static final int ANDROID_ROTATION_Y = 13;
        private static final int ANDROID_SCALE_X = 15;
        private static final int ANDROID_SCALE_Y = 16;
        private static final int ANDROID_TRANSLATION_X = 17;
        private static final int ANDROID_TRANSLATION_Y = 18;
        private static final int ANDROID_TRANSLATION_Z = 19;
        private static final int CURVE_FIT = 4;
        private static final int FRAME_POSITION = 2;
        private static final int PROGRESS = 20;
        private static final int TARGET_ID = 1;
        private static final int TRANSITION_EASING = 3;
        private static final int TRANSITION_PATH_ROTATE = 14;
        private static final int WAVE_OFFSET = 7;
        private static final int WAVE_PERIOD = 6;
        private static final int WAVE_SHAPE = 5;
        private static final int WAVE_VARIES_BY = 8;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray v0 = new SparseIntArray();
            Loader.mAttrMap = v0;
            v0.append(styleable.KeyCycle_motionTarget, 1);
            Loader.mAttrMap.append(styleable.KeyCycle_framePosition, 2);
            Loader.mAttrMap.append(styleable.KeyCycle_transitionEasing, 3);
            Loader.mAttrMap.append(styleable.KeyCycle_curveFit, 4);
            Loader.mAttrMap.append(styleable.KeyCycle_waveShape, 5);
            Loader.mAttrMap.append(styleable.KeyCycle_wavePeriod, 6);
            Loader.mAttrMap.append(styleable.KeyCycle_waveOffset, 7);
            Loader.mAttrMap.append(styleable.KeyCycle_waveVariesBy, 8);
            Loader.mAttrMap.append(styleable.KeyCycle_android_alpha, 9);
            Loader.mAttrMap.append(styleable.KeyCycle_android_elevation, 10);
            Loader.mAttrMap.append(styleable.KeyCycle_android_rotation, 11);
            Loader.mAttrMap.append(styleable.KeyCycle_android_rotationX, 12);
            Loader.mAttrMap.append(styleable.KeyCycle_android_rotationY, 13);
            Loader.mAttrMap.append(styleable.KeyCycle_transitionPathRotate, 14);
            Loader.mAttrMap.append(styleable.KeyCycle_android_scaleX, 15);
            Loader.mAttrMap.append(styleable.KeyCycle_android_scaleY, 16);
            Loader.mAttrMap.append(styleable.KeyCycle_android_translationX, 17);
            Loader.mAttrMap.append(styleable.KeyCycle_android_translationY, 18);
            Loader.mAttrMap.append(styleable.KeyCycle_android_translationZ, 19);
            Loader.mAttrMap.append(styleable.KeyCycle_motionProgress, 20);
        }

        private Loader() {
            super();
        }

        static void access$000(KeyCycle arg0, TypedArray arg1) {
            Loader.read(arg0, arg1);
        }

        private static void read(KeyCycle arg5, TypedArray arg6) {
            int v0 = arg6.getIndexCount();
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                int v2 = arg6.getIndex(v1);
                switch(Loader.mAttrMap.get(v2)) {
                    case 1: {
                        if(MotionLayout.IS_IN_EDIT_MODE) {
                            arg5.mTargetId = arg6.getResourceId(v2, arg5.mTargetId);
                            if(arg5.mTargetId != -1) {
                                goto label_125;
                            }

                            arg5.mTargetString = arg6.getString(v2);
                            goto label_125;
                        }

                        if(arg6.peekValue(v2).type == 3) {
                            arg5.mTargetString = arg6.getString(v2);
                            goto label_125;
                        }

                        arg5.mTargetId = arg6.getResourceId(v2, arg5.mTargetId);
                        break;
                    }
                    case 2: {
                        arg5.mFramePosition = arg6.getInt(v2, arg5.mFramePosition);
                        break;
                    }
                    case 3: {
                        arg5.mTransitionEasing = arg6.getString(v2);
                        break;
                    }
                    case 4: {
                        arg5.mCurveFit = arg6.getInteger(v2, arg5.mCurveFit);
                        break;
                    }
                    case 5: {
                        arg5.mWaveShape = arg6.getInt(v2, arg5.mWaveShape);
                        break;
                    }
                    case 6: {
                        arg5.mWavePeriod = arg6.getFloat(v2, arg5.mWavePeriod);
                        break;
                    }
                    case 7: {
                        if(arg6.peekValue(v2).type == 5) {
                            arg5.mWaveOffset = arg6.getDimension(v2, arg5.mWaveOffset);
                            goto label_125;
                        }

                        arg5.mWaveOffset = arg6.getFloat(v2, arg5.mWaveOffset);
                        break;
                    }
                    case 8: {
                        arg5.mWaveVariesBy = arg6.getInt(v2, arg5.mWaveVariesBy);
                        break;
                    }
                    case 9: {
                        arg5.mAlpha = arg6.getFloat(v2, arg5.mAlpha);
                        break;
                    }
                    case 10: {
                        arg5.mElevation = arg6.getDimension(v2, arg5.mElevation);
                        break;
                    }
                    case 11: {
                        arg5.mRotation = arg6.getFloat(v2, arg5.mRotation);
                        break;
                    }
                    case 12: {
                        arg5.mRotationX = arg6.getFloat(v2, arg5.mRotationX);
                        break;
                    }
                    case 13: {
                        arg5.mRotationY = arg6.getFloat(v2, arg5.mRotationY);
                        break;
                    }
                    case 14: {
                        arg5.mTransitionPathRotate = arg6.getFloat(v2, arg5.mTransitionPathRotate);
                        break;
                    }
                    case 15: {
                        arg5.mScaleX = arg6.getFloat(v2, arg5.mScaleX);
                        break;
                    }
                    case 16: {
                        arg5.mScaleY = arg6.getFloat(v2, arg5.mScaleY);
                        break;
                    }
                    case 17: {
                        arg5.mTranslationX = arg6.getDimension(v2, arg5.mTranslationX);
                        break;
                    }
                    case 18: {
                        arg5.mTranslationY = arg6.getDimension(v2, arg5.mTranslationY);
                        break;
                    }
                    case 19: {
                        arg5.mTranslationZ = arg6.getDimension(v2, arg5.mTranslationZ);
                        break;
                    }
                    case 20: {
                        arg5.mProgress = arg6.getFloat(v2, arg5.mProgress);
                        break;
                    }
                    default: {
                        Log.e("KeyCycle", "unused attribute 0x" + Integer.toHexString(v2) + "   " + Loader.mAttrMap.get(v2));
                        break;
                    }
                }

            label_125:
            }
        }
    }

    public static final int KEY_TYPE = 4;
    static final String NAME = "KeyCycle";
    private static final String TAG = "KeyCycle";
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
    private float mWavePeriod;
    private int mWaveShape;
    private int mWaveVariesBy;

    public KeyCycle() {
        super();
        this.mTransitionEasing = null;
        this.mCurveFit = 0;
        this.mWaveShape = -1;
        this.mWavePeriod = NaNf;
        this.mWaveOffset = 0f;
        this.mProgress = NaNf;
        this.mWaveVariesBy = -1;
        this.mAlpha = NaNf;
        this.mElevation = NaNf;
        this.mRotation = NaNf;
        this.mTransitionPathRotate = NaNf;
        this.mRotationX = NaNf;
        this.mRotationY = NaNf;
        this.mScaleX = NaNf;
        this.mScaleY = NaNf;
        this.mTranslationX = NaNf;
        this.mTranslationY = NaNf;
        this.mTranslationZ = NaNf;
        this.mType = 4;
        this.mCustomConstraints = new HashMap();
    }

    static float access$1000(KeyCycle arg0) {
        return arg0.mRotationX;
    }

    static float access$1002(KeyCycle arg0, float arg1) {
        arg0.mRotationX = arg1;
        return arg1;
    }

    static String access$102(KeyCycle arg0, String arg1) {
        arg0.mTransitionEasing = arg1;
        return arg1;
    }

    static float access$1100(KeyCycle arg0) {
        return arg0.mRotationY;
    }

    static float access$1102(KeyCycle arg0, float arg1) {
        arg0.mRotationY = arg1;
        return arg1;
    }

    static float access$1200(KeyCycle arg0) {
        return arg0.mTransitionPathRotate;
    }

    static float access$1202(KeyCycle arg0, float arg1) {
        arg0.mTransitionPathRotate = arg1;
        return arg1;
    }

    static float access$1300(KeyCycle arg0) {
        return arg0.mScaleX;
    }

    static float access$1302(KeyCycle arg0, float arg1) {
        arg0.mScaleX = arg1;
        return arg1;
    }

    static float access$1400(KeyCycle arg0) {
        return arg0.mScaleY;
    }

    static float access$1402(KeyCycle arg0, float arg1) {
        arg0.mScaleY = arg1;
        return arg1;
    }

    static float access$1500(KeyCycle arg0) {
        return arg0.mTranslationX;
    }

    static float access$1502(KeyCycle arg0, float arg1) {
        arg0.mTranslationX = arg1;
        return arg1;
    }

    static float access$1600(KeyCycle arg0) {
        return arg0.mTranslationY;
    }

    static float access$1602(KeyCycle arg0, float arg1) {
        arg0.mTranslationY = arg1;
        return arg1;
    }

    static float access$1700(KeyCycle arg0) {
        return arg0.mTranslationZ;
    }

    static float access$1702(KeyCycle arg0, float arg1) {
        arg0.mTranslationZ = arg1;
        return arg1;
    }

    static float access$1800(KeyCycle arg0) {
        return arg0.mProgress;
    }

    static float access$1802(KeyCycle arg0, float arg1) {
        arg0.mProgress = arg1;
        return arg1;
    }

    static int access$200(KeyCycle arg0) {
        return arg0.mCurveFit;
    }

    static int access$202(KeyCycle arg0, int arg1) {
        arg0.mCurveFit = arg1;
        return arg1;
    }

    static int access$300(KeyCycle arg0) {
        return arg0.mWaveShape;
    }

    static int access$302(KeyCycle arg0, int arg1) {
        arg0.mWaveShape = arg1;
        return arg1;
    }

    static float access$400(KeyCycle arg0) {
        return arg0.mWavePeriod;
    }

    static float access$402(KeyCycle arg0, float arg1) {
        arg0.mWavePeriod = arg1;
        return arg1;
    }

    static float access$500(KeyCycle arg0) {
        return arg0.mWaveOffset;
    }

    static float access$502(KeyCycle arg0, float arg1) {
        arg0.mWaveOffset = arg1;
        return arg1;
    }

    static int access$600(KeyCycle arg0) {
        return arg0.mWaveVariesBy;
    }

    static int access$602(KeyCycle arg0, int arg1) {
        arg0.mWaveVariesBy = arg1;
        return arg1;
    }

    static float access$700(KeyCycle arg0) {
        return arg0.mAlpha;
    }

    static float access$702(KeyCycle arg0, float arg1) {
        arg0.mAlpha = arg1;
        return arg1;
    }

    static float access$800(KeyCycle arg0) {
        return arg0.mElevation;
    }

    static float access$802(KeyCycle arg0, float arg1) {
        arg0.mElevation = arg1;
        return arg1;
    }

    static float access$900(KeyCycle arg0) {
        return arg0.mRotation;
    }

    static float access$902(KeyCycle arg0, float arg1) {
        arg0.mRotation = arg1;
        return arg1;
    }

    public void addCycleValues(HashMap arg21) {
        KeyCycle v0 = this;
        HashMap v1 = arg21;
        Iterator v2 = v1.keySet().iterator();
        while(v2.hasNext()) {
            Object v3 = v2.next();
            String v4 = "CUSTOM";
            if(((String)v3).startsWith(v4)) {
                Object v12 = v0.mCustomConstraints.get(((String)v3).substring(v4.length() + 1));
                if(v12 != null && ((ConstraintAttribute)v12).getType() == AttributeType.FLOAT_TYPE) {
                    v1.get(v3).setPoint(v0.mFramePosition, v0.mWaveShape, v0.mWaveVariesBy, v0.mWavePeriod, v0.mWaveOffset, ((ConstraintAttribute)v12).getValueToInterpolate(), ((ConstraintAttribute)v12));
                }
            }

            float v19 = v0.getValue(((String)v3));
            if(Float.isNaN(v19)) {
                continue;
            }

            v1.get(v3).setPoint(v0.mFramePosition, v0.mWaveShape, v0.mWaveVariesBy, v0.mWavePeriod, v0.mWaveOffset, v19);
        }
    }

    public void addValues(HashMap arg7) {
        int v2 = 2;
        Debug.logStack("KeyCycle", "add " + arg7.size() + " values", v2);
        Iterator v0 = arg7.keySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v3 = arg7.get(v1);
            ((String)v1).hashCode();
            int v5 = -1;
            switch(((String)v1).hashCode()) {
                case -1249320806: {
                    if(!((String)v1).equals("rotationX")) {
                        goto label_99;
                    }

                    v5 = 0;
                    break;
                }
                case -1249320805: {
                    if(!((String)v1).equals("rotationY")) {
                        goto label_99;
                    }

                    v5 = 1;
                    break;
                }
                case -1225497657: {
                    if(!((String)v1).equals("translationX")) {
                        goto label_99;
                    }

                    v5 = v2;
                    break;
                }
                case -1225497656: {
                    if(!((String)v1).equals("translationY")) {
                        goto label_99;
                    }

                    v5 = 3;
                    break;
                }
                case -1225497655: {
                    if(!((String)v1).equals("translationZ")) {
                        goto label_99;
                    }

                    v5 = 4;
                    break;
                }
                case -1001078227: {
                    if(!((String)v1).equals("progress")) {
                        goto label_99;
                    }

                    v5 = 5;
                    break;
                }
                case -908189618: {
                    if(!((String)v1).equals("scaleX")) {
                        goto label_99;
                    }

                    v5 = 6;
                    break;
                }
                case -908189617: {
                    if(!((String)v1).equals("scaleY")) {
                        goto label_99;
                    }

                    v5 = 7;
                    break;
                }
                case -40300674: {
                    if(!((String)v1).equals("rotation")) {
                        goto label_99;
                    }

                    v5 = 8;
                    break;
                }
                case -4379043: {
                    if(!((String)v1).equals("elevation")) {
                        goto label_99;
                    }

                    v5 = 9;
                    break;
                }
                case 37232917: {
                    if(!((String)v1).equals("transitionPathRotate")) {
                        goto label_99;
                    }

                    v5 = 10;
                    break;
                }
                case 92909918: {
                    if(!((String)v1).equals("alpha")) {
                        goto label_99;
                    }

                    v5 = 11;
                    break;
                }
                case 156108012: {
                    if(!((String)v1).equals("waveOffset")) {
                        goto label_99;
                    }

                    v5 = 12;
                    break;
                }
                default: {
                    break;
                }
            }

        label_99:
            switch(v5) {
                case 0: {
                    goto label_156;
                }
                case 1: {
                    goto label_152;
                }
                case 2: {
                    goto label_148;
                }
                case 3: {
                    goto label_144;
                }
                case 4: {
                    goto label_140;
                }
                case 5: {
                    goto label_136;
                }
                case 6: {
                    goto label_132;
                }
                case 7: {
                    goto label_128;
                }
                case 8: {
                    goto label_124;
                }
                case 9: {
                    goto label_120;
                }
                case 10: {
                    goto label_116;
                }
                case 11: {
                    goto label_112;
                }
                case 12: {
                    goto label_108;
                }
            }

            Log.v("WARNING KeyCycle", "  UNKNOWN  " + (((String)v1)));
            continue;
        label_132:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mScaleX);
            continue;
        label_136:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mProgress);
            continue;
        label_140:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mTranslationZ);
            continue;
        label_108:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mWaveOffset);
            continue;
        label_144:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mTranslationY);
            continue;
        label_112:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mAlpha);
            continue;
        label_148:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mTranslationX);
            continue;
        label_116:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mTransitionPathRotate);
            continue;
        label_152:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mRotationY);
            continue;
        label_120:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mElevation);
            continue;
        label_156:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mRotationX);
            continue;
        label_124:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mRotation);
            continue;
        label_128:
            ((SplineSet)v3).setPoint(this.mFramePosition, this.mScaleY);
        }
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

        if(!Float.isNaN(this.mScaleX)) {
            arg4.add("scaleX");
        }

        if(!Float.isNaN(this.mScaleY)) {
            arg4.add("scaleY");
        }

        if(!Float.isNaN(this.mTransitionPathRotate)) {
            arg4.add("transitionPathRotate");
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

        if(this.mCustomConstraints.size() > 0) {
            Iterator v3 = this.mCustomConstraints.keySet().iterator();
            while(v3.hasNext()) {
                arg4.add("CUSTOM," + v3.next());
            }
        }
    }

    public float getValue(String arg3) {
        arg3.hashCode();
        int v1 = -1;
        switch(arg3.hashCode()) {
            case -1249320806: {
                if(!arg3.equals("rotationX")) {
                    goto label_82;
                }

                v1 = 0;
                break;
            }
            case -1249320805: {
                if(!arg3.equals("rotationY")) {
                    goto label_82;
                }

                v1 = 1;
                break;
            }
            case -1225497657: {
                if(!arg3.equals("translationX")) {
                    goto label_82;
                }

                v1 = 2;
                break;
            }
            case -1225497656: {
                if(!arg3.equals("translationY")) {
                    goto label_82;
                }

                v1 = 3;
                break;
            }
            case -1225497655: {
                if(!arg3.equals("translationZ")) {
                    goto label_82;
                }

                v1 = 4;
                break;
            }
            case -1001078227: {
                if(!arg3.equals("progress")) {
                    goto label_82;
                }

                v1 = 5;
                break;
            }
            case -908189618: {
                if(!arg3.equals("scaleX")) {
                    goto label_82;
                }

                v1 = 6;
                break;
            }
            case -908189617: {
                if(!arg3.equals("scaleY")) {
                    goto label_82;
                }

                v1 = 7;
                break;
            }
            case -40300674: {
                if(!arg3.equals("rotation")) {
                    goto label_82;
                }

                v1 = 8;
                break;
            }
            case -4379043: {
                if(!arg3.equals("elevation")) {
                    goto label_82;
                }

                v1 = 9;
                break;
            }
            case 37232917: {
                if(!arg3.equals("transitionPathRotate")) {
                    goto label_82;
                }

                v1 = 10;
                break;
            }
            case 92909918: {
                if(!arg3.equals("alpha")) {
                    goto label_82;
                }

                v1 = 11;
                break;
            }
            case 156108012: {
                if(!arg3.equals("waveOffset")) {
                    goto label_82;
                }

                v1 = 12;
                break;
            }
            default: {
                break;
            }
        }

    label_82:
        switch(v1) {
            case 0: {
                goto label_116;
            }
            case 1: {
                goto label_114;
            }
            case 2: {
                goto label_112;
            }
            case 3: {
                goto label_110;
            }
            case 4: {
                goto label_108;
            }
            case 5: {
                goto label_106;
            }
            case 6: {
                goto label_104;
            }
            case 7: {
                goto label_102;
            }
            case 8: {
                goto label_100;
            }
            case 9: {
                goto label_98;
            }
            case 10: {
                goto label_96;
            }
            case 11: {
                goto label_94;
            }
            case 12: {
                goto label_92;
            }
        }

        Log.v("WARNING! KeyCycle", "  UNKNOWN  " + arg3);
        return NaNf;
    label_98:
        return this.mElevation;
    label_100:
        return this.mRotation;
    label_102:
        return this.mScaleY;
    label_104:
        return this.mScaleX;
    label_106:
        return this.mProgress;
    label_108:
        return this.mTranslationZ;
    label_110:
        return this.mTranslationY;
    label_112:
        return this.mTranslationX;
    label_114:
        return this.mRotationY;
    label_116:
        return this.mRotationX;
    label_92:
        return this.mWaveOffset;
    label_94:
        return this.mAlpha;
    label_96:
        return this.mTransitionPathRotate;
    }

    public void load(Context arg2, AttributeSet arg3) {
        Loader.access$000(this, arg2.obtainStyledAttributes(arg3, styleable.KeyCycle));
    }

    public void setValue(String arg3, Object arg4) {
        arg3.hashCode();
        int v1 = -1;
        switch(arg3.hashCode()) {
            case 1317633238: {
                if(!arg3.equals("mTranslationZ")) {
                    goto label_100;
                }

                v1 = 15;
                break;
            }
            case -1812823328: {
                if(!arg3.equals("transitionEasing")) {
                    goto label_100;
                }

                v1 = 0;
                break;
            }
            case -1249320806: {
                if(!arg3.equals("rotationX")) {
                    goto label_100;
                }

                v1 = 1;
                break;
            }
            case -1249320805: {
                if(!arg3.equals("rotationY")) {
                    goto label_100;
                }

                v1 = 2;
                break;
            }
            case -1225497657: {
                if(!arg3.equals("translationX")) {
                    goto label_100;
                }

                v1 = 3;
                break;
            }
            case -1225497656: {
                if(!arg3.equals("translationY")) {
                    goto label_100;
                }

                v1 = 4;
                break;
            }
            case -1001078227: {
                if(!arg3.equals("progress")) {
                    goto label_100;
                }

                v1 = 5;
                break;
            }
            case -908189618: {
                if(!arg3.equals("scaleX")) {
                    goto label_100;
                }

                v1 = 6;
                break;
            }
            case -908189617: {
                if(!arg3.equals("scaleY")) {
                    goto label_100;
                }

                v1 = 7;
                break;
            }
            case -40300674: {
                if(!arg3.equals("rotation")) {
                    goto label_100;
                }

                v1 = 8;
                break;
            }
            case -4379043: {
                if(!arg3.equals("elevation")) {
                    goto label_100;
                }

                v1 = 9;
                break;
            }
            case 37232917: {
                if(!arg3.equals("transitionPathRotate")) {
                    goto label_100;
                }

                v1 = 10;
                break;
            }
            case 92909918: {
                if(!arg3.equals("alpha")) {
                    goto label_100;
                }

                v1 = 11;
                break;
            }
            case 156108012: {
                if(!arg3.equals("waveOffset")) {
                    goto label_100;
                }

                v1 = 12;
                break;
            }
            case 184161818: {
                if(!arg3.equals("wavePeriod")) {
                    goto label_100;
                }

                v1 = 13;
                break;
            }
            case 579057826: {
                if(!arg3.equals("curveFit")) {
                    goto label_100;
                }

                v1 = 14;
                break;
            }
            default: {
                break;
            }
        }

    label_100:
        switch(v1) {
            case 0: {
                goto label_147;
            }
            case 1: {
                goto label_144;
            }
            case 2: {
                goto label_141;
            }
            case 3: {
                goto label_138;
            }
            case 4: {
                goto label_135;
            }
            case 5: {
                goto label_132;
            }
            case 6: {
                goto label_129;
            }
            case 7: {
                goto label_126;
            }
            case 8: {
                goto label_123;
            }
            case 9: {
                goto label_120;
            }
            case 10: {
                goto label_117;
            }
            case 11: {
                goto label_114;
            }
            case 12: {
                goto label_111;
            }
            case 13: {
                goto label_108;
            }
            case 14: {
                goto label_105;
            }
            case 15: {
                goto label_102;
            }
        }

        return;
    label_129:
        this.mScaleX = this.toFloat(arg4);
        return;
    label_132:
        this.mProgress = this.toFloat(arg4);
        return;
    label_102:
        this.mTranslationZ = this.toFloat(arg4);
        return;
    label_135:
        this.mTranslationY = this.toFloat(arg4);
        return;
    label_105:
        this.mCurveFit = this.toInt(arg4);
        return;
    label_138:
        this.mTranslationX = this.toFloat(arg4);
        return;
    label_108:
        this.mWavePeriod = this.toFloat(arg4);
        return;
    label_141:
        this.mRotationY = this.toFloat(arg4);
        return;
    label_111:
        this.mWaveOffset = this.toFloat(arg4);
        return;
    label_144:
        this.mRotationX = this.toFloat(arg4);
        return;
    label_114:
        this.mAlpha = this.toFloat(arg4);
        return;
    label_147:
        this.mTransitionEasing = arg4.toString();
        return;
    label_117:
        this.mTransitionPathRotate = this.toFloat(arg4);
        return;
    label_120:
        this.mElevation = this.toFloat(arg4);
        return;
    label_123:
        this.mRotation = this.toFloat(arg4);
        return;
    label_126:
        this.mScaleY = this.toFloat(arg4);
    }
}

