package com.google.android.material.checkbox;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.AnimatedStateListDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.os.Parcel;
import android.os.Parcelable$Creator;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View$BaseSavedState;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.autofill.AutofillManager;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.TintTypedArray;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.CompoundButtonCompat;
import androidx.core.widget.TintableCompoundButton;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat$AnimationCallback;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class MaterialCheckBox extends AppCompatCheckBox {
    class com.google.android.material.checkbox.MaterialCheckBox$1 extends AnimationCallback {
        com.google.android.material.checkbox.MaterialCheckBox$1(MaterialCheckBox arg1) {
            MaterialCheckBox.this = arg1;
            super();
        }

        public void onAnimationEnd(Drawable arg2) {
            super.onAnimationEnd(arg2);
            if(MaterialCheckBox.this.buttonTintList != null) {
                DrawableCompat.setTintList(arg2, MaterialCheckBox.this.buttonTintList);
            }
        }

        public void onAnimationStart(Drawable arg3) {
            super.onAnimationStart(arg3);
            if(MaterialCheckBox.this.buttonTintList != null) {
                DrawableCompat.setTint(arg3, MaterialCheckBox.this.buttonTintList.getColorForState(MaterialCheckBox.this.currentStateChecked, MaterialCheckBox.this.buttonTintList.getDefaultColor()));
            }
        }
    }

    @Retention(value=RetentionPolicy.SOURCE) @public interface CheckedState {
    }

    public interface OnCheckedStateChangedListener {
        void onCheckedStateChangedListener(MaterialCheckBox arg1, int arg2);
    }

    public interface OnErrorChangedListener {
        void onErrorChanged(MaterialCheckBox arg1, boolean arg2);
    }

    class SavedState extends View$BaseSavedState {
        class com.google.android.material.checkbox.MaterialCheckBox$SavedState$1 implements Parcelable$Creator {
            com.google.android.material.checkbox.MaterialCheckBox$SavedState$1() {
                super();
            }

            public SavedState createFromParcel(Parcel arg2) {
                return new SavedState(arg2, null);
            }

            public Object createFromParcel(Parcel arg1) {
                return this.createFromParcel(arg1);
            }

            public SavedState[] newArray(int arg1) {
                return new SavedState[arg1];
            }

            public Object[] newArray(int arg1) {
                return this.newArray(arg1);
            }
        }

        public static final Parcelable$Creator CREATOR;
        int checkedState;

        static {
            SavedState.CREATOR = new com.google.android.material.checkbox.MaterialCheckBox$SavedState$1();
        }

        SavedState(Parcelable arg1) {
            super(arg1);
        }

        private SavedState(Parcel arg2) {
            super(arg2);
            this.checkedState = arg2.readValue(this.getClass().getClassLoader()).intValue();
        }

        SavedState(Parcel arg1, com.google.android.material.checkbox.MaterialCheckBox$1 arg2) {
            this(arg1);
        }

        private String getCheckedStateString() {
            int v1 = this.checkedState;
            if(v1 != 1) {
                if(v1 != 2) {
                    return "unchecked";
                }

                return "indeterminate";
            }

            return "checked";
        }

        public String toString() {
            return "MaterialCheckBox.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " CheckedState=" + this.getCheckedStateString() + "}";
        }

        public void writeToParcel(Parcel arg1, int arg2) {
            super.writeToParcel(arg1, arg2);
            arg1.writeValue(Integer.valueOf(this.checkedState));
        }
    }

    private static final int[][] CHECKBOX_STATES = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] ERROR_STATE_SET = null;
    private static final int FRAMEWORK_BUTTON_DRAWABLE_RES_ID = 0;
    private static final int[] INDETERMINATE_STATE_SET = null;
    public static final int STATE_CHECKED = 1;
    public static final int STATE_INDETERMINATE = 2;
    public static final int STATE_UNCHECKED;
    private boolean broadcasting;
    private Drawable buttonDrawable;
    private Drawable buttonIconDrawable;
    ColorStateList buttonIconTintList;
    private PorterDuff$Mode buttonIconTintMode;
    ColorStateList buttonTintList;
    private boolean centerIfNoTextEnabled;
    private int checkedState;
    private int[] currentStateChecked;
    private CharSequence customStateDescription;
    private CharSequence errorAccessibilityLabel;
    private boolean errorShown;
    private ColorStateList materialThemeColorsTintList;
    private CompoundButton$OnCheckedChangeListener onCheckedChangeListener;
    private final LinkedHashSet onCheckedStateChangedListeners;
    private final LinkedHashSet onErrorChangedListeners;
    private final AnimatedVectorDrawableCompat transitionToUnchecked;
    private final AnimationCallback transitionToUncheckedCallback;
    private boolean useMaterialThemeColors;
    private boolean usingMaterialButtonDrawable;

    static {
        MaterialCheckBox.DEF_STYLE_RES = style.Widget_MaterialComponents_CompoundButton_CheckBox;
        MaterialCheckBox.INDETERMINATE_STATE_SET = new int[]{attr.state_indeterminate};
        MaterialCheckBox.ERROR_STATE_SET = new int[]{attr.state_error};
        MaterialCheckBox.CHECKBOX_STATES = new int[][]{new int[]{0x101009E, attr.state_error}, new int[]{0x101009E, 0x10100A0}, new int[]{0x101009E, 0xFEFEFF60}, new int[]{0xFEFEFF62, 0x10100A0}, new int[]{0xFEFEFF62, 0xFEFEFF60}};
        MaterialCheckBox.FRAMEWORK_BUTTON_DRAWABLE_RES_ID = Resources.getSystem().getIdentifier("btn_check_material_anim", "drawable", "android");
    }

    public MaterialCheckBox(Context arg2) {
        this(arg2, null);
    }

    public MaterialCheckBox(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.checkboxStyle);
    }

    public MaterialCheckBox(Context arg8, AttributeSet arg9, int arg10) {
        int v4 = MaterialCheckBox.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg8, arg9, arg10, v4), arg9, arg10);
        this.onErrorChangedListeners = new LinkedHashSet();
        this.onCheckedStateChangedListeners = new LinkedHashSet();
        this.transitionToUnchecked = AnimatedVectorDrawableCompat.create(this.getContext(), drawable.mtrl_checkbox_button_checked_unchecked);
        this.transitionToUncheckedCallback = new com.google.android.material.checkbox.MaterialCheckBox$1(this);
        Context v0 = this.getContext();
        this.buttonDrawable = CompoundButtonCompat.getButtonDrawable(((CompoundButton)this));
        this.buttonTintList = this.getSuperButtonTintList();
        ColorStateList v8 = null;
        ((TintableCompoundButton)this).setSupportButtonTintList(v8);
        TintTypedArray v9 = ThemeEnforcement.obtainTintedStyledAttributes(v0, arg9, styleable.MaterialCheckBox, arg10, v4, new int[0]);
        this.buttonIconDrawable = v9.getDrawable(styleable.MaterialCheckBox_buttonIcon);
        if(this.buttonDrawable != null && (ThemeEnforcement.isMaterial3Theme(v0)) && (this.isButtonDrawableLegacy(v9))) {
            super.setButtonDrawable(((Drawable)v8));
            this.buttonDrawable = AppCompatResources.getDrawable(v0, drawable.mtrl_checkbox_button);
            this.usingMaterialButtonDrawable = true;
            if(this.buttonIconDrawable == null) {
                this.buttonIconDrawable = AppCompatResources.getDrawable(v0, drawable.mtrl_checkbox_button_icon);
            }
        }

        this.buttonIconTintList = MaterialResources.getColorStateList(v0, v9, styleable.MaterialCheckBox_buttonIconTint);
        this.buttonIconTintMode = ViewUtils.parseTintMode(v9.getInt(styleable.MaterialCheckBox_buttonIconTintMode, -1), PorterDuff$Mode.SRC_IN);
        this.useMaterialThemeColors = v9.getBoolean(styleable.MaterialCheckBox_useMaterialThemeColors, false);
        this.centerIfNoTextEnabled = v9.getBoolean(styleable.MaterialCheckBox_centerIfNoTextEnabled, true);
        this.errorShown = v9.getBoolean(styleable.MaterialCheckBox_errorShown, false);
        this.errorAccessibilityLabel = v9.getText(styleable.MaterialCheckBox_errorAccessibilityLabel);
        if(v9.hasValue(styleable.MaterialCheckBox_checkedState)) {
            this.setCheckedState(v9.getInt(styleable.MaterialCheckBox_checkedState, 0));
        }

        v9.recycle();
        this.refreshButtonDrawable();
    }

    static int[] access$000(MaterialCheckBox arg0) {
        return arg0.currentStateChecked;
    }

    public void addOnCheckedStateChangedListener(OnCheckedStateChangedListener arg1) {
        this.onCheckedStateChangedListeners.add(arg1);
    }

    public void addOnErrorChangedListener(OnErrorChangedListener arg1) {
        this.onErrorChangedListeners.add(arg1);
    }

    public void clearOnCheckedStateChangedListeners() {
        this.onCheckedStateChangedListeners.clear();
    }

    public void clearOnErrorChangedListeners() {
        this.onErrorChangedListeners.clear();
    }

    public Drawable getButtonDrawable() {
        return this.buttonDrawable;
    }

    public Drawable getButtonIconDrawable() {
        return this.buttonIconDrawable;
    }

    public ColorStateList getButtonIconTintList() {
        return this.buttonIconTintList;
    }

    public PorterDuff$Mode getButtonIconTintMode() {
        return this.buttonIconTintMode;
    }

    private String getButtonStateDescription() {
        int v0 = this.checkedState;
        if(v0 == 1) {
            return this.getResources().getString(string.mtrl_checkbox_state_description_checked);
        }

        if(v0 == 0) {
            return this.getResources().getString(string.mtrl_checkbox_state_description_unchecked);
        }

        return this.getResources().getString(string.mtrl_checkbox_state_description_indeterminate);
    }

    public ColorStateList getButtonTintList() {
        return this.buttonTintList;
    }

    public int getCheckedState() {
        return this.checkedState;
    }

    public CharSequence getErrorAccessibilityLabel() {
        return this.errorAccessibilityLabel;
    }

    private ColorStateList getMaterialThemeColorsTintList() {
        ColorStateList v0 = this.materialThemeColorsTintList;
        if(v0 == null) {
            int[][] v0_1 = MaterialCheckBox.CHECKBOX_STATES;
            int[] v1 = new int[v0_1.length];
            int v2 = MaterialColors.getColor(((View)this), attr.colorControlActivated);
            int v3 = MaterialColors.getColor(((View)this), attr.colorError);
            int v4 = MaterialColors.getColor(((View)this), attr.colorSurface);
            int v5 = MaterialColors.getColor(((View)this), attr.colorOnSurface);
            v1[0] = MaterialColors.layer(v4, v3, 1f);
            v1[1] = MaterialColors.layer(v4, v2, 1f);
            v1[2] = MaterialColors.layer(v4, v5, 0.54f);
            v1[3] = MaterialColors.layer(v4, v5, 0.38f);
            v1[4] = MaterialColors.layer(v4, v5, 0.38f);
            ColorStateList v2_1 = new ColorStateList(v0_1, v1);
            this.materialThemeColorsTintList = v2_1;
            return v2_1;
        }

        return v0;
    }

    private ColorStateList getSuperButtonTintList() {
        ColorStateList v0 = this.buttonTintList;
        if(v0 != null) {
            return v0;
        }

        if(super.getButtonTintList() != null) {
            return super.getButtonTintList();
        }

        return ((TintableCompoundButton)this).getSupportButtonTintList();
    }

    private boolean isButtonDrawableLegacy(TintTypedArray arg3) {
        int v2 = arg3.getResourceId(styleable.MaterialCheckBox_android_button, 0);
        int v3 = arg3.getResourceId(styleable.MaterialCheckBox_buttonCompat, 0);
        if(v2 == MaterialCheckBox.FRAMEWORK_BUTTON_DRAWABLE_RES_ID && v3 == 0) {
            return 1;
        }

        return 0;
    }

    public boolean isCenterIfNoTextEnabled() {
        return this.centerIfNoTextEnabled;
    }

    public boolean isChecked() {
        if(this.checkedState == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isErrorShown() {
        return this.errorShown;
    }

    public boolean isUseMaterialThemeColors() {
        return this.useMaterialThemeColors;
    }

    void lambda$new$0$com-google-android-material-checkbox-MaterialCheckBox() {
        this.buttonIconDrawable.jumpToCurrentState();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if((this.useMaterialThemeColors) && this.buttonTintList == null && this.buttonIconTintList == null) {
            this.setUseMaterialThemeColors(true);
        }
    }

    protected int[] onCreateDrawableState(int arg3) {
        int[] v3 = super.onCreateDrawableState(arg3 + 2);
        if(this.getCheckedState() == 2) {
            MaterialCheckBox.mergeDrawableStates(v3, MaterialCheckBox.INDETERMINATE_STATE_SET);
        }

        if(this.isErrorShown()) {
            MaterialCheckBox.mergeDrawableStates(v3, MaterialCheckBox.ERROR_STATE_SET);
        }

        this.currentStateChecked = DrawableUtils.getCheckedState(v3);
        this.updateIconTintIfNeeded();
        return v3;
    }

    protected void onDraw(Canvas arg6) {
        if((this.centerIfNoTextEnabled) && (TextUtils.isEmpty(this.getText()))) {
            Drawable v0 = CompoundButtonCompat.getButtonDrawable(((CompoundButton)this));
            if(v0 != null) {
                int v1 = ViewUtils.isLayoutRtl(((View)this)) ? -1 : 1;
                int v2 = (this.getWidth() - v0.getIntrinsicWidth()) / 2 * v1;
                v1 = arg6.save();
                arg6.translate(((float)v2), 0f);
                super.onDraw(arg6);
                arg6.restoreToCount(v1);
                if(this.getBackground() != null) {
                    Rect v6 = v0.getBounds();
                    DrawableCompat.setHotspotBounds(this.getBackground(), v6.left + v2, v6.top, v6.right + v2, v6.bottom);
                }

                return;
            }
        }

        super.onDraw(arg6);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg3) {
        super.onInitializeAccessibilityNodeInfo(arg3);
        if(arg3 == null) {
        }
        else if(this.isErrorShown()) {
            arg3.setText(arg3.getText() + ", " + this.errorAccessibilityLabel);
        }
    }

    public void onRestoreInstanceState(Parcelable arg2) {
        if(!(arg2 instanceof SavedState)) {
            super.onRestoreInstanceState(arg2);
            return;
        }

        super.onRestoreInstanceState(((SavedState)arg2).getSuperState());
        this.setCheckedState(((SavedState)arg2).checkedState);
    }

    public Parcelable onSaveInstanceState() {
        SavedState v1 = new SavedState(super.onSaveInstanceState());
        v1.checkedState = this.getCheckedState();
        return ((Parcelable)v1);
    }

    private void refreshButtonDrawable() {
        this.buttonDrawable = DrawableUtils.createTintableMutatedDrawableIfNeeded(this.buttonDrawable, this.buttonTintList, CompoundButtonCompat.getButtonTintMode(((CompoundButton)this)));
        this.buttonIconDrawable = DrawableUtils.createTintableMutatedDrawableIfNeeded(this.buttonIconDrawable, this.buttonIconTintList, this.buttonIconTintMode);
        this.setUpDefaultButtonDrawableAnimationIfNeeded();
        this.updateButtonTints();
        super.setButtonDrawable(DrawableUtils.compositeTwoLayeredDrawable(this.buttonDrawable, this.buttonIconDrawable));
        this.refreshDrawableState();
    }

    public void removeOnCheckedStateChangedListener(OnCheckedStateChangedListener arg1) {
        this.onCheckedStateChangedListeners.remove(arg1);
    }

    public void removeOnErrorChangedListener(OnErrorChangedListener arg1) {
        this.onErrorChangedListeners.remove(arg1);
    }

    public void setButtonDrawable(int arg2) {
        this.setButtonDrawable(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setButtonDrawable(Drawable arg1) {
        this.buttonDrawable = arg1;
        this.usingMaterialButtonDrawable = false;
        this.refreshButtonDrawable();
    }

    public void setButtonIconDrawable(Drawable arg1) {
        this.buttonIconDrawable = arg1;
        this.refreshButtonDrawable();
    }

    public void setButtonIconDrawableResource(int arg2) {
        this.setButtonIconDrawable(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setButtonIconTintList(ColorStateList arg2) {
        if(this.buttonIconTintList == arg2) {
            return;
        }

        this.buttonIconTintList = arg2;
        this.refreshButtonDrawable();
    }

    public void setButtonIconTintMode(PorterDuff$Mode arg2) {
        if(this.buttonIconTintMode == arg2) {
            return;
        }

        this.buttonIconTintMode = arg2;
        this.refreshButtonDrawable();
    }

    public void setButtonTintList(ColorStateList arg2) {
        if(this.buttonTintList == arg2) {
            return;
        }

        this.buttonTintList = arg2;
        this.refreshButtonDrawable();
    }

    public void setButtonTintMode(PorterDuff$Mode arg1) {
        ((TintableCompoundButton)this).setSupportButtonTintMode(arg1);
        this.refreshButtonDrawable();
    }

    public void setCenterIfNoTextEnabled(boolean arg1) {
        this.centerIfNoTextEnabled = arg1;
    }

    public void setChecked(boolean arg1) {
        this.setCheckedState(((int)arg1));
    }

    public void setCheckedState(int arg4) {
        if(this.checkedState != arg4) {
            this.checkedState = arg4;
            boolean v4 = arg4 == 1 ? true : false;
            super.setChecked(v4);
            this.refreshDrawableState();
            this.setDefaultStateDescription();
            if(this.broadcasting) {
                return;
            }

            this.broadcasting = true;
            LinkedHashSet v4_1 = this.onCheckedStateChangedListeners;
            if(v4_1 != null) {
                Iterator v4_2 = v4_1.iterator();
                while(v4_2.hasNext()) {
                    v4_2.next().onCheckedStateChangedListener(this, this.checkedState);
                }
            }

            if(this.checkedState != 2) {
                CompoundButton$OnCheckedChangeListener v4_3 = this.onCheckedChangeListener;
                if(v4_3 != null) {
                    v4_3.onCheckedChanged(((CompoundButton)this), this.isChecked());
                }
            }

            Object v4_4 = this.getContext().getSystemService(AutofillManager.class);
            if(v4_4 != null) {
                ((AutofillManager)v4_4).notifyValueChanged(((View)this));
            }

            this.broadcasting = false;
        }
    }

    private void setDefaultStateDescription() {
        if(Build$VERSION.SDK_INT >= 30 && this.customStateDescription == null) {
            super.setStateDescription(this.getButtonStateDescription());
        }
    }

    public void setEnabled(boolean arg1) {
        super.setEnabled(arg1);
        this.updateIconTintIfNeeded();
    }

    public void setErrorAccessibilityLabel(CharSequence arg1) {
        this.errorAccessibilityLabel = arg1;
    }

    public void setErrorAccessibilityLabelResource(int arg2) {
        CharSequence v2 = arg2 != 0 ? this.getResources().getText(arg2) : null;
        this.setErrorAccessibilityLabel(v2);
    }

    public void setErrorShown(boolean arg3) {
        if(this.errorShown == arg3) {
        }
        else {
            this.errorShown = arg3;
            this.refreshDrawableState();
            Iterator v3 = this.onErrorChangedListeners.iterator();
            while(v3.hasNext()) {
                v3.next().onErrorChanged(this, this.errorShown);
            }
        }
    }

    public void setOnCheckedChangeListener(CompoundButton$OnCheckedChangeListener arg1) {
        this.onCheckedChangeListener = arg1;
    }

    public void setStateDescription(CharSequence arg1) {
        this.customStateDescription = arg1;
        if(arg1 == null) {
            this.setDefaultStateDescription();
            return;
        }

        super.setStateDescription(arg1);
    }

    private void setUpDefaultButtonDrawableAnimationIfNeeded() {
        if(!this.usingMaterialButtonDrawable) {
        }
        else {
            AnimatedVectorDrawableCompat v0 = this.transitionToUnchecked;
            if(v0 != null) {
                v0.unregisterAnimationCallback(this.transitionToUncheckedCallback);
                this.transitionToUnchecked.registerAnimationCallback(this.transitionToUncheckedCallback);
            }

            Drawable v0_1 = this.buttonDrawable;
            if(!(v0_1 instanceof AnimatedStateListDrawable)) {
                return;
            }

            if(this.transitionToUnchecked == null) {
                return;
            }

            ((AnimatedStateListDrawable)v0_1).addTransition(id.checked, id.unchecked, this.transitionToUnchecked, false);
            this.buttonDrawable.addTransition(id.indeterminate, id.unchecked, this.transitionToUnchecked, false);
        }
    }

    public void setUseMaterialThemeColors(boolean arg1) {
        this.useMaterialThemeColors = arg1;
        if(arg1) {
            CompoundButtonCompat.setButtonTintList(((CompoundButton)this), this.getMaterialThemeColorsTintList());
            return;
        }

        CompoundButtonCompat.setButtonTintList(((CompoundButton)this), null);
    }

    public void toggle() {
        this.setChecked(this.isChecked() ^ 1);
    }

    private void updateButtonTints() {
        Drawable v0 = this.buttonDrawable;
        if(v0 != null) {
            ColorStateList v1 = this.buttonTintList;
            if(v1 != null) {
                DrawableCompat.setTintList(v0, v1);
            }
        }

        v0 = this.buttonIconDrawable;
        if(v0 != null) {
            ColorStateList v2 = this.buttonIconTintList;
            if(v2 != null) {
                DrawableCompat.setTintList(v0, v2);
            }
        }
    }

    private void updateIconTintIfNeeded() {
    }
}

