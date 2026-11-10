package androidx.transition;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class ChangeClipBounds extends Transition {
    class Listener extends AnimatorListenerAdapter implements TransitionListener {
        private final Rect mEnd;
        private final Rect mStart;
        private final View mView;

        Listener(View arg1, Rect arg2, Rect arg3) {
            super();
            this.mView = arg1;
            this.mStart = arg2;
            this.mEnd = arg3;
        }

        public void onAnimationEnd(Animator arg2) {
            this.onAnimationEnd(arg2, false);
        }

        public void onAnimationEnd(Animator arg1, boolean arg2) {
            View v1 = this.mView;
            if(!arg2) {
                v1.setClipBounds(this.mEnd);
                return;
            }

            v1.setClipBounds(this.mStart);
        }

        public void onTransitionCancel(Transition arg1) {
        }

        public void onTransitionEnd(Transition arg1) {
        }

        public void onTransitionPause(Transition arg3) {
            Rect v3 = this.mView.getClipBounds();
            if(v3 == null) {
                v3 = ChangeClipBounds.NULL_SENTINEL;
            }

            this.mView.setTag(id.transition_clip, v3);
            this.mView.setClipBounds(this.mEnd);
        }

        public void onTransitionResume(Transition arg2) {
            this.mView.setClipBounds(this.mView.getTag(id.transition_clip));
            this.mView.setTag(id.transition_clip, null);
        }

        public void onTransitionStart(Transition arg1) {
        }
    }

    static final Rect NULL_SENTINEL = null;
    private static final String PROPNAME_BOUNDS = "android:clipBounds:bounds";
    private static final String PROPNAME_CLIP = "android:clipBounds:clip";
    private static final String[] sTransitionProperties;

    static {
        ChangeClipBounds.sTransitionProperties = new String[]{"android:clipBounds:clip"};
        ChangeClipBounds.NULL_SENTINEL = new Rect();
    }

    public ChangeClipBounds() {
        super();
    }

    public ChangeClipBounds(Context arg1, AttributeSet arg2) {
        super(arg1, arg2);
    }

    public void captureEndValues(TransitionValues arg2) {
        this.captureValues(arg2, false);
    }

    public void captureStartValues(TransitionValues arg2) {
        this.captureValues(arg2, true);
    }

    private void captureValues(TransitionValues arg3, boolean arg4) {
        Rect v4_1;
        View v2 = arg3.view;
        if(v2.getVisibility() == 8) {
        }
        else {
            Object v0 = null;
            Object v4 = arg4 ? v2.getTag(id.transition_clip) : v0;
            if(v4 == null) {
                v4_1 = v2.getClipBounds();
            }

            if(v4_1 == ChangeClipBounds.NULL_SENTINEL) {
            }
            else {
                v0 = v4_1;
            }

            arg3.values.put("android:clipBounds:clip", v0);
            if(v0 != null) {
                return;
            }

            arg3.values.put("android:clipBounds:bounds", new Rect(0, 0, v2.getWidth(), v2.getHeight()));
        }
    }

    public Animator createAnimator(ViewGroup arg8, TransitionValues arg9, TransitionValues arg10) {
        ObjectAnimator v8_1;
        Animator v8 = null;
        if(arg9 != null && arg10 != null) {
            String v1 = "android:clipBounds:clip";
            if(arg9.values.containsKey(v1)) {
                if(!arg10.values.containsKey(v1)) {
                }
                else {
                    Object v0 = arg9.values.get(v1);
                    Object v1_1 = arg10.values.get(v1);
                    if(v0 == null && v1_1 == null) {
                        return v8;
                    }

                    String v2 = "android:clipBounds:bounds";
                    Object v9 = v0 == null ? arg9.values.get(v2) : v0;
                    Object v2_1 = v1_1 == null ? arg10.values.get(v2) : v1_1;
                    if(((Rect)v9).equals(v2_1)) {
                        return v8;
                    }

                    arg10.view.setClipBounds(((Rect)v0));
                    v8_1 = ObjectAnimator.ofObject(arg10.view, ViewUtils.CLIP_BOUNDS, new RectEvaluator(new Rect()), new Rect[]{v9, v2_1});
                    Listener v10 = new Listener(arg10.view, ((Rect)v0), ((Rect)v1_1));
                    v8_1.addListener(((Animator$AnimatorListener)v10));
                    this.addListener(((TransitionListener)v10));
                }
            }
        }

        return ((Animator)v8_1);
    }

    public String[] getTransitionProperties() {
        return ChangeClipBounds.sTransitionProperties;
    }

    public boolean isSeekingSupported() {
        return 1;
    }
}

