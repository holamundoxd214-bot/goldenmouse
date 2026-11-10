package com.google.android.material.chip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.Paint$Align;
import android.graphics.Paint$FontMetrics;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff$Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable$Callback;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.util.AttributeSet;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.ColorUtils;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.graphics.drawable.TintAwareDrawable;
import androidx.core.text.BidiFormatter;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.canvas.CanvasCompat;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.drawable.DrawableUtils;
import com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shape.MaterialShapeDrawable;
import java.lang.ref.WeakReference;
import java.util.Arrays;

public class ChipDrawable extends MaterialShapeDrawable implements Drawable$Callback, TintAwareDrawable, TextDrawableDelegate {
    public interface Delegate {
        void onChipDrawableSizeChange();
    }

    private static final boolean DEBUG = false;
    private static final int[] DEFAULT_STATE = null;
    private static final int MAX_CHIP_ICON_HEIGHT = 24;
    private static final String NAMESPACE_APP = "http://schemas.android.com/apk/res-auto";
    private int alpha;
    private boolean checkable;
    private Drawable checkedIcon;
    private ColorStateList checkedIconTint;
    private boolean checkedIconVisible;
    private ColorStateList chipBackgroundColor;
    private float chipCornerRadius;
    private float chipEndPadding;
    private Drawable chipIcon;
    private float chipIconSize;
    private ColorStateList chipIconTint;
    private boolean chipIconVisible;
    private float chipMinHeight;
    private final Paint chipPaint;
    private float chipStartPadding;
    private ColorStateList chipStrokeColor;
    private float chipStrokeWidth;
    private ColorStateList chipSurfaceColor;
    private Drawable closeIcon;
    private CharSequence closeIconContentDescription;
    private float closeIconEndPadding;
    private Drawable closeIconRipple;
    private static final ShapeDrawable closeIconRippleMask;
    private float closeIconSize;
    private float closeIconStartPadding;
    private int[] closeIconStateSet;
    private ColorStateList closeIconTint;
    private boolean closeIconVisible;
    private ColorFilter colorFilter;
    private ColorStateList compatRippleColor;
    private final Context context;
    private boolean currentChecked;
    private int currentChipBackgroundColor;
    private int currentChipStrokeColor;
    private int currentChipSurfaceColor;
    private int currentCompatRippleColor;
    private int currentCompositeSurfaceBackgroundColor;
    private int currentTextColor;
    private int currentTint;
    private final Paint debugPaint;
    private WeakReference delegate;
    private final Paint$FontMetrics fontMetrics;
    private boolean hasChipIconTint;
    private MotionSpec hideMotionSpec;
    private float iconEndPadding;
    private float iconStartPadding;
    private boolean isShapeThemingEnabled;
    private int maxWidth;
    private final PointF pointF;
    private final RectF rectF;
    private ColorStateList rippleColor;
    private final Path shapePath;
    private boolean shouldDrawText;
    private MotionSpec showMotionSpec;
    private CharSequence text;
    private final TextDrawableHelper textDrawableHelper;
    private float textEndPadding;
    private float textStartPadding;
    private ColorStateList tint;
    private PorterDuffColorFilter tintFilter;
    private PorterDuff$Mode tintMode;
    private TextUtils$TruncateAt truncateAt;
    private boolean useCompatRipple;

    static {
        ChipDrawable.DEFAULT_STATE = new int[]{0x101009E};
        ChipDrawable.closeIconRippleMask = new ShapeDrawable(new OvalShape());
    }

    private ChipDrawable(Context arg2, AttributeSet arg3, int arg4, int arg5) {
        super(arg2, arg3, arg4, arg5);
        this.chipCornerRadius = -1f;
        this.chipPaint = new Paint(1);
        this.fontMetrics = new Paint$FontMetrics();
        this.rectF = new RectF();
        this.pointF = new PointF();
        this.shapePath = new Path();
        this.alpha = 0xFF;
        this.tintMode = PorterDuff$Mode.SRC_IN;
        this.delegate = new WeakReference(null);
        this.initializeElevationOverlay(arg2);
        this.context = arg2;
        TextDrawableHelper v3 = new TextDrawableHelper(((TextDrawableDelegate)this));
        this.textDrawableHelper = v3;
        this.text = "";
        v3.getTextPaint().density = arg2.getResources().getDisplayMetrics().density;
        this.debugPaint = null;
        int[] v2 = ChipDrawable.DEFAULT_STATE;
        this.setState(v2);
        this.setCloseIconState(v2);
        this.shouldDrawText = true;
        if(RippleUtils.USE_FRAMEWORK_RIPPLE) {
            ChipDrawable.closeIconRippleMask.setTint(-1);
        }
    }

    private void applyChildDrawable(Drawable arg3) {
        if(arg3 == null) {
        }
        else {
            arg3.setCallback(((Drawable$Callback)this));
            DrawableCompat.setLayoutDirection(arg3, DrawableCompat.getLayoutDirection(((Drawable)this)));
            arg3.setLevel(this.getLevel());
            arg3.setVisible(this.isVisible(), false);
            if(arg3 == this.closeIcon) {
                if(arg3.isStateful()) {
                    arg3.setState(this.getCloseIconState());
                }

                DrawableCompat.setTintList(arg3, this.closeIconTint);
                return;
            }
            else {
                Drawable v0 = this.chipIcon;
                if(arg3 == v0 && (this.hasChipIconTint)) {
                    DrawableCompat.setTintList(v0, this.chipIconTint);
                }

                if(!arg3.isStateful()) {
                    return;
                }

                arg3.setState(this.getState());
            }
        }
    }

    private void calculateChipIconBounds(Rect arg4, RectF arg5) {
        arg5.setEmpty();
        if(!this.showsChipIcon()) {
            if(this.showsCheckedIcon()) {
            }
            else {
                return;
            }
        }

        float v0 = this.chipStartPadding + this.iconStartPadding;
        float v1 = this.getCurrentChipIconWidth();
        if(DrawableCompat.getLayoutDirection(((Drawable)this)) == 0) {
            arg5.left = (((float)arg4.left)) + v0;
            arg5.right = arg5.left + v1;
        }
        else {
            arg5.right = (((float)arg4.right)) - v0;
            arg5.left = arg5.right - v1;
        }

        float v3 = this.getCurrentChipIconHeight();
        arg5.top = arg4.exactCenterY() - v3 / 2f;
        arg5.bottom = arg5.top + v3;
    }

    float calculateChipIconWidth() {
        if(!this.showsChipIcon()) {
            if(this.showsCheckedIcon()) {
            }
            else {
                return 0;
            }
        }

        return this.iconStartPadding + this.getCurrentChipIconWidth() + this.iconEndPadding;
    }

    private void calculateChipTouchBounds(Rect arg3, RectF arg4) {
        arg4.set(arg3);
        if(this.showsCloseIcon()) {
            float v0 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if(DrawableCompat.getLayoutDirection(((Drawable)this)) == 0) {
                arg4.right = (((float)arg3.right)) - v0;
                return;
            }
            else {
                arg4.left = (((float)arg3.left)) + v0;
            }
        }
    }

    private void calculateCloseIconBounds(Rect arg3, RectF arg4) {
        arg4.setEmpty();
        if(this.showsCloseIcon()) {
            float v0 = this.chipEndPadding + this.closeIconEndPadding;
            if(DrawableCompat.getLayoutDirection(((Drawable)this)) == 0) {
                arg4.right = (((float)arg3.right)) - v0;
                arg4.left = arg4.right - this.closeIconSize;
            }
            else {
                arg4.left = (((float)arg3.left)) + v0;
                arg4.right = arg4.left + this.closeIconSize;
            }

            arg4.top = arg3.exactCenterY() - this.closeIconSize / 2f;
            arg4.bottom = arg4.top + this.closeIconSize;
        }
    }

    private void calculateCloseIconTouchBounds(Rect arg3, RectF arg4) {
        arg4.setEmpty();
        if(this.showsCloseIcon()) {
            float v0 = this.chipEndPadding + this.closeIconEndPadding + this.closeIconSize + this.closeIconStartPadding + this.textEndPadding;
            if(DrawableCompat.getLayoutDirection(((Drawable)this)) == 0) {
                arg4.right = ((float)arg3.right);
                arg4.left = arg4.right - v0;
            }
            else {
                arg4.left = ((float)arg3.left);
                arg4.right = (((float)arg3.left)) + v0;
            }

            arg4.top = ((float)arg3.top);
            arg4.bottom = ((float)arg3.bottom);
        }
    }

    float calculateCloseIconWidth() {
        if(this.showsCloseIcon()) {
            return this.closeIconStartPadding + this.closeIconSize + this.closeIconEndPadding;
        }

        return 0;
    }

    private void calculateTextBounds(Rect arg4, RectF arg5) {
        arg5.setEmpty();
        if(this.text != null) {
            float v0 = this.chipStartPadding + this.calculateChipIconWidth() + this.textStartPadding;
            float v1 = this.chipEndPadding + this.calculateCloseIconWidth() + this.textEndPadding;
            if(DrawableCompat.getLayoutDirection(((Drawable)this)) == 0) {
                arg5.left = (((float)arg4.left)) + v0;
                arg5.right = (((float)arg4.right)) - v1;
            }
            else {
                arg5.left = (((float)arg4.left)) + v1;
                arg5.right = (((float)arg4.right)) - v0;
            }

            arg5.top = ((float)arg4.top);
            arg5.bottom = ((float)arg4.bottom);
        }
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2f;
    }

    Paint$Align calculateTextOriginAndAlignment(Rect arg3, PointF arg4) {
        arg4.set(0f, 0f);
        Paint$Align v0 = Paint$Align.LEFT;
        if(this.text != null) {
            float v0_1 = this.chipStartPadding + this.calculateChipIconWidth() + this.textStartPadding;
            if(DrawableCompat.getLayoutDirection(((Drawable)this)) == 0) {
                arg4.x = (((float)arg3.left)) + v0_1;
                v0 = Paint$Align.LEFT;
            }
            else {
                arg4.x = (((float)arg3.right)) - v0_1;
                v0 = Paint$Align.RIGHT;
            }

            arg4.y = (((float)arg3.centerY())) - this.calculateTextCenterFromBaseline();
        }

        return v0;
    }

    private boolean canShowCheckedIcon() {
        if((this.checkedIconVisible) && this.checkedIcon != null && (this.checkable)) {
            return 1;
        }

        return 0;
    }

    public static ChipDrawable createFromAttributes(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        ChipDrawable v0 = new ChipDrawable(arg1, arg2, arg3, arg4);
        v0.loadFromAttributes(arg2, arg3, arg4);
        return v0;
    }

    public static ChipDrawable createFromResource(Context arg2, int arg3) {
        AttributeSet v3 = DrawableUtils.parseDrawableXml(arg2, arg3, "chip");
        int v0 = v3.getStyleAttribute();
        if(v0 == 0) {
            v0 = style.Widget_MaterialComponents_Chip_Entry;
        }

        return ChipDrawable.createFromAttributes(arg2, v3, attr.chipStandaloneStyle, v0);
    }

    public void draw(Canvas arg10) {
        int v10;
        Canvas v3;
        Rect v0 = this.getBounds();
        if(!v0.isEmpty()) {
            if(this.getAlpha() == 0) {
            }
            else {
                int v2 = 0xFF;
                if(this.alpha < v2) {
                    v3 = arg10;
                    v10 = CanvasCompat.saveLayerAlpha(v3, ((float)v0.left), ((float)v0.top), ((float)v0.right), ((float)v0.bottom), this.alpha);
                }
                else {
                    v3 = arg10;
                    v10 = 0;
                }

                this.drawChipSurface(v3, v0);
                this.drawChipBackground(v3, v0);
                if(this.isShapeThemingEnabled) {
                    super.draw(v3);
                }

                this.drawChipStroke(v3, v0);
                this.drawCompatRipple(v3, v0);
                this.drawChipIcon(v3, v0);
                this.drawCheckedIcon(v3, v0);
                if(this.shouldDrawText) {
                    this.drawText(v3, v0);
                }

                this.drawCloseIcon(v3, v0);
                this.drawDebug(v3, v0);
                if(this.alpha >= v2) {
                    return;
                }

                v3.restoreToCount(v10);
            }
        }
    }

    private void drawCheckedIcon(Canvas arg6, Rect arg7) {
        if(this.showsCheckedIcon()) {
            this.calculateChipIconBounds(arg7, this.rectF);
            float v7 = this.rectF.left;
            float v0 = this.rectF.top;
            arg6.translate(v7, v0);
            this.checkedIcon.setBounds(0, 0, ((int)this.rectF.width()), ((int)this.rectF.height()));
            this.checkedIcon.draw(arg6);
            arg6.translate(-v7, -v0);
        }
    }

    private void drawChipBackground(Canvas arg3, Rect arg4) {
        if(!this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipBackgroundColor);
            this.chipPaint.setStyle(Paint$Style.FILL);
            this.chipPaint.setColorFilter(this.getTintColorFilter());
            this.rectF.set(arg4);
            arg3.drawRoundRect(this.rectF, this.getChipCornerRadius(), this.getChipCornerRadius(), this.chipPaint);
        }
    }

    private void drawChipIcon(Canvas arg6, Rect arg7) {
        if(this.showsChipIcon()) {
            this.calculateChipIconBounds(arg7, this.rectF);
            float v7 = this.rectF.left;
            float v0 = this.rectF.top;
            arg6.translate(v7, v0);
            this.chipIcon.setBounds(0, 0, ((int)this.rectF.width()), ((int)this.rectF.height()));
            this.chipIcon.draw(arg6);
            arg6.translate(-v7, -v0);
        }
    }

    private void drawChipStroke(Canvas arg7, Rect arg8) {
        if(this.chipStrokeWidth > 0f && !this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipStrokeColor);
            this.chipPaint.setStyle(Paint$Style.STROKE);
            if(!this.isShapeThemingEnabled) {
                this.chipPaint.setColorFilter(this.getTintColorFilter());
            }

            this.rectF.set((((float)arg8.left)) + this.chipStrokeWidth / 2f, (((float)arg8.top)) + this.chipStrokeWidth / 2f, (((float)arg8.right)) - this.chipStrokeWidth / 2f, (((float)arg8.bottom)) - this.chipStrokeWidth / 2f);
            float v8 = this.chipCornerRadius - this.chipStrokeWidth / 2f;
            arg7.drawRoundRect(this.rectF, v8, v8, this.chipPaint);
        }
    }

    private void drawChipSurface(Canvas arg3, Rect arg4) {
        if(!this.isShapeThemingEnabled) {
            this.chipPaint.setColor(this.currentChipSurfaceColor);
            this.chipPaint.setStyle(Paint$Style.FILL);
            this.rectF.set(arg4);
            arg3.drawRoundRect(this.rectF, this.getChipCornerRadius(), this.getChipCornerRadius(), this.chipPaint);
        }
    }

    private void drawCloseIcon(Canvas arg6, Rect arg7) {
        if(this.showsCloseIcon()) {
            this.calculateCloseIconBounds(arg7, this.rectF);
            float v7 = this.rectF.left;
            float v0 = this.rectF.top;
            arg6.translate(v7, v0);
            this.closeIcon.setBounds(0, 0, ((int)this.rectF.width()), ((int)this.rectF.height()));
            if(RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.closeIconRipple.setBounds(this.closeIcon.getBounds());
                this.closeIconRipple.jumpToCurrentState();
                this.closeIconRipple.draw(arg6);
            }
            else {
                this.closeIcon.draw(arg6);
            }

            arg6.translate(-v7, -v0);
        }
    }

    private void drawCompatRipple(Canvas arg3, Rect arg4) {
        this.chipPaint.setColor(this.currentCompatRippleColor);
        this.chipPaint.setStyle(Paint$Style.FILL);
        this.rectF.set(arg4);
        if(!this.isShapeThemingEnabled) {
            arg3.drawRoundRect(this.rectF, this.getChipCornerRadius(), this.getChipCornerRadius(), this.chipPaint);
            return;
        }

        this.calculatePathForSize(new RectF(arg4), this.shapePath);
        super.drawShape(arg3, this.chipPaint, this.shapePath, this.getBoundsAsRectF());
    }

    private void drawDebug(Canvas arg10, Rect arg11) {
        Canvas v3;
        Paint v0 = this.debugPaint;
        if(v0 != null) {
            int v2 = 0x7F;
            v0.setColor(ColorUtils.setAlphaComponent(0xFF000000, v2));
            arg10.drawRect(arg11, this.debugPaint);
            if((this.showsChipIcon()) || (this.showsCheckedIcon())) {
                this.calculateChipIconBounds(arg11, this.rectF);
                arg10.drawRect(this.rectF, this.debugPaint);
            }

            if(this.text != null) {
                v3 = arg10;
                v3.drawLine(((float)arg11.left), arg11.exactCenterY(), ((float)arg11.right), arg11.exactCenterY(), this.debugPaint);
            }
            else {
                v3 = arg10;
            }

            if(this.showsCloseIcon()) {
                this.calculateCloseIconBounds(arg11, this.rectF);
                v3.drawRect(this.rectF, this.debugPaint);
            }

            this.debugPaint.setColor(ColorUtils.setAlphaComponent(0xFFFF0000, v2));
            this.calculateChipTouchBounds(arg11, this.rectF);
            v3.drawRect(this.rectF, this.debugPaint);
            this.debugPaint.setColor(ColorUtils.setAlphaComponent(0xFF00FF00, v2));
            this.calculateCloseIconTouchBounds(arg11, this.rectF);
            v3.drawRect(this.rectF, this.debugPaint);
        }
    }

    private void drawText(Canvas arg10, Rect arg11) {
        if(this.text != null) {
            Paint$Align v0 = this.calculateTextOriginAndAlignment(arg11, this.pointF);
            this.calculateTextBounds(arg11, this.rectF);
            if(this.textDrawableHelper.getTextAppearance() != null) {
                this.textDrawableHelper.getTextPaint().drawableState = this.getState();
                this.textDrawableHelper.updateTextPaintDrawState(this.context);
            }

            this.textDrawableHelper.getTextPaint().setTextAlign(v0);
            int v1 = 0;
            int v11 = Math.round(this.textDrawableHelper.getTextWidth(this.getText().toString())) > Math.round(this.rectF.width()) ? 1 : 0;
            if(v11 != 0) {
                v1 = arg10.save();
                arg10.clipRect(this.rectF);
            }

            CharSequence v0_1 = this.text;
            if(v11 != 0 && this.truncateAt != null) {
                v0_1 = TextUtils.ellipsize(v0_1, this.textDrawableHelper.getTextPaint(), this.rectF.width(), this.truncateAt);
            }

            Canvas v2 = arg10;
            v2.drawText(v0_1, 0, v0_1.length(), this.pointF.x, this.pointF.y, this.textDrawableHelper.getTextPaint());
            if(v11 == 0) {
                return;
            }

            v2.restoreToCount(v1);
        }
    }

    public int getAlpha() {
        return this.alpha;
    }

    public Drawable getCheckedIcon() {
        return this.checkedIcon;
    }

    public ColorStateList getCheckedIconTint() {
        return this.checkedIconTint;
    }

    public ColorStateList getChipBackgroundColor() {
        return this.chipBackgroundColor;
    }

    public float getChipCornerRadius() {
        if(this.isShapeThemingEnabled) {
            return this.getTopLeftCornerResolvedSize();
        }

        return this.chipCornerRadius;
    }

    public float getChipEndPadding() {
        return this.chipEndPadding;
    }

    public Drawable getChipIcon() {
        Drawable v0 = this.chipIcon;
        if(v0 != null) {
            return DrawableCompat.unwrap(v0);
        }

        return null;
    }

    public float getChipIconSize() {
        return this.chipIconSize;
    }

    public ColorStateList getChipIconTint() {
        return this.chipIconTint;
    }

    public float getChipMinHeight() {
        return this.chipMinHeight;
    }

    public float getChipStartPadding() {
        return this.chipStartPadding;
    }

    public ColorStateList getChipStrokeColor() {
        return this.chipStrokeColor;
    }

    public float getChipStrokeWidth() {
        return this.chipStrokeWidth;
    }

    public void getChipTouchBounds(RectF arg2) {
        this.calculateChipTouchBounds(this.getBounds(), arg2);
    }

    public Drawable getCloseIcon() {
        Drawable v0 = this.closeIcon;
        if(v0 != null) {
            return DrawableCompat.unwrap(v0);
        }

        return null;
    }

    public CharSequence getCloseIconContentDescription() {
        return this.closeIconContentDescription;
    }

    public float getCloseIconEndPadding() {
        return this.closeIconEndPadding;
    }

    public float getCloseIconSize() {
        return this.closeIconSize;
    }

    public float getCloseIconStartPadding() {
        return this.closeIconStartPadding;
    }

    public int[] getCloseIconState() {
        return this.closeIconStateSet;
    }

    public ColorStateList getCloseIconTint() {
        return this.closeIconTint;
    }

    public void getCloseIconTouchBounds(RectF arg2) {
        this.calculateCloseIconTouchBounds(this.getBounds(), arg2);
    }

    public ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    private float getCurrentChipIconHeight() {
        Drawable v0 = this.currentChecked ? this.checkedIcon : this.chipIcon;
        float v1 = this.chipIconSize;
        if(v1 <= 0f && v0 != null) {
            float v3 = ((float)Math.ceil(((double)ViewUtils.dpToPx(this.context, 24))));
            if((((float)v0.getIntrinsicHeight())) <= v3) {
                v3 = ((float)v0.getIntrinsicHeight());
            }

            return v3;
        }

        return v1;
    }

    private float getCurrentChipIconWidth() {
        Drawable v0 = this.currentChecked ? this.checkedIcon : this.chipIcon;
        float v2 = this.chipIconSize;
        if(v2 <= 0f && v0 != null) {
            v2 = ((float)v0.getIntrinsicWidth());
        }

        return v2;
    }

    public TextUtils$TruncateAt getEllipsize() {
        return this.truncateAt;
    }

    public MotionSpec getHideMotionSpec() {
        return this.hideMotionSpec;
    }

    public float getIconEndPadding() {
        return this.iconEndPadding;
    }

    public float getIconStartPadding() {
        return this.iconStartPadding;
    }

    public int getIntrinsicHeight() {
        return ((int)this.chipMinHeight);
    }

    public int getIntrinsicWidth() {
        return Math.min(Math.round(this.chipStartPadding + this.calculateChipIconWidth() + this.textStartPadding + this.textDrawableHelper.getTextWidth(this.getText().toString()) + this.textEndPadding + this.calculateCloseIconWidth() + this.chipEndPadding), this.maxWidth);
    }

    public int getMaxWidth() {
        return this.maxWidth;
    }

    public int getOpacity() {
        return -3;
    }

    public void getOutline(Outline arg9) {
        Outline v2;
        if(this.isShapeThemingEnabled) {
            super.getOutline(arg9);
            return;
        }

        Rect v0 = this.getBounds();
        if(!v0.isEmpty()) {
            arg9.setRoundRect(v0, this.chipCornerRadius);
            v2 = arg9;
        }
        else {
            v2 = arg9;
            v2.setRoundRect(0, 0, this.getIntrinsicWidth(), this.getIntrinsicHeight(), this.chipCornerRadius);
        }

        v2.setAlpha((((float)this.getAlpha())) / 255f);
    }

    public ColorStateList getRippleColor() {
        return this.rippleColor;
    }

    public MotionSpec getShowMotionSpec() {
        return this.showMotionSpec;
    }

    public CharSequence getText() {
        return this.text;
    }

    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public float getTextEndPadding() {
        return this.textEndPadding;
    }

    public float getTextStartPadding() {
        return this.textStartPadding;
    }

    private ColorFilter getTintColorFilter() {
        ColorFilter v0 = this.colorFilter;
        if(v0 != null) {
            return v0;
        }

        return this.tintFilter;
    }

    public boolean getUseCompatRipple() {
        return this.useCompatRipple;
    }

    private static boolean hasState(int[] arg4, int arg5) {
        if(arg4 == null) {
            return 0;
        }

        int v1 = arg4.length;
        int v2;
        for(v2 = 0; v2 < v1; ++v2) {
            if(arg4[v2] == arg5) {
                return 1;
            }
        }

        return 0;
    }

    public void invalidateDrawable(Drawable arg1) {
        Drawable$Callback v1 = this.getCallback();
        if(v1 != null) {
            v1.invalidateDrawable(((Drawable)this));
        }
    }

    public boolean isCheckable() {
        return this.checkable;
    }

    @Deprecated public boolean isCheckedIconEnabled() {
        return this.isCheckedIconVisible();
    }

    public boolean isCheckedIconVisible() {
        return this.checkedIconVisible;
    }

    @Deprecated public boolean isChipIconEnabled() {
        return this.isChipIconVisible();
    }

    public boolean isChipIconVisible() {
        return this.chipIconVisible;
    }

    @Deprecated public boolean isCloseIconEnabled() {
        return this.isCloseIconVisible();
    }

    public boolean isCloseIconStateful() {
        return ChipDrawable.isStateful(this.closeIcon);
    }

    public boolean isCloseIconVisible() {
        return this.closeIconVisible;
    }

    boolean isShapeThemingEnabled() {
        return this.isShapeThemingEnabled;
    }

    private static boolean isStateful(ColorStateList arg0) {
        if(arg0 != null && (arg0.isStateful())) {
            return 1;
        }

        return 0;
    }

    private static boolean isStateful(Drawable arg0) {
        if(arg0 != null && (arg0.isStateful())) {
            return 1;
        }

        return 0;
    }

    private static boolean isStateful(TextAppearance arg1) {
        if(arg1 != null && arg1.getTextColor() != null && (arg1.getTextColor().isStateful())) {
            return 1;
        }

        return 0;
    }

    public boolean isStateful() {
        if(!ChipDrawable.isStateful(this.chipSurfaceColor) && !ChipDrawable.isStateful(this.chipBackgroundColor) && !ChipDrawable.isStateful(this.chipStrokeColor) && (!this.useCompatRipple || !ChipDrawable.isStateful(this.compatRippleColor)) && !ChipDrawable.isStateful(this.textDrawableHelper.getTextAppearance()) && !this.canShowCheckedIcon() && !ChipDrawable.isStateful(this.chipIcon) && !ChipDrawable.isStateful(this.checkedIcon) && !ChipDrawable.isStateful(this.tint)) {
            return 0;
        }

        return 1;
    }

    private void loadFromAttributes(AttributeSet arg8, int arg9, int arg10) {
        AttributeSet v1 = arg8;
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(this.context, v1, styleable.Chip, arg9, arg10, new int[0]);
        this.isShapeThemingEnabled = v8.hasValue(styleable.Chip_shapeAppearance);
        this.setChipSurfaceColor(MaterialResources.getColorStateList(this.context, v8, styleable.Chip_chipSurfaceColor));
        this.setChipBackgroundColor(MaterialResources.getColorStateList(this.context, v8, styleable.Chip_chipBackgroundColor));
        this.setChipMinHeight(v8.getDimension(styleable.Chip_chipMinHeight, 0f));
        if(v8.hasValue(styleable.Chip_chipCornerRadius)) {
            this.setChipCornerRadius(v8.getDimension(styleable.Chip_chipCornerRadius, 0f));
        }

        this.setChipStrokeColor(MaterialResources.getColorStateList(this.context, v8, styleable.Chip_chipStrokeColor));
        this.setChipStrokeWidth(v8.getDimension(styleable.Chip_chipStrokeWidth, 0f));
        this.setRippleColor(MaterialResources.getColorStateList(this.context, v8, styleable.Chip_rippleColor));
        this.setText(v8.getText(styleable.Chip_android_text));
        TextAppearance v9 = MaterialResources.getTextAppearance(this.context, v8, styleable.Chip_android_textAppearance);
        v9.setTextSize(v8.getDimension(styleable.Chip_android_textSize, v9.getTextSize()));
        this.setTextAppearance(v9);
        arg9 = v8.getInt(styleable.Chip_android_ellipsize, 0);
        if(arg9 == 1) {
            this.setEllipsize(TextUtils$TruncateAt.START);
        }
        else if(arg9 == 2) {
            this.setEllipsize(TextUtils$TruncateAt.MIDDLE);
        }
        else if(arg9 != 3) {
        }
        else {
            this.setEllipsize(TextUtils$TruncateAt.END);
        }

        this.setChipIconVisible(v8.getBoolean(styleable.Chip_chipIconVisible, false));
        String v9_1 = "http://schemas.android.com/apk/res-auto";
        if(v1 != null && v1.getAttributeValue(v9_1, "chipIconEnabled") != null && v1.getAttributeValue(v9_1, "chipIconVisible") == null) {
            this.setChipIconVisible(v8.getBoolean(styleable.Chip_chipIconEnabled, false));
        }

        this.setChipIcon(MaterialResources.getDrawable(this.context, v8, styleable.Chip_chipIcon));
        if(v8.hasValue(styleable.Chip_chipIconTint)) {
            this.setChipIconTint(MaterialResources.getColorStateList(this.context, v8, styleable.Chip_chipIconTint));
        }

        this.setChipIconSize(v8.getDimension(styleable.Chip_chipIconSize, -1f));
        this.setCloseIconVisible(v8.getBoolean(styleable.Chip_closeIconVisible, false));
        if(v1 != null && v1.getAttributeValue(v9_1, "closeIconEnabled") != null && v1.getAttributeValue(v9_1, "closeIconVisible") == null) {
            this.setCloseIconVisible(v8.getBoolean(styleable.Chip_closeIconEnabled, false));
        }

        this.setCloseIcon(MaterialResources.getDrawable(this.context, v8, styleable.Chip_closeIcon));
        this.setCloseIconTint(MaterialResources.getColorStateList(this.context, v8, styleable.Chip_closeIconTint));
        this.setCloseIconSize(v8.getDimension(styleable.Chip_closeIconSize, 0f));
        this.setCheckable(v8.getBoolean(styleable.Chip_android_checkable, false));
        this.setCheckedIconVisible(v8.getBoolean(styleable.Chip_checkedIconVisible, false));
        if(v1 != null && v1.getAttributeValue(v9_1, "checkedIconEnabled") != null && v1.getAttributeValue(v9_1, "checkedIconVisible") == null) {
            this.setCheckedIconVisible(v8.getBoolean(styleable.Chip_checkedIconEnabled, false));
        }

        this.setCheckedIcon(MaterialResources.getDrawable(this.context, v8, styleable.Chip_checkedIcon));
        if(v8.hasValue(styleable.Chip_checkedIconTint)) {
            this.setCheckedIconTint(MaterialResources.getColorStateList(this.context, v8, styleable.Chip_checkedIconTint));
        }

        this.setShowMotionSpec(MotionSpec.createFromAttribute(this.context, v8, styleable.Chip_showMotionSpec));
        this.setHideMotionSpec(MotionSpec.createFromAttribute(this.context, v8, styleable.Chip_hideMotionSpec));
        this.setChipStartPadding(v8.getDimension(styleable.Chip_chipStartPadding, 0f));
        this.setIconStartPadding(v8.getDimension(styleable.Chip_iconStartPadding, 0f));
        this.setIconEndPadding(v8.getDimension(styleable.Chip_iconEndPadding, 0f));
        this.setTextStartPadding(v8.getDimension(styleable.Chip_textStartPadding, 0f));
        this.setTextEndPadding(v8.getDimension(styleable.Chip_textEndPadding, 0f));
        this.setCloseIconStartPadding(v8.getDimension(styleable.Chip_closeIconStartPadding, 0f));
        this.setCloseIconEndPadding(v8.getDimension(styleable.Chip_closeIconEndPadding, 0f));
        this.setChipEndPadding(v8.getDimension(styleable.Chip_chipEndPadding, 0f));
        this.setMaxWidth(v8.getDimensionPixelSize(styleable.Chip_android_maxWidth, 0x7FFFFFFF));
        v8.recycle();
    }

    public boolean onLayoutDirectionChanged(int arg3) {
        int v0_1;
        boolean v0 = super.onLayoutDirectionChanged(arg3);
        if(this.showsChipIcon()) {
            v0_1 = (((int)v0)) | DrawableCompat.setLayoutDirection(this.chipIcon, arg3);
        }

        if(this.showsCheckedIcon()) {
            v0_1 |= DrawableCompat.setLayoutDirection(this.checkedIcon, arg3);
        }

        if(this.showsCloseIcon()) {
            v0_1 |= DrawableCompat.setLayoutDirection(this.closeIcon, arg3);
        }

        if((((boolean)v0_1))) {
            this.invalidateSelf();
        }

        return 1;
    }

    protected boolean onLevelChange(int arg3) {
        int v0_1;
        boolean v0 = super.onLevelChange(arg3);
        if(this.showsChipIcon()) {
            v0_1 = (((int)v0)) | this.chipIcon.setLevel(arg3);
        }

        if(this.showsCheckedIcon()) {
            v0_1 = (((int)v0)) | this.checkedIcon.setLevel(arg3);
        }

        if(this.showsCloseIcon()) {
            v0_1 = (((int)v0)) | this.closeIcon.setLevel(arg3);
        }

        if(v0) {
            this.invalidateSelf();
        }

        return v0;
    }

    protected void onSizeChange() {
        Object v0 = this.delegate.get();
        if(v0 != null) {
            ((Delegate)v0).onChipDrawableSizeChange();
        }
    }

    private boolean onStateChange(int[] arg7, int[] arg8) {
        boolean v4_1;
        boolean v0 = super.onStateChange(arg7);
        ColorStateList v1 = this.chipSurfaceColor;
        int v1_1 = v1 != null ? v1.getColorForState(arg7, this.currentChipSurfaceColor) : 0;
        v1_1 = this.compositeElevationOverlayIfNeeded(v1_1);
        int v4 = 1;
        if(this.currentChipSurfaceColor != v1_1) {
            this.currentChipSurfaceColor = v1_1;
            v0 = true;
        }

        ColorStateList v3 = this.chipBackgroundColor;
        int v3_1 = v3 != null ? v3.getColorForState(arg7, this.currentChipBackgroundColor) : 0;
        v3_1 = this.compositeElevationOverlayIfNeeded(v3_1);
        if(this.currentChipBackgroundColor != v3_1) {
            this.currentChipBackgroundColor = v3_1;
            v0 = true;
        }

        v1_1 = MaterialColors.layer(v1_1, v3_1);
        v3_1 = this.currentCompositeSurfaceBackgroundColor != v1_1 ? 1 : 0;
        int v5 = this.getFillColor() == null ? 1 : 0;
        if((v3_1 | v5) != 0) {
            this.currentCompositeSurfaceBackgroundColor = v1_1;
            this.setFillColor(ColorStateList.valueOf(v1_1));
            v0 = true;
        }

        v1 = this.chipStrokeColor;
        v1_1 = v1 != null ? v1.getColorForState(arg7, this.currentChipStrokeColor) : 0;
        if(this.currentChipStrokeColor != v1_1) {
            this.currentChipStrokeColor = v1_1;
            v0 = true;
        }

        v1_1 = this.compatRippleColor == null || !RippleUtils.shouldDrawRippleCompat(arg7) ? 0 : this.compatRippleColor.getColorForState(arg7, this.currentCompatRippleColor);
        if(this.currentCompatRippleColor != v1_1) {
            this.currentCompatRippleColor = v1_1;
            if(this.useCompatRipple) {
                v0 = true;
            }
        }

        v1_1 = this.textDrawableHelper.getTextAppearance() == null || this.textDrawableHelper.getTextAppearance().getTextColor() == null ? 0 : this.textDrawableHelper.getTextAppearance().getTextColor().getColorForState(arg7, this.currentTextColor);
        if(this.currentTextColor != v1_1) {
            this.currentTextColor = v1_1;
            v0 = true;
        }

        boolean v1_2 = !ChipDrawable.hasState(this.getState(), 0x10100A0) || !this.checkable ? false : true;
        if(this.currentChecked == v1_2 || this.checkedIcon == null) {
            v1_1 = 0;
        }
        else {
            float v0_1 = this.calculateChipIconWidth();
            this.currentChecked = v1_2;
            if(v0_1 != this.calculateChipIconWidth()) {
                v0 = true;
                v1_1 = 1;
            }
            else {
                v1_1 = 0;
                v0 = true;
            }
        }

        v3 = this.tint;
        v3_1 = v3 != null ? v3.getColorForState(arg7, this.currentTint) : 0;
        if(this.currentTint != v3_1) {
            this.currentTint = v3_1;
            this.tintFilter = DrawableUtils.updateTintFilter(((Drawable)this), this.tint, this.tintMode);
        }
        else {
            v4_1 = v0;
        }

        if(ChipDrawable.isStateful(this.chipIcon)) {
            v4 = (((int)v4_1)) | this.chipIcon.setState(arg7);
        }

        if(ChipDrawable.isStateful(this.checkedIcon)) {
            v4 = (((int)v4_1)) | this.checkedIcon.setState(arg7);
        }

        if(ChipDrawable.isStateful(this.closeIcon)) {
            int[] v0_2 = new int[arg7.length + arg8.length];
            System.arraycopy(arg7, 0, v0_2, 0, arg7.length);
            System.arraycopy(arg8, 0, v0_2, arg7.length, arg8.length);
            v4 = (((int)v4_1)) | this.closeIcon.setState(v0_2);
        }

        if((RippleUtils.USE_FRAMEWORK_RIPPLE) && (ChipDrawable.isStateful(this.closeIconRipple))) {
            v4 = (((int)v4_1)) | this.closeIconRipple.setState(arg8);
        }

        if(v4_1) {
            this.invalidateSelf();
        }

        if(v1_1 != 0) {
            this.onSizeChange();
        }

        return v4_1;
    }

    public boolean onStateChange(int[] arg2) {
        if(this.isShapeThemingEnabled) {
            super.onStateChange(arg2);
        }

        return this.onStateChange(arg2, this.getCloseIconState());
    }

    public void onTextSizeChange() {
        this.onSizeChange();
        this.invalidateSelf();
    }

    public void scheduleDrawable(Drawable arg1, Runnable arg2, long arg3) {
        Drawable$Callback v1 = this.getCallback();
        if(v1 != null) {
            v1.scheduleDrawable(((Drawable)this), arg2, arg3);
        }
    }

    public void setAlpha(int arg2) {
        if(this.alpha != arg2) {
            this.alpha = arg2;
            this.invalidateSelf();
        }
    }

    public void setCheckable(boolean arg2) {
        if(this.checkable != arg2) {
            this.checkable = arg2;
            float v0 = this.calculateChipIconWidth();
            if(!arg2 && (this.currentChecked)) {
                this.currentChecked = false;
            }

            float v2 = this.calculateChipIconWidth();
            this.invalidateSelf();
            if(v0 == v2) {
                return;
            }

            this.onSizeChange();
        }
    }

    public void setCheckableResource(int arg2) {
        this.setCheckable(this.context.getResources().getBoolean(arg2));
    }

    public void setCheckedIcon(Drawable arg3) {
        if(this.checkedIcon != arg3) {
            float v0 = this.calculateChipIconWidth();
            this.checkedIcon = arg3;
            float v3 = this.calculateChipIconWidth();
            this.unapplyChildDrawable(this.checkedIcon);
            this.applyChildDrawable(this.checkedIcon);
            this.invalidateSelf();
            if(v0 != v3) {
                this.onSizeChange();
            }
        }
    }

    @Deprecated public void setCheckedIconEnabled(boolean arg1) {
        this.setCheckedIconVisible(arg1);
    }

    @Deprecated public void setCheckedIconEnabledResource(int arg2) {
        this.setCheckedIconVisible(this.context.getResources().getBoolean(arg2));
    }

    public void setCheckedIconResource(int arg2) {
        this.setCheckedIcon(AppCompatResources.getDrawable(this.context, arg2));
    }

    public void setCheckedIconTint(ColorStateList arg2) {
        if(this.checkedIconTint != arg2) {
            this.checkedIconTint = arg2;
            if(this.canShowCheckedIcon()) {
                DrawableCompat.setTintList(this.checkedIcon, arg2);
            }

            this.onStateChange(this.getState());
        }
    }

    public void setCheckedIconTintResource(int arg2) {
        this.setCheckedIconTint(AppCompatResources.getColorStateList(this.context, arg2));
    }

    public void setCheckedIconVisible(int arg2) {
        this.setCheckedIconVisible(this.context.getResources().getBoolean(arg2));
    }

    public void setCheckedIconVisible(boolean arg2) {
        if(this.checkedIconVisible != arg2) {
            boolean v0 = this.showsCheckedIcon();
            this.checkedIconVisible = arg2;
            arg2 = this.showsCheckedIcon();
            if(v0 != arg2) {
                Drawable v0_1 = this.checkedIcon;
                if(arg2) {
                    this.applyChildDrawable(v0_1);
                }
                else {
                    this.unapplyChildDrawable(v0_1);
                }

                this.invalidateSelf();
                this.onSizeChange();
            }
        }
    }

    public void setChipBackgroundColor(ColorStateList arg2) {
        if(this.chipBackgroundColor != arg2) {
            this.chipBackgroundColor = arg2;
            this.onStateChange(this.getState());
        }
    }

    public void setChipBackgroundColorResource(int arg2) {
        this.setChipBackgroundColor(AppCompatResources.getColorStateList(this.context, arg2));
    }

    @Deprecated public void setChipCornerRadius(float arg2) {
        if(this.chipCornerRadius != arg2) {
            this.chipCornerRadius = arg2;
            this.setShapeAppearanceModel(this.getShapeAppearanceModel().withCornerSize(arg2));
        }
    }

    @Deprecated public void setChipCornerRadiusResource(int arg2) {
        this.setChipCornerRadius(this.context.getResources().getDimension(arg2));
    }

    public void setChipEndPadding(float arg2) {
        if(this.chipEndPadding != arg2) {
            this.chipEndPadding = arg2;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setChipEndPaddingResource(int arg2) {
        this.setChipEndPadding(this.context.getResources().getDimension(arg2));
    }

    public void setChipIcon(Drawable arg3) {
        Drawable v0 = this.getChipIcon();
        if(v0 != arg3) {
            float v1 = this.calculateChipIconWidth();
            arg3 = arg3 != null ? DrawableCompat.wrap(arg3).mutate() : null;
            this.chipIcon = arg3;
            float v3 = this.calculateChipIconWidth();
            this.unapplyChildDrawable(v0);
            if(this.showsChipIcon()) {
                this.applyChildDrawable(this.chipIcon);
            }

            this.invalidateSelf();
            if(v1 == v3) {
                return;
            }

            this.onSizeChange();
        }
    }

    @Deprecated public void setChipIconEnabled(boolean arg1) {
        this.setChipIconVisible(arg1);
    }

    @Deprecated public void setChipIconEnabledResource(int arg1) {
        this.setChipIconVisible(arg1);
    }

    public void setChipIconResource(int arg2) {
        this.setChipIcon(AppCompatResources.getDrawable(this.context, arg2));
    }

    public void setChipIconSize(float arg2) {
        if(this.chipIconSize != arg2) {
            float v0 = this.calculateChipIconWidth();
            this.chipIconSize = arg2;
            arg2 = this.calculateChipIconWidth();
            this.invalidateSelf();
            if(v0 != arg2) {
                this.onSizeChange();
            }
        }
    }

    public void setChipIconSizeResource(int arg2) {
        this.setChipIconSize(this.context.getResources().getDimension(arg2));
    }

    public void setChipIconTint(ColorStateList arg2) {
        this.hasChipIconTint = true;
        if(this.chipIconTint != arg2) {
            this.chipIconTint = arg2;
            if(this.showsChipIcon()) {
                DrawableCompat.setTintList(this.chipIcon, arg2);
            }

            this.onStateChange(this.getState());
        }
    }

    public void setChipIconTintResource(int arg2) {
        this.setChipIconTint(AppCompatResources.getColorStateList(this.context, arg2));
    }

    public void setChipIconVisible(int arg2) {
        this.setChipIconVisible(this.context.getResources().getBoolean(arg2));
    }

    public void setChipIconVisible(boolean arg2) {
        if(this.chipIconVisible != arg2) {
            boolean v0 = this.showsChipIcon();
            this.chipIconVisible = arg2;
            arg2 = this.showsChipIcon();
            if(v0 != arg2) {
                Drawable v0_1 = this.chipIcon;
                if(arg2) {
                    this.applyChildDrawable(v0_1);
                }
                else {
                    this.unapplyChildDrawable(v0_1);
                }

                this.invalidateSelf();
                this.onSizeChange();
            }
        }
    }

    public void setChipMinHeight(float arg2) {
        if(this.chipMinHeight != arg2) {
            this.chipMinHeight = arg2;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setChipMinHeightResource(int arg2) {
        this.setChipMinHeight(this.context.getResources().getDimension(arg2));
    }

    public void setChipStartPadding(float arg2) {
        if(this.chipStartPadding != arg2) {
            this.chipStartPadding = arg2;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setChipStartPaddingResource(int arg2) {
        this.setChipStartPadding(this.context.getResources().getDimension(arg2));
    }

    public void setChipStrokeColor(ColorStateList arg2) {
        if(this.chipStrokeColor != arg2) {
            this.chipStrokeColor = arg2;
            if(this.isShapeThemingEnabled) {
                this.setStrokeColor(arg2);
            }

            this.onStateChange(this.getState());
        }
    }

    public void setChipStrokeColorResource(int arg2) {
        this.setChipStrokeColor(AppCompatResources.getColorStateList(this.context, arg2));
    }

    public void setChipStrokeWidth(float arg2) {
        if(this.chipStrokeWidth != arg2) {
            this.chipStrokeWidth = arg2;
            this.chipPaint.setStrokeWidth(arg2);
            if(this.isShapeThemingEnabled) {
                super.setStrokeWidth(arg2);
            }

            this.invalidateSelf();
        }
    }

    public void setChipStrokeWidthResource(int arg2) {
        this.setChipStrokeWidth(this.context.getResources().getDimension(arg2));
    }

    private void setChipSurfaceColor(ColorStateList arg2) {
        if(this.chipSurfaceColor != arg2) {
            this.chipSurfaceColor = arg2;
            this.onStateChange(this.getState());
        }
    }

    public void setCloseIcon(Drawable arg3) {
        Drawable v0 = this.getCloseIcon();
        if(v0 != arg3) {
            float v1 = this.calculateCloseIconWidth();
            arg3 = arg3 != null ? DrawableCompat.wrap(arg3).mutate() : null;
            this.closeIcon = arg3;
            if(RippleUtils.USE_FRAMEWORK_RIPPLE) {
                this.updateFrameworkCloseIconRipple();
            }

            float v3 = this.calculateCloseIconWidth();
            this.unapplyChildDrawable(v0);
            if(this.showsCloseIcon()) {
                this.applyChildDrawable(this.closeIcon);
            }

            this.invalidateSelf();
            if(v1 == v3) {
                return;
            }

            this.onSizeChange();
        }
    }

    public void setCloseIconContentDescription(CharSequence arg2) {
        if(this.closeIconContentDescription != arg2) {
            this.closeIconContentDescription = BidiFormatter.getInstance().unicodeWrap(arg2);
            this.invalidateSelf();
        }
    }

    @Deprecated public void setCloseIconEnabled(boolean arg1) {
        this.setCloseIconVisible(arg1);
    }

    @Deprecated public void setCloseIconEnabledResource(int arg1) {
        this.setCloseIconVisible(arg1);
    }

    public void setCloseIconEndPadding(float arg2) {
        if(this.closeIconEndPadding != arg2) {
            this.closeIconEndPadding = arg2;
            this.invalidateSelf();
            if(this.showsCloseIcon()) {
                this.onSizeChange();
            }
        }
    }

    public void setCloseIconEndPaddingResource(int arg2) {
        this.setCloseIconEndPadding(this.context.getResources().getDimension(arg2));
    }

    public void setCloseIconResource(int arg2) {
        this.setCloseIcon(AppCompatResources.getDrawable(this.context, arg2));
    }

    public void setCloseIconSize(float arg2) {
        if(this.closeIconSize != arg2) {
            this.closeIconSize = arg2;
            this.invalidateSelf();
            if(this.showsCloseIcon()) {
                this.onSizeChange();
            }
        }
    }

    public void setCloseIconSizeResource(int arg2) {
        this.setCloseIconSize(this.context.getResources().getDimension(arg2));
    }

    public void setCloseIconStartPadding(float arg2) {
        if(this.closeIconStartPadding != arg2) {
            this.closeIconStartPadding = arg2;
            this.invalidateSelf();
            if(this.showsCloseIcon()) {
                this.onSizeChange();
            }
        }
    }

    public void setCloseIconStartPaddingResource(int arg2) {
        this.setCloseIconStartPadding(this.context.getResources().getDimension(arg2));
    }

    public boolean setCloseIconState(int[] arg2) {
        if(!Arrays.equals(this.closeIconStateSet, arg2)) {
            this.closeIconStateSet = arg2;
            if(this.showsCloseIcon()) {
                return this.onStateChange(this.getState(), arg2);
            }
        }

        return 0;
    }

    public void setCloseIconTint(ColorStateList arg2) {
        if(this.closeIconTint != arg2) {
            this.closeIconTint = arg2;
            if(this.showsCloseIcon()) {
                DrawableCompat.setTintList(this.closeIcon, arg2);
            }

            this.onStateChange(this.getState());
        }
    }

    public void setCloseIconTintResource(int arg2) {
        this.setCloseIconTint(AppCompatResources.getColorStateList(this.context, arg2));
    }

    public void setCloseIconVisible(boolean arg2) {
        if(this.closeIconVisible != arg2) {
            boolean v0 = this.showsCloseIcon();
            this.closeIconVisible = arg2;
            arg2 = this.showsCloseIcon();
            if(v0 != arg2) {
                Drawable v0_1 = this.closeIcon;
                if(arg2) {
                    this.applyChildDrawable(v0_1);
                }
                else {
                    this.unapplyChildDrawable(v0_1);
                }

                this.invalidateSelf();
                this.onSizeChange();
            }
        }
    }

    public void setCloseIconVisible(int arg2) {
        this.setCloseIconVisible(this.context.getResources().getBoolean(arg2));
    }

    public void setColorFilter(ColorFilter arg2) {
        if(this.colorFilter != arg2) {
            this.colorFilter = arg2;
            this.invalidateSelf();
        }
    }

    public void setDelegate(Delegate arg2) {
        this.delegate = new WeakReference(arg2);
    }

    public void setEllipsize(TextUtils$TruncateAt arg1) {
        this.truncateAt = arg1;
    }

    public void setHideMotionSpec(MotionSpec arg1) {
        this.hideMotionSpec = arg1;
    }

    public void setHideMotionSpecResource(int arg2) {
        this.setHideMotionSpec(MotionSpec.createFromResource(this.context, arg2));
    }

    public void setIconEndPadding(float arg2) {
        if(this.iconEndPadding != arg2) {
            float v0 = this.calculateChipIconWidth();
            this.iconEndPadding = arg2;
            arg2 = this.calculateChipIconWidth();
            this.invalidateSelf();
            if(v0 != arg2) {
                this.onSizeChange();
            }
        }
    }

    public void setIconEndPaddingResource(int arg2) {
        this.setIconEndPadding(this.context.getResources().getDimension(arg2));
    }

    public void setIconStartPadding(float arg2) {
        if(this.iconStartPadding != arg2) {
            float v0 = this.calculateChipIconWidth();
            this.iconStartPadding = arg2;
            arg2 = this.calculateChipIconWidth();
            this.invalidateSelf();
            if(v0 != arg2) {
                this.onSizeChange();
            }
        }
    }

    public void setIconStartPaddingResource(int arg2) {
        this.setIconStartPadding(this.context.getResources().getDimension(arg2));
    }

    public void setMaxWidth(int arg1) {
        this.maxWidth = arg1;
    }

    public void setRippleColor(ColorStateList arg2) {
        if(this.rippleColor != arg2) {
            this.rippleColor = arg2;
            this.updateCompatRippleColor();
            this.onStateChange(this.getState());
        }
    }

    public void setRippleColorResource(int arg2) {
        this.setRippleColor(AppCompatResources.getColorStateList(this.context, arg2));
    }

    void setShouldDrawText(boolean arg1) {
        this.shouldDrawText = arg1;
    }

    public void setShowMotionSpec(MotionSpec arg1) {
        this.showMotionSpec = arg1;
    }

    public void setShowMotionSpecResource(int arg2) {
        this.setShowMotionSpec(MotionSpec.createFromResource(this.context, arg2));
    }

    public void setText(CharSequence arg2) {
        String v2;
        if(arg2 == null) {
            v2 = "";
        }

        if(!TextUtils.equals(this.text, ((CharSequence)v2))) {
            this.text = ((CharSequence)v2);
            this.textDrawableHelper.setTextWidthDirty(true);
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setTextAppearance(TextAppearance arg2) {
        this.textDrawableHelper.setTextAppearance(arg2, this.context);
    }

    public void setTextAppearanceResource(int arg3) {
        this.setTextAppearance(new TextAppearance(this.context, arg3));
    }

    public void setTextColor(int arg1) {
        this.setTextColor(ColorStateList.valueOf(arg1));
    }

    public void setTextColor(ColorStateList arg2) {
        TextAppearance v0 = this.getTextAppearance();
        if(v0 != null) {
            v0.setTextColor(arg2);
            this.invalidateSelf();
        }
    }

    public void setTextEndPadding(float arg2) {
        if(this.textEndPadding != arg2) {
            this.textEndPadding = arg2;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setTextEndPaddingResource(int arg2) {
        this.setTextEndPadding(this.context.getResources().getDimension(arg2));
    }

    public void setTextResource(int arg2) {
        this.setText(this.context.getResources().getString(arg2));
    }

    public void setTextSize(float arg2) {
        TextAppearance v0 = this.getTextAppearance();
        if(v0 != null) {
            v0.setTextSize(arg2);
            this.textDrawableHelper.getTextPaint().setTextSize(arg2);
            this.onTextSizeChange();
        }
    }

    public void setTextStartPadding(float arg2) {
        if(this.textStartPadding != arg2) {
            this.textStartPadding = arg2;
            this.invalidateSelf();
            this.onSizeChange();
        }
    }

    public void setTextStartPaddingResource(int arg2) {
        this.setTextStartPadding(this.context.getResources().getDimension(arg2));
    }

    public void setTintList(ColorStateList arg2) {
        if(this.tint != arg2) {
            this.tint = arg2;
            this.onStateChange(this.getState());
        }
    }

    public void setTintMode(PorterDuff$Mode arg2) {
        if(this.tintMode != arg2) {
            this.tintMode = arg2;
            this.tintFilter = DrawableUtils.updateTintFilter(((Drawable)this), this.tint, arg2);
            this.invalidateSelf();
        }
    }

    public void setUseCompatRipple(boolean arg2) {
        if(this.useCompatRipple != arg2) {
            this.useCompatRipple = arg2;
            this.updateCompatRippleColor();
            this.onStateChange(this.getState());
        }
    }

    public boolean setVisible(boolean arg3, boolean arg4) {
        int v0_1;
        boolean v0 = super.setVisible(arg3, arg4);
        if(this.showsChipIcon()) {
            v0_1 = (((int)v0)) | this.chipIcon.setVisible(arg3, arg4);
        }

        if(this.showsCheckedIcon()) {
            v0_1 = (((int)v0)) | this.checkedIcon.setVisible(arg3, arg4);
        }

        if(this.showsCloseIcon()) {
            v0_1 = (((int)v0)) | this.closeIcon.setVisible(arg3, arg4);
        }

        if(v0) {
            this.invalidateSelf();
        }

        return v0;
    }

    boolean shouldDrawText() {
        return this.shouldDrawText;
    }

    private boolean showsCheckedIcon() {
        if((this.checkedIconVisible) && this.checkedIcon != null && (this.currentChecked)) {
            return 1;
        }

        return 0;
    }

    private boolean showsChipIcon() {
        if((this.chipIconVisible) && this.chipIcon != null) {
            return 1;
        }

        return 0;
    }

    private boolean showsCloseIcon() {
        if((this.closeIconVisible) && this.closeIcon != null) {
            return 1;
        }

        return 0;
    }

    private void unapplyChildDrawable(Drawable arg1) {
        if(arg1 != null) {
            arg1.setCallback(null);
        }
    }

    public void unscheduleDrawable(Drawable arg1, Runnable arg2) {
        Drawable$Callback v1 = this.getCallback();
        if(v1 != null) {
            v1.unscheduleDrawable(((Drawable)this), arg2);
        }
    }

    private void updateCompatRippleColor() {
        ColorStateList v0 = this.useCompatRipple ? RippleUtils.sanitizeRippleDrawableColor(this.rippleColor) : null;
        this.compatRippleColor = v0;
    }

    private void updateFrameworkCloseIconRipple() {
        this.closeIconRipple = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(this.getRippleColor()), this.closeIcon, ChipDrawable.closeIconRippleMask);
    }
}

