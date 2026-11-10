package com.google.android.material.card;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Build$VERSION;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Checkable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.cardview.widget.CardView;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.shape.MaterialShapeUtils;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import com.google.android.material.theme.overlay.MaterialThemeOverlay;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MaterialCardView extends CardView implements Checkable, Shapeable {
    @Retention(value=RetentionPolicy.SOURCE) @public interface CheckedIconGravity {
    }

    public interface OnCheckedChangeListener {
        void onCheckedChanged(MaterialCardView arg1, boolean arg2);
    }

    private static final String ACCESSIBILITY_CLASS_NAME = "androidx.cardview.widget.CardView";
    private static final int[] CHECKABLE_STATE_SET = null;
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_END = 0x800055;
    public static final int CHECKED_ICON_GRAVITY_BOTTOM_START = 0x800053;
    public static final int CHECKED_ICON_GRAVITY_TOP_END = 0x800035;
    public static final int CHECKED_ICON_GRAVITY_TOP_START = 0x800033;
    private static final int[] CHECKED_STATE_SET = null;
    private static final int DEF_STYLE_RES = 0;
    private static final int[] DRAGGED_STATE_SET = null;
    private static final String LOG_TAG = "MaterialCardView";
    private final MaterialCardViewHelper cardViewHelper;
    private boolean checked;
    private boolean dragged;
    private boolean isParentCardViewDoneInitializing;
    private OnCheckedChangeListener onCheckedChangeListener;

    static {
        MaterialCardView.CHECKABLE_STATE_SET = new int[]{0x101009F};
        MaterialCardView.CHECKED_STATE_SET = new int[]{0x10100A0};
        MaterialCardView.DRAGGED_STATE_SET = new int[]{attr.state_dragged};
        MaterialCardView.DEF_STYLE_RES = style.Widget_MaterialComponents_CardView;
    }

    public MaterialCardView(Context arg2) {
        this(arg2, null);
    }

    public MaterialCardView(Context arg2, AttributeSet arg3) {
        this(arg2, arg3, attr.materialCardViewStyle);
    }

    public MaterialCardView(Context arg7, AttributeSet arg8, int arg9) {
        int v4 = MaterialCardView.DEF_STYLE_RES;
        super(MaterialThemeOverlay.wrap(arg7, arg8, arg9, v4), arg8, arg9);
        this.checked = false;
        this.dragged = false;
        this.isParentCardViewDoneInitializing = true;
        TypedArray v7 = ThemeEnforcement.obtainStyledAttributes(this.getContext(), arg8, styleable.MaterialCardView, arg9, v4, new int[0]);
        MaterialCardViewHelper v8 = new MaterialCardViewHelper(this, arg8, arg9, v4);
        this.cardViewHelper = v8;
        v8.setCardBackgroundColor(super.getCardBackgroundColor());
        v8.setUserContentPadding(super.getContentPaddingLeft(), super.getContentPaddingTop(), super.getContentPaddingRight(), super.getContentPaddingBottom());
        v8.loadFromAttributes(v7);
        v7.recycle();
    }

    static float access$001(MaterialCardView arg0) {
        return super.getRadius();
    }

    private void forceRippleRedrawIfNeeded() {
        if(Build$VERSION.SDK_INT > 26) {
            this.cardViewHelper.forceRippleRedraw();
        }
    }

    private RectF getBoundsAsRectF() {
        RectF v0 = new RectF();
        v0.set(this.cardViewHelper.getBackground().getBounds());
        return v0;
    }

    public ColorStateList getCardBackgroundColor() {
        return this.cardViewHelper.getCardBackgroundColor();
    }

    public ColorStateList getCardForegroundColor() {
        return this.cardViewHelper.getCardForegroundColor();
    }

    float getCardViewRadius() {
        return MaterialCardView.access$001(this);
    }

    public Drawable getCheckedIcon() {
        return this.cardViewHelper.getCheckedIcon();
    }

    public int getCheckedIconGravity() {
        return this.cardViewHelper.getCheckedIconGravity();
    }

    public int getCheckedIconMargin() {
        return this.cardViewHelper.getCheckedIconMargin();
    }

    public int getCheckedIconSize() {
        return this.cardViewHelper.getCheckedIconSize();
    }

    public ColorStateList getCheckedIconTint() {
        return this.cardViewHelper.getCheckedIconTint();
    }

    public int getContentPaddingBottom() {
        return this.cardViewHelper.getUserContentPadding().bottom;
    }

    public int getContentPaddingLeft() {
        return this.cardViewHelper.getUserContentPadding().left;
    }

    public int getContentPaddingRight() {
        return this.cardViewHelper.getUserContentPadding().right;
    }

    public int getContentPaddingTop() {
        return this.cardViewHelper.getUserContentPadding().top;
    }

    public float getProgress() {
        return this.cardViewHelper.getProgress();
    }

    public float getRadius() {
        return this.cardViewHelper.getCornerRadius();
    }

    public ColorStateList getRippleColor() {
        return this.cardViewHelper.getRippleColor();
    }

    public ShapeAppearanceModel getShapeAppearanceModel() {
        return this.cardViewHelper.getShapeAppearanceModel();
    }

    @Deprecated public int getStrokeColor() {
        return this.cardViewHelper.getStrokeColor();
    }

    public ColorStateList getStrokeColorStateList() {
        return this.cardViewHelper.getStrokeColorStateList();
    }

    public int getStrokeWidth() {
        return this.cardViewHelper.getStrokeWidth();
    }

    public boolean isCheckable() {
        MaterialCardViewHelper v0 = this.cardViewHelper;
        if(v0 != null && (v0.isCheckable())) {
            return 1;
        }

        return 0;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public boolean isDragged() {
        return this.dragged;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.cardViewHelper.updateClickable();
        MaterialShapeUtils.setParentAbsoluteElevation(((View)this), this.cardViewHelper.getBackground());
    }

    protected int[] onCreateDrawableState(int arg2) {
        int[] v2 = super.onCreateDrawableState(arg2 + 3);
        if(this.isCheckable()) {
            MaterialCardView.mergeDrawableStates(v2, MaterialCardView.CHECKABLE_STATE_SET);
        }

        if(this.isChecked()) {
            MaterialCardView.mergeDrawableStates(v2, MaterialCardView.CHECKED_STATE_SET);
        }

        if(this.isDragged()) {
            MaterialCardView.mergeDrawableStates(v2, MaterialCardView.DRAGGED_STATE_SET);
        }

        return v2;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent arg2) {
        super.onInitializeAccessibilityEvent(arg2);
        arg2.setClassName("androidx.cardview.widget.CardView");
        arg2.setChecked(this.isChecked());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo arg2) {
        super.onInitializeAccessibilityNodeInfo(arg2);
        arg2.setClassName("androidx.cardview.widget.CardView");
        arg2.setCheckable(this.isCheckable());
        arg2.setClickable(this.isClickable());
        arg2.setChecked(this.isChecked());
    }

    protected void onMeasure(int arg1, int arg2) {
        super.onMeasure(arg1, arg2);
        this.cardViewHelper.recalculateCheckedIconPosition(this.getMeasuredWidth(), this.getMeasuredHeight());
    }

    void setAncestorContentPadding(int arg1, int arg2, int arg3, int arg4) {
        super.setContentPadding(arg1, arg2, arg3, arg4);
    }

    public void setBackground(Drawable arg1) {
        this.setBackgroundDrawable(arg1);
    }

    public void setBackgroundDrawable(Drawable arg3) {
        if(this.isParentCardViewDoneInitializing) {
            if(!this.cardViewHelper.isBackgroundOverwritten()) {
                Log.i("MaterialCardView", "Setting a custom background is not supported.");
                this.cardViewHelper.setBackgroundOverwritten(true);
            }

            super.setBackgroundDrawable(arg3);
        }
    }

    void setBackgroundInternal(Drawable arg1) {
        super.setBackgroundDrawable(arg1);
    }

    public void setCardBackgroundColor(int arg1) {
        this.cardViewHelper.setCardBackgroundColor(ColorStateList.valueOf(arg1));
    }

    public void setCardBackgroundColor(ColorStateList arg1) {
        this.cardViewHelper.setCardBackgroundColor(arg1);
    }

    public void setCardElevation(float arg1) {
        super.setCardElevation(arg1);
        this.cardViewHelper.updateElevation();
    }

    public void setCardForegroundColor(ColorStateList arg1) {
        this.cardViewHelper.setCardForegroundColor(arg1);
    }

    public void setCheckable(boolean arg1) {
        this.cardViewHelper.setCheckable(arg1);
    }

    public void setChecked(boolean arg2) {
        if(this.checked != arg2) {
            this.toggle();
        }
    }

    public void setCheckedIcon(Drawable arg1) {
        this.cardViewHelper.setCheckedIcon(arg1);
    }

    public void setCheckedIconGravity(int arg2) {
        if(this.cardViewHelper.getCheckedIconGravity() != arg2) {
            this.cardViewHelper.setCheckedIconGravity(arg2);
        }
    }

    public void setCheckedIconMargin(int arg1) {
        this.cardViewHelper.setCheckedIconMargin(arg1);
    }

    public void setCheckedIconMarginResource(int arg2) {
        if(arg2 != -1) {
            this.cardViewHelper.setCheckedIconMargin(this.getResources().getDimensionPixelSize(arg2));
        }
    }

    public void setCheckedIconResource(int arg2) {
        this.cardViewHelper.setCheckedIcon(AppCompatResources.getDrawable(this.getContext(), arg2));
    }

    public void setCheckedIconSize(int arg1) {
        this.cardViewHelper.setCheckedIconSize(arg1);
    }

    public void setCheckedIconSizeResource(int arg2) {
        if(arg2 != 0) {
            this.cardViewHelper.setCheckedIconSize(this.getResources().getDimensionPixelSize(arg2));
        }
    }

    public void setCheckedIconTint(ColorStateList arg1) {
        this.cardViewHelper.setCheckedIconTint(arg1);
    }

    public void setClickable(boolean arg1) {
        super.setClickable(arg1);
        MaterialCardViewHelper v0 = this.cardViewHelper;
        if(v0 != null) {
            v0.updateClickable();
        }
    }

    public void setContentPadding(int arg1, int arg2, int arg3, int arg4) {
        this.cardViewHelper.setUserContentPadding(arg1, arg2, arg3, arg4);
    }

    public void setDragged(boolean arg2) {
        if(this.dragged != arg2) {
            this.dragged = arg2;
            this.refreshDrawableState();
            this.forceRippleRedrawIfNeeded();
            this.invalidate();
        }
    }

    public void setMaxCardElevation(float arg1) {
        super.setMaxCardElevation(arg1);
        this.cardViewHelper.updateInsets();
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener arg1) {
        this.onCheckedChangeListener = arg1;
    }

    public void setPreventCornerOverlap(boolean arg1) {
        super.setPreventCornerOverlap(arg1);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    public void setProgress(float arg1) {
        this.cardViewHelper.setProgress(arg1);
    }

    public void setRadius(float arg1) {
        super.setRadius(arg1);
        this.cardViewHelper.setCornerRadius(arg1);
    }

    public void setRippleColor(ColorStateList arg1) {
        this.cardViewHelper.setRippleColor(arg1);
    }

    public void setRippleColorResource(int arg2) {
        this.cardViewHelper.setRippleColor(AppCompatResources.getColorStateList(this.getContext(), arg2));
    }

    public void setShapeAppearanceModel(ShapeAppearanceModel arg2) {
        this.setClipToOutline(arg2.isRoundRect(this.getBoundsAsRectF()));
        this.cardViewHelper.setShapeAppearanceModel(arg2);
    }

    public void setStrokeColor(int arg1) {
        this.setStrokeColor(ColorStateList.valueOf(arg1));
    }

    public void setStrokeColor(ColorStateList arg2) {
        this.cardViewHelper.setStrokeColor(arg2);
        this.invalidate();
    }

    public void setStrokeWidth(int arg2) {
        this.cardViewHelper.setStrokeWidth(arg2);
        this.invalidate();
    }

    public void setUseCompatPadding(boolean arg1) {
        super.setUseCompatPadding(arg1);
        this.cardViewHelper.updateInsets();
        this.cardViewHelper.updateContentPadding();
    }

    public void toggle() {
        if((this.isCheckable()) && (this.isEnabled())) {
            this.checked ^= 1;
            this.refreshDrawableState();
            this.forceRippleRedrawIfNeeded();
            this.cardViewHelper.setChecked(this.checked, true);
            OnCheckedChangeListener v0 = this.onCheckedChangeListener;
            if(v0 != null) {
                v0.onCheckedChanged(this, this.checked);
            }
        }
    }
}

