package androidx.transition;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.view.View;

class TranslationAnimationCreator {
    class TransitionPositionListener extends AnimatorListenerAdapter implements TransitionListener {
        private boolean mIsTransitionCanceled;
        private final View mMovingView;
        private float mPausedX;
        private float mPausedY;
        private final float mTerminalX;
        private final float mTerminalY;
        private int[] mTransitionPosition;
        private final View mViewInHierarchy;

        TransitionPositionListener(View arg1, View arg2, float arg3, float arg4) {
            super();
            this.mMovingView = arg1;
            this.mViewInHierarchy = arg2;
            this.mTerminalX = arg3;
            this.mTerminalY = arg4;
            Object v1 = arg2.getTag(id.transition_position);
            this.mTransitionPosition = ((int[])v1);
            if(v1 != null) {
                arg2.setTag(id.transition_position, null);
            }
        }

        public void onAnimationCancel(Animator arg2) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onAnimationEnd(Animator arg2) {
            this.onAnimationEnd(arg2, false);
        }

        public void onAnimationEnd(Animator arg1, boolean arg2) {
            if(!arg2) {
                this.mMovingView.setTranslationX(this.mTerminalX);
                this.mMovingView.setTranslationY(this.mTerminalY);
            }
        }

        public void onTransitionCancel(Transition arg2) {
            this.mIsTransitionCanceled = true;
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onTransitionEnd(Transition arg2) {
            this.onTransitionEnd(arg2, false);
        }

        public void onTransitionEnd(Transition arg1, boolean arg2) {
            if(!this.mIsTransitionCanceled) {
                this.mViewInHierarchy.setTag(id.transition_position, null);
            }
        }

        public void onTransitionPause(Transition arg2) {
            this.setInterruptedPosition();
            this.mPausedX = this.mMovingView.getTranslationX();
            this.mPausedY = this.mMovingView.getTranslationY();
            this.mMovingView.setTranslationX(this.mTerminalX);
            this.mMovingView.setTranslationY(this.mTerminalY);
        }

        public void onTransitionResume(Transition arg2) {
            this.mMovingView.setTranslationX(this.mPausedX);
            this.mMovingView.setTranslationY(this.mPausedY);
        }

        public void onTransitionStart(Transition arg1) {
        }

        private void setInterruptedPosition() {
            int[] v0 = this.mTransitionPosition;
            if(v0 == null) {
                v0 = new int[2];
                this.mTransitionPosition = v0;
            }

            this.mMovingView.getLocationOnScreen(v0);
            this.mViewInHierarchy.setTag(id.transition_position, this.mTransitionPosition);
        }
    }

    private TranslationAnimationCreator() {
        super();
    }

    static Animator createAnimation(View arg6, TransitionValues arg7, int arg8, int arg9, float arg10, float arg11, float arg12, float arg13, TimeInterpolator arg14, Transition arg15) {
        float v0 = arg6.getTranslationX();
        float v1 = arg6.getTranslationY();
        Object v2 = arg7.view.getTag(id.transition_position);
        if(v2 != null) {
            arg10 = (((float)(v2[0] - arg8))) + v0;
            arg11 = (((float)(v2[1] - arg9))) + v1;
        }

        arg6.setTranslationX(arg10);
        arg6.setTranslationY(arg11);
        if(arg10 == arg12 && arg11 == arg13) {
            return null;
        }

        ObjectAnimator v8 = ObjectAnimator.ofPropertyValuesHolder(arg6, new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.TRANSLATION_X, new float[]{arg10, arg12}), PropertyValuesHolder.ofFloat(View.TRANSLATION_Y, new float[]{arg11, arg13})});
        TransitionPositionListener v9 = new TransitionPositionListener(arg6, arg7.view, v0, v1);
        arg15.addListener(((TransitionListener)v9));
        v8.addListener(((Animator$AnimatorListener)v9));
        v8.setInterpolator(arg14);
        return ((Animator)v8);
    }
}

