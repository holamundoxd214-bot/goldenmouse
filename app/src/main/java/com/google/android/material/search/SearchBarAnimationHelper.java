package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimatableView;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.internal.ExpandCollapseAnimationHelper;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

class SearchBarAnimationHelper {
    interface OnLoadAnimationInvocation {
        void invoke(OnLoadAnimationCallback arg1);
    }

    private static final long COLLAPSE_DURATION_MS = 0xFA;
    private static final long COLLAPSE_FADE_IN_CHILDREN_DURATION_MS = 100;
    private static final long EXPAND_DURATION_MS = 300;
    private static final long EXPAND_FADE_OUT_CHILDREN_DURATION_MS = 75;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_DURATION_MS = 0xFA;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_IN_START_DELAY_MS = 500;
    private static final long ON_LOAD_ANIM_CENTER_VIEW_DEFAULT_FADE_OUT_START_DELAY_MS = 750;
    private static final long ON_LOAD_ANIM_SECONDARY_DURATION_MS = 0xFA;
    private static final long ON_LOAD_ANIM_SECONDARY_START_DELAY_MS = 0xFA;
    private final Set collapseAnimationListeners;
    private boolean collapsing;
    private Animator defaultCenterViewAnimator;
    private final Set expandAnimationListeners;
    private boolean expanding;
    private final Set onLoadAnimationCallbacks;
    private boolean onLoadAnimationFadeInEnabled;
    private Animator runningExpandOrCollapseAnimator;
    private Animator secondaryViewAnimator;

    public static void $r8$lambda$1r7Y4hRSo4F1Esrbw5SdK9GHD3Q(Animator arg0) {
        arg0.start();
    }

    SearchBarAnimationHelper() {
        super();
        this.onLoadAnimationCallbacks = new LinkedHashSet();
        this.expandAnimationListeners = new LinkedHashSet();
        this.collapseAnimationListeners = new LinkedHashSet();
        this.onLoadAnimationFadeInEnabled = true;
        this.runningExpandOrCollapseAnimator = null;
    }

    static void access$000(SearchBarAnimationHelper arg0, OnLoadAnimationInvocation arg1) {
        arg0.dispatchOnLoadAnimation(arg1);
    }

    static boolean access$102(SearchBarAnimationHelper arg0, boolean arg1) {
        arg0.expanding = arg1;
        return arg1;
    }

    static Animator access$202(SearchBarAnimationHelper arg0, Animator arg1) {
        arg0.runningExpandOrCollapseAnimator = arg1;
        return arg1;
    }

    static boolean access$302(SearchBarAnimationHelper arg0, boolean arg1) {
        arg0.collapsing = arg1;
        return arg1;
    }

    void addCollapseAnimationListener(AnimatorListenerAdapter arg1) {
        this.collapseAnimationListeners.add(arg1);
    }

    void addExpandAnimationListener(AnimatorListenerAdapter arg1) {
        this.expandAnimationListeners.add(arg1);
    }

    void addOnLoadAnimationCallback(OnLoadAnimationCallback arg1) {
        this.onLoadAnimationCallbacks.add(arg1);
    }

    private void dispatchOnLoadAnimation(OnLoadAnimationInvocation arg2) {
        Iterator v1 = this.onLoadAnimationCallbacks.iterator();
        while(v1.hasNext()) {
            arg2.invoke(v1.next());
        }
    }

    private Animator getCollapseAnimator(SearchBar arg3, View arg4, AppBarLayout arg5) {
        return this.getExpandCollapseAnimationHelper(arg3, arg4, arg5).setDuration(0xFA).addListener(new AnimatorListenerAdapter(arg3) {
            public void onAnimationEnd(Animator arg2) {
                this.val$searchBar.setVisibility(0);
                SearchBarAnimationHelper.this.collapsing = false;
            }

            public void onAnimationStart(Animator arg1) {
                this.val$searchBar.stopOnLoadAnimation();
            }
        }).getCollapseAnimator();
    }

    private Animator getDefaultCenterViewAnimator(View arg12) {
        int v0 = 2;
        ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        v1.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{arg12}));
        v1.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        long v5 = 0xFA;
        long v7 = 0;
        long v9 = this.onLoadAnimationFadeInEnabled ? v5 : v7;
        v1.setDuration(v9);
        if(this.onLoadAnimationFadeInEnabled) {
            v7 = 500;
        }

        v1.setStartDelay(v7);
        ValueAnimator v11 = ValueAnimator.ofFloat(new float[]{1f, 0f});
        v11.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{arg12}));
        v11.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        v11.setDuration(v5);
        v11.setStartDelay(750);
        AnimatorSet v12 = new AnimatorSet();
        Animator[] v0_1 = new Animator[v0];
        v0_1[0] = v1;
        v0_1[1] = v11;
        v12.playSequentially(v0_1);
        return ((Animator)v12);
    }

    private List getEndAnchoredViews(View arg5) {
        boolean v4 = ViewUtils.isLayoutRtl(arg5);
        ArrayList v0 = new ArrayList();
        if((arg5 instanceof ViewGroup)) {
            int v1;
            for(v1 = 0; v1 < ((ViewGroup)arg5).getChildCount(); ++v1) {
                View v2 = ((ViewGroup)arg5).getChildAt(v1);
                if(!v4 && ((v2 instanceof ActionMenuView)) || (v4) && !(v2 instanceof ActionMenuView)) {
                    ((List)v0).add(v2);
                }
            }
        }

        return ((List)v0);
    }

    private Animator getExpandAnimator(SearchBar arg3, View arg4, AppBarLayout arg5) {
        return this.getExpandCollapseAnimationHelper(arg3, arg4, arg5).setDuration(300).addListener(new AnimatorListenerAdapter(arg3) {
            public void onAnimationEnd(Animator arg1) {
                SearchBarAnimationHelper.this.expanding = false;
            }

            public void onAnimationStart(Animator arg1) {
                this.val$searchBar.setVisibility(4);
            }
        }).getExpandAnimator();
    }

    private ExpandCollapseAnimationHelper getExpandCollapseAnimationHelper(SearchBar arg2, View arg3, AppBarLayout arg4) {
        ExpandCollapseAnimationHelper v2 = new ExpandCollapseAnimationHelper(((View)arg2), arg3).setAdditionalUpdateListener(this.getExpandedViewBackgroundUpdateListener(arg2, arg3));
        int v4 = arg4 != null ? arg4.getTop() : 0;
        return v2.setCollapsedViewOffsetY(v4).addEndAnchoredViews(this.getEndAnchoredViews(arg3));
    }

    private ValueAnimator$AnimatorUpdateListener getExpandedViewBackgroundUpdateListener(SearchBar arg2, View arg3) {
        MaterialShapeDrawable v1 = MaterialShapeDrawable.createWithElevationOverlay(arg3.getContext());
        v1.setCornerSize(arg2.getCornerSize());
        v1.setElevation(ViewCompat.getElevation(((View)arg2)));
        return new SearchBarAnimationHelper$$ExternalSyntheticLambda4(v1, arg3);
    }

    private List getFadeChildren(SearchBar arg2) {
        List v1 = ViewUtils.getChildren(((View)arg2));
        if(arg2.getCenterView() != null) {
            v1.remove(arg2.getCenterView());
        }

        return v1;
    }

    private Animator getFadeInChildrenAnimator(SearchBar arg3) {
        List v2 = this.getFadeChildren(arg3);
        ValueAnimator v3 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        v3.addUpdateListener(MultiViewUpdateListener.alphaListener(((Collection)v2)));
        v3.setDuration(100);
        v3.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return ((Animator)v3);
    }

    private Animator getFadeOutChildrenAnimator(SearchBar arg3, View arg4) {
        List v2 = this.getFadeChildren(arg3);
        ValueAnimator v3 = ValueAnimator.ofFloat(new float[]{1f, 0f});
        v3.addUpdateListener(MultiViewUpdateListener.alphaListener(((Collection)v2)));
        v3.addUpdateListener(new SearchBarAnimationHelper$$ExternalSyntheticLambda0(arg4));
        v3.setDuration(75);
        v3.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        return ((Animator)v3);
    }

    private Animator getSecondaryActionMenuItemAnimator(View arg3) {
        ValueAnimator v2 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        v2.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{arg3}));
        v2.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        v2.setDuration(0xFA);
        return ((Animator)v2);
    }

    private Animator getSecondaryViewAnimator(TextView arg4, View arg5) {
        AnimatorSet v0 = new AnimatorSet();
        v0.setStartDelay(0xFA);
        v0.play(this.getTextViewAnimator(arg4));
        if(arg5 != null) {
            v0.play(this.getSecondaryActionMenuItemAnimator(arg5));
        }

        return ((Animator)v0);
    }

    private Animator getTextViewAnimator(TextView arg3) {
        ValueAnimator v2 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        v2.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{arg3}));
        v2.setInterpolator(AnimationUtils.LINEAR_INTERPOLATOR);
        v2.setDuration(0xFA);
        return ((Animator)v2);
    }

    boolean isCollapsing() {
        return this.collapsing;
    }

    boolean isExpanding() {
        return this.expanding;
    }

    boolean isOnLoadAnimationFadeInEnabled() {
        return this.onLoadAnimationFadeInEnabled;
    }

    static void lambda$getExpandedViewBackgroundUpdateListener$1(MaterialShapeDrawable arg1, View arg2, ValueAnimator arg3) {
        arg1.setInterpolation(1f - arg3.getAnimatedFraction());
        ViewCompat.setBackground(arg2, ((Drawable)arg1));
        arg2.setAlpha(1f);
    }

    static void lambda$getFadeOutChildrenAnimator$2(View arg0, ValueAnimator arg1) {
        arg0.setAlpha(0f);
    }

    void lambda$startExpandAnimation$0$com-google-android-material-search-SearchBarAnimationHelper(SearchBar arg3, View arg4, AppBarLayout arg5, boolean arg6) {
        AnimatorSet v0 = new AnimatorSet();
        v0.playSequentially(new Animator[]{this.getFadeOutChildrenAnimator(arg3, arg4), this.getExpandAnimator(arg3, arg4, arg5)});
        v0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                SearchBarAnimationHelper.this.runningExpandOrCollapseAnimator = null;
            }
        });
        Iterator v3 = this.expandAnimationListeners.iterator();
        while(v3.hasNext()) {
            v0.addListener(v3.next());
        }

        if(arg6) {
            v0.setDuration(0);
        }

        v0.start();
        this.runningExpandOrCollapseAnimator = ((Animator)v0);
    }

    boolean removeCollapseAnimationListener(AnimatorListenerAdapter arg1) {
        return this.collapseAnimationListeners.remove(arg1);
    }

    boolean removeExpandAnimationListener(AnimatorListenerAdapter arg1) {
        return this.expandAnimationListeners.remove(arg1);
    }

    boolean removeOnLoadAnimationCallback(OnLoadAnimationCallback arg1) {
        return this.onLoadAnimationCallbacks.remove(arg1);
    }

    void setOnLoadAnimationFadeInEnabled(boolean arg1) {
        this.onLoadAnimationFadeInEnabled = arg1;
    }

    void startCollapseAnimation(SearchBar arg4, View arg5, AppBarLayout arg6, boolean arg7) {
        if(this.isExpanding()) {
            Animator v0 = this.runningExpandOrCollapseAnimator;
            if(v0 != null) {
                v0.cancel();
            }
        }

        this.collapsing = true;
        AnimatorSet v1 = new AnimatorSet();
        v1.playSequentially(new Animator[]{this.getCollapseAnimator(arg4, arg5, arg6), this.getFadeInChildrenAnimator(arg4)});
        v1.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                SearchBarAnimationHelper.this.runningExpandOrCollapseAnimator = null;
            }
        });
        Iterator v4 = this.collapseAnimationListeners.iterator();
        while(v4.hasNext()) {
            v1.addListener(v4.next());
        }

        if(arg7) {
            v1.setDuration(0);
        }

        v1.start();
        this.runningExpandOrCollapseAnimator = ((Animator)v1);
    }

    void startExpandAnimation(SearchBar arg8, View arg9, AppBarLayout arg10, boolean arg11) {
        if(this.isCollapsing()) {
            Animator v0 = this.runningExpandOrCollapseAnimator;
            if(v0 != null) {
                v0.cancel();
            }
        }

        this.expanding = true;
        arg9.setVisibility(4);
        arg9.post(new SearchBarAnimationHelper$$ExternalSyntheticLambda3(this, arg8, arg9, arg10, arg11));
    }

    void startOnLoadAnimation(SearchBar arg5) {
        this.dispatchOnLoadAnimation(new SearchBarAnimationHelper$$ExternalSyntheticLambda1());
        TextView v0 = arg5.getTextView();
        View v1 = arg5.getCenterView();
        View v5 = ToolbarUtils.getSecondaryActionMenuItemView(((Toolbar)arg5));
        Animator v2 = this.getSecondaryViewAnimator(v0, v5);
        v2.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                SearchBarAnimationHelper.this.dispatchOnLoadAnimation(new SearchBarAnimationHelper$1$$ExternalSyntheticLambda0());
            }
        });
        this.secondaryViewAnimator = v2;
        v0.setAlpha(0f);
        if(v5 != null) {
            v5.setAlpha(0f);
        }

        if((v1 instanceof AnimatableView)) {
            Objects.requireNonNull(v2);
            ((AnimatableView)v1).startAnimation(new SearchBarAnimationHelper$$ExternalSyntheticLambda2(v2));
            return;
        }

        if(v1 != null) {
            v1.setAlpha(0f);
            v1.setVisibility(0);
            Animator v5_1 = this.getDefaultCenterViewAnimator(v1);
            this.defaultCenterViewAnimator = v5_1;
            v5_1.addListener(new AnimatorListenerAdapter(v1, v2) {
                public void onAnimationEnd(Animator arg2) {
                    this.val$centerView.setVisibility(8);
                    this.val$secondaryViewAnimator.start();
                }
            });
            v5_1.start();
            return;
        }

        v2.start();
    }

    void stopOnLoadAnimation(SearchBar arg2) {
        Animator v0 = this.secondaryViewAnimator;
        if(v0 != null) {
            v0.end();
        }

        Animator v1 = this.defaultCenterViewAnimator;
        if(v1 != null) {
            v1.end();
        }

        View v1_1 = arg2.getCenterView();
        if((v1_1 instanceof AnimatableView)) {
            v1_1.stopAnimation();
        }

        if(v1_1 != null) {
            v1_1.setAlpha(0f);
        }
    }
}

