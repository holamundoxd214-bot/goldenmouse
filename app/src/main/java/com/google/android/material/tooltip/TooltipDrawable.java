package com.google.android.material.tooltip;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint$Align;
import android.graphics.Paint$FontMetrics;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View$OnLayoutChangeListener;
import android.view.View;
import androidx.core.graphics.ColorUtils;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.internal.TextDrawableHelper$TextDrawableDelegate;
import com.google.android.material.internal.TextDrawableHelper;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.shape.EdgeTreatment;
import com.google.android.material.shape.MarkerEdgeTreatment;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.OffsetEdgeTreatment;

public class TooltipDrawable extends MaterialShapeDrawable implements TextDrawableDelegate {
    class com.google.android.material.tooltip.TooltipDrawable$1 implements View$OnLayoutChangeListener {
        com.google.android.material.tooltip.TooltipDrawable$1(TooltipDrawable arg1) {
            TooltipDrawable.this = arg1;
            super();
        }

        public void onLayoutChange(View arg1, int arg2, int arg3, int arg4, int arg5, int arg6, int arg7, int arg8, int arg9) {
            TooltipDrawable.this.updateLocationOnScreen(arg1);
        }
    }

    private static final int DEFAULT_STYLE;
    private static final int DEFAULT_THEME_ATTR;
    private int arrowSize;
    private final View$OnLayoutChangeListener attachedViewLayoutChangeListener;
    private final Context context;
    private final Rect displayFrame;
    private final Paint$FontMetrics fontMetrics;
    private float labelOpacity;
    private int layoutMargin;
    private int locationOnScreenX;
    private int minHeight;
    private int minWidth;
    private int padding;
    private CharSequence text;
    private final TextDrawableHelper textDrawableHelper;
    private final float tooltipPivotX;
    private float tooltipPivotY;
    private float tooltipScaleX;
    private float tooltipScaleY;

    static {
        TooltipDrawable.DEFAULT_STYLE = style.Widget_MaterialComponents_Tooltip;
        TooltipDrawable.DEFAULT_THEME_ATTR = attr.tooltipStyle;
    }

    private TooltipDrawable(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        super(arg1, arg2, arg3, arg4);
        this.fontMetrics = new Paint$FontMetrics();
        TextDrawableHelper v2 = new TextDrawableHelper(((TextDrawableDelegate)this));
        this.textDrawableHelper = v2;
        this.attachedViewLayoutChangeListener = new com.google.android.material.tooltip.TooltipDrawable$1(this);
        this.displayFrame = new Rect();
        this.tooltipScaleX = 1f;
        this.tooltipScaleY = 1f;
        this.tooltipPivotX = 0.5f;
        this.tooltipPivotY = 0.5f;
        this.labelOpacity = 1f;
        this.context = arg1;
        v2.getTextPaint().density = arg1.getResources().getDisplayMetrics().density;
        v2.getTextPaint().setTextAlign(Paint$Align.CENTER);
    }

    static void access$000(TooltipDrawable arg0, View arg1) {
        arg0.updateLocationOnScreen(arg1);
    }

    private float calculatePointerOffset() {
        int v0 = this.displayFrame.right - this.getBounds().right - this.locationOnScreenX - this.layoutMargin;
        Rect v1 = this.displayFrame;
        if(v0 < 0) {
            v0 = v1.right - this.getBounds().right - this.locationOnScreenX - this.layoutMargin;
        }
        else if(v1.left - this.getBounds().left - this.locationOnScreenX + this.layoutMargin > 0) {
            v0 = this.displayFrame.left - this.getBounds().left - this.locationOnScreenX + this.layoutMargin;
        }
        else {
            return 0;
        }

        return ((float)v0);
    }

    private float calculateTextCenterFromBaseline() {
        this.textDrawableHelper.getTextPaint().getFontMetrics(this.fontMetrics);
        return (this.fontMetrics.descent + this.fontMetrics.ascent) / 2f;
    }

    private float calculateTextOriginAndAlignment(Rect arg1) {
        return (((float)arg1.centerY())) - this.calculateTextCenterFromBaseline();
    }

    public static TooltipDrawable create(Context arg3) {
        return TooltipDrawable.createFromAttributes(arg3, null, TooltipDrawable.DEFAULT_THEME_ATTR, TooltipDrawable.DEFAULT_STYLE);
    }

    public static TooltipDrawable createFromAttributes(Context arg1, AttributeSet arg2, int arg3, int arg4) {
        TooltipDrawable v0 = new TooltipDrawable(arg1, arg2, arg3, arg4);
        v0.loadFromAttributes(arg2, arg3, arg4);
        return v0;
    }

    public static TooltipDrawable createFromAttributes(Context arg2, AttributeSet arg3) {
        return TooltipDrawable.createFromAttributes(arg2, arg3, TooltipDrawable.DEFAULT_THEME_ATTR, TooltipDrawable.DEFAULT_STYLE);
    }

    private EdgeTreatment createMarkerEdge() {
        float v0 = -this.calculatePointerOffset();
        float v1 = (((float)((((double)this.getBounds().width())) - (((double)this.arrowSize)) * Math.sqrt(2)))) / 2f;
        return new OffsetEdgeTreatment(new MarkerEdgeTreatment(((float)this.arrowSize)), Math.min(Math.max(v0, -v1), v1));
    }

    public void detachView(View arg1) {
        if(arg1 == null) {
            return;
        }

        arg1.removeOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    public void draw(Canvas arg9) {
        arg9.save();
        float v0 = this.calculatePointerOffset();
        float v1 = ((float)(-((((double)this.arrowSize)) * Math.sqrt(2) - (((double)this.arrowSize)))));
        arg9.scale(this.tooltipScaleX, this.tooltipScaleY, (((float)this.getBounds().left)) + (((float)this.getBounds().width())) * 0.5f, (((float)this.getBounds().top)) + (((float)this.getBounds().height())) * this.tooltipPivotY);
        arg9.translate(v0, v1);
        super.draw(arg9);
        this.drawText(arg9);
        arg9.restore();
    }

    private void drawText(Canvas arg12) {
        if(this.text == null) {
            return;
        }

        Rect v0 = this.getBounds();
        int v1 = ((int)this.calculateTextOriginAndAlignment(v0));
        if(this.textDrawableHelper.getTextAppearance() != null) {
            this.textDrawableHelper.getTextPaint().drawableState = this.getState();
            this.textDrawableHelper.updateTextPaintDrawState(this.context);
            this.textDrawableHelper.getTextPaint().setAlpha(((int)(this.labelOpacity * 255f)));
        }

        arg12.drawText(this.text, 0, this.text.length(), ((float)v0.centerX()), ((float)v1), this.textDrawableHelper.getTextPaint());
    }

    public int getIntrinsicHeight() {
        return ((int)Math.max(this.textDrawableHelper.getTextPaint().getTextSize(), ((float)this.minHeight)));
    }

    public int getIntrinsicWidth() {
        return ((int)Math.max((((float)(this.padding * 2))) + this.getTextWidth(), ((float)this.minWidth)));
    }

    public int getLayoutMargin() {
        return this.layoutMargin;
    }

    public int getMinHeight() {
        return this.minHeight;
    }

    public int getMinWidth() {
        return this.minWidth;
    }

    public CharSequence getText() {
        return this.text;
    }

    public TextAppearance getTextAppearance() {
        return this.textDrawableHelper.getTextAppearance();
    }

    public int getTextPadding() {
        return this.padding;
    }

    private float getTextWidth() {
        CharSequence v0 = this.text;
        if(v0 == null) {
            return 0;
        }

        return this.textDrawableHelper.getTextWidth(v0.toString());
    }

    private void loadFromAttributes(AttributeSet arg8, int arg9, int arg10) {
        TypedArray v8 = ThemeEnforcement.obtainStyledAttributes(this.context, arg8, styleable.Tooltip, arg9, arg10, new int[0]);
        this.arrowSize = this.context.getResources().getDimensionPixelSize(dimen.mtrl_tooltip_arrowSize);
        this.setShapeAppearanceModel(this.getShapeAppearanceModel().toBuilder().setBottomEdge(this.createMarkerEdge()).build());
        this.setText(v8.getText(styleable.Tooltip_android_text));
        TextAppearance v9 = MaterialResources.getTextAppearance(this.context, v8, styleable.Tooltip_android_textAppearance);
        if(v9 != null && (v8.hasValue(styleable.Tooltip_android_textColor))) {
            v9.setTextColor(MaterialResources.getColorStateList(this.context, v8, styleable.Tooltip_android_textColor));
        }

        this.setTextAppearance(v9);
        Context v9_1 = this.context;
        arg10 = attr.colorOnBackground;
        Class v0 = TooltipDrawable.class;
        this.setFillColor(ColorStateList.valueOf(v8.getColor(styleable.Tooltip_backgroundTint, MaterialColors.layer(ColorUtils.setAlphaComponent(MaterialColors.getColor(this.context, 0x1010031, v0.getCanonicalName()), 0xE5), ColorUtils.setAlphaComponent(MaterialColors.getColor(v9_1, arg10, v0.getCanonicalName()), 0x99)))));
        this.setStrokeColor(ColorStateList.valueOf(MaterialColors.getColor(this.context, attr.colorSurface, v0.getCanonicalName())));
        this.padding = v8.getDimensionPixelSize(styleable.Tooltip_android_padding, 0);
        this.minWidth = v8.getDimensionPixelSize(styleable.Tooltip_android_minWidth, 0);
        this.minHeight = v8.getDimensionPixelSize(styleable.Tooltip_android_minHeight, 0);
        this.layoutMargin = v8.getDimensionPixelSize(styleable.Tooltip_android_layout_margin, 0);
        v8.recycle();
    }

    protected void onBoundsChange(Rect arg2) {
        super.onBoundsChange(arg2);
        this.setShapeAppearanceModel(this.getShapeAppearanceModel().toBuilder().setBottomEdge(this.createMarkerEdge()).build());
    }

    public boolean onStateChange(int[] arg1) {
        return super.onStateChange(arg1);
    }

    public void onTextSizeChange() {
        this.invalidateSelf();
    }

    public void setLayoutMargin(int arg1) {
        this.layoutMargin = arg1;
        this.invalidateSelf();
    }

    public void setMinHeight(int arg1) {
        this.minHeight = arg1;
        this.invalidateSelf();
    }

    public void setMinWidth(int arg1) {
        this.minWidth = arg1;
        this.invalidateSelf();
    }

    public void setRelativeToView(View arg1) {
        if(arg1 == null) {
            return;
        }

        this.updateLocationOnScreen(arg1);
        arg1.addOnLayoutChangeListener(this.attachedViewLayoutChangeListener);
    }

    public void setRevealFraction(float arg4) {
        this.tooltipPivotY = 1.2f;
        this.tooltipScaleX = arg4;
        this.tooltipScaleY = arg4;
        this.labelOpacity = AnimationUtils.lerp(0f, 1f, 0.19f, 1f, arg4);
        this.invalidateSelf();
    }

    public void setText(CharSequence arg2) {
        if(!TextUtils.equals(this.text, arg2)) {
            this.text = arg2;
            this.textDrawableHelper.setTextWidthDirty(true);
            this.invalidateSelf();
        }
    }

    public void setTextAppearance(TextAppearance arg2) {
        this.textDrawableHelper.setTextAppearance(arg2, this.context);
    }

    public void setTextAppearanceResource(int arg3) {
        this.setTextAppearance(new TextAppearance(this.context, arg3));
    }

    public void setTextPadding(int arg1) {
        this.padding = arg1;
        this.invalidateSelf();
    }

    public void setTextResource(int arg2) {
        this.setText(this.context.getResources().getString(arg2));
    }

    private void updateLocationOnScreen(View arg3) {
        int[] v0 = new int[2];
        arg3.getLocationOnScreen(v0);
        this.locationOnScreenX = v0[0];
        arg3.getWindowVisibleDisplayFrame(this.displayFrame);
    }
}

