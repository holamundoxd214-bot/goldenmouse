package androidx.vectordrawable.graphics.drawable;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$Theme;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class AnimatedVectorDrawableCompat extends VectorDrawableCommon implements Animatable2Compat {
    class androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$1 implements Drawable$Callback {
        androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$1(AnimatedVectorDrawableCompat arg1) {
            AnimatedVectorDrawableCompat.this = arg1;
            super();
        }

        public void invalidateDrawable(Drawable arg1) {
            AnimatedVectorDrawableCompat.this.invalidateSelf();
        }

        public void scheduleDrawable(Drawable arg1, Runnable arg2, long arg3) {
            AnimatedVectorDrawableCompat.this.scheduleSelf(arg2, arg3);
        }

        public void unscheduleDrawable(Drawable arg1, Runnable arg2) {
            AnimatedVectorDrawableCompat.this.unscheduleSelf(arg2);
        }
    }

    class AnimatedVectorDrawableCompatState extends Drawable$ConstantState {
        AnimatorSet mAnimatorSet;
        ArrayList mAnimators;
        int mChangingConfigurations;
        ArrayMap mTargetNameMap;
        VectorDrawableCompat mVectorDrawable;

        public AnimatedVectorDrawableCompatState(Context arg3, AnimatedVectorDrawableCompatState arg4, Drawable$Callback arg5, Resources arg6) {
            Drawable v3_2;
            super();
            if(arg4 != null) {
                this.mChangingConfigurations = arg4.mChangingConfigurations;
                VectorDrawableCompat v3 = arg4.mVectorDrawable;
                int v0 = 0;
                if(v3 != null) {
                    Drawable$ConstantState v3_1 = v3.getConstantState();
                    if(arg6 != null) {
                        v3_2 = v3_1.newDrawable(arg6);
                        this.mVectorDrawable = ((VectorDrawableCompat)v3_2);
                    }
                    else {
                        v3_2 = v3_1.newDrawable();
                        this.mVectorDrawable = ((VectorDrawableCompat)v3_2);
                    }

                    v3_2 = ((VectorDrawableCompat)v3_2).mutate();
                    this.mVectorDrawable = ((VectorDrawableCompat)v3_2);
                    ((VectorDrawableCompat)v3_2).setCallback(arg5);
                    this.mVectorDrawable.setBounds(arg4.mVectorDrawable.getBounds());
                    this.mVectorDrawable.setAllowCaching(false);
                }

                ArrayList v3_3 = arg4.mAnimators;
                if(v3_3 == null) {
                    return;
                }

                int v3_4 = v3_3.size();
                this.mAnimators = new ArrayList(v3_4);
                this.mTargetNameMap = new ArrayMap(v3_4);
                while(v0 < v3_4) {
                    Object v5 = arg4.mAnimators.get(v0);
                    Animator v6 = ((Animator)v5).clone();
                    v5 = arg4.mTargetNameMap.get(v5);
                    v6.setTarget(this.mVectorDrawable.getTargetByName(((String)v5)));
                    this.mAnimators.add(v6);
                    this.mTargetNameMap.put(v6, v5);
                    ++v0;
                }

                this.setupAnimatorSet();
            }
        }

        public int getChangingConfigurations() {
            return this.mChangingConfigurations;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources arg1) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public void setupAnimatorSet() {
            AnimatorSet v0 = this.mAnimatorSet;
            if(v0 == null) {
                v0 = new AnimatorSet();
                this.mAnimatorSet = v0;
            }

            v0.playTogether(this.mAnimators);
        }
    }

    class AnimatedVectorDrawableDelegateState extends Drawable$ConstantState {
        private final Drawable$ConstantState mDelegateState;

        public AnimatedVectorDrawableDelegateState(Drawable$ConstantState arg1) {
            super();
            this.mDelegateState = arg1;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            AnimatedVectorDrawableCompat v0 = new AnimatedVectorDrawableCompat();
            v0.mDelegateDrawable = this.mDelegateState.newDrawable();
            v0.mDelegateDrawable.setCallback(v0.mCallback);
            return ((Drawable)v0);
        }

        public Drawable newDrawable(Resources arg2) {
            AnimatedVectorDrawableCompat v0 = new AnimatedVectorDrawableCompat();
            v0.mDelegateDrawable = this.mDelegateState.newDrawable(arg2);
            v0.mDelegateDrawable.setCallback(v0.mCallback);
            return ((Drawable)v0);
        }

        public Drawable newDrawable(Resources arg2, Resources$Theme arg3) {
            AnimatedVectorDrawableCompat v0 = new AnimatedVectorDrawableCompat();
            v0.mDelegateDrawable = this.mDelegateState.newDrawable(arg2, arg3);
            v0.mDelegateDrawable.setCallback(v0.mCallback);
            return ((Drawable)v0);
        }
    }

    private static final String ANIMATED_VECTOR = "animated-vector";
    private static final boolean DBG_ANIMATION_VECTOR_DRAWABLE = false;
    private static final String LOGTAG = "AnimatedVDCompat";
    private static final String TARGET = "target";
    private AnimatedVectorDrawableCompatState mAnimatedVectorState;
    ArrayList mAnimationCallbacks;
    private Animator$AnimatorListener mAnimatorListener;
    private ArgbEvaluator mArgbEvaluator;
    AnimatedVectorDrawableDelegateState mCachedConstantStateDelegate;
    final Drawable$Callback mCallback;
    private Context mContext;

    AnimatedVectorDrawableCompat() {
        this(null, null, null);
    }

    private AnimatedVectorDrawableCompat(Context arg3, AnimatedVectorDrawableCompatState arg4, Resources arg5) {
        super();
        this.mArgbEvaluator = null;
        this.mAnimatorListener = null;
        this.mAnimationCallbacks = null;
        androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$1 v0 = new androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat$1(this);
        this.mCallback = ((Drawable$Callback)v0);
        this.mContext = arg3;
        if(arg4 != null) {
            this.mAnimatedVectorState = arg4;
            return;
        }

        this.mAnimatedVectorState = new AnimatedVectorDrawableCompatState(arg3, arg4, ((Drawable$Callback)v0), arg5);
    }

    private AnimatedVectorDrawableCompat(Context arg2) {
        this(arg2, null, null);
    }

    public void applyTheme(Resources$Theme arg2) {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.applyTheme(this.mDelegateDrawable, arg2);
        }
    }

    public boolean canApplyTheme() {
        if(this.mDelegateDrawable != null) {
            return DrawableCompat.canApplyTheme(this.mDelegateDrawable);
        }

        return 0;
    }

    public static void clearAnimationCallbacks(Drawable arg1) {
        if(!(arg1 instanceof Animatable)) {
            return;
        }

        ((AnimatedVectorDrawable)arg1).clearAnimationCallbacks();
    }

    public void clearAnimationCallbacks() {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.clearAnimationCallbacks();
            return;
        }

        this.removeAnimatorSetListener();
        ArrayList v1 = this.mAnimationCallbacks;
        if(v1 == null) {
            return;
        }

        v1.clear();
    }

    public void clearColorFilter() {
        super.clearColorFilter();
    }

    public static AnimatedVectorDrawableCompat create(Context arg2, int arg3) {
        AnimatedVectorDrawableCompat v0 = new AnimatedVectorDrawableCompat(arg2);
        v0.mDelegateDrawable = ResourcesCompat.getDrawable(arg2.getResources(), arg3, arg2.getTheme());
        v0.mDelegateDrawable.setCallback(v0.mCallback);
        v0.mCachedConstantStateDelegate = new AnimatedVectorDrawableDelegateState(v0.mDelegateDrawable.getConstantState());
        return v0;
    }

    public static AnimatedVectorDrawableCompat createFromXmlInner(Context arg1, Resources arg2, XmlPullParser arg3, AttributeSet arg4, Resources$Theme arg5) throws XmlPullParserException, IOException {
        AnimatedVectorDrawableCompat v0 = new AnimatedVectorDrawableCompat(arg1);
        v0.inflate(arg2, arg3, arg4, arg5);
        return v0;
    }

    public void draw(Canvas arg2) {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.draw(arg2);
            return;
        }

        this.mAnimatedVectorState.mVectorDrawable.draw(arg2);
        if(this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            this.invalidateSelf();
        }
    }

    public int getAlpha() {
        if(this.mDelegateDrawable != null) {
            return DrawableCompat.getAlpha(this.mDelegateDrawable);
        }

        return this.mAnimatedVectorState.mVectorDrawable.getAlpha();
    }

    public int getChangingConfigurations() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getChangingConfigurations();
        }

        return this.mAnimatedVectorState.mChangingConfigurations | super.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        if(this.mDelegateDrawable != null) {
            return DrawableCompat.getColorFilter(this.mDelegateDrawable);
        }

        return this.mAnimatedVectorState.mVectorDrawable.getColorFilter();
    }

    public Drawable$ConstantState getConstantState() {
        if(this.mDelegateDrawable != null) {
            return new AnimatedVectorDrawableDelegateState(this.mDelegateDrawable.getConstantState());
        }

        return null;
    }

    public Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicHeight();
        }

        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getIntrinsicWidth();
        }

        return this.mAnimatedVectorState.mVectorDrawable.getIntrinsicWidth();
    }

    public int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.getOpacity();
        }

        return this.mAnimatedVectorState.mVectorDrawable.getOpacity();
    }

    public boolean getPadding(Rect arg1) {
        return super.getPadding(arg1);
    }

    public int[] getState() {
        return super.getState();
    }

    public Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources arg7, XmlPullParser arg8, AttributeSet arg9, Resources$Theme arg10) throws XmlPullParserException, IOException {
        TypedArray v0_2;
        if(this.mDelegateDrawable != null) {
            DrawableCompat.inflate(this.mDelegateDrawable, arg7, arg8, arg9, arg10);
            return;
        }

        int v0 = arg8.getEventType();
        int v1 = arg8.getDepth() + 1;
        while(v0 != 1) {
            if(arg8.getDepth() < v1 && v0 == 3) {
                break;
            }

            if(v0 == 2) {
                String v0_1 = arg8.getName();
                if("animated-vector".equals(v0_1)) {
                    v0_2 = TypedArrayUtils.obtainAttributes(arg7, arg10, arg9, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE);
                    int v3 = v0_2.getResourceId(0, 0);
                    if(v3 != 0) {
                        VectorDrawableCompat v3_1 = VectorDrawableCompat.create(arg7, v3, arg10);
                        v3_1.setAllowCaching(false);
                        v3_1.setCallback(this.mCallback);
                        if(this.mAnimatedVectorState.mVectorDrawable != null) {
                            this.mAnimatedVectorState.mVectorDrawable.setCallback(null);
                        }

                        this.mAnimatedVectorState.mVectorDrawable = v3_1;
                    }

                    v0_2.recycle();
                }
                else {
                    if(!"target".equals(v0_1)) {
                        goto label_59;
                    }

                    v0_2 = arg7.obtainAttributes(arg9, AndroidResources.STYLEABLE_ANIMATED_VECTOR_DRAWABLE_TARGET);
                    String v3_2 = v0_2.getString(0);
                    int v4 = v0_2.getResourceId(1, 0);
                    if(v4 != 0) {
                        Context v5 = this.mContext;
                        if(v5 != null) {
                            this.setupAnimatorsForTarget(v3_2, AnimatorInflaterCompat.loadAnimator(v5, v4));
                        }
                        else {
                            v0_2.recycle();
                            throw new IllegalStateException("Context can\'t be null when inflating animators");
                        }
                    }

                    v0_2.recycle();
                }
            }

        label_59:
            v0 = arg8.next();
        }

        this.mAnimatedVectorState.setupAnimatorSet();
    }

    public void inflate(Resources arg2, XmlPullParser arg3, AttributeSet arg4) throws XmlPullParserException, IOException {
        this.inflate(arg2, arg3, arg4, null);
    }

    public boolean isAutoMirrored() {
        if(this.mDelegateDrawable != null) {
            return DrawableCompat.isAutoMirrored(this.mDelegateDrawable);
        }

        return this.mAnimatedVectorState.mVectorDrawable.isAutoMirrored();
    }

    public boolean isRunning() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isRunning();
        }

        return this.mAnimatedVectorState.mAnimatorSet.isRunning();
    }

    public boolean isStateful() {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.isStateful();
        }

        return this.mAnimatedVectorState.mVectorDrawable.isStateful();
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.mutate();
        }

        return this;
    }

    protected void onBoundsChange(Rect arg2) {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setBounds(arg2);
            return;
        }

        this.mAnimatedVectorState.mVectorDrawable.setBounds(arg2);
    }

    protected boolean onLevelChange(int arg2) {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setLevel(arg2);
        }

        return this.mAnimatedVectorState.mVectorDrawable.setLevel(arg2);
    }

    protected boolean onStateChange(int[] arg2) {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setState(arg2);
        }

        return this.mAnimatedVectorState.mVectorDrawable.setState(arg2);
    }

    public static void registerAnimationCallback(Drawable arg1, AnimationCallback arg2) {
        if(arg1 != null) {
            if(arg2 == null) {
            }
            else if(!(arg1 instanceof Animatable)) {
            }
            else {
                AnimatedVectorDrawableCompat.registerPlatformCallback(((AnimatedVectorDrawable)arg1), arg2);
            }
        }
    }

    public void registerAnimationCallback(AnimationCallback arg2) {
        if(this.mDelegateDrawable != null) {
            AnimatedVectorDrawableCompat.registerPlatformCallback(this.mDelegateDrawable, arg2);
            return;
        }

        if(arg2 == null) {
        }
        else {
            ArrayList v0 = this.mAnimationCallbacks;
            if(v0 == null) {
                v0 = new ArrayList();
                this.mAnimationCallbacks = v0;
            }

            if(!v0.contains(arg2)) {
                goto label_15;
            }
        }

        return;
    label_15:
        this.mAnimationCallbacks.add(arg2);
        if(this.mAnimatorListener == null) {
            this.mAnimatorListener = new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator arg5) {
                    ArrayList v5 = new ArrayList(AnimatedVectorDrawableCompat.this.mAnimationCallbacks);
                    int v0 = v5.size();
                    int v1;
                    for(v1 = 0; v1 < v0; ++v1) {
                        v5.get(v1).onAnimationEnd(AnimatedVectorDrawableCompat.this);
                    }
                }

                public void onAnimationStart(Animator arg5) {
                    ArrayList v5 = new ArrayList(AnimatedVectorDrawableCompat.this.mAnimationCallbacks);
                    int v0 = v5.size();
                    int v1;
                    for(v1 = 0; v1 < v0; ++v1) {
                        v5.get(v1).onAnimationStart(AnimatedVectorDrawableCompat.this);
                    }
                }
            };
        }

        this.mAnimatedVectorState.mAnimatorSet.addListener(this.mAnimatorListener);
    }

    private static void registerPlatformCallback(AnimatedVectorDrawable arg0, AnimationCallback arg1) {
        arg0.registerAnimationCallback(arg1.getPlatformCallback());
    }

    private void removeAnimatorSetListener() {
        if(this.mAnimatorListener != null) {
            this.mAnimatedVectorState.mAnimatorSet.removeListener(this.mAnimatorListener);
            this.mAnimatorListener = null;
        }
    }

    public void setAlpha(int arg2) {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setAlpha(arg2);
            return;
        }

        this.mAnimatedVectorState.mVectorDrawable.setAlpha(arg2);
    }

    public void setAutoMirrored(boolean arg2) {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.setAutoMirrored(this.mDelegateDrawable, arg2);
            return;
        }

        this.mAnimatedVectorState.mVectorDrawable.setAutoMirrored(arg2);
    }

    public void setChangingConfigurations(int arg1) {
        super.setChangingConfigurations(arg1);
    }

    public void setColorFilter(int arg1, PorterDuff$Mode arg2) {
        super.setColorFilter(arg1, arg2);
    }

    public void setColorFilter(ColorFilter arg2) {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.setColorFilter(arg2);
            return;
        }

        this.mAnimatedVectorState.mVectorDrawable.setColorFilter(arg2);
    }

    public void setFilterBitmap(boolean arg1) {
        super.setFilterBitmap(arg1);
    }

    public void setHotspot(float arg1, float arg2) {
        super.setHotspot(arg1, arg2);
    }

    public void setHotspotBounds(int arg1, int arg2, int arg3, int arg4) {
        super.setHotspotBounds(arg1, arg2, arg3, arg4);
    }

    public boolean setState(int[] arg1) {
        return super.setState(arg1);
    }

    public void setTint(int arg2) {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.setTint(this.mDelegateDrawable, arg2);
            return;
        }

        this.mAnimatedVectorState.mVectorDrawable.setTint(arg2);
    }

    public void setTintList(ColorStateList arg2) {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.setTintList(this.mDelegateDrawable, arg2);
            return;
        }

        this.mAnimatedVectorState.mVectorDrawable.setTintList(arg2);
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        if(this.mDelegateDrawable != null) {
            DrawableCompat.setTintMode(this.mDelegateDrawable, arg2);
            return;
        }

        this.mAnimatedVectorState.mVectorDrawable.setTintMode(arg2);
    }

    public boolean setVisible(boolean arg2, boolean arg3) {
        if(this.mDelegateDrawable != null) {
            return this.mDelegateDrawable.setVisible(arg2, arg3);
        }

        this.mAnimatedVectorState.mVectorDrawable.setVisible(arg2, arg3);
        return super.setVisible(arg2, arg3);
    }

    private void setupAnimatorsForTarget(String arg3, Animator arg4) {
        arg4.setTarget(this.mAnimatedVectorState.mVectorDrawable.getTargetByName(arg3));
        if(this.mAnimatedVectorState.mAnimators == null) {
            this.mAnimatedVectorState.mAnimators = new ArrayList();
            this.mAnimatedVectorState.mTargetNameMap = new ArrayMap();
        }

        this.mAnimatedVectorState.mAnimators.add(arg4);
        this.mAnimatedVectorState.mTargetNameMap.put(arg4, arg3);
    }

    private void setupColorAnimator(Animator arg4) {
        if((arg4 instanceof AnimatorSet)) {
            ArrayList v0 = arg4.getChildAnimations();
            if(v0 != null) {
                int v1;
                for(v1 = 0; v1 < ((List)v0).size(); ++v1) {
                    this.setupColorAnimator(((List)v0).get(v1));
                }
            }
        }

        if((arg4 instanceof ObjectAnimator)) {
            String v0_1 = ((ObjectAnimator)arg4).getPropertyName();
            if(!"fillColor".equals(v0_1) && !"strokeColor".equals(v0_1)) {
                return;
            }

            ArgbEvaluator v0_2 = this.mArgbEvaluator;
            if(v0_2 == null) {
                v0_2 = new ArgbEvaluator();
                this.mArgbEvaluator = v0_2;
            }

            ((ObjectAnimator)arg4).setEvaluator(((TypeEvaluator)v0_2));
        }
    }

    public void start() {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.start();
            return;
        }

        if(this.mAnimatedVectorState.mAnimatorSet.isStarted()) {
            return;
        }

        this.mAnimatedVectorState.mAnimatorSet.start();
        this.invalidateSelf();
    }

    public void stop() {
        if(this.mDelegateDrawable != null) {
            this.mDelegateDrawable.stop();
            return;
        }

        this.mAnimatedVectorState.mAnimatorSet.end();
    }

    public static boolean unregisterAnimationCallback(Drawable arg2, AnimationCallback arg3) {
        if(arg2 != null) {
            if(arg3 == null) {
            }
            else if(!(arg2 instanceof Animatable)) {
                return 0;
            }
            else {
                return AnimatedVectorDrawableCompat.unregisterPlatformCallback(((AnimatedVectorDrawable)arg2), arg3);
            }
        }

        return 0;
    }

    public boolean unregisterAnimationCallback(AnimationCallback arg2) {
        if(this.mDelegateDrawable != null) {
            AnimatedVectorDrawableCompat.unregisterPlatformCallback(this.mDelegateDrawable, arg2);
        }

        ArrayList v0 = this.mAnimationCallbacks;
        if(v0 != null) {
            if(arg2 == null) {
            }
            else {
                boolean v2 = v0.remove(arg2);
                if(this.mAnimationCallbacks.size() == 0) {
                    this.removeAnimatorSetListener();
                }

                return v2;
            }
        }

        return 0;
    }

    private static boolean unregisterPlatformCallback(AnimatedVectorDrawable arg0, AnimationCallback arg1) {
        return arg0.unregisterAnimationCallback(arg1.getPlatformCallback());
    }
}

