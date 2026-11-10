package com.google.android.material.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextUtils$TruncateAt;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.ToggleButton;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.shape.AbsoluteCornerSize;
import com.google.android.material.shape.CornerSize;
import com.google.android.material.shape.ShapeAppearanceModel$Builder;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;

public class MaterialButtonToggleGroup extends LinearLayout {
    class com.google.android.material.button.MaterialButtonToggleGroup$1 implements Comparator {
        com.google.android.material.button.MaterialButtonToggleGroup$1(MaterialButtonToggleGroup arg1) {
            MaterialButtonToggleGroup.this = arg1;
            super();
        }

        public int compare(MaterialButton arg3, MaterialButton arg4) {
            int v0 = Boolean.valueOf(arg3.isChecked()).compareTo(Boolean.valueOf(arg4.isChecked()));
            if(v0 != 0) {
                return v0;
            }

            v0 = Boolean.valueOf(arg3.isPressed()).compareTo(Boolean.valueOf(arg4.isPressed()));
            if(v0 != 0) {
                return v0;
            }

            return Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(((View)arg3))).compareTo(Integer.valueOf(MaterialButtonToggleGroup.this.indexOfChild(((View)arg4))));
        }

        public int compare(Object arg1, Object arg2) {
            return this.compare(((MaterialButton)arg1), ((MaterialButton)arg2));
        }
    }

    class CornerData {
        CornerSize bottomLeft;
        CornerSize bottomRight;
        private static final CornerSize noCorner;
        CornerSize topLeft;
        CornerSize topRight;

        static {
            CornerData.noCorner = new AbsoluteCornerSize(0f);
        }

        CornerData(CornerSize arg1, CornerSize arg2, CornerSize arg3, CornerSize arg4) {
            super();
            this.topLeft = arg1;
            this.topRight = arg3;
            this.bottomRight = arg4;
            this.bottomLeft = arg2;
        }

        public static CornerData bottom(CornerData arg3) {
            return new CornerData(CornerData.noCorner, arg3.bottomLeft, CornerData.noCorner, arg3.bottomRight);
        }

        public static CornerData end(CornerData arg0, View arg1) {
            if(ViewUtils.isLayoutRtl(arg1)) {
                return CornerData.left(arg0);
            }

            return CornerData.right(arg0);
        }

        public static CornerData left(CornerData arg3) {
            return new CornerData(arg3.topLeft, arg3.bottomLeft, CornerData.noCorner, CornerData.noCorner);
        }

        public static CornerData right(CornerData arg3) {
            return new CornerData(CornerData.noCorner, CornerData.noCorner, arg3.topRight, arg3.bottomRight);
        }

        public static CornerData start(CornerData arg0, View arg1) {
            if(ViewUtils.isLayoutRtl(arg1)) {
                return CornerData.right(arg0);
            }

            return CornerData.left(arg0);
        }

        public static CornerData top(CornerData arg3) {
            return new CornerData(arg3.topLeft, CornerData.noCorner, arg3.topRight, CornerData.noCorner);
        }
    }

    public interface OnButtonCheckedListener {
        void onButtonChecked(MaterialButtonToggleGroup arg1, int arg2, boolean arg3);
    }

    class PressedStateTracker implements OnPressedChangeListener {
        PressedStateTracker(MaterialButtonToggleGroup arg1, com.google.android.material.button.MaterialButtonToggleGroup$1 arg2) {
            this(arg1);
        }

        private PressedStateTracker(MaterialButtonToggleGroup arg1) {
            MaterialButtonToggleGroup.this = arg1;
            super();
        }

        public void onPressedChanged(MaterialButton arg1, boolean arg2) {
            MaterialButtonToggleGroup.this.invalidate();
        }
    }

    private static final int DEF_STYLE_RES = 0;
    private static final String LOG_TAG = "MButtonToggleGroup";
    private Set checkedIds;
    private Integer[] childOrder;
    private final Comparator childOrderComparator;
    private final int defaultCheckId;
    private final LinkedHashSet onButtonCheckedListeners;
    private final List originalCornerData;
    private final PressedStateTracker pressedStateTracker;
    private boolean selectionRequired;
    private boolean singleSelection;
    private boolean skipCheckedStateTracker;

    static {
        MaterialButtonToggleGroup.DEF_STYLE_RES = style.Widget_MaterialComponents_MaterialButtonToggleGroup;
    }

    public MaterialButtonToggleGroup(Context arg2) {
        this(arg2, null);
    }

    public MaterialButtonToggleGroup(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.materialButtonToggleGroupStyle);
    }

    public MaterialButtonToggleGroup(Context arg7, AttributeSet arg8, int arg9) {
        int v4 = MaterialButtonToggleGroup.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg7, arg8, arg9, v4), arg8, arg9);
        this.originalCornerData = new ArrayList();
        this.pressedStateTracker = new PressedStateTracker(this, null);
        this.onButtonCheckedListeners = new LinkedHashSet();
        this.childOrderComparator = new com.google.android.material.button.MaterialButtonToggleGroup$1(this);
        this.skipCheckedStateTracker = false;
        this.checkedIds = new HashSet();
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(this.getContext(), arg8, styleable.MaterialButtonToggleGroup, arg9, v4, new int[0]);
        this.setSingleSelection(v8.getBoolean(styleable.MaterialButtonToggleGroup_singleSelection, false));
        this.defaultCheckId = v8.getResourceId(styleable.MaterialButtonToggleGroup_checkedButton, -1);
        this.selectionRequired = v8.getBoolean(styleable.MaterialButtonToggleGroup_selectionRequired, false);
        this.setChildrenDrawingOrderEnabled(true);
        this.setEnabled(v8.getBoolean(styleable.MaterialButtonToggleGroup_android_enabled, true));
        v8.recycle();
        ViewCompat.setImportantForAccessibility(((View)this), 1);
    }

    static int access$100(MaterialButtonToggleGroup arg0, View arg1) {
        return arg0.getIndexWithinVisibleButtons(arg1);
    }

    public void addOnButtonCheckedListener(OnButtonCheckedListener arg1) {
        this.onButtonCheckedListeners.add(arg1);
    }

    public void addView(View arg5, int arg6, ViewGroup$LayoutParams arg7) {
        if(!(arg5 instanceof MaterialButton)) {
            Log.e("MButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }

        super.addView(arg5, arg6, arg7);
        this.setGeneratedIdIfNeeded(((MaterialButton)arg5));
        this.setupButtonChild(((MaterialButton)arg5));
        this.checkInternal(((MaterialButton)arg5).getId(), ((MaterialButton)arg5).isChecked());
        ShapeAppearanceModel v6 = ((MaterialButton)arg5).getShapeAppearanceModel();
        this.originalCornerData.add(new CornerData(v6.getTopLeftCornerSize(), v6.getBottomLeftCornerSize(), v6.getTopRightCornerSize(), v6.getBottomRightCornerSize()));
        ((MaterialButton)arg5).setEnabled(this.isEnabled());
        ViewCompat.setAccessibilityDelegate(arg5, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View arg7, AccessibilityNodeInfoCompat arg8) {
                super.onInitializeAccessibilityNodeInfo(arg7, arg8);
                arg8.setCollectionItemInfo(CollectionItemInfoCompat.obtain(0, 1, MaterialButtonToggleGroup.this.getIndexWithinVisibleButtons(arg7), 1, false, ((MaterialButton)arg7).isChecked()));
            }
        });
    }

    private void adjustChildMarginsAndUpdateLayout() {
        int v0 = this.getFirstVisibleChildIndex();
        if(v0 == -1) {
            return;
        }

        int v1;
        for(v1 = v0 + 1; v1 < this.getChildCount(); ++v1) {
            MaterialButton v2 = this.getChildButton(v1);
            int v3 = Math.min(v2.getStrokeWidth(), this.getChildButton(v1 - 1).getStrokeWidth());
            LinearLayout$LayoutParams v4 = this.buildLayoutParams(((View)v2));
            if(this.getOrientation() == 0) {
                MarginLayoutParamsCompat.setMarginEnd(((ViewGroup$MarginLayoutParams)v4), 0);
                MarginLayoutParamsCompat.setMarginStart(((ViewGroup$MarginLayoutParams)v4), -v3);
                v4.topMargin = 0;
            }
            else {
                v4.bottomMargin = 0;
                v4.topMargin = -v3;
                MarginLayoutParamsCompat.setMarginStart(((ViewGroup$MarginLayoutParams)v4), 0);
            }

            v2.setLayoutParams(((ViewGroup$LayoutParams)v4));
        }

        this.resetChildMargins(v0);
    }

    private LinearLayout$LayoutParams buildLayoutParams(View arg2) {
        ViewGroup$LayoutParams v1 = arg2.getLayoutParams();
        if((v1 instanceof LinearLayout$LayoutParams)) {
            return ((LinearLayout$LayoutParams)v1);
        }

        return new LinearLayout$LayoutParams(v1.width, v1.height);
    }

    public void check(int arg2) {
        this.checkInternal(arg2, true);
    }

    private void checkInternal(int arg3, boolean arg4) {
        if(arg3 == -1) {
            Log.e("MButtonToggleGroup", "Button ID is not valid: " + arg3);
            return;
        }

        HashSet v0 = new HashSet(this.checkedIds);
        if(!arg4 || (((Set)v0).contains(Integer.valueOf(arg3)))) {
            if(arg4) {
                return;
            }

            if(!((Set)v0).contains(Integer.valueOf(arg3))) {
                return;
            }

            if(!this.selectionRequired || ((Set)v0).size() > 1) {
                ((Set)v0).remove(Integer.valueOf(arg3));
            }

        label_36:
            this.updateCheckedIds(((Set)v0));
        }
        else {
            if((this.singleSelection) && !((Set)v0).isEmpty()) {
                ((Set)v0).clear();
            }

            ((Set)v0).add(Integer.valueOf(arg3));
            goto label_36;
        }
    }

    public void clearChecked() {
        this.updateCheckedIds(new HashSet());
    }

    public void clearOnButtonCheckedListeners() {
        this.onButtonCheckedListeners.clear();
    }

    protected void dispatchDraw(Canvas arg1) {
        this.updateChildOrder();
        super.dispatchDraw(arg1);
    }

    private void dispatchOnButtonChecked(int arg3, boolean arg4) {
        Iterator v0 = this.onButtonCheckedListeners.iterator();
        while(v0.hasNext()) {
            v0.next().onButtonChecked(this, arg3, arg4);
        }
    }

    public int getCheckedButtonId() {
        if((this.singleSelection) && !this.checkedIds.isEmpty()) {
            return this.checkedIds.iterator().next().intValue();
        }

        return -1;
    }

    public List getCheckedButtonIds() {
        ArrayList v0 = new ArrayList();
        int v1;
        for(v1 = 0; v1 < this.getChildCount(); ++v1) {
            int v2 = this.getChildButton(v1).getId();
            if(this.checkedIds.contains(Integer.valueOf(v2))) {
                ((List)v0).add(Integer.valueOf(v2));
            }
        }

        return ((List)v0);
    }

    private MaterialButton getChildButton(int arg1) {
        return this.getChildAt(arg1);
    }

    protected int getChildDrawingOrder(int arg1, int arg2) {
        Integer[] v0 = this.childOrder;
        if(v0 != null) {
            if(arg2 >= v0.length) {
            }
            else {
                return v0[arg2].intValue();
            }
        }

        Log.w("MButtonToggleGroup", "Child order wasn\'t updated");
        return arg2;
    }

    private int getFirstVisibleChildIndex() {
        int v0 = this.getChildCount();
        int v1;
        for(v1 = 0; v1 < v0; ++v1) {
            if(this.isChildVisible(v1)) {
                return v1;
            }
        }

        return -1;
    }

    private int getIndexWithinVisibleButtons(View arg5) {
        int v1 = -1;
        if(!(arg5 instanceof MaterialButton)) {
            return v1;
        }

        int v0 = 0;
        int v2 = 0;
        while(v0 < this.getChildCount()) {
            if(this.getChildAt(v0) == arg5) {
                return v2;
            }

            if(((this.getChildAt(v0) instanceof MaterialButton)) && (this.isChildVisible(v0))) {
                ++v2;
            }

            ++v0;
        }

        return v1;
    }

    private int getLastVisibleChildIndex() {
        int v0;
        for(v0 = this.getChildCount() - 1; v0 >= 0; --v0) {
            if(this.isChildVisible(v0)) {
                return v0;
            }
        }

        return -1;
    }

    private CornerData getNewCornerData(int arg3, int arg4, int arg5) {
        Object v0 = this.originalCornerData.get(arg3);
        if(arg4 == arg5) {
            return ((CornerData)v0);
        }

        int v1 = this.getOrientation() == 0 ? 1 : 0;
        if(arg3 == arg4) {
            if(v1 != 0) {
                return CornerData.start(((CornerData)v0), ((View)this));
            }

            return CornerData.top(((CornerData)v0));
        }

        if(arg3 == arg5) {
            if(v1 != 0) {
                return CornerData.end(((CornerData)v0), ((View)this));
            }

            return CornerData.bottom(((CornerData)v0));
        }

        return null;
    }

    private int getVisibleButtonCount() {
        int v0 = 0;
        int v1 = 0;
        while(v0 < this.getChildCount()) {
            if(((this.getChildAt(v0) instanceof MaterialButton)) && (this.isChildVisible(v0))) {
                ++v1;
            }

            ++v0;
        }

        return v1;
    }

    private boolean isChildVisible(int arg1) {
        if(this.getChildAt(arg1).getVisibility() != 8) {
            return 1;
        }

        return 0;
    }

    public boolean isSelectionRequired() {
        return this.selectionRequired;
    }

    public boolean isSingleSelection() {
        return this.singleSelection;
    }

    void onButtonCheckedStateChanged(MaterialButton arg2, boolean arg3) {
        if(this.skipCheckedStateTracker) {
            return;
        }

        this.checkInternal(arg2.getId(), arg3);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        int v0 = this.defaultCheckId;
        if(v0 != -1) {
            this.updateCheckedIds(Collections.singleton(Integer.valueOf(v0)));
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg4) {
        super.onInitializeAccessibilityNodeInfo(arg4);
        AccessibilityNodeInfoCompat v4 = AccessibilityNodeInfoCompat.wrap(arg4);
        int v0 = this.getVisibleButtonCount();
        int v3 = this.isSingleSelection() ? 1 : 2;
        v4.setCollectionInfo(CollectionInfoCompat.obtain(1, v0, false, v3));
    }

    protected void onMeasure(int arg1, int arg2) {
        this.updateChildShapes();
        this.adjustChildMarginsAndUpdateLayout();
        super.onMeasure(arg1, arg2);
    }

    public void onViewRemoved(View arg3) {
        super.onViewRemoved(arg3);
        if((arg3 instanceof MaterialButton)) {
            arg3.setOnPressedChangeListenerInternal(null);
        }

        int v3 = this.indexOfChild(arg3);
        if(v3 >= 0) {
            this.originalCornerData.remove(v3);
        }

        this.updateChildShapes();
        this.adjustChildMarginsAndUpdateLayout();
    }

    public void removeOnButtonCheckedListener(OnButtonCheckedListener arg1) {
        this.onButtonCheckedListeners.remove(arg1);
    }

    private void resetChildMargins(int arg3) {
        if(this.getChildCount() != 0) {
            if(arg3 == -1) {
            }
            else {
                ViewGroup$LayoutParams v3 = this.getChildButton(arg3).getLayoutParams();
                if(this.getOrientation() == 1) {
                    ((LinearLayout$LayoutParams)v3).topMargin = 0;
                    ((LinearLayout$LayoutParams)v3).bottomMargin = 0;
                    return;
                }
                else {
                    MarginLayoutParamsCompat.setMarginEnd(((ViewGroup$MarginLayoutParams)v3), 0);
                    MarginLayoutParamsCompat.setMarginStart(((ViewGroup$MarginLayoutParams)v3), 0);
                    ((LinearLayout$LayoutParams)v3).leftMargin = 0;
                    ((LinearLayout$LayoutParams)v3).rightMargin = 0;
                }
            }
        }
    }

    private void setCheckedStateForView(int arg2, boolean arg3) {
        View v2 = this.findViewById(arg2);
        if((v2 instanceof MaterialButton)) {
            this.skipCheckedStateTracker = true;
            ((MaterialButton)v2).setChecked(arg3);
            this.skipCheckedStateTracker = false;
        }
    }

    public void setEnabled(boolean arg3) {
        super.setEnabled(arg3);
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            this.getChildButton(v0).setEnabled(arg3);
        }
    }

    private void setGeneratedIdIfNeeded(MaterialButton arg2) {
        if(arg2.getId() == -1) {
            arg2.setId(ViewCompat.generateViewId());
        }
    }

    public void setSelectionRequired(boolean arg1) {
        this.selectionRequired = arg1;
    }

    public void setSingleSelection(boolean arg2) {
        if(this.singleSelection != arg2) {
            this.singleSelection = arg2;
            this.clearChecked();
        }

        this.updateChildrenA11yClassName();
    }

    public void setSingleSelection(int arg2) {
        this.setSingleSelection(this.getResources().getBoolean(arg2));
    }

    private void setupButtonChild(MaterialButton arg3) {
        arg3.setMaxLines(1);
        arg3.setEllipsize(TextUtils$TruncateAt.END);
        arg3.setCheckable(true);
        arg3.setOnPressedChangeListenerInternal(this.pressedStateTracker);
        arg3.setShouldDrawSurfaceColorStroke(true);
    }

    public void uncheck(int arg2) {
        this.checkInternal(arg2, false);
    }

    private static void updateBuilderWithCornerData(Builder arg1, CornerData arg2) {
        if(arg2 == null) {
            arg1.setAllCornerSizes(0f);
            return;
        }

        arg1.setTopLeftCornerSize(arg2.topLeft).setBottomLeftCornerSize(arg2.bottomLeft).setTopRightCornerSize(arg2.topRight).setBottomRightCornerSize(arg2.bottomRight);
    }

    private void updateCheckedIds(Set arg6) {
        Set v0 = this.checkedIds;
        this.checkedIds = new HashSet(((Collection)arg6));
        int v1;
        for(v1 = 0; v1 < this.getChildCount(); ++v1) {
            int v2 = this.getChildButton(v1).getId();
            this.setCheckedStateForView(v2, arg6.contains(Integer.valueOf(v2)));
            if(v0.contains(Integer.valueOf(v2)) != arg6.contains(Integer.valueOf(v2))) {
                this.dispatchOnButtonChecked(v2, arg6.contains(Integer.valueOf(v2)));
            }
        }

        this.invalidate();
    }

    private void updateChildOrder() {
        TreeMap v0 = new TreeMap(this.childOrderComparator);
        int v1 = this.getChildCount();
        int v3;
        for(v3 = 0; v3 < v1; ++v3) {
            ((SortedMap)v0).put(this.getChildButton(v3), Integer.valueOf(v3));
        }

        this.childOrder = ((SortedMap)v0).values().toArray(new Integer[0]);
    }

    void updateChildShapes() {
        int v0 = this.getChildCount();
        int v1 = this.getFirstVisibleChildIndex();
        int v2 = this.getLastVisibleChildIndex();
        int v3;
        for(v3 = 0; v3 < v0; ++v3) {
            MaterialButton v4 = this.getChildButton(v3);
            if(v4.getVisibility() == 8) {
            }
            else {
                Builder v5 = v4.getShapeAppearanceModel().toBuilder();
                MaterialButtonToggleGroup.updateBuilderWithCornerData(v5, this.getNewCornerData(v3, v1, v2));
                v4.setShapeAppearanceModel(v5.build());
            }
        }
    }

    private void updateChildrenA11yClassName() {
        int v0;
        for(v0 = 0; v0 < this.getChildCount(); ++v0) {
            Class v1 = this.singleSelection ? RadioButton.class : ToggleButton.class;
            this.getChildButton(v0).setA11yClassName(v1.getName());
        }
    }
}

