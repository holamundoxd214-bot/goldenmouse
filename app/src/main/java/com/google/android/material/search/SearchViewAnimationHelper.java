package com.google.android.material.search;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.activity.BackEventCompat;
import androidx.appcompat.graphics.drawable.DrawerArrowDrawable;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.ClippableRoundedCornerLayout;
import com.google.android.material.internal.FadeThroughDrawable;
import com.google.android.material.internal.FadeThroughUpdateListener;
import com.google.android.material.internal.MultiViewUpdateListener;
import com.google.android.material.internal.RectEvaluator;
import com.google.android.material.internal.ReversableAnimatedValueInterpolator;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.internal.TouchObserverFrameLayout;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.motion.MaterialMainContainerBackHelper;
import java.util.Objects;

class SearchViewAnimationHelper {
    private static final float CONTENT_FROM_SCALE = 0.95f;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_DURATION_MS = 42;
    private static final long HIDE_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_ALPHA_DURATION_MS = 83;
    private static final long HIDE_CONTENT_ALPHA_START_DELAY_MS = 0;
    private static final long HIDE_CONTENT_SCALE_DURATION_MS = 0xFA;
    private static final long HIDE_DURATION_MS = 0xFA;
    private static final long HIDE_TRANSLATE_DURATION_MS = 300;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_DURATION_MS = 50;
    private static final long SHOW_CLEAR_BUTTON_ALPHA_START_DELAY_MS = 0xFA;
    private static final long SHOW_CONTENT_ALPHA_DURATION_MS = 150;
    private static final long SHOW_CONTENT_ALPHA_START_DELAY_MS = 75;
    private static final long SHOW_CONTENT_SCALE_DURATION_MS = 300;
    private static final long SHOW_DURATION_MS = 300;
    private static final long SHOW_TRANSLATE_DURATION_MS = 350;
    private static final long SHOW_TRANSLATE_KEYBOARD_START_DELAY_MS = 150;
    private final MaterialMainContainerBackHelper backHelper;
    private AnimatorSet backProgressAnimatorSet;
    private final ImageButton clearButton;
    private final TouchObserverFrameLayout contentContainer;
    private final View divider;
    private final Toolbar dummyToolbar;
    private final EditText editText;
    private final FrameLayout headerContainer;
    private final ClippableRoundedCornerLayout rootView;
    private final View scrim;
    private SearchBar searchBar;
    private final TextView searchPrefix;
    private final SearchView searchView;
    private final Toolbar toolbar;
    private final FrameLayout toolbarContainer;

    SearchViewAnimationHelper(SearchView arg3) {
        super();
        this.searchView = arg3;
        this.scrim = arg3.scrim;
        ClippableRoundedCornerLayout v0 = arg3.rootView;
        this.rootView = v0;
        this.headerContainer = arg3.headerContainer;
        this.toolbarContainer = arg3.toolbarContainer;
        this.toolbar = arg3.toolbar;
        this.dummyToolbar = arg3.dummyToolbar;
        this.searchPrefix = arg3.searchPrefix;
        this.editText = arg3.editText;
        this.clearButton = arg3.clearButton;
        this.divider = arg3.divider;
        this.contentContainer = arg3.contentContainer;
        this.backHelper = new MaterialMainContainerBackHelper(((View)v0));
    }

    static SearchView access$000(SearchViewAnimationHelper arg0) {
        return arg0.searchView;
    }

    static ClippableRoundedCornerLayout access$100(SearchViewAnimationHelper arg0) {
        return arg0.rootView;
    }

    static void access$200(SearchViewAnimationHelper arg0, float arg1) {
        arg0.setContentViewsAlpha(arg1);
    }

    static SearchBar access$300(SearchViewAnimationHelper arg0) {
        return arg0.searchBar;
    }

    private void addActionMenuViewAnimatorIfNeeded(AnimatorSet arg8) {
        ActionMenuView v0 = ToolbarUtils.getActionMenuView(this.toolbar);
        if(v0 == null) {
            return;
        }

        ValueAnimator v3 = ValueAnimator.ofFloat(new float[]{((float)this.getFromTranslationXEnd(((View)v0))), 0f});
        v3.addUpdateListener(MultiViewUpdateListener.translationXListener(new View[]{v0}));
        ValueAnimator v7 = ValueAnimator.ofFloat(new float[]{((float)this.getFromTranslationY()), 0f});
        v7.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{v0}));
        arg8.playTogether(new Animator[]{v3, v7});
    }

    private void addBackButtonProgressAnimatorIfNeeded(AnimatorSet arg3) {
        ImageButton v0 = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if(v0 == null) {
            return;
        }

        Drawable v0_1 = DrawableCompat.unwrap(v0.getDrawable());
        if(this.searchView.isAnimatedNavigationIcon()) {
            this.addDrawerArrowDrawableAnimatorIfNeeded(arg3, v0_1);
            this.addFadeThroughDrawableAnimatorIfNeeded(arg3, v0_1);
            return;
        }

        this.setFullDrawableProgressIfNeeded(v0_1);
    }

    private void addBackButtonTranslationAnimatorIfNeeded(AnimatorSet arg8) {
        ImageButton v0 = ToolbarUtils.getNavigationIconButton(this.toolbar);
        if(v0 == null) {
            return;
        }

        ValueAnimator v3 = ValueAnimator.ofFloat(new float[]{((float)this.getFromTranslationXStart(((View)v0))), 0f});
        v3.addUpdateListener(MultiViewUpdateListener.translationXListener(new View[]{v0}));
        ValueAnimator v7 = ValueAnimator.ofFloat(new float[]{((float)this.getFromTranslationY()), 0f});
        v7.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{v0}));
        arg8.playTogether(new Animator[]{v3, v7});
    }

    private void addDrawerArrowDrawableAnimatorIfNeeded(AnimatorSet arg2, Drawable arg3) {
        if((arg3 instanceof DrawerArrowDrawable)) {
            ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{0f, 1f});
            v1.addUpdateListener(new SearchViewAnimationHelper$$ExternalSyntheticLambda1(((DrawerArrowDrawable)arg3)));
            arg2.playTogether(new Animator[]{v1});
        }
    }

    private void addFadeThroughDrawableAnimatorIfNeeded(AnimatorSet arg2, Drawable arg3) {
        if((arg3 instanceof FadeThroughDrawable)) {
            ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{0f, 1f});
            v1.addUpdateListener(new SearchViewAnimationHelper$$ExternalSyntheticLambda3(((FadeThroughDrawable)arg3)));
            arg2.playTogether(new Animator[]{v1});
        }
    }

    public void cancelBackProgress() {
        this.backHelper.cancelBackProgress(this.searchBar);
        AnimatorSet v0 = this.backProgressAnimatorSet;
        if(v0 != null) {
            v0.reverse();
        }

        this.backProgressAnimatorSet = null;
    }

    public void finishBackProgress() {
        this.backHelper.finishBackProgress(this.hide().getTotalDuration(), this.searchBar);
        if(this.backProgressAnimatorSet != null) {
            this.getButtonsTranslationAnimator(false).start();
            this.backProgressAnimatorSet.resume();
        }

        this.backProgressAnimatorSet = null;
    }

    private Animator getActionMenuViewsAlphaAnimator(boolean arg4) {
        ValueAnimator v0 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        long v1 = arg4 ? 300 : 0xFA;
        v0.setDuration(v1);
        v0.setInterpolator(ReversableAnimatedValueInterpolator.of(arg4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        if(this.searchView.isMenuItemsAnimated()) {
            v0.addUpdateListener(new FadeThroughUpdateListener(ToolbarUtils.getActionMenuView(this.dummyToolbar), ToolbarUtils.getActionMenuView(this.toolbar)));
        }

        return ((Animator)v0);
    }

    MaterialMainContainerBackHelper getBackHelper() {
        return this.backHelper;
    }

    private AnimatorSet getButtonsProgressAnimator(boolean arg4) {
        AnimatorSet v0 = new AnimatorSet();
        this.addBackButtonProgressAnimatorIfNeeded(v0);
        long v1 = arg4 ? 300 : 0xFA;
        v0.setDuration(v1);
        v0.setInterpolator(ReversableAnimatedValueInterpolator.of(arg4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return v0;
    }

    private AnimatorSet getButtonsTranslationAnimator(boolean arg4) {
        AnimatorSet v0 = new AnimatorSet();
        this.addBackButtonTranslationAnimatorIfNeeded(v0);
        this.addActionMenuViewAnimatorIfNeeded(v0);
        long v1 = arg4 ? 300 : 0xFA;
        v0.setDuration(v1);
        v0.setInterpolator(ReversableAnimatedValueInterpolator.of(arg4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return v0;
    }

    private Animator getClearButtonAnimator(boolean arg4) {
        ValueAnimator v0 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        long v1 = arg4 ? 50 : 42;
        v0.setDuration(v1);
        v1 = arg4 ? 0xFA : 0;
        v0.setStartDelay(v1);
        v0.setInterpolator(ReversableAnimatedValueInterpolator.of(arg4, AnimationUtils.LINEAR_INTERPOLATOR));
        v0.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{this.clearButton}));
        return ((Animator)v0);
    }

    private Animator getContentAlphaAnimator(boolean arg5) {
        int v0 = 2;
        ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        long v2 = arg5 ? 150 : 83;
        v1.setDuration(v2);
        v2 = arg5 ? 75 : 0;
        v1.setStartDelay(v2);
        v1.setInterpolator(ReversableAnimatedValueInterpolator.of(arg5, AnimationUtils.LINEAR_INTERPOLATOR));
        View[] v5 = new View[v0];
        v5[0] = this.divider;
        v5[1] = this.contentContainer;
        v1.addUpdateListener(MultiViewUpdateListener.alphaListener(v5));
        return ((Animator)v1);
    }

    private Animator getContentAnimator(boolean arg5) {
        AnimatorSet v0 = new AnimatorSet();
        v0.playTogether(new Animator[]{this.getContentAlphaAnimator(arg5), this.getDividerAnimator(arg5), this.getContentScaleAnimator(arg5)});
        return ((Animator)v0);
    }

    private Animator getContentScaleAnimator(boolean arg4) {
        ValueAnimator v0 = ValueAnimator.ofFloat(new float[]{0.95f, 1f});
        long v1 = arg4 ? 300 : 0xFA;
        v0.setDuration(v1);
        v0.setInterpolator(ReversableAnimatedValueInterpolator.of(arg4, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        v0.addUpdateListener(MultiViewUpdateListener.scaleListener(new View[]{this.contentContainer}));
        return ((Animator)v0);
    }

    private Animator getDividerAnimator(boolean arg6) {
        ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{(((float)this.contentContainer.getHeight())) * 0.05f / 2f, 0f});
        long v3 = arg6 ? 300 : 0xFA;
        v1.setDuration(v3);
        v1.setInterpolator(ReversableAnimatedValueInterpolator.of(arg6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        v1.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{this.divider}));
        return ((Animator)v1);
    }

    private Animator getDummyToolbarAnimator(boolean arg3) {
        return this.getTranslationAnimator(arg3, false, this.dummyToolbar);
    }

    private Animator getEditTextAnimator(boolean arg3) {
        return this.getTranslationAnimator(arg3, true, this.editText);
    }

    private AnimatorSet getExpandCollapseAnimatorSet(boolean arg7) {
        Animator[] v1;
        AnimatorSet v0 = new AnimatorSet();
        int v4 = 2;
        if(this.backProgressAnimatorSet != null) {
        }
        else {
            v1 = new Animator[v4];
            v1[0] = this.getButtonsProgressAnimator(arg7);
            v1[1] = this.getButtonsTranslationAnimator(arg7);
            v0.playTogether(v1);
        }

        v1 = new Animator[9];
        v1[0] = this.getScrimAlphaAnimator(arg7);
        v1[1] = this.getRootViewAnimator(arg7);
        v1[v4] = this.getClearButtonAnimator(arg7);
        v1[3] = this.getContentAnimator(arg7);
        v1[4] = this.getHeaderContainerAnimator(arg7);
        v1[5] = this.getDummyToolbarAnimator(arg7);
        v1[6] = this.getActionMenuViewsAlphaAnimator(arg7);
        v1[7] = this.getEditTextAnimator(arg7);
        v1[8] = this.getSearchPrefixAnimator(arg7);
        v0.playTogether(v1);
        v0.addListener(new AnimatorListenerAdapter(arg7) {
            public void onAnimationEnd(Animator arg2) {
                SearchViewAnimationHelper v2 = SearchViewAnimationHelper.this;
                float v0 = this.val$show ? 1f : 0f;
                v2.setContentViewsAlpha(v0);
                SearchViewAnimationHelper.this.rootView.resetClipBoundsAndCornerRadius();
            }

            public void onAnimationStart(Animator arg1) {
                SearchViewAnimationHelper v1 = SearchViewAnimationHelper.this;
                float v0 = this.val$show ? 0f : 1f;
                v1.setContentViewsAlpha(v0);
            }
        });
        return v0;
    }

    private int getFromTranslationXEnd(View arg3) {
        int v3 = MarginLayoutParamsCompat.getMarginEnd(arg3.getLayoutParams());
        boolean v0 = ViewUtils.isLayoutRtl(this.searchBar);
        SearchBar v1 = this.searchBar;
        if(v0) {
            return v1.getLeft() - v3;
        }

        return v1.getRight() - this.searchView.getWidth() + v3;
    }

    private int getFromTranslationXStart(View arg4) {
        int v4 = MarginLayoutParamsCompat.getMarginStart(arg4.getLayoutParams());
        int v0 = ViewCompat.getPaddingStart(this.searchBar);
        boolean v1 = ViewUtils.isLayoutRtl(this.searchBar);
        SearchBar v2 = this.searchBar;
        if(v1) {
            return v2.getWidth() - this.searchBar.getRight() + v4 - v0;
        }

        return v2.getLeft() - v4 + v0;
    }

    private int getFromTranslationY() {
        return (this.searchBar.getTop() + this.searchBar.getBottom()) / 2 - (this.toolbarContainer.getTop() + this.toolbarContainer.getBottom()) / 2;
    }

    private Animator getHeaderContainerAnimator(boolean arg3) {
        return this.getTranslationAnimator(arg3, false, this.headerContainer);
    }

    private Animator getRootViewAnimator(boolean arg7) {
        Rect v0 = this.backHelper.getInitialHideToClipBounds();
        Rect v1 = this.backHelper.getInitialHideFromClipBounds();
        if(v0 != null) {
        }
        else {
            v0 = ViewUtils.calculateRectFromBounds(this.searchView);
        }

        if(v1 != null) {
        }
        else {
            v1 = ViewUtils.calculateOffsetRectFromBounds(this.rootView, this.searchBar);
        }

        Rect v2 = new Rect(v1);
        float v3 = this.searchBar.getCornerSize();
        float v4 = Math.max(this.rootView.getCornerRadius(), ((float)this.backHelper.getExpandedCornerSize()));
        ValueAnimator v0_1 = ValueAnimator.ofObject(new RectEvaluator(v2), new Object[]{v1, v0});
        v0_1.addUpdateListener(new SearchViewAnimationHelper$$ExternalSyntheticLambda0(this, v3, v4, v2));
        long v1_1 = arg7 ? 300 : 0xFA;
        v0_1.setDuration(v1_1);
        v0_1.setInterpolator(ReversableAnimatedValueInterpolator.of(arg7, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return ((Animator)v0_1);
    }

    private Animator getScrimAlphaAnimator(boolean arg5) {
        TimeInterpolator v0 = arg5 ? AnimationUtils.LINEAR_INTERPOLATOR : AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR;
        ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{0f, 1f});
        long v2 = arg5 ? 300 : 0xFA;
        v1.setDuration(v2);
        v1.setInterpolator(ReversableAnimatedValueInterpolator.of(arg5, v0));
        v1.addUpdateListener(MultiViewUpdateListener.alphaListener(new View[]{this.scrim}));
        return ((Animator)v1);
    }

    private Animator getSearchPrefixAnimator(boolean arg3) {
        return this.getTranslationAnimator(arg3, true, this.searchPrefix);
    }

    private AnimatorSet getTranslateAnimatorSet(boolean arg5) {
        AnimatorSet v0 = new AnimatorSet();
        v0.playTogether(new Animator[]{this.getTranslationYAnimator()});
        this.addBackButtonProgressAnimatorIfNeeded(v0);
        v0.setInterpolator(ReversableAnimatedValueInterpolator.of(arg5, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        long v4 = arg5 ? 350 : 300;
        v0.setDuration(v4);
        return v0;
    }

    private Animator getTranslationAnimator(boolean arg6, boolean arg7, View arg8) {
        int v7 = arg7 ? this.getFromTranslationXStart(arg8) : this.getFromTranslationXEnd(arg8);
        ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{((float)v7), 0f});
        v1.addUpdateListener(MultiViewUpdateListener.translationXListener(new View[]{arg8}));
        ValueAnimator v5 = ValueAnimator.ofFloat(new float[]{((float)this.getFromTranslationY()), 0f});
        v5.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{arg8}));
        AnimatorSet v8 = new AnimatorSet();
        v8.playTogether(new Animator[]{v1, v5});
        long v0 = arg6 ? 300 : 0xFA;
        v8.setDuration(v0);
        v8.setInterpolator(ReversableAnimatedValueInterpolator.of(arg6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        return ((Animator)v8);
    }

    private Animator getTranslationYAnimator() {
        ValueAnimator v1 = ValueAnimator.ofFloat(new float[]{((float)this.rootView.getHeight()), 0f});
        v1.addUpdateListener(MultiViewUpdateListener.translationYListener(new View[]{this.rootView}));
        return ((Animator)v1);
    }

    AnimatorSet hide() {
        if(this.searchBar != null) {
            return this.startHideAnimationCollapse();
        }

        return this.startHideAnimationTranslate();
    }

    static void lambda$addDrawerArrowDrawableAnimatorIfNeeded$3(DrawerArrowDrawable arg0, ValueAnimator arg1) {
        arg0.setProgress(arg1.getAnimatedValue().floatValue());
    }

    static void lambda$addFadeThroughDrawableAnimatorIfNeeded$4(FadeThroughDrawable arg0, ValueAnimator arg1) {
        arg0.setProgress(arg1.getAnimatedValue().floatValue());
    }

    void lambda$getRootViewAnimator$2$com-google-android-material-search-SearchViewAnimationHelper(float arg1, float arg2, Rect arg3, ValueAnimator arg4) {
        this.rootView.updateClipBoundsAndCornerRadius(arg3, AnimationUtils.lerp(arg1, arg2, arg4.getAnimatedFraction()));
    }

    void lambda$startShowAnimationExpand$0$com-google-android-material-search-SearchViewAnimationHelper() {
        AnimatorSet v0 = this.getExpandCollapseAnimatorSet(true);
        v0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                if(!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.requestFocusAndShowKeyboardIfNeeded();
                }

                SearchViewAnimationHelper.this.searchView.setTransitionState(TransitionState.SHOWN);
            }

            public void onAnimationStart(Animator arg2) {
                SearchViewAnimationHelper.this.rootView.setVisibility(0);
                SearchViewAnimationHelper.this.searchBar.stopOnLoadAnimation();
            }
        });
        v0.start();
    }

    void lambda$startShowAnimationTranslate$1$com-google-android-material-search-SearchViewAnimationHelper() {
        this.rootView.setTranslationY(((float)this.rootView.getHeight()));
        AnimatorSet v0 = this.getTranslateAnimatorSet(true);
        v0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg1) {
                if(!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.requestFocusAndShowKeyboardIfNeeded();
                }

                SearchViewAnimationHelper.this.searchView.setTransitionState(TransitionState.SHOWN);
            }

            public void onAnimationStart(Animator arg2) {
                SearchViewAnimationHelper.this.rootView.setVisibility(0);
                SearchViewAnimationHelper.this.searchView.setTransitionState(TransitionState.SHOWING);
            }
        });
        v0.start();
    }

    public BackEventCompat onHandleBackInvoked() {
        return this.backHelper.onHandleBackInvoked();
    }

    private void setActionMenuViewAlphaIfNeeded(float arg2) {
        if(this.searchView.isMenuItemsAnimated()) {
            ActionMenuView v1 = ToolbarUtils.getActionMenuView(this.toolbar);
            if(v1 != null) {
                v1.setAlpha(arg2);
            }
        }
    }

    private void setContentViewsAlpha(float arg2) {
        this.clearButton.setAlpha(arg2);
        this.divider.setAlpha(arg2);
        this.contentContainer.setAlpha(arg2);
        this.setActionMenuViewAlphaIfNeeded(arg2);
    }

    private void setFullDrawableProgressIfNeeded(Drawable arg2) {
        float v0 = 1f;
        if((arg2 instanceof DrawerArrowDrawable)) {
            arg2.setProgress(v0);
        }

        if((arg2 instanceof FadeThroughDrawable)) {
            ((FadeThroughDrawable)arg2).setProgress(v0);
        }
    }

    private void setMenuItemsNotClickable(Toolbar arg3) {
        ActionMenuView v2 = ToolbarUtils.getActionMenuView(arg3);
        if(v2 != null) {
            int v0;
            for(v0 = 0; v0 < v2.getChildCount(); ++v0) {
                View v1 = v2.getChildAt(v0);
                v1.setClickable(false);
                v1.setFocusable(false);
                v1.setFocusableInTouchMode(false);
            }
        }
    }

    void setSearchBar(SearchBar arg1) {
        this.searchBar = arg1;
    }

    private void setUpDummyToolbarIfNeeded() {
        Menu v0 = this.dummyToolbar.getMenu();
        if(v0 != null) {
            v0.clear();
        }

        if(this.searchBar.getMenuResId() != -1 && (this.searchView.isMenuItemsAnimated())) {
            this.dummyToolbar.inflateMenu(this.searchBar.getMenuResId());
            this.setMenuItemsNotClickable(this.dummyToolbar);
            this.dummyToolbar.setVisibility(0);
            return;
        }

        this.dummyToolbar.setVisibility(8);
    }

    void show() {
        if(this.searchBar != null) {
            this.startShowAnimationExpand();
            return;
        }

        this.startShowAnimationTranslate();
    }

    void startBackProgress(BackEventCompat arg2) {
        this.backHelper.startBackProgress(arg2, this.searchBar);
    }

    private AnimatorSet startHideAnimationCollapse() {
        if(this.searchView.isAdjustNothingSoftInputMode()) {
            this.searchView.clearFocusAndHideKeyboard();
        }

        AnimatorSet v0 = this.getExpandCollapseAnimatorSet(false);
        v0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg2) {
                SearchViewAnimationHelper.this.rootView.setVisibility(8);
                if(!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.clearFocusAndHideKeyboard();
                }

                SearchViewAnimationHelper.this.searchView.setTransitionState(TransitionState.HIDDEN);
            }

            public void onAnimationStart(Animator arg1) {
                SearchViewAnimationHelper.this.searchView.setTransitionState(TransitionState.HIDING);
            }
        });
        v0.start();
        return v0;
    }

    private AnimatorSet startHideAnimationTranslate() {
        if(this.searchView.isAdjustNothingSoftInputMode()) {
            this.searchView.clearFocusAndHideKeyboard();
        }

        AnimatorSet v0 = this.getTranslateAnimatorSet(false);
        v0.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator arg2) {
                SearchViewAnimationHelper.this.rootView.setVisibility(8);
                if(!SearchViewAnimationHelper.this.searchView.isAdjustNothingSoftInputMode()) {
                    SearchViewAnimationHelper.this.searchView.clearFocusAndHideKeyboard();
                }

                SearchViewAnimationHelper.this.searchView.setTransitionState(TransitionState.HIDDEN);
            }

            public void onAnimationStart(Animator arg1) {
                SearchViewAnimationHelper.this.searchView.setTransitionState(TransitionState.HIDING);
            }
        });
        v0.start();
        return v0;
    }

    private void startShowAnimationExpand() {
        if(this.searchView.isAdjustNothingSoftInputMode()) {
            this.searchView.requestFocusAndShowKeyboardIfNeeded();
        }

        this.searchView.setTransitionState(TransitionState.SHOWING);
        this.setUpDummyToolbarIfNeeded();
        this.editText.setText(this.searchBar.getText());
        this.editText.setSelection(this.editText.getText().length());
        this.rootView.setVisibility(4);
        this.rootView.post(new SearchViewAnimationHelper$$ExternalSyntheticLambda2(this));
    }

    private void startShowAnimationTranslate() {
        if(this.searchView.isAdjustNothingSoftInputMode()) {
            SearchView v0 = this.searchView;
            Objects.requireNonNull(v0);
            v0.postDelayed(new SearchViewAnimationHelper$$ExternalSyntheticLambda4(v0), 150);
        }

        this.rootView.setVisibility(4);
        this.rootView.post(new SearchViewAnimationHelper$$ExternalSyntheticLambda5(this));
    }

    public void updateBackProgress(BackEventCompat arg4) {
        AnimatorSet v0;
        if(arg4.getProgress() <= 0f) {
        }
        else {
            this.backHelper.updateBackProgress(arg4, this.searchBar, this.searchBar.getCornerSize());
            v0 = this.backProgressAnimatorSet;
            if(v0 == null) {
                if(this.searchView.isAdjustNothingSoftInputMode()) {
                    this.searchView.clearFocusAndHideKeyboard();
                }

                if(this.searchView.isAnimatedNavigationIcon()) {
                    goto label_19;
                }
            }
            else {
                goto label_26;
            }
        }

        return;
    label_19:
        AnimatorSet v4 = this.getButtonsProgressAnimator(false);
        this.backProgressAnimatorSet = v4;
        v4.start();
        this.backProgressAnimatorSet.pause();
        return;
    label_26:
        v0.setCurrentPlayTime(((long)(arg4.getProgress() * (((float)this.backProgressAnimatorSet.getDuration())))));
    }
}

