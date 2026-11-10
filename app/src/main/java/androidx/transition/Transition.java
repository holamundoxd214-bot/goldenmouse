package androidx.transition;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowId;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.util.Consumer;
import androidx.core.view.ViewCompat;
import androidx.dynamicanimation.animation.DynamicAnimation$OnAnimationUpdateListener;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.FloatValueHolder;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import org.xmlpull.v1.XmlPullParser;

public abstract class Transition implements Cloneable {
    class androidx.transition.Transition$1 extends PathMotion {
        androidx.transition.Transition$1() {
            super();
        }

        public Path getPath(float arg1, float arg2, float arg3, float arg4) {
            Path v0 = new Path();
            v0.moveTo(arg1, arg2);
            v0.lineTo(arg3, arg4);
            return v0;
        }
    }

    class AnimationInfo {
        Animator mAnimator;
        String mName;
        Transition mTransition;
        TransitionValues mValues;
        View mView;
        WindowId mWindowId;

        AnimationInfo(View arg1, String arg2, Transition arg3, WindowId arg4, TransitionValues arg5, Animator arg6) {
            super();
            this.mView = arg1;
            this.mName = arg2;
            this.mValues = arg5;
            this.mWindowId = arg4;
            this.mTransition = arg3;
            this.mAnimator = arg6;
        }
    }

    class ArrayListManager {
        private ArrayListManager() {
            super();
        }

        static ArrayList add(ArrayList arg1, Object arg2) {
            if(arg1 == null) {
                arg1 = new ArrayList();
            }

            if(!arg1.contains(arg2)) {
                arg1.add(arg2);
            }

            return arg1;
        }

        static ArrayList remove(ArrayList arg0, Object arg1) {
            if(arg0 != null) {
                arg0.remove(arg1);
                if(arg0.isEmpty()) {
                    arg0 = null;
                }
            }

            return arg0;
        }
    }

    public abstract class EpicenterCallback {
        public EpicenterCallback() {
            super();
        }

        public abstract Rect onGetEpicenter(Transition arg1);
    }

    class Impl26 {
        private Impl26() {
            super();
        }

        static long getTotalDuration(Animator arg2) {
            return arg2.getTotalDuration();
        }

        static void setCurrentPlayTime(Animator arg0, long arg1) {
            ((AnimatorSet)arg0).setCurrentPlayTime(arg1);
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface MatchOrder {
    }

    class SeekController extends TransitionListenerAdapter implements OnAnimationUpdateListener, TransitionSeekController {
        private static final int ON_READY_ANIMATE_TO_END = 1;
        private static final int ON_READY_ANIMATE_TO_START = 2;
        private static final int ON_READY_NOTHING;
        private long mCurrentPlayTime;
        private boolean mIsCanceled;
        private boolean mIsReady;
        private Consumer[] mListenerCache;
        private ArrayList mOnProgressListeners;
        private int mOnReady;
        private ArrayList mOnReadyListeners;
        private Runnable mResetToStartState;
        private SpringAnimation mSpringAnimation;
        private final VelocityTracker1D mVelocityTracker;

        SeekController(Transition arg3) {
            Transition.this = arg3;
            super();
            this.mCurrentPlayTime = -1;
            this.mOnReadyListeners = null;
            this.mOnProgressListeners = null;
            this.mOnReady = 0;
            this.mListenerCache = null;
            this.mVelocityTracker = new VelocityTracker1D();
        }

        public void addOnProgressChangedListener(Consumer arg2) {
            ArrayList v0 = this.mOnProgressListeners;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mOnProgressListeners = v0;
            }

            v0.add(arg2);
        }

        public void addOnReadyListener(Consumer arg2) {
            if(this.isReady()) {
                arg2.accept(this);
                return;
            }

            ArrayList v0 = this.mOnReadyListeners;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mOnReadyListeners = v0;
            }

            v0.add(arg2);
        }

        public void animateToEnd() {
            if(!this.mIsReady) {
                this.mOnReady = 1;
                this.mResetToStartState = null;
                return;
            }

            this.ensureAnimation();
            this.mSpringAnimation.animateToFinalPosition(((float)(this.getDurationMillis() + 1)));
        }

        public void animateToStart(Runnable arg1) {
            this.mResetToStartState = arg1;
            if(!this.mIsReady) {
                this.mOnReady = 2;
                return;
            }

            this.ensureAnimation();
            this.mSpringAnimation.animateToFinalPosition(0f);
        }

        private void callProgressListeners() {
            ArrayList v0 = this.mOnProgressListeners;
            if(v0 != null) {
                if(v0.isEmpty()) {
                }
                else {
                    int v0_1 = this.mOnProgressListeners.size();
                    Consumer[] v1 = this.mListenerCache;
                    if(v1 == null) {
                        v1 = new Consumer[v0_1];
                        this.mListenerCache = v1;
                    }

                    Object[] v1_1 = this.mOnProgressListeners.toArray(((Object[])v1));
                    Consumer[] v2 = null;
                    this.mListenerCache = v2;
                    int v3;
                    for(v3 = 0; v3 < v0_1; ++v3) {
                        v1_1[v3].accept(this);
                        v1_1[v3] = v2;
                    }

                    this.mListenerCache = ((Consumer[])v1_1);
                }
            }
        }

        private void ensureAnimation() {
            if(this.mSpringAnimation != null) {
                return;
            }

            this.mVelocityTracker.addDataPoint(AnimationUtils.currentAnimationTimeMillis(), ((float)this.mCurrentPlayTime));
            this.mSpringAnimation = new SpringAnimation(new FloatValueHolder());
            SpringForce v0 = new SpringForce();
            v0.setDampingRatio(1f);
            v0.setStiffness(200f);
            this.mSpringAnimation.setSpring(v0);
            this.mSpringAnimation.setStartValue(((float)this.mCurrentPlayTime));
            this.mSpringAnimation.addUpdateListener(((OnAnimationUpdateListener)this));
            this.mSpringAnimation.setStartVelocity(this.mVelocityTracker.calculateVelocity());
            this.mSpringAnimation.setMaxValue(((float)(this.getDurationMillis() + 1)));
            this.mSpringAnimation.setMinValue(-1f);
            this.mSpringAnimation.setMinimumVisibleChange(4f);
            this.mSpringAnimation.addEndListener(new Transition$SeekController$$ExternalSyntheticLambda0(this));
        }

        public float getCurrentFraction() {
            return (((float)this.getCurrentPlayTimeMillis())) / (((float)this.getDurationMillis()));
        }

        public long getCurrentPlayTimeMillis() {
            return Math.min(this.getDurationMillis(), Math.max(0, this.mCurrentPlayTime));
        }

        public long getDurationMillis() {
            return Transition.this.getTotalDurationMillis();
        }

        void initPlayTime() {
            long v2 = 0;
            if(this.getDurationMillis() == v2) {
                v2 = 1;
            }

            Transition.this.setCurrentPlayTimeMillis(v2, this.mCurrentPlayTime);
            this.mCurrentPlayTime = v2;
        }

        public boolean isReady() {
            return this.mIsReady;
        }

        void lambda$ensureAnimation$0$androidx-transition-Transition$SeekController(DynamicAnimation arg5, boolean arg6, float arg7, float arg8) {
            if(!arg6) {
                if(Float.compare(arg7, 1f) < 0) {
                    long v7 = this.getDurationMillis();
                    Transition v5 = Transition.this.getTransitionAt(0);
                    Transition v6 = v5.mCloneParent;
                    v5.mCloneParent = null;
                    Transition.this.setCurrentPlayTimeMillis(-1, this.mCurrentPlayTime);
                    Transition.this.setCurrentPlayTimeMillis(v7, -1);
                    this.mCurrentPlayTime = v7;
                    Runnable v5_1 = this.mResetToStartState;
                    if(v5_1 != null) {
                        v5_1.run();
                    }

                    Transition.this.mAnimators.clear();
                    if(v6 == null) {
                        return;
                    }

                    v6.notifyListeners(TransitionNotification.ON_END, true);
                    return;
                }
                else {
                    Transition.this.notifyListeners(TransitionNotification.ON_END, false);
                }
            }
        }

        public void onAnimationUpdate(DynamicAnimation arg5, float arg6, float arg7) {
            long v5 = Math.max(-1, Math.min(this.getDurationMillis() + 1, Math.round(((double)arg6))));
            Transition.this.setCurrentPlayTimeMillis(v5, this.mCurrentPlayTime);
            this.mCurrentPlayTime = v5;
            this.callProgressListeners();
        }

        public void onTransitionCancel(Transition arg1) {
            this.mIsCanceled = true;
        }

        public void ready() {
            this.mIsReady = true;
            ArrayList v1 = this.mOnReadyListeners;
            if(v1 != null) {
                this.mOnReadyListeners = null;
                int v3;
                for(v3 = 0; v3 < v1.size(); ++v3) {
                    v1.get(v3).accept(this);
                }
            }

            this.callProgressListeners();
            int v1_1 = this.mOnReady;
            if(v1_1 == 1) {
                this.mOnReady = 0;
                this.animateToEnd();
                return;
            }

            if(v1_1 == 2) {
                this.mOnReady = 0;
                this.animateToStart(this.mResetToStartState);
            }
        }

        public void removeOnProgressChangedListener(Consumer arg1) {
            ArrayList v0 = this.mOnProgressListeners;
            if(v0 != null) {
                v0.remove(arg1);
            }
        }

        public void removeOnReadyListener(Consumer arg2) {
            ArrayList v0 = this.mOnReadyListeners;
            if(v0 != null) {
                v0.remove(arg2);
                if(this.mOnReadyListeners.isEmpty()) {
                    this.mOnReadyListeners = null;
                }
            }
        }

        public void setCurrentFraction(float arg3) {
            if(this.mSpringAnimation == null) {
                this.setCurrentPlayTimeMillis(((long)(arg3 * (((float)this.getDurationMillis())))));
                return;
            }

            throw new IllegalStateException("setCurrentFraction() called after animation has been started");
        }

        public void setCurrentPlayTimeMillis(long arg5) {
            if(this.mSpringAnimation == null) {
                if(arg5 != this.mCurrentPlayTime) {
                    if(!this.isReady()) {
                    }
                    else {
                        if(!this.mIsCanceled) {
                            long v0 = 0;
                            if(arg5 != v0 || this.mCurrentPlayTime <= v0) {
                                v0 = this.getDurationMillis();
                                if(arg5 == v0 && this.mCurrentPlayTime < v0) {
                                    arg5 = v0 + 1;
                                }
                            }
                            else {
                                arg5 = -1;
                            }

                            v0 = this.mCurrentPlayTime;
                            if(arg5 == v0) {
                                goto label_27;
                            }

                            Transition.this.setCurrentPlayTimeMillis(arg5, v0);
                            this.mCurrentPlayTime = arg5;
                        }

                    label_27:
                        this.callProgressListeners();
                        this.mVelocityTracker.addDataPoint(AnimationUtils.currentAnimationTimeMillis(), ((float)arg5));
                    }
                }

                return;
            }

            throw new IllegalStateException("setCurrentPlayTimeMillis() called after animation has been started");
        }
    }

    public interface TransitionListener {
        void onTransitionCancel(Transition arg1);

        void onTransitionEnd(Transition arg1);

        default void onTransitionEnd(Transition arg1, boolean arg2) {
            this.onTransitionEnd(arg1);
        }

        void onTransitionPause(Transition arg1);

        void onTransitionResume(Transition arg1);

        void onTransitionStart(Transition arg1);

        default void onTransitionStart(Transition arg1, boolean arg2) {
            this.onTransitionStart(arg1);
        }
    }

    interface TransitionNotification {
        public static final TransitionNotification ON_CANCEL;
        public static final TransitionNotification ON_END;
        public static final TransitionNotification ON_PAUSE;
        public static final TransitionNotification ON_RESUME;
        public static final TransitionNotification ON_START;

        static {
            TransitionNotification.ON_START = new Transition$TransitionNotification$$ExternalSyntheticLambda0();
            TransitionNotification.ON_END = new Transition$TransitionNotification$$ExternalSyntheticLambda1();
            TransitionNotification.ON_CANCEL = new Transition$TransitionNotification$$ExternalSyntheticLambda2();
            TransitionNotification.ON_PAUSE = new Transition$TransitionNotification$$ExternalSyntheticLambda3();
            TransitionNotification.ON_RESUME = new Transition$TransitionNotification$$ExternalSyntheticLambda4();
        }

        static void lambda$static$0(TransitionListener arg0, Transition arg1, boolean arg2) {
            arg0.onTransitionCancel(arg1);
        }

        static void lambda$static$1(TransitionListener arg0, Transition arg1, boolean arg2) {
            arg0.onTransitionPause(arg1);
        }

        static void lambda$static$2(TransitionListener arg0, Transition arg1, boolean arg2) {
            arg0.onTransitionResume(arg1);
        }

        void notifyListener(TransitionListener arg1, Transition arg2, boolean arg3);
    }

    static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = null;
    private static final Animator[] EMPTY_ANIMATOR_ARRAY = null;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION;
    private Animator[] mAnimatorCache;
    ArrayList mAnimators;
    boolean mCanRemoveViews;
    private Transition mCloneParent;
    ArrayList mCurrentAnimators;
    long mDuration;
    private TransitionValuesMaps mEndValues;
    private ArrayList mEndValuesList;
    boolean mEnded;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator;
    private ArrayList mListeners;
    private TransitionListener[] mListenersCache;
    private int[] mMatchOrder;
    private String mName;
    private ArrayMap mNameOverrides;
    int mNumInstances;
    TransitionSet mParent;
    private PathMotion mPathMotion;
    private boolean mPaused;
    TransitionPropagation mPropagation;
    SeekController mSeekController;
    long mSeekOffsetInParent;
    private long mStartDelay;
    private TransitionValuesMaps mStartValues;
    private ArrayList mStartValuesList;
    private ArrayList mTargetChildExcludes;
    private ArrayList mTargetExcludes;
    private ArrayList mTargetIdChildExcludes;
    private ArrayList mTargetIdExcludes;
    ArrayList mTargetIds;
    private ArrayList mTargetNameExcludes;
    private ArrayList mTargetNames;
    private ArrayList mTargetTypeChildExcludes;
    private ArrayList mTargetTypeExcludes;
    private ArrayList mTargetTypes;
    ArrayList mTargets;
    long mTotalDuration;
    private static ThreadLocal sRunningAnimators;

    static {
        Transition.EMPTY_ANIMATOR_ARRAY = new Animator[0];
        Transition.DEFAULT_MATCH_ORDER = new int[]{2, 1, 3, 4};
        Transition.STRAIGHT_PATH_MOTION = new androidx.transition.Transition$1();
        Transition.sRunningAnimators = new ThreadLocal();
    }

    public Transition() {
        super();
        this.mName = this.getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = Transition.DEFAULT_MATCH_ORDER;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mAnimatorCache = Transition.EMPTY_ANIMATOR_ARRAY;
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mCloneParent = null;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = Transition.STRAIGHT_PATH_MOTION;
    }

    public Transition(Context arg9, AttributeSet arg10) {
        super();
        this.mName = this.getClass().getName();
        this.mStartDelay = -1;
        this.mDuration = -1;
        this.mInterpolator = null;
        this.mTargetIds = new ArrayList();
        this.mTargets = new ArrayList();
        this.mTargetNames = null;
        this.mTargetTypes = null;
        this.mTargetIdExcludes = null;
        this.mTargetExcludes = null;
        this.mTargetTypeExcludes = null;
        this.mTargetNameExcludes = null;
        this.mTargetIdChildExcludes = null;
        this.mTargetChildExcludes = null;
        this.mTargetTypeChildExcludes = null;
        this.mStartValues = new TransitionValuesMaps();
        this.mEndValues = new TransitionValuesMaps();
        this.mParent = null;
        this.mMatchOrder = Transition.DEFAULT_MATCH_ORDER;
        this.mCanRemoveViews = false;
        this.mCurrentAnimators = new ArrayList();
        this.mAnimatorCache = Transition.EMPTY_ANIMATOR_ARRAY;
        this.mNumInstances = 0;
        this.mPaused = false;
        this.mEnded = false;
        this.mCloneParent = null;
        this.mListeners = null;
        this.mAnimators = new ArrayList();
        this.mPathMotion = Transition.STRAIGHT_PATH_MOTION;
        TypedArray v0 = arg9.obtainStyledAttributes(arg10, Styleable.TRANSITION);
        int v4 = -1;
        long v2 = ((long)TypedArrayUtils.getNamedInt(v0, ((XmlPullParser)arg10), "duration", 1, v4));
        long v5 = 0;
        if(v2 >= v5) {
            this.setDuration(v2);
        }

        v2 = ((long)TypedArrayUtils.getNamedInt(v0, ((XmlPullParser)arg10), "startDelay", 2, v4));
        if(v2 > v5) {
            this.setStartDelay(v2);
        }

        int v1 = TypedArrayUtils.getNamedResourceId(v0, ((XmlPullParser)arg10), "interpolator", 0, 0);
        if(v1 > 0) {
            this.setInterpolator(AnimationUtils.loadInterpolator(arg9, v1));
        }

        String v9 = TypedArrayUtils.getNamedString(v0, ((XmlPullParser)arg10), "matchOrder", 3);
        if(v9 != null) {
            this.setMatchOrder(Transition.parseMatchOrder(v9));
        }

        v0.recycle();
    }

    static Transition access$000(Transition arg0) {
        return arg0.mCloneParent;
    }

    static Transition access$002(Transition arg0, Transition arg1) {
        arg0.mCloneParent = arg1;
        return arg1;
    }

    public Transition addListener(TransitionListener arg2) {
        ArrayList v0 = this.mListeners;
        if(v0 == null) {
            v0 = new ArrayList();
            this.mListeners = v0;
        }

        v0.add(arg2);
        return this;
    }

    public Transition addTarget(int arg2) {
        if(arg2 != 0) {
            this.mTargetIds.add(Integer.valueOf(arg2));
        }

        return this;
    }

    public Transition addTarget(View arg2) {
        this.mTargets.add(arg2);
        return this;
    }

    public Transition addTarget(Class arg2) {
        ArrayList v0 = this.mTargetTypes;
        if(v0 == null) {
            v0 = new ArrayList();
            this.mTargetTypes = v0;
        }

        v0.add(arg2);
        return this;
    }

    public Transition addTarget(String arg2) {
        ArrayList v0 = this.mTargetNames;
        if(v0 == null) {
            v0 = new ArrayList();
            this.mTargetNames = v0;
        }

        v0.add(arg2);
        return this;
    }

    private void addUnmatched(ArrayMap arg6, ArrayMap arg7) {
        Object v3;
        int v0 = 0;
        int v1 = 0;
        while(true) {
            v3 = null;
            if(v1 < arg6.size()) {
                Object v2 = arg6.valueAt(v1);
                if(this.isValidTarget(((TransitionValues)v2).view)) {
                    this.mStartValuesList.add(v2);
                    this.mEndValuesList.add(v3);
                }

                ++v1;
                continue;
            }

            break;
        }

        while(v0 < arg7.size()) {
            Object v6 = arg7.valueAt(v0);
            if(this.isValidTarget(((TransitionValues)v6).view)) {
                this.mEndValuesList.add(v6);
                this.mStartValuesList.add(v3);
            }

            ++v0;
        }
    }

    private static void addViewValues(TransitionValuesMaps arg3, View arg4, TransitionValues arg5) {
        arg3.mViewValues.put(arg4, arg5);
        int v5 = arg4.getId();
        Object v0 = null;
        if(v5 >= 0) {
            if(arg3.mIdValues.indexOfKey(v5) >= 0) {
                arg3.mIdValues.put(v5, v0);
            }
            else {
                arg3.mIdValues.put(v5, arg4);
            }
        }

        String v5_1 = ViewCompat.getTransitionName(arg4);
        if(v5_1 != null) {
            if(arg3.mNameValues.containsKey(v5_1)) {
                arg3.mNameValues.put(v5_1, v0);
            }
            else {
                arg3.mNameValues.put(v5_1, arg4);
            }
        }

        if((arg4.getParent() instanceof ListView)) {
            ViewParent v5_2 = arg4.getParent();
            if(((ListView)v5_2).getAdapter().hasStableIds()) {
                long v1 = ((ListView)v5_2).getItemIdAtPosition(((ListView)v5_2).getPositionForView(arg4));
                if(arg3.mItemIdValues.indexOfKey(v1) >= 0) {
                    Object v4 = arg3.mItemIdValues.get(v1);
                    if(v4 != null) {
                        ((View)v4).setHasTransientState(false);
                        arg3.mItemIdValues.put(v1, v0);
                        return;
                    }
                }
                else {
                    arg4.setHasTransientState(true);
                    arg3.mItemIdValues.put(v1, arg4);
                }
            }
        }
    }

    private static boolean alreadyContains(int[] arg4, int arg5) {
        int v0 = arg4[arg5];
        int v2;
        for(v2 = 0; v2 < arg5; ++v2) {
            if(arg4[v2] == v0) {
                return 1;
            }
        }

        return 0;
    }

    protected void animate(Animator arg5) {
        if(arg5 == null) {
            this.end();
            return;
        }

        long v2 = 0;
        if(this.getDuration() >= v2) {
            arg5.setDuration(this.getDuration());
        }

        if(this.getStartDelay() >= v2) {
            arg5.setStartDelay(this.getStartDelay() + arg5.getStartDelay());
        }

        if(this.getInterpolator() != null) {
            arg5.setInterpolator(this.getInterpolator());
        }

        arg5.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg2) {
                Transition.this.end();
                arg2.removeListener(((Animator$AnimatorListener)this));
            }
        });
        arg5.start();
    }

    protected void cancel() {
        int v0 = this.mCurrentAnimators.size();
        Object[] v1 = this.mCurrentAnimators.toArray(this.mAnimatorCache);
        this.mAnimatorCache = Transition.EMPTY_ANIMATOR_ARRAY;
        --v0;
        while(v0 >= 0) {
            Object v2 = v1[v0];
            v1[v0] = null;
            ((Animator)v2).cancel();
            --v0;
        }

        this.mAnimatorCache = ((Animator[])v1);
        this.notifyListeners(TransitionNotification.ON_CANCEL, false);
    }

    public abstract void captureEndValues(TransitionValues arg1);

    private void captureHierarchy(View arg6, boolean arg7) {
        int v1_1;
        if(arg6 == null) {
        }
        else {
            int v0 = arg6.getId();
            ArrayList v1 = this.mTargetIdExcludes;
            if(v1 != null && (v1.contains(Integer.valueOf(v0)))) {
                return;
            }

            v1 = this.mTargetExcludes;
            if(v1 != null && (v1.contains(arg6))) {
                return;
            }

            v1 = this.mTargetTypeExcludes;
            int v2 = 0;
            if(v1 != null) {
                v1_1 = v1.size();
                int v3 = 0;
                while(v3 < v1_1) {
                    if(this.mTargetTypeExcludes.get(v3).isInstance(arg6)) {
                        return;
                    }
                    else {
                        ++v3;
                        continue;
                    }
                }
            }

            if((arg6.getParent() instanceof ViewGroup)) {
                TransitionValues v1_2 = new TransitionValues(arg6);
                if(arg7) {
                    this.captureStartValues(v1_2);
                }
                else {
                    this.captureEndValues(v1_2);
                }

                v1_2.mTargetedTransitions.add(this);
                this.capturePropagationValues(v1_2);
                if(arg7) {
                    Transition.addViewValues(this.mStartValues, arg6, v1_2);
                    goto label_45;
                }

                Transition.addViewValues(this.mEndValues, arg6, v1_2);
            }

        label_45:
            if(!(arg6 instanceof ViewGroup)) {
                return;
            }

            v1 = this.mTargetIdChildExcludes;
            if(v1 != null && (v1.contains(Integer.valueOf(v0)))) {
                return;
            }

            ArrayList v0_1 = this.mTargetChildExcludes;
            if(v0_1 != null && (v0_1.contains(arg6))) {
                return;
            }

            v0_1 = this.mTargetTypeChildExcludes;
            if(v0_1 != null) {
                v0 = v0_1.size();
                v1_1 = 0;
                while(v1_1 < v0) {
                    if(this.mTargetTypeChildExcludes.get(v1_1).isInstance(arg6)) {
                        return;
                    }
                    else {
                        ++v1_1;
                        continue;
                    }
                }
            }

            while(v2 < ((ViewGroup)arg6).getChildCount()) {
                this.captureHierarchy(((ViewGroup)arg6).getChildAt(v2), arg7);
                ++v2;
            }
        }
    }

    void capturePropagationValues(TransitionValues arg5) {
        if(this.mPropagation != null && !arg5.values.isEmpty()) {
            String[] v0 = this.mPropagation.getPropagationProperties();
            if(v0 == null) {
            }
            else {
                int v1 = 0;
                while(v1 < v0.length) {
                    if(!arg5.values.containsKey(v0[v1])) {
                        this.mPropagation.captureValues(arg5);
                        return;
                    }
                    else {
                        ++v1;
                        continue;
                    }

                    return;
                }
            }
        }
    }

    public abstract void captureStartValues(TransitionValues arg1);

    void captureValues(ViewGroup arg6, boolean arg7) {
        Object v0_2;
        this.clearValues(arg7);
        int v1 = 0;
        if(this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            ArrayList v0 = this.mTargetNames;
            if(v0 != null && !v0.isEmpty()) {
                goto label_17;
            }

            v0 = this.mTargetTypes;
            if(v0 != null) {
                if(v0.isEmpty()) {
                }
                else {
                label_17:
                    this.captureHierarchy(((View)arg6), arg7);
                    goto label_68;
                }
            }

            int v0_1;
            for(v0_1 = 0; v0_1 < this.mTargetIds.size(); ++v0_1) {
                View v2 = arg6.findViewById(this.mTargetIds.get(v0_1).intValue());
                if(v2 != null) {
                    TransitionValues v3 = new TransitionValues(v2);
                    if(arg7) {
                        this.captureStartValues(v3);
                    }
                    else {
                        this.captureEndValues(v3);
                    }

                    v3.mTargetedTransitions.add(this);
                    this.capturePropagationValues(v3);
                    if(arg7) {
                        Transition.addViewValues(this.mStartValues, v2, v3);
                        goto label_43;
                    }

                    Transition.addViewValues(this.mEndValues, v2, v3);
                }

            label_43:
            }

            int v6;
            for(v6 = 0; v6 < this.mTargets.size(); ++v6) {
                v0_2 = this.mTargets.get(v6);
                TransitionValues v2_1 = new TransitionValues(((View)v0_2));
                if(arg7) {
                    this.captureStartValues(v2_1);
                }
                else {
                    this.captureEndValues(v2_1);
                }

                v2_1.mTargetedTransitions.add(this);
                this.capturePropagationValues(v2_1);
                if(arg7) {
                    Transition.addViewValues(this.mStartValues, ((View)v0_2), v2_1);
                }
                else {
                    Transition.addViewValues(this.mEndValues, ((View)v0_2), v2_1);
                }
            }
        }
        else {
            goto label_17;
        }

    label_68:
        if(!arg7) {
            ArrayMap v6_1 = this.mNameOverrides;
            if(v6_1 != null) {
                v6 = v6_1.size();
                ArrayList v7 = new ArrayList(v6);
                for(v0_1 = 0; v0_1 < v6; ++v0_1) {
                    v7.add(this.mStartValues.mNameValues.remove(this.mNameOverrides.keyAt(v0_1)));
                }

                while(v1 < v6) {
                    v0_2 = v7.get(v1);
                    if(v0_2 != null) {
                        this.mStartValues.mNameValues.put(this.mNameOverrides.valueAt(v1), v0_2);
                    }

                    ++v1;
                }
            }
        }
    }

    void clearValues(boolean arg1) {
        if(arg1) {
            this.mStartValues.mViewValues.clear();
            this.mStartValues.mIdValues.clear();
            this.mStartValues.mItemIdValues.clear();
            return;
        }

        this.mEndValues.mViewValues.clear();
        this.mEndValues.mIdValues.clear();
        this.mEndValues.mItemIdValues.clear();
    }

    public Transition clone() {
        try {
            Object v0 = super.clone();
            ((Transition)v0).mAnimators = new ArrayList();
            ((Transition)v0).mStartValues = new TransitionValuesMaps();
            ((Transition)v0).mEndValues = new TransitionValuesMaps();
            ((Transition)v0).mStartValuesList = null;
            ((Transition)v0).mEndValuesList = null;
            ((Transition)v0).mSeekController = null;
            ((Transition)v0).mCloneParent = this;
            ((Transition)v0).mListeners = null;
            return ((Transition)v0);
        }
        catch(CloneNotSupportedException v2) {
            throw new RuntimeException(((Throwable)v2));
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return this.clone();
    }

    public Animator createAnimator(ViewGroup arg1, TransitionValues arg2, TransitionValues arg3) {
        return null;
    }

    void createAnimators(ViewGroup arg24, TransitionValuesMaps arg25, TransitionValuesMaps arg26, ArrayList arg27, ArrayList arg28) {
        Animator v1_2;
        long v10_2;
        Animator v5_1;
        View v20;
        int v11_1;
        int v19;
        int v18;
        int v17;
        TransitionValues v6_1;
        Animator v16;
        View v5;
        Object v2;
        Transition v3 = this;
        ViewGroup v7 = arg24;
        ArrayMap v8 = Transition.getRunningAnimators();
        SparseIntArray v9 = new SparseIntArray();
        int v10 = arg27.size();
        int v12 = v3.getRootTransition().mSeekController != null ? 1 : 0;
        long v0 = 0x7FFFFFFFFFFFFFFFL;
        int v13 = 0;
        while(v13 < v10) {
            v2 = arg27.get(v13);
            Object v4 = arg28.get(v13);
            if(v2 != null && !((TransitionValues)v2).mTargetedTransitions.contains(v3)) {
                v2 = null;
            }

            if(v4 != null && !((TransitionValues)v4).mTargetedTransitions.contains(v3)) {
                v4 = null;
            }

            if(v2 != null || v4 != null) {
                if(v2 == null || v4 == null || (v3.isTransitionRequired(((TransitionValues)v2), ((TransitionValues)v4)))) {
                    Animator v6 = v3.createAnimator(v7, ((TransitionValues)v2), ((TransitionValues)v4));
                    if(v6 != null) {
                        if(v4 != null) {
                            v5 = ((TransitionValues)v4).view;
                            String[] v11 = v3.getTransitionProperties();
                            v16 = v6;
                            if(v11 == null || v11.length <= 0) {
                                v20 = v5;
                                v17 = v10;
                                v18 = v12;
                                v19 = v13;
                                v5_1 = v16;
                                v6_1 = null;
                            }
                            else {
                                v6_1 = new TransitionValues(v5);
                                v17 = v10;
                                v18 = v12;
                                Object v12_1 = arg26.mViewValues.get(v5);
                                v19 = v13;
                                if(v12_1 != null) {
                                    v10 = 0;
                                    while(v10 < v11.length) {
                                        v6_1.values.put(v11[v10], ((TransitionValues)v12_1).values.get(v11[v10]));
                                        ++v10;
                                        v11 = v11;
                                        v12_1 = v12_1;
                                    }
                                }

                                v10 = v8.size();
                                v11_1 = 0;
                                while(v11_1 < v10) {
                                    v12_1 = v8.get(v8.keyAt(v11_1));
                                    if(((AnimationInfo)v12_1).mValues == null || ((AnimationInfo)v12_1).mView != v5) {
                                        v20 = v5;
                                    }
                                    else {
                                        v20 = v5;
                                        if((((AnimationInfo)v12_1).mName.equals(v3.getName())) && (((AnimationInfo)v12_1).mValues.equals(v6_1))) {
                                            v5_1 = null;
                                            goto label_106;
                                        }
                                    }

                                    ++v11_1;
                                    v5 = v20;
                                }

                                v20 = v5;
                                v5_1 = v16;
                            }

                        label_106:
                            v16 = v5_1;
                            v5 = v20;
                        }
                        else {
                            v16 = v6;
                            v17 = v10;
                            v18 = v12;
                            v19 = v13;
                            v5 = ((TransitionValues)v2).view;
                            v6_1 = null;
                        }

                        if(v16 == null) {
                            goto label_142;
                        }

                        TransitionPropagation v10_1 = v3.mPropagation;
                        if(v10_1 != null) {
                            v10_2 = v10_1.getStartDelay(v7, v3, ((TransitionValues)v2), ((TransitionValues)v4));
                            v9.put(v3.mAnimators.size(), ((int)v10_2));
                            v0 = Math.min(v10_2, v0);
                        }

                        v10_2 = v0;
                        View v1 = v5;
                        TransitionValues v5_2 = v6_1;
                        v6 = v16;
                        AnimationInfo v0_1 = new AnimationInfo(v1, v3.getName(), v3, v7.getWindowId(), v5_2, v6);
                        if(v18 != 0) {
                            AnimatorSet v1_1 = new AnimatorSet();
                            v1_1.play(v6);
                        }
                        else {
                            v1_2 = v6;
                        }

                        v8.put(v1_2, v0_1);
                        v3.mAnimators.add(v1_2);
                        v0 = v10_2;
                        goto label_142;
                    }
                }

            label_32:
                v17 = v10;
                v18 = v12;
                v19 = v13;
            }
            else {
                goto label_32;
            }

        label_142:
            v13 = v19 + 1;
            v10 = v17;
            v12 = v18;
        }

        if(v9.size() != 0) {
            for(v11_1 = 0; v11_1 < v9.size(); ++v11_1) {
                v2 = v8.get(v3.mAnimators.get(v9.keyAt(v11_1)));
                ((AnimationInfo)v2).mAnimator.setStartDelay((((long)v9.valueAt(v11_1))) - v0 + ((AnimationInfo)v2).mAnimator.getStartDelay());
            }
        }
    }

    TransitionSeekController createSeekController() {
        SeekController v0 = new SeekController(this);
        this.mSeekController = v0;
        this.addListener(((TransitionListener)v0));
        return this.mSeekController;
    }

    protected void end() {
        Object v3;
        int v0 = this.mNumInstances - 1;
        this.mNumInstances = v0;
        if(v0 == 0) {
            this.notifyListeners(TransitionNotification.ON_END, false);
            for(v0 = 0; v0 < this.mStartValues.mItemIdValues.size(); ++v0) {
                v3 = this.mStartValues.mItemIdValues.valueAt(v0);
                if(v3 != null) {
                    ((View)v3).setHasTransientState(false);
                }
            }

            for(v0 = 0; v0 < this.mEndValues.mItemIdValues.size(); ++v0) {
                v3 = this.mEndValues.mItemIdValues.valueAt(v0);
                if(v3 != null) {
                    ((View)v3).setHasTransientState(false);
                }
            }

            this.mEnded = true;
        }
    }

    public Transition excludeChildren(int arg2, boolean arg3) {
        this.mTargetIdChildExcludes = this.excludeId(this.mTargetIdChildExcludes, arg2, arg3);
        return this;
    }

    public Transition excludeChildren(View arg2, boolean arg3) {
        this.mTargetChildExcludes = this.excludeView(this.mTargetChildExcludes, arg2, arg3);
        return this;
    }

    public Transition excludeChildren(Class arg2, boolean arg3) {
        this.mTargetTypeChildExcludes = this.excludeType(this.mTargetTypeChildExcludes, arg2, arg3);
        return this;
    }

    private ArrayList excludeId(ArrayList arg1, int arg2, boolean arg3) {
        if(arg2 > 0) {
            if(arg3) {
                return ArrayListManager.add(arg1, Integer.valueOf(arg2));
            }

            return ArrayListManager.remove(arg1, Integer.valueOf(arg2));
        }

        return arg1;
    }

    private static ArrayList excludeObject(ArrayList arg0, Object arg1, boolean arg2) {
        if(arg1 != null) {
            if(arg2) {
                return ArrayListManager.add(arg0, arg1);
            }
            else {
                arg0 = ArrayListManager.remove(arg0, arg1);
            }
        }

        return arg0;
    }

    public Transition excludeTarget(int arg2, boolean arg3) {
        this.mTargetIdExcludes = this.excludeId(this.mTargetIdExcludes, arg2, arg3);
        return this;
    }

    public Transition excludeTarget(View arg2, boolean arg3) {
        this.mTargetExcludes = this.excludeView(this.mTargetExcludes, arg2, arg3);
        return this;
    }

    public Transition excludeTarget(Class arg2, boolean arg3) {
        this.mTargetTypeExcludes = this.excludeType(this.mTargetTypeExcludes, arg2, arg3);
        return this;
    }

    public Transition excludeTarget(String arg2, boolean arg3) {
        this.mTargetNameExcludes = Transition.excludeObject(this.mTargetNameExcludes, arg2, arg3);
        return this;
    }

    private ArrayList excludeType(ArrayList arg1, Class arg2, boolean arg3) {
        if(arg2 != null) {
            if(arg3) {
                return ArrayListManager.add(arg1, arg2);
            }

            return ArrayListManager.remove(arg1, arg2);
        }

        return arg1;
    }

    private ArrayList excludeView(ArrayList arg1, View arg2, boolean arg3) {
        if(arg2 != null) {
            if(arg3) {
                return ArrayListManager.add(arg1, arg2);
            }

            return ArrayListManager.remove(arg1, arg2);
        }

        return arg1;
    }

    void forceToEnd(ViewGroup arg4) {
        ArrayMap v3 = Transition.getRunningAnimators();
        int v0 = v3.size();
        if(arg4 != null) {
            if(v0 == 0) {
            }
            else {
                WindowId v4 = arg4.getWindowId();
                ArrayMap v1 = new ArrayMap(((SimpleArrayMap)v3));
                v3.clear();
                --v0;
                while(v0 >= 0) {
                    Object v3_1 = v1.valueAt(v0);
                    if(((AnimationInfo)v3_1).mView != null && (v4.equals(((AnimationInfo)v3_1).mWindowId))) {
                        v1.keyAt(v0).end();
                    }

                    --v0;
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        EpicenterCallback v0 = this.mEpicenterCallback;
        if(v0 == null) {
            return null;
        }

        return v0.onGetEpicenter(this);
    }

    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    TransitionValues getMatchedTransitionValues(View arg6, boolean arg7) {
        TransitionSet v0 = this.mParent;
        if(v0 != null) {
            return v0.getMatchedTransitionValues(arg6, arg7);
        }

        ArrayList v0_1 = arg7 ? this.mStartValuesList : this.mEndValuesList;
        TransitionValues v1 = null;
        if(v0_1 == null) {
            return v1;
        }

        int v2 = v0_1.size();
        int v3 = 0;
        while(true) {
            if(v3 < v2) {
                Object v4 = v0_1.get(v3);
                if(v4 == null) {
                    return v1;
                }
                else if(((TransitionValues)v4).view == arg6) {
                }
                else {
                    ++v3;
                    continue;
                }
            }
            else {
                break;
            }

            goto label_23;
        }

        v3 = -1;
    label_23:
        if(v3 >= 0) {
            ArrayList v5 = arg7 ? this.mEndValuesList : this.mStartValuesList;
            return v5.get(v3);
        }

        return v1;
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public final Transition getRootTransition() {
        TransitionSet v0 = this.mParent;
        if(v0 != null) {
            this = v0.getRootTransition();
        }

        return this;
    }

    private static ArrayMap getRunningAnimators() {
        Object v0 = Transition.sRunningAnimators.get();
        if(v0 == null) {
            ArrayMap v0_1 = new ArrayMap();
            Transition.sRunningAnimators.set(v0_1);
        }

        return ((ArrayMap)v0);
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List getTargetIds() {
        return this.mTargetIds;
    }

    public List getTargetNames() {
        return this.mTargetNames;
    }

    public List getTargetTypes() {
        return this.mTargetTypes;
    }

    public List getTargets() {
        return this.mTargets;
    }

    final long getTotalDurationMillis() {
        return this.mTotalDuration;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View arg2, boolean arg3) {
        TransitionSet v0 = this.mParent;
        if(v0 != null) {
            return v0.getTransitionValues(arg2, arg3);
        }

        TransitionValuesMaps v1 = arg3 ? this.mStartValues : this.mEndValues;
        return v1.mViewValues.get(arg2);
    }

    boolean hasAnimators() {
        return this.mCurrentAnimators.isEmpty() ^ 1;
    }

    public boolean isSeekingSupported() {
        return 0;
    }

    public boolean isTransitionRequired(TransitionValues arg6, TransitionValues arg7) {
        if(arg6 != null && arg7 != null) {
            String[] v5 = this.getTransitionProperties();
            if(v5 != null) {
                int v2 = v5.length;
                int v3 = 0;
                while(v3 < v2) {
                    if(Transition.isValueChanged(arg6, arg7, v5[v3])) {
                        return 1;
                    }
                    else {
                        ++v3;
                        continue;
                    }

                    return 0;
                }
            }
            else {
                Iterator v5_1 = arg6.values.keySet().iterator();
                do {
                    if(v5_1.hasNext()) {
                        if(!Transition.isValueChanged(arg6, arg7, v5_1.next())) {
                            continue;
                        }

                        return 1;
                    }

                    return 0;
                }
                while(true);

                return 1;
            }
        }

        return 0;
    }

    private static boolean isValidMatch(int arg2) {
        if(arg2 >= 1 && arg2 <= 4) {
            return 1;
        }

        return 0;
    }

    boolean isValidTarget(View arg6) {
        int v0 = arg6.getId();
        ArrayList v1 = this.mTargetIdExcludes;
        if(v1 != null && (v1.contains(Integer.valueOf(v0)))) {
            return 0;
        }

        v1 = this.mTargetExcludes;
        if(v1 != null && (v1.contains(arg6))) {
            return 0;
        }

        v1 = this.mTargetTypeExcludes;
        if(v1 != null) {
            int v1_1 = v1.size();
            int v3 = 0;
            while(v3 < v1_1) {
                if(this.mTargetTypeExcludes.get(v3).isInstance(arg6)) {
                    return 0;
                }
                else {
                    ++v3;
                    continue;
                }

                break;
            }
        }

        if(this.mTargetNameExcludes != null && ViewCompat.getTransitionName(arg6) != null && (this.mTargetNameExcludes.contains(ViewCompat.getTransitionName(arg6)))) {
            return 0;
        }

        if(this.mTargetIds.size() == 0 && this.mTargets.size() == 0) {
            v1 = this.mTargetTypes;
            if(v1 != null && !v1.isEmpty()) {
                goto label_50;
            }

            v1 = this.mTargetNames;
            if(v1 != null && !v1.isEmpty()) {
                goto label_50;
            }

            return 1;
        }

    label_50:
        if(!this.mTargetIds.contains(Integer.valueOf(v0))) {
            if(this.mTargets.contains(arg6)) {
            }
            else {
                ArrayList v0_1 = this.mTargetNames;
                if(v0_1 != null && (v0_1.contains(ViewCompat.getTransitionName(arg6)))) {
                    return 1;
                }

                if(this.mTargetTypes != null) {
                    v0 = 0;
                    while(v0 < this.mTargetTypes.size()) {
                        if(this.mTargetTypes.get(v0).isInstance(arg6)) {
                            return 1;
                        }
                        else {
                            ++v0;
                            continue;
                        }

                        return 0;
                    }
                }

                return 0;
            }
        }

        return 1;
    }

    private static boolean isValueChanged(TransitionValues arg0, TransitionValues arg1, String arg2) {
        Object v0 = arg0.values.get(arg2);
        Object v1 = arg1.values.get(arg2);
        if(v0 == null && v1 == null) {
            return 0;
        }

        if(v0 != null) {
            if(v1 == null) {
            }
            else {
                return v0.equals(v1) ^ 1;
            }
        }

        return 1;
    }

    private void matchIds(ArrayMap arg8, ArrayMap arg9, SparseArray arg10, SparseArray arg11) {
        int v0 = arg10.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg10.valueAt(v1);
            if(v2 != null && (this.isValidTarget(((View)v2)))) {
                Object v3 = arg11.get(arg10.keyAt(v1));
                if(v3 != null && (this.isValidTarget(((View)v3)))) {
                    Object v4 = arg8.get(v2);
                    Object v5 = arg9.get(v3);
                    if(v4 != null && v5 != null) {
                        this.mStartValuesList.add(v4);
                        this.mEndValuesList.add(v5);
                        arg8.remove(v2);
                        arg9.remove(v3);
                    }
                }
            }
        }
    }

    private void matchInstances(ArrayMap arg5, ArrayMap arg6) {
        int v0;
        for(v0 = arg5.size() - 1; v0 >= 0; --v0) {
            Object v1 = arg5.keyAt(v0);
            if(v1 != null && (this.isValidTarget(((View)v1)))) {
                v1 = arg6.remove(v1);
                if(v1 != null && (this.isValidTarget(((TransitionValues)v1).view))) {
                    this.mStartValuesList.add(arg5.removeAt(v0));
                    this.mEndValuesList.add(v1);
                }
            }
        }
    }

    private void matchItemIds(ArrayMap arg8, ArrayMap arg9, LongSparseArray arg10, LongSparseArray arg11) {
        int v0 = arg10.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg10.valueAt(v1);
            if(v2 != null && (this.isValidTarget(((View)v2)))) {
                Object v3 = arg11.get(arg10.keyAt(v1));
                if(v3 != null && (this.isValidTarget(((View)v3)))) {
                    Object v4 = arg8.get(v2);
                    Object v5 = arg9.get(v3);
                    if(v4 != null && v5 != null) {
                        this.mStartValuesList.add(v4);
                        this.mEndValuesList.add(v5);
                        arg8.remove(v2);
                        arg9.remove(v3);
                    }
                }
            }
        }
    }

    private void matchNames(ArrayMap arg8, ArrayMap arg9, ArrayMap arg10, ArrayMap arg11) {
        int v0 = arg10.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            Object v2 = arg10.valueAt(v1);
            if(v2 != null && (this.isValidTarget(((View)v2)))) {
                Object v3 = arg11.get(arg10.keyAt(v1));
                if(v3 != null && (this.isValidTarget(((View)v3)))) {
                    Object v4 = arg8.get(v2);
                    Object v5 = arg9.get(v3);
                    if(v4 != null && v5 != null) {
                        this.mStartValuesList.add(v4);
                        this.mEndValuesList.add(v5);
                        arg8.remove(v2);
                        arg9.remove(v3);
                    }
                }
            }
        }
    }

    private void matchStartAndEnd(TransitionValuesMaps arg6, TransitionValuesMaps arg7) {
        ArrayMap v0 = new ArrayMap(arg6.mViewValues);
        ArrayMap v1 = new ArrayMap(arg7.mViewValues);
        int v2;
        for(v2 = 0; true; ++v2) {
            int[] v3 = this.mMatchOrder;
            if(v2 >= v3.length) {
                break;
            }

            int v3_1 = v3[v2];
            if(v3_1 == 1) {
                this.matchInstances(v0, v1);
            }
            else if(v3_1 == 2) {
                this.matchNames(v0, v1, arg6.mNameValues, arg7.mNameValues);
            }
            else if(v3_1 == 3) {
                this.matchIds(v0, v1, arg6.mIdValues, arg7.mIdValues);
            }
            else if(v3_1 != 4) {
            }
            else {
                this.matchItemIds(v0, v1, arg6.mItemIdValues, arg7.mItemIdValues);
            }
        }

        this.addUnmatched(v0, v1);
    }

    private void notifyFromTransition(Transition arg6, TransitionNotification arg7, boolean arg8) {
        Transition v0 = this.mCloneParent;
        if(v0 != null) {
            v0.notifyFromTransition(arg6, arg7, arg8);
        }

        ArrayList v0_1 = this.mListeners;
        if(v0_1 != null && !v0_1.isEmpty()) {
            int v0_2 = this.mListeners.size();
            TransitionListener[] v1 = this.mListenersCache;
            if(v1 == null) {
                v1 = new TransitionListener[v0_2];
            }

            TransitionListener[] v2 = null;
            this.mListenersCache = v2;
            Object[] v1_1 = this.mListeners.toArray(((Object[])v1));
            int v3;
            for(v3 = 0; v3 < v0_2; ++v3) {
                arg7.notifyListener(v1_1[v3], arg6, arg8);
                v1_1[v3] = v2;
            }

            this.mListenersCache = ((TransitionListener[])v1_1);
        }
    }

    void notifyListeners(TransitionNotification arg1, boolean arg2) {
        this.notifyFromTransition(this, arg1, arg2);
    }

    private static int[] parseMatchOrder(String arg6) {
        String v3;
        StringTokenizer v0 = new StringTokenizer(arg6, ",");
        int[] v6 = new int[v0.countTokens()];
        int v2;
        for(v2 = 0; true; ++v2) {
            if(!v0.hasMoreTokens()) {
                return v6;
            }

            v3 = v0.nextToken().trim();
            if("id".equalsIgnoreCase(v3)) {
                v6[v2] = 3;
            }
            else if("instance".equalsIgnoreCase(v3)) {
                v6[v2] = 1;
            }
            else if("name".equalsIgnoreCase(v3)) {
                v6[v2] = 2;
            }
            else if("itemId".equalsIgnoreCase(v3)) {
                v6[v2] = 4;
            }
            else if(v3.isEmpty()) {
                int[] v3_1 = new int[v6.length - 1];
                System.arraycopy(v6, 0, v3_1, 0, v2);
                --v2;
                v6 = v3_1;
            }
            else {
                break;
            }
        }

        throw new InflateException("Unknown match type in matchOrder: \'" + v3 + "\'");
        return v6;
    }

    public void pause(View arg5) {
        if(!this.mEnded) {
            int v5 = this.mCurrentAnimators.size();
            Object[] v0 = this.mCurrentAnimators.toArray(this.mAnimatorCache);
            this.mAnimatorCache = Transition.EMPTY_ANIMATOR_ARRAY;
            --v5;
            while(v5 >= 0) {
                Object v2 = v0[v5];
                v0[v5] = null;
                ((Animator)v2).pause();
                --v5;
            }

            this.mAnimatorCache = ((Animator[])v0);
            this.notifyListeners(TransitionNotification.ON_PAUSE, false);
            this.mPaused = true;
        }
    }

    void playTransition(ViewGroup arg12) {
        this.mStartValuesList = new ArrayList();
        this.mEndValuesList = new ArrayList();
        this.matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap v0 = Transition.getRunningAnimators();
        int v1 = v0.size();
        WindowId v2 = arg12.getWindowId();
        ArrayList v3 = new ArrayList();
        --v1;
        while(v1 >= 0) {
            Object v5 = v0.keyAt(v1);
            if(v5 != null) {
                Object v6 = v0.get(v5);
                if(v6 != null && ((AnimationInfo)v6).mView != null && (v2.equals(((AnimationInfo)v6).mWindowId))) {
                    TransitionValues v7 = ((AnimationInfo)v6).mValues;
                    View v8 = ((AnimationInfo)v6).mView;
                    TransitionValues v9 = this.getTransitionValues(v8, true);
                    TransitionValues v10 = this.getMatchedTransitionValues(v8, true);
                    if(v9 == null && v10 == null) {
                        Object v10_1 = this.mEndValues.mViewValues.get(v8);
                    }

                    if(v9 == null && v10 == null) {
                        goto label_62;
                    }

                    if(!((AnimationInfo)v6).mTransition.isTransitionRequired(v7, v10)) {
                        goto label_62;
                    }

                    Transition v6_1 = ((AnimationInfo)v6).mTransition;
                    if(v6_1.getRootTransition().mSeekController != null) {
                        ((Animator)v5).cancel();
                        v6_1.mCurrentAnimators.remove(v5);
                        v0.removeAt(v1);
                        if(v6_1.mCurrentAnimators.size() != 0) {
                            goto label_62;
                        }

                        v3.add(v6_1);
                        goto label_62;
                    }

                    if(!((Animator)v5).isRunning()) {
                        if(((Animator)v5).isStarted()) {
                        }
                        else {
                            v0.removeAt(v1);
                            goto label_62;
                        }
                    }

                    ((Animator)v5).cancel();
                }
            }

        label_62:
            --v1;
        }

        for(v1 = 0; v1 < v3.size(); ++v1) {
            Object v2_1 = v3.get(v1);
            ((Transition)v2_1).notifyListeners(TransitionNotification.ON_CANCEL, false);
            if(!((Transition)v2_1).mEnded) {
                ((Transition)v2_1).mEnded = true;
                ((Transition)v2_1).notifyListeners(TransitionNotification.ON_END, false);
            }
        }

        Transition v5_1 = this;
        v5_1.createAnimators(arg12, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        if(v5_1.mSeekController == null) {
            v5_1.runAnimators();
            return;
        }

        if(Build$VERSION.SDK_INT >= 34) {
            v5_1.prepareAnimatorsForSeeking();
            v5_1.mSeekController.initPlayTime();
            v5_1.mSeekController.ready();
        }
    }

    void prepareAnimatorsForSeeking() {
        ArrayList v5;
        ArrayMap v0 = Transition.getRunningAnimators();
        long v1 = 0;
        this.mTotalDuration = v1;
        int v3;
        for(v3 = 0; true; ++v3) {
            int v4 = this.mAnimators.size();
            v5 = this.mAnimators;
            if(v3 >= v4) {
                break;
            }

            Object v4_1 = v5.get(v3);
            Object v5_1 = v0.get(v4_1);
            if(v4_1 != null && v5_1 != null) {
                if(this.getDuration() >= v1) {
                    ((AnimationInfo)v5_1).mAnimator.setDuration(this.getDuration());
                }

                if(this.getStartDelay() >= v1) {
                    ((AnimationInfo)v5_1).mAnimator.setStartDelay(this.getStartDelay() + ((AnimationInfo)v5_1).mAnimator.getStartDelay());
                }

                if(this.getInterpolator() != null) {
                    ((AnimationInfo)v5_1).mAnimator.setInterpolator(this.getInterpolator());
                }

                this.mCurrentAnimators.add(v4_1);
                this.mTotalDuration = Math.max(this.mTotalDuration, Impl26.getTotalDuration(((Animator)v4_1)));
            }
        }

        v5.clear();
    }

    public Transition removeListener(TransitionListener arg2) {
        ArrayList v0 = this.mListeners;
        if(v0 == null) {
        }
        else {
            if(!v0.remove(arg2)) {
                Transition v0_1 = this.mCloneParent;
                if(v0_1 != null) {
                    v0_1.removeListener(arg2);
                }
            }

            if(this.mListeners.size() != 0) {
                return this;
            }

            this.mListeners = null;
        }

        return this;
    }

    public Transition removeTarget(int arg2) {
        if(arg2 != 0) {
            this.mTargetIds.remove(Integer.valueOf(arg2));
        }

        return this;
    }

    public Transition removeTarget(View arg2) {
        this.mTargets.remove(arg2);
        return this;
    }

    public Transition removeTarget(Class arg2) {
        ArrayList v0 = this.mTargetTypes;
        if(v0 != null) {
            v0.remove(arg2);
        }

        return this;
    }

    public Transition removeTarget(String arg2) {
        ArrayList v0 = this.mTargetNames;
        if(v0 != null) {
            v0.remove(arg2);
        }

        return this;
    }

    public void resume(View arg5) {
        if(this.mPaused) {
            if(!this.mEnded) {
                int v5 = this.mCurrentAnimators.size();
                Object[] v1 = this.mCurrentAnimators.toArray(this.mAnimatorCache);
                this.mAnimatorCache = Transition.EMPTY_ANIMATOR_ARRAY;
                --v5;
                while(v5 >= 0) {
                    Object v2 = v1[v5];
                    v1[v5] = null;
                    ((Animator)v2).resume();
                    --v5;
                }

                this.mAnimatorCache = ((Animator[])v1);
                this.notifyListeners(TransitionNotification.ON_RESUME, false);
            }

            this.mPaused = false;
        }
    }

    private void runAnimator(Animator arg2, ArrayMap arg3) {
        if(arg2 != null) {
            arg2.addListener(new AnimatorListenerAdapter(arg3) {
                public void onAnimationEnd(Animator arg2) {
                    this.val$runningAnimators.remove(arg2);
                    Transition.this.mCurrentAnimators.remove(arg2);
                }

                public void onAnimationStart(Animator arg1) {
                    Transition.this.mCurrentAnimators.add(arg1);
                }
            });
            this.animate(arg2);
        }
    }

    protected void runAnimators() {
        this.start();
        ArrayMap v0 = Transition.getRunningAnimators();
        Iterator v1 = this.mAnimators.iterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            if(!v0.containsKey(v2)) {
                continue;
            }

            this.start();
            this.runAnimator(((Animator)v2), v0);
        }

        this.mAnimators.clear();
        this.end();
    }

    void setCanRemoveViews(boolean arg1) {
        this.mCanRemoveViews = arg1;
    }

    void setCurrentPlayTimeMillis(long arg18, long arg20) {
        Transition v0 = this;
        long v1 = arg18;
        long v3 = v0.getTotalDurationMillis();
        int v7 = 0;
        boolean v5 = Long.compare(v1, arg20) < 0 ? true : false;
        long v8 = 0;
        int v10 = Long.compare(arg20, v8);
        if(v10 < 0 && v1 >= v8 || arg20 > v3 && v1 <= v3) {
            v0.mEnded = false;
            v0.notifyListeners(TransitionNotification.ON_START, v5);
        }

        int v11 = v0.mCurrentAnimators.size();
        Object[] v12 = v0.mCurrentAnimators.toArray(v0.mAnimatorCache);
        v0.mAnimatorCache = Transition.EMPTY_ANIMATOR_ARRAY;
        while(v7 < v11) {
            Object v13 = v12[v7];
            v12[v7] = null;
            Impl26.setCurrentPlayTime(((Animator)v13), Math.min(Math.max(v8, v1), Impl26.getTotalDuration(((Animator)v13))));
            ++v7;
        }

        v0.mAnimatorCache = ((Animator[])v12);
        int v6 = Long.compare(v1, v3);
        if(v6 > 0 && arg20 <= v3 || v1 < v8 && v10 >= 0) {
            if(v6 > 0) {
                v0.mEnded = true;
            }

            v0.notifyListeners(TransitionNotification.ON_END, v5);
        }
    }

    public Transition setDuration(long arg1) {
        this.mDuration = arg1;
        return this;
    }

    public void setEpicenterCallback(EpicenterCallback arg1) {
        this.mEpicenterCallback = arg1;
    }

    public Transition setInterpolator(TimeInterpolator arg1) {
        this.mInterpolator = arg1;
        return this;
    }

    public void setMatchOrder(int[] arg3) {
        if(arg3 != null) {
            if(arg3.length == 0) {
            }
            else {
                int v0 = 0;
                while(true) {
                    if(v0 >= arg3.length) {
                        goto label_22;
                    }
                    else if(!Transition.isValidMatch(arg3[v0])) {
                        goto label_18;
                    }
                    else if(!Transition.alreadyContains(arg3, v0)) {
                        ++v0;
                        continue;
                    }
                    else {
                        break;
                    }
                }

                throw new IllegalArgumentException("matches contains a duplicate value");
            label_18:
                throw new IllegalArgumentException("matches contains invalid value");
            label_22:
                this.mMatchOrder = arg3.clone();
                return;
            }
        }

        this.mMatchOrder = Transition.DEFAULT_MATCH_ORDER;
    }

    public void setPathMotion(PathMotion arg1) {
        if(arg1 == null) {
            this.mPathMotion = Transition.STRAIGHT_PATH_MOTION;
            return;
        }

        this.mPathMotion = arg1;
    }

    public void setPropagation(TransitionPropagation arg1) {
        this.mPropagation = arg1;
    }

    public Transition setStartDelay(long arg1) {
        this.mStartDelay = arg1;
        return this;
    }

    protected void start() {
        if(this.mNumInstances == 0) {
            this.notifyListeners(TransitionNotification.ON_START, false);
            this.mEnded = false;
        }

        ++this.mNumInstances;
    }

    public String toString() {
        return this.toString("");
    }

    String toString(String arg7) {
        StringBuilder v7 = new StringBuilder(arg7).append(this.getClass().getSimpleName()).append("@").append(Integer.toHexString(this.hashCode())).append(": ");
        long v2 = -1;
        String v1 = ") ";
        if(Long.compare(this.mDuration, v2) != 0) {
            v7.append("dur(").append(this.mDuration).append(v1);
        }

        if(this.mStartDelay != v2) {
            v7.append("dly(").append(this.mStartDelay).append(v1);
        }

        if(this.mInterpolator != null) {
            v7.append("interp(").append(this.mInterpolator).append(v1);
        }

        if(this.mTargetIds.size() > 0 || this.mTargets.size() > 0) {
            v7.append("tgts(");
            v1 = ", ";
            int v2_1 = 0;
            if(this.mTargetIds.size() > 0) {
                int v0;
                for(v0 = 0; v0 < this.mTargetIds.size(); ++v0) {
                    if(v0 > 0) {
                        v7.append(v1);
                    }

                    v7.append(this.mTargetIds.get(v0));
                }
            }

            if(this.mTargets.size() > 0) {
                while(v2_1 < this.mTargets.size()) {
                    if(v2_1 > 0) {
                        v7.append(v1);
                    }

                    v7.append(this.mTargets.get(v2_1));
                    ++v2_1;
                }
            }

            v7.append(")");
        }

        return v7.toString();
    }
}

