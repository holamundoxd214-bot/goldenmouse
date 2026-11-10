package com.google.android.material.internal;

import android.text.Layout$Alignment;
import android.text.StaticLayout$Builder;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils$TruncateAt;
import android.text.TextUtils;
import java.lang.reflect.Constructor;

final class StaticLayoutBuilderCompat {
    class StaticLayoutBuilderCompatException extends Exception {
        StaticLayoutBuilderCompatException(Throwable arg3) {
            super("Error thrown initializing StaticLayout " + arg3.getMessage(), arg3);
        }
    }

    static final int DEFAULT_HYPHENATION_FREQUENCY = 0;
    static final float DEFAULT_LINE_SPACING_ADD = 0f;
    static final float DEFAULT_LINE_SPACING_MULTIPLIER = 1f;
    private static final String TEXT_DIRS_CLASS = "android.text.TextDirectionHeuristics";
    private static final String TEXT_DIR_CLASS = "android.text.TextDirectionHeuristic";
    private static final String TEXT_DIR_CLASS_LTR = "LTR";
    private static final String TEXT_DIR_CLASS_RTL = "RTL";
    private Layout$Alignment alignment;
    private static Constructor constructor;
    private TextUtils$TruncateAt ellipsize;
    private int end;
    private int hyphenationFrequency;
    private boolean includePad;
    private static boolean initialized;
    private boolean isRtl;
    private float lineSpacingAdd;
    private float lineSpacingMultiplier;
    private int maxLines;
    private final TextPaint paint;
    private CharSequence source;
    private int start;
    private StaticLayoutBuilderConfigurer staticLayoutBuilderConfigurer;
    private static Object textDirection;
    private final int width;

    static {
        StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY = 1;
    }

    private StaticLayoutBuilderCompat(CharSequence arg1, TextPaint arg2, int arg3) {
        super();
        this.source = arg1;
        this.paint = arg2;
        this.width = arg3;
        this.start = 0;
        this.end = arg1.length();
        this.alignment = Layout$Alignment.ALIGN_NORMAL;
        this.maxLines = 0x7FFFFFFF;
        this.lineSpacingAdd = 0f;
        this.lineSpacingMultiplier = 1f;
        this.hyphenationFrequency = StaticLayoutBuilderCompat.DEFAULT_HYPHENATION_FREQUENCY;
        this.includePad = true;
        this.ellipsize = null;
    }

    public StaticLayout build() throws StaticLayoutBuilderCompatException {
        if(this.source == null) {
            this.source = "";
        }

        int v0 = Math.max(0, this.width);
        CharSequence v1 = this.source;
        if(this.maxLines == 1) {
            v1 = TextUtils.ellipsize(v1, this.paint, ((float)v0), this.ellipsize);
        }

        this.end = Math.min(v1.length(), this.end);
        if((this.isRtl) && this.maxLines == 1) {
            this.alignment = Layout$Alignment.ALIGN_OPPOSITE;
        }

        StaticLayout$Builder v0_1 = StaticLayout$Builder.obtain(v1, this.start, this.end, this.paint, v0);
        v0_1.setAlignment(this.alignment);
        v0_1.setIncludePad(this.includePad);
        TextDirectionHeuristic v1_1 = this.isRtl ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
        v0_1.setTextDirection(v1_1);
        TextUtils$TruncateAt v1_2 = this.ellipsize;
        if(v1_2 != null) {
            v0_1.setEllipsize(v1_2);
        }

        v0_1.setMaxLines(this.maxLines);
        float v1_3 = this.lineSpacingAdd;
        if(v1_3 != 0f || this.lineSpacingMultiplier != 1f) {
            v0_1.setLineSpacing(v1_3, this.lineSpacingMultiplier);
        }

        if(this.maxLines > 1) {
            v0_1.setHyphenationFrequency(this.hyphenationFrequency);
        }

        StaticLayoutBuilderConfigurer v6 = this.staticLayoutBuilderConfigurer;
        if(v6 != null) {
            v6.configure(v0_1);
        }

        return v0_1.build();
    }

    private void createConstructorWithReflection() throws StaticLayoutBuilderCompatException {
        if(StaticLayoutBuilderCompat.initialized) {
            return;
        }

        try {
            boolean v4_1 = this.isRtl;
            Class v0 = TextDirectionHeuristic.class;
            TextDirectionHeuristic v4_2 = v4_1 ? TextDirectionHeuristics.RTL : TextDirectionHeuristics.LTR;
            StaticLayoutBuilderCompat.textDirection = v4_2;
            Constructor v4_3 = StaticLayout.class.getDeclaredConstructor(CharSequence.class, Integer.TYPE, Integer.TYPE, TextPaint.class, Integer.TYPE, Layout$Alignment.class, v0, Float.TYPE, Float.TYPE, Boolean.TYPE, TextUtils$TruncateAt.class, Integer.TYPE, Integer.TYPE);
            StaticLayoutBuilderCompat.constructor = v4_3;
            v4_3.setAccessible(true);
            StaticLayoutBuilderCompat.initialized = true;
            return;
        }
        catch(Exception v4) {
            throw new StaticLayoutBuilderCompatException(((Throwable)v4));
        }
    }

    public static StaticLayoutBuilderCompat obtain(CharSequence arg1, TextPaint arg2, int arg3) {
        return new StaticLayoutBuilderCompat(arg1, arg2, arg3);
    }

    public StaticLayoutBuilderCompat setAlignment(Layout$Alignment arg1) {
        this.alignment = arg1;
        return this;
    }

    public StaticLayoutBuilderCompat setEllipsize(TextUtils$TruncateAt arg1) {
        this.ellipsize = arg1;
        return this;
    }

    public StaticLayoutBuilderCompat setEnd(int arg1) {
        this.end = arg1;
        return this;
    }

    public StaticLayoutBuilderCompat setHyphenationFrequency(int arg1) {
        this.hyphenationFrequency = arg1;
        return this;
    }

    public StaticLayoutBuilderCompat setIncludePad(boolean arg1) {
        this.includePad = arg1;
        return this;
    }

    public StaticLayoutBuilderCompat setIsRtl(boolean arg1) {
        this.isRtl = arg1;
        return this;
    }

    public StaticLayoutBuilderCompat setLineSpacing(float arg1, float arg2) {
        this.lineSpacingAdd = arg1;
        this.lineSpacingMultiplier = arg2;
        return this;
    }

    public StaticLayoutBuilderCompat setMaxLines(int arg1) {
        this.maxLines = arg1;
        return this;
    }

    public StaticLayoutBuilderCompat setStart(int arg1) {
        this.start = arg1;
        return this;
    }

    public StaticLayoutBuilderCompat setStaticLayoutBuilderConfigurer(StaticLayoutBuilderConfigurer arg1) {
        this.staticLayoutBuilderConfigurer = arg1;
        return this;
    }
}

