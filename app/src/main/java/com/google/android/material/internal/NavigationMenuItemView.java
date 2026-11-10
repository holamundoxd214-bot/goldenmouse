package com.google.android.material.internal;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable$ConstantState;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.view.menu.MenuItemImpl;
import androidx.appcompat.view.menu.MenuView$ItemView;
import androidx.appcompat.widget.LinearLayoutCompat$LayoutParams;
import androidx.appcompat.widget.TooltipCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;

public class NavigationMenuItemView extends ForegroundLinearLayout implements ItemView {
    class com.google.android.material.internal.NavigationMenuItemView$1 extends AccessibilityDelegateCompat {
        com.google.android.material.internal.NavigationMenuItemView$1(NavigationMenuItemView arg1) {
            NavigationMenuItemView.this = arg1;
            super();
        }

        public void onInitializeAccessibilityNodeInfo(View arg1, AccessibilityNodeInfoCompat arg2) {
            super.onInitializeAccessibilityNodeInfo(arg1, arg2);
            arg2.setCheckable(NavigationMenuItemView.this.checkable);
        }
    }

    private static final int[] CHECKED_STATE_SET;
    private final AccessibilityDelegateCompat accessibilityDelegate;
    private FrameLayout actionArea;
    boolean checkable;
    private Drawable emptyDrawable;
    private boolean hasIconTintList;
    private int iconSize;
    private ColorStateList iconTintList;
    boolean isBold;
    private MenuItemImpl itemData;
    private boolean needsEmptyIcon;
    private final CheckedTextView textView;

    static {
        NavigationMenuItemView.CHECKED_STATE_SET = new int[]{0x10100A0};
    }

    public NavigationMenuItemView(Context arg2) {
        this(arg2, null);
    }

    public NavigationMenuItemView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, 0);
    }

    public NavigationMenuItemView(Context arg3, AttributeSet arg4, int arg5) {
        super(arg3, arg4, arg5);
        this.isBold = true;
        com.google.android.material.internal.NavigationMenuItemView$1 v5 = new com.google.android.material.internal.NavigationMenuItemView$1(this);
        this.accessibilityDelegate = ((AccessibilityDelegateCompat)v5);
        this.setOrientation(0);
        LayoutInflater.from(arg3).inflate(layout.design_navigation_menu_item, ((ViewGroup)this), true);
        this.setIconSize(arg3.getResources().getDimensionPixelSize(dimen.design_navigation_icon_size));
        View v3 = this.findViewById(id.design_menu_item_text);
        this.textView = ((CheckedTextView)v3);
        ((CheckedTextView)v3).setDuplicateParentStateEnabled(true);
        ViewCompat.setAccessibilityDelegate(v3, ((AccessibilityDelegateCompat)v5));
    }

    private void adjustAppearance() {
        ViewGroup$LayoutParams v0_2;
        FrameLayout v0_1;
        boolean v0 = this.shouldExpandActionArea();
        CheckedTextView v1 = this.textView;
        if(v0) {
            v1.setVisibility(8);
            v0_1 = this.actionArea;
            if(v0_1 != null) {
                v0_2 = v0_1.getLayoutParams();
                ((LayoutParams)v0_2).width = -1;
                this.actionArea.setLayoutParams(v0_2);
                return;
            }
        }
        else {
            v1.setVisibility(0);
            v0_1 = this.actionArea;
            if(v0_1 != null) {
                v0_2 = v0_1.getLayoutParams();
                ((LayoutParams)v0_2).width = -2;
                this.actionArea.setLayoutParams(v0_2);
            }
        }
    }

    private StateListDrawable createDefaultBackground() {
        TypedValue v0 = new TypedValue();
        if(this.getContext().getTheme().resolveAttribute(attr.colorControlHighlight, v0, true)) {
            StateListDrawable v3 = new StateListDrawable();
            v3.addState(NavigationMenuItemView.CHECKED_STATE_SET, new ColorDrawable(v0.data));
            v3.addState(NavigationMenuItemView.EMPTY_STATE_SET, new ColorDrawable(0));
            return v3;
        }

        return null;
    }

    public MenuItemImpl getItemData() {
        return this.itemData;
    }

    public void initialize(MenuItemImpl arg1, int arg2) {
        this.itemData = arg1;
        if(arg1.getItemId() > 0) {
            this.setId(arg1.getItemId());
        }

        arg2 = arg1.isVisible() ? 0 : 8;
        this.setVisibility(arg2);
        if(this.getBackground() == null) {
            ViewCompat.setBackground(((View)this), this.createDefaultBackground());
        }

        this.setCheckable(arg1.isCheckable());
        this.setChecked(arg1.isChecked());
        this.setEnabled(arg1.isEnabled());
        this.setTitle(arg1.getTitle());
        this.setIcon(arg1.getIcon());
        this.setActionView(arg1.getActionView());
        this.setContentDescription(arg1.getContentDescription());
        TooltipCompat.setTooltipText(((View)this), arg1.getTooltipText());
        this.adjustAppearance();
    }

    public void initialize(MenuItemImpl arg1, boolean arg2) {
        this.isBold = arg2;
        this.initialize(arg1, 0);
    }

    protected int[] onCreateDrawableState(int arg2) {
        int[] v2 = super.onCreateDrawableState(arg2 + 1);
        MenuItemImpl v0 = this.itemData;
        if(v0 != null && (v0.isCheckable()) && (this.itemData.isChecked())) {
            NavigationMenuItemView.mergeDrawableStates(v2, NavigationMenuItemView.CHECKED_STATE_SET);
        }

        return v2;
    }

    public boolean prefersCondensedTitle() {
        return 0;
    }

    public void recycle() {
        FrameLayout v0 = this.actionArea;
        if(v0 != null) {
            v0.removeAllViews();
        }

        this.textView.setCompoundDrawables(null, null, null, null);
    }

    private void setActionView(View arg2) {
        if(arg2 != null) {
            FrameLayout v0 = this.actionArea;
            if(v0 == null) {
                View v0_1 = this.findViewById(id.design_menu_item_action_area_stub).inflate();
                this.actionArea = ((FrameLayout)v0_1);
            }

            v0.removeAllViews();
            this.actionArea.addView(arg2);
        }
    }

    public void setCheckable(boolean arg2) {
        this.refreshDrawableState();
        if(this.checkable != arg2) {
            this.checkable = arg2;
            this.accessibilityDelegate.sendAccessibilityEvent(this.textView, 0x800);
        }
    }

    public void setChecked(boolean arg3) {
        this.refreshDrawableState();
        this.textView.setChecked(arg3);
        CheckedTextView v0 = this.textView;
        Typeface v1 = v0.getTypeface();
        int v2 = !arg3 || !this.isBold ? 0 : 1;
        v0.setTypeface(v1, v2);
    }

    public void setHorizontalPadding(int arg3) {
        this.setPadding(arg3, this.getPaddingTop(), arg3, this.getPaddingBottom());
    }

    public void setIcon(Drawable arg4) {
        if(arg4 != null) {
            if(this.hasIconTintList) {
                Drawable$ConstantState v1 = arg4.getConstantState();
                if(v1 == null) {
                }
                else {
                    arg4 = v1.newDrawable();
                }

                arg4 = DrawableCompat.wrap(arg4).mutate();
                DrawableCompat.setTintList(arg4, this.iconTintList);
            }

            arg4.setBounds(0, 0, this.iconSize, this.iconSize);
        }
        else {
            if(!this.needsEmptyIcon) {
                goto label_29;
            }

            if(this.emptyDrawable == null) {
                arg4 = ResourcesCompat.getDrawable(this.getResources(), drawable.navigation_empty_icon, this.getContext().getTheme());
                this.emptyDrawable = arg4;
                if(arg4 != null) {
                    arg4.setBounds(0, 0, this.iconSize, this.iconSize);
                }
            }

            arg4 = this.emptyDrawable;
        }

    label_29:
        TextViewCompat.setCompoundDrawablesRelative(this.textView, arg4, null, null, null);
    }

    public void setIconPadding(int arg1) {
        this.textView.setCompoundDrawablePadding(arg1);
    }

    public void setIconSize(int arg1) {
        this.iconSize = arg1;
    }

    void setIconTintList(ColorStateList arg1) {
        this.iconTintList = arg1;
        boolean v1 = arg1 != null ? true : false;
        this.hasIconTintList = v1;
        MenuItemImpl v1_1 = this.itemData;
        if(v1_1 != null) {
            this.setIcon(v1_1.getIcon());
        }
    }

    public void setMaxLines(int arg1) {
        this.textView.setMaxLines(arg1);
    }

    public void setNeedsEmptyIcon(boolean arg1) {
        this.needsEmptyIcon = arg1;
    }

    public void setShortcut(boolean arg1, char arg2) {
    }

    public void setTextAppearance(int arg1) {
        TextViewCompat.setTextAppearance(this.textView, arg1);
    }

    public void setTextColor(ColorStateList arg1) {
        this.textView.setTextColor(arg1);
    }

    public void setTitle(CharSequence arg1) {
        this.textView.setText(arg1);
    }

    private boolean shouldExpandActionArea() {
        if(this.itemData.getTitle() == null && this.itemData.getIcon() == null && this.itemData.getActionView() != null) {
            return 1;
        }

        return 0;
    }

    public boolean showsIcon() {
        return 1;
    }
}

