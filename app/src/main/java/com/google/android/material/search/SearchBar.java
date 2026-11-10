package com.google.android.material.search;

import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View$OnAttachStateChangeListener;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityManagerCompat$TouchExplorationStateChangeListener;
import androidx.core.view.accessibility.AccessibilityManagerCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout$LayoutParams;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ToolbarUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class SearchBar extends Toolbar {
    public abstract class OnLoadAnimationCallback {
        public OnLoadAnimationCallback() {
            super();
        }

        public void onAnimationEnd() {
        }

        public void onAnimationStart() {
        }
    }

    class SavedState extends AbsSavedState {
        class com.google.android.material.search.SearchBar$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.search.SearchBar$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg1) {
                return new SavedState(arg1);
            }

            public SavedState createFromParcel(Parcel arg1, ClassLoader arg2) {
                return new SavedState(arg1, arg2);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public Object createFromParcel(Parcel arg1, ClassLoader arg2) {
                return this.createFromParcel(arg1, arg2);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        String text;

        static {
            SavedState.CREATOR = new com.google.android.material.search.SearchBar$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg2) {
            this(arg2, null);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.text = arg1.readString();
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeString(this.text);
        }
    }

    public class ScrollingViewBehavior extends com.google.android.material.appbar.AppBarLayout$ScrollingViewBehavior {
        private boolean initialized;

        public ScrollingViewBehavior() {
            super();
            this.initialized = false;
        }

        public ScrollingViewBehavior(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
            this.initialized = false;
        }

        public boolean onDependentViewChanged(CoordinatorLayout arg1, View arg2, View arg3) {
            boolean v1 = super.onDependentViewChanged(arg1, arg2, arg3);
            if(!this.initialized && ((arg3 instanceof AppBarLayout))) {
                this.initialized = true;
                this.setAppBarLayoutTransparent(((AppBarLayout)arg3));
            }

            return v1;
        }

        private void setAppBarLayoutTransparent(AppBarLayout arg1) {
            arg1.setBackgroundColor(0);
            arg1.setTargetElevation(0f);
        }

        protected boolean shouldHeaderOverlapScrollingChild() {
            return 1;
        }
    }

    private static final int DEFAULT_SCROLL_FLAGS = 53;
    private static final int DEF_STYLE_RES = 0;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private final AccessibilityManager accessibilityManager;
    private MaterialShapeDrawable backgroundShape;
    private View centerView;
    private final boolean defaultMarginsEnabled;
    private final Drawable defaultNavigationIcon;
    private boolean defaultScrollFlagsEnabled;
    private final boolean forceDefaultNavigationOnClickListener;
    private final boolean layoutInflated;
    private int menuResId;
    private Integer navigationIconTint;
    private Drawable originalNavigationIconBackground;
    private final SearchBarAnimationHelper searchBarAnimationHelper;
    private final TextView textView;
    private final boolean tintNavigationIcon;
    private final TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    static {
        SearchBar.DEF_STYLE_RES = style.Widget_Material3_SearchBar;
    }

    public SearchBar(Context arg2) {
        this(arg2, null);
    }

    public SearchBar(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.materialSearchBarStyle);
    }

    public SearchBar(Context arg14, AttributeSet arg15, int arg16) {
        int v4 = SearchBar.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg14, arg15, arg16, v4), arg15, arg16);
        int v14 = -1;
        this.menuResId = v14;
        this.touchExplorationStateChangeListener = new SearchBar$$ExternalSyntheticLambda1(this);
        Context v0 = this.getContext();
        this.validateAttributes(arg15);
        this.defaultNavigationIcon = AppCompatResources.getDrawable(v0, this.getDefaultNavigationIconResource());
        this.searchBarAnimationHelper = new SearchBarAnimationHelper();
        TypedArray v2 = ThemeEnforcement.obtainStyledAttributes(v0, arg15, styleable.SearchBar, arg16, v4, new int[0]);
        ShapeAppearanceModel v8 = ShapeAppearanceModel.builder(v0, arg15, arg16, v4).build();
        int v9 = v2.getColor(styleable.SearchBar_backgroundTint, 0);
        float v10 = v2.getDimension(styleable.SearchBar_elevation, 0f);
        this.defaultMarginsEnabled = v2.getBoolean(styleable.SearchBar_defaultMarginsEnabled, true);
        this.defaultScrollFlagsEnabled = v2.getBoolean(styleable.SearchBar_defaultScrollFlagsEnabled, true);
        boolean v1 = v2.getBoolean(styleable.SearchBar_hideNavigationIcon, false);
        this.forceDefaultNavigationOnClickListener = v2.getBoolean(styleable.SearchBar_forceDefaultNavigationOnClickListener, false);
        this.tintNavigationIcon = v2.getBoolean(styleable.SearchBar_tintNavigationIcon, true);
        if(v2.hasValue(styleable.SearchBar_navigationIconTint)) {
            this.navigationIconTint = Integer.valueOf(v2.getColor(styleable.SearchBar_navigationIconTint, v14));
        }

        v14 = v2.getResourceId(styleable.SearchBar_android_textAppearance, v14);
        String v4_1 = v2.getString(styleable.SearchBar_android_text);
        String v5 = v2.getString(styleable.SearchBar_android_hint);
        float v11 = v2.getDimension(styleable.SearchBar_strokeWidth, -1f);
        int v12 = v2.getColor(styleable.SearchBar_strokeColor, 0);
        v2.recycle();
        if(!v1) {
            this.initNavigationIcon();
        }

        this.setClickable(true);
        this.setFocusable(true);
        LayoutInflater.from(v0).inflate(layout.mtrl_search_bar, ((ViewGroup)this));
        this.layoutInflated = true;
        this.textView = this.findViewById(id.open_search_bar_text_view);
        ViewCompat.setElevation(((View)this), v10);
        this.initTextView(v14, v4_1, v5);
        this.initBackground(v8, v9, v10, v11, v12);
        this.accessibilityManager = this.getContext().getSystemService("accessibility");
        this.setupTouchExplorationStateChangeListener();
    }

    static AccessibilityManager access$000(SearchBar arg0) {
        return arg0.accessibilityManager;
    }

    static TouchExplorationStateChangeListener access$100(SearchBar arg0) {
        return arg0.touchExplorationStateChangeListener;
    }

    public void addCollapseAnimationListener(AnimatorListenerAdapter arg1) {
        this.searchBarAnimationHelper.addCollapseAnimationListener(arg1);
    }

    public void addExpandAnimationListener(AnimatorListenerAdapter arg1) {
        this.searchBarAnimationHelper.addExpandAnimationListener(arg1);
    }

    public void addOnLoadAnimationCallback(OnLoadAnimationCallback arg1) {
        this.searchBarAnimationHelper.addOnLoadAnimationCallback(arg1);
    }

    public void addView(View arg2, int arg3, ViewGroup$LayoutParams arg4) {
        if((this.layoutInflated) && this.centerView == null && !(arg2 instanceof ActionMenuView)) {
            this.centerView = arg2;
            arg2.setAlpha(0f);
        }

        super.addView(arg2, arg3, arg4);
    }

    public void clearText() {
        this.textView.setText("");
    }

    public boolean collapse(View arg2) {
        return this.collapse(arg2, null);
    }

    public boolean collapse(View arg2, AppBarLayout arg3) {
        return this.collapse(arg2, arg3, false);
    }

    public boolean collapse(View arg2, AppBarLayout arg3, boolean arg4) {
        if(arg2.getVisibility() == 0 && !this.isCollapsing() || (this.isExpanding())) {
            this.searchBarAnimationHelper.startCollapseAnimation(this, arg2, arg3, arg4);
            return 1;
        }

        return 0;
    }

    private int defaultIfZero(int arg1, int arg2) {
        if(arg1 == 0) {
            return arg2;
        }

        return arg1;
    }

    public boolean expand(View arg2) {
        return this.expand(arg2, null);
    }

    public boolean expand(View arg2, AppBarLayout arg3) {
        return this.expand(arg2, arg3, false);
    }

    public boolean expand(View arg2, AppBarLayout arg3, boolean arg4) {
        if(arg2.getVisibility() != 0 && !this.isExpanding() || (this.isCollapsing())) {
            this.searchBarAnimationHelper.startExpandAnimation(this, arg2, arg3, arg4);
            return 1;
        }

        return 0;
    }

    public View getCenterView() {
        return this.centerView;
    }

    private ColorStateList getCompatBackgroundColorStateList(int arg3, int arg4) {
        int[][] v2 = new int[][]{new int[]{0x10100A7}, new int[]{0x101009C}, new int[0]};
        arg4 = MaterialColors.layer(arg3, arg4);
        return new ColorStateList(v2, new int[]{arg4, arg4, arg3});
    }

    float getCompatElevation() {
        MaterialShapeDrawable v0 = this.backgroundShape;
        if(v0 != null) {
            return v0.getElevation();
        }

        return ViewCompat.getElevation(((View)this));
    }

    public float getCornerSize() {
        return this.backgroundShape.getTopLeftCornerResolvedSize();
    }

    protected int getDefaultMarginVerticalResource() {
        return dimen.m3_searchbar_margin_vertical;
    }

    protected int getDefaultNavigationIconResource() {
        return drawable.ic_search_black_24;
    }

    public CharSequence getHint() {
        return this.textView.getHint();
    }

    int getMenuResId() {
        return this.menuResId;
    }

    public int getStrokeColor() {
        return this.backgroundShape.getStrokeColor().getDefaultColor();
    }

    public float getStrokeWidth() {
        return this.backgroundShape.getStrokeWidth();
    }

    public CharSequence getText() {
        return this.textView.getText();
    }

    public TextView getTextView() {
        return this.textView;
    }

    public void inflateMenu(int arg4) {
        Menu v0 = this.getMenu();
        boolean v1 = v0 instanceof MenuBuilder;
        if(v1) {
            v0.stopDispatchingItemsChanged();
        }

        super.inflateMenu(arg4);
        this.menuResId = arg4;
        if(v1) {
            ((MenuBuilder)v0).startDispatchingItemsChanged();
        }
    }

    private void initBackground(ShapeAppearanceModel arg2, int arg3, float arg4, float arg5, int arg6) {
        MaterialShapeDrawable v0 = new MaterialShapeDrawable(arg2);
        this.backgroundShape = v0;
        v0.initializeElevationOverlay(this.getContext());
        this.backgroundShape.setElevation(arg4);
        if(arg5 >= 0f) {
            this.backgroundShape.setStroke(arg5, arg6);
        }

        int v2 = MaterialColors.getColor(((View)this), attr.colorControlHighlight);
        this.backgroundShape.setFillColor(ColorStateList.valueOf(arg3));
        ViewCompat.setBackground(((View)this), new RippleDrawable(ColorStateList.valueOf(v2), this.backgroundShape, this.backgroundShape));
    }

    private void initNavigationIcon() {
        Drawable v0 = this.getNavigationIcon() == null ? this.defaultNavigationIcon : this.getNavigationIcon();
        this.setNavigationIcon(v0);
        this.setNavigationIconDecorative(true);
    }

    private void initTextView(int arg2, String arg3, String arg4) {
        if(arg2 != -1) {
            TextViewCompat.setTextAppearance(this.textView, arg2);
        }

        this.setText(((CharSequence)arg3));
        this.setHint(((CharSequence)arg4));
        if(this.getNavigationIcon() == null) {
            MarginLayoutParamsCompat.setMarginStart(this.textView.getLayoutParams(), this.getResources().getDimensionPixelSize(dimen.m3_searchbar_text_margin_start_no_navigation_icon));
        }
    }

    public boolean isCollapsing() {
        return this.searchBarAnimationHelper.isCollapsing();
    }

    public boolean isDefaultScrollFlagsEnabled() {
        return this.defaultScrollFlagsEnabled;
    }

    public boolean isExpanding() {
        return this.searchBarAnimationHelper.isExpanding();
    }

    public boolean isOnLoadAnimationFadeInEnabled() {
        return this.searchBarAnimationHelper.isOnLoadAnimationFadeInEnabled();
    }

    void lambda$new$0$com-google-android-material-search-SearchBar(boolean arg1) {
        this.setFocusableInTouchMode(arg1);
    }

    void lambda$startOnLoadAnimation$1$com-google-android-material-search-SearchBar() {
        this.searchBarAnimationHelper.startOnLoadAnimation(this);
    }

    private void layoutCenterView() {
        View v0 = this.centerView;
        if(v0 == null) {
            return;
        }

        int v0_1 = v0.getMeasuredWidth();
        int v5 = this.getMeasuredWidth() / 2 - v0_1 / 2;
        int v7 = v5 + v0_1;
        v0_1 = this.centerView.getMeasuredHeight();
        int v6 = this.getMeasuredHeight() / 2 - v0_1 / 2;
        this.layoutChild(this.centerView, v5, v6, v7, v6 + v0_1);
    }

    private void layoutChild(View arg3, int arg4, int arg5, int arg6, int arg7) {
        if(ViewCompat.getLayoutDirection(((View)this)) == 1) {
            arg3.layout(this.getMeasuredWidth() - arg6, arg5, this.getMeasuredWidth() - arg4, arg7);
            return;
        }

        arg3.layout(arg4, arg5, arg6, arg7);
    }

    private Drawable maybeTintNavigationIcon(Drawable arg2) {
        int v1;
        if(this.tintNavigationIcon) {
            if(arg2 == null) {
            }
            else {
                Integer v0 = this.navigationIconTint;
                if(v0 != null) {
                    v1 = v0.intValue();
                }
                else {
                    int v0_1 = arg2 == this.defaultNavigationIcon ? attr.colorOnSurfaceVariant : attr.colorOnSurface;
                    v1 = MaterialColors.getColor(((View)this), v0_1);
                }

                arg2 = DrawableCompat.wrap(arg2.mutate());
                DrawableCompat.setTint(arg2, v1);
            }
        }

        return arg2;
    }

    private void measureCenterView(int arg1, int arg2) {
        View v0 = this.centerView;
        if(v0 != null) {
            v0.measure(arg1, arg2);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this), this.backgroundShape);
        this.setDefaultMargins();
        this.setOrClearDefaultScrollFlags();
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg4) {
        super.onInitializeAccessibilityNodeInfo(arg4);
        arg4.setClassName(EditText.class.getCanonicalName());
        arg4.setEditable(this.isEnabled());
        CharSequence v0 = this.getText();
        boolean v1 = TextUtils.isEmpty(v0);
        arg4.setHintText(this.getHint());
        arg4.setShowingHintText(v1);
        if(v1) {
            v0 = this.getHint();
        }

        arg4.setText(v0);
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        this.layoutCenterView();
    }

    protected void onMeasure(int arg1, int arg2) {
        super.onMeasure(arg1, arg2);
        this.measureCenterView(arg1, arg2);
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.setText(((SavedState)arg2).text);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v0 = new SavedState(super.onSaveInstanceState());
        CharSequence v2 = this.getText();
        String v2_1 = v2 == null ? null : v2.toString();
        v0.text = v2_1;
        return ((Parcelable)v0);
    }

    public boolean removeCollapseAnimationListener(AnimatorListenerAdapter arg1) {
        return this.searchBarAnimationHelper.removeCollapseAnimationListener(arg1);
    }

    public boolean removeExpandAnimationListener(AnimatorListenerAdapter arg1) {
        return this.searchBarAnimationHelper.removeExpandAnimationListener(arg1);
    }

    public boolean removeOnLoadAnimationCallback(OnLoadAnimationCallback arg1) {
        return this.searchBarAnimationHelper.removeOnLoadAnimationCallback(arg1);
    }

    public void setCenterView(View arg2) {
        View v0 = this.centerView;
        if(v0 != null) {
            this.removeView(v0);
            this.centerView = null;
        }

        if(arg2 != null) {
            this.addView(arg2);
        }
    }

    private void setDefaultMargins() {
        if((this.defaultMarginsEnabled) && ((this.getLayoutParams() instanceof ViewGroup$MarginLayoutParams))) {
            Resources v0 = this.getResources();
            int v1 = v0.getDimensionPixelSize(dimen.m3_searchbar_margin_horizontal);
            int v0_1 = v0.getDimensionPixelSize(this.getDefaultMarginVerticalResource());
            ViewGroup$LayoutParams v2 = this.getLayoutParams();
            ((ViewGroup$MarginLayoutParams)v2).leftMargin = this.defaultIfZero(((ViewGroup$MarginLayoutParams)v2).leftMargin, v1);
            ((ViewGroup$MarginLayoutParams)v2).topMargin = this.defaultIfZero(((ViewGroup$MarginLayoutParams)v2).topMargin, v0_1);
            ((ViewGroup$MarginLayoutParams)v2).rightMargin = this.defaultIfZero(((ViewGroup$MarginLayoutParams)v2).rightMargin, v1);
            ((ViewGroup$MarginLayoutParams)v2).bottomMargin = this.defaultIfZero(((ViewGroup$MarginLayoutParams)v2).bottomMargin, v0_1);
        }
    }

    public void setDefaultScrollFlagsEnabled(boolean arg1) {
        this.defaultScrollFlagsEnabled = arg1;
        this.setOrClearDefaultScrollFlags();
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        MaterialShapeDrawable v0 = this.backgroundShape;
        if(v0 != null) {
            v0.setElevation(arg1);
        }
    }

    public void setHint(CharSequence arg1) {
        this.textView.setHint(arg1);
    }

    public void setHint(int arg1) {
        this.textView.setHint(arg1);
    }

    public void setNavigationIcon(Drawable arg1) {
        super.setNavigationIcon(this.maybeTintNavigationIcon(arg1));
    }

    private void setNavigationIconDecorative(boolean arg3) {
        ImageButton v0 = ToolbarUtils.getNavigationIconButton(((Toolbar)this));
        if(v0 == null) {
            return;
        }

        v0.setClickable((((int)arg3)) ^ 1);
        v0.setFocusable((((int)arg3)) ^ 1);
        Drawable v1 = v0.getBackground();
        if(v1 != null) {
            this.originalNavigationIconBackground = v1;
        }

        Drawable v2 = arg3 ? null : this.originalNavigationIconBackground;
        v0.setBackgroundDrawable(v2);
    }

    public void setNavigationOnClickListener(View$OnClickListener arg2) {
        if(this.forceDefaultNavigationOnClickListener) {
            return;
        }

        super.setNavigationOnClickListener(arg2);
        boolean v2 = arg2 == null ? true : false;
        this.setNavigationIconDecorative(v2);
    }

    public void setOnLoadAnimationFadeInEnabled(boolean arg1) {
        this.searchBarAnimationHelper.setOnLoadAnimationFadeInEnabled(arg1);
    }

    private void setOrClearDefaultScrollFlags() {
        if((this.getLayoutParams() instanceof LayoutParams)) {
            ViewGroup$LayoutParams v0 = this.getLayoutParams();
            int v1 = 53;
            if(this.defaultScrollFlagsEnabled) {
                if(((LayoutParams)v0).getScrollFlags() == 0) {
                    ((LayoutParams)v0).setScrollFlags(v1);
                    return;
                }
            }
            else if(((LayoutParams)v0).getScrollFlags() == v1) {
                ((LayoutParams)v0).setScrollFlags(0);
            }
        }
    }

    public void setStrokeColor(int arg2) {
        if(this.getStrokeColor() != arg2) {
            this.backgroundShape.setStrokeColor(ColorStateList.valueOf(arg2));
        }
    }

    public void setStrokeWidth(float arg2) {
        if(this.getStrokeWidth() != arg2) {
            this.backgroundShape.setStrokeWidth(arg2);
        }
    }

    public void setSubtitle(CharSequence arg1) {
    }

    public void setText(CharSequence arg1) {
        this.textView.setText(arg1);
    }

    public void setText(int arg1) {
        this.textView.setText(arg1);
    }

    public void setTitle(CharSequence arg1) {
    }

    private void setupTouchExplorationStateChangeListener() {
        AccessibilityManager v0 = this.accessibilityManager;
        if(v0 != null) {
            if((v0.isEnabled()) && (this.accessibilityManager.isTouchExplorationEnabled())) {
                this.setFocusableInTouchMode(true);
            }

            this.addOnAttachStateChangeListener(new View$OnAttachStateChangeListener() {
                public void onViewAttachedToWindow(View arg1) {
                    AccessibilityManagerCompat.addTouchExplorationStateChangeListener(SearchBar.this.accessibilityManager, SearchBar.this.touchExplorationStateChangeListener);
                }

                public void onViewDetachedFromWindow(View arg1) {
                    AccessibilityManagerCompat.removeTouchExplorationStateChangeListener(SearchBar.this.accessibilityManager, SearchBar.this.touchExplorationStateChangeListener);
                }
            });
        }
    }

    public void startOnLoadAnimation() {
        this.post(new SearchBar$$ExternalSyntheticLambda0(this));
    }

    public void stopOnLoadAnimation() {
        this.searchBarAnimationHelper.stopOnLoadAnimation(this);
    }

    private void validateAttributes(AttributeSet arg2) {
        if(arg2 == null) {
        }
        else {
            String v0 = "http://schemas.android.com/apk/res-auto";
            if(arg2.getAttributeValue(v0, "title") == null) {
                if(arg2.getAttributeValue(v0, "subtitle") == null) {
                    return;
                }

                goto label_10;
            }
            else {
                goto label_14;
            }
        }

        return;
    label_10:
        throw new UnsupportedOperationException("SearchBar does not support subtitle. Use hint or text instead.");
    label_14:
        throw new UnsupportedOperationException("SearchBar does not support title. Use hint or text instead.");
    }
}

