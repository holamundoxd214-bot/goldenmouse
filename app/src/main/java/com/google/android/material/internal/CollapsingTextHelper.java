package com.google.android.material.internal;

import android.animation.TimeInterpolator;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.graphics.Bitmap$Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.os.Build$VERSION;
import android.text.Layout$Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import androidx.core.math.MathUtils;
import androidx.core.text.TextDirectionHeuristicCompat;
import androidx.core.text.TextDirectionHeuristicsCompat;
import androidx.core.util.Preconditions;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.resources.CancelableFontCallback$ApplyFont;
import com.google.android.material.resources.CancelableFontCallback;
import com.google.android.material.resources.TextAppearance;
import com.google.android.material.resources.TypefaceUtils;

public final class CollapsingTextHelper {
    private static final boolean DEBUG_DRAW = false;
    private static final Paint DEBUG_DRAW_PAINT = null;
    private static final String ELLIPSIS_NORMAL = "…";
    private static final float FADE_MODE_THRESHOLD_FRACTION_RELATIVE = 0.5f;
    private static final String TAG = "CollapsingTextHelper";
    private static final boolean USE_SCALING_TEXTURE;
    private boolean boundsChanged;
    private final Rect collapsedBounds;
    private float collapsedDrawX;
    private float collapsedDrawY;
    private CancelableFontCallback collapsedFontCallback;
    private float collapsedLetterSpacing;
    private ColorStateList collapsedShadowColor;
    private float collapsedShadowDx;
    private float collapsedShadowDy;
    private float collapsedShadowRadius;
    private float collapsedTextBlend;
    private ColorStateList collapsedTextColor;
    private int collapsedTextGravity;
    private float collapsedTextSize;
    private float collapsedTextWidth;
    private Typeface collapsedTypeface;
    private Typeface collapsedTypefaceBold;
    private Typeface collapsedTypefaceDefault;
    private final RectF currentBounds;
    private float currentDrawX;
    private float currentDrawY;
    private float currentLetterSpacing;
    private int currentOffsetY;
    private int currentShadowColor;
    private float currentShadowDx;
    private float currentShadowDy;
    private float currentShadowRadius;
    private float currentTextSize;
    private Typeface currentTypeface;
    private final Rect expandedBounds;
    private float expandedDrawX;
    private float expandedDrawY;
    private CancelableFontCallback expandedFontCallback;
    private float expandedFraction;
    private float expandedLetterSpacing;
    private int expandedLineCount;
    private ColorStateList expandedShadowColor;
    private float expandedShadowDx;
    private float expandedShadowDy;
    private float expandedShadowRadius;
    private float expandedTextBlend;
    private ColorStateList expandedTextColor;
    private int expandedTextGravity;
    private float expandedTextSize;
    private Bitmap expandedTitleTexture;
    private Typeface expandedTypeface;
    private Typeface expandedTypefaceBold;
    private Typeface expandedTypefaceDefault;
    private boolean fadeModeEnabled;
    private float fadeModeStartFraction;
    private float fadeModeThresholdFraction;
    private int hyphenationFrequency;
    private boolean isRtl;
    private boolean isRtlTextDirectionHeuristicsEnabled;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private TimeInterpolator positionInterpolator;
    private float scale;
    private int[] state;
    private StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer;
    private CharSequence text;
    private StaticLayout textLayout;
    private final TextPaint textPaint;
    private TimeInterpolator textSizeInterpolator;
    private CharSequence textToDraw;
    private CharSequence textToDrawCollapsed;
    private Paint texturePaint;
    private TextUtils$TruncateAt titleTextEllipsize;
    private final TextPaint tmpPaint;
    private boolean useTexture;
    private final View view;

    static {
        CollapsingTextHelper.USE_SCALING_TEXTURE = false;
        CollapsingTextHelper.DEBUG_DRAW_PAINT = null;
    }

    public CollapsingTextHelper(View arg3) {
        super();
        this.expandedTextGravity = 16;
        this.collapsedTextGravity = 16;
        this.expandedTextSize = 15f;
        this.collapsedTextSize = 15f;
        this.titleTextEllipsize = TextUtils$TruncateAt.END;
        this.isRtlTextDirectionHeuristicsEnabled = true;
        this.maxLines = 1;
        this.lineSpacingAdd = 0f;
        this.lineSpacingMultiplier = 1f;
        this.hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
        this.view = arg3;
        TextPaint v0 = new TextPaint(0x81);
        this.textPaint = v0;
        this.tmpPaint = new TextPaint(((Paint)v0));
        this.collapsedBounds = new Rect();
        this.expandedBounds = new Rect();
        this.currentBounds = new RectF();
        this.fadeModeThresholdFraction = this.calculateFadeModeThresholdFraction();
        this.maybeUpdateFontWeightAdjustment(arg3.getContext().getResources().getConfiguration());
    }

    private static int blendARGB(int arg5, int arg6, float arg7) {
        float v0 = 1f - arg7;
        return Color.argb(Math.round((((float)Color.alpha(arg5))) * v0 + (((float)Color.alpha(arg6))) * arg7), Math.round((((float)Color.red(arg5))) * v0 + (((float)Color.red(arg6))) * arg7), Math.round((((float)Color.green(arg5))) * v0 + (((float)Color.green(arg6))) * arg7), Math.round((((float)Color.blue(arg5))) * v0 + (((float)Color.blue(arg6))) * arg7));
    }

    private void calculateBaseOffsets(boolean arg10) {
        this.calculateUsingTextSize(1f, arg10);
        CharSequence v0 = this.textToDraw;
        if(v0 != null) {
            StaticLayout v1 = this.textLayout;
            if(v1 != null) {
                this.textToDrawCollapsed = TextUtils.ellipsize(v0, this.textPaint, ((float)v1.getWidth()), this.titleTextEllipsize);
            }
        }

        v0 = this.textToDrawCollapsed;
        float v1_1 = 0f;
        this.collapsedTextWidth = v0 != null ? this.measureTextWidth(this.textPaint, v0) : 0f;
        int v0_1 = GravityCompat.getAbsoluteGravity(this.collapsedTextGravity, this.isRtl);
        int v2 = v0_1 & 0x70;
        int v3 = 80;
        int v4 = 0x30;
        float v5 = 2f;
        if(v2 == v4) {
            this.collapsedDrawY = ((float)this.collapsedBounds.top);
        }
        else if(v2 != v3) {
            this.collapsedDrawY = (((float)this.collapsedBounds.centerY())) - (this.textPaint.descent() - this.textPaint.ascent()) / v5;
        }
        else {
            this.collapsedDrawY = (((float)this.collapsedBounds.bottom)) + this.textPaint.ascent();
        }

        v2 = 0x800007;
        v0_1 &= v2;
        int v6 = 5;
        if(v0_1 != 1) {
            Rect v8 = this.collapsedBounds;
            this.collapsedDrawX = v0_1 != v6 ? ((float)v8.left) : (((float)v8.right)) - this.collapsedTextWidth;
        }
        else {
            this.collapsedDrawX = (((float)this.collapsedBounds.centerX())) - this.collapsedTextWidth / v5;
        }

        this.calculateUsingTextSize(0f, arg10);
        StaticLayout v10 = this.textLayout;
        float v10_1 = v10 != null ? ((float)v10.getHeight()) : 0f;
        StaticLayout v0_2 = this.textLayout;
        if(v0_2 == null || this.maxLines <= 1) {
            v0 = this.textToDraw;
            if(v0 != null) {
                v1_1 = this.measureTextWidth(this.textPaint, v0);
            }
        }
        else {
            v1_1 = ((float)v0_2.getWidth());
        }

        v0_2 = this.textLayout;
        v0_1 = v0_2 != null ? v0_2.getLineCount() : 0;
        this.expandedLineCount = v0_1;
        v0_1 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl);
        int v8_1 = v0_1 & 0x70;
        if(v8_1 != v4) {
            Rect v4_1 = this.expandedBounds;
            this.expandedDrawY = v8_1 != v3 ? (((float)v4_1.centerY())) - v10_1 / v5 : (((float)v4_1.bottom)) - v10_1 + this.textPaint.descent();
        }
        else {
            this.expandedDrawY = ((float)this.expandedBounds.top);
        }

        int v10_2 = v0_1 & v2;
        if(v10_2 != 1) {
            Rect v0_3 = this.expandedBounds;
            this.expandedDrawX = v10_2 != v6 ? ((float)v0_3.left) : (((float)v0_3.right)) - v1_1;
        }
        else {
            this.expandedDrawX = (((float)this.expandedBounds.centerX())) - v1_1 / v5;
        }

        this.clearTexture();
        this.setInterpolatedTextSize(this.expandedFraction);
    }

    private void calculateCurrentOffsets() {
        this.calculateOffsets(this.expandedFraction);
    }

    private float calculateFadeModeTextAlpha(float arg5) {
        float v0 = this.fadeModeThresholdFraction;
        float v3 = 1f;
        if(Float.compare(arg5, v0) <= 0) {
            return AnimationUtils.lerp(v3, 0f, this.fadeModeStartFraction, v0, arg5);
        }

        return AnimationUtils.lerp(0f, v3, v0, v3, arg5);
    }

    private float calculateFadeModeThresholdFraction() {
        return this.fadeModeStartFraction + (1f - this.fadeModeStartFraction) * 0.5f;
    }

    private boolean calculateIsRtl(CharSequence arg3) {
        boolean v0 = this.isDefaultIsRtl();
        if(this.isRtlTextDirectionHeuristicsEnabled) {
            return this.isTextDirectionHeuristicsIsRtl(arg3, v0);
        }

        return v0;
    }

    private void calculateOffsets(float arg6) {
        float v0;
        this.interpolateBounds(arg6);
        float v2 = 1f;
        if(!this.fadeModeEnabled) {
            this.currentDrawX = CollapsingTextHelper.lerp(this.expandedDrawX, this.collapsedDrawX, arg6, this.positionInterpolator);
            this.currentDrawY = CollapsingTextHelper.lerp(this.expandedDrawY, this.collapsedDrawY, arg6, this.positionInterpolator);
            this.setInterpolatedTextSize(arg6);
            v0 = arg6;
        }
        else if(arg6 < this.fadeModeThresholdFraction) {
            this.currentDrawX = this.expandedDrawX;
            this.currentDrawY = this.expandedDrawY;
            this.setInterpolatedTextSize(0f);
            v0 = 0f;
        }
        else {
            this.currentDrawX = this.collapsedDrawX;
            this.currentDrawY = this.collapsedDrawY - (((float)Math.max(0, this.currentOffsetY)));
            this.setInterpolatedTextSize(v2);
            v0 = v2;
        }

        this.setCollapsedTextBlend(v2 - CollapsingTextHelper.lerp(0f, v2, v2 - arg6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        this.setExpandedTextBlend(CollapsingTextHelper.lerp(v2, 0f, arg6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        ColorStateList v1 = this.collapsedTextColor;
        ColorStateList v2_1 = this.expandedTextColor;
        TextPaint v3 = this.textPaint;
        if(v1 != v2_1) {
            v3.setColor(CollapsingTextHelper.blendARGB(this.getCurrentExpandedTextColor(), this.getCurrentCollapsedTextColor(), v0));
        }
        else {
            v3.setColor(this.getCurrentCollapsedTextColor());
        }

        v0 = this.collapsedLetterSpacing;
        float v1_1 = this.expandedLetterSpacing;
        int v2_2 = Float.compare(v0, v1_1);
        v3 = this.textPaint;
        if(v2_2 != 0) {
            v3.setLetterSpacing(CollapsingTextHelper.lerp(v1_1, v0, arg6, AnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR));
        }
        else {
            v3.setLetterSpacing(v0);
        }

        this.currentShadowRadius = CollapsingTextHelper.lerp(this.expandedShadowRadius, this.collapsedShadowRadius, arg6, null);
        this.currentShadowDx = CollapsingTextHelper.lerp(this.expandedShadowDx, this.collapsedShadowDx, arg6, null);
        this.currentShadowDy = CollapsingTextHelper.lerp(this.expandedShadowDy, this.collapsedShadowDy, arg6, null);
        int v0_1 = CollapsingTextHelper.blendARGB(this.getCurrentColor(this.expandedShadowColor), this.getCurrentColor(this.collapsedShadowColor), arg6);
        this.currentShadowColor = v0_1;
        this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, v0_1);
        if(this.fadeModeEnabled) {
            this.textPaint.setAlpha(((int)(this.calculateFadeModeTextAlpha(arg6) * (((float)this.textPaint.getAlpha())))));
        }

        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    private void calculateUsingTextSize(float arg11, boolean arg12) {
        int v4;
        Typeface v1_1;
        float v12;
        float v0;
        if(this.text == null) {
        }
        else {
            v0 = ((float)this.collapsedBounds.width());
            float v1 = ((float)this.expandedBounds.width());
            float v2 = 1f;
            if(CollapsingTextHelper.isClose(arg11, v2)) {
                arg11 = this.collapsedTextSize;
                v12 = this.collapsedLetterSpacing;
                this.scale = v2;
                v1_1 = this.collapsedTypeface;
            }
            else {
                float v3 = this.expandedTextSize;
                float v5 = this.expandedLetterSpacing;
                Typeface v6 = this.expandedTypeface;
                this.scale = CollapsingTextHelper.isClose(arg11, 0f) ? v2 : CollapsingTextHelper.lerp(this.expandedTextSize, this.collapsedTextSize, arg11, this.textSizeInterpolator) / this.expandedTextSize;
                arg11 = this.collapsedTextSize / this.expandedTextSize;
                float v7 = v1 * arg11;
                v0 = (arg12) || (this.fadeModeEnabled) || v7 <= v0 ? v1 : Math.min(v0 / arg11, v1);
                arg11 = v3;
                v12 = v5;
                v1_1 = v6;
            }

            v4 = 1;
            boolean v5_1 = false;
            if(Float.compare(v0, 0f) > 0) {
                int v3_1 = this.currentTextSize != arg11 ? 1 : 0;
                int v6_1 = this.currentLetterSpacing != v12 ? 1 : 0;
                int v7_1 = this.currentTypeface != v1_1 ? 1 : 0;
                StaticLayout v8 = this.textLayout;
                int v8_1 = v8 == null || v0 == (((float)v8.getWidth())) ? 0 : 1;
                v3_1 = v3_1 != 0 || v6_1 != 0 || v8_1 != 0 || v7_1 != 0 || (this.boundsChanged) ? 1 : 0;
                this.currentTextSize = arg11;
                this.currentLetterSpacing = v12;
                this.currentTypeface = v1_1;
                this.boundsChanged = false;
                TextPaint v11 = this.textPaint;
                if(this.scale != v2) {
                    v5_1 = true;
                }

                v11.setLinearText(v5_1);
                int v5_2 = v3_1;
            }

            if(this.textToDraw != null) {
                if(v5_1) {
                }
                else {
                    return;
                }
            }

            goto label_101;
        }

        return;
    label_101:
        this.textPaint.setTextSize(this.currentTextSize);
        this.textPaint.setTypeface(this.currentTypeface);
        this.textPaint.setLetterSpacing(this.currentLetterSpacing);
        this.isRtl = this.calculateIsRtl(this.text);
        if(this.shouldDrawMultiline()) {
            v4 = this.maxLines;
        }

        StaticLayout v11_1 = this.createStaticLayout(v4, v0, this.isRtl);
        this.textLayout = v11_1;
        this.textToDraw = v11_1.getText();
    }

    private void calculateUsingTextSize(float arg2) {
        this.calculateUsingTextSize(arg2, false);
    }

    private void clearTexture() {
        Bitmap v0 = this.expandedTitleTexture;
        if(v0 != null) {
            v0.recycle();
            this.expandedTitleTexture = null;
        }
    }

    private StaticLayout createStaticLayout(int arg4, float arg5, boolean arg6) {
        Object v3_2;
        if(arg4 == 1) {
            try {
                Layout$Alignment v0 = Layout$Alignment.ALIGN_NORMAL;
                goto label_5;
            label_4:
                v0 = this.getMultilineTextLayoutAlignment();
            label_5:
                StaticLayout v3_1 = StaticLayoutBuilderCompat.obtain(this.text, this.textPaint, ((int)arg5)).setEllipsize(this.titleTextEllipsize).setIsRtl(arg6).setAlignment(v0).setIncludePad(false).setMaxLines(arg4).setLineSpacing(this.lineSpacingAdd, this.lineSpacingMultiplier).setHyphenationFrequency(this.hyphenationFrequency).setStaticLayoutBuilderConfigurer(this.staticLayoutBuilderConfigurer).build();
            }
            catch(StaticLayoutBuilderCompatException v3) {
                Log.e("CollapsingTextHelper", v3.getCause().getMessage(), ((Throwable)v3));
                v3_2 = null;
            }
        }
        else {
            goto label_4;
        }

        return Preconditions.checkNotNull(v3_2);
    }

    public void draw(Canvas arg8) {
        int v0 = arg8.save();
        if(this.textToDraw != null && this.currentBounds.width() > 0f && this.currentBounds.height() > 0f) {
            this.textPaint.setTextSize(this.currentTextSize);
            float v1 = this.currentDrawX;
            float v2 = this.currentDrawY;
            int v3 = !this.useTexture || this.expandedTitleTexture == null ? 0 : 1;
            float v5 = this.scale;
            if(v5 != 1f && !this.fadeModeEnabled) {
                arg8.scale(v5, v5, v1, v2);
            }

            if(v3 != 0) {
                arg8.drawBitmap(this.expandedTitleTexture, v1, v2, this.texturePaint);
                arg8.restoreToCount(v0);
                return;
            }

            if(this.shouldDrawMultiline()) {
                if((this.fadeModeEnabled) && this.expandedFraction <= this.fadeModeThresholdFraction) {
                    goto label_49;
                }

                this.drawMultilineTransition(arg8, this.currentDrawX - (((float)this.textLayout.getLineStart(0))), v2);
            }
            else {
            label_49:
                arg8.translate(v1, v2);
                this.textLayout.draw(arg8);
            }

            arg8.restoreToCount(v0);
        }
    }

    private void drawMultilineTransition(Canvas arg12, float arg13, float arg14) {
        int v0 = this.textPaint.getAlpha();
        arg12.translate(arg13, arg14);
        int v2 = 0x1F;
        if(!this.fadeModeEnabled) {
            this.textPaint.setAlpha(((int)(this.expandedTextBlend * (((float)v0)))));
            if(Build$VERSION.SDK_INT >= v2) {
                this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, this.textPaint.getAlpha()));
            }

            this.textLayout.draw(arg12);
        }

        if(!this.fadeModeEnabled) {
            this.textPaint.setAlpha(((int)(this.collapsedTextBlend * (((float)v0)))));
        }

        if(Build$VERSION.SDK_INT >= v2) {
            this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, MaterialColors.compositeARGBWithAlpha(this.currentShadowColor, this.textPaint.getAlpha()));
        }

        float v8 = ((float)this.textLayout.getLineBaseline(0));
        arg12.drawText(this.textToDrawCollapsed, 0, this.textToDrawCollapsed.length(), 0f, v8, this.textPaint);
        if(Build$VERSION.SDK_INT >= v2) {
            this.textPaint.setShadowLayer(this.currentShadowRadius, this.currentShadowDx, this.currentShadowDy, this.currentShadowColor);
        }

        if(!this.fadeModeEnabled) {
            String v1 = this.textToDrawCollapsed.toString().trim();
            if(v1.endsWith("…")) {
                v1 = v1.substring(0, v1.length() - 1);
            }

            this.textPaint.setAlpha(v0);
            arg12.drawText(v1, 0, Math.min(this.textLayout.getLineEnd(0), v1.length()), 0f, v8, this.textPaint);
        }
    }

    private void ensureExpandedTexture() {
        if(this.expandedTitleTexture == null && !this.expandedBounds.isEmpty()) {
            if(TextUtils.isEmpty(this.textToDraw)) {
            }
            else {
                this.calculateOffsets(0f);
                int v0 = this.textLayout.getWidth();
                int v1 = this.textLayout.getHeight();
                if(v0 > 0) {
                    if(v1 <= 0) {
                    }
                    else {
                        this.expandedTitleTexture = Bitmap.createBitmap(v0, v1, Bitmap$Config.ARGB_8888);
                        this.textLayout.draw(new Canvas(this.expandedTitleTexture));
                        if(this.texturePaint == null) {
                            this.texturePaint = new Paint(3);
                        }
                    }
                }
            }
        }
    }

    public void getCollapsedTextActualBounds(RectF arg3, int arg4, int arg5) {
        this.isRtl = this.calculateIsRtl(this.text);
        arg3.left = Math.max(this.getCollapsedTextLeftBound(arg4, arg5), ((float)this.collapsedBounds.left));
        arg3.top = ((float)this.collapsedBounds.top);
        arg3.right = Math.min(this.getCollapsedTextRightBound(arg3, arg4, arg5), ((float)this.collapsedBounds.right));
        arg3.bottom = (((float)this.collapsedBounds.top)) + this.getCollapsedTextHeight();
    }

    public ColorStateList getCollapsedTextColor() {
        return this.collapsedTextColor;
    }

    public int getCollapsedTextGravity() {
        return this.collapsedTextGravity;
    }

    public float getCollapsedTextHeight() {
        this.getTextPaintCollapsed(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    private float getCollapsedTextLeftBound(int arg3, int arg4) {
        int v2_1;
        float v2;
        float v3_1;
        Rect v4;
        boolean v3;
        if(arg4 == 17 || (arg4 & 7) == 1) {
            v3_1 = (((float)arg3)) / 2f;
            v2 = this.collapsedTextWidth / 2f;
        }
        else {
            if((arg4 & 0x800005) == 0x800005 || (arg4 & 5) == 5) {
                v3 = this.isRtl;
                v4 = this.collapsedBounds;
                if(v3) {
                    v2_1 = v4.left;
                }
                else {
                    goto label_29;
                }
            }
            else {
                v3 = this.isRtl;
                v4 = this.collapsedBounds;
                if(v3) {
                    v3_1 = ((float)v4.right);
                    v2 = this.collapsedTextWidth;
                    goto label_19;
                }
                else {
                    v2_1 = v4.left;
                }
            }

            return ((float)v2_1);
        label_29:
            v3_1 = ((float)v4.right);
            v2 = this.collapsedTextWidth;
        }

    label_19:
        return v3_1 - v2;
    }

    private float getCollapsedTextRightBound(RectF arg3, int arg4, int arg5) {
        float v2_1;
        float v3;
        int v2;
        if(arg5 == 17 || (arg5 & 7) == 1) {
            v3 = (((float)arg4)) / 2f;
            v2_1 = this.collapsedTextWidth / 2f;
        }
        else {
            if((arg5 & 0x800005) == 0x800005 || (arg5 & 5) == 5) {
                if(this.isRtl) {
                    v3 = arg3.left;
                    v2_1 = this.collapsedTextWidth;
                    goto label_21;
                }
                else {
                    v2 = this.collapsedBounds.right;
                }
            }
            else if(this.isRtl) {
                v2 = this.collapsedBounds.right;
            }
            else {
                v3 = arg3.left;
                v2_1 = this.collapsedTextWidth;
                goto label_21;
            }

            return ((float)v2);
        }

    label_21:
        return v3 + v2_1;
    }

    public float getCollapsedTextSize() {
        return this.collapsedTextSize;
    }

    public Typeface getCollapsedTypeface() {
        Typeface v0 = this.collapsedTypeface;
        if(v0 != null) {
            return v0;
        }

        return Typeface.DEFAULT;
    }

    public int getCurrentCollapsedTextColor() {
        return this.getCurrentColor(this.collapsedTextColor);
    }

    private int getCurrentColor(ColorStateList arg2) {
        if(arg2 == null) {
            return 0;
        }

        int[] v1 = this.state;
        if(v1 != null) {
            return arg2.getColorForState(v1, 0);
        }

        return arg2.getDefaultColor();
    }

    private int getCurrentExpandedTextColor() {
        return this.getCurrentColor(this.expandedTextColor);
    }

    public int getExpandedLineCount() {
        return this.expandedLineCount;
    }

    public ColorStateList getExpandedTextColor() {
        return this.expandedTextColor;
    }

    public float getExpandedTextFullHeight() {
        this.getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent() + this.tmpPaint.descent();
    }

    public int getExpandedTextGravity() {
        return this.expandedTextGravity;
    }

    public float getExpandedTextHeight() {
        this.getTextPaintExpanded(this.tmpPaint);
        return -this.tmpPaint.ascent();
    }

    public float getExpandedTextSize() {
        return this.expandedTextSize;
    }

    public Typeface getExpandedTypeface() {
        Typeface v0 = this.expandedTypeface;
        if(v0 != null) {
            return v0;
        }

        return Typeface.DEFAULT;
    }

    public float getExpansionFraction() {
        return this.expandedFraction;
    }

    public float getFadeModeThresholdFraction() {
        return this.fadeModeThresholdFraction;
    }

    public int getHyphenationFrequency() {
        return this.hyphenationFrequency;
    }

    public int getLineCount() {
        StaticLayout v0 = this.textLayout;
        if(v0 != null) {
            return v0.getLineCount();
        }

        return 0;
    }

    public float getLineSpacingAdd() {
        return this.textLayout.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.textLayout.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.maxLines;
    }

    private Layout$Alignment getMultilineTextLayoutAlignment() {
        int v0 = GravityCompat.getAbsoluteGravity(this.expandedTextGravity, this.isRtl) & 7;
        if(v0 != 1) {
            boolean v2 = this.isRtl;
            if(v0 != 5) {
                if(v2) {
                    return Layout$Alignment.ALIGN_OPPOSITE;
                }

                return Layout$Alignment.ALIGN_NORMAL;
            }

            if(v2) {
                return Layout$Alignment.ALIGN_NORMAL;
            }

            return Layout$Alignment.ALIGN_OPPOSITE;
        }

        return Layout$Alignment.ALIGN_CENTER;
    }

    public TimeInterpolator getPositionInterpolator() {
        return this.positionInterpolator;
    }

    public CharSequence getText() {
        return this.text;
    }

    private void getTextPaintCollapsed(TextPaint arg2) {
        arg2.setTextSize(this.collapsedTextSize);
        arg2.setTypeface(this.collapsedTypeface);
        arg2.setLetterSpacing(this.collapsedLetterSpacing);
    }

    private void getTextPaintExpanded(TextPaint arg2) {
        arg2.setTextSize(this.expandedTextSize);
        arg2.setTypeface(this.expandedTypeface);
        arg2.setLetterSpacing(this.expandedLetterSpacing);
    }

    public TextUtils$TruncateAt getTitleTextEllipsize() {
        return this.titleTextEllipsize;
    }

    private void interpolateBounds(float arg5) {
        boolean v0 = this.fadeModeEnabled;
        RectF v1 = this.currentBounds;
        if(v0) {
            Rect v4 = arg5 < this.fadeModeThresholdFraction ? this.expandedBounds : this.collapsedBounds;
            v1.set(v4);
            return;
        }

        v1.left = CollapsingTextHelper.lerp(((float)this.expandedBounds.left), ((float)this.collapsedBounds.left), arg5, this.positionInterpolator);
        this.currentBounds.top = CollapsingTextHelper.lerp(this.expandedDrawY, this.collapsedDrawY, arg5, this.positionInterpolator);
        this.currentBounds.right = CollapsingTextHelper.lerp(((float)this.expandedBounds.right), ((float)this.collapsedBounds.right), arg5, this.positionInterpolator);
        this.currentBounds.bottom = CollapsingTextHelper.lerp(((float)this.expandedBounds.bottom), ((float)this.collapsedBounds.bottom), arg5, this.positionInterpolator);
    }

    private static boolean isClose(float arg0, float arg1) {
        if(Math.abs(arg0 - arg1) < 0.00001f) {
            return 1;
        }

        return 0;
    }

    private boolean isDefaultIsRtl() {
        if(ViewCompat.getLayoutDirection(this.view) == 1) {
            return 1;
        }

        return 0;
    }

    public boolean isRtlTextDirectionHeuristicsEnabled() {
        return this.isRtlTextDirectionHeuristicsEnabled;
    }

    public final boolean isStateful() {
        ColorStateList v0 = this.collapsedTextColor;
        if(v0 == null || !v0.isStateful()) {
            ColorStateList v1 = this.expandedTextColor;
            if(v1 != null && (v1.isStateful())) {
                return 1;
            }
        }
        else {
            return 1;
        }

        return 0;
    }

    private boolean isTextDirectionHeuristicsIsRtl(CharSequence arg2, boolean arg3) {
        TextDirectionHeuristicCompat v1 = arg3 ? TextDirectionHeuristicsCompat.FIRSTSTRONG_RTL : TextDirectionHeuristicsCompat.FIRSTSTRONG_LTR;
        return v1.isRtl(arg2, 0, arg2.length());
    }

    private static float lerp(float arg0, float arg1, float arg2, TimeInterpolator arg3) {
        if(arg3 != null) {
            arg2 = arg3.getInterpolation(arg2);
        }

        return AnimationUtils.lerp(arg0, arg1, arg2);
    }

    public void maybeUpdateFontWeightAdjustment(Configuration arg3) {
        if(Build$VERSION.SDK_INT >= 0x1F) {
            Typeface v0 = this.collapsedTypefaceDefault;
            if(v0 != null) {
                this.collapsedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(arg3, v0);
            }

            v0 = this.expandedTypefaceDefault;
            if(v0 != null) {
                this.expandedTypefaceBold = TypefaceUtils.maybeCopyWithFontWeightAdjustment(arg3, v0);
            }

            Typeface v3 = this.collapsedTypefaceBold;
            if(v3 != null) {
            }
            else {
                v3 = this.collapsedTypefaceDefault;
            }

            this.collapsedTypeface = v3;
            v3 = this.expandedTypefaceBold;
            if(v3 != null) {
            }
            else {
                v3 = this.expandedTypefaceDefault;
            }

            this.expandedTypeface = v3;
            this.recalculate(true);
        }
    }

    private float measureTextWidth(TextPaint arg2, CharSequence arg3) {
        return arg2.measureText(arg3, 0, arg3.length());
    }

    public void recalculate(boolean arg2) {
        if(this.view.getHeight() > 0 && this.view.getWidth() > 0 || (arg2)) {
            this.calculateBaseOffsets(arg2);
            this.calculateCurrentOffsets();
        }
    }

    public void recalculate() {
        this.recalculate(false);
    }

    private static boolean rectEquals(Rect arg1, int arg2, int arg3, int arg4, int arg5) {
        if(arg1.left == arg2 && arg1.top == arg3 && arg1.right == arg4 && arg1.bottom == arg5) {
            return 1;
        }

        return 0;
    }

    public void setCollapsedAndExpandedTextColor(ColorStateList arg2) {
        if(this.collapsedTextColor == arg2) {
            if(this.expandedTextColor != arg2) {
            }
            else {
                return;
            }
        }

        this.collapsedTextColor = arg2;
        this.expandedTextColor = arg2;
        this.recalculate();
    }

    public void setCollapsedBounds(int arg2, int arg3, int arg4, int arg5) {
        if(!CollapsingTextHelper.rectEquals(this.collapsedBounds, arg2, arg3, arg4, arg5)) {
            this.collapsedBounds.set(arg2, arg3, arg4, arg5);
            this.boundsChanged = true;
        }
    }

    public void setCollapsedBounds(Rect arg4) {
        this.setCollapsedBounds(arg4.left, arg4.top, arg4.right, arg4.bottom);
    }

    public void setCollapsedTextAppearance(int arg4) {
        TextAppearance v0 = new TextAppearance(this.view.getContext(), arg4);
        if(v0.getTextColor() != null) {
            this.collapsedTextColor = v0.getTextColor();
        }

        if(v0.getTextSize() != 0f) {
            this.collapsedTextSize = v0.getTextSize();
        }

        if(v0.shadowColor != null) {
            this.collapsedShadowColor = v0.shadowColor;
        }

        this.collapsedShadowDx = v0.shadowDx;
        this.collapsedShadowDy = v0.shadowDy;
        this.collapsedShadowRadius = v0.shadowRadius;
        this.collapsedLetterSpacing = v0.letterSpacing;
        CancelableFontCallback v4 = this.collapsedFontCallback;
        if(v4 != null) {
            v4.cancel();
        }

        this.collapsedFontCallback = new CancelableFontCallback(new ApplyFont() {
            public void apply(Typeface arg1) {
                CollapsingTextHelper.this.setCollapsedTypeface(arg1);
            }
        }, v0.getFallbackFont());
        v0.getFontAsync(this.view.getContext(), this.collapsedFontCallback);
        this.recalculate();
    }

    private void setCollapsedTextBlend(float arg1) {
        this.collapsedTextBlend = arg1;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    public void setCollapsedTextColor(ColorStateList arg2) {
        if(this.collapsedTextColor != arg2) {
            this.collapsedTextColor = arg2;
            this.recalculate();
        }
    }

    public void setCollapsedTextGravity(int arg2) {
        if(this.collapsedTextGravity != arg2) {
            this.collapsedTextGravity = arg2;
            this.recalculate();
        }
    }

    public void setCollapsedTextSize(float arg2) {
        if(this.collapsedTextSize != arg2) {
            this.collapsedTextSize = arg2;
            this.recalculate();
        }
    }

    public void setCollapsedTypeface(Typeface arg1) {
        if(this.setCollapsedTypefaceInternal(arg1)) {
            this.recalculate();
        }
    }

    private boolean setCollapsedTypefaceInternal(Typeface arg2) {
        CancelableFontCallback v0 = this.collapsedFontCallback;
        if(v0 != null) {
            v0.cancel();
        }

        if(this.collapsedTypefaceDefault != arg2) {
            this.collapsedTypefaceDefault = arg2;
            arg2 = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), arg2);
            this.collapsedTypefaceBold = arg2;
            if(arg2 == null) {
                arg2 = this.collapsedTypefaceDefault;
            }

            this.collapsedTypeface = arg2;
            return 1;
        }

        return 0;
    }

    public void setCurrentOffsetY(int arg1) {
        this.currentOffsetY = arg1;
    }

    public void setExpandedBounds(int arg2, int arg3, int arg4, int arg5) {
        if(!CollapsingTextHelper.rectEquals(this.expandedBounds, arg2, arg3, arg4, arg5)) {
            this.expandedBounds.set(arg2, arg3, arg4, arg5);
            this.boundsChanged = true;
        }
    }

    public void setExpandedBounds(Rect arg4) {
        this.setExpandedBounds(arg4.left, arg4.top, arg4.right, arg4.bottom);
    }

    public void setExpandedLetterSpacing(float arg2) {
        if(this.expandedLetterSpacing != arg2) {
            this.expandedLetterSpacing = arg2;
            this.recalculate();
        }
    }

    public void setExpandedTextAppearance(int arg4) {
        TextAppearance v0 = new TextAppearance(this.view.getContext(), arg4);
        if(v0.getTextColor() != null) {
            this.expandedTextColor = v0.getTextColor();
        }

        if(v0.getTextSize() != 0f) {
            this.expandedTextSize = v0.getTextSize();
        }

        if(v0.shadowColor != null) {
            this.expandedShadowColor = v0.shadowColor;
        }

        this.expandedShadowDx = v0.shadowDx;
        this.expandedShadowDy = v0.shadowDy;
        this.expandedShadowRadius = v0.shadowRadius;
        this.expandedLetterSpacing = v0.letterSpacing;
        CancelableFontCallback v4 = this.expandedFontCallback;
        if(v4 != null) {
            v4.cancel();
        }

        this.expandedFontCallback = new CancelableFontCallback(new ApplyFont() {
            public void apply(Typeface arg1) {
                CollapsingTextHelper.this.setExpandedTypeface(arg1);
            }
        }, v0.getFallbackFont());
        v0.getFontAsync(this.view.getContext(), this.expandedFontCallback);
        this.recalculate();
    }

    private void setExpandedTextBlend(float arg1) {
        this.expandedTextBlend = arg1;
        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    public void setExpandedTextColor(ColorStateList arg2) {
        if(this.expandedTextColor != arg2) {
            this.expandedTextColor = arg2;
            this.recalculate();
        }
    }

    public void setExpandedTextGravity(int arg2) {
        if(this.expandedTextGravity != arg2) {
            this.expandedTextGravity = arg2;
            this.recalculate();
        }
    }

    public void setExpandedTextSize(float arg2) {
        if(this.expandedTextSize != arg2) {
            this.expandedTextSize = arg2;
            this.recalculate();
        }
    }

    public void setExpandedTypeface(Typeface arg1) {
        if(this.setExpandedTypefaceInternal(arg1)) {
            this.recalculate();
        }
    }

    private boolean setExpandedTypefaceInternal(Typeface arg2) {
        CancelableFontCallback v0 = this.expandedFontCallback;
        if(v0 != null) {
            v0.cancel();
        }

        if(this.expandedTypefaceDefault != arg2) {
            this.expandedTypefaceDefault = arg2;
            arg2 = TypefaceUtils.maybeCopyWithFontWeightAdjustment(this.view.getContext().getResources().getConfiguration(), arg2);
            this.expandedTypefaceBold = arg2;
            if(arg2 == null) {
                arg2 = this.expandedTypefaceDefault;
            }

            this.expandedTypeface = arg2;
            return 1;
        }

        return 0;
    }

    public void setExpansionFraction(float arg3) {
        arg3 = MathUtils.clamp(arg3, 0f, 1f);
        if(arg3 != this.expandedFraction) {
            this.expandedFraction = arg3;
            this.calculateCurrentOffsets();
        }
    }

    public void setFadeModeEnabled(boolean arg1) {
        this.fadeModeEnabled = arg1;
    }

    public void setFadeModeStartFraction(float arg1) {
        this.fadeModeStartFraction = arg1;
        this.fadeModeThresholdFraction = this.calculateFadeModeThresholdFraction();
    }

    public void setHyphenationFrequency(int arg1) {
        this.hyphenationFrequency = arg1;
    }

    private void setInterpolatedTextSize(float arg2) {
        this.calculateUsingTextSize(arg2);
        boolean v2 = !CollapsingTextHelper.USE_SCALING_TEXTURE || this.scale == 1f ? false : true;
        this.useTexture = v2;
        if(v2) {
            this.ensureExpandedTexture();
        }

        ViewCompat.postInvalidateOnAnimation(this.view);
    }

    public void setLineSpacingAdd(float arg1) {
        this.lineSpacingAdd = arg1;
    }

    public void setLineSpacingMultiplier(float arg1) {
        this.lineSpacingMultiplier = arg1;
    }

    public void setMaxLines(int arg2) {
        if(arg2 != this.maxLines) {
            this.maxLines = arg2;
            this.clearTexture();
            this.recalculate();
        }
    }

    public void setPositionInterpolator(TimeInterpolator arg1) {
        this.positionInterpolator = arg1;
        this.recalculate();
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean arg1) {
        this.isRtlTextDirectionHeuristicsEnabled = arg1;
    }

    public final boolean setState(int[] arg1) {
        this.state = arg1;
        if(this.isStateful()) {
            this.recalculate();
            return 1;
        }

        return 0;
    }

    public void setStaticLayoutBuilderConfigurer(StaticLayoutBuilderConfigurer arg2) {
        if(this.staticLayoutBuilderConfigurer != arg2) {
            this.staticLayoutBuilderConfigurer = arg2;
            this.recalculate(true);
        }
    }

    public void setText(CharSequence arg2) {
        if(arg2 != null) {
            if(!TextUtils.equals(this.text, arg2)) {
            }
            else {
                return;
            }
        }

        this.text = arg2;
        this.textToDraw = null;
        this.clearTexture();
        this.recalculate();
    }

    public void setTextSizeInterpolator(TimeInterpolator arg1) {
        this.textSizeInterpolator = arg1;
        this.recalculate();
    }

    public void setTitleTextEllipsize(TextUtils$TruncateAt arg1) {
        this.titleTextEllipsize = arg1;
        this.recalculate();
    }

    public void setTypefaces(Typeface arg2) {
        boolean v0 = this.setCollapsedTypefaceInternal(arg2);
        boolean v2 = this.setExpandedTypefaceInternal(arg2);
        if(!v0) {
            if(v2) {
            }
            else {
                return;
            }
        }

        this.recalculate();
    }

    private boolean shouldDrawMultiline() {
        if(this.maxLines > 1 && (!this.isRtl || (this.fadeModeEnabled)) && !this.useTexture) {
            return 1;
        }

        return 0;
    }
}

