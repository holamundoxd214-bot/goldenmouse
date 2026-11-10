package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View$OnTouchListener;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.view.SupportMenuInflater;
import androidx.appcompat.view.menu.MenuBuilder$Callback;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPresenter;
import androidx.appcompat.view.menu.MenuView;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public abstract class NavigationBarView extends FrameLayout {
    @Retention(value=RetentionPolicy.SOURCE) @public interface LabelVisibility {
    }

    public interface OnItemReselectedListener {
        void onNavigationItemReselected(MenuItem arg1);
    }

    public interface OnItemSelectedListener {
        boolean onNavigationItemSelected(MenuItem arg1);
    }

    class SavedState extends AbsSavedState {
        class com.google.android.material.navigation.NavigationBarView$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.navigation.NavigationBarView$SavedState$1() {
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
        Bundle menuPresenterState;

        static {
            SavedState.CREATOR = new com.google.android.material.navigation.NavigationBarView$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            if(arg2 == null) {
                arg2 = this.getClass().getClassLoader();
            }

            this.readFromParcel(arg1, arg2);
        }

        private void readFromParcel(Parcel arg1, ClassLoader arg2) {
            this.menuPresenterState = arg1.readBundle(arg2);
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeBundle(this.menuPresenterState);
        }
    }

    public static final int LABEL_VISIBILITY_AUTO = -1;
    public static final int LABEL_VISIBILITY_LABELED = 1;
    public static final int LABEL_VISIBILITY_SELECTED = 0;
    public static final int LABEL_VISIBILITY_UNLABELED = 2;
    private static final int MENU_PRESENTER_ID = 1;
    private final NavigationBarMenu menu;
    private MenuInflater menuInflater;
    private final NavigationBarMenuView menuView;
    private final NavigationBarPresenter presenter;
    private OnItemReselectedListener reselectedListener;
    private OnItemSelectedListener selectedListener;

    public NavigationBarView(Context arg8, AttributeSet arg9, int arg10, int arg11) {
        super(MaterialThemeOverlay.wrap(arg8, arg9, arg10, arg11), arg9, arg10);
        NavigationBarPresenter v8 = new NavigationBarPresenter();
        this.presenter = v8;
        Context v0 = this.getContext();
        AttributeSet v1 = arg9;
        int v3 = arg10;
        int v4 = arg11;
        TintTypedArray v9 = ThemeEnforcement.obtainTintedStyledAttributes(v0, v1, styleable.NavigationBarView, v3, v4, new int[]{styleable.NavigationBarView_itemTextAppearanceInactive, styleable.NavigationBarView_itemTextAppearanceActive});
        NavigationBarMenu v10 = new NavigationBarMenu(v0, this.getClass(), this.getMaxItemCount());
        this.menu = v10;
        NavigationBarMenuView v11 = this.createNavigationBarMenuView(v0);
        this.menuView = v11;
        v8.setMenuView(v11);
        v8.setId(1);
        v11.setPresenter(v8);
        v10.addMenuPresenter(((MenuPresenter)v8));
        v8.initForMenu(this.getContext(), ((MenuBuilder)v10));
        if(v9.hasValue(styleable.NavigationBarView_itemIconTint)) {
            v11.setIconTintList(v9.getColorStateList(styleable.NavigationBarView_itemIconTint));
        }
        else {
            v11.setIconTintList(v11.createDefaultColorStateList(0x1010038));
        }

        this.setItemIconSize(v9.getDimensionPixelSize(styleable.NavigationBarView_itemIconSize, this.getResources().getDimensionPixelSize(dimen.mtrl_navigation_bar_item_default_icon_size)));
        if(v9.hasValue(styleable.NavigationBarView_itemTextAppearanceInactive)) {
            this.setItemTextAppearanceInactive(v9.getResourceId(styleable.NavigationBarView_itemTextAppearanceInactive, 0));
        }

        if(v9.hasValue(styleable.NavigationBarView_itemTextAppearanceActive)) {
            this.setItemTextAppearanceActive(v9.getResourceId(styleable.NavigationBarView_itemTextAppearanceActive, 0));
        }

        this.setItemTextAppearanceActiveBoldEnabled(v9.getBoolean(styleable.NavigationBarView_itemTextAppearanceActiveBoldEnabled, true));
        if(v9.hasValue(styleable.NavigationBarView_itemTextColor)) {
            this.setItemTextColor(v9.getColorStateList(styleable.NavigationBarView_itemTextColor));
        }

        Drawable v8_1 = this.getBackground();
        ColorStateList v6 = DrawableUtils.getColorStateListOrNull(v8_1);
        if(v8_1 == null || v6 != null) {
            MaterialShapeDrawable v1_1 = new MaterialShapeDrawable(ShapeAppearanceModel.builder(v0, v1, v3, v4).build());
            if(v6 != null) {
                v1_1.setFillColor(v6);
            }

            v1_1.initializeElevationOverlay(v0);
            ViewCompat.setBackground(((View)this), ((Drawable)v1_1));
        }

        if(v9.hasValue(styleable.NavigationBarView_itemPaddingTop)) {
            this.setItemPaddingTop(v9.getDimensionPixelSize(styleable.NavigationBarView_itemPaddingTop, 0));
        }

        if(v9.hasValue(styleable.NavigationBarView_itemPaddingBottom)) {
            this.setItemPaddingBottom(v9.getDimensionPixelSize(styleable.NavigationBarView_itemPaddingBottom, 0));
        }

        if(v9.hasValue(styleable.NavigationBarView_activeIndicatorLabelPadding)) {
            this.setActiveIndicatorLabelPadding(v9.getDimensionPixelSize(styleable.NavigationBarView_activeIndicatorLabelPadding, 0));
        }

        if(v9.hasValue(styleable.NavigationBarView_elevation)) {
            this.setElevation(((float)v9.getDimensionPixelSize(styleable.NavigationBarView_elevation, 0)));
        }

        DrawableCompat.setTintList(this.getBackground().mutate(), MaterialResources.getColorStateList(v0, v9, styleable.NavigationBarView_backgroundTint));
        this.setLabelVisibilityMode(v9.getInteger(styleable.NavigationBarView_labelVisibilityMode, -1));
        int v8_2 = v9.getResourceId(styleable.NavigationBarView_itemBackground, 0);
        if(v8_2 != 0) {
            v11.setItemBackgroundRes(v8_2);
        }
        else {
            this.setItemRippleColor(MaterialResources.getColorStateList(v0, v9, styleable.NavigationBarView_itemRippleColor));
        }

        v8_2 = v9.getResourceId(styleable.NavigationBarView_itemActiveIndicatorStyle, 0);
        if(v8_2 != 0) {
            this.setItemActiveIndicatorEnabled(true);
            TypedArray v8_3 = v0.obtainStyledAttributes(v8_2, styleable.NavigationBarActiveIndicator);
            this.setItemActiveIndicatorWidth(v8_3.getDimensionPixelSize(styleable.NavigationBarActiveIndicator_android_width, 0));
            this.setItemActiveIndicatorHeight(v8_3.getDimensionPixelSize(styleable.NavigationBarActiveIndicator_android_height, 0));
            this.setItemActiveIndicatorMarginHorizontal(v8_3.getDimensionPixelOffset(styleable.NavigationBarActiveIndicator_marginHorizontal, 0));
            this.setItemActiveIndicatorColor(MaterialResources.getColorStateList(v0, v8_3, styleable.NavigationBarActiveIndicator_android_color));
            this.setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel.builder(v0, v8_3.getResourceId(styleable.NavigationBarActiveIndicator_shapeAppearance, 0), 0).build());
            v8_3.recycle();
        }

        if(v9.hasValue(styleable.NavigationBarView_menu)) {
            this.inflateMenu(v9.getResourceId(styleable.NavigationBarView_menu, 0));
        }

        v9.recycle();
        this.addView(((View)v11));
        v10.setCallback(new Callback() {
            public boolean onMenuItemSelected(MenuBuilder arg3, MenuItem arg4) {
                if(NavigationBarView.access$000(NavigationBarView.this) != null && arg4.getItemId() == NavigationBarView.this.getSelectedItemId()) {
                    NavigationBarView.access$000(NavigationBarView.this).onNavigationItemReselected(arg4);
                    return 1;
                }

                if(NavigationBarView.access$100(NavigationBarView.this) != null && !NavigationBarView.access$100(NavigationBarView.this).onNavigationItemSelected(arg4)) {
                    return 1;
                }

                return 0;
            }

            public void onMenuModeChange(MenuBuilder arg1) {
            }
        });
    }

    static OnItemReselectedListener access$000(NavigationBarView arg0) {
        return arg0.reselectedListener;
    }

    static OnItemSelectedListener access$100(NavigationBarView arg0) {
        return arg0.selectedListener;
    }

    protected abstract NavigationBarMenuView createNavigationBarMenuView(Context arg1);

    public int getActiveIndicatorLabelPadding() {
        return this.menuView.getActiveIndicatorLabelPadding();
    }

    public BadgeDrawable getBadge(int arg1) {
        return this.menuView.getBadge(arg1);
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.menuView.getItemActiveIndicatorColor();
    }

    public int getItemActiveIndicatorHeight() {
        return this.menuView.getItemActiveIndicatorHeight();
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.menuView.getItemActiveIndicatorMarginHorizontal();
    }

    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.menuView.getItemActiveIndicatorShapeAppearance();
    }

    public int getItemActiveIndicatorWidth() {
        return this.menuView.getItemActiveIndicatorWidth();
    }

    public Drawable getItemBackground() {
        return this.menuView.getItemBackground();
    }

    @Deprecated public int getItemBackgroundResource() {
        return this.menuView.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.menuView.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.menuView.getIconTintList();
    }

    public int getItemPaddingBottom() {
        return this.menuView.getItemPaddingBottom();
    }

    public int getItemPaddingTop() {
        return this.menuView.getItemPaddingTop();
    }

    public ColorStateList getItemRippleColor() {
        return this.menuView.getItemRippleColor();
    }

    public int getItemTextAppearanceActive() {
        return this.menuView.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.menuView.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.menuView.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.menuView.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.menu;
    }

    private MenuInflater getMenuInflater() {
        if(this.menuInflater == null) {
            this.menuInflater = new SupportMenuInflater(this.getContext());
        }

        return this.menuInflater;
    }

    public MenuView getMenuView() {
        return this.menuView;
    }

    public BadgeDrawable getOrCreateBadge(int arg1) {
        return this.menuView.getOrCreateBadge(arg1);
    }

    public NavigationBarPresenter getPresenter() {
        return this.presenter;
    }

    public int getSelectedItemId() {
        return this.menuView.getSelectedItemId();
    }

    public void inflateMenu(int arg4) {
        this.presenter.setUpdateSuspended(true);
        this.getMenuInflater().inflate(arg4, this.menu);
        this.presenter.setUpdateSuspended(false);
        this.presenter.updateMenuView(true);
    }

    public boolean isItemActiveIndicatorEnabled() {
        return this.menuView.getItemActiveIndicatorEnabled();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this));
    }

    protected void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.menu.restorePresenterStates(((SavedState)arg2).menuPresenterState);
    }

    protected Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.menuPresenterState = new Bundle();
        this.menu.savePresenterStates(v1.menuPresenterState);
        return ((Parcelable)v1);
    }

    public void removeBadge(int arg1) {
        this.menuView.removeBadge(arg1);
    }

    public void setActiveIndicatorLabelPadding(int arg1) {
        this.menuView.setActiveIndicatorLabelPadding(arg1);
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        MaterialShapeUtils.setElevation(((View)this), arg1);
    }

    public void setItemActiveIndicatorColor(ColorStateList arg1) {
        this.menuView.setItemActiveIndicatorColor(arg1);
    }

    public void setItemActiveIndicatorEnabled(boolean arg1) {
        this.menuView.setItemActiveIndicatorEnabled(arg1);
    }

    public void setItemActiveIndicatorHeight(int arg1) {
        this.menuView.setItemActiveIndicatorHeight(arg1);
    }

    public void setItemActiveIndicatorMarginHorizontal(int arg1) {
        this.menuView.setItemActiveIndicatorMarginHorizontal(arg1);
    }

    public void setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel arg1) {
        this.menuView.setItemActiveIndicatorShapeAppearance(arg1);
    }

    public void setItemActiveIndicatorWidth(int arg1) {
        this.menuView.setItemActiveIndicatorWidth(arg1);
    }

    public void setItemBackground(Drawable arg1) {
        this.menuView.setItemBackground(arg1);
    }

    public void setItemBackgroundResource(int arg1) {
        this.menuView.setItemBackgroundRes(arg1);
    }

    public void setItemIconSize(int arg1) {
        this.menuView.setItemIconSize(arg1);
    }

    public void setItemIconSizeRes(int arg2) {
        this.setItemIconSize(this.getResources().getDimensionPixelSize(arg2));
    }

    public void setItemIconTintList(ColorStateList arg1) {
        this.menuView.setIconTintList(arg1);
    }

    public void setItemOnTouchListener(int arg1, View$OnTouchListener arg2) {
        this.menuView.setItemOnTouchListener(arg1, arg2);
    }

    public void setItemPaddingBottom(int arg1) {
        this.menuView.setItemPaddingBottom(arg1);
    }

    public void setItemPaddingTop(int arg1) {
        this.menuView.setItemPaddingTop(arg1);
    }

    public void setItemRippleColor(ColorStateList arg1) {
        this.menuView.setItemRippleColor(arg1);
    }

    public void setItemTextAppearanceActive(int arg1) {
        this.menuView.setItemTextAppearanceActive(arg1);
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean arg1) {
        this.menuView.setItemTextAppearanceActiveBoldEnabled(arg1);
    }

    public void setItemTextAppearanceInactive(int arg1) {
        this.menuView.setItemTextAppearanceInactive(arg1);
    }

    public void setItemTextColor(ColorStateList arg1) {
        this.menuView.setItemTextColor(arg1);
    }

    public void setLabelVisibilityMode(int arg2) {
        if(this.menuView.getLabelVisibilityMode() != arg2) {
            this.menuView.setLabelVisibilityMode(arg2);
            this.presenter.updateMenuView(false);
        }
    }

    public void setOnItemReselectedListener(OnItemReselectedListener arg1) {
        this.reselectedListener = arg1;
    }

    public void setOnItemSelectedListener(OnItemSelectedListener arg1) {
        this.selectedListener = arg1;
    }

    public void setSelectedItemId(int arg3) {
        MenuItem v3 = this.menu.findItem(arg3);
        if(v3 != null && !this.menu.performItemAction(v3, this.presenter, 0)) {
            v3.setChecked(true);
        }
    }
}

