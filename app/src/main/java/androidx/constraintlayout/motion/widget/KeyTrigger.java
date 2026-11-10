package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import androidx.constraintlayout.widget.R$styleable;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.HashSet;

public class KeyTrigger extends Key {
    class Loader {
        private static final int COLLISION = 9;
        private static final int CROSS = 4;
        private static final int FRAME_POS = 8;
        private static final int NEGATIVE_CROSS = 1;
        private static final int POSITIVE_CROSS = 2;
        private static final int POST_LAYOUT = 10;
        private static final int TARGET_ID = 7;
        private static final int TRIGGER_ID = 6;
        private static final int TRIGGER_RECEIVER = 11;
        private static final int TRIGGER_SLACK = 5;
        private static SparseIntArray mAttrMap;

        static {
            SparseIntArray v0 = new SparseIntArray();
            Loader.mAttrMap = v0;
            v0.append(styleable.KeyTrigger_framePosition, 8);
            Loader.mAttrMap.append(styleable.KeyTrigger_onCross, 4);
            Loader.mAttrMap.append(styleable.KeyTrigger_onNegativeCross, 1);
            Loader.mAttrMap.append(styleable.KeyTrigger_onPositiveCross, 2);
            Loader.mAttrMap.append(styleable.KeyTrigger_motionTarget, 7);
            Loader.mAttrMap.append(styleable.KeyTrigger_triggerId, 6);
            Loader.mAttrMap.append(styleable.KeyTrigger_triggerSlack, 5);
            Loader.mAttrMap.append(styleable.KeyTrigger_motion_triggerOnCollision, 9);
            Loader.mAttrMap.append(styleable.KeyTrigger_motion_postLayoutCollision, 10);
            Loader.mAttrMap.append(styleable.KeyTrigger_triggerReceiver, 11);
        }

        private Loader() {
            super();
        }

        public static void read(KeyTrigger arg4, TypedArray arg5, Context arg6) {
            int v6 = arg5.getIndexCount();
            int v0;
            for(v0 = 0; v0 < v6; ++v0) {
                int v1 = arg5.getIndex(v0);
                switch(Loader.mAttrMap.get(v1)) {
                    case 1: {
                        arg4.mNegativeCross = arg5.getString(v1);
                        break;
                    }
                    case 2: {
                        arg4.mPositiveCross = arg5.getString(v1);
                        break;
                    }
                    case 4: {
                        arg4.mCross = arg5.getString(v1);
                        break;
                    }
                    case 5: {
                        arg4.mTriggerSlack = arg5.getFloat(v1, arg4.mTriggerSlack);
                        break;
                    }
                    case 6: {
                        arg4.mTriggerID = arg5.getResourceId(v1, arg4.mTriggerID);
                        break;
                    }
                    case 7: {
                        if(MotionLayout.IS_IN_EDIT_MODE) {
                            arg4.mTargetId = arg5.getResourceId(v1, arg4.mTargetId);
                            if(arg4.mTargetId != -1) {
                                goto label_83;
                            }

                            arg4.mTargetString = arg5.getString(v1);
                            goto label_83;
                        }

                        if(arg5.peekValue(v1).type == 3) {
                            arg4.mTargetString = arg5.getString(v1);
                            goto label_83;
                        }

                        arg4.mTargetId = arg5.getResourceId(v1, arg4.mTargetId);
                        break;
                    }
                    case 8: {
                        arg4.mFramePosition = arg5.getInteger(v1, arg4.mFramePosition);
                        arg4.mFireThreshold = ((((float)arg4.mFramePosition)) + 0.5f) / 100f;
                        break;
                    }
                    case 9: {
                        arg4.mTriggerCollisionId = arg5.getResourceId(v1, arg4.mTriggerCollisionId);
                        break;
                    }
                    case 10: {
                        arg4.mPostLayout = arg5.getBoolean(v1, arg4.mPostLayout);
                        break;
                    }
                    case 11: {
                        arg4.mTriggerReceiver = arg5.getResourceId(v1, arg4.mTriggerReceiver);
                    label_70:
                        Log.e("KeyTrigger", "unused attribute 0x" + Integer.toHexString(v1) + "   " + Loader.mAttrMap.get(v1));
                        break;
                    }
                    default: {
                        goto label_70;
                    }
                }

            label_83:
            }
        }
    }

    public static final int KEY_TYPE = 5;
    static final String NAME = "KeyTrigger";
    private static final String TAG = "KeyTrigger";
    RectF mCollisionRect;
    private String mCross;
    private int mCurveFit;
    private Method mFireCross;
    private boolean mFireCrossReset;
    private float mFireLastPos;
    private Method mFireNegativeCross;
    private boolean mFireNegativeReset;
    private Method mFirePositiveCross;
    private boolean mFirePositiveReset;
    private float mFireThreshold;
    private String mNegativeCross;
    private String mPositiveCross;
    private boolean mPostLayout;
    RectF mTargetRect;
    private int mTriggerCollisionId;
    private View mTriggerCollisionView;
    private int mTriggerID;
    private int mTriggerReceiver;
    float mTriggerSlack;

    public KeyTrigger() {
        super();
        this.mCurveFit = -1;
        this.mCross = null;
        this.mTriggerReceiver = KeyTrigger.UNSET;
        this.mNegativeCross = null;
        this.mPositiveCross = null;
        this.mTriggerID = KeyTrigger.UNSET;
        this.mTriggerCollisionId = KeyTrigger.UNSET;
        this.mTriggerCollisionView = null;
        this.mTriggerSlack = 0.1f;
        this.mFireCrossReset = true;
        this.mFireNegativeReset = true;
        this.mFirePositiveReset = true;
        this.mFireThreshold = NaNf;
        this.mPostLayout = false;
        this.mCollisionRect = new RectF();
        this.mTargetRect = new RectF();
        this.mType = 5;
        this.mCustomConstraints = new HashMap();
    }

    static float access$002(KeyTrigger arg0, float arg1) {
        arg0.mFireThreshold = arg1;
        return arg1;
    }

    static String access$102(KeyTrigger arg0, String arg1) {
        arg0.mNegativeCross = arg1;
        return arg1;
    }

    static String access$202(KeyTrigger arg0, String arg1) {
        arg0.mPositiveCross = arg1;
        return arg1;
    }

    static String access$302(KeyTrigger arg0, String arg1) {
        arg0.mCross = arg1;
        return arg1;
    }

    static int access$400(KeyTrigger arg0) {
        return arg0.mTriggerID;
    }

    static int access$402(KeyTrigger arg0, int arg1) {
        arg0.mTriggerID = arg1;
        return arg1;
    }

    static int access$500(KeyTrigger arg0) {
        return arg0.mTriggerCollisionId;
    }

    static int access$502(KeyTrigger arg0, int arg1) {
        arg0.mTriggerCollisionId = arg1;
        return arg1;
    }

    static boolean access$600(KeyTrigger arg0) {
        return arg0.mPostLayout;
    }

    static boolean access$602(KeyTrigger arg0, boolean arg1) {
        arg0.mPostLayout = arg1;
        return arg1;
    }

    static int access$700(KeyTrigger arg0) {
        return arg0.mTriggerReceiver;
    }

    static int access$702(KeyTrigger arg0, int arg1) {
        arg0.mTriggerReceiver = arg1;
        return arg1;
    }

    public void addValues(HashMap arg1) {
    }

    public void conditionallyFire(float arg11, View arg12) {
        int v1_1;
        int v0_2;
        boolean v1;
        boolean v0_1;
        boolean v2 = true;
        if(this.mTriggerCollisionId != KeyTrigger.UNSET) {
            View v0 = this.mTriggerCollisionView;
            if(v0 == null) {
                v0 = arg12.getParent().findViewById(this.mTriggerCollisionId);
                this.mTriggerCollisionView = v0;
            }

            this.setUpRect(this.mCollisionRect, v0, this.mPostLayout);
            this.setUpRect(this.mTargetRect, arg12, this.mPostLayout);
            v0_1 = this.mCollisionRect.intersect(this.mTargetRect);
            v1 = this.mFireCrossReset;
            if(v0_1) {
                if(v1) {
                    this.mFireCrossReset = false;
                    v0_2 = 1;
                }
                else {
                    v0_2 = 0;
                }

                if(this.mFirePositiveReset) {
                    this.mFirePositiveReset = false;
                    v1 = true;
                }
                else {
                    v1 = false;
                }

                this.mFireNegativeReset = true;
                v2 = v1;
                v1_1 = 0;
                goto label_103;
            }

            if(!v1) {
                this.mFireCrossReset = true;
                v0_2 = 1;
            }
            else {
                v0_2 = 0;
            }

            if(this.mFireNegativeReset) {
                this.mFireNegativeReset = false;
                v1_1 = 1;
            }
            else {
                v1_1 = 0;
            }

            this.mFirePositiveReset = true;
            goto label_102;
        }
        else {
            v0_1 = this.mFireCrossReset;
            float v1_2 = this.mFireThreshold;
            if(v0_1) {
                if((arg11 - v1_2) * (this.mFireLastPos - v1_2) < 0f) {
                    this.mFireCrossReset = false;
                    v0_2 = 1;
                }
                else {
                    goto label_67;
                }
            }
            else if(Math.abs(arg11 - v1_2) > this.mTriggerSlack) {
                this.mFireCrossReset = true;
                goto label_67;
            }
            else {
            label_67:
                v0_2 = 0;
            }

            v1 = this.mFireNegativeReset;
            float v5 = this.mFireThreshold;
            if(v1) {
                v1_2 = arg11 - v5;
                if((this.mFireLastPos - v5) * v1_2 >= 0f) {
                    goto label_85;
                }
                else if(v1_2 < 0f) {
                    this.mFireNegativeReset = false;
                    v1_1 = 1;
                }
                else {
                    goto label_85;
                }
            }
            else if(Math.abs(arg11 - v5) > this.mTriggerSlack) {
                this.mFireNegativeReset = true;
                goto label_85;
            }
            else {
            label_85:
                v1_1 = 0;
            }

            boolean v5_1 = this.mFirePositiveReset;
            float v6 = this.mFireThreshold;
            if(v5_1) {
                v5 = arg11 - v6;
                if((this.mFireLastPos - v6) * v5 >= 0f) {
                    goto label_102;
                }

                if(v5 <= 0f) {
                    goto label_102;
                }

                this.mFirePositiveReset = false;
                goto label_103;
            }

            if(Math.abs(arg11 - v6) > this.mTriggerSlack) {
                this.mFirePositiveReset = true;
            }

        label_102:
            v2 = false;
        }

    label_103:
        this.mFireLastPos = arg11;
        if(v1_1 != 0 || v0_2 != 0 || (v2)) {
            arg12.getParent().fireTrigger(this.mTriggerID, v2, arg11);
        }

        if(this.mTriggerReceiver == KeyTrigger.UNSET) {
        }
        else {
            arg12 = arg12.getParent().findViewById(this.mTriggerReceiver);
        }

        String v11 = "Could not find method \"";
        String v4 = "Exception in call \"";
        String v5_2 = " ";
        String v6_1 = "\"on class ";
        String v7 = "KeyTrigger";
        if(v1_1 != 0 && this.mNegativeCross != null) {
            if(this.mFireNegativeCross != null) {
                goto label_146;
            }

            try {
                this.mFireNegativeCross = arg12.getClass().getMethod(this.mNegativeCross);
            }
            catch(NoSuchMethodException ) {
                Log.e(v7, v11 + this.mNegativeCross + v6_1 + arg12.getClass().getSimpleName() + v5_2 + Debug.getName(arg12));
            }

            try {
            label_146:
                this.mFireNegativeCross.invoke(arg12);
            }
            catch(Exception ) {
                Log.e(v7, v4 + this.mNegativeCross + v6_1 + arg12.getClass().getSimpleName() + v5_2 + Debug.getName(arg12));
            }
        }

        if((v2) && this.mPositiveCross != null) {
            if(this.mFirePositiveCross != null) {
                goto label_187;
            }

            try {
                this.mFirePositiveCross = arg12.getClass().getMethod(this.mPositiveCross);
            }
            catch(NoSuchMethodException ) {
                Log.e(v7, v11 + this.mPositiveCross + v6_1 + arg12.getClass().getSimpleName() + v5_2 + Debug.getName(arg12));
            }

            try {
            label_187:
                this.mFirePositiveCross.invoke(arg12);
            }
            catch(Exception ) {
                Log.e(v7, v4 + this.mPositiveCross + v6_1 + arg12.getClass().getSimpleName() + v5_2 + Debug.getName(arg12));
            }
        }

        if(v0_2 != 0 && this.mCross != null) {
            if(this.mFireCross != null) {
                goto label_228;
            }

            try {
                this.mFireCross = arg12.getClass().getMethod(this.mCross);
            }
            catch(NoSuchMethodException ) {
                Log.e(v7, v11 + this.mCross + v6_1 + arg12.getClass().getSimpleName() + v5_2 + Debug.getName(arg12));
            }

            try {
            label_228:
                this.mFireCross.invoke(arg12);
            }
            catch(Exception ) {
                Log.e(v7, v4 + this.mCross + v6_1 + arg12.getClass().getSimpleName() + v5_2 + Debug.getName(arg12));
            }
        }
    }

    public void getAttributeNames(HashSet arg1) {
    }

    int getCurveFit() {
        return this.mCurveFit;
    }

    public void load(Context arg2, AttributeSet arg3) {
        Loader.read(this, arg2.obtainStyledAttributes(arg3, styleable.KeyTrigger), arg2);
    }

    private void setUpRect(RectF arg1, View arg2, boolean arg3) {
        arg1.top = ((float)arg2.getTop());
        arg1.bottom = ((float)arg2.getBottom());
        arg1.left = ((float)arg2.getLeft());
        arg1.right = ((float)arg2.getRight());
        if(arg3) {
            arg2.getMatrix().mapRect(arg1);
        }
    }

    public void setValue(String arg1, Object arg2) {
    }
}

