package com.google.android.material.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build$VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver$OnGlobalLayoutListener;
import androidx.activity.BackEventCompat;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import androidx.drawerlayout.widget.DrawerLayout$DrawerListener;
import androidx.drawerlayout.widget.DrawerLayout$LayoutParams;
import androidx.drawerlayout.widget.DrawerLayout$SimpleDrawerListener;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ContextUtils;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.internal.NavigationMenuPresenter;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.WindowUtils;
import com.google.android.material.motion.MaterialBackHandler;
import com.google.android.material.motion.MaterialBackOrchestrator;
import com.google.android.material.motion.MaterialSideContainerBackHelper;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel$Builder;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.ShapeableDelegate;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.Objects;

public class NavigationView extends ScrimInsetsFrameLayout implements MaterialBackHandler {
    class com.google.android.material.navigation.NavigationView$1 extends SimpleDrawerListener {
        com.google.android.material.navigation.NavigationView$1(NavigationView arg1) {
            NavigationView.this = arg1;
            super();
        }

        public void onDrawerClosed(View arg1) {
            NavigationView v0 = NavigationView.this;
            if(arg1 == (((View)v0))) {
                v0.backOrchestrator.stopListeningForBackCallbacks();
            }
        }

        public void onDrawerOpened(View arg2) {
            NavigationView v1 = NavigationView.this;
            if(arg2 == (((View)v1))) {
                MaterialBackOrchestrator v1_1 = v1.backOrchestrator;
                Objects.requireNonNull(v1_1);
                arg2.post(new NavigationView$1$$ExternalSyntheticLambda0(v1_1));
            }
        }
    }

    public interface OnNavigationItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem arg1);
    }

    public class SavedState extends AbsSavedState {
        class com.google.android.material.navigation.NavigationView$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.navigation.NavigationView$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return new SavedState(arg2, null);
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
        public Bundle menuState;

        static {
            SavedState.CREATOR = new com.google.android.material.navigation.NavigationView$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            this.menuState = arg1.readBundle(arg2);
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeBundle(this.menuState);
        }
    }

    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int PRESENTER_NAVIGATION_VIEW_ID = 1;
    private final DrawerListener backDrawerListener;
    private final MaterialBackOrchestrator backOrchestrator;
    private boolean bottomInsetScrimEnabled;
    private int drawerLayoutCornerSize;
    OnNavigationItemSelectedListener listener;
    private final int maxWidth;
    private final NavigationMenu menu;
    private MenuInflater menuInflater;
    private ViewTreeObserver$OnGlobalLayoutListener onGlobalLayoutListener;
    private final NavigationMenuPresenter presenter;
    private final ShapeableDelegate shapeableDelegate;
    private final MaterialSideContainerBackHelper sideContainerBackHelper;
    private final int[] tmpLocation;
    private boolean topInsetScrimEnabled;

    static {
        NavigationView.CHECKED_STATE_SET = new int[]{0x10100A0};
        NavigationView.DISABLED_STATE_SET = new int[]{0xFEFEFF62};
        NavigationView.DEF_STYLE_RES = style.Widget_Design_NavigationView;
    }

    public NavigationView(Context arg2) {
        this(arg2, null);
    }

    public NavigationView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.navigationViewStyle);
    }

    public NavigationView(Context arg17, AttributeSet arg18, int arg19) {
        int v8;
        NavigationView v0 = this;
        AttributeSet v2 = arg18;
        int v4 = arg19;
        int v5 = NavigationView.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg17, v2, v4, v5), v2, v4);
        NavigationMenuPresenter v7 = new NavigationMenuPresenter();
        v0.presenter = v7;
        v0.tmpLocation = new int[2];
        v0.topInsetScrimEnabled = true;
        v0.bottomInsetScrimEnabled = true;
        v0.drawerLayoutCornerSize = 0;
        v0.shapeableDelegate = ShapeableDelegate.create(((View)v0));
        v0.sideContainerBackHelper = new MaterialSideContainerBackHelper(((View)v0));
        v0.backOrchestrator = new MaterialBackOrchestrator(((View)v0));
        v0.backDrawerListener = new com.google.android.material.navigation.NavigationView$1(v0);
        Context v1 = v0.getContext();
        NavigationMenu v10 = new NavigationMenu(v1);
        v0.menu = v10;
        TintTypedArray v3 = ThemeEnforcement.obtainTintedStyledAttributes(v1, v2, styleable.NavigationView, v4, v5, new int[0]);
        if(v3.hasValue(styleable.NavigationView_android_background)) {
            ViewCompat.setBackground(((View)v0), v3.getDrawable(styleable.NavigationView_android_background));
        }

        v0.drawerLayoutCornerSize = v3.getDimensionPixelSize(styleable.NavigationView_drawerLayoutCornerSize, 0);
        Drawable v6 = v0.getBackground();
        ColorStateList v11 = DrawableUtils.getColorStateListOrNull(v6);
        if(v6 == null || v11 != null) {
            MaterialShapeDrawable v4_1 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(v1, v2, v4, v5).build());
            if(v11 != null) {
                v4_1.setFillColor(v11);
            }

            v4_1.initializeElevationOverlay(v1);
            ViewCompat.setBackground(((View)v0), ((Drawable)v4_1));
        }

        if(v3.hasValue(styleable.NavigationView_elevation)) {
            v0.setElevation(((float)v3.getDimensionPixelSize(styleable.NavigationView_elevation, 0)));
        }

        v0.setFitsSystemWindows(v3.getBoolean(styleable.NavigationView_android_fitsSystemWindows, false));
        v0.maxWidth = v3.getDimensionPixelSize(styleable.NavigationView_android_maxWidth, 0);
        ColorStateList v4_2 = null;
        ColorStateList v2_1 = v3.hasValue(styleable.NavigationView_subheaderColor) ? v3.getColorStateList(styleable.NavigationView_subheaderColor) : v4_2;
        v5 = v3.hasValue(styleable.NavigationView_subheaderTextAppearance) ? v3.getResourceId(styleable.NavigationView_subheaderTextAppearance, 0) : 0;
        int v6_1 = 0x1010038;
        if(v5 == 0 && v2_1 == null) {
            v2_1 = v0.createDefaultColorStateList(v6_1);
        }

        ColorStateList v6_2 = v3.hasValue(styleable.NavigationView_itemIconTint) ? v3.getColorStateList(styleable.NavigationView_itemIconTint) : v0.createDefaultColorStateList(v6_1);
        int v11_1 = v3.hasValue(styleable.NavigationView_itemTextAppearance) ? v3.getResourceId(styleable.NavigationView_itemTextAppearance, 0) : 0;
        boolean v12 = v3.getBoolean(styleable.NavigationView_itemTextAppearanceActiveBoldEnabled, true);
        if(v3.hasValue(styleable.NavigationView_itemIconSize)) {
            v0.setItemIconSize(v3.getDimensionPixelSize(styleable.NavigationView_itemIconSize, 0));
        }

        ColorStateList v13 = v3.hasValue(styleable.NavigationView_itemTextColor) ? v3.getColorStateList(styleable.NavigationView_itemTextColor) : v4_2;
        if(v11_1 == 0 && v13 == null) {
            v13 = v0.createDefaultColorStateList(0x1010036);
        }

        Drawable v14 = v3.getDrawable(styleable.NavigationView_itemBackground);
        if(v14 == null && (v0.hasShapeAppearance(v3))) {
            v14 = v0.createDefaultItemBackground(v3);
            ColorStateList v15 = MaterialResources.getColorStateList(v1, v3, styleable.NavigationView_itemRippleColor);
            if(v15 != null) {
                v7.setItemForeground(new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(v15), ((Drawable)v4_2), v0.createDefaultItemDrawable(v3, v4_2)));
            }
        }

        if(v3.hasValue(styleable.NavigationView_itemHorizontalPadding)) {
            v8 = 0;
            v0.setItemHorizontalPadding(v3.getDimensionPixelSize(styleable.NavigationView_itemHorizontalPadding, 0));
        }
        else {
            v8 = 0;
        }

        if(v3.hasValue(styleable.NavigationView_itemVerticalPadding)) {
            v0.setItemVerticalPadding(v3.getDimensionPixelSize(styleable.NavigationView_itemVerticalPadding, v8));
        }

        v0.setDividerInsetStart(v3.getDimensionPixelSize(styleable.NavigationView_dividerInsetStart, v8));
        v0.setDividerInsetEnd(v3.getDimensionPixelSize(styleable.NavigationView_dividerInsetEnd, v8));
        v0.setSubheaderInsetStart(v3.getDimensionPixelSize(styleable.NavigationView_subheaderInsetStart, v8));
        v0.setSubheaderInsetEnd(v3.getDimensionPixelSize(styleable.NavigationView_subheaderInsetEnd, v8));
        v0.setTopInsetScrimEnabled(v3.getBoolean(styleable.NavigationView_topInsetScrimEnabled, v0.topInsetScrimEnabled));
        v0.setBottomInsetScrimEnabled(v3.getBoolean(styleable.NavigationView_bottomInsetScrimEnabled, v0.bottomInsetScrimEnabled));
        v4 = v3.getDimensionPixelSize(styleable.NavigationView_itemIconPadding, v8);
        v0.setItemMaxLines(v3.getInt(styleable.NavigationView_itemMaxLines, 1));
        v10.setCallback(new Callback() {
            public boolean onMenuItemSelected(MenuBuilder arg1, MenuItem arg2) {
                if(NavigationView.this.listener != null && (NavigationView.this.listener.onNavigationItemSelected(arg2))) {
                    return 1;
                }

                return 0;
            }

            public void onMenuModeChange(MenuBuilder arg1) {
            }
        });
        v7.setId(1);
        v7.initForMenu(v1, ((MenuBuilder)v10));
        if(v5 != 0) {
            v7.setSubheaderTextAppearance(v5);
        }

        v7.setSubheaderColor(v2_1);
        v7.setItemIconTintList(v6_2);
        v7.setOverScrollMode(v0.getOverScrollMode());
        if(v11_1 != 0) {
            v7.setItemTextAppearance(v11_1);
        }

        v7.setItemTextAppearanceActiveBoldEnabled(v12);
        v7.setItemTextColor(v13);
        v7.setItemBackground(v14);
        v7.setItemIconPadding(v4);
        v10.addMenuPresenter(((MenuPresenter)v7));
        v0.addView(v7.getMenuView(((ViewGroup)v0)));
        if(v3.hasValue(styleable.NavigationView_menu)) {
            v8 = 0;
            v0.inflateMenu(v3.getResourceId(styleable.NavigationView_menu, 0));
        }
        else {
            v8 = 0;
        }

        if(v3.hasValue(styleable.NavigationView_headerLayout)) {
            v0.inflateHeaderView(v3.getResourceId(styleable.NavigationView_headerLayout, v8));
        }

        v3.recycle();
        v0.setupInsetScrimsListener();
    }

    static MaterialBackOrchestrator access$000(NavigationView arg0) {
        return arg0.backOrchestrator;
    }

    static int[] access$100(NavigationView arg0) {
        return arg0.tmpLocation;
    }

    static NavigationMenuPresenter access$200(NavigationView arg0) {
        return arg0.presenter;
    }

    public void addHeaderView(View arg1) {
        this.presenter.addHeaderView(arg1);
    }

    public void cancelBackProgress() {
        this.requireDrawerLayoutParent();
        this.sideContainerBackHelper.cancelBackProgress();
    }

    private ColorStateList createDefaultColorStateList(int arg6) {
        TypedValue v0 = new TypedValue();
        ColorStateList v1 = null;
        if(!this.getContext().getTheme().resolveAttribute(arg6, v0, true)) {
            return v1;
        }

        ColorStateList v6 = AppCompatResources.getColorStateList(this.getContext(), v0.resourceId);
        if(!this.getContext().getTheme().resolveAttribute(androidx.appcompat.R$attr.colorPrimary, v0, true)) {
            return v1;
        }

        int v5 = v0.data;
        int v0_1 = v6.getDefaultColor();
        return new ColorStateList(new int[][]{NavigationView.DISABLED_STATE_SET, NavigationView.CHECKED_STATE_SET, NavigationView.EMPTY_STATE_SET}, new int[]{v6.getColorForState(NavigationView.DISABLED_STATE_SET, v0_1), v5, v0_1});
    }

    private Drawable createDefaultItemBackground(TintTypedArray arg3) {
        return this.createDefaultItemDrawable(arg3, MaterialResources.getColorStateList(this.getContext(), arg3, styleable.NavigationView_itemShapeFillColor));
    }

    private Drawable createDefaultItemDrawable(TintTypedArray arg10, ColorStateList arg11) {
        MaterialShapeDrawable v4 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(this.getContext(), arg10.getResourceId(styleable.NavigationView_itemShapeAppearance, 0), arg10.getResourceId(styleable.NavigationView_itemShapeAppearanceOverlay, 0)).build());
        v4.setFillColor(arg11);
        return new InsetDrawable(((Drawable)v4), arg10.getDimensionPixelSize(styleable.NavigationView_itemShapeInsetStart, 0), arg10.getDimensionPixelSize(styleable.NavigationView_itemShapeInsetTop, 0), arg10.getDimensionPixelSize(styleable.NavigationView_itemShapeInsetEnd, 0), arg10.getDimensionPixelSize(styleable.NavigationView_itemShapeInsetBottom, 0));
    }

    protected void dispatchDraw(Canvas arg3) {
        this.shapeableDelegate.maybeClip(arg3, new NavigationView$$ExternalSyntheticLambda0(this));
    }

    MaterialSideContainerBackHelper getBackHelper() {
        return this.sideContainerBackHelper;
    }

    public MenuItem getCheckedItem() {
        return this.presenter.getCheckedItem();
    }

    public int getDividerInsetEnd() {
        return this.presenter.getDividerInsetEnd();
    }

    public int getDividerInsetStart() {
        return this.presenter.getDividerInsetStart();
    }

    public int getHeaderCount() {
        return this.presenter.getHeaderCount();
    }

    public View getHeaderView(int arg1) {
        return this.presenter.getHeaderView(arg1);
    }

    public Drawable getItemBackground() {
        return this.presenter.getItemBackground();
    }

    public int getItemHorizontalPadding() {
        return this.presenter.getItemHorizontalPadding();
    }

    public int getItemIconPadding() {
        return this.presenter.getItemIconPadding();
    }

    public ColorStateList getItemIconTintList() {
        return this.presenter.getItemTintList();
    }

    public int getItemMaxLines() {
        return this.presenter.getItemMaxLines();
    }

    public ColorStateList getItemTextColor() {
        return this.presenter.getItemTextColor();
    }

    public int getItemVerticalPadding() {
        return this.presenter.getItemVerticalPadding();
    }

    public Menu getMenu() {
        return this.menu;
    }

    private MenuInflater getMenuInflater() {
        if(this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(this.getContext());
        }

        return this.menuInflater;
    }

    public int getSubheaderInsetEnd() {
        return this.presenter.getSubheaderInsetEnd();
    }

    public int getSubheaderInsetStart() {
        return this.presenter.getSubheaderInsetStart();
    }

    public void handleBackInvoked() {
        Pair v0 = this.requireDrawerLayoutParent();
        Object v1 = v0.first;
        BackEventCompat v2 = this.sideContainerBackHelper.onHandleBackInvoked();
        if(v2 != null) {
            if(Build$VERSION.SDK_INT < 34) {
            }
            else {
                this.sideContainerBackHelper.finishBackProgress(v2, v0.second.gravity, DrawerLayoutUtils.getScrimCloseAnimatorListener(((DrawerLayout)v1), ((View)this)), DrawerLayoutUtils.getScrimCloseAnimatorUpdateListener(((DrawerLayout)v1)));
                return;
            }
        }

        ((DrawerLayout)v1).closeDrawer(((View)this));
    }

    private boolean hasShapeAppearance(TintTypedArray arg1) {
        if(!arg1.hasValue(styleable.NavigationView_itemShapeAppearance)) {
            if(arg1.hasValue(styleable.NavigationView_itemShapeAppearanceOverlay)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public View inflateHeaderView(int arg1) {
        return this.presenter.inflateHeaderView(arg1);
    }

    public void inflateMenu(int arg3) {
        this.presenter.setUpdateSuspended(true);
        this.getMenuInflater().inflate(arg3, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(false);
    }

    public boolean isBottomInsetScrimEnabled() {
        return this.bottomInsetScrimEnabled;
    }

    public boolean isTopInsetScrimEnabled() {
        return this.topInsetScrimEnabled;
    }

    void lambda$dispatchDraw$0$com-google-android-material-navigation-NavigationView(Canvas arg1) {
        super.dispatchDraw(arg1);
    }

    private void maybeUpdateCornerSizeForDrawerLayout(int arg6, int arg7) {
        if(((this.getParent() instanceof DrawerLayout)) && ((this.getLayoutParams() instanceof LayoutParams)) && this.drawerLayoutCornerSize > 0 && ((this.getBackground() instanceof MaterialShapeDrawable))) {
            int v0 = GravityCompat.getAbsoluteGravity(this.getLayoutParams().gravity, ViewCompat.getLayoutDirection(((View)this))) == 3 ? 1 : 0;
            Drawable v1 = this.getBackground();
            Builder v3 = ((MaterialShapeDrawable)v1).getShapeAppearanceModel().toBuilder().setAllCornerSizes(((float)this.drawerLayoutCornerSize));
            if(v0 != 0) {
                v3.setTopLeftCornerSize(0f);
                v3.setBottomLeftCornerSize(0f);
            }
            else {
                v3.setTopRightCornerSize(0f);
                v3.setBottomRightCornerSize(0f);
            }

            ShapeAppearanceModel v0_1 = v3.build();
            ((MaterialShapeDrawable)v1).setShapeAppearanceModel(v0_1);
            this.shapeableDelegate.onShapeAppearanceChanged(((View)this), v0_1);
            this.shapeableDelegate.onMaskChanged(((View)this), new RectF(0f, 0f, ((float)arg6), ((float)arg7)));
            this.shapeableDelegate.setOffsetZeroCornerEdgeBoundsEnabled(((View)this), true);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this));
        ViewParent v0 = this.getParent();
        if(((v0 instanceof DrawerLayout)) && (this.backOrchestrator.shouldListenForBackCallbacks())) {
            ((DrawerLayout)v0).removeDrawerListener(this.backDrawerListener);
            ((DrawerLayout)v0).addDrawerListener(this.backDrawerListener);
            if(((DrawerLayout)v0).isDrawerOpen(((View)this))) {
                this.backOrchestrator.startListeningForBackCallbacksWithPriorityOverlay();
            }
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.getViewTreeObserver().removeOnGlobalLayoutListener(this.onGlobalLayoutListener);
        ViewParent v0 = this.getParent();
        if((v0 instanceof DrawerLayout)) {
            ((DrawerLayout)v0).removeDrawerListener(this.backDrawerListener);
        }
    }

    protected void onInsetsChanged(WindowInsetsCompat arg1) {
        this.presenter.dispatchApplyWindowInsets(arg1);
    }

    protected void onMeasure(int arg4, int arg5) {
        int v0 = View$MeasureSpec.getMode(arg4);
        int v2 = 0x40000000;
        if(v0 == 0x80000000) {
            arg4 = View$MeasureSpec.makeMeasureSpec(Math.min(View$MeasureSpec.getSize(arg4), this.maxWidth), v2);
        }
        else if(v0 != 0) {
        }
        else {
            arg4 = View$MeasureSpec.makeMeasureSpec(this.maxWidth, v2);
        }

        super.onMeasure(arg4, arg5);
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.menu.restorePresenterStates(((SavedState)arg2).menuState);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.menuState = new Bundle();
        this.menu.savePresenterStates(v1.menuState);
        return ((Parcelable)v1);
    }

    protected void onSizeChanged(int arg1, int arg2, int arg3, int arg4) {
        super.onSizeChanged(arg1, arg2, arg3, arg4);
        this.maybeUpdateCornerSizeForDrawerLayout(arg1, arg2);
    }

    public void removeHeaderView(View arg1) {
        this.presenter.removeHeaderView(arg1);
    }

    private Pair requireDrawerLayoutParent() {
        ViewParent v0 = this.getParent();
        ViewGroup$LayoutParams v2 = this.getLayoutParams();
        if(((v0 instanceof DrawerLayout)) && ((v2 instanceof LayoutParams))) {
            return new Pair(v0, v2);
        }

        throw new IllegalStateException("NavigationView back progress requires the direct parent view to be a DrawerLayout.");
    }

    public void setBottomInsetScrimEnabled(boolean arg1) {
        this.bottomInsetScrimEnabled = arg1;
    }

    public void setCheckedItem(int arg2) {
        MenuItem v2 = this.menu.findItem(arg2);
        if(v2 != null) {
            this.presenter.setCheckedItem(((MenuItemImpl)v2));
        }
    }

    public void setCheckedItem(MenuItem arg2) {
        arg2 = this.menu.findItem(arg2.getItemId());
        if(arg2 != null) {
            this.presenter.setCheckedItem(((MenuItemImpl)arg2));
            return;
        }

        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }

    public void setDividerInsetEnd(int arg1) {
        this.presenter.setDividerInsetEnd(arg1);
    }

    public void setDividerInsetStart(int arg1) {
        this.presenter.setDividerInsetStart(arg1);
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        MaterialShapeUtils.setElevation(((View)this), arg1);
    }

    public void setForceCompatClippingEnabled(boolean arg2) {
        this.shapeableDelegate.setForceCompatClippingEnabled(((View)this), arg2);
    }

    public void setItemBackground(Drawable arg1) {
        this.presenter.setItemBackground(arg1);
    }

    public void setItemBackgroundResource(int arg2) {
        this.setItemBackground(ContextCompat.getDrawable(this.getContext(), arg2));
    }

    public void setItemHorizontalPadding(int arg1) {
        this.presenter.setItemHorizontalPadding(arg1);
    }

    public void setItemHorizontalPaddingResource(int arg2) {
        this.presenter.setItemHorizontalPadding(this.getResources().getDimensionPixelSize(arg2));
    }

    public void setItemIconPadding(int arg1) {
        this.presenter.setItemIconPadding(arg1);
    }

    public void setItemIconPaddingResource(int arg2) {
        this.presenter.setItemIconPadding(this.getResources().getDimensionPixelSize(arg2));
    }

    public void setItemIconSize(int arg1) {
        this.presenter.setItemIconSize(arg1);
    }

    public void setItemIconTintList(ColorStateList arg1) {
        this.presenter.setItemIconTintList(arg1);
    }

    public void setItemMaxLines(int arg1) {
        this.presenter.setItemMaxLines(arg1);
    }

    public void setItemTextAppearance(int arg1) {
        this.presenter.setItemTextAppearance(arg1);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean arg1) {
        this.presenter.setItemTextAppearanceActiveBoldEnabled(arg1);
    }

    public void setItemTextColor(ColorStateList arg1) {
        this.presenter.setItemTextColor(arg1);
    }

    public void setItemVerticalPadding(int arg1) {
        this.presenter.setItemVerticalPadding(arg1);
    }

    public void setItemVerticalPaddingResource(int arg2) {
        this.presenter.setItemVerticalPadding(this.getResources().getDimensionPixelSize(arg2));
    }

    public void setNavigationItemSelectedListener(OnNavigationItemSelectedListener arg1) {
        this.listener = arg1;
    }

    public void setOverScrollMode(int arg1) {
        super.setOverScrollMode(arg1);
        NavigationMenuPresenter v0 = this.presenter;
        if(v0 != null) {
            v0.setOverScrollMode(arg1);
        }
    }

    public void setSubheaderInsetEnd(int arg1) {
        this.presenter.setSubheaderInsetEnd(arg1);
    }

    public void setSubheaderInsetStart(int arg1) {
        this.presenter.setSubheaderInsetStart(arg1);
    }

    public void setTopInsetScrimEnabled(boolean arg1) {
        this.topInsetScrimEnabled = arg1;
    }

    private void setupInsetScrimsListener() {
        this.onGlobalLayoutListener = new ViewTreeObserver$OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                NavigationView.this.getLocationOnScreen(NavigationView.this.tmpLocation);
                boolean v1 = true;
                boolean v0 = NavigationView.this.tmpLocation[1] == 0 ? true : false;
                NavigationView.this.presenter.setBehindStatusBar(v0);
                NavigationView v3 = NavigationView.this;
                v0 = !v0 || !v3.isTopInsetScrimEnabled() ? false : true;
                v3.setDrawTopInsetForeground(v0);
                v0 = NavigationView.this.tmpLocation[0] == 0 || NavigationView.this.tmpLocation[0] + NavigationView.this.getWidth() == 0 ? true : false;
                NavigationView.this.setDrawLeftInsetForeground(v0);
                Activity v0_1 = ContextUtils.getActivity(NavigationView.this.getContext());
                if(v0_1 != null) {
                    Rect v3_1 = WindowUtils.getCurrentWindowBounds(((Context)v0_1));
                    int v4 = v3_1.height() - NavigationView.this.getHeight() == NavigationView.this.tmpLocation[1] ? 1 : 0;
                    int v0_2 = Color.alpha(v0_1.getWindow().getNavigationBarColor()) != 0 ? 1 : 0;
                    NavigationView v5 = NavigationView.this;
                    v0 = v4 == 0 || v0_2 == 0 || !v5.isBottomInsetScrimEnabled() ? false : true;
                    v5.setDrawBottomInsetForeground(v0);
                    if(v3_1.width() != NavigationView.this.tmpLocation[0]) {
                        if(v3_1.width() - NavigationView.this.getWidth() == NavigationView.this.tmpLocation[0]) {
                        }
                        else {
                            v1 = false;
                        }
                    }

                    NavigationView.this.setDrawRightInsetForeground(v1);
                }
            }
        };
        this.getViewTreeObserver().addOnGlobalLayoutListener(this.onGlobalLayoutListener);
    }

    public void startBackProgress(BackEventCompat arg1) {
        this.requireDrawerLayoutParent();
        this.sideContainerBackHelper.startBackProgress(arg1);
    }

    public void updateBackProgress(BackEventCompat arg2) {
        this.sideContainerBackHelper.updateBackProgress(arg2, this.requireDrawerLayoutParent().second.gravity);
    }
}

