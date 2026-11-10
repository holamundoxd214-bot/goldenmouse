package androidx.transition;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.res.TypedArrayUtils;
import org.xmlpull.v1.XmlPullParser;

public class Fade extends Visibility {
    class FadeAnimatorListener extends AnimatorListenerAdapter implements TransitionListener {
        private boolean mLayerTypeChanged;
        private final View mView;

        FadeAnimatorListener(View arg2) {
            super();
            this.mLayerTypeChanged = false;
            this.mView = arg2;
        }

        public void onAnimationCancel(Animator arg1) {
            ViewUtils.setTransitionAlpha(this.mView, 1f);
        }

        public void onAnimationEnd(Animator arg2) {
            this.onAnimationEnd(arg2, false);
        }

        public void onAnimationEnd(Animator arg3, boolean arg4) {
            if(this.mLayerTypeChanged) {
                this.mView.setLayerType(0, null);
            }

            if(!arg4) {
                ViewUtils.setTransitionAlpha(this.mView, 1f);
                ViewUtils.clearNonTransitionAlpha(this.mView);
            }
        }

        public void onAnimationStart(Animator arg2) {
            if((this.mView.hasOverlappingRendering()) && this.mView.getLayerType() == 0) {
                this.mLayerTypeChanged = true;
                this.mView.setLayerType(2, null);
            }
        }

        public void onTransitionCancel(Transition arg1) {
        }

        public void onTransitionEnd(Transition arg1) {
        }

        public void onTransitionPause(Transition arg2) {
            float v2 = this.mView.getVisibility() == 0 ? ViewUtils.getTransitionAlpha(this.mView) : 0f;
            this.mView.setTag(id.transition_pause_alpha, Float.valueOf(v2));
        }

        public void onTransitionResume(Transition arg2) {
            this.mView.setTag(id.transition_pause_alpha, null);
        }

        public void onTransitionStart(Transition arg1) {
        }

        public void onTransitionStart(Transition arg1, boolean arg2) {
        }
    }

    public static final int IN = 1;
    private static final String LOG_TAG = "Fade";
    public static final int OUT = 2;
    private static final String PROPNAME_TRANSITION_ALPHA = "android:fade:transitionAlpha";

    public Fade(int arg1) {
        super();
        this.setMode(arg1);
    }

    public Fade() {
        super();
    }

    public Fade(Context arg4, AttributeSet arg5) {
        super(arg4, arg5);
        TypedArray v4 = arg4.obtainStyledAttributes(arg5, Styleable.FADE);
        this.setMode(TypedArrayUtils.getNamedInt(v4, ((XmlPullParser)arg5), "fadingMode", 0, this.getMode()));
        v4.recycle();
    }

    public void captureStartValues(TransitionValues arg2) {
        super.captureStartValues(arg2);
        Object v1 = arg2.view.getTag(id.transition_pause_alpha);
        if(v1 == null) {
            Float v1_1 = arg2.view.getVisibility() == 0 ? Float.valueOf(ViewUtils.getTransitionAlpha(arg2.view)) : Float.valueOf(0f);
        }

        arg2.values.put("android:fade:transitionAlpha", v1);
    }

    private Animator createAnimation(View arg3, float arg4, float arg5) {
        if(arg4 == arg5) {
            return null;
        }

        ViewUtils.setTransitionAlpha(arg3, arg4);
        ObjectAnimator v4 = ObjectAnimator.ofFloat(arg3, ViewUtils.TRANSITION_ALPHA, new float[]{arg5});
        FadeAnimatorListener v5 = new FadeAnimatorListener(arg3);
        v4.addListener(((Animator$AnimatorListener)v5));
        this.getRootTransition().addListener(((TransitionListener)v5));
        return ((Animator)v4);
    }

    private static float getStartAlpha(TransitionValues arg1, float arg2) {
        if(arg1 != null) {
            Object v1 = arg1.values.get("android:fade:transitionAlpha");
            if(v1 != null) {
                return ((Float)v1).floatValue();
            }
        }

        return arg2;
    }

    public boolean isSeekingSupported() {
        return 1;
    }

    public Animator onAppear(ViewGroup arg1, View arg2, TransitionValues arg3, TransitionValues arg4) {
        ViewUtils.saveNonTransitionAlpha(arg2);
        return this.createAnimation(arg2, Fade.getStartAlpha(arg3, 0f), 1f);
    }

    public Animator onDisappear(ViewGroup arg2, View arg3, TransitionValues arg4, TransitionValues arg5) {
        ViewUtils.saveNonTransitionAlpha(arg3);
        float v2 = 1f;
        Animator v1 = this.createAnimation(arg3, Fade.getStartAlpha(arg4, v2), 0f);
        if(v1 == null) {
            ViewUtils.setTransitionAlpha(arg3, Fade.getStartAlpha(arg5, v2));
        }

        return v1;
    }
}

