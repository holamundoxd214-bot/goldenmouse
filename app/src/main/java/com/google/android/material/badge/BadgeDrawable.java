package com.google.android.material.badge;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint$Align;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout$LayoutParams;
import android.widget.FrameLayout;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$attr;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.ref.WeakReference;
import java.text.NumberFormat;
import java.util.Locale;

public class BadgeDrawable extends Drawable implements TextDrawableDelegate {
    @Retention(value=RetentionPolicy.SOURCE) @public interface BadgeGravity {
    }

    public static final int BADGE_CONTENT_NOT_TRUNCATED = -2;
    static final int BADGE_RADIUS_NOT_SPECIFIED = -1;
    @Deprecated public static final int BOTTOM_END = 0x800055;
    @Deprecated public static final int BOTTOM_START = 0x800053;
    static final String DEFAULT_EXCEED_MAX_BADGE_NUMBER_SUFFIX = "+";
    static final String DEFAULT_EXCEED_MAX_BADGE_TEXT_SUFFIX = "…";
    private static final int DEFAULT_STYLE = 0;
    private static final int DEFAULT_THEME_ATTR = 0;
    private static final float FONT_SCALE_THRESHOLD = 0.3f;
    static final int OFFSET_ALIGNMENT_MODE_EDGE = 0;
    static final int OFFSET_ALIGNMENT_MODE_LEGACY = 1;
    private static final String TAG = "Badge";
    public static final int TOP_END = 0x800035;
    public static final int TOP_START = 0x800033;
    private WeakReference anchorViewRef;
    private final Rect badgeBounds;
    private float badgeCenterX;
    private float badgeCenterY;
    private final WeakReference contextRef;
    private float cornerRadius;
    private WeakReference customBadgeParentRef;
    private float halfBadgeHeight;
    private float halfBadgeWidth;
    private int maxBadgeNumber;
    private final MaterialShapeDrawable shapeDrawable;
    private final BadgeState state;
    private final TextDrawableHelper textDrawableHelper;

    static {
        BadgeDrawable.DEFAULT_STYLE = style.Widget_MaterialComponents_Badge;
        BadgeDrawable.DEFAULT_THEME_ATTR = attr.badgeStyle;
    }

    private BadgeDrawable(Context arg9, int arg10, int arg11, int arg12, State arg13) {
        super();
        this.contextRef = new WeakReference(arg9);
        ThemeEnforcement.checkMaterialTheme(arg9);
        this.badgeBounds = new Rect();
        TextDrawableHelper v0 = new TextDrawableHelper(((TextDrawableDelegate)this));
        this.textDrawableHelper = v0;
        v0.getTextPaint().setTextAlign(Paint$Align.CENTER);
        Context v3 = arg9;
        BadgeState v2 = new BadgeState(v3, arg10, arg11, arg12, arg13);
        this.state = v2;
        arg10 = this.hasBadgeContent() ? v2.getBadgeWithTextShapeAppearanceResId() : v2.getBadgeShapeAppearanceResId();
        arg11 = this.hasBadgeContent() ? v2.getBadgeWithTextShapeAppearanceOverlayResId() : v2.getBadgeShapeAppearanceOverlayResId();
        this.shapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder(v3, arg10, arg11).build());
        this.restoreState();
    }

    private void autoAdjustWithinGrandparentBounds(View arg7) {
        float v7;
        ViewParent v0_2;
        float v2;
        float v0_1;
        FrameLayout v0 = this.getCustomBadgeParent();
        if(v0 == null) {
            if(!(arg7.getParent() instanceof View)) {
            }
            else {
                v0_1 = arg7.getY();
                v2 = arg7.getX();
                float v5 = v0_1;
                v0_2 = arg7.getParent();
                v7 = v5;
                goto label_26;
            }
        }
        else if(!this.isAnchorViewWrappedInCompatParent()) {
            v7 = 0f;
            v2 = 0f;
        label_26:
            float v3 = this.getTopCutOff(((View)v0_2), v7);
            float v4 = this.getLeftCutOff(((View)v0_2), v2);
            v7 = this.getBottomCutOff(((View)v0_2), v7);
            v0_1 = this.getRightCutoff(((View)v0_2), v2);
            if(v3 < 0f) {
                this.badgeCenterY += Math.abs(v3);
            }

            if(v4 < 0f) {
                this.badgeCenterX += Math.abs(v4);
            }

            if(v7 > 0f) {
                this.badgeCenterY -= Math.abs(v7);
            }

            if(v0_1 <= 0f) {
                return;
            }

            this.badgeCenterX -= Math.abs(v0_1);
        }
        else if(!(((View)v0).getParent() instanceof View)) {
        }
        else {
            v7 = ((View)v0).getY();
            v2 = ((View)v0).getX();
            v0_2 = ((View)v0).getParent();
            goto label_26;
        }
    }

    private void calculateCenterAndBounds(Rect arg6, View arg7) {
        float v6;
        boolean v0 = this.hasBadgeContent();
        BadgeState v1 = this.state;
        float v0_1 = v0 ? v1.badgeWithTextRadius : v1.badgeRadius;
        this.cornerRadius = v0_1;
        float v2 = 2f;
        if(Float.compare(v0_1, -1f) != 0) {
            this.halfBadgeWidth = v0_1;
            this.halfBadgeHeight = v0_1;
        }
        else {
            v0 = this.hasBadgeContent();
            v1 = this.state;
            v0_1 = v0 ? v1.badgeWithTextWidth : v1.badgeWidth;
            this.halfBadgeWidth = ((float)Math.round(v0_1 / v2));
            v0 = this.hasBadgeContent();
            v1 = this.state;
            v0_1 = v0 ? v1.badgeWithTextHeight : v1.badgeHeight;
            this.halfBadgeHeight = ((float)Math.round(v0_1 / v2));
        }

        if(this.hasBadgeContent()) {
            String v0_2 = this.getBadgeContent();
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, this.textDrawableHelper.getTextWidth(v0_2) / v2 + (((float)this.state.getBadgeHorizontalPadding())));
            v0_1 = Math.max(this.halfBadgeHeight, this.textDrawableHelper.getTextHeight(v0_2) / v2 + (((float)this.state.getBadgeVerticalPadding())));
            this.halfBadgeHeight = v0_1;
            this.halfBadgeWidth = Math.max(this.halfBadgeWidth, v0_1);
        }

        int v0_3 = this.getTotalVerticalOffsetForState();
        int v1_1 = this.state.getBadgeGravity();
        int v2_1 = 0x800053;
        this.badgeCenterY = v1_1 == v2_1 || v1_1 == 0x800055 ? ((float)(arg6.bottom - v0_3)) : ((float)(arg6.top + v0_3));
        v0_3 = this.getTotalHorizontalOffsetForState();
        v1_1 = this.state.getBadgeGravity();
        if(v1_1 == 0x800033 || v1_1 == v2_1) {
            v6 = ViewCompat.getLayoutDirection(arg7) == 0 ? (((float)arg6.left)) - this.halfBadgeWidth + (((float)v0_3)) : (((float)arg6.right)) + this.halfBadgeWidth - (((float)v0_3));
            this.badgeCenterX = v6;
        }
        else {
            v6 = ViewCompat.getLayoutDirection(arg7) == 0 ? (((float)arg6.right)) + this.halfBadgeWidth - (((float)v0_3)) : (((float)arg6.left)) - this.halfBadgeWidth + (((float)v0_3));
            this.badgeCenterX = v6;
        }

        if(this.state.isAutoAdjustedToGrandparentBounds()) {
            this.autoAdjustWithinGrandparentBounds(arg7);
        }
    }

    public void clearNumber() {
        if(this.state.hasNumber()) {
            this.state.clearNumber();
            this.onNumberUpdated();
        }
    }

    public void clearText() {
        if(this.state.hasText()) {
            this.state.clearText();
            this.onTextUpdated();
        }
    }

    public static BadgeDrawable create(Context arg6) {
        return new BadgeDrawable(arg6, 0, BadgeDrawable.DEFAULT_THEME_ATTR, BadgeDrawable.DEFAULT_STYLE, null);
    }

    public static BadgeDrawable createFromResource(Context arg6, int arg7) {
        return new BadgeDrawable(arg6, arg7, BadgeDrawable.DEFAULT_THEME_ATTR, BadgeDrawable.DEFAULT_STYLE, null);
    }

    static BadgeDrawable createFromSavedState(Context arg6, State arg7) {
        return new BadgeDrawable(arg6, 0, BadgeDrawable.DEFAULT_THEME_ATTR, BadgeDrawable.DEFAULT_STYLE, arg7);
    }

    public void draw(Canvas arg2) {
        if(!this.getBounds().isEmpty() && this.getAlpha() != 0) {
            if(!this.isVisible()) {
            }
            else {
                this.shapeDrawable.draw(arg2);
                if(this.hasBadgeContent()) {
                    this.drawBadgeContent(arg2);
                }
            }
        }
    }

    private void drawBadgeContent(Canvas arg6) {
        String v0 = this.getBadgeContent();
        if(v0 != null) {
            Rect v1 = new Rect();
            this.textDrawableHelper.getTextPaint().getTextBounds(v0, 0, v0.length(), v1);
            float v2 = this.badgeCenterY - v1.exactCenterY();
            float v3 = this.badgeCenterX;
            int v1_1 = v1.bottom <= 0 ? ((int)v2) : Math.round(v2);
            arg6.drawText(v0, v3, ((float)v1_1), this.textDrawableHelper.getTextPaint());
        }
    }

    int getAdditionalHorizontalOffset() {
        return this.state.getAdditionalHorizontalOffset();
    }

    int getAdditionalVerticalOffset() {
        return this.state.getAdditionalVerticalOffset();
    }

    public int getAlpha() {
        return this.state.getAlpha();
    }

    public int getBackgroundColor() {
        return this.shapeDrawable.getFillColor().getDefaultColor();
    }

    private String getBadgeContent() {
        if(this.hasText()) {
            return this.getTextBadgeText();
        }

        if(this.hasNumber()) {
            return this.getNumberBadgeText();
        }

        return null;
    }

    public int getBadgeGravity() {
        return this.state.getBadgeGravity();
    }

    public Locale getBadgeNumberLocale() {
        return this.state.getNumberLocale();
    }

    public int getBadgeTextColor() {
        return this.textDrawableHelper.getTextPaint().getColor();
    }

    private float getBottomCutOff(View arg3, float arg4) {
        if((arg3.getParent() instanceof View)) {
            return this.badgeCenterY + this.halfBadgeHeight - ((((float)arg3.getParent().getHeight())) - arg3.getY()) + arg4;
        }

        return 0;
    }

    public CharSequence getContentDescription() {
        if(!this.isVisible()) {
            return null;
        }

        if(this.hasText()) {
            return this.getTextContentDescription();
        }

        if(this.hasNumber()) {
            return this.getNumberContentDescription();
        }

        return this.getEmptyContentDescription();
    }

    public FrameLayout getCustomBadgeParent() {
        WeakReference v0 = this.customBadgeParentRef;
        if(v0 != null) {
            return v0.get();
        }

        return null;
    }

    private CharSequence getEmptyContentDescription() {
        return this.state.getContentDescriptionNumberless();
    }

    public int getHorizontalOffset() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    public int getHorizontalOffsetWithText() {
        return this.state.getHorizontalOffsetWithText();
    }

    public int getHorizontalOffsetWithoutText() {
        return this.state.getHorizontalOffsetWithoutText();
    }

    public int getHorizontalPadding() {
        return this.state.getBadgeHorizontalPadding();
    }

    public int getIntrinsicHeight() {
        return this.badgeBounds.height();
    }

    public int getIntrinsicWidth() {
        return this.badgeBounds.width();
    }

    public int getLargeFontVerticalOffsetAdjustment() {
        return this.state.getLargeFontVerticalOffsetAdjustment();
    }

    private float getLeftCutOff(View arg2, float arg3) {
        return this.badgeCenterX - this.halfBadgeWidth + arg2.getX() + arg3;
    }

    public int getMaxCharacterCount() {
        return this.state.getMaxCharacterCount();
    }

    public int getMaxNumber() {
        return this.state.getMaxNumber();
    }

    public int getNumber() {
        if(this.state.hasNumber()) {
            return this.state.getNumber();
        }

        return 0;
    }

    private String getNumberBadgeText() {
        if(this.maxBadgeNumber != -2) {
            if(this.getNumber() <= this.maxBadgeNumber) {
            }
            else {
                Object v0 = this.contextRef.get();
                if(v0 == null) {
                    return "";
                }
                else {
                    return String.format(this.state.getNumberLocale(), ((Context)v0).getString(string.mtrl_exceed_max_badge_number_suffix), Integer.valueOf(this.maxBadgeNumber), "+");
                }
            }
        }

        return NumberFormat.getInstance(this.state.getNumberLocale()).format(((long)this.getNumber()));
    }

    private String getNumberContentDescription() {
        String v1 = null;
        if(this.state.getContentDescriptionQuantityStrings() != 0) {
            Object v0 = this.contextRef.get();
            if(v0 == null) {
                return v1;
            }

            if(this.maxBadgeNumber != -2) {
                if(this.getNumber() <= this.maxBadgeNumber) {
                }
                else {
                    return ((Context)v0).getString(this.state.getContentDescriptionExceedsMaxBadgeNumberStringResource(), new Object[]{Integer.valueOf(this.maxBadgeNumber)});
                }
            }

            return ((Context)v0).getResources().getQuantityString(this.state.getContentDescriptionQuantityStrings(), this.getNumber(), new Object[]{Integer.valueOf(this.getNumber())});
        }

        return v1;
    }

    public int getOpacity() {
        return -3;
    }

    private float getRightCutoff(View arg3, float arg4) {
        if((arg3.getParent() instanceof View)) {
            return this.badgeCenterX + this.halfBadgeWidth - ((((float)arg3.getParent().getWidth())) - arg3.getX()) + arg4;
        }

        return 0;
    }

    State getSavedState() {
        return this.state.getOverridingState();
    }

    public String getText() {
        return this.state.getText();
    }

    private String getTextBadgeText() {
        String v0 = this.getText();
        int v1 = this.getMaxCharacterCount();
        if(v1 == -2) {
        }
        else if(v0 != null && v0.length() > v1) {
            Object v3 = this.contextRef.get();
            if(v3 == null) {
                return "";
            }
            else {
                return String.format(((Context)v3).getString(string.m3_exceed_max_badge_text_suffix), v0.substring(0, v1 - 1), "…");
            }
        }

        return v0;
    }

    private CharSequence getTextContentDescription() {
        CharSequence v0 = this.state.getContentDescriptionForText();
        if(v0 != null) {
            return v0;
        }

        return this.getText();
    }

    private float getTopCutOff(View arg2, float arg3) {
        return this.badgeCenterY - this.halfBadgeHeight + arg2.getY() + arg3;
    }

    private int getTotalHorizontalOffsetForState() {
        boolean v0 = this.hasBadgeContent();
        BadgeState v1 = this.state;
        int v0_1 = v0 ? v1.getHorizontalOffsetWithText() : v1.getHorizontalOffsetWithoutText();
        if(this.state.offsetAlignmentMode == 1) {
            boolean v1_1 = this.hasBadgeContent();
            BadgeState v2 = this.state;
            int v1_2 = v1_1 ? v2.horizontalInsetWithText : v2.horizontalInset;
            v0_1 += v1_2;
        }

        return v0_1 + this.state.getAdditionalHorizontalOffset();
    }

    private int getTotalVerticalOffsetForState() {
        int v0 = this.state.getVerticalOffsetWithoutText();
        if(this.hasBadgeContent()) {
            v0 = this.state.getVerticalOffsetWithText();
            Object v1 = this.contextRef.get();
            if(v1 != null) {
                v0 = AnimationUtils.lerp(v0, v0 - this.state.getLargeFontVerticalOffsetAdjustment(), AnimationUtils.lerp(0f, 1f, 0.3f, 1f, MaterialResources.getFontScale(((Context)v1)) - 1f));
            }
        }

        if(this.state.offsetAlignmentMode == 0) {
            v0 -= Math.round(this.halfBadgeHeight);
        }

        return v0 + this.state.getAdditionalVerticalOffset();
    }

    public int getVerticalOffset() {
        return this.state.getVerticalOffsetWithoutText();
    }

    public int getVerticalOffsetWithText() {
        return this.state.getVerticalOffsetWithText();
    }

    public int getVerticalOffsetWithoutText() {
        return this.state.getVerticalOffsetWithoutText();
    }

    public int getVerticalPadding() {
        return this.state.getBadgeVerticalPadding();
    }

    private boolean hasBadgeContent() {
        if(!this.hasText()) {
            if(this.hasNumber()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    public boolean hasNumber() {
        if(!this.state.hasText() && (this.state.hasNumber())) {
            return 1;
        }

        return 0;
    }

    public boolean hasText() {
        return this.state.hasText();
    }

    private boolean isAnchorViewWrappedInCompatParent() {
        FrameLayout v1 = this.getCustomBadgeParent();
        if(v1 != null && ((View)v1).getId() == id.mtrl_anchor_parent) {
            return 1;
        }

        return 0;
    }

    public boolean isStateful() {
        return 0;
    }

    private void onAlphaUpdated() {
        this.textDrawableHelper.getTextPaint().setAlpha(this.getAlpha());
        this.invalidateSelf();
    }

    private void onBackgroundColorUpdated() {
        ColorStateList v0 = ColorStateList.valueOf(this.state.getBackgroundColor());
        if(this.shapeDrawable.getFillColor() != v0) {
            this.shapeDrawable.setFillColor(v0);
            this.invalidateSelf();
        }
    }

    private void onBadgeContentUpdated() {
        this.textDrawableHelper.setTextSizeDirty(true);
        this.onBadgeShapeAppearanceUpdated();
        this.updateCenterAndBounds();
        this.invalidateSelf();
    }

    private void onBadgeGravityUpdated() {
        FrameLayout v1_2;
        WeakReference v0 = this.anchorViewRef;
        if(v0 != null && v0.get() != null) {
            Object v0_1 = this.anchorViewRef.get();
            WeakReference v1 = this.customBadgeParentRef;
            if(v1 != null) {
                Object v1_1 = v1.get();
            }
            else {
                v1_2 = null;
            }

            this.updateBadgeCoordinates(((View)v0_1), v1_2);
        }
    }

    private void onBadgeShapeAppearanceUpdated() {
        Object v0 = this.contextRef.get();
        if(v0 == null) {
            return;
        }

        MaterialShapeDrawable v1 = this.shapeDrawable;
        boolean v2 = this.hasBadgeContent();
        BadgeState v3 = this.state;
        int v2_1 = v2 ? v3.getBadgeWithTextShapeAppearanceResId() : v3.getBadgeShapeAppearanceResId();
        boolean v3_1 = this.hasBadgeContent();
        BadgeState v4 = this.state;
        int v3_2 = v3_1 ? v4.getBadgeWithTextShapeAppearanceOverlayResId() : v4.getBadgeShapeAppearanceOverlayResId();
        v1.setShapeAppearanceModel(ShapeAppearanceModel.builder(((Context)v0), v2_1, v3_2).build());
        this.invalidateSelf();
    }

    private void onBadgeTextAppearanceUpdated() {
        TextAppearance v1;
        Object v0 = this.contextRef.get();
        if(v0 == null) {
        }
        else {
            v1 = new TextAppearance(((Context)v0), this.state.getTextAppearanceResId());
            if(this.textDrawableHelper.getTextAppearance() == v1) {
                return;
            }

            goto label_12;
        }

        return;
    label_12:
        this.textDrawableHelper.setTextAppearance(v1, ((Context)v0));
        this.onBadgeTextColorUpdated();
        this.updateCenterAndBounds();
        this.invalidateSelf();
    }

    private void onBadgeTextColorUpdated() {
        this.textDrawableHelper.getTextPaint().setColor(this.state.getBadgeTextColor());
        this.invalidateSelf();
    }

    private void onMaxBadgeLengthUpdated() {
        this.updateMaxBadgeNumber();
        this.textDrawableHelper.setTextSizeDirty(true);
        this.updateCenterAndBounds();
        this.invalidateSelf();
    }

    private void onNumberUpdated() {
        if(!this.hasText()) {
            this.onBadgeContentUpdated();
        }
    }

    public boolean onStateChange(int[] arg1) {
        return super.onStateChange(arg1);
    }

    public void onTextSizeChange() {
        this.invalidateSelf();
    }

    private void onTextUpdated() {
        this.onBadgeContentUpdated();
    }

    private void onVisibilityUpdated() {
        boolean v0 = this.state.isVisible();
        this.setVisible(v0, false);
        if((BadgeUtils.USE_COMPAT_PARENT) && this.getCustomBadgeParent() != null && !v0) {
            this.getCustomBadgeParent().getParent().invalidate();
        }
    }

    private void restoreState() {
        this.onBadgeShapeAppearanceUpdated();
        this.onBadgeTextAppearanceUpdated();
        this.onMaxBadgeLengthUpdated();
        this.onBadgeContentUpdated();
        this.onAlphaUpdated();
        this.onBackgroundColorUpdated();
        this.onBadgeTextColorUpdated();
        this.onBadgeGravityUpdated();
        this.updateCenterAndBounds();
        this.onVisibilityUpdated();
    }

    void setAdditionalHorizontalOffset(int arg2) {
        this.state.setAdditionalHorizontalOffset(arg2);
        this.updateCenterAndBounds();
    }

    void setAdditionalVerticalOffset(int arg2) {
        this.state.setAdditionalVerticalOffset(arg2);
        this.updateCenterAndBounds();
    }

    public void setAlpha(int arg2) {
        this.state.setAlpha(arg2);
        this.onAlphaUpdated();
    }

    public void setAutoAdjustToWithinGrandparentBounds(boolean arg2) {
        if(this.state.isAutoAdjustedToGrandparentBounds() == arg2) {
        }
        else {
            this.state.setAutoAdjustToGrandparentBounds(arg2);
            WeakReference v2 = this.anchorViewRef;
            if(v2 != null && v2.get() != null) {
                this.autoAdjustWithinGrandparentBounds(this.anchorViewRef.get());
            }
        }
    }

    public void setBackgroundColor(int arg2) {
        this.state.setBackgroundColor(arg2);
        this.onBackgroundColorUpdated();
    }

    public void setBadgeGravity(int arg3) {
        if(arg3 == 0x800053 || arg3 == 0x800055) {
            Log.w("Badge", "Bottom badge gravities are deprecated; please use a top gravity instead.");
        }

        if(this.state.getBadgeGravity() != arg3) {
            this.state.setBadgeGravity(arg3);
            this.onBadgeGravityUpdated();
        }
    }

    public void setBadgeNumberLocale(Locale arg2) {
        if(!arg2.equals(this.state.getNumberLocale())) {
            this.state.setNumberLocale(arg2);
            this.invalidateSelf();
        }
    }

    public void setBadgeTextColor(int arg2) {
        if(this.textDrawableHelper.getTextPaint().getColor() != arg2) {
            this.state.setBadgeTextColor(arg2);
            this.onBadgeTextColorUpdated();
        }
    }

    public void setBadgeWithTextShapeAppearance(int arg2) {
        this.state.setBadgeWithTextShapeAppearanceResId(arg2);
        this.onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithTextShapeAppearanceOverlay(int arg2) {
        this.state.setBadgeWithTextShapeAppearanceOverlayResId(arg2);
        this.onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearance(int arg2) {
        this.state.setBadgeShapeAppearanceResId(arg2);
        this.onBadgeShapeAppearanceUpdated();
    }

    public void setBadgeWithoutTextShapeAppearanceOverlay(int arg2) {
        this.state.setBadgeShapeAppearanceOverlayResId(arg2);
        this.onBadgeShapeAppearanceUpdated();
    }

    public void setColorFilter(ColorFilter arg1) {
    }

    public void setContentDescriptionExceedsMaxBadgeNumberStringResource(int arg1) {
        this.state.setContentDescriptionExceedsMaxBadgeNumberStringResource(arg1);
    }

    public void setContentDescriptionForText(CharSequence arg1) {
        this.state.setContentDescriptionForText(arg1);
    }

    public void setContentDescriptionNumberless(CharSequence arg1) {
        this.state.setContentDescriptionNumberless(arg1);
    }

    public void setContentDescriptionQuantityStringsResource(int arg1) {
        this.state.setContentDescriptionQuantityStringsResource(arg1);
    }

    public void setHorizontalOffset(int arg1) {
        this.setHorizontalOffsetWithoutText(arg1);
        this.setHorizontalOffsetWithText(arg1);
    }

    public void setHorizontalOffsetWithText(int arg2) {
        this.state.setHorizontalOffsetWithText(arg2);
        this.updateCenterAndBounds();
    }

    public void setHorizontalOffsetWithoutText(int arg2) {
        this.state.setHorizontalOffsetWithoutText(arg2);
        this.updateCenterAndBounds();
    }

    public void setHorizontalPadding(int arg2) {
        if(arg2 != this.state.getBadgeHorizontalPadding()) {
            this.state.setBadgeHorizontalPadding(arg2);
            this.updateCenterAndBounds();
        }
    }

    public void setLargeFontVerticalOffsetAdjustment(int arg2) {
        this.state.setLargeFontVerticalOffsetAdjustment(arg2);
        this.updateCenterAndBounds();
    }

    public void setMaxCharacterCount(int arg2) {
        if(this.state.getMaxCharacterCount() != arg2) {
            this.state.setMaxCharacterCount(arg2);
            this.onMaxBadgeLengthUpdated();
        }
    }

    public void setMaxNumber(int arg2) {
        if(this.state.getMaxNumber() != arg2) {
            this.state.setMaxNumber(arg2);
            this.onMaxBadgeLengthUpdated();
        }
    }

    public void setNumber(int arg2) {
        arg2 = Math.max(0, arg2);
        if(this.state.getNumber() != arg2) {
            this.state.setNumber(arg2);
            this.onNumberUpdated();
        }
    }

    public void setText(String arg2) {
        if(!TextUtils.equals(this.state.getText(), ((CharSequence)arg2))) {
            this.state.setText(arg2);
            this.onTextUpdated();
        }
    }

    public void setTextAppearance(int arg2) {
        this.state.setTextAppearanceResId(arg2);
        this.onBadgeTextAppearanceUpdated();
    }

    public void setVerticalOffset(int arg1) {
        this.setVerticalOffsetWithoutText(arg1);
        this.setVerticalOffsetWithText(arg1);
    }

    public void setVerticalOffsetWithText(int arg2) {
        this.state.setVerticalOffsetWithText(arg2);
        this.updateCenterAndBounds();
    }

    public void setVerticalOffsetWithoutText(int arg2) {
        this.state.setVerticalOffsetWithoutText(arg2);
        this.updateCenterAndBounds();
    }

    public void setVerticalPadding(int arg2) {
        if(arg2 != this.state.getBadgeVerticalPadding()) {
            this.state.setBadgeVerticalPadding(arg2);
            this.updateCenterAndBounds();
        }
    }

    public void setVisible(boolean arg2) {
        this.state.setVisible(arg2);
        this.onVisibilityUpdated();
    }

    private void tryWrapAnchorInCompatParent(View arg6) {
        ViewParent v0 = arg6.getParent();
        if(v0 == null || ((ViewGroup)v0).getId() != id.mtrl_anchor_parent) {
            WeakReference v1 = this.customBadgeParentRef;
            if(v1 != null && v1.get() == v0) {
                return;
            }
        }
        else {
            return;
        }

        BadgeDrawable.updateAnchorParentToNotClip(arg6);
        FrameLayout v1_1 = new FrameLayout(arg6.getContext());
        v1_1.setId(id.mtrl_anchor_parent);
        v1_1.setClipChildren(false);
        v1_1.setClipToPadding(false);
        v1_1.setLayoutParams(arg6.getLayoutParams());
        v1_1.setMinimumWidth(arg6.getWidth());
        v1_1.setMinimumHeight(arg6.getHeight());
        int v2 = ((ViewGroup)v0).indexOfChild(arg6);
        ((ViewGroup)v0).removeViewAt(v2);
        arg6.setLayoutParams(new FrameLayout$LayoutParams(-1, -1));
        v1_1.addView(arg6);
        ((ViewGroup)v0).addView(((View)v1_1), v2);
        this.customBadgeParentRef = new WeakReference(v1_1);
        v1_1.post(new Runnable(arg6, v1_1) {
            public void run() {
                BadgeDrawable.this.updateBadgeCoordinates(this.val$anchorView, this.val$frameLayout);
            }
        });
    }

    private static void updateAnchorParentToNotClip(View arg1) {
        ViewParent v1 = arg1.getParent();
        ((ViewGroup)v1).setClipChildren(false);
        ((ViewGroup)v1).setClipToPadding(false);
    }

    public void updateBadgeCoordinates(View arg2, FrameLayout arg3) {
        this.anchorViewRef = new WeakReference(arg2);
        if(!BadgeUtils.USE_COMPAT_PARENT || arg3 != null) {
            this.customBadgeParentRef = new WeakReference(arg3);
        }
        else {
            this.tryWrapAnchorInCompatParent(arg2);
        }

        if(!BadgeUtils.USE_COMPAT_PARENT) {
            BadgeDrawable.updateAnchorParentToNotClip(arg2);
        }

        this.updateCenterAndBounds();
        this.invalidateSelf();
    }

    public void updateBadgeCoordinates(View arg2) {
        this.updateBadgeCoordinates(arg2, null);
    }

    @Deprecated public void updateBadgeCoordinates(View arg2, ViewGroup arg3) {
        if((arg3 instanceof FrameLayout)) {
            this.updateBadgeCoordinates(arg2, ((FrameLayout)arg3));
            return;
        }

        throw new IllegalArgumentException("customBadgeParent must be a FrameLayout");
    }

    private void updateCenterAndBounds() {
        ViewParent v2_1;
        Object v0 = this.contextRef.get();
        WeakReference v1 = this.anchorViewRef;
        Object v2 = null;
        Object v1_1 = v1 != null ? v1.get() : v2;
        if(v0 != null) {
            if(v1_1 == null) {
            }
            else {
                Rect v0_1 = new Rect();
                v0_1.set(this.badgeBounds);
                Rect v3 = new Rect();
                ((View)v1_1).getDrawingRect(v3);
                WeakReference v4 = this.customBadgeParentRef;
                if(v4 != null) {
                    v2 = v4.get();
                }

                if(v2 != null || (BadgeUtils.USE_COMPAT_PARENT)) {
                    if(v2 == null) {
                        v2_1 = ((View)v1_1).getParent();
                    }

                    ((ViewGroup)v2_1).offsetDescendantRectToMyCoords(((View)v1_1), v3);
                }

                this.calculateCenterAndBounds(v3, ((View)v1_1));
                BadgeUtils.updateBadgeBounds(this.badgeBounds, this.badgeCenterX, this.badgeCenterY, this.halfBadgeWidth, this.halfBadgeHeight);
                float v1_2 = this.cornerRadius;
                if(v1_2 != -1f) {
                    this.shapeDrawable.setCornerSize(v1_2);
                }

                if(v0_1.equals(this.badgeBounds)) {
                    return;
                }

                this.shapeDrawable.setBounds(this.badgeBounds);
            }
        }
    }

    private void updateMaxBadgeNumber() {
        if(this.getMaxCharacterCount() != -2) {
            this.maxBadgeNumber = (((int)Math.pow(10, (((double)this.getMaxCharacterCount())) - 1))) - 1;
            return;
        }

        this.maxBadgeNumber = this.getMaxNumber();
    }
}

