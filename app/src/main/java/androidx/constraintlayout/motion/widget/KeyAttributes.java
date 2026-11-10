package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import androidx.constraintlayout.widget.ConstraintAttribute;
import androidx.constraintlayout.widget.R$styleable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class KeyAttributes extends Key {
    class Loader {
        private static final int ANDROID_ALPHA = 1;
        private static final int ANDROID_ELEVATION = 2;
        private static final int ANDROID_PIVOT_X = 19;
        private static final int ANDROID_PIVOT_Y = 20;
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
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray v0 = new SparseIntArray();
            Loader.mAttrMap = v0;
            v0.append(styleable.KeyAttribute_android_alpha, 1);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_elevation, 2);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_rotation, 4);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_rotationX, 5);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_rotationY, 6);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_transformPivotX, 19);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_transformPivotY, 20);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_scaleX, 7);
            Loader.mAttrMap.append(styleable.KeyAttribute_transitionPathRotate, 8);
            Loader.mAttrMap.append(styleable.KeyAttribute_transitionEasing, 9);
            Loader.mAttrMap.append(styleable.KeyAttribute_motionTarget, 10);
            Loader.mAttrMap.append(styleable.KeyAttribute_framePosition, 12);
            Loader.mAttrMap.append(styleable.KeyAttribute_curveFit, 13);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_scaleY, 14);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_translationX, 15);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_translationY, 16);
            Loader.mAttrMap.append(styleable.KeyAttribute_android_translationZ, 17);
            Loader.mAttrMap.append(styleable.KeyAttribute_motionProgress, 18);
        }

        private Loader() {
            super();
        }

        public static void read(KeyAttributes arg5, TypedArray arg6) {
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
                                goto label_109;
                            }

                            arg5.mTargetString = arg6.getString(v2);
                            goto label_109;
                        }

                        if(arg6.peekValue(v2).type == 3) {
                            arg5.mTargetString = arg6.getString(v2);
                            goto label_109;
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
                        arg5.mPivotX = arg6.getDimension(v2, arg5.mPivotX);
                        break;
                    }
                    case 20: {
                        arg5.mPivotY = arg6.getDimension(v2, arg5.mPivotY);
                        break;
                    }
                    default: {
                        Log.e("KeyAttribute", "unused attribute 0x" + Integer.toHexString(v2) + "   " + Loader.mAttrMap.get(v2));
                        break;
                    }
                }

            label_109:
            }
        }
    }

    public static final int KEY_TYPE = 1;
    static final String NAME = "KeyAttribute";
    private static final String TAG = "KeyAttribute";
    private float mAlpha;
    private int mCurveFit;
    private float mElevation;
    private float mPivotX;
    private float mPivotY;
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
    private boolean mVisibility;

    public KeyAttributes() {
        super();
        this.mCurveFit = -1;
        this.mVisibility = false;
        this.mAlpha = NaNf;
        this.mElevation = NaNf;
        this.mRotation = NaNf;
        this.mRotationX = NaNf;
        this.mRotationY = NaNf;
        this.mPivotX = NaNf;
        this.mPivotY = NaNf;
        this.mTransitionPathRotate = NaNf;
        this.mScaleX = NaNf;
        this.mScaleY = NaNf;
        this.mTranslationX = NaNf;
        this.mTranslationY = NaNf;
        this.mTranslationZ = NaNf;
        this.mProgress = NaNf;
        this.mType = 1;
        this.mCustomConstraints = new HashMap();
    }

    static float access$000(KeyAttributes arg0) {
        return arg0.mAlpha;
    }

    static float access$002(KeyAttributes arg0, float arg1) {
        arg0.mAlpha = arg1;
        return arg1;
    }

    static float access$100(KeyAttributes arg0) {
        return arg0.mElevation;
    }

    static float access$1000(KeyAttributes arg0) {
        return arg0.mScaleY;
    }

    static float access$1002(KeyAttributes arg0, float arg1) {
        arg0.mScaleY = arg1;
        return arg1;
    }

    static float access$102(KeyAttributes arg0, float arg1) {
        arg0.mElevation = arg1;
        return arg1;
    }

    static float access$1100(KeyAttributes arg0) {
        return arg0.mTransitionPathRotate;
    }

    static float access$1102(KeyAttributes arg0, float arg1) {
        arg0.mTransitionPathRotate = arg1;
        return arg1;
    }

    static float access$1200(KeyAttributes arg0) {
        return arg0.mTranslationX;
    }

    static float access$1202(KeyAttributes arg0, float arg1) {
        arg0.mTranslationX = arg1;
        return arg1;
    }

    static float access$1300(KeyAttributes arg0) {
        return arg0.mTranslationY;
    }

    static float access$1302(KeyAttributes arg0, float arg1) {
        arg0.mTranslationY = arg1;
        return arg1;
    }

    static float access$1400(KeyAttributes arg0) {
        return arg0.mTranslationZ;
    }

    static float access$1402(KeyAttributes arg0, float arg1) {
        arg0.mTranslationZ = arg1;
        return arg1;
    }

    static float access$1500(KeyAttributes arg0) {
        return arg0.mProgress;
    }

    static float access$1502(KeyAttributes arg0, float arg1) {
        arg0.mProgress = arg1;
        return arg1;
    }

    static float access$200(KeyAttributes arg0) {
        return arg0.mRotation;
    }

    static float access$202(KeyAttributes arg0, float arg1) {
        arg0.mRotation = arg1;
        return arg1;
    }

    static int access$300(KeyAttributes arg0) {
        return arg0.mCurveFit;
    }

    static int access$302(KeyAttributes arg0, int arg1) {
        arg0.mCurveFit = arg1;
        return arg1;
    }

    static float access$400(KeyAttributes arg0) {
        return arg0.mScaleX;
    }

    static float access$402(KeyAttributes arg0, float arg1) {
        arg0.mScaleX = arg1;
        return arg1;
    }

    static float access$500(KeyAttributes arg0) {
        return arg0.mRotationX;
    }

    static float access$502(KeyAttributes arg0, float arg1) {
        arg0.mRotationX = arg1;
        return arg1;
    }

    static float access$600(KeyAttributes arg0) {
        return arg0.mRotationY;
    }

    static float access$602(KeyAttributes arg0, float arg1) {
        arg0.mRotationY = arg1;
        return arg1;
    }

    static float access$700(KeyAttributes arg0) {
        return arg0.mPivotX;
    }

    static float access$702(KeyAttributes arg0, float arg1) {
        arg0.mPivotX = arg1;
        return arg1;
    }

    static float access$800(KeyAttributes arg0) {
        return arg0.mPivotY;
    }

    static float access$802(KeyAttributes arg0, float arg1) {
        arg0.mPivotY = arg1;
        return arg1;
    }

    static String access$902(KeyAttributes arg0, String arg1) {
        arg0.mTransitionEasing = arg1;
        return arg1;
    }

    public void addValues(HashMap arg7) {
        Iterator v0 = arg7.keySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = arg7.get(v1);
            String v3 = "CUSTOM";
            int v5 = 1;
            if(((String)v1).startsWith(v3)) {
                v1 = this.mCustomConstraints.get(((String)v1).substring(v3.length() + 1));
                if(v1 == null) {
                    continue;
                }

                ((CustomSet)v2).setPoint(this.mFramePosition, ((ConstraintAttribute)v1));
                continue;
            }

            ((String)v1).hashCode();
            int v4 = -1;
            switch(((String)v1).hashCode()) {
                case -1249320806: {
                    if(!((String)v1).equals("rotationX")) {
                        goto label_23;
                    }

                    v5 = 0;
                    break;
                }
                case -1249320805: {
                    if(((String)v1).equals("rotationY")) {
                        goto label_106;
                    }

                    goto label_23;
                }
                case -1225497657: {
                    if(!((String)v1).equals("translationX")) {
                        goto label_23;
                    }

                    v5 = 2;
                    break;
                }
                case -1225497656: {
                    if(!((String)v1).equals("translationY")) {
                        goto label_23;
                    }

                    v5 = 3;
                    break;
                }
                case -1225497655: {
                    if(!((String)v1).equals("translationZ")) {
                        goto label_23;
                    }

                    v5 = 4;
                    break;
                }
                case -1001078227: {
                    if(!((String)v1).equals("progress")) {
                        goto label_23;
                    }

                    v5 = 5;
                    break;
                }
                case -908189618: {
                    if(!((String)v1).equals("scaleX")) {
                        goto label_23;
                    }

                    v5 = 6;
                    break;
                }
                case -908189617: {
                    if(!((String)v1).equals("scaleY")) {
                        goto label_23;
                    }

                    v5 = 7;
                    break;
                }
                case -760884510: {
                    if(!((String)v1).equals("transformPivotX")) {
                        goto label_23;
                    }

                    v5 = 8;
                    break;
                }
                case -760884509: {
                    if(!((String)v1).equals("transformPivotY")) {
                        goto label_23;
                    }

                    v5 = 9;
                    break;
                }
                case -40300674: {
                    if(!((String)v1).equals("rotation")) {
                        goto label_23;
                    }

                    v5 = 10;
                    break;
                }
                case -4379043: {
                    if(!((String)v1).equals("elevation")) {
                        goto label_23;
                    }

                    v5 = 11;
                    break;
                }
                case 37232917: {
                    if(((String)v1).equals("transitionPathRotate")) {
                        goto label_35;
                    }

                    goto label_23;
                }
                case 92909918: {
                    if(!((String)v1).equals("alpha")) {
                        goto label_23;
                    }

                    v5 = 13;
                    break;
                }
                default: {
                label_23:
                    v5 = v4;
                    goto label_106;
                label_35:
                    v5 = 12;
                    break;
                }
            }

        label_106:
            switch(v5) {
                case 0: {
                    goto label_208;
                }
                case 1: {
                    goto label_201;
                }
                case 2: {
                    goto label_194;
                }
                case 3: {
                    goto label_187;
                }
                case 4: {
                    goto label_180;
                }
                case 5: {
                    goto label_173;
                }
                case 6: {
                    goto label_166;
                }
                case 7: {
                    goto label_159;
                }
                case 8: {
                    goto label_152;
                }
                case 9: {
                    goto label_145;
                }
                case 10: {
                    goto label_138;
                }
                case 11: {
                    goto label_131;
                }
                case 12: {
                    goto label_124;
                }
                case 13: {
                    goto label_117;
                }
            }

            Log.v("KeyAttributes", "UNKNOWN addValues \"" + (((String)v1)) + "\"");
            continue;
        label_194:
            if(Float.isNaN(this.mTranslationX)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mTranslationX);
            continue;
        label_131:
            if(Float.isNaN(this.mElevation)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mElevation);
            continue;
        label_166:
            if(Float.isNaN(this.mScaleX)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mScaleX);
            continue;
        label_201:
            if(Float.isNaN(this.mRotationY)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mRotationY);
            continue;
        label_138:
            if(Float.isNaN(this.mRotation)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mRotation);
            continue;
        label_173:
            if(Float.isNaN(this.mProgress)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mProgress);
            continue;
        label_208:
            if(Float.isNaN(this.mRotationX)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mRotationX);
            continue;
        label_145:
            if(Float.isNaN(this.mRotationY)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mPivotY);
            continue;
        label_180:
            if(Float.isNaN(this.mTranslationZ)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mTranslationZ);
            continue;
        label_117:
            if(Float.isNaN(this.mAlpha)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mAlpha);
            continue;
        label_152:
            if(Float.isNaN(this.mRotationX)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mPivotX);
            continue;
        label_187:
            if(Float.isNaN(this.mTranslationY)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mTranslationY);
            continue;
        label_124:
            if(Float.isNaN(this.mTransitionPathRotate)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mTransitionPathRotate);
            continue;
        label_159:
            if(Float.isNaN(this.mScaleY)) {
                continue;
            }

            ((SplineSet)v2).setPoint(this.mFramePosition, this.mScaleY);
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

        if(!Float.isNaN(this.mPivotX)) {
            arg4.add("transformPivotX");
        }

        if(!Float.isNaN(this.mPivotY)) {
            arg4.add("transformPivotY");
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

        if(!Float.isNaN(this.mScaleX)) {
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
        Loader.read(this, arg2.obtainStyledAttributes(arg3, styleable.KeyAttribute));
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

            if(!Float.isNaN(this.mPivotX)) {
                arg5.put("transformPivotX", Integer.valueOf(this.mCurveFit));
            }

            if(!Float.isNaN(this.mPivotY)) {
                arg5.put("transformPivotY", Integer.valueOf(this.mCurveFit));
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

            if(!Float.isNaN(this.mScaleY)) {
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
                    goto label_106;
                }

                v1 = 15;
                break;
            }
            case 1941332754: {
                if(!arg3.equals("visibility")) {
                    goto label_106;
                }

                v1 = 16;
                break;
            }
            case -1913008125: {
                if(!arg3.equals("motionProgress")) {
                    goto label_106;
                }

                v1 = 0;
                break;
            }
            case -1812823328: {
                if(!arg3.equals("transitionEasing")) {
                    goto label_106;
                }

                v1 = 1;
                break;
            }
            case -1249320806: {
                if(!arg3.equals("rotationX")) {
                    goto label_106;
                }

                v1 = 2;
                break;
            }
            case -1249320805: {
                if(!arg3.equals("rotationY")) {
                    goto label_106;
                }

                v1 = 3;
                break;
            }
            case -1225497657: {
                if(!arg3.equals("translationX")) {
                    goto label_106;
                }

                v1 = 4;
                break;
            }
            case -1225497656: {
                if(!arg3.equals("translationY")) {
                    goto label_106;
                }

                v1 = 5;
                break;
            }
            case -987906986: {
                if(!arg3.equals("pivotX")) {
                    goto label_106;
                }

                v1 = 6;
                break;
            }
            case -987906985: {
                if(!arg3.equals("pivotY")) {
                    goto label_106;
                }

                v1 = 7;
                break;
            }
            case -908189618: {
                if(!arg3.equals("scaleX")) {
                    goto label_106;
                }

                v1 = 8;
                break;
            }
            case -908189617: {
                if(!arg3.equals("scaleY")) {
                    goto label_106;
                }

                v1 = 9;
                break;
            }
            case -40300674: {
                if(!arg3.equals("rotation")) {
                    goto label_106;
                }

                v1 = 10;
                break;
            }
            case -4379043: {
                if(!arg3.equals("elevation")) {
                    goto label_106;
                }

                v1 = 11;
                break;
            }
            case 37232917: {
                if(!arg3.equals("transitionPathRotate")) {
                    goto label_106;
                }

                v1 = 12;
                break;
            }
            case 92909918: {
                if(!arg3.equals("alpha")) {
                    goto label_106;
                }

                v1 = 13;
                break;
            }
            case 579057826: {
                if(!arg3.equals("curveFit")) {
                    goto label_106;
                }

                v1 = 14;
                break;
            }
            default: {
                break;
            }
        }

    label_106:
        switch(v1) {
            case 0: {
                goto label_156;
            }
            case 1: {
                goto label_153;
            }
            case 2: {
                goto label_150;
            }
            case 3: {
                goto label_147;
            }
            case 4: {
                goto label_144;
            }
            case 5: {
                goto label_141;
            }
            case 6: {
                goto label_138;
            }
            case 7: {
                goto label_135;
            }
            case 8: {
                goto label_132;
            }
            case 9: {
                goto label_129;
            }
            case 10: {
                goto label_126;
            }
            case 11: {
                goto label_123;
            }
            case 12: {
                goto label_120;
            }
            case 13: {
                goto label_117;
            }
            case 14: {
                goto label_114;
            }
            case 15: {
                goto label_111;
            }
            case 16: {
                goto label_108;
            }
        }

        return;
    label_129:
        this.mScaleY = this.toFloat(arg4);
        return;
    label_132:
        this.mScaleX = this.toFloat(arg4);
        return;
    label_135:
        this.mPivotY = this.toFloat(arg4);
        return;
    label_138:
        this.mPivotX = this.toFloat(arg4);
        return;
    label_108:
        this.mVisibility = this.toBoolean(arg4);
        return;
    label_141:
        this.mTranslationY = this.toFloat(arg4);
        return;
    label_111:
        this.mTranslationZ = this.toFloat(arg4);
        return;
    label_144:
        this.mTranslationX = this.toFloat(arg4);
        return;
    label_114:
        this.mCurveFit = this.toInt(arg4);
        return;
    label_147:
        this.mRotationY = this.toFloat(arg4);
        return;
    label_117:
        this.mAlpha = this.toFloat(arg4);
        return;
    label_150:
        this.mRotationX = this.toFloat(arg4);
        return;
    label_120:
        this.mTransitionPathRotate = this.toFloat(arg4);
        return;
    label_153:
        this.mTransitionEasing = arg4.toString();
        return;
    label_123:
        this.mElevation = this.toFloat(arg4);
        return;
    label_156:
        this.mProgress = this.toFloat(arg4);
        return;
    label_126:
        this.mRotation = this.toFloat(arg4);
    }
}

