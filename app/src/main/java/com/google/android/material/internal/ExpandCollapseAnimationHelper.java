package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.view.View;
import com.google.android.material.animation.AnimationUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class ExpandCollapseAnimationHelper {
    private ValueAnimator$AnimatorUpdateListener additionalUpdateListener;
    private final View collapsedView;
    private int collapsedViewOffsetY;
    private long duration;
    private final List endAnchoredViews;
    private final View expandedView;
    private int expandedViewOffsetY;
    private final List listeners;

    public ExpandCollapseAnimationHelper(View arg1, View arg2) {
        super();
        this.collapsedView = arg1;
        this.expandedView = arg2;
        this.listeners = new ArrayList();
        this.endAnchoredViews = new ArrayList();
    }

    static View access$000(ExpandCollapseAnimationHelper arg0) {
        return arg0.expandedView;
    }

    public ExpandCollapseAnimationHelper addEndAnchoredViews(Collection arg2) {
        this.endAnchoredViews.addAll(arg2);
        return this;
    }

    public ExpandCollapseAnimationHelper addEndAnchoredViews(View[] arg2) {
        Collections.addAll(this.endAnchoredViews, ((Object[])arg2));
        return this;
    }

    public ExpandCollapseAnimationHelper addListener(AnimatorListenerAdapter arg2) {
        this.listeners.add(arg2);
        return this;
    }

    private void addListeners(Animator arg1, List arg2) {
        Iterator v0 = arg2.iterator();
        while(v0.hasNext()) {
            arg1.addListener(v0.next());
        }
    }

    private AnimatorSet getAnimatorSet(boolean arg5) {
        AnimatorSet v0 = new AnimatorSet();
        v0.playTogether(new Animator[]{this.getExpandCollapseAnimator(arg5), this.getExpandedViewChildrenAlphaAnimator(arg5), this.getEndAnchoredViewsTranslateAnimator(arg5)});
        return v0;
    }

    public Animator getCollapseAnimator() {
        AnimatorSet v0 = this.getAnimatorSet(false);
        ((Animator)v0).addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(8);
            }
        });
        this.addListeners(((Animator)v0), this.listeners);
        return ((Animator)v0);
    }

    private Animator getEndAnchoredViewsTranslateAnimator(boolean arg4) {
        ValueAnimator v0 = ValueAnimator.ofFloat(new float[]{((float)(this.expandedView.getLeft() - this.collapsedView.getLeft() + (this.collapsedView.getRight() - this.expandedView.getRight()))), 0f});
        v0.addUpdateListener(MultiViewUpdateListener.translationXListener(this.endAnchoredViews));
        v0.setDuration(this.duration);
        v0.setInterpolator(ReversableAnimatedValueInterpolator.of(arg4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return ((Animator)v0);
    }

    public Animator getExpandAnimator() {
        AnimatorSet v0 = this.getAnimatorSet(true);
        ((Animator)v0).addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator arg1) {
                ExpandCollapseAnimationHelper.this.expandedView.setVisibility(0);
            }
        });
        this.addListeners(((Animator)v0), this.listeners);
        return ((Animator)v0);
    }

    private Animator getExpandCollapseAnimator(boolean arg5) {
        Rect v0 = ViewUtils.calculateRectFromBounds(this.collapsedView, this.collapsedViewOffsetY);
        Rect v1 = ViewUtils.calculateRectFromBounds(this.expandedView, this.expandedViewOffsetY);
        Rect v2 = new Rect(v0);
        ValueAnimator v0_1 = ValueAnimator.ofObject(new RectEvaluator(v2), new Object[]{v0, v1});
        v0_1.addUpdateListener(new ExpandCollapseAnimationHelper$$ExternalSyntheticLambda0(this, v2));
        ValueAnimator$AnimatorUpdateListener v1_1 = this.additionalUpdateListener;
        if(v1_1 != null) {
            v0_1.addUpdateListener(v1_1);
        }

        v0_1.setDuration(this.duration);
        v0_1.setInterpolator(ReversableAnimatedValueInterpolator.of(arg5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return ((Animator)v0_1);
    }

    private Animator getExpandedViewChildrenAlphaAnimator(boolean arg5) {
        List v0 = ViewUtils.getChildren(this.expandedView);
        ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        v1.addUpdateListener(MultiViewUpdateListener.alphaListener(((Collection)v0)));
        v1.setDuration(this.duration);
        v1.setInterpolator(ReversableAnimatedValueInterpolator.of(arg5, AnimationUtils.LINEAR_INTERPOLATOR));
        return ((Animator)v1);
    }

    void lambda$getExpandCollapseAnimator$0$com-google-android-material-internal-ExpandCollapseAnimationHelper(Rect arg1, ValueAnimator arg2) {
        ViewUtils.setBoundsFromRect(this.expandedView, arg1);
    }

    public ExpandCollapseAnimationHelper setAdditionalUpdateListener(ValueAnimator$AnimatorUpdateListener arg1) {
        this.additionalUpdateListener = arg1;
        return this;
    }

    public ExpandCollapseAnimationHelper setCollapsedViewOffsetY(int arg1) {
        this.collapsedViewOffsetY = arg1;
        return this;
    }

    public ExpandCollapseAnimationHelper setDuration(long arg1) {
        this.duration = arg1;
        return this;
    }

    public ExpandCollapseAnimationHelper setExpandedViewOffsetY(int arg1) {
        this.expandedViewOffsetY = arg1;
        return this;
    }
}

