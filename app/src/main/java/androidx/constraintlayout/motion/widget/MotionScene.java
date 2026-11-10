package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.util.TypedValue;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationUtils;
import android.view.animation.AnticipateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import androidx.constraintlayout.motion.utils.Easing;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R$id;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.StateSet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class MotionScene {
    public class Transition {
        class TransitionOnClick implements View$OnClickListener {
            public static final int ANIM_TOGGLE = 17;
            public static final int ANIM_TO_END = 1;
            public static final int ANIM_TO_START = 16;
            public static final int JUMP_TO_END = 0x100;
            public static final int JUMP_TO_START = 0x1000;
            int mMode;
            int mTargetId;
            private final Transition mTransition;

            public TransitionOnClick(Context arg3, Transition arg4, XmlPullParser arg5) {
                super();
                this.mTargetId = -1;
                this.mMode = 17;
                this.mTransition = arg4;
                TypedArray v3 = arg3.obtainStyledAttributes(Xml.asAttributeSet(arg5), styleable.OnClick);
                int v4 = v3.getIndexCount();
                int v5;
                for(v5 = 0; v5 < v4; ++v5) {
                    int v0 = v3.getIndex(v5);
                    if(v0 == styleable.OnClick_targetId) {
                        this.mTargetId = v3.getResourceId(v0, this.mTargetId);
                    }
                    else if(v0 == styleable.OnClick_clickAction) {
                        this.mMode = v3.getInt(v0, this.mMode);
                    }
                }

                v3.recycle();
            }

            public void addOnClickListeners(MotionLayout arg7, int arg8, Transition arg9) {
                View v7;
                int v0 = this.mTargetId;
                int v1 = -1;
                if(v0 == v1) {
                }
                else {
                    v7 = arg7.findViewById(v0);
                }

                if((((MotionLayout)v7)) == null) {
                    Log.e("MotionScene", "OnClick could not find id " + this.mTargetId);
                    return;
                }

                v0 = arg9.mConstraintSetStart;
                int v9 = arg9.mConstraintSetEnd;
                if(v0 == v1) {
                    v7.setOnClickListener(((View$OnClickListener)this));
                    return;
                }

                v1 = this.mMode;
                int v3 = 0;
                int v2 = (v1 & 1) == 0 || arg8 != v0 ? 0 : 1;
                int v5 = (v1 & 0x100) == 0 || arg8 != v0 ? 0 : 1;
                v2 |= v5;
                v0 = (v1 & 1) == 0 || arg8 != v0 ? 0 : 1;
                v0 |= v2;
                v2 = (v1 & 16) == 0 || arg8 != v9 ? 0 : 1;
                v0 |= v2;
                if((v1 & 0x1000) != 0 && arg8 == v9) {
                    v3 = 1;
                }

                if((v0 | v3) != 0) {
                    v7.setOnClickListener(((View$OnClickListener)this));
                }
            }

            boolean isTransitionViable(Transition arg4, MotionLayout arg5) {
                Transition v0 = this.mTransition;
                if(v0 == arg4) {
                    return 1;
                }

                int v4 = v0.mConstraintSetEnd;
                int v3 = this.mTransition.mConstraintSetStart;
                if(v3 == -1) {
                    if(arg5.mCurrentState != v4) {
                        return 1;
                    }

                    return 0;
                }

                if(arg5.mCurrentState != v3) {
                    if(arg5.mCurrentState == v4) {
                    }
                    else {
                        return 0;
                    }
                }

                return 1;
            }

            public void onClick(View arg8) {
                MotionLayout v8 = this.mTransition.mMotionScene.mMotionLayout;
                if(!v8.isInteractionEnabled()) {
                }
                else {
                    int v1 = -1;
                    if(this.mTransition.mConstraintSetStart == v1) {
                        int v0 = v8.getCurrentState();
                        if(v0 == v1) {
                            v8.transitionToState(this.mTransition.mConstraintSetEnd);
                            return;
                        }
                        else {
                            Transition v1_1 = new Transition(this.mTransition.mMotionScene, this.mTransition);
                            v1_1.mConstraintSetStart = v0;
                            v1_1.mConstraintSetEnd = this.mTransition.mConstraintSetEnd;
                            v8.setTransition(v1_1);
                            v8.transitionToEnd();
                            return;
                        }
                    }
                    else {
                        Transition v0_1 = this.mTransition.mMotionScene.mCurrentTransition;
                        v1 = this.mMode;
                        int v3 = 0;
                        int v2 = (v1 & 1) != 0 || (v1 & 0x100) != 0 ? 1 : 0;
                        v1 = (v1 & 16) != 0 || (v1 & 0x1000) != 0 ? 1 : 0;
                        if(v2 != 0) {
                            if(v1 != 0) {
                                Transition v5 = this.mTransition.mMotionScene.mCurrentTransition;
                                Transition v6 = this.mTransition;
                                if(v5 != v6) {
                                    v8.setTransition(v6);
                                }

                                if(v8.getCurrentState() == v8.getEndState()) {
                                    goto label_67;
                                }

                                if(v8.getProgress() > 0.5f) {
                                    goto label_67;
                                }

                                v1 = 0;
                            }
                            else {
                            }

                            goto label_66;
                        }
                        else {
                        label_66:
                            v3 = v2;
                        }

                    label_67:
                        if(!this.isTransitionViable(v0_1, v8)) {
                            return;
                        }

                        if(v3 != 0 && (this.mMode & 1) != 0) {
                            v8.setTransition(this.mTransition);
                            v8.transitionToEnd();
                            return;
                        }

                        if(v1 != 0 && (this.mMode & 16) != 0) {
                            v8.setTransition(this.mTransition);
                            v8.transitionToStart();
                            return;
                        }

                        if(v3 != 0 && (this.mMode & 0x100) != 0) {
                            v8.setTransition(this.mTransition);
                            v8.setProgress(1f);
                            return;
                        }

                        if(v1 == 0) {
                            return;
                        }

                        if((this.mMode & 0x1000) == 0) {
                            return;
                        }

                        v8.setTransition(this.mTransition);
                        v8.setProgress(0f);
                    }
                }
            }

            public void removeOnClickListeners(MotionLayout arg3) {
                int v0 = this.mTargetId;
                if(v0 == -1) {
                    return;
                }

                View v3 = arg3.findViewById(v0);
                if(v3 == null) {
                    Log.e("MotionScene", " (*)  could not find id " + this.mTargetId);
                    return;
                }

                v3.setOnClickListener(null);
            }
        }

        public static final int AUTO_ANIMATE_TO_END = 4;
        public static final int AUTO_ANIMATE_TO_START = 3;
        public static final int AUTO_JUMP_TO_END = 2;
        public static final int AUTO_JUMP_TO_START = 1;
        public static final int AUTO_NONE = 0;
        static final int TRANSITION_FLAG_FIRST_DRAW = 1;
        private int mAutoTransition;
        private int mConstraintSetEnd;
        private int mConstraintSetStart;
        private int mDefaultInterpolator;
        private int mDefaultInterpolatorID;
        private String mDefaultInterpolatorString;
        private boolean mDisable;
        private int mDuration;
        private int mId;
        private boolean mIsAbstract;
        private ArrayList mKeyFramesList;
        private int mLayoutDuringTransition;
        private final MotionScene mMotionScene;
        private ArrayList mOnClicks;
        private int mPathMotionArc;
        private float mStagger;
        private TouchResponse mTouchResponse;
        private int mTransitionFlags;

        Transition(MotionScene arg5, Context arg6, XmlPullParser arg7) {
            super();
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mDuration = arg5.mDefaultDuration;
            this.mLayoutDuringTransition = arg5.mLayoutDuringTransition;
            this.mMotionScene = arg5;
            this.fillFromAttributeList(arg5, arg6, Xml.asAttributeSet(arg7));
        }

        Transition(MotionScene arg5, Transition arg6) {
            super();
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mMotionScene = arg5;
            if(arg6 != null) {
                this.mPathMotionArc = arg6.mPathMotionArc;
                this.mDefaultInterpolator = arg6.mDefaultInterpolator;
                this.mDefaultInterpolatorString = arg6.mDefaultInterpolatorString;
                this.mDefaultInterpolatorID = arg6.mDefaultInterpolatorID;
                this.mDuration = arg6.mDuration;
                this.mKeyFramesList = arg6.mKeyFramesList;
                this.mStagger = arg6.mStagger;
                this.mLayoutDuringTransition = arg6.mLayoutDuringTransition;
            }
        }

        public Transition(int arg5, MotionScene arg6, int arg7, int arg8) {
            super();
            this.mId = -1;
            this.mIsAbstract = false;
            this.mConstraintSetEnd = -1;
            this.mConstraintSetStart = -1;
            this.mDefaultInterpolator = 0;
            this.mDefaultInterpolatorString = null;
            this.mDefaultInterpolatorID = -1;
            this.mDuration = 400;
            this.mStagger = 0f;
            this.mKeyFramesList = new ArrayList();
            this.mTouchResponse = null;
            this.mOnClicks = new ArrayList();
            this.mAutoTransition = 0;
            this.mDisable = false;
            this.mPathMotionArc = -1;
            this.mLayoutDuringTransition = 0;
            this.mTransitionFlags = 0;
            this.mId = arg5;
            this.mMotionScene = arg6;
            this.mConstraintSetStart = arg7;
            this.mConstraintSetEnd = arg8;
            this.mDuration = arg6.mDefaultDuration;
            this.mLayoutDuringTransition = arg6.mLayoutDuringTransition;
        }

        static int access$000(Transition arg0) {
            return arg0.mConstraintSetEnd;
        }

        static int access$002(Transition arg0, int arg1) {
            arg0.mConstraintSetEnd = arg1;
            return arg1;
        }

        static int access$100(Transition arg0) {
            return arg0.mConstraintSetStart;
        }

        static int access$102(Transition arg0, int arg1) {
            arg0.mConstraintSetStart = arg1;
            return arg1;
        }

        static boolean access$1200(Transition arg0) {
            return arg0.mIsAbstract;
        }

        static ArrayList access$1300(Transition arg0) {
            return arg0.mKeyFramesList;
        }

        static int access$1400(Transition arg0) {
            return arg0.mDefaultInterpolator;
        }

        static String access$1500(Transition arg0) {
            return arg0.mDefaultInterpolatorString;
        }

        static int access$1600(Transition arg0) {
            return arg0.mDefaultInterpolatorID;
        }

        static int access$1700(Transition arg0) {
            return arg0.mDuration;
        }

        static int access$1800(Transition arg0) {
            return arg0.mPathMotionArc;
        }

        static float access$1900(Transition arg0) {
            return arg0.mStagger;
        }

        static TouchResponse access$200(Transition arg0) {
            return arg0.mTouchResponse;
        }

        static TouchResponse access$202(Transition arg0, TouchResponse arg1) {
            arg0.mTouchResponse = arg1;
            return arg1;
        }

        static int access$300(Transition arg0) {
            return arg0.mId;
        }

        static ArrayList access$400(Transition arg0) {
            return arg0.mOnClicks;
        }

        static boolean access$500(Transition arg0) {
            return arg0.mDisable;
        }

        static int access$600(Transition arg0) {
            return arg0.mAutoTransition;
        }

        static MotionScene access$700(Transition arg0) {
            return arg0.mMotionScene;
        }

        public void addOnClick(Context arg3, XmlPullParser arg4) {
            this.mOnClicks.add(new TransitionOnClick(arg3, this, arg4));
        }

        public String debugString(Context arg4) {
            int v1 = -1;
            String v0 = this.mConstraintSetStart == v1 ? "null" : arg4.getResources().getResourceEntryName(this.mConstraintSetStart);
            if(this.mConstraintSetEnd == v1) {
                return v0 + " -> null";
            }

            return v0 + " -> " + arg4.getResources().getResourceEntryName(this.mConstraintSetEnd);
        }

        private void fill(MotionScene arg10, Context arg11, TypedArray arg12) {
            ConstraintSet v3;
            int v0 = arg12.getIndexCount();
            int v2;
            for(v2 = 0; true; ++v2) {
                int v4 = -1;
                if(v2 >= v0) {
                    break;
                }

                int v5 = arg12.getIndex(v2);
                String v7 = "layout";
                if(v5 == styleable.Transition_constraintSetEnd) {
                    this.mConstraintSetEnd = arg12.getResourceId(v5, this.mConstraintSetEnd);
                    if(v7.equals(arg11.getResources().getResourceTypeName(this.mConstraintSetEnd))) {
                        v3 = new ConstraintSet();
                        v3.load(arg11, this.mConstraintSetEnd);
                        arg10.mConstraintSetMap.append(this.mConstraintSetEnd, v3);
                    }
                }
                else if(v5 == styleable.Transition_constraintSetStart) {
                    this.mConstraintSetStart = arg12.getResourceId(v5, this.mConstraintSetStart);
                    if(v7.equals(arg11.getResources().getResourceTypeName(this.mConstraintSetStart))) {
                        v3 = new ConstraintSet();
                        v3.load(arg11, this.mConstraintSetStart);
                        arg10.mConstraintSetMap.append(this.mConstraintSetStart, v3);
                    }
                }
                else if(v5 == styleable.Transition_motionInterpolator) {
                    TypedValue v6 = arg12.peekValue(v5);
                    int v8 = -2;
                    if(v6.type == 1) {
                        int v3_1 = arg12.getResourceId(v5, v4);
                        this.mDefaultInterpolatorID = v3_1;
                        if(v3_1 != v4) {
                            this.mDefaultInterpolator = v8;
                        }
                    }
                    else if(v6.type == 3) {
                        String v3_2 = arg12.getString(v5);
                        this.mDefaultInterpolatorString = v3_2;
                        if(v3_2.indexOf("/") > 0) {
                            this.mDefaultInterpolatorID = arg12.getResourceId(v5, v4);
                            this.mDefaultInterpolator = v8;
                        }
                        else {
                            this.mDefaultInterpolator = v4;
                        }
                    }
                    else {
                        this.mDefaultInterpolator = arg12.getInteger(v5, this.mDefaultInterpolator);
                    }
                }
                else if(v5 == styleable.Transition_duration) {
                    this.mDuration = arg12.getInt(v5, this.mDuration);
                }
                else if(v5 == styleable.Transition_staggered) {
                    this.mStagger = arg12.getFloat(v5, this.mStagger);
                }
                else if(v5 == styleable.Transition_autoTransition) {
                    this.mAutoTransition = arg12.getInteger(v5, this.mAutoTransition);
                }
                else if(v5 == styleable.Transition_android_id) {
                    this.mId = arg12.getResourceId(v5, this.mId);
                }
                else if(v5 == styleable.Transition_transitionDisable) {
                    this.mDisable = arg12.getBoolean(v5, this.mDisable);
                }
                else if(v5 == styleable.Transition_pathMotionArc) {
                    this.mPathMotionArc = arg12.getInteger(v5, v4);
                }
                else if(v5 == styleable.Transition_layoutDuringTransition) {
                    this.mLayoutDuringTransition = arg12.getInteger(v5, 0);
                }
                else if(v5 == styleable.Transition_transitionFlags) {
                    this.mTransitionFlags = arg12.getInteger(v5, 0);
                }
            }

            if(this.mConstraintSetStart == v4) {
                this.mIsAbstract = true;
            }
        }

        private void fillFromAttributeList(MotionScene arg2, Context arg3, AttributeSet arg4) {
            TypedArray v4 = arg3.obtainStyledAttributes(arg4, styleable.Transition);
            this.fill(arg2, arg3, v4);
            v4.recycle();
        }

        public int getDuration() {
            return this.mDuration;
        }

        public int getEndConstraintSetId() {
            return this.mConstraintSetEnd;
        }

        public int getId() {
            return this.mId;
        }

        public List getKeyFrameList() {
            return this.mKeyFramesList;
        }

        public int getLayoutDuringTransition() {
            return this.mLayoutDuringTransition;
        }

        public List getOnClickList() {
            return this.mOnClicks;
        }

        public int getPathMotionArc() {
            return this.mPathMotionArc;
        }

        public float getStagger() {
            return this.mStagger;
        }

        public int getStartConstraintSetId() {
            return this.mConstraintSetStart;
        }

        public TouchResponse getTouchResponse() {
            return this.mTouchResponse;
        }

        public boolean isEnabled() {
            return this.mDisable ^ 1;
        }

        public boolean isTransitionFlag(int arg1) {
            if((this.mTransitionFlags & arg1) != 0) {
                return 1;
            }

            return 0;
        }

        public void setDuration(int arg1) {
            this.mDuration = arg1;
        }

        public void setEnable(boolean arg1) {
            this.mDisable = (((int)arg1)) ^ 1;
        }

        public void setPathMotionArc(int arg1) {
            this.mPathMotionArc = arg1;
        }

        public void setStagger(float arg1) {
            this.mStagger = arg1;
        }
    }

    static final int ANTICIPATE = 4;
    static final int BOUNCE = 5;
    private static final boolean DEBUG = false;
    private boolean DEBUG_DESKTOP;
    static final int EASE_IN = 1;
    static final int EASE_IN_OUT = 0;
    static final int EASE_OUT = 2;
    private static final int INTERPOLATOR_REFRENCE_ID = -2;
    public static final int LAYOUT_HONOR_REQUEST = 1;
    public static final int LAYOUT_IGNORE_REQUEST = 0;
    static final int LINEAR = 3;
    private static final int SPLINE_STRING = -1;
    public static final String TAG = "MotionScene";
    static final int TRANSITION_BACKWARD = 0;
    static final int TRANSITION_FORWARD = 1;
    public static final int UNSET = -1;
    private ArrayList mAbstractTransitionList;
    private HashMap mConstraintSetIdMap;
    private SparseArray mConstraintSetMap;
    Transition mCurrentTransition;
    private int mDefaultDuration;
    private Transition mDefaultTransition;
    private SparseIntArray mDeriveMap;
    private boolean mDisableAutoTransition;
    private MotionEvent mLastTouchDown;
    float mLastTouchX;
    float mLastTouchY;
    private int mLayoutDuringTransition;
    private final MotionLayout mMotionLayout;
    private boolean mMotionOutsideRegion;
    private boolean mRtl;
    StateSet mStateSet;
    private ArrayList mTransitionList;
    private MotionTracker mVelocityTracker;

    MotionScene(Context arg4, MotionLayout arg5, int arg6) {
        super();
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = arg5;
        this.load(arg4, arg6);
        this.mConstraintSetMap.put(id.motion_base, new ConstraintSet());
        this.mConstraintSetIdMap.put("motion_base", Integer.valueOf(id.motion_base));
    }

    public MotionScene(MotionLayout arg4) {
        super();
        this.mStateSet = null;
        this.mCurrentTransition = null;
        this.mDisableAutoTransition = false;
        this.mTransitionList = new ArrayList();
        this.mDefaultTransition = null;
        this.mAbstractTransitionList = new ArrayList();
        this.mConstraintSetMap = new SparseArray();
        this.mConstraintSetIdMap = new HashMap();
        this.mDeriveMap = new SparseIntArray();
        this.DEBUG_DESKTOP = false;
        this.mDefaultDuration = 400;
        this.mLayoutDuringTransition = 0;
        this.mMotionOutsideRegion = false;
        this.mMotionLayout = arg4;
    }

    static int access$1000(MotionScene arg0) {
        return arg0.mLayoutDuringTransition;
    }

    static SparseArray access$1100(MotionScene arg0) {
        return arg0.mConstraintSetMap;
    }

    static MotionLayout access$800(MotionScene arg0) {
        return arg0.mMotionLayout;
    }

    static int access$900(MotionScene arg0) {
        return arg0.mDefaultDuration;
    }

    public void addOnClickListeners(MotionLayout arg5, int arg6) {
        Object v0_1;
        Object v1;
        Iterator v0 = this.mTransitionList.iterator();
        do {
        label_2:
            if(!v0.hasNext()) {
                goto label_15;
            }

            v1 = v0.next();
        }
        while(Transition.access$400(((Transition)v1)).size() <= 0);

        Iterator v1_1 = Transition.access$400(((Transition)v1)).iterator();
        goto label_10;
    label_15:
        v0 = this.mAbstractTransitionList.iterator();
        goto label_17;
        while(true) {
        label_10:
            if(!v1_1.hasNext()) {
                goto label_2;
            }

            v1_1.next().removeOnClickListeners(arg5);
        }

        do {
        label_17:
            if(!v0.hasNext()) {
                goto label_30;
            }

            v1 = v0.next();
        }
        while(Transition.access$400(((Transition)v1)).size() <= 0);

        v1_1 = Transition.access$400(((Transition)v1)).iterator();
        goto label_25;
    label_30:
        v0 = this.mTransitionList.iterator();
        goto label_32;
        while(true) {
        label_25:
            if(!v1_1.hasNext()) {
                goto label_17;
            }

            v1_1.next().removeOnClickListeners(arg5);
        }

        do {
        label_32:
            if(!v0.hasNext()) {
                goto label_45;
            }

            v1 = v0.next();
        }
        while(Transition.access$400(((Transition)v1)).size() <= 0);

        Iterator v2 = Transition.access$400(((Transition)v1)).iterator();
        goto label_40;
    label_45:
        Iterator v4 = this.mAbstractTransitionList.iterator();
        goto label_47;
        while(true) {
        label_40:
            if(!v2.hasNext()) {
                goto label_32;
            }

            v2.next().addOnClickListeners(arg5, arg6, ((Transition)v1));
        }

        do {
        label_47:
            if(!v4.hasNext()) {
                return;
            }

            v0_1 = v4.next();
        }
        while(Transition.access$400(((Transition)v0_1)).size() <= 0);

        v1_1 = Transition.access$400(((Transition)v0_1)).iterator();
        goto label_55;
        return;
        while(true) {
        label_55:
            if(!v1_1.hasNext()) {
                goto label_47;
            }

            v1_1.next().addOnClickListeners(arg5, arg6, ((Transition)v0_1));
        }
    }

    public void addTransition(Transition arg3) {
        int v0 = this.getIndex(arg3);
        ArrayList v2 = this.mTransitionList;
        if(v0 == -1) {
            v2.add(arg3);
            return;
        }

        v2.set(v0, arg3);
    }

    boolean autoTransition(MotionLayout arg7, int arg8) {
        int v4;
        Object v0;
        if(this.isProcessingTouch()) {
            return 0;
        }

        if(this.mDisableAutoTransition) {
            return 0;
        }

        Iterator v6 = this.mTransitionList.iterator();
        do {
        label_9:
            if(!v6.hasNext()) {
                return 0;
            }

            v0 = v6.next();
            if(Transition.access$600(((Transition)v0)) == 0) {
                goto label_9;
            }

            if(arg8 == Transition.access$100(((Transition)v0))) {
                v4 = 4;
                if(Transition.access$600(((Transition)v0)) != v4 && Transition.access$600(((Transition)v0)) != 2) {
                    goto label_45;
                }

                arg7.setState(TransitionState.FINISHED);
                arg7.setTransition(((Transition)v0));
                if(Transition.access$600(((Transition)v0)) == v4) {
                    arg7.transitionToEnd();
                    arg7.setState(TransitionState.SETUP);
                    arg7.setState(TransitionState.MOVING);
                }
                else {
                    arg7.setProgress(1f);
                    arg7.evaluate(true);
                    arg7.setState(TransitionState.SETUP);
                    arg7.setState(TransitionState.MOVING);
                    arg7.setState(TransitionState.FINISHED);
                }

                return 1;
            }

        label_45:
            if(arg8 != Transition.access$000(((Transition)v0))) {
                goto label_9;
            }

            v4 = 3;
            if(Transition.access$600(((Transition)v0)) == v4) {
                break;
            }
        }
        while(Transition.access$600(((Transition)v0)) != 1);

        arg7.setState(TransitionState.FINISHED);
        arg7.setTransition(((Transition)v0));
        if(Transition.access$600(((Transition)v0)) == v4) {
            arg7.transitionToStart();
            arg7.setState(TransitionState.SETUP);
            arg7.setState(TransitionState.MOVING);
        }
        else {
            arg7.setProgress(0f);
            arg7.evaluate(true);
            arg7.setState(TransitionState.SETUP);
            arg7.setState(TransitionState.MOVING);
            arg7.setState(TransitionState.FINISHED);
        }

        return 1;
    }

    public Transition bestTransitionFor(int arg9, float arg10, float arg11, MotionEvent arg12) {
        if(arg9 != -1) {
            List v0 = this.getTransitionsWithState(arg9);
            RectF v1 = new RectF();
            Iterator v0_1 = v0.iterator();
            float v2 = 0f;
            Transition v3 = null;
            while(v0_1.hasNext()) {
                Object v4 = v0_1.next();
                if(Transition.access$500(((Transition)v4))) {
                    continue;
                }

                if(Transition.access$200(((Transition)v4)) == null) {
                    continue;
                }

                Transition.access$200(((Transition)v4)).setRTL(this.mRtl);
                RectF v5 = Transition.access$200(((Transition)v4)).getTouchRegion(this.mMotionLayout, v1);
                if(v5 != null && arg12 != null && !v5.contains(arg12.getX(), arg12.getY())) {
                    continue;
                }

                v5 = Transition.access$200(((Transition)v4)).getTouchRegion(this.mMotionLayout, v1);
                if(v5 != null && arg12 != null && !v5.contains(arg12.getX(), arg12.getY())) {
                    continue;
                }

                float v5_1 = Transition.access$200(((Transition)v4)).dot(arg10, arg11);
                float v6 = Transition.access$000(((Transition)v4)) == arg9 ? -1f : 1.1f;
                v5_1 *= v6;
                if(v5_1 <= v2) {
                    continue;
                }

                Object v3_1 = v4;
                v2 = v5_1;
            }

            return v3;
        }

        return this.mCurrentTransition;
    }

    public void disableAutoTransition(boolean arg1) {
        this.mDisableAutoTransition = arg1;
    }

    public int gatPathMotionArc() {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null) {
            return Transition.access$1800(v0);
        }

        return -1;
    }

    ConstraintSet getConstraintSet(int arg2) {
        return this.getConstraintSet(arg2, -1, -1);
    }

    ConstraintSet getConstraintSet(int arg4, int arg5, int arg6) {
        if(this.DEBUG_DESKTOP) {
            System.out.println("id " + arg4);
            System.out.println("size " + this.mConstraintSetMap.size());
        }

        StateSet v0 = this.mStateSet;
        if(v0 != null) {
            arg5 = v0.stateGetConstraintID(arg4, arg5, arg6);
            if(arg5 != -1) {
                arg4 = arg5;
            }
        }

        if(this.mConstraintSetMap.get(arg4) == null) {
            Log.e("MotionScene", "Warning could not find ConstraintSet id/" + Debug.getName(this.mMotionLayout.getContext(), arg4) + " In MotionScene");
            return this.mConstraintSetMap.get(this.mConstraintSetMap.keyAt(0));
        }

        return this.mConstraintSetMap.get(arg4);
    }

    public ConstraintSet getConstraintSet(Context arg7, String arg8) {
        if(this.DEBUG_DESKTOP) {
            System.out.println("id " + arg8);
            System.out.println("size " + this.mConstraintSetMap.size());
        }

        int v0;
        for(v0 = 0; v0 < this.mConstraintSetMap.size(); ++v0) {
            int v1 = this.mConstraintSetMap.keyAt(v0);
            String v2 = arg7.getResources().getResourceName(v1);
            if(this.DEBUG_DESKTOP) {
                System.out.println("Id for <" + v0 + "> is <" + v2 + "> looking for <" + arg8 + ">");
            }

            if(arg8.equals(v2)) {
                return this.mConstraintSetMap.get(v1);
            }
        }

        return null;
    }

    public int[] getConstraintSetIds() {
        int v0 = this.mConstraintSetMap.size();
        int[] v1 = new int[v0];
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1[v2] = this.mConstraintSetMap.keyAt(v2);
        }

        return v1;
    }

    public ArrayList getDefinedTransitions() {
        return this.mTransitionList;
    }

    public int getDuration() {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null) {
            return Transition.access$1700(v0);
        }

        return this.mDefaultDuration;
    }

    int getEndId() {
        Transition v0 = this.mCurrentTransition;
        if(v0 == null) {
            return -1;
        }

        return Transition.access$000(v0);
    }

    private int getId(Context arg6, String arg7) {
        int v6;
        int v2 = -1;
        if(arg7.contains("/")) {
            v6 = arg6.getResources().getIdentifier(arg7.substring(arg7.indexOf(0x2F) + 1), "id", arg6.getPackageName());
            if(this.DEBUG_DESKTOP) {
                System.out.println("id getMap res = " + v6);
            }
        }
        else {
            v6 = v2;
        }

        if(v6 == v2) {
            if(arg7 != null && arg7.length() > 1) {
                return Integer.parseInt(arg7.substring(1));
            }

            Log.e("MotionScene", "error in parsing id");
        }

        return v6;
    }

    private int getIndex(Transition arg4) {
        int v4 = Transition.access$300(arg4);
        int v0 = -1;
        if(v4 != v0) {
            int v1;
            for(v1 = 0; v1 < this.mTransitionList.size(); ++v1) {
                if(Transition.access$300(this.mTransitionList.get(v1)) == v4) {
                    return v1;
                }
            }

            return v0;
        }

        throw new IllegalArgumentException("The transition must have an id");
    }

    public Interpolator getInterpolator() {
        int v0 = Transition.access$1400(this.mCurrentTransition);
        if(v0 != -2) {
            if(v0 != -1) {
                if(v0 != 0) {
                    if(v0 != 1) {
                        if(v0 != 2) {
                            if(v0 != 4) {
                                if(v0 != 5) {
                                    return null;
                                }

                                return new BounceInterpolator();
                            }

                            return new AnticipateInterpolator();
                        }

                        return new DecelerateInterpolator();
                    }

                    return new AccelerateInterpolator();
                }

                return new AccelerateDecelerateInterpolator();
            }

            return new Interpolator(Easing.getInterpolator(Transition.access$1500(this.mCurrentTransition))) {
                public float getInterpolation(float arg3) {
                    return ((float)this.val$easing.get(((double)arg3)));
                }
            };
        }

        return AnimationUtils.loadInterpolator(this.mMotionLayout.getContext(), Transition.access$1600(this.mCurrentTransition));
    }

    Key getKeyFrame(Context arg6, int arg7, int arg8, int arg9) {
        Object v3;
        Object v2;
        Transition v5 = this.mCurrentTransition;
        Key v6 = null;
        if(v5 == null) {
            return v6;
        }

        Iterator v5_1 = Transition.access$1300(v5).iterator();
    label_6:
        if(v5_1.hasNext()) {
            Object v0 = v5_1.next();
            Iterator v1 = ((KeyFrames)v0).getKeys().iterator();
            do {
            label_11:
                if(!v1.hasNext()) {
                    goto label_6;
                }

                v2 = v1.next();
            }
            while(arg8 != ((Integer)v2).intValue());

            Iterator v2_1 = ((KeyFrames)v0).getKeyFramesForView(((Integer)v2).intValue()).iterator();
            do {
            label_19:
                if(!v2_1.hasNext()) {
                    goto label_11;
                }

                v3 = v2_1.next();
                if(((Key)v3).mFramePosition != arg9) {
                    goto label_19;
                }
            }
            while(((Key)v3).mType != arg7);

            return ((Key)v3);
        }

        return v6;
    }

    public void getKeyFrames(MotionController arg2) {
        Iterator v1_1;
        Transition v0 = this.mCurrentTransition;
        if(v0 == null) {
            Transition v1 = this.mDefaultTransition;
            if(v1 != null) {
                v1_1 = Transition.access$1300(v1).iterator();
                while(v1_1.hasNext()) {
                    v1_1.next().addFrames(arg2);
                }
            }
        }
        else {
            v1_1 = Transition.access$1300(v0).iterator();
            while(v1_1.hasNext()) {
                v1_1.next().addFrames(arg2);
            }
        }
    }

    float getMaxAcceleration() {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null && Transition.access$200(v0) != null) {
            return Transition.access$200(this.mCurrentTransition).getMaxAcceleration();
        }

        return 0;
    }

    float getMaxVelocity() {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null && Transition.access$200(v0) != null) {
            return Transition.access$200(this.mCurrentTransition).getMaxVelocity();
        }

        return 0;
    }

    boolean getMoveWhenScrollAtTop() {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null && Transition.access$200(v0) != null) {
            return Transition.access$200(this.mCurrentTransition).getMoveWhenScrollAtTop();
        }

        return 0;
    }

    public float getPathPercent(View arg1, int arg2) {
        return 0;
    }

    float getProgressDirection(float arg2, float arg3) {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null && Transition.access$200(v0) != null) {
            return Transition.access$200(this.mCurrentTransition).getProgressDirection(arg2, arg3);
        }

        return 0;
    }

    private int getRealID(int arg2) {
        StateSet v1 = this.mStateSet;
        if(v1 != null) {
            int v1_1 = v1.stateGetConstraintID(arg2, -1, -1);
            if(v1_1 != -1) {
                return v1_1;
            }
        }

        return arg2;
    }

    public float getStaggered() {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null) {
            return Transition.access$1900(v0);
        }

        return 0;
    }

    int getStartId() {
        Transition v0 = this.mCurrentTransition;
        if(v0 == null) {
            return -1;
        }

        return Transition.access$100(v0);
    }

    public Transition getTransitionById(int arg3) {
        Object v0;
        Iterator v2 = this.mTransitionList.iterator();
        do {
            if(!v2.hasNext()) {
                return null;
            }

            v0 = v2.next();
        }
        while(Transition.access$300(((Transition)v0)) != arg3);

        return ((Transition)v0);
    }

    int getTransitionDirection(int arg2) {
        Iterator v1 = this.mTransitionList.iterator();
        do {
            if(!v1.hasNext()) {
                return 1;
            }
        }
        while(Transition.access$100(v1.next()) != arg2);

        return 0;
    }

    public List getTransitionsWithState(int arg4) {
        arg4 = this.getRealID(arg4);
        ArrayList v0 = new ArrayList();
        Iterator v3 = this.mTransitionList.iterator();
        while(v3.hasNext()) {
            Object v1 = v3.next();
            if(Transition.access$100(((Transition)v1)) != arg4 && Transition.access$000(((Transition)v1)) != arg4) {
                continue;
            }

            v0.add(v1);
        }

        return ((List)v0);
    }

    private boolean hasCycleDependency(int arg5) {
        int v0 = this.mDeriveMap.get(arg5);
        int v1;
        for(v1 = this.mDeriveMap.size(); v0 > 0; v1 = v3) {
            if(v0 == arg5) {
                return 1;
            }

            int v3 = v1 - 1;
            if(v1 < 0) {
                return 1;
            }

            v0 = this.mDeriveMap.get(v0);
        }

        return 0;
    }

    boolean hasKeyFramePosition(View arg4, int arg5) {
        Transition v3 = this.mCurrentTransition;
        if(v3 == null) {
            return 0;
        }

        Iterator v3_1 = Transition.access$1300(v3).iterator();
    label_6:
        if(v3_1.hasNext()) {
            Iterator v1 = v3_1.next().getKeyFramesForView(arg4.getId()).iterator();
            do {
                if(!v1.hasNext()) {
                    goto label_6;
                }
            }
            while(v1.next().mFramePosition != arg5);

            return 1;
        }

        return 0;
    }

    private boolean isProcessingTouch() {
        if(this.mVelocityTracker != null) {
            return 1;
        }

        return 0;
    }

    private void load(Context arg8, int arg9) {
        String v1_1;
        Transition v2;
        int v1;
        XmlResourceParser v0 = arg8.getResources().getXml(arg9);
        try {
            v1 = ((XmlPullParser)v0).getEventType();
            v2 = null;
            while(true) {
            label_4:
                if(v1 == 1) {
                    return;
                }

                if(v1 == 0) {
                    goto label_116;
                }
                else if(v1 != 2) {
                }
                else {
                    v1_1 = ((XmlPullParser)v0).getName();
                    if(this.DEBUG_DESKTOP) {
                        System.out.println("parsing = " + v1_1);
                    }

                    int v3 = v1_1.hashCode();
                    break;
                }

                goto label_117;
            }
        }
        catch(IOException v7) {
            goto label_120;
        }
        catch(XmlPullParserException v7_1) {
            goto label_123;
        }

        String v4 = "MotionScene";
        switch(v3) {
            case -1349929691: {
                goto label_103;
            }
            case -1239391468: {
                goto label_95;
            }
            case 269306229: {
                try {
                    if(!v1_1.equals("Transition")) {
                        goto label_108;
                    }

                    ArrayList v1_2 = this.mTransitionList;
                    v2 = new Transition(this, arg8, ((XmlPullParser)v0));
                    v1_2.add(v2);
                    if(this.mCurrentTransition == null && !Transition.access$1200(v2)) {
                        this.mCurrentTransition = v2;
                        if(Transition.access$200(v2) != null) {
                            Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
                        }
                    }

                    if(!Transition.access$1200(v2)) {
                        goto label_117;
                    }

                    if(Transition.access$000(v2) == -1) {
                        this.mDefaultTransition = v2;
                    }
                    else {
                        this.mAbstractTransitionList.add(v2);
                    }

                    this.mTransitionList.remove(v2);
                    goto label_117;
                label_36:
                    if(!v1_1.equals("OnSwipe")) {
                        goto label_108;
                    }

                    if(v2 == null) {
                        Log.v(v4, " OnSwipe (" + arg8.getResources().getResourceEntryName(arg9) + ".xml:" + ((XmlPullParser)v0).getLineNumber() + ")");
                    }

                    Transition.access$202(v2, new TouchResponse(arg8, this.mMotionLayout, ((XmlPullParser)v0)));
                    goto label_117;
                label_103:
                    if(!v1_1.equals("ConstraintSet")) {
                        goto label_108;
                    }

                    this.parseConstraintSet(arg8, ((XmlPullParser)v0));
                    goto label_117;
                label_25:
                    if(!v1_1.equals("StateSet")) {
                        goto label_108;
                    }

                    this.mStateSet = new StateSet(arg8, ((XmlPullParser)v0));
                    goto label_117;
                label_60:
                    if(!v1_1.equals("OnClick")) {
                        goto label_108;
                    }

                    v2.addOnClick(arg8, ((XmlPullParser)v0));
                    goto label_117;
                label_95:
                    if(!v1_1.equals("KeyFrameSet")) {
                        goto label_108;
                    }

                    Transition.access$1300(v2).add(new KeyFrames(arg8, ((XmlPullParser)v0)));
                    goto label_117;
                label_32:
                    if(v1_1.equals(v4)) {
                        this.parseMotionSceneTags(arg8, ((XmlPullParser)v0));
                    }
                    else {
                    label_108:
                        Log.v(v4, "WARNING UNKNOWN ATTRIBUTE " + v1_1);
                        goto label_117;
                    label_116:
                        ((XmlPullParser)v0).getName();
                    }

                label_117:
                    v1 = ((XmlPullParser)v0).next();
                    goto label_4;
                }
                catch(IOException v7) {
                label_120:
                    v7.printStackTrace();
                    return;
                }
                catch(XmlPullParserException v7_1) {
                label_123:
                    v7_1.printStackTrace();
                    return;
                }
            }
            case 312750793: {
                goto label_60;
            }
            case 327855227: {
                goto label_36;
            }
            case 793277014: {
                goto label_32;
            }
            case 1382829617: {
                goto label_25;
            }
            default: {
                goto label_108;
            }
        }
    }

    public int lookUpConstraintId(String arg1) {
        return this.mConstraintSetIdMap.get(arg1).intValue();
    }

    public String lookUpConstraintName(int arg3) {
        Object v0;
        Iterator v2 = this.mConstraintSetIdMap.entrySet().iterator();
        do {
            if(!v2.hasNext()) {
                return null;
            }

            v0 = v2.next();
        }
        while(((Map$Entry)v0).getValue().intValue() != arg3);

        return ((Map$Entry)v0).getKey();
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
    }

    private void parseConstraintSet(Context arg12, XmlPullParser arg13) {
        ConstraintSet v0 = new ConstraintSet();
        int v1 = 0;
        v0.setForceId(false);
        int v2 = arg13.getAttributeCount();
        int v3 = -1;
        int v4 = v3;
        int v5 = v4;
        while(v1 < v2) {
            String v6 = arg13.getAttributeName(v1);
            String v7 = arg13.getAttributeValue(v1);
            if(this.DEBUG_DESKTOP) {
                System.out.println("id string = " + v7);
            }

            v6.hashCode();
            if(v6.equals("deriveConstraintsFrom")) {
                v5 = this.getId(arg12, v7);
            }
            else if(!v6.equals("id")) {
            }
            else {
                v4 = this.getId(arg12, v7);
                this.mConstraintSetIdMap.put(MotionScene.stripID(v7), Integer.valueOf(v4));
            }

            ++v1;
        }

        if(v4 != v3) {
            if(this.mMotionLayout.mDebugPath != 0) {
                v0.setValidateOnParse(true);
            }

            v0.load(arg12, arg13);
            if(v5 != v3) {
                this.mDeriveMap.put(v4, v5);
            }

            this.mConstraintSetMap.put(v4, v0);
        }
    }

    private void parseMotionSceneTags(Context arg5, XmlPullParser arg6) {
        TypedArray v5 = arg5.obtainStyledAttributes(Xml.asAttributeSet(arg6), styleable.MotionScene);
        int v6 = v5.getIndexCount();
        int v1;
        for(v1 = 0; v1 < v6; ++v1) {
            int v2 = v5.getIndex(v1);
            if(v2 == styleable.MotionScene_defaultDuration) {
                this.mDefaultDuration = v5.getInt(v2, this.mDefaultDuration);
            }
            else if(v2 == styleable.MotionScene_layoutDuringTransition) {
                this.mLayoutDuringTransition = v5.getInteger(v2, 0);
            }
        }

        v5.recycle();
    }

    void processScrollMove(float arg2, float arg3) {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null && Transition.access$200(v0) != null) {
            Transition.access$200(this.mCurrentTransition).scrollMove(arg2, arg3);
        }
    }

    void processScrollUp(float arg2, float arg3) {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null && Transition.access$200(v0) != null) {
            Transition.access$200(this.mCurrentTransition).scrollUp(arg2, arg3);
        }
    }

    void processTouchEvent(MotionEvent arg12, int arg13, MotionLayout arg14) {
        RectF v0 = new RectF();
        MotionTracker v1 = this.mVelocityTracker;
        if(v1 == null) {
            v1 = this.mMotionLayout.obtainVelocityTracker();
            this.mVelocityTracker = v1;
        }

        v1.addMovement(arg12);
        MotionEvent v1_1 = null;
        int v2 = -1;
        if(arg13 != v2) {
            int v4 = arg12.getAction();
            boolean v5 = false;
            if(v4 != 0) {
                if(v4 != 2) {
                }
                else {
                    float v4_1 = arg12.getRawY() - this.mLastTouchY;
                    float v6 = arg12.getRawX() - this.mLastTouchX;
                    double v9 = 0;
                    if((((double)v6)) == v9 && (((double)v4_1)) == v9) {
                        return;
                    }

                    MotionEvent v7 = this.mLastTouchDown;
                    if(v7 == null) {
                        return;
                    }

                    Transition v4_2 = this.bestTransitionFor(arg13, v6, v4_1, v7);
                    if(v4_2 == null) {
                        goto label_95;
                    }

                    arg14.setTransition(v4_2);
                    v0 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, v0);
                    if(v0 != null && !v0.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                        v5 = true;
                    }

                    this.mMotionOutsideRegion = v5;
                    Transition.access$200(this.mCurrentTransition).setUpTouchEvent(this.mLastTouchX, this.mLastTouchY);
                }

                goto label_95;
            }
            else {
                this.mLastTouchX = arg12.getRawX();
                this.mLastTouchY = arg12.getRawY();
                this.mLastTouchDown = arg12;
                if(Transition.access$200(this.mCurrentTransition) == null) {
                    return;
                }

                RectF v12 = Transition.access$200(this.mCurrentTransition).getLimitBoundsTo(this.mMotionLayout, v0);
                if(v12 != null && !v12.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) {
                    this.mLastTouchDown = v1_1;
                    return;
                }

                v12 = Transition.access$200(this.mCurrentTransition).getTouchRegion(this.mMotionLayout, v0);
                this.mMotionOutsideRegion = v12 == null || (v12.contains(this.mLastTouchDown.getX(), this.mLastTouchDown.getY())) ? false : true;
                Transition.access$200(this.mCurrentTransition).setDown(this.mLastTouchX, this.mLastTouchY);
                return;
            }
        }
        else {
        label_95:
            Transition v0_1 = this.mCurrentTransition;
            if(v0_1 != null && Transition.access$200(v0_1) != null && !this.mMotionOutsideRegion) {
                Transition.access$200(this.mCurrentTransition).processTouchEvent(arg12, this.mVelocityTracker, arg13, this);
            }

            this.mLastTouchX = arg12.getRawX();
            this.mLastTouchY = arg12.getRawY();
            if(arg12.getAction() != 1) {
                return;
            }

            MotionTracker v12_1 = this.mVelocityTracker;
            if(v12_1 == null) {
                return;
            }

            v12_1.recycle();
            this.mVelocityTracker = ((MotionTracker)v1_1);
            if(arg14.mCurrentState == v2) {
                return;
            }

            this.autoTransition(arg14, arg14.mCurrentState);
        }
    }

    private void readConstraintChain(int arg4) {
        int v0 = this.mDeriveMap.get(arg4);
        if(v0 > 0) {
            this.readConstraintChain(this.mDeriveMap.get(arg4));
            Object v1 = this.mConstraintSetMap.get(arg4);
            Object v2 = this.mConstraintSetMap.get(v0);
            if(v2 == null) {
                Log.e("MotionScene", "ERROR! invalid deriveConstraintsFrom: @id/" + Debug.getName(this.mMotionLayout.getContext(), v0));
                return;
            }
            else {
                ((ConstraintSet)v1).readFallback(((ConstraintSet)v2));
                this.mDeriveMap.put(arg4, -1);
            }
        }
    }

    void readFallback(MotionLayout arg5) {
        int v0 = 0;
        int v1 = 0;
        while(v1 < this.mConstraintSetMap.size()) {
            int v2 = this.mConstraintSetMap.keyAt(v1);
            if(this.hasCycleDependency(v2)) {
                Log.e("MotionScene", "Cannot be derived from yourself");
                return;
            }
            else {
                this.readConstraintChain(v2);
                ++v1;
                continue;
            }

            break;
        }

        while(v0 < this.mConstraintSetMap.size()) {
            this.mConstraintSetMap.valueAt(v0).readFallback(((ConstraintLayout)arg5));
            ++v0;
        }
    }

    public void removeTransition(Transition arg2) {
        int v2 = this.getIndex(arg2);
        if(v2 != -1) {
            this.mTransitionList.remove(v2);
        }
    }

    public void setConstraintSet(int arg1, ConstraintSet arg2) {
        this.mConstraintSetMap.put(arg1, arg2);
    }

    public void setDuration(int arg2) {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null) {
            v0.setDuration(arg2);
            return;
        }

        this.mDefaultDuration = arg2;
    }

    public void setKeyframe(View arg3, int arg4, String arg5, Object arg6) {
        Transition v2 = this.mCurrentTransition;
        if(v2 == null) {
        }
        else {
            Iterator v2_1 = Transition.access$1300(v2).iterator();
        label_5:
            if(v2_1.hasNext()) {
                Iterator v0 = v2_1.next().getKeyFramesForView(arg3.getId()).iterator();
                while(true) {
                    if(!v0.hasNext()) {
                        goto label_5;
                    }

                    if(v0.next().mFramePosition != arg4) {
                        continue;
                    }

                    if(arg6 != null) {
                        arg6.floatValue();
                    }

                    arg5.equalsIgnoreCase("app:PerpendicularPath_percent");
                }
            }
        }
    }

    public void setRtl(boolean arg1) {
        this.mRtl = arg1;
        Transition v1 = this.mCurrentTransition;
        if(v1 != null && Transition.access$200(v1) != null) {
            Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        }
    }

    public void setTransition(Transition arg1) {
        this.mCurrentTransition = arg1;
        if(arg1 != null && Transition.access$200(arg1) != null) {
            Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        }
    }

    void setTransition(int arg7, int arg8) {
        Object v7_1;
        Object v4;
        int v2;
        int v0_1;
        StateSet v0 = this.mStateSet;
        int v1 = -1;
        if(v0 != null) {
            v0_1 = v0.stateGetConstraintID(arg7, v1, v1);
            if(v0_1 != v1) {
            }
            else {
                v0_1 = arg7;
            }

            v2 = this.mStateSet.stateGetConstraintID(arg8, v1, v1);
            if(v2 == v1) {
                goto label_12;
            }
        }
        else {
            v0_1 = arg7;
        label_12:
            v2 = arg8;
        }

        Iterator v3 = this.mTransitionList.iterator();
        do {
        label_15:
            if(!v3.hasNext()) {
                goto label_35;
            }

            v4 = v3.next();
            if(Transition.access$000(((Transition)v4)) == v2 && Transition.access$100(((Transition)v4)) == v0_1) {
                break;
            }

            if(Transition.access$000(((Transition)v4)) != arg8) {
                goto label_15;
            }
        }
        while(Transition.access$100(((Transition)v4)) != arg7);

        this.mCurrentTransition = ((Transition)v4);
        if(v4 != null && Transition.access$200(((Transition)v4)) != null) {
            Transition.access$200(this.mCurrentTransition).setRTL(this.mRtl);
        }

        return;
    label_35:
        Transition v7 = this.mDefaultTransition;
        v3 = this.mAbstractTransitionList.iterator();
        while(v3.hasNext()) {
            v4 = v3.next();
            if(Transition.access$000(((Transition)v4)) != arg8) {
                continue;
            }

            v7_1 = v4;
        }

        Transition v8 = new Transition(this, ((Transition)v7_1));
        Transition.access$102(v8, v0_1);
        Transition.access$002(v8, v2);
        if(v0_1 != v1) {
            this.mTransitionList.add(v8);
        }

        this.mCurrentTransition = v8;
    }

    void setupTouch() {
        Transition v0 = this.mCurrentTransition;
        if(v0 != null && Transition.access$200(v0) != null) {
            Transition.access$200(this.mCurrentTransition).setupTouch();
        }
    }

    public static String stripID(String arg1) {
        if(arg1 == null) {
            return "";
        }

        int v0 = arg1.indexOf(0x2F);
        if(v0 < 0) {
            return arg1;
        }

        return arg1.substring(v0 + 1);
    }

    boolean supportTouch() {
        Iterator v0 = this.mTransitionList.iterator();
        do {
            if(!v0.hasNext()) {
                goto label_9;
            }
        }
        while(Transition.access$200(v0.next()) == null);

        return 1;
    label_9:
        Transition v3 = this.mCurrentTransition;
        if(v3 != null && Transition.access$200(v3) != null) {
            return 1;
        }

        return 0;
    }

    public boolean validateLayout(MotionLayout arg2) {
        if(arg2 == this.mMotionLayout && arg2.mScene == this) {
            return 1;
        }

        return 0;
    }
}

