package androidx.core.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.os.Build$VERSION;
import android.view.View$OnApplyWindowInsetsListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowInsets;
import android.view.WindowInsetsAnimation$Bounds;
import android.view.WindowInsetsAnimation$Callback;
import android.view.WindowInsetsAnimation;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import androidx.core.R$id;
import androidx.core.graphics.Insets;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public final class WindowInsetsAnimationCompat {
    public final class BoundsCompat {
        private final Insets mLowerBound;
        private final Insets mUpperBound;

        public BoundsCompat(Insets arg1, Insets arg2) {
            super();
            this.mLowerBound = arg1;
            this.mUpperBound = arg2;
        }

        private BoundsCompat(WindowInsetsAnimation$Bounds arg2) {
            super();
            this.mLowerBound = Impl30.getLowerBounds(arg2);
            this.mUpperBound = Impl30.getHigherBounds(arg2);
        }

        public Insets getLowerBound() {
            return this.mLowerBound;
        }

        public Insets getUpperBound() {
            return this.mUpperBound;
        }

        public BoundsCompat inset(Insets arg7) {
            return new BoundsCompat(WindowInsetsCompat.insetInsets(this.mLowerBound, arg7.left, arg7.top, arg7.right, arg7.bottom), WindowInsetsCompat.insetInsets(this.mUpperBound, arg7.left, arg7.top, arg7.right, arg7.bottom));
        }

        public WindowInsetsAnimation$Bounds toBounds() {
            return Impl30.createPlatformBounds(this);
        }

        public static BoundsCompat toBoundsCompat(WindowInsetsAnimation$Bounds arg1) {
            return new BoundsCompat(arg1);
        }

        public String toString() {
            return "Bounds{lower=" + this.mLowerBound + " upper=" + this.mUpperBound + "}";
        }
    }

    public abstract class Callback {
        @Retention(value=RetentionPolicy.SOURCE) @public interface DispatchMode {
        }

        public static final int DISPATCH_MODE_CONTINUE_ON_SUBTREE = 1;
        public static final int DISPATCH_MODE_STOP;
        WindowInsetsCompat mDispachedInsets;
        private final int mDispatchMode;

        public Callback(int arg1) {
            super();
            this.mDispatchMode = arg1;
        }

        public final int getDispatchMode() {
            return this.mDispatchMode;
        }

        public void onEnd(WindowInsetsAnimationCompat arg1) {
        }

        public void onPrepare(WindowInsetsAnimationCompat arg1) {
        }

        public abstract WindowInsetsCompat onProgress(WindowInsetsCompat arg1, List arg2);

        public BoundsCompat onStart(WindowInsetsAnimationCompat arg1, BoundsCompat arg2) {
            return arg2;
        }
    }

    class Impl21 extends Impl {
        class Impl21OnApplyWindowInsetsListener implements View$OnApplyWindowInsetsListener {
            private static final int COMPAT_ANIMATION_DURATION_IME = 0xA0;
            private static final int COMPAT_ANIMATION_DURATION_SYSTEM_BAR = 0xFA;
            final Callback mCallback;
            private WindowInsetsCompat mLastInsets;

            Impl21OnApplyWindowInsetsListener(View arg1, Callback arg2) {
                super();
                this.mCallback = arg2;
                WindowInsetsCompat v1 = ViewCompat.getRootWindowInsets(arg1);
                v1 = v1 != null ? new Builder(v1).build() : null;
                this.mLastInsets = v1;
            }

            public WindowInsets onApplyWindowInsets(View arg13, WindowInsets arg14) {
                if(!arg13.isLaidOut()) {
                    this.mLastInsets = WindowInsetsCompat.toWindowInsetsCompat(arg14, arg13);
                    return Impl21.forwardToViewIfNeeded(arg13, arg14);
                }

                WindowInsetsCompat v3 = WindowInsetsCompat.toWindowInsetsCompat(arg14, arg13);
                WindowInsetsCompat v0 = this.mLastInsets;
                if(v0 == null) {
                    v0 = ViewCompat.getRootWindowInsets(arg13);
                    this.mLastInsets = v0;
                }

                if(v0 == null) {
                    this.mLastInsets = v3;
                    return Impl21.forwardToViewIfNeeded(arg13, arg14);
                }

                Callback v0_1 = Impl21.getCallback(arg13);
                if(v0_1 != null && (Objects.equals(v0_1.mDispachedInsets, v3))) {
                    return Impl21.forwardToViewIfNeeded(arg13, arg14);
                }

                int[] v1 = new int[1];
                int[] v0_2 = new int[1];
                Impl21.buildAnimationMask(v3, this.mLastInsets, v1, v0_2);
                int v1_1 = v1[0];
                int v0_3 = v0_2[0];
                int v5 = v1_1 | v0_3;
                if(v5 == 0) {
                    this.mLastInsets = v3;
                    return Impl21.forwardToViewIfNeeded(arg13, arg14);
                }

                WindowInsetsCompat v4 = this.mLastInsets;
                Interpolator v0_4 = Impl21.createInsetInterpolator(v1_1, v0_3);
                long v6 = (Type.ime() & v5) != 0 ? 0xA0 : 0xFA;
                WindowInsetsAnimationCompat v9 = new WindowInsetsAnimationCompat(v5, v0_4, v6);
                v9.setFraction(0f);
                ValueAnimator v11 = ValueAnimator.ofFloat(new float[]{0f, 1f}).setDuration(v9.getDurationMillis());
                BoundsCompat v10 = Impl21.computeAnimationBounds(v3, v4, v5);
                Impl21.dispatchOnPrepare(arg13, v9, v3, false);
                v11.addUpdateListener(new ValueAnimator$AnimatorUpdateListener(v9, v3, v4, v5, arg13) {
                    public void onAnimationUpdate(ValueAnimator arg4) {
                        this.val$anim.setFraction(arg4.getAnimatedFraction());
                        Impl21.dispatchOnProgress(this.val$v, Impl21.interpolateInsets(this.val$targetInsets, this.val$startingInsets, this.val$anim.getInterpolatedFraction(), this.val$animationMask), Collections.singletonList(this.val$anim));
                    }
                });
                v11.addListener(new AnimatorListenerAdapter(v9, arg13) {
                    public void onAnimationEnd(Animator arg2) {
                        this.val$anim.setFraction(1f);
                        Impl21.dispatchOnEnd(this.val$v, this.val$anim);
                    }
                });
                OneShotPreDrawListener.add(arg13, new Runnable(arg13, v9, v10, v11) {
                    public void run() {
                        Impl21.dispatchOnStart(this.val$v, this.val$anim, this.val$animationBounds);
                        this.val$animator.start();
                    }
                });
                this.mLastInsets = v3;
                return Impl21.forwardToViewIfNeeded(arg13, arg14);
            }
        }

        private static final Interpolator HIDE_IME_INTERPOLATOR;
        private static final Interpolator HIDE_SYSTEM_BAR_INTERPOLATOR;
        private static final Interpolator SHOW_IME_INTERPOLATOR;
        private static final Interpolator SHOW_SYSTEM_BAR_INTERPOLATOR;

        static {
            Impl21.SHOW_IME_INTERPOLATOR = new PathInterpolator(0f, 1.1f, 0f, 1f);
            Impl21.HIDE_IME_INTERPOLATOR = new FastOutLinearInInterpolator();
            Impl21.SHOW_SYSTEM_BAR_INTERPOLATOR = new DecelerateInterpolator(1.5f);
            Impl21.HIDE_SYSTEM_BAR_INTERPOLATOR = new AccelerateInterpolator(1.5f);
        }

        Impl21(int arg1, Interpolator arg2, long arg3) {
            super(arg1, arg2, arg3);
        }

        static void buildAnimationMask(WindowInsetsCompat arg8, WindowInsetsCompat arg9, int[] arg10, int[] arg11) {
            int v1;
            for(v1 = 1; v1 <= 0x200; v1 <<= 1) {
                Insets v2 = arg8.getInsets(v1);
                Insets v3 = arg9.getInsets(v1);
                int v4 = v2.left > v3.left || v2.top > v3.top || v2.right > v3.right || v2.bottom > v3.bottom ? 1 : 0;
                int v2_1 = v2.left < v3.left || v2.top < v3.top || v2.right < v3.right || v2.bottom < v3.bottom ? 1 : 0;
                if(v4 != v2_1) {
                    if(v4 != 0) {
                        arg10[0] |= v1;
                    }
                    else {
                        arg11[0] |= v1;
                    }
                }
            }
        }

        static BoundsCompat computeAnimationBounds(WindowInsetsCompat arg4, WindowInsetsCompat arg5, int arg6) {
            Insets v4 = arg4.getInsets(arg6);
            Insets v5 = arg5.getInsets(arg6);
            return new BoundsCompat(Insets.of(Math.min(v4.left, v5.left), Math.min(v4.top, v5.top), Math.min(v4.right, v5.right), Math.min(v4.bottom, v5.bottom)), Insets.of(Math.max(v4.left, v5.left), Math.max(v4.top, v5.top), Math.max(v4.right, v5.right), Math.max(v4.bottom, v5.bottom)));
        }

        static Interpolator createInsetInterpolator(int arg1, int arg2) {
            if((Type.ime() & arg1) != 0) {
                return Impl21.SHOW_IME_INTERPOLATOR;
            }

            if((Type.ime() & arg2) != 0) {
                return Impl21.HIDE_IME_INTERPOLATOR;
            }

            if((arg1 & Type.systemBars()) != 0) {
                return Impl21.SHOW_SYSTEM_BAR_INTERPOLATOR;
            }

            if((Type.systemBars() & arg2) != 0) {
                return Impl21.HIDE_SYSTEM_BAR_INTERPOLATOR;
            }

            return null;
        }

        private static View$OnApplyWindowInsetsListener createProxyListener(View arg1, Callback arg2) {
            return new Impl21OnApplyWindowInsetsListener(arg1, arg2);
        }

        static void dispatchOnEnd(View arg2, WindowInsetsAnimationCompat arg3) {
            Callback v0 = Impl21.getCallback(arg2);
            if(v0 != null) {
                v0.onEnd(arg3);
                if(v0.getDispatchMode() == 0) {
                }
                else {
                    goto label_6;
                }
            }
            else {
            label_6:
                if((arg2 instanceof ViewGroup)) {
                    int v0_1;
                    for(v0_1 = 0; v0_1 < ((ViewGroup)arg2).getChildCount(); ++v0_1) {
                        Impl21.dispatchOnEnd(((ViewGroup)arg2).getChildAt(v0_1), arg3);
                    }
                }
            }
        }

        static void dispatchOnPrepare(View arg2, WindowInsetsAnimationCompat arg3, WindowInsetsCompat arg4, boolean arg5) {
            Callback v0 = Impl21.getCallback(arg2);
            int v1 = 0;
            if(v0 != null) {
                v0.mDispachedInsets = arg4;
                if(!arg5) {
                    v0.onPrepare(arg3);
                    arg5 = v0.getDispatchMode() == 0 ? true : false;
                }
            }

            if((arg2 instanceof ViewGroup)) {
                while(v1 < ((ViewGroup)arg2).getChildCount()) {
                    Impl21.dispatchOnPrepare(((ViewGroup)arg2).getChildAt(v1), arg3, arg4, arg5);
                    ++v1;
                }
            }
        }

        static void dispatchOnProgress(View arg2, WindowInsetsCompat arg3, List arg4) {
            Callback v0 = Impl21.getCallback(arg2);
            if(v0 != null) {
                arg3 = v0.onProgress(arg3, arg4);
                if(v0.getDispatchMode() == 0) {
                }
                else {
                    goto label_6;
                }
            }
            else {
            label_6:
                if((arg2 instanceof ViewGroup)) {
                    int v0_1;
                    for(v0_1 = 0; v0_1 < ((ViewGroup)arg2).getChildCount(); ++v0_1) {
                        Impl21.dispatchOnProgress(((ViewGroup)arg2).getChildAt(v0_1), arg3, arg4);
                    }
                }
            }
        }

        static void dispatchOnStart(View arg2, WindowInsetsAnimationCompat arg3, BoundsCompat arg4) {
            Callback v0 = Impl21.getCallback(arg2);
            if(v0 != null) {
                v0.onStart(arg3, arg4);
                if(v0.getDispatchMode() == 0) {
                }
                else {
                    goto label_6;
                }
            }
            else {
            label_6:
                if((arg2 instanceof ViewGroup)) {
                    int v0_1;
                    for(v0_1 = 0; v0_1 < ((ViewGroup)arg2).getChildCount(); ++v0_1) {
                        Impl21.dispatchOnStart(((ViewGroup)arg2).getChildAt(v0_1), arg3, arg4);
                    }
                }
            }
        }

        static WindowInsets forwardToViewIfNeeded(View arg1, WindowInsets arg2) {
            if(arg1.getTag(id.tag_on_apply_window_listener) != null) {
                return arg2;
            }

            return arg1.onApplyWindowInsets(arg2);
        }

        static Callback getCallback(View arg1) {
            Object v1 = arg1.getTag(id.tag_window_insets_animation_callback);
            if((v1 instanceof Impl21OnApplyWindowInsetsListener)) {
                return ((Impl21OnApplyWindowInsetsListener)v1).mCallback;
            }

            return null;
        }

        static WindowInsetsCompat interpolateInsets(WindowInsetsCompat arg12, WindowInsetsCompat arg13, float arg14, int arg15) {
            Builder v0 = new Builder(arg12);
            int v1;
            for(v1 = 1; v1 <= 0x200; v1 <<= 1) {
                if((arg15 & v1) == 0) {
                    v0.setInsets(v1, arg12.getInsets(v1));
                }
                else {
                    Insets v2 = arg12.getInsets(v1);
                    Insets v3 = arg13.getInsets(v1);
                    float v5 = 1f - arg14;
                    v0.setInsets(v1, WindowInsetsCompat.insetInsets(v2, ((int)((((double)((((float)(v2.left - v3.left))) * v5))) + 0.5)), ((int)((((double)((((float)(v2.top - v3.top))) * v5))) + 0.5)), ((int)((((double)((((float)(v2.right - v3.right))) * v5))) + 0.5)), ((int)((((double)((((float)(v2.bottom - v3.bottom))) * v5))) + 0.5))));
                }
            }

            return v0.build();
        }

        static void setCallback(View arg1, Callback arg2) {
            Object v2_1;
            if(arg2 != null) {
                View$OnApplyWindowInsetsListener v2 = Impl21.createProxyListener(arg1, arg2);
            }
            else {
                v2_1 = null;
            }

            arg1.setTag(id.tag_window_insets_animation_callback, v2_1);
            if(arg1.getTag(id.tag_compat_insets_dispatch) == null && arg1.getTag(id.tag_on_apply_window_listener) == null) {
                arg1.setOnApplyWindowInsetsListener(((View$OnApplyWindowInsetsListener)v2_1));
            }
        }
    }

    class Impl30 extends Impl {
        class ProxyCallback extends WindowInsetsAnimation$Callback {
            private final HashMap mAnimations;
            private final Callback mCompat;
            private List mRORunningAnimations;
            private ArrayList mTmpRunningAnimations;

            ProxyCallback(Callback arg2) {
                super(arg2.getDispatchMode());
                this.mAnimations = new HashMap();
                this.mCompat = arg2;
            }

            private WindowInsetsAnimationCompat getWindowInsetsAnimationCompat(WindowInsetsAnimation arg2) {
                Object v0 = this.mAnimations.get(arg2);
                if(v0 == null) {
                    WindowInsetsAnimationCompat v0_1 = WindowInsetsAnimationCompat.toWindowInsetsAnimationCompat(arg2);
                    this.mAnimations.put(arg2, v0_1);
                }

                return ((WindowInsetsAnimationCompat)v0);
            }

            public void onEnd(WindowInsetsAnimation arg3) {
                this.mCompat.onEnd(this.getWindowInsetsAnimationCompat(arg3));
                this.mAnimations.remove(arg3);
            }

            public void onPrepare(WindowInsetsAnimation arg2) {
                this.mCompat.onPrepare(this.getWindowInsetsAnimationCompat(arg2));
            }

            public WindowInsets onProgress(WindowInsets arg4, List arg5) {
                ArrayList v0 = this.mTmpRunningAnimations;
                if(v0 == null) {
                    v0 = new ArrayList(arg5.size());
                    this.mTmpRunningAnimations = v0;
                    this.mRORunningAnimations = Collections.unmodifiableList(((List)v0));
                }
                else {
                    v0.clear();
                }

                int v0_1;
                for(v0_1 = arg5.size() - 1; v0_1 >= 0; --v0_1) {
                    Object v1 = arg5.get(v0_1);
                    WindowInsetsAnimationCompat v2 = this.getWindowInsetsAnimationCompat(((WindowInsetsAnimation)v1));
                    v2.setFraction(((WindowInsetsAnimation)v1).getFraction());
                    this.mTmpRunningAnimations.add(v2);
                }

                return this.mCompat.onProgress(WindowInsetsCompat.toWindowInsetsCompat(arg4), this.mRORunningAnimations).toWindowInsets();
            }

            public WindowInsetsAnimation$Bounds onStart(WindowInsetsAnimation arg2, WindowInsetsAnimation$Bounds arg3) {
                return this.mCompat.onStart(this.getWindowInsetsAnimationCompat(arg2), BoundsCompat.toBoundsCompat(arg3)).toBounds();
            }
        }

        private final WindowInsetsAnimation mWrapped;

        Impl30(int arg2, Interpolator arg3, long arg4) {
            this(new WindowInsetsAnimation(arg2, arg3, arg4));
        }

        Impl30(WindowInsetsAnimation arg5) {
            super(0, null, 0);
            this.mWrapped = arg5;
        }

        public static WindowInsetsAnimation$Bounds createPlatformBounds(BoundsCompat arg2) {
            return new WindowInsetsAnimation$Bounds(arg2.getLowerBound().toPlatformInsets(), arg2.getUpperBound().toPlatformInsets());
        }

        public float getAlpha() {
            return this.mWrapped.getAlpha();
        }

        public long getDurationMillis() {
            return this.mWrapped.getDurationMillis();
        }

        public float getFraction() {
            return this.mWrapped.getFraction();
        }

        public static Insets getHigherBounds(WindowInsetsAnimation$Bounds arg0) {
            return Insets.toCompatInsets(arg0.getUpperBound());
        }

        public float getInterpolatedFraction() {
            return this.mWrapped.getInterpolatedFraction();
        }

        public Interpolator getInterpolator() {
            return this.mWrapped.getInterpolator();
        }

        public static Insets getLowerBounds(WindowInsetsAnimation$Bounds arg0) {
            return Insets.toCompatInsets(arg0.getLowerBound());
        }

        public int getTypeMask() {
            return this.mWrapped.getTypeMask();
        }

        public void setAlpha(float arg1) {
            this.mWrapped.setAlpha(arg1);
        }

        public static void setCallback(View arg1, Callback arg2) {
            WindowInsetsAnimation$Callback v0_1;
            if(arg2 != null) {
                ProxyCallback v0 = new ProxyCallback(arg2);
            }
            else {
                v0_1 = null;
            }

            arg1.setWindowInsetsAnimationCallback(v0_1);
        }

        public void setFraction(float arg1) {
            this.mWrapped.setFraction(arg1);
        }
    }

    class Impl {
        private float mAlpha;
        private final long mDurationMillis;
        private float mFraction;
        private final Interpolator mInterpolator;
        private final int mTypeMask;

        Impl(int arg2, Interpolator arg3, long arg4) {
            super();
            this.mAlpha = 1f;
            this.mTypeMask = arg2;
            this.mInterpolator = arg3;
            this.mDurationMillis = arg4;
        }

        public float getAlpha() {
            return this.mAlpha;
        }

        public long getDurationMillis() {
            return this.mDurationMillis;
        }

        public float getFraction() {
            return this.mFraction;
        }

        public float getInterpolatedFraction() {
            Interpolator v0 = this.mInterpolator;
            float v1 = this.mFraction;
            if(v0 != null) {
                v1 = v0.getInterpolation(v1);
            }

            return v1;
        }

        public Interpolator getInterpolator() {
            return this.mInterpolator;
        }

        public int getTypeMask() {
            return this.mTypeMask;
        }

        public void setAlpha(float arg1) {
            this.mAlpha = arg1;
        }

        public void setFraction(float arg1) {
            this.mFraction = arg1;
        }
    }

    private static final boolean DEBUG = false;
    private static final String TAG = "WindowInsetsAnimCompat";
    private Impl mImpl;

    public WindowInsetsAnimationCompat(int arg3, Interpolator arg4, long arg5) {
        super();
        if(Build$VERSION.SDK_INT >= 30) {
            this.mImpl = new Impl30(arg3, arg4, arg5);
            return;
        }

        this.mImpl = new Impl21(arg3, arg4, arg5);
    }

    private WindowInsetsAnimationCompat(WindowInsetsAnimation arg5) {
        this(0, null, 0);
        this.mImpl = new Impl30(arg5);
    }

    public float getAlpha() {
        return this.mImpl.getAlpha();
    }

    public long getDurationMillis() {
        return this.mImpl.getDurationMillis();
    }

    public float getFraction() {
        return this.mImpl.getFraction();
    }

    public float getInterpolatedFraction() {
        return this.mImpl.getInterpolatedFraction();
    }

    public Interpolator getInterpolator() {
        return this.mImpl.getInterpolator();
    }

    public int getTypeMask() {
        return this.mImpl.getTypeMask();
    }

    public void setAlpha(float arg1) {
        this.mImpl.setAlpha(arg1);
    }

    static void setCallback(View arg2, Callback arg3) {
        if(Build$VERSION.SDK_INT >= 30) {
            Impl30.setCallback(arg2, arg3);
            return;
        }

        Impl21.setCallback(arg2, arg3);
    }

    public void setFraction(float arg1) {
        this.mImpl.setFraction(arg1);
    }

    static WindowInsetsAnimationCompat toWindowInsetsAnimationCompat(WindowInsetsAnimation arg1) {
        return new WindowInsetsAnimationCompat(arg1);
    }
}

