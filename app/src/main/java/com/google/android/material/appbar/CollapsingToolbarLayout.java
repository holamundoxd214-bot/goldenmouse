package com.google.android.material.appbar;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region$Op;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.elevation.ElevationOverlayProvider;
import com.google.android.material.internal.CollapsingTextHelper;
import com.google.android.material.internal.DescendantOffsetUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CollapsingToolbarLayout extends FrameLayout {
    public class LayoutParams extends FrameLayout$LayoutParams {
        public static final int COLLAPSE_MODE_OFF = 0;
        public static final int COLLAPSE_MODE_PARALLAX = 2;
        public static final int COLLAPSE_MODE_PIN = 1;
        private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
        int collapseMode;
        float parallaxMult;

        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(Context arg4, AttributeSet arg5) {
            super(arg4, arg5);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            TypedArray v4 = arg4.obtainStyledAttributes(arg5, styleable.CollapsingToolbarLayout_Layout);
            this.collapseMode = v4.getInt(styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
            this.setParallaxMultiplier(v4.getFloat(styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f));
            v4.recycle();
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(int arg1, int arg2, int arg3) {
            super(arg1, arg2, arg3);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg1) {
            super(arg1);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(FrameLayout$LayoutParams arg1) {
            super(arg1);
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
        }

        public LayoutParams(LayoutParams arg2) {
            super(((FrameLayout$LayoutParams)arg2));
            this.collapseMode = 0;
            this.parallaxMult = 0.5f;
            this.collapseMode = arg2.collapseMode;
            this.parallaxMult = arg2.parallaxMult;
        }

        public int getCollapseMode() {
            return this.collapseMode;
        }

        public float getParallaxMultiplier() {
            return this.parallaxMult;
        }

        public void setCollapseMode(int arg1) {
            this.collapseMode = arg1;
        }

        public void setParallaxMultiplier(float arg1) {
            this.parallaxMult = arg1;
        }
    }

    class OffsetUpdateListener implements OnOffsetChangedListener {
        OffsetUpdateListener(CollapsingToolbarLayout arg1) {
            CollapsingToolbarLayout.this = arg1;
            super();
        }

        public void onOffsetChanged(AppBarLayout arg9, int arg10) {
            CollapsingToolbarLayout v3;
            CollapsingToolbarLayout.this.currentOffset = arg10;
            int v9 = CollapsingToolbarLayout.this.lastInsets != null ? CollapsingToolbarLayout.this.lastInsets.getSystemWindowInsetTop() : 0;
            int v1 = CollapsingToolbarLayout.this.getChildCount();
            int v2;
            for(v2 = 0; true; ++v2) {
                v3 = CollapsingToolbarLayout.this;
                if(v2 >= v1) {
                    break;
                }

                View v3_1 = v3.getChildAt(v2);
                ViewGroup$LayoutParams v4 = v3_1.getLayoutParams();
                ViewOffsetHelper v5 = CollapsingToolbarLayout.getViewOffsetHelper(v3_1);
                int v6 = ((LayoutParams)v4).collapseMode;
                if(v6 == 1) {
                    v5.setTopAndBottomOffset(MathUtils.clamp(-arg10, 0, CollapsingToolbarLayout.this.getMaxOffsetForPinChild(v3_1)));
                }
                else if(v6 != 2) {
                }
                else {
                    v5.setTopAndBottomOffset(Math.round((((float)(-arg10))) * ((LayoutParams)v4).parallaxMult));
                }
            }

            v3.updateScrimVisibility();
            if(CollapsingToolbarLayout.this.statusBarScrim != null && v9 > 0) {
                ViewCompat.postInvalidateOnAnimation(CollapsingToolbarLayout.this);
            }

            int v0 = CollapsingToolbarLayout.this.getHeight();
            v1 = v0 - ViewCompat.getMinimumHeight(CollapsingToolbarLayout.this) - v9;
            float v2_1 = ((float)v1);
            CollapsingToolbarLayout.this.collapsingTextHelper.setFadeModeStartFraction(Math.min(1f, (((float)(v0 - CollapsingToolbarLayout.this.getScrimVisibleHeightTrigger()))) / v2_1));
            CollapsingToolbarLayout.this.collapsingTextHelper.setCurrentOffsetY(CollapsingToolbarLayout.this.currentOffset + v1);
            CollapsingToolbarLayout.this.collapsingTextHelper.setExpansionFraction((((float)Math.abs(arg10))) / v2_1);
        }
    }

    public interface StaticLayoutBuilderConfigurer extends com.google.android.material.internal.StaticLayoutBuilderConfigurer {
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface TitleCollapseMode {
    }

    private static final int DEFAULT_SCRIM_ANIMATION_DURATION = 600;
    private static final int DEF_STYLE_RES = 0;
    public static final int TITLE_COLLAPSE_MODE_FADE = 1;
    public static final int TITLE_COLLAPSE_MODE_SCALE;
    final CollapsingTextHelper collapsingTextHelper;
    private boolean collapsingTitleEnabled;
    private Drawable contentScrim;
    int currentOffset;
    private boolean drawCollapsingTitle;
    private View dummyView;
    final ElevationOverlayProvider elevationOverlayProvider;
    private int expandedMarginBottom;
    private int expandedMarginEnd;
    private int expandedMarginStart;
    private int expandedMarginTop;
    private int extraMultilineHeight;
    private boolean extraMultilineHeightEnabled;
    private boolean forceApplySystemWindowInsetTop;
    WindowInsetsCompat lastInsets;
    private OnOffsetChangedListener onOffsetChangedListener;
    private boolean refreshToolbar;
    private int scrimAlpha;
    private long scrimAnimationDuration;
    private final TimeInterpolator scrimAnimationFadeInInterpolator;
    private final TimeInterpolator scrimAnimationFadeOutInterpolator;
    private ValueAnimator scrimAnimator;
    private int scrimVisibleHeightTrigger;
    private boolean scrimsAreShown;
    Drawable statusBarScrim;
    private int titleCollapseMode;
    private final Rect tmpRect;
    private ViewGroup toolbar;
    private View toolbarDirectChild;
    private int toolbarId;
    private int topInsetApplied;

    static {
        CollapsingToolbarLayout.DEF_STYLE_RES = style.Widget_Design_CollapsingToolbar;
    }

    public CollapsingToolbarLayout(Context arg2) {
        this(arg2, null);
    }

    public CollapsingToolbarLayout(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.collapsingToolbarLayoutStyle);
    }

    public CollapsingToolbarLayout(Context arg10, AttributeSet arg11, int arg12) {
        int v4 = CollapsingToolbarLayout.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg10, arg11, arg12, v4), arg11, arg12);
        this.refreshToolbar = true;
        this.tmpRect = new Rect();
        int v6 = -1;
        this.scrimVisibleHeightTrigger = v6;
        this.topInsetApplied = 0;
        this.extraMultilineHeight = 0;
        Context v0 = this.getContext();
        CollapsingTextHelper v8 = new CollapsingTextHelper(((View)this));
        this.collapsingTextHelper = v8;
        v8.setTextSizeInterpolator(AnimationUtils.DECELERATE_INTERPOLATOR);
        v8.setRtlTextDirectionHeuristicsEnabled(false);
        this.elevationOverlayProvider = new ElevationOverlayProvider(v0);
        TypedArray v11 = ThemeEnforcement.obtainStyledAttributes(v0, arg11, styleable.CollapsingToolbarLayout, arg12, v4, new int[0]);
        v8.setExpandedTextGravity(v11.getInt(styleable.CollapsingToolbarLayout_expandedTitleGravity, 0x800053));
        v8.setCollapsedTextGravity(v11.getInt(styleable.CollapsingToolbarLayout_collapsedTitleGravity, 0x800013));
        arg12 = v11.getDimensionPixelSize(styleable.CollapsingToolbarLayout_expandedTitleMargin, 0);
        this.expandedMarginBottom = arg12;
        this.expandedMarginEnd = arg12;
        this.expandedMarginTop = arg12;
        this.expandedMarginStart = arg12;
        if(v11.hasValue(styleable.CollapsingToolbarLayout_expandedTitleMarginStart)) {
            this.expandedMarginStart = v11.getDimensionPixelSize(styleable.CollapsingToolbarLayout_expandedTitleMarginStart, 0);
        }

        if(v11.hasValue(styleable.CollapsingToolbarLayout_expandedTitleMarginEnd)) {
            this.expandedMarginEnd = v11.getDimensionPixelSize(styleable.CollapsingToolbarLayout_expandedTitleMarginEnd, 0);
        }

        if(v11.hasValue(styleable.CollapsingToolbarLayout_expandedTitleMarginTop)) {
            this.expandedMarginTop = v11.getDimensionPixelSize(styleable.CollapsingToolbarLayout_expandedTitleMarginTop, 0);
        }

        if(v11.hasValue(styleable.CollapsingToolbarLayout_expandedTitleMarginBottom)) {
            this.expandedMarginBottom = v11.getDimensionPixelSize(styleable.CollapsingToolbarLayout_expandedTitleMarginBottom, 0);
        }

        this.collapsingTitleEnabled = v11.getBoolean(styleable.CollapsingToolbarLayout_titleEnabled, true);
        this.setTitle(v11.getText(styleable.CollapsingToolbarLayout_title));
        v8.setExpandedTextAppearance(style.TextAppearance_Design_CollapsingToolbar_Expanded);
        v8.setCollapsedTextAppearance(androidx.appcompat.R$style.TextAppearance_AppCompat_Widget_ActionBar_Title);
        if(v11.hasValue(styleable.CollapsingToolbarLayout_expandedTitleTextAppearance)) {
            v8.setExpandedTextAppearance(v11.getResourceId(styleable.CollapsingToolbarLayout_expandedTitleTextAppearance, 0));
        }

        if(v11.hasValue(styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance)) {
            v8.setCollapsedTextAppearance(v11.getResourceId(styleable.CollapsingToolbarLayout_collapsedTitleTextAppearance, 0));
        }

        if(v11.hasValue(styleable.CollapsingToolbarLayout_titleTextEllipsize)) {
            this.setTitleEllipsize(this.convertEllipsizeToTruncateAt(v11.getInt(styleable.CollapsingToolbarLayout_titleTextEllipsize, v6)));
        }

        if(v11.hasValue(styleable.CollapsingToolbarLayout_expandedTitleTextColor)) {
            v8.setExpandedTextColor(MaterialResources.getColorStateList(v0, v11, styleable.CollapsingToolbarLayout_expandedTitleTextColor));
        }

        if(v11.hasValue(styleable.CollapsingToolbarLayout_collapsedTitleTextColor)) {
            v8.setCollapsedTextColor(MaterialResources.getColorStateList(v0, v11, styleable.CollapsingToolbarLayout_collapsedTitleTextColor));
        }

        this.scrimVisibleHeightTrigger = v11.getDimensionPixelSize(styleable.CollapsingToolbarLayout_scrimVisibleHeightTrigger, v6);
        if(v11.hasValue(styleable.CollapsingToolbarLayout_maxLines)) {
            v8.setMaxLines(v11.getInt(styleable.CollapsingToolbarLayout_maxLines, 1));
        }

        if(v11.hasValue(styleable.CollapsingToolbarLayout_titlePositionInterpolator)) {
            v8.setPositionInterpolator(android.view.animation.AnimationUtils.loadInterpolator(v0, v11.getResourceId(styleable.CollapsingToolbarLayout_titlePositionInterpolator, 0)));
        }

        this.scrimAnimationDuration = ((long)v11.getInt(styleable.CollapsingToolbarLayout_scrimAnimationDuration, 600));
        this.scrimAnimationFadeInInterpolator = MotionUtils.resolveThemeInterpolator(v0, attr.motionEasingStandardInterpolator, AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR);
        this.scrimAnimationFadeOutInterpolator = MotionUtils.resolveThemeInterpolator(v0, attr.motionEasingStandardInterpolator, AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR);
        this.setContentScrim(v11.getDrawable(styleable.CollapsingToolbarLayout_contentScrim));
        this.setStatusBarScrim(v11.getDrawable(styleable.CollapsingToolbarLayout_statusBarScrim));
        this.setTitleCollapseMode(v11.getInt(styleable.CollapsingToolbarLayout_titleCollapseMode, 0));
        this.toolbarId = v11.getResourceId(styleable.CollapsingToolbarLayout_toolbarId, v6);
        this.forceApplySystemWindowInsetTop = v11.getBoolean(styleable.CollapsingToolbarLayout_forceApplySystemWindowInsetTop, false);
        this.extraMultilineHeightEnabled = v11.getBoolean(styleable.CollapsingToolbarLayout_extraMultilineHeightEnabled, false);
        v11.recycle();
        this.setWillNotDraw(false);
        ViewCompat.setOnApplyWindowInsetsListener(((View)this), new OnApplyWindowInsetsListener() {
            public WindowInsetsCompat onApplyWindowInsets(View arg1, WindowInsetsCompat arg2) {
                return CollapsingToolbarLayout.this.onWindowInsetChanged(arg2);
            }
        });
    }

    private void animateScrim(int arg4) {
        this.ensureToolbar();
        ValueAnimator v0 = this.scrimAnimator;
        if(v0 == null) {
            v0 = new ValueAnimator();
            this.scrimAnimator = v0;
            TimeInterpolator v1 = arg4 > this.scrimAlpha ? this.scrimAnimationFadeInInterpolator : this.scrimAnimationFadeOutInterpolator;
            v0.setInterpolator(v1);
            this.scrimAnimator.addUpdateListener(new ValueAnimator$AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator arg1) {
                    CollapsingToolbarLayout.this.setScrimAlpha(arg1.getAnimatedValue().intValue());
                }
            });
        }
        else {
            if(!v0.isRunning()) {
                goto label_21;
            }

            this.scrimAnimator.cancel();
        }

    label_21:
        this.scrimAnimator.setDuration(this.scrimAnimationDuration);
        this.scrimAnimator.setIntValues(new int[]{this.scrimAlpha, arg4});
        this.scrimAnimator.start();
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg1) {
        return arg1 instanceof LayoutParams;
    }

    private TextUtils$TruncateAt convertEllipsizeToTruncateAt(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 3) {
                    return TextUtils$TruncateAt.END;
                }

                return TextUtils$TruncateAt.MARQUEE;
            }

            return TextUtils$TruncateAt.MIDDLE;
        }

        return TextUtils$TruncateAt.START;
    }

    private void disableLiftOnScrollIfNeeded(AppBarLayout arg1) {
        if(this.isTitleCollapseFadeMode()) {
            arg1.setLiftOnScroll(false);
        }
    }

    public void draw(Canvas arg7) {
        int v0_1;
        super.draw(arg7);
        this.ensureToolbar();
        if(this.toolbar == null) {
            Drawable v0 = this.contentScrim;
            if(v0 != null && this.scrimAlpha > 0) {
                v0.mutate().setAlpha(this.scrimAlpha);
                this.contentScrim.draw(arg7);
            }
        }

        if((this.collapsingTitleEnabled) && (this.drawCollapsingTitle)) {
            if(this.toolbar != null && this.contentScrim != null && this.scrimAlpha > 0 && (this.isTitleCollapseFadeMode()) && this.collapsingTextHelper.getExpansionFraction() < this.collapsingTextHelper.getFadeModeThresholdFraction()) {
                v0_1 = arg7.save();
                arg7.clipRect(this.contentScrim.getBounds(), Region$Op.DIFFERENCE);
                this.collapsingTextHelper.draw(arg7);
                arg7.restoreToCount(v0_1);
                goto label_41;
            }

            this.collapsingTextHelper.draw(arg7);
        }

    label_41:
        if(this.statusBarScrim != null && this.scrimAlpha > 0) {
            WindowInsetsCompat v0_2 = this.lastInsets;
            v0_1 = v0_2 != null ? v0_2.getSystemWindowInsetTop() : 0;
            if(v0_1 <= 0) {
                return;
            }

            this.statusBarScrim.setBounds(0, -this.currentOffset, this.getWidth(), v0_1 - this.currentOffset);
            this.statusBarScrim.mutate().setAlpha(this.scrimAlpha);
            this.statusBarScrim.draw(arg7);
        }
    }

    protected boolean drawChild(Canvas arg6, View arg7, long arg8) {
        int v0;
        if(this.contentScrim == null || this.scrimAlpha <= 0 || !this.isToolbarChild(arg7)) {
            v0 = 0;
        }
        else {
            this.updateContentScrimBounds(this.contentScrim, arg7, this.getWidth(), this.getHeight());
            this.contentScrim.mutate().setAlpha(this.scrimAlpha);
            this.contentScrim.draw(arg6);
            v0 = 1;
        }

        if(!super.drawChild(arg6, arg7, arg8)) {
            if(v0 != 0) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    protected void drawableStateChanged() {
        boolean v1_1;
        int v1_2;
        super.drawableStateChanged();
        int[] v0 = this.getDrawableState();
        Drawable v1 = this.statusBarScrim;
        if(v1 == null || !v1.isStateful()) {
            v1_2 = 0;
        }
        else {
            v1_1 = v1.setState(v0);
        }

        Drawable v2 = this.contentScrim;
        if(v2 != null && (v2.isStateful())) {
            v1_2 = (((int)v1_1)) | v2.setState(v0);
        }

        CollapsingTextHelper v2_1 = this.collapsingTextHelper;
        if(v2_1 != null) {
            v1_2 = (((int)v1_1)) | v2_1.setState(v0);
        }

        if(v1_1) {
            this.invalidate();
        }
    }

    private void ensureToolbar() {
        if(!this.refreshToolbar) {
            return;
        }

        ViewGroup v0 = null;
        this.toolbar = v0;
        this.toolbarDirectChild = ((View)v0);
        int v1 = this.toolbarId;
        if(v1 != -1) {
            View v1_1 = this.findViewById(v1);
            this.toolbar = ((ViewGroup)v1_1);
            if(v1_1 != null) {
                this.toolbarDirectChild = this.findDirectChild(v1_1);
            }
        }

        if(this.toolbar == null) {
            v1 = this.getChildCount();
            int v3 = 0;
            while(v3 < v1) {
                View v4 = this.getChildAt(v3);
                if(CollapsingToolbarLayout.isToolbar(v4)) {
                    View v0_1 = v4;
                }
                else {
                    ++v3;
                    continue;
                }

                break;
            }

            this.toolbar = v0;
        }

        this.updateDummyView();
        this.refreshToolbar = false;
    }

    private View findDirectChild(View arg3) {
        ViewParent v3;
        ViewParent v0;
        for(v0 = arg3.getParent(); (((CollapsingToolbarLayout)v0)) != this; v0 = v0.getParent()) {
            if(v0 == null) {
                break;
            }

            if((v0 instanceof View)) {
                v3 = v0;
            }
        }

        return ((View)v3);
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-1, -1);
    }

    protected FrameLayout$LayoutParams generateDefaultLayoutParams() {
        return this.generateDefaultLayoutParams();
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg1) {
        return this.generateLayoutParams(arg1);
    }

    public FrameLayout$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return this.generateLayoutParams(arg1);
    }

    protected FrameLayout$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return new LayoutParams(arg1);
    }

    public int getCollapsedTitleGravity() {
        return this.collapsingTextHelper.getCollapsedTextGravity();
    }

    public float getCollapsedTitleTextSize() {
        return this.collapsingTextHelper.getCollapsedTextSize();
    }

    public Typeface getCollapsedTitleTypeface() {
        return this.collapsingTextHelper.getCollapsedTypeface();
    }

    public Drawable getContentScrim() {
        return this.contentScrim;
    }

    private int getDefaultContentScrimColorForTitleCollapseFadeMode() {
        ColorStateList v0 = MaterialColors.getColorStateListOrNull(this.getContext(), attr.colorSurfaceContainer);
        if(v0 != null) {
            return v0.getDefaultColor();
        }

        return this.elevationOverlayProvider.compositeOverlayWithThemeSurfaceColorIfNeeded(this.getResources().getDimension(dimen.design_appbar_elevation));
    }

    public int getExpandedTitleGravity() {
        return this.collapsingTextHelper.getExpandedTextGravity();
    }

    public int getExpandedTitleMarginBottom() {
        return this.expandedMarginBottom;
    }

    public int getExpandedTitleMarginEnd() {
        return this.expandedMarginEnd;
    }

    public int getExpandedTitleMarginStart() {
        return this.expandedMarginStart;
    }

    public int getExpandedTitleMarginTop() {
        return this.expandedMarginTop;
    }

    public float getExpandedTitleTextSize() {
        return this.collapsingTextHelper.getExpandedTextSize();
    }

    public Typeface getExpandedTitleTypeface() {
        return this.collapsingTextHelper.getExpandedTypeface();
    }

    private static int getHeightWithMargins(View arg2) {
        ViewGroup$LayoutParams v0 = arg2.getLayoutParams();
        if((v0 instanceof ViewGroup$MarginLayoutParams)) {
            return arg2.getMeasuredHeight() + ((ViewGroup$MarginLayoutParams)v0).topMargin + ((ViewGroup$MarginLayoutParams)v0).bottomMargin;
        }

        return arg2.getMeasuredHeight();
    }

    public int getHyphenationFrequency() {
        return this.collapsingTextHelper.getHyphenationFrequency();
    }

    public int getLineCount() {
        return this.collapsingTextHelper.getLineCount();
    }

    public float getLineSpacingAdd() {
        return this.collapsingTextHelper.getLineSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.collapsingTextHelper.getLineSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.collapsingTextHelper.getMaxLines();
    }

    final int getMaxOffsetForPinChild(View arg3) {
        return this.getHeight() - CollapsingToolbarLayout.getViewOffsetHelper(arg3).getLayoutTop() - arg3.getHeight() - arg3.getLayoutParams().bottomMargin;
    }

    int getScrimAlpha() {
        return this.scrimAlpha;
    }

    public long getScrimAnimationDuration() {
        return this.scrimAnimationDuration;
    }

    public int getScrimVisibleHeightTrigger() {
        int v0 = this.scrimVisibleHeightTrigger;
        if(v0 >= 0) {
            return v0 + this.topInsetApplied + this.extraMultilineHeight;
        }

        WindowInsetsCompat v0_1 = this.lastInsets;
        v0 = v0_1 != null ? v0_1.getSystemWindowInsetTop() : 0;
        int v1 = ViewCompat.getMinimumHeight(((View)this));
        if(v1 > 0) {
            return Math.min(v1 * 2 + v0, this.getHeight());
        }

        return this.getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.statusBarScrim;
    }

    public CharSequence getTitle() {
        if(this.collapsingTitleEnabled) {
            return this.collapsingTextHelper.getText();
        }

        return null;
    }

    public int getTitleCollapseMode() {
        return this.titleCollapseMode;
    }

    public TimeInterpolator getTitlePositionInterpolator() {
        return this.collapsingTextHelper.getPositionInterpolator();
    }

    public TextUtils$TruncateAt getTitleTextEllipsize() {
        return this.collapsingTextHelper.getTitleTextEllipsize();
    }

    private static CharSequence getToolbarTitle(View arg1) {
        if((arg1 instanceof Toolbar)) {
            return ((Toolbar)arg1).getTitle();
        }

        if((arg1 instanceof android.widget.Toolbar)) {
            return ((android.widget.Toolbar)arg1).getTitle();
        }

        return null;
    }

    static ViewOffsetHelper getViewOffsetHelper(View arg2) {
        Object v0 = arg2.getTag(id.view_offset_helper);
        if(v0 == null) {
            ViewOffsetHelper v0_1 = new ViewOffsetHelper(arg2);
            arg2.setTag(id.view_offset_helper, v0_1);
        }

        return ((ViewOffsetHelper)v0);
    }

    public boolean isExtraMultilineHeightEnabled() {
        return this.extraMultilineHeightEnabled;
    }

    public boolean isForceApplySystemWindowInsetTop() {
        return this.forceApplySystemWindowInsetTop;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.collapsingTextHelper.isRtlTextDirectionHeuristicsEnabled();
    }

    private boolean isTitleCollapseFadeMode() {
        if(this.titleCollapseMode == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isTitleEnabled() {
        return this.collapsingTitleEnabled;
    }

    private static boolean isToolbar(View arg1) {
        if(!(arg1 instanceof Toolbar)) {
            if((arg1 instanceof android.widget.Toolbar)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean isToolbarChild(View arg4) {
        View v0 = this.toolbarDirectChild;
        if(v0 != null) {
            if((((CollapsingToolbarLayout)v0)) == this) {
            }
            else if(arg4 == v0) {
                return 1;
            }
            else {
                return 0;
            }
        }

        if(arg4 == this.toolbar) {
            return 1;
        }

        return 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent v0 = this.getParent();
        if((v0 instanceof AppBarLayout)) {
            this.disableLiftOnScrollIfNeeded(((AppBarLayout)v0));
            ViewCompat.setFitsSystemWindows(((View)this), ViewCompat.getFitsSystemWindows(((View)v0)));
            if(this.onOffsetChangedListener == null) {
                this.onOffsetChangedListener = new OffsetUpdateListener(this);
            }

            ((AppBarLayout)v0).addOnOffsetChangedListener(this.onOffsetChangedListener);
            ViewCompat.requestApplyInsets(((View)this));
        }
    }

    protected void onConfigurationChanged(Configuration arg1) {
        super.onConfigurationChanged(arg1);
        this.collapsingTextHelper.maybeUpdateFontWeightAdjustment(arg1);
    }

    protected void onDetachedFromWindow() {
        ViewParent v0 = this.getParent();
        OnOffsetChangedListener v1 = this.onOffsetChangedListener;
        if(v1 != null && ((v0 instanceof AppBarLayout))) {
            ((AppBarLayout)v0).removeOnOffsetChangedListener(v1);
        }

        super.onDetachedFromWindow();
    }

    protected void onLayout(boolean arg6, int arg7, int arg8, int arg9, int arg10) {
        int v1;
        super.onLayout(arg6, arg7, arg8, arg9, arg10);
        int v6 = arg7;
        arg7 = arg8;
        arg8 = arg9;
        arg9 = arg10;
        WindowInsetsCompat v10 = this.lastInsets;
        int v0 = 0;
        if(v10 != null) {
            arg10 = v10.getSystemWindowInsetTop();
            v1 = this.getChildCount();
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                View v3 = this.getChildAt(v2);
                if(!ViewCompat.getFitsSystemWindows(v3) && v3.getTop() < arg10) {
                    ViewCompat.offsetTopAndBottom(v3, arg10);
                }
            }
        }

        arg10 = this.getChildCount();
        for(v1 = 0; v1 < arg10; ++v1) {
            CollapsingToolbarLayout.getViewOffsetHelper(this.getChildAt(v1)).onViewLayout();
        }

        this.updateTextBounds(v6, arg7, arg8, arg9, false);
        this.updateTitleFromToolbarIfNeeded();
        this.updateScrimVisibility();
        v6 = this.getChildCount();
        while(v0 < v6) {
            CollapsingToolbarLayout.getViewOffsetHelper(this.getChildAt(v0)).applyOffsets();
            ++v0;
        }
    }

    protected void onMeasure(int arg9, int arg10) {
        CollapsingToolbarLayout v2;
        this.ensureToolbar();
        super.onMeasure(arg9, arg10);
        arg10 = View$MeasureSpec.getMode(arg10);
        WindowInsetsCompat v0 = this.lastInsets;
        int v0_1 = v0 != null ? v0.getSystemWindowInsetTop() : 0;
        int v1 = 0x40000000;
        if((arg10 == 0 || (this.forceApplySystemWindowInsetTop)) && v0_1 > 0) {
            this.topInsetApplied = v0_1;
            super.onMeasure(arg9, View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight() + v0_1, v1));
        }

        if(!this.extraMultilineHeightEnabled || this.collapsingTextHelper.getMaxLines() <= 1) {
            v2 = this;
        }
        else {
            this.updateTitleFromToolbarIfNeeded();
            v2 = this;
            v2.updateTextBounds(0, 0, this.getMeasuredWidth(), this.getMeasuredHeight(), true);
            int v8 = v2.collapsingTextHelper.getExpandedLineCount();
            if(v8 > 1) {
                v2.extraMultilineHeight = Math.round(v2.collapsingTextHelper.getExpandedTextFullHeight()) * (v8 - 1);
                super.onMeasure(arg9, View$MeasureSpec.makeMeasureSpec(v2.getMeasuredHeight() + v2.extraMultilineHeight, v1));
            }
        }

        ViewGroup v8_1 = v2.toolbar;
        if(v8_1 != null) {
            View v9 = v2.toolbarDirectChild;
            if(v9 != null) {
                if((((CollapsingToolbarLayout)v9)) == v2) {
                }
                else {
                    v2.setMinimumHeight(CollapsingToolbarLayout.getHeightWithMargins(v9));
                    return;
                }
            }

            v2.setMinimumHeight(CollapsingToolbarLayout.getHeightWithMargins(((View)v8_1)));
        }
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        Drawable v3 = this.contentScrim;
        if(v3 != null) {
            this.updateContentScrimBounds(v3, arg1, arg2);
        }
    }

    WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat arg3) {
        Object v0_1;
        if(ViewCompat.getFitsSystemWindows(((View)this))) {
            WindowInsetsCompat v0 = arg3;
        }
        else {
            v0_1 = null;
        }

        if(!ObjectsCompat.equals(this.lastInsets, v0_1)) {
            this.lastInsets = ((WindowInsetsCompat)v0_1);
            this.requestLayout();
        }

        return arg3.consumeSystemWindowInsets();
    }

    public void setCollapsedTitleGravity(int arg1) {
        this.collapsingTextHelper.setCollapsedTextGravity(arg1);
    }

    public void setCollapsedTitleTextAppearance(int arg1) {
        this.collapsingTextHelper.setCollapsedTextAppearance(arg1);
    }

    public void setCollapsedTitleTextColor(int arg1) {
        this.setCollapsedTitleTextColor(ColorStateList.valueOf(arg1));
    }

    public void setCollapsedTitleTextColor(ColorStateList arg1) {
        this.collapsingTextHelper.setCollapsedTextColor(arg1);
    }

    public void setCollapsedTitleTextSize(float arg1) {
        this.collapsingTextHelper.setCollapsedTextSize(arg1);
    }

    public void setCollapsedTitleTypeface(Typeface arg1) {
        this.collapsingTextHelper.setCollapsedTypeface(arg1);
    }

    public void setContentScrim(Drawable arg3) {
        Drawable v0 = this.contentScrim;
        if(v0 != arg3) {
            Drawable$Callback v1 = null;
            if(v0 != null) {
                v0.setCallback(v1);
            }

            if(arg3 != null) {
                Drawable v1_1 = arg3.mutate();
            }

            this.contentScrim = ((Drawable)v1);
            if((((Drawable)v1)) != null) {
                this.updateContentScrimBounds(((Drawable)v1), this.getWidth(), this.getHeight());
                this.contentScrim.setCallback(((Drawable$Callback)this));
                this.contentScrim.setAlpha(this.scrimAlpha);
            }

            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    public void setContentScrimColor(int arg2) {
        this.setContentScrim(new ColorDrawable(arg2));
    }

    public void setContentScrimResource(int arg2) {
        this.setContentScrim(ContextCompat.getDrawable(this.getContext(), arg2));
    }

    public void setExpandedTitleColor(int arg1) {
        this.setExpandedTitleTextColor(ColorStateList.valueOf(arg1));
    }

    public void setExpandedTitleGravity(int arg1) {
        this.collapsingTextHelper.setExpandedTextGravity(arg1);
    }

    public void setExpandedTitleMargin(int arg1, int arg2, int arg3, int arg4) {
        this.expandedMarginStart = arg1;
        this.expandedMarginTop = arg2;
        this.expandedMarginEnd = arg3;
        this.expandedMarginBottom = arg4;
        this.requestLayout();
    }

    public void setExpandedTitleMarginBottom(int arg1) {
        this.expandedMarginBottom = arg1;
        this.requestLayout();
    }

    public void setExpandedTitleMarginEnd(int arg1) {
        this.expandedMarginEnd = arg1;
        this.requestLayout();
    }

    public void setExpandedTitleMarginStart(int arg1) {
        this.expandedMarginStart = arg1;
        this.requestLayout();
    }

    public void setExpandedTitleMarginTop(int arg1) {
        this.expandedMarginTop = arg1;
        this.requestLayout();
    }

    public void setExpandedTitleTextAppearance(int arg1) {
        this.collapsingTextHelper.setExpandedTextAppearance(arg1);
    }

    public void setExpandedTitleTextColor(ColorStateList arg1) {
        this.collapsingTextHelper.setExpandedTextColor(arg1);
    }

    public void setExpandedTitleTextSize(float arg1) {
        this.collapsingTextHelper.setExpandedTextSize(arg1);
    }

    public void setExpandedTitleTypeface(Typeface arg1) {
        this.collapsingTextHelper.setExpandedTypeface(arg1);
    }

    public void setExtraMultilineHeightEnabled(boolean arg1) {
        this.extraMultilineHeightEnabled = arg1;
    }

    public void setForceApplySystemWindowInsetTop(boolean arg1) {
        this.forceApplySystemWindowInsetTop = arg1;
    }

    public void setHyphenationFrequency(int arg1) {
        this.collapsingTextHelper.setHyphenationFrequency(arg1);
    }

    public void setLineSpacingAdd(float arg1) {
        this.collapsingTextHelper.setLineSpacingAdd(arg1);
    }

    public void setLineSpacingMultiplier(float arg1) {
        this.collapsingTextHelper.setLineSpacingMultiplier(arg1);
    }

    public void setMaxLines(int arg1) {
        this.collapsingTextHelper.setMaxLines(arg1);
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean arg1) {
        this.collapsingTextHelper.setRtlTextDirectionHeuristicsEnabled(arg1);
    }

    void setScrimAlpha(int arg2) {
        if(arg2 != this.scrimAlpha) {
            if(this.contentScrim != null) {
                ViewGroup v0 = this.toolbar;
                if(v0 != null) {
                    ViewCompat.postInvalidateOnAnimation(((View)v0));
                }
            }

            this.scrimAlpha = arg2;
            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    public void setScrimAnimationDuration(long arg1) {
        this.scrimAnimationDuration = arg1;
    }

    public void setScrimVisibleHeightTrigger(int arg2) {
        if(this.scrimVisibleHeightTrigger != arg2) {
            this.scrimVisibleHeightTrigger = arg2;
            this.updateScrimVisibility();
        }
    }

    public void setScrimsShown(boolean arg2) {
        boolean v0 = !ViewCompat.isLaidOut(((View)this)) || (this.isInEditMode()) ? false : true;
        this.setScrimsShown(arg2, v0);
    }

    public void setScrimsShown(boolean arg3, boolean arg4) {
        if(this.scrimsAreShown != arg3) {
            int v0 = 0xFF;
            if(arg4) {
                if(arg3) {
                }
                else {
                    v0 = 0;
                }

                this.animateScrim(v0);
            }
            else {
                if(arg3) {
                }
                else {
                    v0 = 0;
                }

                this.setScrimAlpha(v0);
            }

            this.scrimsAreShown = arg3;
        }
    }

    public void setStaticLayoutBuilderConfigurer(StaticLayoutBuilderConfigurer arg1) {
        this.collapsingTextHelper.setStaticLayoutBuilderConfigurer(((com.google.android.material.internal.StaticLayoutBuilderConfigurer)arg1));
    }

    public void setStatusBarScrim(Drawable arg3) {
        Drawable v1_1;
        Drawable v0 = this.statusBarScrim;
        if(v0 != arg3) {
            Drawable$Callback v1 = null;
            if(v0 != null) {
                v0.setCallback(v1);
            }

            if(arg3 != null) {
                v1_1 = arg3.mutate();
            }

            this.statusBarScrim = v1_1;
            if(v1_1 != null) {
                if(v1_1.isStateful()) {
                    this.statusBarScrim.setState(this.getDrawableState());
                }

                DrawableCompat.setLayoutDirection(this.statusBarScrim, ViewCompat.getLayoutDirection(((View)this)));
                arg3 = this.statusBarScrim;
                boolean v0_1 = this.getVisibility() == 0 ? true : false;
                arg3.setVisible(v0_1, false);
                this.statusBarScrim.setCallback(((Drawable$Callback)this));
                this.statusBarScrim.setAlpha(this.scrimAlpha);
            }

            ViewCompat.postInvalidateOnAnimation(((View)this));
        }
    }

    public void setStatusBarScrimColor(int arg2) {
        this.setStatusBarScrim(new ColorDrawable(arg2));
    }

    public void setStatusBarScrimResource(int arg2) {
        this.setStatusBarScrim(ContextCompat.getDrawable(this.getContext(), arg2));
    }

    public void setTitle(CharSequence arg2) {
        this.collapsingTextHelper.setText(arg2);
        this.updateContentDescriptionFromTitle();
    }

    public void setTitleCollapseMode(int arg3) {
        this.titleCollapseMode = arg3;
        boolean v3 = this.isTitleCollapseFadeMode();
        this.collapsingTextHelper.setFadeModeEnabled(v3);
        ViewParent v0 = this.getParent();
        if((v0 instanceof AppBarLayout)) {
            this.disableLiftOnScrollIfNeeded(((AppBarLayout)v0));
        }

        if((v3) && this.contentScrim == null) {
            this.setContentScrimColor(this.getDefaultContentScrimColorForTitleCollapseFadeMode());
        }
    }

    public void setTitleEllipsize(TextUtils$TruncateAt arg1) {
        this.collapsingTextHelper.setTitleTextEllipsize(arg1);
    }

    public void setTitleEnabled(boolean arg2) {
        if(arg2 != this.collapsingTitleEnabled) {
            this.collapsingTitleEnabled = arg2;
            this.updateContentDescriptionFromTitle();
            this.updateDummyView();
            this.requestLayout();
        }
    }

    public void setTitlePositionInterpolator(TimeInterpolator arg1) {
        this.collapsingTextHelper.setPositionInterpolator(arg1);
    }

    public void setVisibility(int arg3) {
        super.setVisibility(arg3);
        boolean v3 = arg3 == 0 ? true : false;
        Drawable v1 = this.statusBarScrim;
        if(v1 != null && v1.isVisible() != v3) {
            this.statusBarScrim.setVisible(v3, false);
        }

        v1 = this.contentScrim;
        if(v1 != null && v1.isVisible() != v3) {
            this.contentScrim.setVisible(v3, false);
        }
    }

    private void updateCollapsedBounds(boolean arg9) {
        int v1_1;
        int v4;
        int v3;
        int v2;
        View v0 = this.toolbarDirectChild;
        if(v0 != null) {
        }
        else {
            ViewGroup v0_1 = this.toolbar;
        }

        int v0_2 = this.getMaxOffsetForPinChild(v0);
        DescendantOffsetUtils.getDescendantRect(((ViewGroup)this), this.dummyView, this.tmpRect);
        ViewGroup v1 = this.toolbar;
        if((v1 instanceof Toolbar)) {
            v2 = ((Toolbar)v1).getTitleMarginStart();
            v3 = ((Toolbar)v1).getTitleMarginEnd();
            v4 = ((Toolbar)v1).getTitleMarginTop();
            v1_1 = ((Toolbar)v1).getTitleMarginBottom();
        }
        else {
            v1 = this.toolbar;
            if((v1 instanceof android.widget.Toolbar)) {
                v2 = ((android.widget.Toolbar)v1).getTitleMarginStart();
                v3 = ((android.widget.Toolbar)v1).getTitleMarginEnd();
                v4 = ((android.widget.Toolbar)v1).getTitleMarginTop();
                v1_1 = ((android.widget.Toolbar)v1).getTitleMarginBottom();
            }
            else {
                v2 = 0;
                v1_1 = 0;
                v3 = 0;
                v4 = 0;
            }
        }

        CollapsingTextHelper v5 = this.collapsingTextHelper;
        int v6 = this.tmpRect.left;
        int v7 = arg9 ? v3 : v2;
        v6 += v7;
        v7 = this.tmpRect.top + v0_2 + v4;
        v4 = this.tmpRect.right;
        if(arg9) {
        }
        else {
            v2 = v3;
        }

        v5.setCollapsedBounds(v6, v7, v4 - v2, this.tmpRect.bottom + v0_2 - v1_1);
    }

    private void updateContentDescriptionFromTitle() {
        this.setContentDescription(this.getTitle());
    }

    private void updateContentScrimBounds(Drawable arg2, int arg3, int arg4) {
        this.updateContentScrimBounds(arg2, this.toolbar, arg3, arg4);
    }

    private void updateContentScrimBounds(Drawable arg2, View arg3, int arg4, int arg5) {
        if((this.isTitleCollapseFadeMode()) && arg3 != null && (this.collapsingTitleEnabled)) {
            arg5 = arg3.getBottom();
        }

        arg2.setBounds(0, 0, arg4, arg5);
    }

    private void updateDummyView() {
        View v0;
        if(!this.collapsingTitleEnabled) {
            v0 = this.dummyView;
            if(v0 != null) {
                ViewParent v0_1 = v0.getParent();
                if((v0_1 instanceof ViewGroup)) {
                    ((ViewGroup)v0_1).removeView(this.dummyView);
                }
            }
        }

        if((this.collapsingTitleEnabled) && this.toolbar != null) {
            v0 = this.dummyView;
            if(v0 == null) {
                v0 = new View(this.getContext());
                this.dummyView = v0;
            }

            if(v0.getParent() != null) {
                return;
            }

            this.toolbar.addView(this.dummyView, -1, -1);
        }
    }

    final void updateScrimVisibility() {
        if(this.contentScrim == null) {
            if(this.statusBarScrim != null) {
            }
            else {
                return;
            }
        }

        boolean v0 = this.getHeight() + this.currentOffset < this.getScrimVisibleHeightTrigger() ? true : false;
        this.setScrimsShown(v0);
    }

    private void updateTextBounds(int arg6, int arg7, int arg8, int arg9, boolean arg10) {
        if(this.collapsingTitleEnabled) {
            View v0 = this.dummyView;
            if(v0 != null) {
                boolean v1 = false;
                boolean v0_1 = !ViewCompat.isAttachedToWindow(v0) || this.dummyView.getVisibility() != 0 ? false : true;
                this.drawCollapsingTitle = v0_1;
                if(!v0_1 && !arg10) {
                    return;
                }

                if(ViewCompat.getLayoutDirection(((View)this)) == 1) {
                    v1 = true;
                }

                this.updateCollapsedBounds(v1);
                CollapsingTextHelper v0_2 = this.collapsingTextHelper;
                int v2 = v1 ? this.expandedMarginEnd : this.expandedMarginStart;
                int v3 = this.tmpRect.top + this.expandedMarginTop;
                arg8 -= arg6;
                arg6 = v1 ? this.expandedMarginStart : this.expandedMarginEnd;
                v0_2.setExpandedBounds(v2, v3, arg8 - arg6, arg9 - arg7 - this.expandedMarginBottom);
                this.collapsingTextHelper.recalculate(arg10);
            }
        }
    }

    private void updateTitleFromToolbarIfNeeded() {
        if(this.toolbar != null && (this.collapsingTitleEnabled) && (TextUtils.isEmpty(this.collapsingTextHelper.getText()))) {
            this.setTitle(CollapsingToolbarLayout.getToolbarTitle(this.toolbar));
        }
    }

    protected boolean verifyDrawable(Drawable arg2) {
        if(!super.verifyDrawable(arg2) && arg2 != this.contentScrim) {
            if(arg2 == this.statusBarScrim) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }
}

