package androidx.appcompat.graphics.drawable;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import androidx.appcompat.resources.Compatibility$Api18Impl;
import androidx.appcompat.resources.Compatibility$Api21Impl;
import androidx.appcompat.resources.R$styleable;
import androidx.appcompat.widget.ResourceManagerInternal;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.util.ObjectsCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedStateListDrawableCompat extends StateListDrawableCompat implements TintAwareDrawable {
    class androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1 {
    }

    class AnimatableTransition extends Transition {
        private final Animatable mA;

        AnimatableTransition(Animatable arg2) {
            super(null);
            this.mA = arg2;
        }

        public void start() {
            this.mA.start();
        }

        public void stop() {
            this.mA.stop();
        }
    }

    class AnimatedStateListState extends StateListState {
        private static final long REVERSED_BIT = 0x100000000L;
        private static final long REVERSIBLE_FLAG_BIT = 0x200000000L;
        SparseArrayCompat mStateIds;
        LongSparseArray mTransitions;

        AnimatedStateListState(AnimatedStateListState arg1, AnimatedStateListDrawableCompat arg2, Resources arg3) {
            super(((StateListState)arg1), ((StateListDrawableCompat)arg2), arg3);
            if(arg1 != null) {
                this.mTransitions = arg1.mTransitions;
                this.mStateIds = arg1.mStateIds;
                return;
            }

            this.mTransitions = new LongSparseArray();
            this.mStateIds = new SparseArrayCompat();
        }

        int addStateSet(int[] arg1, Drawable arg2, int arg3) {
            int v1 = super.addStateSet(arg1, arg2);
            this.mStateIds.put(v1, Integer.valueOf(arg3));
            return v1;
        }

        int addTransition(int arg10, int arg11, Drawable arg12, boolean arg13) {
            int v12 = super.addChild(arg12);
            long v0 = AnimatedStateListState.generateTransitionKey(arg10, arg11);
            long v2 = arg13 ? 0x200000000L : 0;
            long v5 = ((long)v12);
            this.mTransitions.append(v0, Long.valueOf(v5 | v2));
            if(arg13) {
                this.mTransitions.append(AnimatedStateListState.generateTransitionKey(arg11, arg10), Long.valueOf(0x100000000L | v5 | v2));
            }

            return v12;
        }

        private static long generateTransitionKey(int arg2, int arg3) {
            return (((long)arg3)) | (((long)arg2)) << 0x20;
        }

        int getKeyframeIdAt(int arg2) {
            if(arg2 < 0) {
                return 0;
            }

            return this.mStateIds.get(arg2, Integer.valueOf(0)).intValue();
        }

        int indexOfKeyframe(int[] arg1) {
            int v1 = super.indexOfStateSet(arg1);
            if(v1 >= 0) {
                return v1;
            }

            return super.indexOfStateSet(StateSet.WILD_CARD);
        }

        int indexOfTransition(int arg3, int arg4) {
            return ((int)this.mTransitions.get(AnimatedStateListState.generateTransitionKey(arg3, arg4), Long.valueOf(-1)).longValue());
        }

        boolean isTransitionReversed(int arg3, int arg4) {
            if((this.mTransitions.get(AnimatedStateListState.generateTransitionKey(arg3, arg4), Long.valueOf(-1)).longValue() & 0x100000000L) != 0) {
                return 1;
            }

            return 0;
        }

        void mutate() {
            this.mTransitions = this.mTransitions.clone();
            this.mStateIds = this.mStateIds.clone();
        }

        public Drawable newDrawable() {
            return new AnimatedStateListDrawableCompat(this, null);
        }

        public Drawable newDrawable(Resources arg2) {
            return new AnimatedStateListDrawableCompat(this, arg2);
        }

        boolean transitionHasReversibleFlag(int arg3, int arg4) {
            if((this.mTransitions.get(AnimatedStateListState.generateTransitionKey(arg3, arg4), Long.valueOf(-1)).longValue() & 0x200000000L) != 0) {
                return 1;
            }

            return 0;
        }
    }

    class AnimatedVectorDrawableTransition extends Transition {
        private final AnimatedVectorDrawableCompat mAvd;

        AnimatedVectorDrawableTransition(AnimatedVectorDrawableCompat arg2) {
            super(null);
            this.mAvd = arg2;
        }

        public void start() {
            this.mAvd.start();
        }

        public void stop() {
            this.mAvd.stop();
        }
    }

    class AnimationDrawableTransition extends Transition {
        private final ObjectAnimator mAnim;
        private final boolean mHasReversibleFlag;

        AnimationDrawableTransition(AnimationDrawable arg5, boolean arg6, boolean arg7) {
            super(null);
            int v0 = arg5.getNumberOfFrames();
            int v1 = 0;
            int v2 = arg6 ? v0 - 1 : 0;
            if(arg6) {
            }
            else {
                v1 = v0 - 1;
            }

            FrameInterpolator v0_1 = new FrameInterpolator(arg5, arg6);
            ObjectAnimator v5 = ObjectAnimator.ofInt(arg5, "currentIndex", new int[]{v2, v1});
            Api18Impl.setAutoCancel(v5, true);
            v5.setDuration(((long)v0_1.getTotalDuration()));
            v5.setInterpolator(((TimeInterpolator)v0_1));
            this.mHasReversibleFlag = arg7;
            this.mAnim = v5;
        }

        public boolean canReverse() {
            return this.mHasReversibleFlag;
        }

        public void reverse() {
            this.mAnim.reverse();
        }

        public void start() {
            this.mAnim.start();
        }

        public void stop() {
            this.mAnim.cancel();
        }
    }

    class FrameInterpolator implements TimeInterpolator {
        private int[] mFrameTimes;
        private int mFrames;
        private int mTotalDuration;

        FrameInterpolator(AnimationDrawable arg1, boolean arg2) {
            super();
            this.updateFrames(arg1, arg2);
        }

        public float getInterpolation(float arg5) {
            int v5 = ((int)(arg5 * (((float)this.mTotalDuration)) + 0.5f));
            int v0 = this.mFrames;
            int[] v1 = this.mFrameTimes;
            int v2;
            for(v2 = 0; v2 < v0; ++v2) {
                int v3 = v1[v2];
                if(v5 < v3) {
                    break;
                }

                v5 -= v3;
            }

            arg5 = v2 < v0 ? (((float)v5)) / (((float)this.mTotalDuration)) : 0f;
            return (((float)v2)) / (((float)v0)) + arg5;
        }

        int getTotalDuration() {
            return this.mTotalDuration;
        }

        int updateFrames(AnimationDrawable arg6, boolean arg7) {
            int v0 = arg6.getNumberOfFrames();
            this.mFrames = v0;
            int[] v1 = this.mFrameTimes;
            if(v1 == null || v1.length < v0) {
                v1 = new int[v0];
                this.mFrameTimes = v1;
            }

            int v2 = 0;
            int v3 = 0;
            while(v2 < v0) {
                int v4 = arg7 ? v0 - v2 - 1 : v2;
                v4 = arg6.getDuration(v4);
                v1[v2] = v4;
                v3 += v4;
                ++v2;
            }

            this.mTotalDuration = v3;
            return v3;
        }
    }

    abstract class Transition {
        private Transition() {
            super();
        }

        Transition(androidx.appcompat.graphics.drawable.AnimatedStateListDrawableCompat$1 arg1) {
            this();
        }

        public boolean canReverse() {
            return 0;
        }

        public void reverse() {
        }

        public abstract void start();

        public abstract void stop();
    }

    private static final String ELEMENT_ITEM = "item";
    private static final String ELEMENT_TRANSITION = "transition";
    private static final String ITEM_MISSING_DRAWABLE_ERROR = ": <item> tag requires a \'drawable\' attribute or child tag defining a drawable";
    private static final String LOGTAG = "AnimatedStateListDrawableCompat";
    private static final String TRANSITION_MISSING_DRAWABLE_ERROR = ": <transition> tag requires a \'drawable\' attribute or child tag defining a drawable";
    private static final String TRANSITION_MISSING_FROM_TO_ID = ": <transition> tag requires \'fromId\' & \'toId\' attributes";
    private boolean mMutated;
    private AnimatedStateListState mState;
    private Transition mTransition;
    private int mTransitionFromIndex;
    private int mTransitionToIndex;

    static {
    }

    public AnimatedStateListDrawableCompat() {
        this(null, null);
    }

    AnimatedStateListDrawableCompat(AnimatedStateListState arg2, Resources arg3) {
        super(null);
        this.mTransitionToIndex = -1;
        this.mTransitionFromIndex = -1;
        this.setConstantState(new AnimatedStateListState(arg2, this, arg3));
        this.onStateChange(this.getState());
        this.jumpToCurrentState();
    }

    public void addState(int[] arg2, Drawable arg3, int arg4) {
        ObjectsCompat.requireNonNull(arg3);
        this.mState.addStateSet(arg2, arg3, arg4);
        this.onStateChange(this.getState());
    }

    public void addTransition(int arg1, int arg2, Drawable arg3, boolean arg4) {
        ObjectsCompat.requireNonNull(arg3);
        this.mState.addTransition(arg1, arg2, arg3, arg4);
    }

    void clearMutated() {
        super.clearMutated();
        this.mMutated = false;
    }

    AnimatedStateListState cloneConstantState() {
        return new AnimatedStateListState(this.mState, this, null);
    }

    DrawableContainerState cloneConstantState() {
        return this.cloneConstantState();
    }

    StateListState cloneConstantState() {
        return this.cloneConstantState();
    }

    public static AnimatedStateListDrawableCompat create(Context arg6, int arg7, Resources$Theme arg8) {
        String v0 = "parser error";
        try {
            Resources v1 = arg6.getResources();
            XmlResourceParser v7 = v1.getXml(arg7);
            AttributeSet v2 = Xml.asAttributeSet(((XmlPullParser)v7));
            while(true) {
                int v3 = ((XmlPullParser)v7).next();
                int v4 = 2;
                if(v3 != v4 && v3 != 1) {
                    continue;
                }

                break;
            }

            if(v3 == v4) {
                return AnimatedStateListDrawableCompat.createFromXmlInner(arg6, v1, ((XmlPullParser)v7), v2, arg8);
            }

            throw new XmlPullParserException("No start tag found");
        }
        catch(IOException v6) {
            Log.e(AnimatedStateListDrawableCompat.LOGTAG, v0, ((Throwable)v6));
        }
        catch(XmlPullParserException v6_1) {
            Log.e(AnimatedStateListDrawableCompat.LOGTAG, v0, ((Throwable)v6_1));
        }

        return null;
    }

    public static AnimatedStateListDrawableCompat createFromXmlInner(Context arg8, Resources arg9, XmlPullParser arg10, AttributeSet arg11, Resources$Theme arg12) throws IOException, XmlPullParserException {
        String v0 = arg10.getName();
        if(v0.equals("animated-selector")) {
            AnimatedStateListDrawableCompat v2 = new AnimatedStateListDrawableCompat();
            v2.inflate(arg8, arg9, arg10, arg11, arg12);
            return v2;
        }

        throw new XmlPullParserException(arg10.getPositionDescription() + ": invalid animated-selector tag " + v0);
    }

    public void inflate(Context arg4, Resources arg5, XmlPullParser arg6, AttributeSet arg7, Resources$Theme arg8) throws XmlPullParserException, IOException {
        TypedArray v0 = TypedArrayUtils.obtainAttributes(arg5, arg8, arg7, styleable.AnimatedStateListDrawableCompat);
        this.setVisible(v0.getBoolean(styleable.AnimatedStateListDrawableCompat_android_visible, true), true);
        this.updateStateFromTypedArray(v0);
        this.updateDensity(arg5);
        v0.recycle();
        this.inflateChildElements(arg4, arg5, arg6, arg7, arg8);
        this.init();
    }

    private void inflateChildElements(Context arg6, Resources arg7, XmlPullParser arg8, AttributeSet arg9, Resources$Theme arg10) throws XmlPullParserException, IOException {
        int v0 = arg8.getDepth() + 1;
        while(true) {
            int v2 = arg8.next();
            if(v2 != 1) {
                int v3 = arg8.getDepth();
                if(v3 < v0 && v2 == 3) {
                    return;
                }

                if(v2 != 2) {
                    continue;
                }

                if(v3 > v0) {
                    continue;
                }

                if(arg8.getName().equals("item")) {
                    this.parseItem(arg6, arg7, arg8, arg9, arg10);
                    continue;
                }

                if(!arg8.getName().equals("transition")) {
                    continue;
                }

                this.parseTransition(arg6, arg7, arg8, arg9, arg10);
                continue;
            }

            return;
        }
    }

    private void init() {
        this.onStateChange(this.getState());
    }

    public boolean isStateful() {
        return 1;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        Transition v0 = this.mTransition;
        if(v0 != null) {
            v0.stop();
            this.mTransition = null;
            this.selectDrawable(this.mTransitionToIndex);
            this.mTransitionToIndex = -1;
            this.mTransitionFromIndex = -1;
        }
    }

    public Drawable mutate() {
        if(!this.mMutated && super.mutate() == this) {
            this.mState.mutate();
            this.mMutated = true;
        }

        return this;
    }

    protected boolean onStateChange(int[] arg3) {
        int v0 = this.mState.indexOfKeyframe(arg3);
        if(v0 != this.getCurrentIndex()) {
            if(!this.selectTransition(v0) && !this.selectDrawable(v0)) {
                goto label_10;
            }

            v0 = 1;
        }
        else {
        label_10:
            v0 = 0;
        }

        Drawable v2 = this.getCurrent();
        if(v2 != null) {
            return v2.setState(arg3) | v0;
        }

        return ((boolean)v0);
    }

    private int parseItem(Context arg5, Resources arg6, XmlPullParser arg7, AttributeSet arg8, Resources$Theme arg9) throws XmlPullParserException, IOException {
        VectorDrawableCompat v5_2;
        TypedArray v0 = TypedArrayUtils.obtainAttributes(arg6, arg9, arg8, styleable.AnimatedStateListDrawableItem);
        int v1 = v0.getResourceId(styleable.AnimatedStateListDrawableItem_android_id, 0);
        int v2 = v0.getResourceId(styleable.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable v5 = v2 > 0 ? ResourceManagerInternal.get().getDrawable(arg5, v2) : null;
        v0.recycle();
        int[] v0_1 = this.extractStateSet(arg8);
        String v2_1 = ": <item> tag requires a \'drawable\' attribute or child tag defining a drawable";
        if(v5 == null) {
            while(true) {
                int v5_1 = arg7.next();
                if(v5_1 != 4) {
                    break;
                }
            }

            if(v5_1 != 2) {
                throw new XmlPullParserException(arg7.getPositionDescription() + v2_1);
            }
            else if(arg7.getName().equals("vector")) {
                v5_2 = VectorDrawableCompat.createFromXmlInner(arg6, arg7, arg8, arg9);
            }
            else {
                v5 = Api21Impl.createFromXmlInner(arg6, arg7, arg8, arg9);
            }
        }

        if((((Drawable)v5_2)) != null) {
            return this.mState.addStateSet(v0_1, ((Drawable)v5_2), v1);
        }

        throw new XmlPullParserException(arg7.getPositionDescription() + v2_1);
    }

    private int parseTransition(Context arg8, Resources arg9, XmlPullParser arg10, AttributeSet arg11, Resources$Theme arg12) throws XmlPullParserException, IOException {
        TypedArray v0 = TypedArrayUtils.obtainAttributes(arg9, arg12, arg11, styleable.AnimatedStateListDrawableTransition);
        int v2 = -1;
        int v1 = v0.getResourceId(styleable.AnimatedStateListDrawableTransition_android_fromId, v2);
        int v3 = v0.getResourceId(styleable.AnimatedStateListDrawableTransition_android_toId, v2);
        int v4 = v0.getResourceId(styleable.AnimatedStateListDrawableTransition_android_drawable, v2);
        Drawable v4_1 = v4 > 0 ? ResourceManagerInternal.get().getDrawable(arg8, v4) : null;
        boolean v5 = v0.getBoolean(styleable.AnimatedStateListDrawableTransition_android_reversible, false);
        v0.recycle();
        String v0_1 = ": <transition> tag requires a \'drawable\' attribute or child tag defining a drawable";
        if(v4_1 == null) {
            while(true) {
                v4 = arg10.next();
                if(v4 != 4) {
                    break;
                }
            }

            if(v4 != 2) {
                throw new XmlPullParserException(arg10.getPositionDescription() + v0_1);
            }
            else if(arg10.getName().equals("animated-vector")) {
                AnimatedVectorDrawableCompat v4_2 = AnimatedVectorDrawableCompat.createFromXmlInner(arg8, arg9, arg10, arg11, arg12);
            }
            else {
                v4_1 = Api21Impl.createFromXmlInner(arg9, arg10, arg11, arg12);
            }
        }

        if(v4_1 != null) {
            if(v1 != v2 && v3 != v2) {
                return this.mState.addTransition(v1, v3, v4_1, v5);
            }

            throw new XmlPullParserException(arg10.getPositionDescription() + ": <transition> tag requires \'fromId\' & \'toId\' attributes");
        }

        throw new XmlPullParserException(arg10.getPositionDescription() + v0_1);
    }

    private boolean selectTransition(int arg10) {
        AnimatableTransition v3_3;
        int v2;
        Transition v0 = this.mTransition;
        if(v0 == null) {
            v2 = this.getCurrentIndex();
        }
        else if(arg10 == this.mTransitionToIndex) {
            return 1;
        }
        else {
            if(arg10 == this.mTransitionFromIndex && (v0.canReverse())) {
                v0.reverse();
                this.mTransitionToIndex = this.mTransitionFromIndex;
                this.mTransitionFromIndex = arg10;
                return 1;
            }

            v2 = this.mTransitionToIndex;
            v0.stop();
        }

        this.mTransition = null;
        this.mTransitionFromIndex = -1;
        this.mTransitionToIndex = -1;
        AnimatedStateListState v0_1 = this.mState;
        int v3 = v0_1.getKeyframeIdAt(v2);
        int v4 = v0_1.getKeyframeIdAt(arg10);
        if(v4 != 0) {
            if(v3 == 0) {
            }
            else {
                int v6 = v0_1.indexOfTransition(v3, v4);
                if(v6 < 0) {
                    return 0;
                }
                else {
                    boolean v7 = v0_1.transitionHasReversibleFlag(v3, v4);
                    this.selectDrawable(v6);
                    Drawable v6_1 = this.getCurrent();
                    if((v6_1 instanceof AnimationDrawable)) {
                        AnimationDrawableTransition v3_1 = new AnimationDrawableTransition(((AnimationDrawable)v6_1), v0_1.isTransitionReversed(v3, v4), v7);
                    }
                    else if((v6_1 instanceof AnimatedVectorDrawableCompat)) {
                        AnimatedVectorDrawableTransition v3_2 = new AnimatedVectorDrawableTransition(((AnimatedVectorDrawableCompat)v6_1));
                    }
                    else if((v6_1 instanceof Animatable)) {
                        v3_3 = new AnimatableTransition(((Animatable)v6_1));
                    }
                    else {
                        return 0;
                    }

                    ((Transition)v3_3).start();
                    this.mTransition = ((Transition)v3_3);
                    this.mTransitionFromIndex = v2;
                    this.mTransitionToIndex = arg10;
                    return 1;
                }
            }
        }

        return 0;
    }

    void setConstantState(DrawableContainerState arg2) {
        super.setConstantState(arg2);
        if((arg2 instanceof AnimatedStateListState)) {
            this.mState = ((AnimatedStateListState)arg2);
        }
    }

    public boolean setVisible(boolean arg3, boolean arg4) {
        boolean v0 = super.setVisible(arg3, arg4);
        Transition v1 = this.mTransition;
        if(v1 != null && ((v0) || (arg4))) {
            if(arg3) {
                v1.start();
                return v0;
            }

            this.jumpToCurrentState();
        }

        return v0;
    }

    private void updateStateFromTypedArray(TypedArray arg4) {
        AnimatedStateListState v0 = this.mState;
        v0.mChangingConfigurations |= Api21Impl.getChangingConfigurations(arg4);
        v0.setVariablePadding(arg4.getBoolean(styleable.AnimatedStateListDrawableCompat_android_variablePadding, v0.mVariablePadding));
        v0.setConstantSize(arg4.getBoolean(styleable.AnimatedStateListDrawableCompat_android_constantSize, v0.mConstantSize));
        v0.setEnterFadeDuration(arg4.getInt(styleable.AnimatedStateListDrawableCompat_android_enterFadeDuration, v0.mEnterFadeDuration));
        v0.setExitFadeDuration(arg4.getInt(styleable.AnimatedStateListDrawableCompat_android_exitFadeDuration, v0.mExitFadeDuration));
        this.setDither(arg4.getBoolean(styleable.AnimatedStateListDrawableCompat_android_dither, v0.mDither));
    }
}

