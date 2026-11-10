package androidx.transition;

import android.animation.Animator$AnimatorListener;
import android.animation.Animator$AnimatorPauseListener;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.view.ViewCompat;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.xmlpull.v1.XmlPullParser;

public abstract class Visibility extends Transition {
    class DisappearListener extends AnimatorListenerAdapter implements TransitionListener {
        boolean mCanceled;
        private final int mFinalVisibility;
        private boolean mLayoutSuppressed;
        private final ViewGroup mParent;
        private final boolean mSuppressLayout;
        private final View mView;

        DisappearListener(View arg2, int arg3, boolean arg4) {
            super();
            this.mCanceled = false;
            this.mView = arg2;
            this.mFinalVisibility = arg3;
            this.mParent = arg2.getParent();
            this.mSuppressLayout = arg4;
            this.suppressLayout(true);
        }

        private void hideViewWhenNotCanceled() {
            if(!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
                ViewGroup v0 = this.mParent;
                if(v0 != null) {
                    v0.invalidate();
                }
            }

            this.suppressLayout(false);
        }

        public void onAnimationCancel(Animator arg1) {
            this.mCanceled = true;
        }

        public void onAnimationEnd(Animator arg1) {
            this.hideViewWhenNotCanceled();
        }

        public void onAnimationEnd(Animator arg1, boolean arg2) {
            if(!arg2) {
                this.hideViewWhenNotCanceled();
            }
        }

        public void onAnimationRepeat(Animator arg1) {
        }

        public void onAnimationStart(Animator arg1) {
        }

        public void onAnimationStart(Animator arg1, boolean arg2) {
            if(arg2) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
                ViewGroup v0 = this.mParent;
                if(v0 != null) {
                    v0.invalidate();
                }
            }
        }

        public void onTransitionCancel(Transition arg1) {
        }

        public void onTransitionEnd(Transition arg1) {
            arg1.removeListener(((TransitionListener)this));
        }

        public void onTransitionPause(Transition arg1) {
            this.suppressLayout(false);
            if(!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, this.mFinalVisibility);
            }
        }

        public void onTransitionResume(Transition arg1) {
            this.suppressLayout(true);
            if(!this.mCanceled) {
                ViewUtils.setTransitionVisibility(this.mView, 0);
            }
        }

        public void onTransitionStart(Transition arg1) {
        }

        private void suppressLayout(boolean arg2) {
            if((this.mSuppressLayout) && this.mLayoutSuppressed != arg2) {
                ViewGroup v0 = this.mParent;
                if(v0 != null) {
                    this.mLayoutSuppressed = arg2;
                    ViewGroupUtils.suppressLayout(v0, arg2);
                }
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface Mode {
    }

    class OverlayListener extends AnimatorListenerAdapter implements TransitionListener {
        private boolean mHasOverlay;
        private final ViewGroup mOverlayHost;
        private final View mOverlayView;
        private final View mStartView;

        OverlayListener(Visibility arg1, ViewGroup arg2, View arg3, View arg4) {
            Visibility.this = arg1;
            super();
            this.mHasOverlay = true;
            this.mOverlayHost = arg2;
            this.mOverlayView = arg3;
            this.mStartView = arg4;
        }

        public void onAnimationEnd(Animator arg1) {
            this.removeFromOverlay();
        }

        public void onAnimationEnd(Animator arg1, boolean arg2) {
            if(!arg2) {
                this.removeFromOverlay();
            }
        }

        public void onAnimationPause(Animator arg1) {
            this.mOverlayHost.getOverlay().remove(this.mOverlayView);
        }

        public void onAnimationResume(Animator arg1) {
            if(this.mOverlayView.getParent() == null) {
                ViewCompat.addOverlayView(this.mOverlayHost, this.mOverlayView);
                return;
            }

            Visibility.this.cancel();
        }

        public void onAnimationStart(Animator arg2, boolean arg3) {
            if(arg3) {
                this.mStartView.setTag(id.save_overlay_view, this.mOverlayView);
                ViewCompat.addOverlayView(this.mOverlayHost, this.mOverlayView);
                this.mHasOverlay = true;
            }
        }

        public void onTransitionCancel(Transition arg1) {
            if(this.mHasOverlay) {
                this.removeFromOverlay();
            }
        }

        public void onTransitionEnd(Transition arg1) {
            arg1.removeListener(((TransitionListener)this));
        }

        public void onTransitionPause(Transition arg1) {
        }

        public void onTransitionResume(Transition arg1) {
        }

        public void onTransitionStart(Transition arg1) {
        }

        private void removeFromOverlay() {
            this.mStartView.setTag(id.save_overlay_view, null);
            this.mOverlayHost.getOverlay().remove(this.mOverlayView);
            this.mHasOverlay = false;
        }
    }

    class VisibilityInfo {
        ViewGroup mEndParent;
        int mEndVisibility;
        boolean mFadeIn;
        ViewGroup mStartParent;
        int mStartVisibility;
        boolean mVisibilityChange;

        VisibilityInfo() {
            super();
        }
    }

    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private int mMode;
    private static final String[] sTransitionProperties;

    static {
        Visibility.sTransitionProperties = new String[]{"android:visibility:visibility", "android:visibility:parent"};
    }

    public Visibility() {
        super();
        this.mMode = 3;
    }

    public Visibility(Context arg3, AttributeSet arg4) {
        super(arg3, arg4);
        this.mMode = 3;
        TypedArray v3 = arg3.obtainStyledAttributes(arg4, Styleable.VISIBILITY_TRANSITION);
        int v4 = TypedArrayUtils.getNamedInt(v3, ((XmlPullParser)arg4), "transitionVisibilityMode", 0, 0);
        v3.recycle();
        if(v4 != 0) {
            this.setMode(v4);
        }
    }

    public void captureEndValues(TransitionValues arg1) {
        this.captureValues(arg1);
    }

    public void captureStartValues(TransitionValues arg1) {
        this.captureValues(arg1);
    }

    private void captureValues(TransitionValues arg3) {
        arg3.values.put("android:visibility:visibility", Integer.valueOf(arg3.view.getVisibility()));
        arg3.values.put("android:visibility:parent", arg3.view.getParent());
        int[] v2 = new int[2];
        arg3.view.getLocationOnScreen(v2);
        arg3.values.put("android:visibility:screenLocation", v2);
    }

    public Animator createAnimator(ViewGroup arg9, TransitionValues arg10, TransitionValues arg11) {
        VisibilityInfo v0 = this.getVisibilityChangeInfo(arg10, arg11);
        if((v0.mVisibilityChange) && (v0.mStartParent != null || v0.mEndParent != null)) {
            if(v0.mFadeIn) {
                return this.onAppear(arg9, arg10, v0.mStartVisibility, arg11, v0.mEndVisibility);
            }

            return this.onDisappear(arg9, arg10, v0.mStartVisibility, arg11, v0.mEndVisibility);
        }

        return null;
    }

    public int getMode() {
        return this.mMode;
    }

    public String[] getTransitionProperties() {
        return Visibility.sTransitionProperties;
    }

    private VisibilityInfo getVisibilityChangeInfo(TransitionValues arg7, TransitionValues arg8) {
        VisibilityInfo v6 = new VisibilityInfo();
        v6.mVisibilityChange = false;
        v6.mFadeIn = false;
        String v1 = "android:visibility:parent";
        ViewGroup v2 = null;
        int v3 = -1;
        String v4 = "android:visibility:visibility";
        if(arg7 == null || !arg7.values.containsKey(v4)) {
            v6.mStartVisibility = v3;
            v6.mStartParent = v2;
        }
        else {
            v6.mStartVisibility = arg7.values.get(v4).intValue();
            v6.mStartParent = arg7.values.get(v1);
        }

        if(arg8 == null || !arg8.values.containsKey(v4)) {
            v6.mEndVisibility = v3;
            v6.mEndParent = v2;
        }
        else {
            v6.mEndVisibility = arg8.values.get(v4).intValue();
            v6.mEndParent = arg8.values.get(v1);
        }

        if(arg7 == null || arg8 == null) {
            if(arg7 == null && v6.mEndVisibility == 0) {
                v6.mFadeIn = true;
                v6.mVisibilityChange = true;
                return v6;
            }

            if(arg8 != null) {
                return v6;
            }

            if(v6.mStartVisibility != 0) {
                return v6;
            }

            v6.mFadeIn = false;
            v6.mVisibilityChange = true;
        }
        else {
            if(v6.mStartVisibility == v6.mEndVisibility && v6.mStartParent == v6.mEndParent) {
                return v6;
            }

            if(v6.mStartVisibility != v6.mEndVisibility) {
                if(v6.mStartVisibility == 0) {
                    v6.mFadeIn = false;
                    v6.mVisibilityChange = true;
                    return v6;
                }

                if(v6.mEndVisibility != 0) {
                    return v6;
                }

                v6.mFadeIn = true;
                v6.mVisibilityChange = true;
                return v6;
            }

            if(v6.mEndParent == null) {
                v6.mFadeIn = false;
                v6.mVisibilityChange = true;
                return v6;
            }

            if(v6.mStartParent != null) {
                return v6;
            }

            v6.mFadeIn = true;
            v6.mVisibilityChange = true;
            return v6;
        }

        return v6;
    }

    public boolean isTransitionRequired(TransitionValues arg5, TransitionValues arg6) {
        if(arg5 == null && arg6 == null) {
            return 0;
        }

        if(arg5 != null && arg6 != null && arg6.values.containsKey("android:visibility:visibility") != arg5.values.containsKey("android:visibility:visibility")) {
            return 0;
        }

        VisibilityInfo v4 = this.getVisibilityChangeInfo(arg5, arg6);
        if((v4.mVisibilityChange) && (v4.mStartVisibility == 0 || v4.mEndVisibility == 0)) {
            return 1;
        }

        return 0;
    }

    public boolean isVisible(TransitionValues arg3) {
        boolean v2 = false;
        if(arg3 == null) {
            return 0;
        }

        int v0 = arg3.values.get("android:visibility:visibility").intValue();
        Object v3 = arg3.values.get("android:visibility:parent");
        if(v0 == 0 && v3 != null) {
            v2 = true;
        }

        return v2;
    }

    public Animator onAppear(ViewGroup arg3, TransitionValues arg4, int arg5, TransitionValues arg6, int arg7) {
        Animator v0 = null;
        if((this.mMode & 1) == 1) {
            if(arg6 == null) {
            }
            else {
                if(arg4 == null) {
                    ViewParent v5 = arg6.view.getParent();
                    if(this.getVisibilityChangeInfo(this.getMatchedTransitionValues(((View)v5), false), this.getTransitionValues(((View)v5), false)).mVisibilityChange) {
                        return v0;
                    }
                }

                return this.onAppear(arg3, arg6.view, arg4, arg6);
            }
        }

        return v0;
    }

    public Animator onAppear(ViewGroup arg1, View arg2, TransitionValues arg3, TransitionValues arg4) {
        return null;
    }

    public Animator onDisappear(ViewGroup arg10, TransitionValues arg11, int arg12, TransitionValues arg13, int arg14) {
        View v3_1;
        int v6;
        int v0 = 2;
        Animator v1 = null;
        if((this.mMode & v0) != v0) {
            return v1;
        }

        if(arg11 == null) {
            return v1;
        }

        View v12 = arg11.view;
        View v2 = arg13 != null ? arg13.view : ((View)v1);
        Object v3 = v12.getTag(id.save_overlay_view);
        if(v3 != null) {
            v2 = ((View)v1);
            v6 = 1;
        }
        else {
            if(v2 == null || v2.getParent() == null) {
                if(v2 != null) {
                    v3_1 = ((View)v1);
                    v6 = 0;
                    goto label_40;
                }

            label_37:
                v2 = ((View)v1);
                v3_1 = v2;
                v6 = 1;
            }
            else {
                if(arg14 == 4) {
                }
                else {
                    if(v12 == v2) {
                        goto label_29;
                    }

                    goto label_37;
                }

            label_29:
                v3_1 = v2;
                v6 = 0;
                v2 = ((View)v1);
            }

        label_40:
            if(v6 != 0) {
                if(v12.getParent() == null) {
                }
                else if((v12.getParent() instanceof View)) {
                    ViewParent v6_1 = v12.getParent();
                    if(!this.getVisibilityChangeInfo(this.getTransitionValues(((View)v6_1), true), this.getMatchedTransitionValues(((View)v6_1), true)).mVisibilityChange) {
                        v2 = TransitionUtils.copyViewImage(arg10, v12, ((View)v6_1));
                    }
                    else {
                        int v7 = ((View)v6_1).getId();
                        if(((View)v6_1).getParent() != null) {
                        }
                        else if(v7 == -1) {
                        }
                        else if(arg10.findViewById(v7) == null) {
                        }
                        else if(this.mCanRemoveViews) {
                            goto label_64;
                        }
                    }

                    goto label_68;
                }
                else {
                    goto label_68;
                }

            label_64:
                v2 = v3_1;
                v6 = 0;
                v3_1 = v12;
                goto label_72;
            }

        label_68:
            View v6_2 = v3_1;
            v3_1 = v2;
            v2 = v6_2;
            v6 = 0;
        }

    label_72:
        if(v3 != null) {
            if(v6 == 0) {
                Object v14 = arg11.values.get("android:visibility:screenLocation");
                int v1_1 = v14[0];
                arg14 = v14[1];
                int[] v0_1 = new int[v0];
                arg10.getLocationOnScreen(v0_1);
                ((View)v3).offsetLeftAndRight(v1_1 - v0_1[0] - ((View)v3).getLeft());
                ((View)v3).offsetTopAndBottom(arg14 - v0_1[1] - ((View)v3).getTop());
                ViewCompat.addOverlayView(arg10, ((View)v3));
            }

            Animator v11 = this.onDisappear(arg10, ((View)v3), arg11, arg13);
            if(v6 == 0) {
                if(v11 == null) {
                    arg10.getOverlay().remove(((View)v3));
                    return v11;
                }
                else {
                    v12.setTag(id.save_overlay_view, v3);
                    OverlayListener v13 = new OverlayListener(this, arg10, ((View)v3), v12);
                    v11.addListener(((Animator$AnimatorListener)v13));
                    v11.addPauseListener(((Animator$AnimatorPauseListener)v13));
                    this.getRootTransition().addListener(((TransitionListener)v13));
                }
            }

            return v11;
        }

        if(v2 != null) {
            arg12 = v2.getVisibility();
            ViewUtils.setTransitionVisibility(v2, 0);
            Animator v10 = this.onDisappear(arg10, v2, arg11, arg13);
            if(v10 != null) {
                DisappearListener v11_1 = new DisappearListener(v2, arg14, true);
                v10.addListener(((Animator$AnimatorListener)v11_1));
                this.getRootTransition().addListener(((TransitionListener)v11_1));
                return v10;
            }

            ViewUtils.setTransitionVisibility(v2, arg12);
            return v10;
        }

        return v1;
    }

    public Animator onDisappear(ViewGroup arg1, View arg2, TransitionValues arg3, TransitionValues arg4) {
        return null;
    }

    public void setMode(int arg2) {
        if((arg2 & -4) == 0) {
            this.mMode = arg2;
            return;
        }

        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }
}

