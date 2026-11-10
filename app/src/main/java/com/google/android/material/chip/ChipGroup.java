package com.google.android.material.chip;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewGroup$OnHierarchyChangeListener;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.CheckableGroup;
import com.google.android.material.internal.FlowLayout;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;
import java.util.Set;

public class ChipGroup extends FlowLayout {
    public class LayoutParams extends ViewGroup$MarginLayoutParams {
        public LayoutParams(int arg1, int arg2) {
            super(arg1, arg2);
        }

        public LayoutParams(Context arg1, AttributeSet arg2) {
            super(arg1, arg2);
        }

        public LayoutParams(ViewGroup$LayoutParams arg1) {
            super(arg1);
        }

        public LayoutParams(ViewGroup$MarginLayoutParams arg1) {
            super(arg1);
        }
    }

    @Deprecated public interface OnCheckedChangeListener {
        void onCheckedChanged(ChipGroup arg1, int arg2);
    }

    public interface OnCheckedStateChangeListener {
        void onCheckedChanged(ChipGroup arg1, List arg2);
    }

    class PassThroughHierarchyChangeListener implements ViewGroup$OnHierarchyChangeListener {
        private ViewGroup$OnHierarchyChangeListener onHierarchyChangeListener;

        PassThroughHierarchyChangeListener(ChipGroup arg1, com.google.android.material.chip.ChipGroup$1 arg2) {
            this(arg1);
        }

        private PassThroughHierarchyChangeListener(ChipGroup arg1) {
            ChipGroup.this = arg1;
            super();
        }

        static ViewGroup$OnHierarchyChangeListener access$302(PassThroughHierarchyChangeListener arg0, ViewGroup$OnHierarchyChangeListener arg1) {
            arg0.onHierarchyChangeListener = arg1;
            return arg1;
        }

        public void onChildViewAdded(View arg3, View arg4) {
            if(arg3 == ChipGroup.this && ((arg4 instanceof Chip))) {
                if(arg4.getId() == -1) {
                    arg4.setId(ViewCompat.generateViewId());
                }

                ChipGroup.this.checkableGroup.addCheckable(arg4);
            }

            ViewGroup$OnHierarchyChangeListener v2 = this.onHierarchyChangeListener;
            if(v2 != null) {
                v2.onChildViewAdded(arg3, arg4);
            }
        }

        public void onChildViewRemoved(View arg3, View arg4) {
            ChipGroup v0 = ChipGroup.this;
            if(arg3 == (((View)v0)) && ((arg4 instanceof Chip))) {
                v0.checkableGroup.removeCheckable(arg4);
            }

            ViewGroup$OnHierarchyChangeListener v2 = this.onHierarchyChangeListener;
            if(v2 != null) {
                v2.onChildViewRemoved(arg3, arg4);
            }
        }
    }

    private static final int DEF_STYLE_RES;
    private final CheckableGroup checkableGroup;
    private int chipSpacingHorizontal;
    private int chipSpacingVertical;
    private final int defaultCheckedId;
    private OnCheckedStateChangeListener onCheckedStateChangeListener;
    private final PassThroughHierarchyChangeListener passThroughListener;

    static {
        ChipGroup.DEF_STYLE_RES = style.Widget_MaterialComponents_ChipGroup;
    }

    public ChipGroup(Context arg2) {
        this(arg2, null);
    }

    public ChipGroup(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.chipGroupStyle);
    }

    public ChipGroup(Context arg9, AttributeSet arg10, int arg11) {
        int v4 = ChipGroup.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg9, arg10, arg11, v4), arg10, arg11);
        CheckableGroup v9 = new CheckableGroup();
        this.checkableGroup = v9;
        PassThroughHierarchyChangeListener v6 = new PassThroughHierarchyChangeListener(this, null);
        this.passThroughListener = v6;
        TypedArray v10 = ThemeEnforcement.obtainStyledAttributes(this.getContext(), arg10, styleable.ChipGroup, arg11, v4, new int[0]);
        arg11 = v10.getDimensionPixelOffset(styleable.ChipGroup_chipSpacing, 0);
        this.setChipSpacingHorizontal(v10.getDimensionPixelOffset(styleable.ChipGroup_chipSpacingHorizontal, arg11));
        this.setChipSpacingVertical(v10.getDimensionPixelOffset(styleable.ChipGroup_chipSpacingVertical, arg11));
        this.setSingleLine(v10.getBoolean(styleable.ChipGroup_singleLine, false));
        this.setSingleSelection(v10.getBoolean(styleable.ChipGroup_singleSelection, false));
        this.setSelectionRequired(v10.getBoolean(styleable.ChipGroup_selectionRequired, false));
        this.defaultCheckedId = v10.getResourceId(styleable.ChipGroup_checkedChip, -1);
        v10.recycle();
        v9.setOnCheckedStateChangeListener(new com.google.android.material.internal.CheckableGroup$OnCheckedStateChangeListener() {
            public void onCheckedStateChanged(Set arg3) {
                if(ChipGroup.access$100(ChipGroup.this) != null) {
                    ChipGroup.access$100(ChipGroup.this).onCheckedChanged(ChipGroup.this, ChipGroup.access$200(ChipGroup.this).getCheckedIdsSortedByChildOrder(ChipGroup.this));
                }
            }
        });
        super.setOnHierarchyChangeListener(((ViewGroup$OnHierarchyChangeListener)v6));
        ViewCompat.setImportantForAccessibility(((View)this), 1);
    }

    static OnCheckedStateChangeListener access$100(ChipGroup arg0) {
        return arg0.onCheckedStateChangeListener;
    }

    static CheckableGroup access$200(ChipGroup arg0) {
        return arg0.checkableGroup;
    }

    public void check(int arg1) {
        this.checkableGroup.check(arg1);
    }

    protected boolean checkLayoutParams(ViewGroup$LayoutParams arg1) {
        if((super.checkLayoutParams(arg1)) && ((arg1 instanceof LayoutParams))) {
            return 1;
        }

        return 0;
    }

    public void clearCheck() {
        this.checkableGroup.clearCheck();
    }

    protected ViewGroup$LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public ViewGroup$LayoutParams generateLayoutParams(AttributeSet arg2) {
        return new LayoutParams(this.getContext(), arg2);
    }

    protected ViewGroup$LayoutParams generateLayoutParams(ViewGroup$LayoutParams arg1) {
        return new LayoutParams(arg1);
    }

    public int getCheckedChipId() {
        return this.checkableGroup.getSingleCheckedId();
    }

    public List getCheckedChipIds() {
        return this.checkableGroup.getCheckedIdsSortedByChildOrder(((ViewGroup)this));
    }

    public int getChipSpacingHorizontal() {
        return this.chipSpacingHorizontal;
    }

    public int getChipSpacingVertical() {
        return this.chipSpacingVertical;
    }

    int getIndexOfChip(View arg6) {
        int v1 = -1;
        if(!(arg6 instanceof Chip)) {
            return v1;
        }

        int v0 = 0;
        int v2 = 0;
        while(v0 < this.getChildCount()) {
            View v3 = this.getChildAt(v0);
            if(((v3 instanceof Chip)) && (this.isChildVisible(v0))) {
                if(v3 == arg6) {
                    return v2;
                }
                else {
                    ++v2;
                }
            }

            ++v0;
        }

        return v1;
    }

    private int getVisibleChipCount() {
        int v0 = 0;
        int v1 = 0;
        while(v0 < this.getChildCount()) {
            if(((this.getChildAt(v0) instanceof Chip)) && (this.isChildVisible(v0))) {
                ++v1;
            }

            ++v0;
        }

        return v1;
    }

    private boolean isChildVisible(int arg1) {
        if(this.getChildAt(arg1).getVisibility() == 0) {
            return 1;
        }

        return 0;
    }

    public boolean isSelectionRequired() {
        return this.checkableGroup.isSelectionRequired();
    }

    public boolean isSingleLine() {
        return super.isSingleLine();
    }

    public boolean isSingleSelection() {
        return this.checkableGroup.isSingleSelection();
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        int v0 = this.defaultCheckedId;
        if(v0 != -1) {
            this.checkableGroup.check(v0);
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg4) {
        super.onInitializeAccessibilityNodeInfo(arg4);
        AccessibilityNodeInfoCompat v4 = AccessibilityNodeInfoCompat.wrap(arg4);
        int v0 = this.isSingleLine() ? this.getVisibleChipCount() : -1;
        int v1 = this.getRowCount();
        int v3 = this.isSingleSelection() ? 1 : 2;
        v4.setCollectionInfo(CollectionInfoCompat.obtain(v1, v0, false, v3));
    }

    public void setChipSpacing(int arg1) {
        this.setChipSpacingHorizontal(arg1);
        this.setChipSpacingVertical(arg1);
    }

    public void setChipSpacingHorizontal(int arg2) {
        if(this.chipSpacingHorizontal != arg2) {
            this.chipSpacingHorizontal = arg2;
            this.setItemSpacing(arg2);
            this.requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int arg2) {
        this.setChipSpacingHorizontal(this.getResources().getDimensionPixelOffset(arg2));
    }

    public void setChipSpacingResource(int arg2) {
        this.setChipSpacing(this.getResources().getDimensionPixelOffset(arg2));
    }

    public void setChipSpacingVertical(int arg2) {
        if(this.chipSpacingVertical != arg2) {
            this.chipSpacingVertical = arg2;
            this.setLineSpacing(arg2);
            this.requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int arg2) {
        this.setChipSpacingVertical(this.getResources().getDimensionPixelOffset(arg2));
    }

    @Deprecated public void setDividerDrawableHorizontal(Drawable arg1) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated public void setDividerDrawableVertical(Drawable arg1) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated public void setFlexWrap(int arg1) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    @Deprecated public void setOnCheckedChangeListener(OnCheckedChangeListener arg2) {
        if(arg2 == null) {
            this.setOnCheckedStateChangeListener(null);
            return;
        }

        this.setOnCheckedStateChangeListener(new OnCheckedStateChangeListener(arg2) {
            public void onCheckedChanged(ChipGroup arg1, List arg2) {
                if(!ChipGroup.this.checkableGroup.isSingleSelection()) {
                    return;
                }

                this.val$listener.onCheckedChanged(arg1, ChipGroup.this.getCheckedChipId());
            }
        });
    }

    public void setOnCheckedStateChangeListener(OnCheckedStateChangeListener arg1) {
        this.onCheckedStateChangeListener = arg1;
    }

    public void setOnHierarchyChangeListener(ViewGroup$OnHierarchyChangeListener arg1) {
        PassThroughHierarchyChangeListener.access$302(this.passThroughListener, arg1);
    }

    public void setSelectionRequired(boolean arg1) {
        this.checkableGroup.setSelectionRequired(arg1);
    }

    @Deprecated public void setShowDividerHorizontal(int arg1) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated public void setShowDividerVertical(int arg1) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    public void setSingleLine(boolean arg1) {
        super.setSingleLine(arg1);
    }

    public void setSingleLine(int arg2) {
        this.setSingleLine(this.getResources().getBoolean(arg2));
    }

    public void setSingleSelection(boolean arg1) {
        this.checkableGroup.setSingleSelection(arg1);
    }

    public void setSingleSelection(int arg2) {
        this.setSingleSelection(this.getResources().getBoolean(arg2));
    }
}

