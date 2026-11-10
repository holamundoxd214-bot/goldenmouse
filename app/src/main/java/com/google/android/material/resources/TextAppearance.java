package com.google.android.material.resources;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources$NotFoundException;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextPaint;
import android.util.Log;
import androidx.core.content.res.ResourcesCompat$FontCallback;
import androidx.core.content.res.ResourcesCompat;
import com.google.android.material.R$styleable;

public class TextAppearance {
    private static final String TAG = "TextAppearance";
    private static final int TYPEFACE_MONOSPACE = 3;
    private static final int TYPEFACE_SANS = 1;
    private static final int TYPEFACE_SERIF = 2;
    private Typeface font;
    public final String fontFamily;
    private final int fontFamilyResourceId;
    private boolean fontResolved;
    public final boolean hasLetterSpacing;
    public final float letterSpacing;
    public final ColorStateList shadowColor;
    public final float shadowDx;
    public final float shadowDy;
    public final float shadowRadius;
    public final boolean textAllCaps;
    private ColorStateList textColor;
    public final ColorStateList textColorHint;
    public final ColorStateList textColorLink;
    private float textSize;
    public final int textStyle;
    public final int typeface;

    public TextAppearance(Context arg6, int arg7) {
        super();
        this.fontResolved = false;
        TypedArray v1 = arg6.obtainStyledAttributes(arg7, styleable.TextAppearance);
        this.setTextSize(v1.getDimension(styleable.TextAppearance_android_textSize, 0f));
        this.setTextColor(MaterialResources.getColorStateList(arg6, v1, styleable.TextAppearance_android_textColor));
        this.textColorHint = MaterialResources.getColorStateList(arg6, v1, styleable.TextAppearance_android_textColorHint);
        this.textColorLink = MaterialResources.getColorStateList(arg6, v1, styleable.TextAppearance_android_textColorLink);
        this.textStyle = v1.getInt(styleable.TextAppearance_android_textStyle, 0);
        this.typeface = v1.getInt(styleable.TextAppearance_android_typeface, 1);
        int v2 = MaterialResources.getIndexWithValue(v1, styleable.TextAppearance_fontFamily, styleable.TextAppearance_android_fontFamily);
        this.fontFamilyResourceId = v1.getResourceId(v2, 0);
        this.fontFamily = v1.getString(v2);
        this.textAllCaps = v1.getBoolean(styleable.TextAppearance_textAllCaps, false);
        this.shadowColor = MaterialResources.getColorStateList(arg6, v1, styleable.TextAppearance_android_shadowColor);
        this.shadowDx = v1.getFloat(styleable.TextAppearance_android_shadowDx, 0f);
        this.shadowDy = v1.getFloat(styleable.TextAppearance_android_shadowDy, 0f);
        this.shadowRadius = v1.getFloat(styleable.TextAppearance_android_shadowRadius, 0f);
        v1.recycle();
        TypedArray v6 = arg6.obtainStyledAttributes(arg7, styleable.MaterialTextAppearance);
        this.hasLetterSpacing = v6.hasValue(styleable.MaterialTextAppearance_android_letterSpacing);
        this.letterSpacing = v6.getFloat(styleable.MaterialTextAppearance_android_letterSpacing, 0f);
        v6.recycle();
    }

    static Typeface access$000(TextAppearance arg0) {
        return arg0.font;
    }

    static Typeface access$002(TextAppearance arg0, Typeface arg1) {
        arg0.font = arg1;
        return arg1;
    }

    static boolean access$102(TextAppearance arg0, boolean arg1) {
        arg0.fontResolved = arg1;
        return arg1;
    }

    private void createFallbackFont() {
        Typeface v0 = this.font;
        if(v0 == null) {
            String v1 = this.fontFamily;
            if(v1 != null) {
                v0 = Typeface.create(v1, this.textStyle);
                this.font = v0;
            }
        }

        if(v0 == null) {
            int v0_1 = this.typeface;
            if(v0_1 == 1) {
                v0 = Typeface.SANS_SERIF;
                this.font = v0;
            }
            else if(v0_1 == 2) {
                v0 = Typeface.SERIF;
                this.font = v0;
            }
            else if(v0_1 != 3) {
                v0 = Typeface.DEFAULT;
                this.font = v0;
            }
            else {
                v0 = Typeface.MONOSPACE;
                this.font = v0;
            }

            this.font = Typeface.create(v0, this.textStyle);
        }
    }

    public Typeface getFallbackFont() {
        this.createFallbackFont();
        return this.font;
    }

    public Typeface getFont(Context arg3) {
        if(this.fontResolved) {
            return this.font;
        }

        if(arg3.isRestricted()) {
            goto label_23;
        }

        try {
            Typeface v3_1 = ResourcesCompat.getFont(arg3, this.fontFamilyResourceId);
            this.font = v3_1;
            if(v3_1 == null) {
                goto label_23;
            }

            this.font = Typeface.create(v3_1, this.textStyle);
            goto label_23;
        }
        catch(Resources$NotFoundException ) {
        label_23:
            this.createFallbackFont();
            this.fontResolved = true;
            return this.font;
        }
        catch(Exception v3) {
            Log.d("TextAppearance", "Error loading font " + this.fontFamily, ((Throwable)v3));
            goto label_23;
        }
    }

    public void getFontAsync(Context arg5, TextAppearanceFontCallback arg6) {
        if(this.shouldLoadFontSynchronously(arg5)) {
            this.getFont(arg5);
        }
        else {
            this.createFallbackFont();
        }

        int v0 = this.fontFamilyResourceId;
        if(v0 == 0) {
            this.fontResolved = true;
        }

        if(this.fontResolved) {
            arg6.onFontRetrieved(this.font, true);
            return;
        }

        try {
            ResourcesCompat.getFont(arg5, v0, new FontCallback(arg6) {
                public void onFontRetrievalFailed(int arg3) {
                    TextAppearance.this.fontResolved = true;
                    this.val$callback.onFontRetrievalFailed(arg3);
                }

                public void onFontRetrieved(Typeface arg3) {
                    TextAppearance.this.font = Typeface.create(arg3, TextAppearance.this.textStyle);
                    TextAppearance.this.fontResolved = true;
                    this.val$callback.onFontRetrieved(TextAppearance.this.font, false);
                }
            }, null);
            return;
        }
        catch(Exception v5) {
            Log.d("TextAppearance", "Error loading font " + this.fontFamily, ((Throwable)v5));
            this.fontResolved = true;
            arg6.onFontRetrievalFailed(-3);
        }
        catch(Resources$NotFoundException ) {
            this.fontResolved = true;
            arg6.onFontRetrievalFailed(1);
        }
    }

    public void getFontAsync(Context arg2, TextPaint arg3, TextAppearanceFontCallback arg4) {
        this.updateTextPaintMeasureState(arg2, arg3, this.getFallbackFont());
        this.getFontAsync(arg2, new TextAppearanceFontCallback(arg2, arg3, arg4) {
            public void onFontRetrievalFailed(int arg1) {
                this.val$callback.onFontRetrievalFailed(arg1);
            }

            public void onFontRetrieved(Typeface arg4, boolean arg5) {
                TextAppearance.this.updateTextPaintMeasureState(this.val$context, this.val$textPaint, arg4);
                this.val$callback.onFontRetrieved(arg4, arg5);
            }
        });
    }

    public ColorStateList getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public void setTextColor(ColorStateList arg1) {
        this.textColor = arg1;
    }

    public void setTextSize(float arg1) {
        this.textSize = arg1;
    }

    private boolean shouldLoadFontSynchronously(Context arg3) {
        if(TextAppearanceConfig.shouldLoadFontSynchronously()) {
            return 1;
        }

        int v2 = this.fontFamilyResourceId;
        Typeface v2_1 = v2 != 0 ? ResourcesCompat.getCachedFont(arg3, v2) : null;
        if(v2_1 != null) {
            return 1;
        }

        return 0;
    }

    public void updateDrawState(Context arg4, TextPaint arg5, TextAppearanceFontCallback arg6) {
        this.updateMeasureState(arg4, arg5, arg6);
        ColorStateList v4 = this.textColor;
        int v4_1 = v4 != null ? v4.getColorForState(arg5.drawableState, this.textColor.getDefaultColor()) : 0xFF000000;
        arg5.setColor(v4_1);
        float v4_2 = this.shadowRadius;
        float v6 = this.shadowDx;
        float v0 = this.shadowDy;
        ColorStateList v1 = this.shadowColor;
        int v3 = v1 != null ? v1.getColorForState(arg5.drawableState, this.shadowColor.getDefaultColor()) : 0;
        arg5.setShadowLayer(v4_2, v6, v0, v3);
    }

    public void updateMeasureState(Context arg2, TextPaint arg3, TextAppearanceFontCallback arg4) {
        if(this.shouldLoadFontSynchronously(arg2)) {
            this.updateTextPaintMeasureState(arg2, arg3, this.getFont(arg2));
            return;
        }

        this.getFontAsync(arg2, arg3, arg4);
    }

    public void updateTextPaintMeasureState(Context arg1, TextPaint arg2, Typeface arg3) {
        Typeface v1 = TypefaceUtils.maybeCopyWithFontWeightAdjustment(arg1, arg3);
        if(v1 != null) {
            arg3 = v1;
        }

        arg2.setTypeface(arg3);
        int v1_1 = this.textStyle & ~arg3.getStyle();
        boolean v3 = (v1_1 & 1) != 0 ? true : false;
        arg2.setFakeBoldText(v3);
        float v1_2 = (v1_1 & 2) != 0 ? -0.25f : 0f;
        arg2.setTextSkewX(v1_2);
        arg2.setTextSize(this.textSize);
        if(this.hasLetterSpacing) {
            arg2.setLetterSpacing(this.letterSpacing);
        }
    }
}

