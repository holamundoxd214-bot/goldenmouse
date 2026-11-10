package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Outline;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.PointerIcon;
import android.view.View$OnClickListener;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.CompoundButton$OnCheckedChangeListener;
import android.widget.CompoundButton;
import android.widget.TextView$BufferType;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$AccessibilityActionCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat$CollectionItemInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.google.android.material.R$attr;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.internal.MaterialCheckable$OnCheckedChangeListener;
import com.google.android.material.internal.MaterialCheckable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TextAppearanceFontCallback;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.util.List;

public class Chip extends AppCompatCheckBox implements Delegate, MaterialCheckable, Shapeable {
    class com.google.android.material.chip.Chip$1 extends TextAppearanceFontCallback {
        com.google.android.material.chip.Chip$1(Chip arg1) {
            Chip.this = arg1;
            super();
        }

        public void onFontRetrievalFailed(int arg1) {
        }

        public void onFontRetrieved(Typeface arg2, boolean arg3) {
            Chip v2 = Chip.this;
            arg3 = v2.chipDrawable.shouldDrawText();
            Chip v0 = Chip.this;
            CharSequence v3 = arg3 ? v0.chipDrawable.getText() : v0.getText();
            v2.setText(v3);
            Chip.this.requestLayout();
            Chip.this.invalidate();
        }
    }

    class ChipTouchHelper extends ExploreByTouchHelper {
        ChipTouchHelper(Chip arg1, Chip arg2) {
            Chip.this = arg1;
            super(((View)arg2));
        }

        protected int getVirtualViewAt(float arg2, float arg3) {
            if((Chip.this.hasCloseIcon()) && (Chip.this.getCloseIconTouchBounds().contains(arg2, arg3))) {
                return 1;
            }

            return 0;
        }

        protected void getVisibleVirtualViews(List arg2) {
            arg2.add(Integer.valueOf(0));
            if((Chip.this.hasCloseIcon()) && (Chip.this.isCloseIconVisible()) && Chip.this.onCloseIconClickListener != null) {
                arg2.add(Integer.valueOf(1));
            }
        }

        protected boolean onPerformActionForVirtualView(int arg1, int arg2, Bundle arg3) {
            if(arg2 == 16) {
                if(arg1 == 0) {
                    return Chip.this.performClick();
                }
                else if(arg1 == 1) {
                    return Chip.this.performCloseIconClick();
                }
            }

            return 0;
        }

        protected void onPopulateNodeForHost(AccessibilityNodeInfoCompat arg2) {
            arg2.setCheckable(Chip.this.isCheckable());
            arg2.setClickable(Chip.this.isClickable());
            arg2.setClassName(Chip.this.getAccessibilityClassName());
            arg2.setText(Chip.this.getText());
        }

        protected void onPopulateNodeForVirtualView(int arg5, AccessibilityNodeInfoCompat arg6) {
            CharSequence v1_1;
            String v1 = "";
            if(arg5 == 1) {
                CharSequence v5 = Chip.this.getCloseIconContentDescription();
                if(v5 != null) {
                    arg6.setContentDescription(v5);
                }
                else {
                    v5 = Chip.this.getText();
                    Context v0 = Chip.this.getContext();
                    int v2 = string.mtrl_chip_close_icon_content_description;
                    if(!TextUtils.isEmpty(v5)) {
                        v1_1 = v5;
                    }

                    arg6.setContentDescription(v0.getString(v2, new Object[]{v1_1}).trim());
                }

                arg6.setBoundsInParent(Chip.this.getCloseIconTouchBoundsInt());
                arg6.addAction(AccessibilityActionCompat.ACTION_CLICK);
                arg6.setEnabled(Chip.this.isEnabled());
                return;
            }

            arg6.setContentDescription(((CharSequence)v1));
            arg6.setBoundsInParent(Chip.EMPTY_BOUNDS);
        }

        protected void onVirtualViewKeyboardFocusChanged(int arg2, boolean arg3) {
            if(arg2 == 1) {
                Chip.this.closeIconFocused = arg3;
                Chip.this.refreshDrawableState();
            }
        }
    }

    private static final String BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.Button";
    private static final int[] CHECKABLE_STATE_SET = null;
    private static final int CHIP_BODY_VIRTUAL_ID = 0;
    private static final int CLOSE_ICON_VIRTUAL_ID = 1;
    private static final int DEF_STYLE_RES = 0;
    private static final Rect EMPTY_BOUNDS = null;
    private static final String GENERIC_VIEW_ACCESSIBILITY_CLASS_NAME = "android.view.View";
    private static final int MIN_TOUCH_TARGET_DP = 0x30;
    private static final String NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private static final String RADIO_BUTTON_ACCESSIBILITY_CLASS_NAME = "android.widget.RadioButton";
    private static final int[] SELECTED_STATE = null;
    private static final String TAG = "Chip";
    private CharSequence accessibilityClassName;
    private ChipDrawable chipDrawable;
    private boolean closeIconFocused;
    private boolean closeIconHovered;
    private boolean closeIconPressed;
    private boolean deferredCheckedValue;
    private boolean ensureMinTouchTargetSize;
    private final TextAppearanceFontCallback fontCallback;
    private InsetDrawable insetBackgroundDrawable;
    private int lastLayoutDirection;
    private int minTouchTargetSize;
    private CompoundButton$OnCheckedChangeListener onCheckedChangeListener;
    private OnCheckedChangeListener onCheckedChangeListenerInternal;
    private View$OnClickListener onCloseIconClickListener;
    private final Rect rect;
    private final RectF rectF;
    private RippleDrawable ripple;
    private final ChipTouchHelper touchHelper;
    private boolean touchHelperEnabled;

    static {
        Chip.DEF_STYLE_RES = style.Widget_MaterialComponents_Chip_Action;
        Chip.EMPTY_BOUNDS = new Rect();
        Chip.SELECTED_STATE = new int[]{0x10100A1};
        Chip.CHECKABLE_STATE_SET = new int[]{0x101009F};
    }

    public Chip(Context arg2) {
        this(arg2, null);
    }

    public Chip(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.chipStyle);
    }

    public Chip(Context arg7, AttributeSet arg8, int arg9) {
        int v4 = Chip.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg7, arg8, arg9, v4), arg8, arg9);
        this.rect = new Rect();
        this.rectF = new RectF();
        this.fontCallback = new com.google.android.material.chip.Chip$1(this);
        Context v0 = this.getContext();
        this.validateAttributes(arg8);
        ChipDrawable v7 = ChipDrawable.createFromAttributes(v0, arg8, arg9, v4);
        this.initMinTouchTarget(v0, arg8, arg9);
        this.setChipDrawable(v7);
        v7.setElevation(ViewCompat.getElevation(((View)this)));
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(v0, arg8, styleable.Chip, arg9, v4, new int[0]);
        boolean v9 = v8.hasValue(styleable.Chip_shapeAppearance);
        v8.recycle();
        this.touchHelper = new ChipTouchHelper(this, this);
        this.updateAccessibilityDelegate();
        if(!v9) {
            this.initOutlineProvider();
        }

        this.setChecked(this.deferredCheckedValue);
        this.setText(v7.getText());
        this.setEllipsize(v7.getEllipsize());
        this.updateTextPaintDrawState();
        if(!this.chipDrawable.shouldDrawText()) {
            this.setLines(1);
            this.setHorizontallyScrolling(true);
        }

        this.setGravity(0x800013);
        this.updatePaddingInternal();
        if(this.shouldEnsureMinTouchTargetSize()) {
            this.setMinHeight(this.minTouchTargetSize);
        }

        this.lastLayoutDirection = ViewCompat.getLayoutDirection(((View)this));
        super.setOnCheckedChangeListener(new Chip$$ExternalSyntheticLambda0(this));
    }

    static ChipDrawable access$000(Chip arg0) {
        return arg0.chipDrawable;
    }

    static boolean access$100(Chip arg0) {
        return arg0.hasCloseIcon();
    }

    static RectF access$200(Chip arg0) {
        return arg0.getCloseIconTouchBounds();
    }

    static View$OnClickListener access$300(Chip arg0) {
        return arg0.onCloseIconClickListener;
    }

    static boolean access$402(Chip arg0, boolean arg1) {
        arg0.closeIconFocused = arg1;
        return arg1;
    }

    static Rect access$500(Chip arg0) {
        return arg0.getCloseIconTouchBoundsInt();
    }

    static Rect access$600() {
        return Chip.EMPTY_BOUNDS;
    }

    private void applyChipDrawable(ChipDrawable arg1) {
        arg1.setDelegate(((Delegate)this));
    }

    private int[] createCloseIconDrawableState() {
        int v0_1;
        boolean v0 = this.isEnabled();
        if(this.closeIconFocused) {
            v0_1 = (((int)v0)) + 1;
        }

        if(this.closeIconHovered) {
            v0_1 = (((int)v0)) + 1;
        }

        if(this.closeIconPressed) {
            v0_1 = (((int)v0)) + 1;
        }

        if(this.isChecked()) {
            v0_1 = (((int)v0)) + 1;
        }

        int[] v0_2 = new int[((int)v0)];
        int v2 = 0;
        if(this.isEnabled()) {
            v0_2[0] = 0x101009E;
            v2 = 1;
        }

        if(this.closeIconFocused) {
            v0_2[v2] = 0x101009C;
            ++v2;
        }

        if(this.closeIconHovered) {
            v0_2[v2] = 0x1010367;
            ++v2;
        }

        if(this.closeIconPressed) {
            v0_2[v2] = 0x10100A7;
            ++v2;
        }

        if(this.isChecked()) {
            v0_2[v2] = 0x10100A1;
        }

        return v0_2;
    }

    protected boolean dispatchHoverEvent(MotionEvent arg2) {
        if(!this.touchHelperEnabled) {
            return super.dispatchHoverEvent(arg2);
        }

        if(!this.touchHelper.dispatchHoverEvent(arg2)) {
            if(super.dispatchHoverEvent(arg2)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean dispatchKeyEvent(KeyEvent arg3) {
        if(!this.touchHelperEnabled) {
            return super.dispatchKeyEvent(arg3);
        }

        if((this.touchHelper.dispatchKeyEvent(arg3)) && this.touchHelper.getKeyboardFocusedVirtualViewId() != 0x80000000) {
            return 1;
        }

        return super.dispatchKeyEvent(arg3);
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        ChipDrawable v0 = this.chipDrawable;
        boolean v0_1 = v0 == null || !v0.isCloseIconStateful() ? false : this.chipDrawable.setCloseIconState(this.createCloseIconDrawableState());
        if(v0_1) {
            this.invalidate();
        }
    }

    public boolean ensureAccessibleTouchTarget(int arg6) {
        this.minTouchTargetSize = arg6;
        int v1 = 0;
        if(!this.shouldEnsureMinTouchTargetSize()) {
            if(this.insetBackgroundDrawable != null) {
                this.removeBackgroundInset();
            }
            else {
                this.updateBackgroundDrawable();
            }

            return 0;
        }

        int v0 = Math.max(0, arg6 - this.chipDrawable.getIntrinsicHeight());
        int v2 = Math.max(0, arg6 - this.chipDrawable.getIntrinsicWidth());
        if(v2 <= 0 && v0 <= 0) {
            if(this.insetBackgroundDrawable != null) {
                this.removeBackgroundInset();
            }
            else {
                this.updateBackgroundDrawable();
            }

            return 0;
        }

        if(v2 > 0) {
            v2 /= 2;
        }
        else {
            v2 = 0;
        }

        if(v0 > 0) {
            v1 = v0 / 2;
        }

        if(this.insetBackgroundDrawable != null) {
            Rect v0_1 = new Rect();
            this.insetBackgroundDrawable.getPadding(v0_1);
            if(v0_1.top == v1 && v0_1.bottom == v1 && v0_1.left == v2 && v0_1.right == v2) {
                this.updateBackgroundDrawable();
                return 1;
            }
        }

        if(this.getMinHeight() != arg6) {
            this.setMinHeight(arg6);
        }

        if(this.getMinWidth() != arg6) {
            this.setMinWidth(arg6);
        }

        this.insetChipBackgroundDrawable(v2, v1, v2, v1);
        this.updateBackgroundDrawable();
        return 1;
    }

    private void ensureChipDrawableHasCallback() {
        if(this.getBackgroundDrawable() == this.insetBackgroundDrawable && this.chipDrawable.getCallback() == null) {
            this.chipDrawable.setCallback(this.insetBackgroundDrawable);
        }
    }

    public CharSequence getAccessibilityClassName() {
        if(!TextUtils.isEmpty(this.accessibilityClassName)) {
            return this.accessibilityClassName;
        }

        String v1 = "android.widget.Button";
        if(this.isCheckable()) {
            ViewParent v2 = this.getParent();
            if(((v2 instanceof ChipGroup)) && (((ChipGroup)v2).isSingleSelection())) {
                return "android.widget.RadioButton";
            }

            return ((CharSequence)v1);
        }

        if(this.isClickable()) {
            return ((CharSequence)v1);
        }

        return "android.view.View";
    }

    public Drawable getBackgroundDrawable() {
        InsetDrawable v0 = this.insetBackgroundDrawable;
        if(v0 == null) {
            return this.chipDrawable;
        }

        return ((Drawable)v0);
    }

    public Drawable getCheckedIcon() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getCheckedIcon();
        }

        return null;
    }

    public ColorStateList getCheckedIconTint() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getCheckedIconTint();
        }

        return null;
    }

    public ColorStateList getChipBackgroundColor() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getChipBackgroundColor();
        }

        return null;
    }

    public float getChipCornerRadius() {
        ChipDrawable v1 = this.chipDrawable;
        if(v1 != null) {
            return Math.max(0f, v1.getChipCornerRadius());
        }

        return 0;
    }

    public Drawable getChipDrawable() {
        return this.chipDrawable;
    }

    public float getChipEndPadding() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getChipEndPadding();
        }

        return 0;
    }

    public Drawable getChipIcon() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getChipIcon();
        }

        return null;
    }

    public float getChipIconSize() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getChipIconSize();
        }

        return 0;
    }

    public ColorStateList getChipIconTint() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getChipIconTint();
        }

        return null;
    }

    public float getChipMinHeight() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getChipMinHeight();
        }

        return 0;
    }

    public float getChipStartPadding() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getChipStartPadding();
        }

        return 0;
    }

    public ColorStateList getChipStrokeColor() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getChipStrokeColor();
        }

        return null;
    }

    public float getChipStrokeWidth() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getChipStrokeWidth();
        }

        return 0;
    }

    @Deprecated public CharSequence getChipText() {
        return this.getText();
    }

    public Drawable getCloseIcon() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getCloseIcon();
        }

        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getCloseIconContentDescription();
        }

        return null;
    }

    public float getCloseIconEndPadding() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getCloseIconEndPadding();
        }

        return 0;
    }

    public float getCloseIconSize() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getCloseIconSize();
        }

        return 0;
    }

    public float getCloseIconStartPadding() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getCloseIconStartPadding();
        }

        return 0;
    }

    public ColorStateList getCloseIconTint() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getCloseIconTint();
        }

        return null;
    }

    private RectF getCloseIconTouchBounds() {
        this.rectF.setEmpty();
        if((this.hasCloseIcon()) && this.onCloseIconClickListener != null) {
            this.chipDrawable.getCloseIconTouchBounds(this.rectF);
        }

        return this.rectF;
    }

    private Rect getCloseIconTouchBoundsInt() {
        RectF v0 = this.getCloseIconTouchBounds();
        this.rect.set(((int)v0.left), ((int)v0.top), ((int)v0.right), ((int)v0.bottom));
        return this.rect;
    }

    public TextUtils$TruncateAt getEllipsize() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getEllipsize();
        }

        return null;
    }

    public void getFocusedRect(Rect arg3) {
        if((this.touchHelperEnabled) && (this.touchHelper.getKeyboardFocusedVirtualViewId() == 1 || this.touchHelper.getAccessibilityFocusedVirtualViewId() == 1)) {
            arg3.set(this.getCloseIconTouchBoundsInt());
            return;
        }

        super.getFocusedRect(arg3);
    }

    public MotionSpec getHideMotionSpec() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getHideMotionSpec();
        }

        return null;
    }

    public float getIconEndPadding() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getIconEndPadding();
        }

        return 0;
    }

    public float getIconStartPadding() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getIconStartPadding();
        }

        return 0;
    }

    public ColorStateList getRippleColor() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getRippleColor();
        }

        return null;
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.chipDrawable.getShapeAppearanceModel();
    }

    public MotionSpec getShowMotionSpec() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getShowMotionSpec();
        }

        return null;
    }

    private TextAppearance getTextAppearance() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getTextAppearance();
        }

        return null;
    }

    public float getTextEndPadding() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getTextEndPadding();
        }

        return 0;
    }

    public float getTextStartPadding() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            return v0.getTextStartPadding();
        }

        return 0;
    }

    private boolean hasCloseIcon() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null && v0.getCloseIcon() != null) {
            return 1;
        }

        return 0;
    }

    private void initMinTouchTarget(Context arg8, AttributeSet arg9, int arg10) {
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(arg8, arg9, styleable.Chip, arg10, Chip.DEF_STYLE_RES, new int[0]);
        this.ensureMinTouchTargetSize = v8.getBoolean(styleable.Chip_ensureMinTouchTargetSize, false);
        this.minTouchTargetSize = ((int)Math.ceil(((double)v8.getDimension(styleable.Chip_chipMinTouchTargetSize, ((float)Math.ceil(((double)ViewUtils.dpToPx(this.getContext(), 0x30))))))));
        v8.recycle();
    }

    private void initOutlineProvider() {
        this.setOutlineProvider(new ViewOutlineProvider() {
            public void getOutline(View arg1, Outline arg2) {
                if(Chip.this.chipDrawable != null) {
                    Chip.this.chipDrawable.getOutline(arg2);
                    return;
                }

                arg2.setAlpha(0f);
            }
        });
    }

    private void insetChipBackgroundDrawable(int arg7, int arg8, int arg9, int arg10) {
        this.insetBackgroundDrawable = new InsetDrawable(this.chipDrawable, arg7, arg8, arg9, arg10);
    }

    public boolean isCheckable() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null && (v0.isCheckable())) {
            return 1;
        }

        return 0;
    }

    @Deprecated public boolean isCheckedIconEnabled() {
        return this.isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null && (v0.isCheckedIconVisible())) {
            return 1;
        }

        return 0;
    }

    @Deprecated public boolean isChipIconEnabled() {
        return this.isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null && (v0.isChipIconVisible())) {
            return 1;
        }

        return 0;
    }

    @Deprecated public boolean isCloseIconEnabled() {
        return this.isCloseIconVisible();
    }

    public boolean isCloseIconVisible() {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null && (v0.isCloseIconVisible())) {
            return 1;
        }

        return 0;
    }

    void lambda$new$0$com-google-android-material-chip-Chip(CompoundButton arg2, boolean arg3) {
        OnCheckedChangeListener v0 = this.onCheckedChangeListenerInternal;
        if(v0 != null) {
            v0.onCheckedChanged(this, arg3);
        }

        CompoundButton$OnCheckedChangeListener v1 = this.onCheckedChangeListener;
        if(v1 != null) {
            v1.onCheckedChanged(arg2, arg3);
        }
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this), this.chipDrawable);
    }

    public void onChipDrawableSizeChange() {
        this.ensureAccessibleTouchTarget(this.minTouchTargetSize);
        this.requestLayout();
        this.invalidateOutline();
    }

    protected int[] onCreateDrawableState(int arg2) {
        int[] v2 = super.onCreateDrawableState(arg2 + 2);
        if(this.isChecked()) {
            Chip.mergeDrawableStates(v2, Chip.SELECTED_STATE);
        }

        if(this.isCheckable()) {
            Chip.mergeDrawableStates(v2, Chip.CHECKABLE_STATE_SET);
        }

        return v2;
    }

    protected void onFocusChanged(boolean arg2, int arg3, Rect arg4) {
        super.onFocusChanged(arg2, arg3, arg4);
        if(this.touchHelperEnabled) {
            this.touchHelper.onFocusChanged(arg2, arg3, arg4);
        }
    }

    public boolean onHoverEvent(MotionEvent arg4) {
        int v0 = arg4.getActionMasked();
        if(v0 == 7) {
            this.setCloseIconHovered(this.getCloseIconTouchBounds().contains(arg4.getX(), arg4.getY()));
        }
        else if(v0 != 10) {
        }
        else {
            this.setCloseIconHovered(false);
        }

        return super.onHoverEvent(arg4);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg9) {
        super.onInitializeAccessibilityNodeInfo(arg9);
        arg9.setClassName(this.getAccessibilityClassName());
        arg9.setCheckable(this.isCheckable());
        arg9.setClickable(this.isClickable());
        if((this.getParent() instanceof ChipGroup)) {
            ViewParent v0 = this.getParent();
            AccessibilityNodeInfoCompat v9 = AccessibilityNodeInfoCompat.wrap(arg9);
            int v1 = ((ChipGroup)v0).isSingleLine() ? ((ChipGroup)v0).getIndexOfChip(((View)this)) : -1;
            v9.setCollectionItemInfo(CollectionItemInfoCompat.obtain(((ChipGroup)v0).getRowIndex(((View)this)), 1, v1, 1, false, this.isChecked()));
        }
    }

    public PointerIcon onResolvePointerIcon(MotionEvent arg4, int arg5) {
        if((this.getCloseIconTouchBounds().contains(arg4.getX(), arg4.getY())) && (this.isEnabled())) {
            return PointerIcon.getSystemIcon(this.getContext(), 1002);
        }

        return super.onResolvePointerIcon(arg4, arg5);
    }

    public void onRtlPropertiesChanged(int arg2) {
        super.onRtlPropertiesChanged(arg2);
        if(this.lastLayoutDirection != arg2) {
            this.lastLayoutDirection = arg2;
            this.updatePaddingInternal();
        }
    }

    public boolean onTouchEvent(MotionEvent arg6) {
        int v0 = arg6.getActionMasked();
        boolean v1 = this.getCloseIconTouchBounds().contains(arg6.getX(), arg6.getY());
        if(v0 != 0) {
            if(v0 != 1) {
                if(v0 != 2) {
                    if(v0 != 3) {
                        goto label_31;
                    }
                    else {
                        goto label_24;
                    }
                }
                else if(this.closeIconPressed) {
                    if(!v1) {
                        this.setCloseIconPressed(false);
                    }
                    else {
                    }

                    goto label_29;
                }
                else {
                    goto label_31;
                }
            }
            else if(this.closeIconPressed) {
                this.performCloseIconClick();
                v0 = 1;
            }
            else {
            label_24:
                v0 = 0;
            }

            this.setCloseIconPressed(false);
        }
        else {
            if(v1) {
                this.setCloseIconPressed(true);
            label_29:
                v0 = 1;
                goto label_32;
            }

        label_31:
            v0 = 0;
        }

    label_32:
        if(v0 == 0) {
            if(super.onTouchEvent(arg6)) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean performCloseIconClick() {
        boolean v0 = false;
        this.playSoundEffect(0);
        View$OnClickListener v1 = this.onCloseIconClickListener;
        if(v1 != null) {
            v1.onClick(((View)this));
            v0 = true;
        }

        if(this.touchHelperEnabled) {
            this.touchHelper.sendEventForVirtualView(1, 1);
        }

        return v0;
    }

    private void removeBackgroundInset() {
        if(this.insetBackgroundDrawable != null) {
            this.insetBackgroundDrawable = null;
            this.setMinWidth(0);
            this.setMinHeight(((int)this.getChipMinHeight()));
            this.updateBackgroundDrawable();
        }
    }

    public void setAccessibilityClassName(CharSequence arg1) {
        this.accessibilityClassName = arg1;
    }

    public void setBackground(Drawable arg2) {
        if(arg2 != this.getBackgroundDrawable() && arg2 != this.ripple) {
            Log.w("Chip", "Do not set the background; Chip manages its own background drawable.");
            return;
        }

        super.setBackground(arg2);
    }

    public void setBackgroundColor(int arg1) {
        Log.w("Chip", "Do not set the background color; Chip manages its own background drawable.");
    }

    public void setBackgroundDrawable(Drawable arg2) {
        if(arg2 != this.getBackgroundDrawable() && arg2 != this.ripple) {
            Log.w("Chip", "Do not set the background drawable; Chip manages its own background drawable.");
            return;
        }

        super.setBackgroundDrawable(arg2);
    }

    public void setBackgroundResource(int arg1) {
        Log.w("Chip", "Do not set the background resource; Chip manages its own background drawable.");
    }

    public void setBackgroundTintList(ColorStateList arg1) {
        Log.w("Chip", "Do not set the background tint list; Chip manages its own background drawable.");
    }

    public void setBackgroundTintMode(PorterDuff$Mode arg1) {
        Log.w("Chip", "Do not set the background tint mode; Chip manages its own background drawable.");
    }

    public void setCheckable(boolean arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCheckable(arg1);
        }
    }

    public void setCheckableResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCheckableResource(arg1);
        }
    }

    public void setChecked(boolean arg2) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 == null) {
            this.deferredCheckedValue = arg2;
            return;
        }

        if(v0.isCheckable()) {
            super.setChecked(arg2);
        }
    }

    public void setCheckedIcon(Drawable arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCheckedIcon(arg1);
        }
    }

    @Deprecated public void setCheckedIconEnabled(boolean arg1) {
        this.setCheckedIconVisible(arg1);
    }

    @Deprecated public void setCheckedIconEnabledResource(int arg1) {
        this.setCheckedIconVisible(arg1);
    }

    public void setCheckedIconResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCheckedIconResource(arg1);
        }
    }

    public void setCheckedIconTint(ColorStateList arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCheckedIconTint(arg1);
        }
    }

    public void setCheckedIconTintResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCheckedIconTintResource(arg1);
        }
    }

    public void setCheckedIconVisible(boolean arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCheckedIconVisible(arg1);
        }
    }

    public void setCheckedIconVisible(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCheckedIconVisible(arg1);
        }
    }

    public void setChipBackgroundColor(ColorStateList arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipBackgroundColor(arg1);
        }
    }

    public void setChipBackgroundColorResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipBackgroundColorResource(arg1);
        }
    }

    @Deprecated public void setChipCornerRadius(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipCornerRadius(arg1);
        }
    }

    @Deprecated public void setChipCornerRadiusResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipCornerRadiusResource(arg1);
        }
    }

    public void setChipDrawable(ChipDrawable arg2) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != arg2) {
            this.unapplyChipDrawable(v0);
            this.chipDrawable = arg2;
            arg2.setShouldDrawText(false);
            this.applyChipDrawable(this.chipDrawable);
            this.ensureAccessibleTouchTarget(this.minTouchTargetSize);
        }
    }

    public void setChipEndPadding(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipEndPadding(arg1);
        }
    }

    public void setChipEndPaddingResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipEndPaddingResource(arg1);
        }
    }

    public void setChipIcon(Drawable arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipIcon(arg1);
        }
    }

    @Deprecated public void setChipIconEnabled(boolean arg1) {
        this.setChipIconVisible(arg1);
    }

    @Deprecated public void setChipIconEnabledResource(int arg1) {
        this.setChipIconVisible(arg1);
    }

    public void setChipIconResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipIconResource(arg1);
        }
    }

    public void setChipIconSize(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipIconSize(arg1);
        }
    }

    public void setChipIconSizeResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipIconSizeResource(arg1);
        }
    }

    public void setChipIconTint(ColorStateList arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipIconTint(arg1);
        }
    }

    public void setChipIconTintResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipIconTintResource(arg1);
        }
    }

    public void setChipIconVisible(boolean arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipIconVisible(arg1);
        }
    }

    public void setChipIconVisible(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipIconVisible(arg1);
        }
    }

    public void setChipMinHeight(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipMinHeight(arg1);
        }
    }

    public void setChipMinHeightResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipMinHeightResource(arg1);
        }
    }

    public void setChipStartPadding(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipStartPadding(arg1);
        }
    }

    public void setChipStartPaddingResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipStartPaddingResource(arg1);
        }
    }

    public void setChipStrokeColor(ColorStateList arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipStrokeColor(arg1);
        }
    }

    public void setChipStrokeColorResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipStrokeColorResource(arg1);
        }
    }

    public void setChipStrokeWidth(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipStrokeWidth(arg1);
        }
    }

    public void setChipStrokeWidthResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setChipStrokeWidthResource(arg1);
        }
    }

    @Deprecated public void setChipText(CharSequence arg1) {
        this.setText(arg1);
    }

    @Deprecated public void setChipTextResource(int arg2) {
        this.setText(this.getResources().getString(arg2));
    }

    public void setCloseIcon(Drawable arg2) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIcon(arg2);
        }

        this.updateAccessibilityDelegate();
    }

    public void setCloseIconContentDescription(CharSequence arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconContentDescription(arg1);
        }
    }

    @Deprecated public void setCloseIconEnabled(boolean arg1) {
        this.setCloseIconVisible(arg1);
    }

    @Deprecated public void setCloseIconEnabledResource(int arg1) {
        this.setCloseIconVisible(arg1);
    }

    public void setCloseIconEndPadding(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconEndPadding(arg1);
        }
    }

    public void setCloseIconEndPaddingResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconEndPaddingResource(arg1);
        }
    }

    private void setCloseIconHovered(boolean arg2) {
        if(this.closeIconHovered != arg2) {
            this.closeIconHovered = arg2;
            this.refreshDrawableState();
        }
    }

    private void setCloseIconPressed(boolean arg2) {
        if(this.closeIconPressed != arg2) {
            this.closeIconPressed = arg2;
            this.refreshDrawableState();
        }
    }

    public void setCloseIconResource(int arg2) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconResource(arg2);
        }

        this.updateAccessibilityDelegate();
    }

    public void setCloseIconSize(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconSize(arg1);
        }
    }

    public void setCloseIconSizeResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconSizeResource(arg1);
        }
    }

    public void setCloseIconStartPadding(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconStartPadding(arg1);
        }
    }

    public void setCloseIconStartPaddingResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconStartPaddingResource(arg1);
        }
    }

    public void setCloseIconTint(ColorStateList arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconTint(arg1);
        }
    }

    public void setCloseIconTintResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconTintResource(arg1);
        }
    }

    public void setCloseIconVisible(boolean arg2) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setCloseIconVisible(arg2);
        }

        this.updateAccessibilityDelegate();
    }

    public void setCloseIconVisible(int arg2) {
        this.setCloseIconVisible(this.getResources().getBoolean(arg2));
    }

    public void setCompoundDrawables(Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        if(arg1 == null) {
            if(arg3 == null) {
                super.setCompoundDrawables(arg1, arg2, arg3, arg4);
                return;
            }

            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }

        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    public void setCompoundDrawablesRelative(Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        if(arg1 == null) {
            if(arg3 == null) {
                super.setCompoundDrawablesRelative(arg1, arg2, arg3, arg4);
                return;
            }

            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }

        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(int arg1, int arg2, int arg3, int arg4) {
        if(arg1 == 0) {
            if(arg3 == 0) {
                super.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4);
                return;
            }

            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }

        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    public void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        if(arg1 == null) {
            if(arg3 == null) {
                super.setCompoundDrawablesRelativeWithIntrinsicBounds(arg1, arg2, arg3, arg4);
                return;
            }

            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }

        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    public void setCompoundDrawablesWithIntrinsicBounds(int arg1, int arg2, int arg3, int arg4) {
        if(arg1 == 0) {
            if(arg3 == 0) {
                super.setCompoundDrawablesWithIntrinsicBounds(arg1, arg2, arg3, arg4);
                return;
            }

            throw new UnsupportedOperationException("Please set end drawable using R.attr#closeIcon.");
        }

        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    }

    public void setCompoundDrawablesWithIntrinsicBounds(Drawable arg1, Drawable arg2, Drawable arg3, Drawable arg4) {
        if(arg1 == null) {
            if(arg3 == null) {
                super.setCompoundDrawablesWithIntrinsicBounds(arg1, arg2, arg3, arg4);
                return;
            }

            throw new UnsupportedOperationException("Please set right drawable using R.attr#closeIcon.");
        }

        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }

    public void setElevation(float arg1) {
        super.setElevation(arg1);
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setElevation(arg1);
        }
    }

    public void setEllipsize(TextUtils$TruncateAt arg2) {
        if(this.chipDrawable == null) {
        }
        else if(arg2 != TextUtils$TruncateAt.MARQUEE) {
            super.setEllipsize(arg2);
            ChipDrawable v1 = this.chipDrawable;
            if(v1 != null) {
                v1.setEllipsize(arg2);
            }
        }
        else {
            goto label_10;
        }

        return;
    label_10:
        throw new UnsupportedOperationException("Text within a chip are not allowed to scroll.");
    }

    public void setEnsureMinTouchTargetSize(boolean arg1) {
        this.ensureMinTouchTargetSize = arg1;
        this.ensureAccessibleTouchTarget(this.minTouchTargetSize);
    }

    public void setGravity(int arg2) {
        if(arg2 != 0x800013) {
            Log.w("Chip", "Chip text must be vertically center and start aligned");
            return;
        }

        super.setGravity(arg2);
    }

    public void setHideMotionSpec(MotionSpec arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setHideMotionSpec(arg1);
        }
    }

    public void setHideMotionSpecResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setHideMotionSpecResource(arg1);
        }
    }

    public void setIconEndPadding(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setIconEndPadding(arg1);
        }
    }

    public void setIconEndPaddingResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setIconEndPaddingResource(arg1);
        }
    }

    public void setIconStartPadding(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setIconStartPadding(arg1);
        }
    }

    public void setIconStartPaddingResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setIconStartPaddingResource(arg1);
        }
    }

    public void setInternalOnCheckedChangeListener(OnCheckedChangeListener arg1) {
        this.onCheckedChangeListenerInternal = arg1;
    }

    public void setLayoutDirection(int arg2) {
        if(this.chipDrawable == null) {
            return;
        }

        super.setLayoutDirection(arg2);
    }

    public void setLines(int arg2) {
        if(arg2 <= 1) {
            super.setLines(arg2);
            return;
        }

        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxLines(int arg2) {
        if(arg2 <= 1) {
            super.setMaxLines(arg2);
            return;
        }

        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setMaxWidth(int arg1) {
        super.setMaxWidth(arg1);
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setMaxWidth(arg1);
        }
    }

    public void setMinLines(int arg2) {
        if(arg2 <= 1) {
            super.setMinLines(arg2);
            return;
        }

        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setOnCheckedChangeListener(CompoundButton$OnCheckedChangeListener arg1) {
        this.onCheckedChangeListener = arg1;
    }

    public void setOnCloseIconClickListener(View$OnClickListener arg1) {
        this.onCloseIconClickListener = arg1;
        this.updateAccessibilityDelegate();
    }

    public void setRippleColor(ColorStateList arg2) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setRippleColor(arg2);
        }

        if(!this.chipDrawable.getUseCompatRipple()) {
            this.updateFrameworkRippleBackground();
        }
    }

    public void setRippleColorResource(int arg2) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setRippleColorResource(arg2);
            if(!this.chipDrawable.getUseCompatRipple()) {
                this.updateFrameworkRippleBackground();
            }
        }
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg1) {
        this.chipDrawable.setShapeAppearanceModel(arg1);
    }

    public void setShowMotionSpec(MotionSpec arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setShowMotionSpec(arg1);
        }
    }

    public void setShowMotionSpecResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setShowMotionSpecResource(arg1);
        }
    }

    public void setSingleLine(boolean arg1) {
        if(arg1) {
            super.setSingleLine(arg1);
            return;
        }

        throw new UnsupportedOperationException("Chip does not support multi-line text");
    }

    public void setText(CharSequence arg2, TextView$BufferType arg3) {
        String v2;
        ChipDrawable v0 = this.chipDrawable;
        if(v0 == null) {
        }
        else {
            if(arg2 == null) {
                v2 = "";
            }

            CharSequence v0_1 = v0.shouldDrawText() ? null : ((CharSequence)v2);
            super.setText(v0_1, arg3);
            ChipDrawable v1 = this.chipDrawable;
            if(v1 == null) {
                return;
            }

            v1.setText(((CharSequence)v2));
        }
    }

    public void setTextAppearance(int arg2) {
        super.setTextAppearance(arg2);
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setTextAppearanceResource(arg2);
        }

        this.updateTextPaintDrawState();
    }

    public void setTextAppearance(Context arg1, int arg2) {
        super.setTextAppearance(arg1, arg2);
        ChipDrawable v1 = this.chipDrawable;
        if(v1 != null) {
            v1.setTextAppearanceResource(arg2);
        }

        this.updateTextPaintDrawState();
    }

    public void setTextAppearance(TextAppearance arg2) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setTextAppearance(arg2);
        }

        this.updateTextPaintDrawState();
    }

    public void setTextAppearanceResource(int arg2) {
        this.setTextAppearance(this.getContext(), arg2);
    }

    public void setTextEndPadding(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setTextEndPadding(arg1);
        }
    }

    public void setTextEndPaddingResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setTextEndPaddingResource(arg1);
        }
    }

    public void setTextSize(int arg3, float arg4) {
        super.setTextSize(arg3, arg4);
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setTextSize(TypedValue.applyDimension(arg3, arg4, this.getResources().getDisplayMetrics()));
        }

        this.updateTextPaintDrawState();
    }

    public void setTextStartPadding(float arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setTextStartPadding(arg1);
        }
    }

    public void setTextStartPaddingResource(int arg1) {
        ChipDrawable v0 = this.chipDrawable;
        if(v0 != null) {
            v0.setTextStartPaddingResource(arg1);
        }
    }

    public boolean shouldEnsureMinTouchTargetSize() {
        return this.ensureMinTouchTargetSize;
    }

    private void unapplyChipDrawable(ChipDrawable arg1) {
        if(arg1 != null) {
            arg1.setDelegate(null);
        }
    }

    private void updateAccessibilityDelegate() {
        if((this.hasCloseIcon()) && (this.isCloseIconVisible()) && this.onCloseIconClickListener != null) {
            ViewCompat.setAccessibilityDelegate(((View)this), this.touchHelper);
            this.touchHelperEnabled = true;
            return;
        }

        ViewCompat.setAccessibilityDelegate(((View)this), null);
        this.touchHelperEnabled = false;
    }

    private void updateBackgroundDrawable() {
        if(RippleUtils.USE_FRAMEWORK_RIPPLE) {
            this.updateFrameworkRippleBackground();
            return;
        }

        this.chipDrawable.setUseCompatRipple(true);
        ViewCompat.setBackground(((View)this), this.getBackgroundDrawable());
        this.updatePaddingInternal();
        this.ensureChipDrawableHasCallback();
    }

    private void updateFrameworkRippleBackground() {
        this.ripple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.chipDrawable.getRippleColor()), this.getBackgroundDrawable(), null);
        this.chipDrawable.setUseCompatRipple(false);
        ViewCompat.setBackground(((View)this), this.ripple);
        this.updatePaddingInternal();
    }

    private void updatePaddingInternal() {
        if(!TextUtils.isEmpty(this.getText())) {
            ChipDrawable v0 = this.chipDrawable;
            if(v0 == null) {
            }
            else {
                int v0_1 = ((int)(v0.getChipEndPadding() + this.chipDrawable.getTextEndPadding() + this.chipDrawable.calculateCloseIconWidth()));
                int v1 = ((int)(this.chipDrawable.getChipStartPadding() + this.chipDrawable.getTextStartPadding() + this.chipDrawable.calculateChipIconWidth()));
                if(this.insetBackgroundDrawable != null) {
                    Rect v2 = new Rect();
                    this.insetBackgroundDrawable.getPadding(v2);
                    v1 += v2.left;
                    v0_1 += v2.right;
                }

                ViewCompat.setPaddingRelative(((View)this), v1, this.getPaddingTop(), v0_1, this.getPaddingBottom());
            }
        }
    }

    private void updateTextPaintDrawState() {
        TextPaint v0 = this.getPaint();
        ChipDrawable v1 = this.chipDrawable;
        if(v1 != null) {
            v0.drawableState = v1.getState();
        }

        TextAppearance v1_1 = this.getTextAppearance();
        if(v1_1 != null) {
            v1_1.updateDrawState(this.getContext(), v0, this.fontCallback);
        }
    }

    private void validateAttributes(AttributeSet arg4) {
        String v2;
        if(arg4 == null) {
        }
        else {
            String v0 = "http://schemas.android.com/apk/res/android";
            String v1 = "Chip";
            if(arg4.getAttributeValue(v0, "background") != null) {
                Log.w(v1, "Do not set the background; Chip manages its own background drawable.");
            }

            if(arg4.getAttributeValue(v0, "drawableLeft") != null) {
                goto label_56;
            }

            if(arg4.getAttributeValue(v0, "drawableStart") != null) {
                goto label_52;
            }

            v2 = "Please set end drawable using R.attr#closeIcon.";
            if(arg4.getAttributeValue(v0, "drawableEnd") != null) {
                goto label_49;
            }

            if(arg4.getAttributeValue(v0, "drawableRight") != null) {
                goto label_46;
            }

            if((arg4.getAttributeBooleanValue(v0, "singleLine", true)) && arg4.getAttributeIntValue(v0, "lines", 1) == 1 && arg4.getAttributeIntValue(v0, "minLines", 1) == 1 && arg4.getAttributeIntValue(v0, "maxLines", 1) == 1) {
                if(arg4.getAttributeIntValue(v0, "gravity", 0x800013) != 0x800013) {
                    Log.w(v1, "Chip text must be vertically center and start aligned");
                }
                else {
                }

                return;
            }

            goto label_42;
        }

        return;
    label_42:
        throw new UnsupportedOperationException("Chip does not support multi-line text");
    label_46:
        throw new UnsupportedOperationException(v2);
    label_49:
        throw new UnsupportedOperationException(v2);
    label_52:
        throw new UnsupportedOperationException("Please set start drawable using R.attr#chipIcon.");
    label_56:
        throw new UnsupportedOperationException("Please set left drawable using R.attr#chipIcon.");
    }
}

