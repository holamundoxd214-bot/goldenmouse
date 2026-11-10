package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.util.AttributeSet;
import android.view.View$MeasureSpec;
import android.view.View;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.AdapterView$OnItemClickListener;
import android.widget.AdapterView$OnItemSelectedListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.ManufacturerUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;

public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    class MaterialArrayAdapter extends ArrayAdapter {
        private ColorStateList pressedRippleColor;
        private ColorStateList selectedItemRippleOverlaidColor;

        MaterialArrayAdapter(MaterialAutoCompleteTextView arg1, Context arg2, int arg3, String[] arg4) {
            MaterialAutoCompleteTextView.this = arg1;
            super(arg2, arg3, ((Object[])arg4));
            this.updateSelectedItemColorStateList();
        }

        private ColorStateList createItemSelectedColorStateList() {
            if((this.hasSelectedColor()) && (this.hasSelectedRippleColor())) {
                int[] v0 = new int[]{0x1010367, 0xFEFEFF59};
                int[] v1 = new int[]{0x10100A1, 0xFEFEFF59};
                return new ColorStateList(new int[][]{v1, v0, new int[0]}, new int[]{MaterialColors.layer(MaterialAutoCompleteTextView.this.simpleItemSelectedColor, MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor.getColorForState(v1, 0)), MaterialColors.layer(MaterialAutoCompleteTextView.this.simpleItemSelectedColor, MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor.getColorForState(v0, 0)), MaterialAutoCompleteTextView.this.simpleItemSelectedColor});
            }

            return null;
        }

        private Drawable getSelectedItemDrawable() {
            Drawable v1 = null;
            if(this.hasSelectedColor()) {
                ColorDrawable v0 = new ColorDrawable(MaterialAutoCompleteTextView.this.simpleItemSelectedColor);
                if(this.pressedRippleColor != null) {
                    DrawableCompat.setTintList(((Drawable)v0), this.selectedItemRippleOverlaidColor);
                    return new RippleDrawable(this.pressedRippleColor, ((Drawable)v0), v1);
                }

                return ((Drawable)v0);
            }

            return v1;
        }

        public View getView(int arg2, View arg3, ViewGroup arg4) {
            View v2 = super.getView(arg2, arg3, arg4);
            if((v2 instanceof TextView)) {
                arg3 = v2;
                Drawable v1 = MaterialAutoCompleteTextView.this.getText().toString().contentEquals(((TextView)arg3).getText()) ? this.getSelectedItemDrawable() : null;
                ViewCompat.setBackground(arg3, v1);
            }

            return v2;
        }

        private boolean hasSelectedColor() {
            if(MaterialAutoCompleteTextView.this.simpleItemSelectedColor != 0) {
                return 1;
            }

            return 0;
        }

        private boolean hasSelectedRippleColor() {
            if(MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor != null) {
                return 1;
            }

            return 0;
        }

        private ColorStateList sanitizeDropdownItemSelectedRippleColor() {
            if(!this.hasSelectedRippleColor()) {
                return null;
            }

            int[] v0 = new int[]{0x10100A7};
            return new ColorStateList(new int[][]{v0, new int[0]}, new int[]{MaterialAutoCompleteTextView.this.simpleItemSelectedRippleColor.getColorForState(v0, 0), 0});
        }

        void updateSelectedItemColorStateList() {
            this.pressedRippleColor = this.sanitizeDropdownItemSelectedRippleColor();
            this.selectedItemRippleOverlaidColor = this.createItemSelectedColorStateList();
        }
    }

    private static final int MAX_ITEMS_MEASURED = 15;
    private final AccessibilityManager accessibilityManager;
    private ColorStateList dropDownBackgroundTint;
    private final ListPopupWindow modalListPopup;
    private final float popupElevation;
    private final int simpleItemLayout;
    private int simpleItemSelectedColor;
    private ColorStateList simpleItemSelectedRippleColor;
    private final Rect tempRect;

    public MaterialAutoCompleteTextView(Context arg2) {
        this(arg2, null);
    }

    public MaterialAutoCompleteTextView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(Context arg8, AttributeSet arg9, int arg10) {
        super(MaterialThemeOverlay.wrap(arg8, arg9, arg10, 0), arg9, arg10);
        this.tempRect = new Rect();
        Context v1 = this.getContext();
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v1, arg9, styleable.MaterialAutoCompleteTextView, arg10, style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if((v8.hasValue(styleable.MaterialAutoCompleteTextView_android_inputType)) && v8.getInt(styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            this.setKeyListener(null);
        }

        this.simpleItemLayout = v8.getResourceId(styleable.MaterialAutoCompleteTextView_simpleItemLayout, layout.mtrl_auto_complete_simple_item);
        this.popupElevation = ((float)v8.getDimensionPixelOffset(styleable.MaterialAutoCompleteTextView_android_popupElevation, dimen.mtrl_exposed_dropdown_menu_popup_elevation));
        if(v8.hasValue(styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint)) {
            this.dropDownBackgroundTint = ColorStateList.valueOf(v8.getColor(styleable.MaterialAutoCompleteTextView_dropDownBackgroundTint, 0));
        }

        this.simpleItemSelectedColor = v8.getColor(styleable.MaterialAutoCompleteTextView_simpleItemSelectedColor, 0);
        this.simpleItemSelectedRippleColor = MaterialResources.getColorStateList(v1, v8, styleable.MaterialAutoCompleteTextView_simpleItemSelectedRippleColor);
        this.accessibilityManager = v1.getSystemService("accessibility");
        ListPopupWindow v9 = new ListPopupWindow(v1);
        this.modalListPopup = v9;
        v9.setModal(true);
        v9.setAnchorView(((View)this));
        v9.setInputMethodMode(2);
        v9.setAdapter(this.getAdapter());
        v9.setOnItemClickListener(new AdapterView$OnItemClickListener() {
            public void onItemClick(AdapterView arg7, View arg8, int arg9, long arg10) {
                MaterialAutoCompleteTextView v7 = MaterialAutoCompleteTextView.this;
                Object v7_1 = arg9 < 0 ? MaterialAutoCompleteTextView.access$000(v7).getSelectedItem() : v7.getAdapter().getItem(arg9);
                MaterialAutoCompleteTextView.access$100(MaterialAutoCompleteTextView.this, v7_1);
                AdapterView$OnItemClickListener v0 = MaterialAutoCompleteTextView.this.getOnItemClickListener();
                if(v0 != null) {
                    if(arg8 == null || arg9 < 0) {
                        arg8 = MaterialAutoCompleteTextView.access$000(MaterialAutoCompleteTextView.this).getSelectedView();
                        arg9 = MaterialAutoCompleteTextView.access$000(MaterialAutoCompleteTextView.this).getSelectedItemPosition();
                        arg10 = MaterialAutoCompleteTextView.access$000(MaterialAutoCompleteTextView.this).getSelectedItemId();
                    }

                    v0.onItemClick(MaterialAutoCompleteTextView.access$000(MaterialAutoCompleteTextView.this).getListView(), arg8, arg9, arg10);
                }

                MaterialAutoCompleteTextView.access$000(MaterialAutoCompleteTextView.this).dismiss();
            }
        });
        if(v8.hasValue(styleable.MaterialAutoCompleteTextView_simpleItems)) {
            this.setSimpleItems(v8.getResourceId(styleable.MaterialAutoCompleteTextView_simpleItems, 0));
        }

        v8.recycle();
    }

    static ListPopupWindow access$000(MaterialAutoCompleteTextView arg0) {
        return arg0.modalListPopup;
    }

    static void access$100(MaterialAutoCompleteTextView arg0, Object arg1) {
        arg0.updateText(arg1);
    }

    static int access$200(MaterialAutoCompleteTextView arg0) {
        return arg0.simpleItemSelectedColor;
    }

    static ColorStateList access$300(MaterialAutoCompleteTextView arg0) {
        return arg0.simpleItemSelectedRippleColor;
    }

    public void dismissDropDown() {
        if(this.isTouchExplorationEnabled()) {
            this.modalListPopup.dismiss();
            return;
        }

        super.dismissDropDown();
    }

    private TextInputLayout findTextInputLayoutAncestor() {
        ViewParent v1;
        for(v1 = this.getParent(); v1 != null; v1 = v1.getParent()) {
            if((v1 instanceof TextInputLayout)) {
                return ((TextInputLayout)v1);
            }
        }

        return null;
    }

    public ColorStateList getDropDownBackgroundTintList() {
        return this.dropDownBackgroundTint;
    }

    public CharSequence getHint() {
        TextInputLayout v0 = this.findTextInputLayoutAncestor();
        if(v0 != null && (v0.isProvidingHint())) {
            return v0.getHint();
        }

        return super.getHint();
    }

    public float getPopupElevation() {
        return this.popupElevation;
    }

    public int getSimpleItemSelectedColor() {
        return this.simpleItemSelectedColor;
    }

    public ColorStateList getSimpleItemSelectedRippleColor() {
        return this.simpleItemSelectedRippleColor;
    }

    private boolean isTouchExplorationEnabled() {
        AccessibilityManager v0 = this.accessibilityManager;
        if(v0 != null && (v0.isTouchExplorationEnabled())) {
            return 1;
        }

        return 0;
    }

    private int measureContentWidth() {
        ListAdapter v0 = this.getAdapter();
        TextInputLayout v1 = this.findTextInputLayoutAncestor();
        int v2 = 0;
        if(v0 != null) {
            if(v1 == null) {
            }
            else {
                int v3 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredWidth(), 0);
                int v4 = View$MeasureSpec.makeMeasureSpec(this.getMeasuredHeight(), 0);
                int v5 = Math.min(v0.getCount(), Math.max(0, this.modalListPopup.getSelectedItemPosition()) + 15);
                View v7 = null;
                int v8 = Math.max(0, v5 - 15);
                View v9 = v7;
                int v6 = 0;
                while(v8 < v5) {
                    int v10 = v0.getItemViewType(v8);
                    if(v10 != v2) {
                        v9 = v7;
                        v2 = v10;
                    }

                    v9 = v0.getView(v8, v9, ((ViewGroup)v1));
                    if(v9.getLayoutParams() == null) {
                        v9.setLayoutParams(new ViewGroup$LayoutParams(-2, -2));
                    }

                    v9.measure(v3, v4);
                    v6 = Math.max(v6, v9.getMeasuredWidth());
                    ++v8;
                }

                Drawable v0_1 = this.modalListPopup.getBackground();
                if(v0_1 != null) {
                    v0_1.getPadding(this.tempRect);
                    v6 += this.tempRect.left + this.tempRect.right;
                }

                return v6 + v1.getEndIconView().getMeasuredWidth();
            }
        }

        return 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout v0 = this.findTextInputLayoutAncestor();
        if(v0 != null && (v0.isProvidingHint()) && super.getHint() == null && (ManufacturerUtils.isMeizuDevice())) {
            this.setHint("");
        }
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.modalListPopup.dismiss();
    }

    private void onInputTypeChanged() {
        TextInputLayout v0 = this.findTextInputLayoutAncestor();
        if(v0 != null) {
            v0.updateEditTextBoxBackgroundIfNeeded();
        }
    }

    protected void onMeasure(int arg2, int arg3) {
        super.onMeasure(arg2, arg3);
        if(View$MeasureSpec.getMode(arg2) == 0x80000000) {
            this.setMeasuredDimension(Math.min(Math.max(this.getMeasuredWidth(), this.measureContentWidth()), View$MeasureSpec.getSize(arg2)), this.getMeasuredHeight());
        }
    }

    public void onWindowFocusChanged(boolean arg2) {
        if(this.isTouchExplorationEnabled()) {
            return;
        }

        super.onWindowFocusChanged(arg2);
    }

    public void setAdapter(ListAdapter arg1) {
        super.setAdapter(arg1);
        this.modalListPopup.setAdapter(this.getAdapter());
    }

    public void setDropDownBackgroundDrawable(Drawable arg1) {
        super.setDropDownBackgroundDrawable(arg1);
        ListPopupWindow v0 = this.modalListPopup;
        if(v0 != null) {
            v0.setBackgroundDrawable(arg1);
        }
    }

    public void setDropDownBackgroundTint(int arg1) {
        this.setDropDownBackgroundTintList(ColorStateList.valueOf(arg1));
    }

    public void setDropDownBackgroundTintList(ColorStateList arg2) {
        this.dropDownBackgroundTint = arg2;
        Drawable v2 = this.getDropDownBackground();
        if((v2 instanceof MaterialShapeDrawable)) {
            ((MaterialShapeDrawable)v2).setFillColor(this.dropDownBackgroundTint);
        }
    }

    public void setOnItemSelectedListener(AdapterView$OnItemSelectedListener arg1) {
        super.setOnItemSelectedListener(arg1);
        this.modalListPopup.setOnItemSelectedListener(this.getOnItemSelectedListener());
    }

    public void setRawInputType(int arg1) {
        super.setRawInputType(arg1);
        this.onInputTypeChanged();
    }

    public void setSimpleItemSelectedColor(int arg1) {
        this.simpleItemSelectedColor = arg1;
        if((this.getAdapter() instanceof MaterialArrayAdapter)) {
            this.getAdapter().updateSelectedItemColorStateList();
        }
    }

    public void setSimpleItemSelectedRippleColor(ColorStateList arg1) {
        this.simpleItemSelectedRippleColor = arg1;
        if((this.getAdapter() instanceof MaterialArrayAdapter)) {
            this.getAdapter().updateSelectedItemColorStateList();
        }
    }

    public void setSimpleItems(int arg2) {
        this.setSimpleItems(this.getResources().getStringArray(arg2));
    }

    public void setSimpleItems(String[] arg4) {
        this.setAdapter(new MaterialArrayAdapter(this, this.getContext(), this.simpleItemLayout, arg4));
    }

    public void showDropDown() {
        if(this.isTouchExplorationEnabled()) {
            this.modalListPopup.show();
            return;
        }

        super.showDropDown();
    }

    private void updateText(Object arg2) {
        this.setText(this.convertSelectionToString(arg2), false);
    }
}

