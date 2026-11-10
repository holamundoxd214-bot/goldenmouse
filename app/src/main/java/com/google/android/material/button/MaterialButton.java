package com.google.android.material.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable$ClassLoaderCreator;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.Layout$Alignment;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialButton extends AppCompatButton implements Checkable, Shapeable {
    @Retention(value=RetentionPolicy.SOURCE) @public interface IconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialButton arg1, boolean arg2);
    }

    interface OnPressedChangeListener {
        void onPressedChanged(MaterialButton arg1, boolean arg2);
    }

    class SavedState extends AbsSavedState {
        class com.google.android.material.button.MaterialButton$SavedState$1 implements Parcelable$ClassLoaderCreator {
            com.google.android.material.button.MaterialButton$SavedState$1() {
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
        boolean checked;

        static {
            SavedState.CREATOR = new com.google.android.material.button.MaterialButton$SavedState$1();
        }

        public SavedState(Parcelable arg1) {
            super(arg1);
        }

        public SavedState(Parcel arg1, ClassLoader arg2) {
            super(arg1, arg2);
            if(arg2 == null) {
                this.getClass().getClassLoader();
            }

            this.readFromParcel(arg1);
        }

        private void readFromParcel(Parcel arg2) {
            boolean v0 = true;
            if(arg2.readInt() == 1) {
            }
            else {
                v0 = false;
            }

            this.checked = v0;
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeInt(this.checked);
        }
    }

    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    public static final int ICON_GRAVITY_END = 3;
    public static final int ICON_GRAVITY_START = 1;
    public static final int ICON_GRAVITY_TEXT_END = 4;
    public static final int ICON_GRAVITY_TEXT_START = 2;
    public static final int ICON_GRAVITY_TEXT_TOP = 0x20;
    public static final int ICON_GRAVITY_TOP = 16;
    private static final String LOG_TAG = "MaterialButton";
    private String accessibilityClassName;
    private boolean broadcasting;
    private boolean checked;
    private Drawable icon;
    private int iconGravity;
    private int iconLeft;
    private int iconPadding;
    private int iconSize;
    private ColorStateList iconTint;
    private PorterDuff$Mode iconTintMode;
    private int iconTop;
    private final MaterialButtonHelper materialButtonHelper;
    private final LinkedHashSet onCheckedChangeListeners;
    private OnPressedChangeListener onPressedChangeListenerInternal;

    static {
        MaterialButton.CHECKABLE_STATE_SET = new int[]{0x101009F};
        MaterialButton.CHECKED_STATE_SET = new int[]{0x10100A0};
        MaterialButton.DEF_STYLE_RES = style.Widget_MaterialComponents_Button;
    }

    public MaterialButton(Context arg2) {
        this(arg2, null);
    }

    public MaterialButton(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.materialButtonStyle);
    }

    public MaterialButton(Context arg7, AttributeSet arg8, int arg9) {
        int v4 = MaterialButton.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg7, arg8, arg9, v4), arg8, arg9);
        this.onCheckedChangeListeners = new LinkedHashSet();
        boolean v7 = false;
        this.checked = false;
        this.broadcasting = false;
        Context v0 = this.getContext();
        AttributeSet v1 = arg8;
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v0, v1, styleable.MaterialButton, arg9, v4, new int[0]);
        this.iconPadding = v8.getDimensionPixelSize(styleable.MaterialButton_iconPadding, 0);
        this.iconTintMode = ViewUtils.parseTintMode(v8.getInt(styleable.MaterialButton_iconTintMode, -1), PorterDuff$Mode.SRC_IN);
        this.iconTint = MaterialResources.getColorStateList(this.getContext(), v8, styleable.MaterialButton_iconTint);
        this.icon = MaterialResources.getDrawable(this.getContext(), v8, styleable.MaterialButton_icon);
        this.iconGravity = v8.getInteger(styleable.MaterialButton_iconGravity, 1);
        this.iconSize = v8.getDimensionPixelSize(styleable.MaterialButton_iconSize, 0);
        MaterialButtonHelper v0_1 = new MaterialButtonHelper(this, ShapeAppearanceModel.builder(v0, v1, arg9, v4).build());
        this.materialButtonHelper = v0_1;
        v0_1.loadFromAttributes(v8);
        v8.recycle();
        this.setCompoundDrawablePadding(this.iconPadding);
        if(this.icon != null) {
            v7 = true;
        }

        this.updateIcon(v7);
    }

    public void addOnCheckedChangeListener(OnCheckedChangeListener arg1) {
        this.onCheckedChangeListeners.add(arg1);
    }

    public void clearOnCheckedChangeListeners() {
        this.onCheckedChangeListeners.clear();
    }

    String getA11yClassName() {
        if(!TextUtils.isEmpty(this.accessibilityClassName)) {
            return this.accessibilityClassName;
        }

        Class v1 = this.isCheckable() ? CompoundButton.class : Button.class;
        return v1.getName();
    }

    private Layout$Alignment getActualTextAlignment() {
        int v0 = this.getTextAlignment();
        if(v0 != 1) {
            if(v0 != 6 && v0 != 3) {
                if(v0 != 4) {
                    return Layout$Alignment.ALIGN_NORMAL;
                }
                else {
                    return Layout$Alignment.ALIGN_CENTER;
                }
            }

            return Layout$Alignment.ALIGN_OPPOSITE;
        }

        return this.getGravityTextAlignment();
    }

    public ColorStateList getBackgroundTintList() {
        return this.getSupportBackgroundTintList();
    }

    public PorterDuff$Mode getBackgroundTintMode() {
        return this.getSupportBackgroundTintMode();
    }

    public int getCornerRadius() {
        if(this.isUsingOriginalBackground()) {
            return this.materialButtonHelper.getCornerRadius();
        }

        return 0;
    }

    private Layout$Alignment getGravityTextAlignment() {
        int v1 = this.getGravity() & 0x800007;
        if(v1 != 1) {
            if(v1 != 5 && v1 != 0x800005) {
                return Layout$Alignment.ALIGN_NORMAL;
            }

            return Layout$Alignment.ALIGN_OPPOSITE;
        }

        return Layout$Alignment.ALIGN_CENTER;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public int getIconGravity() {
        return this.iconGravity;
    }

    public int getIconPadding() {
        return this.iconPadding;
    }

    public int getIconSize() {
        return this.iconSize;
    }

    public ColorStateList getIconTint() {
        return this.iconTint;
    }

    public PorterDuff$Mode getIconTintMode() {
        return this.iconTintMode;
    }

    public int getInsetBottom() {
        return this.materialButtonHelper.getInsetBottom();
    }

    public int getInsetTop() {
        return this.materialButtonHelper.getInsetTop();
    }

    public ColorStateList getRippleColor() {
        if(this.isUsingOriginalBackground()) {
            return this.materialButtonHelper.getRippleColor();
        }

        return null;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        if(this.isUsingOriginalBackground()) {
            return this.materialButtonHelper.getShapeAppearanceModel();
        }

        throw new IllegalStateException("Attempted to get ShapeAppearanceModel from a MaterialButton which has an overwritten background.");
    }

    public ColorStateList getStrokeColor() {
        if(this.isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeColor();
        }

        return null;
    }

    public int getStrokeWidth() {
        if(this.isUsingOriginalBackground()) {
            return this.materialButtonHelper.getStrokeWidth();
        }

        return 0;
    }

    public ColorStateList getSupportBackgroundTintList() {
        if(this.isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintList();
        }

        return super.getSupportBackgroundTintList();
    }

    public PorterDuff$Mode getSupportBackgroundTintMode() {
        if(this.isUsingOriginalBackground()) {
            return this.materialButtonHelper.getSupportBackgroundTintMode();
        }

        return super.getSupportBackgroundTintMode();
    }

    private int getTextHeight() {
        if(this.getLineCount() > 1) {
            return this.getLayout().getHeight();
        }

        TextPaint v0 = this.getPaint();
        String v1 = this.getText().toString();
        if(this.getTransformationMethod() != null) {
            v1 = this.getTransformationMethod().getTransformation(((CharSequence)v1), ((View)this)).toString();
        }

        Rect v2 = new Rect();
        ((Paint)v0).getTextBounds(v1, 0, v1.length(), v2);
        return Math.min(v2.height(), this.getLayout().getHeight());
    }

    private int getTextLayoutWidth() {
        int v0 = this.getLineCount();
        float v1 = 0f;
        int v2;
        for(v2 = 0; v2 < v0; ++v2) {
            v1 = Math.max(v1, this.getLayout().getLineWidth(v2));
        }

        return ((int)Math.ceil(((double)v1)));
    }

    public boolean isCheckable() {
        MaterialButtonHelper v0 = this.materialButtonHelper;
        if(v0 != null && (v0.isCheckable())) {
            return 1;
        }

        return 0;
    }

    public boolean isChecked() {
        return this.checked;
    }

    private boolean isIconEnd() {
        int v1 = this.iconGravity;
        if(v1 != 3) {
            if(v1 == 4) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean isIconStart() {
        int v2 = this.iconGravity;
        if(v2 != 1) {
            if(v2 == 2) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean isIconTop() {
        int v1 = this.iconGravity;
        if(v1 != 16) {
            if(v1 == 0x20) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private boolean isLayoutRTL() {
        if(ViewCompat.getLayoutDirection(((View)this)) == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isToggleCheckedStateOnClick() {
        return this.materialButtonHelper.isToggleCheckedStateOnClick();
    }

    private boolean isUsingOriginalBackground() {
        MaterialButtonHelper v0 = this.materialButtonHelper;
        if(v0 != null && !v0.isBackgroundOverwritten()) {
            return 1;
        }

        return 0;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if(this.isUsingOriginalBackground()) {
            MaterialShapeUtils.setParentAbsoluteElevation(((View)this), this.materialButtonHelper.getMaterialShapeDrawable());
        }
    }

    protected int[] onCreateDrawableState(int arg2) {
        int[] v2 = super.onCreateDrawableState(arg2 + 2);
        if(this.isCheckable()) {
            MaterialButton.mergeDrawableStates(v2, MaterialButton.CHECKABLE_STATE_SET);
        }

        if(this.isChecked()) {
            MaterialButton.mergeDrawableStates(v2, MaterialButton.CHECKED_STATE_SET);
        }

        return v2;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg2) {
        super.onInitializeAccessibilityEvent(arg2);
        arg2.setClassName(this.getA11yClassName());
        arg2.setChecked(this.isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg2) {
        super.onInitializeAccessibilityNodeInfo(arg2);
        arg2.setClassName(this.getA11yClassName());
        arg2.setCheckable(this.isCheckable());
        arg2.setChecked(this.isChecked());
        arg2.setClickable(this.isClickable());
    }

    protected void onLayout(boolean arg1, int arg2, int arg3, int arg4, int arg5) {
        super.onLayout(arg1, arg2, arg3, arg4, arg5);
        this.updateIconPosition(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    public void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.setChecked(((SavedState)arg2).checked);
    }

    public Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.checked = this.checked;
        return ((Parcelable)v1);
    }

    protected void onTextChanged(CharSequence arg1, int arg2, int arg3, int arg4) {
        super.onTextChanged(arg1, arg2, arg3, arg4);
        this.updateIconPosition(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    public boolean performClick() {
        if(this.materialButtonHelper.isToggleCheckedStateOnClick()) {
            this.toggle();
        }

        return super.performClick();
    }

    public void refreshDrawableState() {
        super.refreshDrawableState();
        if(this.icon != null && (this.icon.setState(this.getDrawableState()))) {
            this.invalidate();
        }
    }

    public void removeOnCheckedChangeListener(OnCheckedChangeListener arg1) {
        this.onCheckedChangeListeners.remove(arg1);
    }

    private void resetIconDrawable() {
        Drawable v1 = null;
        if(this.isIconStart()) {
            TextViewCompat.setCompoundDrawablesRelative(((TextView)this), this.icon, v1, v1, v1);
            return;
        }

        if(this.isIconEnd()) {
            TextViewCompat.setCompoundDrawablesRelative(((TextView)this), v1, v1, this.icon, v1);
            return;
        }

        if(this.isIconTop()) {
            TextViewCompat.setCompoundDrawablesRelative(((TextView)this), v1, this.icon, v1, v1);
        }
    }

    void setA11yClassName(String arg1) {
        this.accessibilityClassName = arg1;
    }

    public void setBackground(Drawable arg1) {
        this.setBackgroundDrawable(arg1);
    }

    public void setBackgroundColor(int arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setBackgroundColor(arg2);
            return;
        }

        super.setBackgroundColor(arg2);
    }

    public void setBackgroundDrawable(Drawable arg3) {
        if(this.isUsingOriginalBackground()) {
            if(arg3 != this.getBackground()) {
                Log.w("MaterialButton", "MaterialButton manages its own background to control elevation, shape, color and states. Consider using backgroundTint, shapeAppearance and other attributes where available. A custom background will ignore these attributes and you should consider handling interaction states such as pressed, focused and disabled");
                this.materialButtonHelper.setBackgroundOverwritten();
                super.setBackgroundDrawable(arg3);
                return;
            }

            this.getBackground().setState(arg3.getState());
            return;
        }

        super.setBackgroundDrawable(arg3);
    }

    public void setBackgroundResource(int arg2) {
        Drawable v2 = arg2 != 0 ? AppCompatResources.getDrawable(this.getContext(), arg2) : null;
        this.setBackgroundDrawable(v2);
    }

    public void setBackgroundTintList(ColorStateList arg1) {
        this.setSupportBackgroundTintList(arg1);
    }

    public void setBackgroundTintMode(PorterDuff$Mode arg1) {
        this.setSupportBackgroundTintMode(arg1);
    }

    public void setCheckable(boolean arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setCheckable(arg2);
        }
    }

    public void setChecked(boolean arg3) {
        if((this.isCheckable()) && (this.isEnabled()) && this.checked != arg3) {
            this.checked = arg3;
            this.refreshDrawableState();
            if((this.getParent() instanceof MaterialButtonToggleGroup)) {
                this.getParent().onButtonCheckedStateChanged(this, this.checked);
            }

            if(this.broadcasting) {
                return;
            }

            this.broadcasting = true;
            Iterator v3 = this.onCheckedChangeListeners.iterator();
            while(v3.hasNext()) {
                v3.next().onCheckedChanged(this, this.checked);
            }

            this.broadcasting = false;
        }
    }

    public void setCornerRadius(int arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setCornerRadius(arg2);
        }
    }

    public void setCornerRadiusResource(int arg2) {
        if(this.isUsingOriginalBackground()) {
            this.setCornerRadius(this.getResources().getDimensionPixelSize(arg2));
        }
    }

    public void setElevation(float arg2) {
        super.setElevation(arg2);
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.getMaterialShapeDrawable().setElevation(arg2);
        }
    }

    public void setIcon(Drawable arg2) {
        if(this.icon != arg2) {
            this.icon = arg2;
            this.updateIcon(true);
            this.updateIconPosition(this.getMeasuredWidth(), this.getMeasuredHeight());
        }
    }

    public void setIconGravity(int arg2) {
        if(this.iconGravity != arg2) {
            this.iconGravity = arg2;
            this.updateIconPosition(this.getMeasuredWidth(), this.getMeasuredHeight());
        }
    }

    public void setIconPadding(int arg2) {
        if(this.iconPadding != arg2) {
            this.iconPadding = arg2;
            this.setCompoundDrawablePadding(arg2);
        }
    }

    public void setIconResource(int arg2) {
        Drawable v2 = arg2 != 0 ? AppCompatResources.getDrawable(this.getContext(), arg2) : null;
        this.setIcon(v2);
    }

    public void setIconSize(int arg2) {
        if(arg2 >= 0) {
            if(this.iconSize != arg2) {
                this.iconSize = arg2;
                this.updateIcon(true);
            }

            return;
        }

        throw new IllegalArgumentException("iconSize cannot be less than 0");
    }

    public void setIconTint(ColorStateList arg2) {
        if(this.iconTint != arg2) {
            this.iconTint = arg2;
            this.updateIcon(false);
        }
    }

    public void setIconTintMode(PorterDuff$Mode arg2) {
        if(this.iconTintMode != arg2) {
            this.iconTintMode = arg2;
            this.updateIcon(false);
        }
    }

    public void setIconTintResource(int arg2) {
        this.setIconTint(AppCompatResources.getColorStateList(this.getContext(), arg2));
    }

    public void setInsetBottom(int arg1) {
        this.materialButtonHelper.setInsetBottom(arg1);
    }

    public void setInsetTop(int arg1) {
        this.materialButtonHelper.setInsetTop(arg1);
    }

    void setInternalBackground(Drawable arg1) {
        super.setBackgroundDrawable(arg1);
    }

    void setOnPressedChangeListenerInternal(OnPressedChangeListener arg1) {
        this.onPressedChangeListenerInternal = arg1;
    }

    public void setPressed(boolean arg2) {
        OnPressedChangeListener v0 = this.onPressedChangeListenerInternal;
        if(v0 != null) {
            v0.onPressedChanged(this, arg2);
        }

        super.setPressed(arg2);
    }

    public void setRippleColor(ColorStateList arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setRippleColor(arg2);
        }
    }

    public void setRippleColorResource(int arg2) {
        if(this.isUsingOriginalBackground()) {
            this.setRippleColor(AppCompatResources.getColorStateList(this.getContext(), arg2));
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setShapeAppearanceModel(arg2);
            return;
        }

        throw new IllegalStateException("Attempted to set ShapeAppearanceModel on a MaterialButton which has an overwritten background.");
    }

    void setShouldDrawSurfaceColorStroke(boolean arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setShouldDrawSurfaceColorStroke(arg2);
        }
    }

    public void setStrokeColor(ColorStateList arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeColor(arg2);
        }
    }

    public void setStrokeColorResource(int arg2) {
        if(this.isUsingOriginalBackground()) {
            this.setStrokeColor(AppCompatResources.getColorStateList(this.getContext(), arg2));
        }
    }

    public void setStrokeWidth(int arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setStrokeWidth(arg2);
        }
    }

    public void setStrokeWidthResource(int arg2) {
        if(this.isUsingOriginalBackground()) {
            this.setStrokeWidth(this.getResources().getDimensionPixelSize(arg2));
        }
    }

    public void setSupportBackgroundTintList(ColorStateList arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintList(arg2);
            return;
        }

        super.setSupportBackgroundTintList(arg2);
    }

    public void setSupportBackgroundTintMode(PorterDuff$Mode arg2) {
        if(this.isUsingOriginalBackground()) {
            this.materialButtonHelper.setSupportBackgroundTintMode(arg2);
            return;
        }

        super.setSupportBackgroundTintMode(arg2);
    }

    public void setTextAlignment(int arg2) {
        super.setTextAlignment(arg2);
        this.updateIconPosition(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    public void setToggleCheckedStateOnClick(boolean arg1) {
        this.materialButtonHelper.setToggleCheckedStateOnClick(arg1);
    }

    public void toggle() {
        this.setChecked(this.checked ^ 1);
    }

    private void updateIcon(boolean arg7) {
        Drawable v0 = this.icon;
        if(v0 != null) {
            v0 = DrawableCompat.wrap(v0).mutate();
            this.icon = v0;
            DrawableCompat.setTintList(v0, this.iconTint);
            PorterDuff$Mode v0_1 = this.iconTintMode;
            if(v0_1 != null) {
                DrawableCompat.setTintMode(this.icon, v0_1);
            }

            int v0_2 = this.iconSize;
            if(v0_2 != 0) {
            }
            else {
                v0_2 = this.icon.getIntrinsicWidth();
            }

            int v2 = this.iconSize;
            if(v2 != 0) {
            }
            else {
                v2 = this.icon.getIntrinsicHeight();
            }

            this.icon.setBounds(this.iconLeft, this.iconTop, v0_2 + this.iconLeft, v2 + this.iconTop);
            this.icon.setVisible(true, arg7);
        }

        if(arg7) {
            this.resetIconDrawable();
            return;
        }

        Drawable[] v7 = TextViewCompat.getCompoundDrawablesRelative(((TextView)this));
        v0 = v7[0];
        Drawable v1 = v7[1];
        Drawable v7_1 = v7[2];
        if(!this.isIconStart() || v0 == this.icon) {
            if(!this.isIconEnd() || v7_1 == this.icon) {
                if(!this.isIconTop()) {
                    return;
                }

                if(v1 == this.icon) {
                    return;
                }
            }

        label_51:
            this.resetIconDrawable();
        }
        else {
            goto label_51;
        }
    }

    private void updateIconPosition(int arg6, int arg7) {
        if(this.icon != null) {
            if(this.getLayout() == null) {
            }
            else {
                int v1 = 2;
                if(!this.isIconStart()) {
                    if(this.isIconEnd()) {
                    }
                    else if(this.isIconTop()) {
                        this.iconLeft = 0;
                        if(this.iconGravity == 16) {
                            this.iconTop = 0;
                            this.updateIcon(false);
                            return;
                        }
                        else {
                            arg6 = this.iconSize;
                            if(arg6 == 0) {
                                arg6 = this.icon.getIntrinsicHeight();
                            }

                            arg6 = Math.max(0, (arg7 - this.getTextHeight() - this.getPaddingTop() - arg6 - this.iconPadding - this.getPaddingBottom()) / v1);
                            if(this.iconTop == arg6) {
                                return;
                            }

                            this.iconTop = arg6;
                            this.updateIcon(false);
                            return;
                        }
                    }
                    else {
                        return;
                    }
                }

                this.iconTop = 0;
                Layout$Alignment v7 = this.getActualTextAlignment();
                int v0 = this.iconGravity;
                boolean v3 = true;
                if(v0 != 1 && v0 != 3 && (v0 != v1 || v7 != Layout$Alignment.ALIGN_NORMAL)) {
                    v1 = 4;
                    if(this.iconGravity == v1 && v7 == Layout$Alignment.ALIGN_OPPOSITE) {
                        goto label_85;
                    }

                    v0 = this.iconSize;
                    if(v0 == 0) {
                        v0 = this.icon.getIntrinsicWidth();
                    }

                    arg6 = arg6 - this.getTextLayoutWidth() - ViewCompat.getPaddingEnd(((View)this)) - v0 - this.iconPadding - ViewCompat.getPaddingStart(((View)this));
                    if(v7 == Layout$Alignment.ALIGN_CENTER) {
                        arg6 /= 2;
                    }

                    boolean v7_1 = this.isLayoutRTL();
                    if(this.iconGravity == v1) {
                    }
                    else {
                        v3 = false;
                    }

                    if(v7_1 != v3) {
                        arg6 = -arg6;
                    }

                    if(this.iconLeft == arg6) {
                        return;
                    }

                    this.iconLeft = arg6;
                    this.updateIcon(false);
                    return;
                }

            label_85:
                this.iconLeft = 0;
                this.updateIcon(false);
            }
        }
    }
}

