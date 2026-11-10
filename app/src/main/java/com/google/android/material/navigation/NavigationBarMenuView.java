package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.MenuItem;
import android.view.View$OnClickListener;
import android.view.View$OnTouchListener;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView;
import androidx.core.util.Pools$Pool;
import androidx.core.util.Pools$SynchronizedPool;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.transition.AutoTransition;
import androidx.transition.Transition;
import androidx.transition.TransitionManager;
import androidx.transition.TransitionSet;
import com.google.android.material.R$attr;
import com.google.android.material.R$integer;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.internal.TextScale;
import com.google.android.material.motion.MotionUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.HashSet;

public abstract class NavigationBarMenuView extends ViewGroup implements MenuView {
    private static final int[] CHECKED_STATE_SET = null;
    private static final int[] DISABLED_STATE_SET = null;
    private static final int ITEM_POOL_SIZE = 5;
    private static final int NO_PADDING = -1;
    private final SparseArray badgeDrawables;
    private NavigationBarItemView[] buttons;
    private ColorStateList itemActiveIndicatorColor;
    private boolean itemActiveIndicatorEnabled;
    private int itemActiveIndicatorHeight;
    private int itemActiveIndicatorLabelPadding;
    private int itemActiveIndicatorMarginHorizontal;
    private boolean itemActiveIndicatorResizeable;
    private ShapeAppearanceModel itemActiveIndicatorShapeAppearance;
    private int itemActiveIndicatorWidth;
    private Drawable itemBackground;
    private int itemBackgroundRes;
    private int itemIconSize;
    private ColorStateList itemIconTint;
    private int itemPaddingBottom;
    private int itemPaddingTop;
    private final Pool itemPool;
    private ColorStateList itemRippleColor;
    private int itemTextAppearanceActive;
    private boolean itemTextAppearanceActiveBoldEnabled;
    private int itemTextAppearanceInactive;
    private final ColorStateList itemTextColorDefault;
    private ColorStateList itemTextColorFromUser;
    private int labelVisibilityMode;
    private MenuBuilder menu;
    private final View$OnClickListener onClickListener;
    private final SparseArray onTouchListeners;
    private NavigationBarPresenter presenter;
    private int selectedItemId;
    private int selectedItemPosition;
    private final TransitionSet set;

    static {
        NavigationBarMenuView.CHECKED_STATE_SET = new int[]{0x10100A0};
        NavigationBarMenuView.DISABLED_STATE_SET = new int[]{0xFEFEFF62};
    }

    public NavigationBarMenuView(Context arg5) {
        super(arg5);
        this.itemPool = new SynchronizedPool(5);
        this.onTouchListeners = new SparseArray(5);
        this.selectedItemId = 0;
        this.selectedItemPosition = 0;
        this.badgeDrawables = new SparseArray(5);
        this.itemPaddingTop = -1;
        this.itemPaddingBottom = -1;
        this.itemActiveIndicatorLabelPadding = -1;
        this.itemActiveIndicatorResizeable = false;
        this.itemTextColorDefault = this.createDefaultColorStateList(0x1010038);
        if(this.isInEditMode()) {
            this.set = null;
        }
        else {
            AutoTransition v0 = new AutoTransition();
            this.set = ((TransitionSet)v0);
            ((TransitionSet)v0).setOrdering(0);
            ((TransitionSet)v0).setDuration(((long)MotionUtils.resolveThemeDuration(this.getContext(), attr.motionDurationMedium4, this.getResources().getInteger(integer.material_motion_duration_long_1))));
            ((TransitionSet)v0).setInterpolator(MotionUtils.resolveThemeInterpolator(this.getContext(), attr.motionEasingStandard, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
            ((TransitionSet)v0).addTransition(new TextScale());
        }

        this.onClickListener = new View$OnClickListener() {
            public void onClick(View arg3) {
                MenuItemImpl v3 = ((NavigationBarItemView)arg3).getItemData();
                if(!NavigationBarMenuView.access$100(NavigationBarMenuView.this).performItemAction(((MenuItem)v3), NavigationBarMenuView.access$000(NavigationBarMenuView.this), 0)) {
                    ((MenuItem)v3).setChecked(true);
                }
            }
        };
        ViewCompat.setImportantForAccessibility(((View)this), 1);
    }

    static NavigationBarPresenter access$000(NavigationBarMenuView arg0) {
        return arg0.presenter;
    }

    static MenuBuilder access$100(NavigationBarMenuView arg0) {
        return arg0.menu;
    }

    public void buildMenuView() {
        int v2;
        this.removeAllViews();
        NavigationBarItemView[] v0 = this.buttons;
        if(v0 != null) {
            v2 = v0.length;
            int v3;
            for(v3 = 0; v3 < v2; ++v3) {
                NavigationBarItemView v4 = v0[v3];
                if(v4 != null) {
                    this.itemPool.release(v4);
                    v4.clear();
                }
            }
        }

        if(this.menu.size() == 0) {
            this.selectedItemId = 0;
            this.selectedItemPosition = 0;
            this.buttons = null;
            return;
        }

        this.removeUnusedBadges();
        this.buttons = new NavigationBarItemView[this.menu.size()];
        boolean v0_1 = this.isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
        for(v2 = 0; v2 < this.menu.size(); ++v2) {
            this.presenter.setUpdateSuspended(true);
            this.menu.getItem(v2).setCheckable(true);
            this.presenter.setUpdateSuspended(false);
            NavigationBarItemView v3_1 = this.getNewItem();
            this.buttons[v2] = v3_1;
            v3_1.setIconTintList(this.itemIconTint);
            v3_1.setIconSize(this.itemIconSize);
            v3_1.setTextColor(this.itemTextColorDefault);
            v3_1.setTextAppearanceInactive(this.itemTextAppearanceInactive);
            v3_1.setTextAppearanceActive(this.itemTextAppearanceActive);
            v3_1.setTextAppearanceActiveBoldEnabled(this.itemTextAppearanceActiveBoldEnabled);
            v3_1.setTextColor(this.itemTextColorFromUser);
            int v4_1 = this.itemPaddingTop;
            int v5 = -1;
            if(v4_1 != v5) {
                v3_1.setItemPaddingTop(v4_1);
            }

            v4_1 = this.itemPaddingBottom;
            if(v4_1 != v5) {
                v3_1.setItemPaddingBottom(v4_1);
            }

            v4_1 = this.itemActiveIndicatorLabelPadding;
            if(v4_1 != v5) {
                v3_1.setActiveIndicatorLabelPadding(v4_1);
            }

            v3_1.setActiveIndicatorWidth(this.itemActiveIndicatorWidth);
            v3_1.setActiveIndicatorHeight(this.itemActiveIndicatorHeight);
            v3_1.setActiveIndicatorMarginHorizontal(this.itemActiveIndicatorMarginHorizontal);
            v3_1.setActiveIndicatorDrawable(this.createItemActiveIndicatorDrawable());
            v3_1.setActiveIndicatorResizeable(this.itemActiveIndicatorResizeable);
            v3_1.setActiveIndicatorEnabled(this.itemActiveIndicatorEnabled);
            Drawable v4_2 = this.itemBackground;
            if(v4_2 != null) {
                v3_1.setItemBackground(v4_2);
            }
            else {
                v3_1.setItemBackground(this.itemBackgroundRes);
            }

            v3_1.setItemRippleColor(this.itemRippleColor);
            v3_1.setShifting(v0_1);
            v3_1.setLabelVisibilityMode(this.labelVisibilityMode);
            MenuItem v4_3 = this.menu.getItem(v2);
            v3_1.initialize(((MenuItemImpl)v4_3), 0);
            v3_1.setItemPosition(v2);
            v4_1 = ((MenuItemImpl)v4_3).getItemId();
            v3_1.setOnTouchListener(this.onTouchListeners.get(v4_1));
            v3_1.setOnClickListener(this.onClickListener);
            v5 = this.selectedItemId;
            if(v5 != 0 && v4_1 == v5) {
                this.selectedItemPosition = v2;
            }

            this.setBadgeIfNeeded(v3_1);
            this.addView(((View)v3_1));
        }

        int v0_2 = Math.min(this.menu.size() - 1, this.selectedItemPosition);
        this.selectedItemPosition = v0_2;
        this.menu.getItem(v0_2).setChecked(true);
    }

    public ColorStateList createDefaultColorStateList(int arg6) {
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
        return new ColorStateList(new int[][]{NavigationBarMenuView.DISABLED_STATE_SET, NavigationBarMenuView.CHECKED_STATE_SET, NavigationBarMenuView.EMPTY_STATE_SET}, new int[]{v6.getColorForState(NavigationBarMenuView.DISABLED_STATE_SET, v0_1), v5, v0_1});
    }

    private Drawable createItemActiveIndicatorDrawable() {
        if(this.itemActiveIndicatorShapeAppearance != null && this.itemActiveIndicatorColor != null) {
            MaterialShapeDrawable v0 = new MaterialShapeDrawable(this.itemActiveIndicatorShapeAppearance);
            v0.setFillColor(this.itemActiveIndicatorColor);
            return ((Drawable)v0);
        }

        return null;
    }

    protected abstract NavigationBarItemView createNavigationBarItemView(Context arg1);

    public NavigationBarItemView findItemView(int arg5) {
        this.validateMenuItemId(arg5);
        NavigationBarItemView[] v4 = this.buttons;
        if(v4 != null) {
            int v0 = v4.length;
            int v1 = 0;
            while(v1 < v0) {
                NavigationBarItemView v2 = v4[v1];
                if(v2.getId() == arg5) {
                    return v2;
                }
                else {
                    ++v1;
                    continue;
                }

                return null;
            }
        }

        return null;
    }

    public int getActiveIndicatorLabelPadding() {
        return this.itemActiveIndicatorLabelPadding;
    }

    public BadgeDrawable getBadge(int arg1) {
        return this.badgeDrawables.get(arg1);
    }

    SparseArray getBadgeDrawables() {
        return this.badgeDrawables;
    }

    public ColorStateList getIconTintList() {
        return this.itemIconTint;
    }

    public ColorStateList getItemActiveIndicatorColor() {
        return this.itemActiveIndicatorColor;
    }

    public boolean getItemActiveIndicatorEnabled() {
        return this.itemActiveIndicatorEnabled;
    }

    public int getItemActiveIndicatorHeight() {
        return this.itemActiveIndicatorHeight;
    }

    public int getItemActiveIndicatorMarginHorizontal() {
        return this.itemActiveIndicatorMarginHorizontal;
    }

    public ShapeAppearanceModel getItemActiveIndicatorShapeAppearance() {
        return this.itemActiveIndicatorShapeAppearance;
    }

    public int getItemActiveIndicatorWidth() {
        return this.itemActiveIndicatorWidth;
    }

    public Drawable getItemBackground() {
        NavigationBarItemView[] v0 = this.buttons;
        if(v0 != null && v0.length > 0) {
            return v0[0].getBackground();
        }

        return this.itemBackground;
    }

    @Deprecated public int getItemBackgroundRes() {
        return this.itemBackgroundRes;
    }

    public int getItemIconSize() {
        return this.itemIconSize;
    }

    public int getItemPaddingBottom() {
        return this.itemPaddingBottom;
    }

    public int getItemPaddingTop() {
        return this.itemPaddingTop;
    }

    public ColorStateList getItemRippleColor() {
        return this.itemRippleColor;
    }

    public int getItemTextAppearanceActive() {
        return this.itemTextAppearanceActive;
    }

    public int getItemTextAppearanceInactive() {
        return this.itemTextAppearanceInactive;
    }

    public ColorStateList getItemTextColor() {
        return this.itemTextColorFromUser;
    }

    public int getLabelVisibilityMode() {
        return this.labelVisibilityMode;
    }

    protected MenuBuilder getMenu() {
        return this.menu;
    }

    private NavigationBarItemView getNewItem() {
        Object v0 = this.itemPool.acquire();
        if(v0 == null) {
            return this.createNavigationBarItemView(this.getContext());
        }

        return ((NavigationBarItemView)v0);
    }

    BadgeDrawable getOrCreateBadge(int arg3) {
        this.validateMenuItemId(arg3);
        Object v0 = this.badgeDrawables.get(arg3);
        if(v0 == null) {
            BadgeDrawable v0_1 = BadgeDrawable.create(this.getContext());
            this.badgeDrawables.put(arg3, v0_1);
        }

        NavigationBarItemView v2 = this.findItemView(arg3);
        if(v2 != null) {
            v2.setBadge(((BadgeDrawable)v0));
        }

        return ((BadgeDrawable)v0);
    }

    public int getSelectedItemId() {
        return this.selectedItemId;
    }

    protected int getSelectedItemPosition() {
        return this.selectedItemPosition;
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void initialize(MenuBuilder arg1) {
        this.menu = arg1;
    }

    protected boolean isItemActiveIndicatorResizeable() {
        return this.itemActiveIndicatorResizeable;
    }

    protected boolean isShifting(int arg3, int arg4) {
        if(arg3 == -1) {
            if(arg4 > 3) {
                return 1;
            }

            return 0;
        }

        if(arg3 == 0) {
            return 1;
        }

        return 0;
    }

    private boolean isValidId(int arg1) {
        if(arg1 != -1) {
            return 1;
        }

        return 0;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg3) {
        super.onInitializeAccessibilityNodeInfo(arg3);
        AccessibilityNodeInfoCompat.wrap(arg3).setCollectionInfo(CollectionInfoCompat.obtain(1, this.menu.getVisibleItems().size(), false, 1));
    }

    void removeBadge(int arg2) {
        this.validateMenuItemId(arg2);
        NavigationBarItemView v0 = this.findItemView(arg2);
        if(v0 != null) {
            v0.removeBadge();
        }

        this.badgeDrawables.put(arg2, null);
    }

    private void removeUnusedBadges() {
        HashSet v0 = new HashSet();
        int v1 = 0;
        int v2;
        for(v2 = 0; v2 < this.menu.size(); ++v2) {
            v0.add(Integer.valueOf(this.menu.getItem(v2).getItemId()));
        }

        while(v1 < this.badgeDrawables.size()) {
            v2 = this.badgeDrawables.keyAt(v1);
            if(!v0.contains(Integer.valueOf(v2))) {
                this.badgeDrawables.delete(v2);
            }

            ++v1;
        }
    }

    void restoreBadgeDrawables(SparseArray arg6) {
        int v0 = 0;
        int v1;
        for(v1 = 0; v1 < arg6.size(); ++v1) {
            int v2 = arg6.keyAt(v1);
            if(this.badgeDrawables.indexOfKey(v2) < 0) {
                this.badgeDrawables.append(v2, arg6.get(v2));
            }
        }

        NavigationBarItemView[] v6 = this.buttons;
        if(v6 != null) {
            v1 = v6.length;
            while(v0 < v1) {
                NavigationBarItemView v2_1 = v6[v0];
                Object v3 = this.badgeDrawables.get(v2_1.getId());
                if(v3 != null) {
                    v2_1.setBadge(((BadgeDrawable)v3));
                }

                ++v0;
            }
        }
    }

    public void setActiveIndicatorLabelPadding(int arg4) {
        this.itemActiveIndicatorLabelPadding = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setActiveIndicatorLabelPadding(arg4);
            }
        }
    }

    private void setBadgeIfNeeded(NavigationBarItemView arg3) {
        int v0 = arg3.getId();
        if(!this.isValidId(v0)) {
        }
        else {
            Object v2 = this.badgeDrawables.get(v0);
            if(v2 != null) {
                arg3.setBadge(((BadgeDrawable)v2));
            }
        }
    }

    public void setIconTintList(ColorStateList arg4) {
        this.itemIconTint = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setIconTintList(arg4);
            }
        }
    }

    public void setItemActiveIndicatorColor(ColorStateList arg5) {
        this.itemActiveIndicatorColor = arg5;
        NavigationBarItemView[] v5 = this.buttons;
        if(v5 != null) {
            int v0 = v5.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v5[v1].setActiveIndicatorDrawable(this.createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorEnabled(boolean arg4) {
        this.itemActiveIndicatorEnabled = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setActiveIndicatorEnabled(arg4);
            }
        }
    }

    public void setItemActiveIndicatorHeight(int arg4) {
        this.itemActiveIndicatorHeight = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setActiveIndicatorHeight(arg4);
            }
        }
    }

    public void setItemActiveIndicatorMarginHorizontal(int arg4) {
        this.itemActiveIndicatorMarginHorizontal = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setActiveIndicatorMarginHorizontal(arg4);
            }
        }
    }

    protected void setItemActiveIndicatorResizeable(boolean arg4) {
        this.itemActiveIndicatorResizeable = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setActiveIndicatorResizeable(arg4);
            }
        }
    }

    public void setItemActiveIndicatorShapeAppearance(ShapeAppearanceModel arg5) {
        this.itemActiveIndicatorShapeAppearance = arg5;
        NavigationBarItemView[] v5 = this.buttons;
        if(v5 != null) {
            int v0 = v5.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v5[v1].setActiveIndicatorDrawable(this.createItemActiveIndicatorDrawable());
            }
        }
    }

    public void setItemActiveIndicatorWidth(int arg4) {
        this.itemActiveIndicatorWidth = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setActiveIndicatorWidth(arg4);
            }
        }
    }

    public void setItemBackground(Drawable arg4) {
        this.itemBackground = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setItemBackground(arg4);
            }
        }
    }

    public void setItemBackgroundRes(int arg4) {
        this.itemBackgroundRes = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setItemBackground(arg4);
            }
        }
    }

    public void setItemIconSize(int arg4) {
        this.itemIconSize = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setIconSize(arg4);
            }
        }
    }

    public void setItemOnTouchListener(int arg5, View$OnTouchListener arg6) {
        SparseArray v0 = this.onTouchListeners;
        if(arg6 == null) {
            v0.remove(arg5);
        }
        else {
            v0.put(arg5, arg6);
        }

        NavigationBarItemView[] v4 = this.buttons;
        if(v4 != null) {
            int v0_1 = v4.length;
            int v1;
            for(v1 = 0; v1 < v0_1; ++v1) {
                NavigationBarItemView v2 = v4[v1];
                if(v2.getItemData().getItemId() == arg5) {
                    v2.setOnTouchListener(arg6);
                }
            }
        }
    }

    public void setItemPaddingBottom(int arg4) {
        this.itemPaddingBottom = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setItemPaddingBottom(arg4);
            }
        }
    }

    public void setItemPaddingTop(int arg4) {
        this.itemPaddingTop = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setItemPaddingTop(arg4);
            }
        }
    }

    public void setItemRippleColor(ColorStateList arg4) {
        this.itemRippleColor = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setItemRippleColor(arg4);
            }
        }
    }

    public void setItemTextAppearanceActive(int arg6) {
        this.itemTextAppearanceActive = arg6;
        NavigationBarItemView[] v0 = this.buttons;
        if(v0 != null) {
            int v1 = v0.length;
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                NavigationBarItemView v3 = v0[v2];
                v3.setTextAppearanceActive(arg6);
                ColorStateList v4 = this.itemTextColorFromUser;
                if(v4 != null) {
                    v3.setTextColor(v4);
                }
            }
        }
    }

    public void setItemTextAppearanceActiveBoldEnabled(boolean arg4) {
        this.itemTextAppearanceActiveBoldEnabled = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setTextAppearanceActiveBoldEnabled(arg4);
            }
        }
    }

    public void setItemTextAppearanceInactive(int arg6) {
        this.itemTextAppearanceInactive = arg6;
        NavigationBarItemView[] v0 = this.buttons;
        if(v0 != null) {
            int v1 = v0.length;
            int v2;
            for(v2 = 0; v2 < v1; ++v2) {
                NavigationBarItemView v3 = v0[v2];
                v3.setTextAppearanceInactive(arg6);
                ColorStateList v4 = this.itemTextColorFromUser;
                if(v4 != null) {
                    v3.setTextColor(v4);
                }
            }
        }
    }

    public void setItemTextColor(ColorStateList arg4) {
        this.itemTextColorFromUser = arg4;
        NavigationBarItemView[] v3 = this.buttons;
        if(v3 != null) {
            int v0 = v3.length;
            int v1;
            for(v1 = 0; v1 < v0; ++v1) {
                v3[v1].setTextColor(arg4);
            }
        }
    }

    public void setLabelVisibilityMode(int arg1) {
        this.labelVisibilityMode = arg1;
    }

    public void setPresenter(NavigationBarPresenter arg1) {
        this.presenter = arg1;
    }

    void tryRestoreSelectedItemId(int arg5) {
        int v0 = this.menu.size();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            MenuItem v2 = this.menu.getItem(v1);
            if(arg5 == v2.getItemId()) {
                this.selectedItemId = arg5;
                this.selectedItemPosition = v1;
                v2.setChecked(true);
                return;
            }
        }
    }

    public void updateMenuView() {
        MenuBuilder v0 = this.menu;
        if(v0 != null) {
            if(this.buttons == null) {
            }
            else {
                int v0_1 = v0.size();
                if(v0_1 != this.buttons.length) {
                    this.buildMenuView();
                    return;
                }
                else {
                    int v1 = this.selectedItemId;
                    int v3;
                    for(v3 = 0; v3 < v0_1; ++v3) {
                        MenuItem v4 = this.menu.getItem(v3);
                        if(v4.isChecked()) {
                            this.selectedItemId = v4.getItemId();
                            this.selectedItemPosition = v3;
                        }
                    }

                    if(v1 != this.selectedItemId) {
                        TransitionSet v1_1 = this.set;
                        if(v1_1 != null) {
                            TransitionManager.beginDelayedTransition(((ViewGroup)this), ((Transition)v1_1));
                        }
                    }

                    boolean v1_2 = this.isShifting(this.labelVisibilityMode, this.menu.getVisibleItems().size());
                    for(v3 = 0; v3 < v0_1; ++v3) {
                        this.presenter.setUpdateSuspended(true);
                        this.buttons[v3].setLabelVisibilityMode(this.labelVisibilityMode);
                        this.buttons[v3].setShifting(v1_2);
                        this.buttons[v3].initialize(this.menu.getItem(v3), 0);
                        this.presenter.setUpdateSuspended(false);
                    }
                }
            }
        }
    }

    private void validateMenuItemId(int arg2) {
        if(this.isValidId(arg2)) {
            return;
        }

        throw new IllegalArgumentException(arg2 + " is not a valid view id");
    }
}

