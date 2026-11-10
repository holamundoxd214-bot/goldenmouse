package androidx.emoji2.text;

import android.text.TextPaint;
import androidx.core.graphics.PaintCompat;

class DefaultGlyphChecker implements GlyphChecker {
    private static final int PAINT_TEXT_SIZE = 10;
    private final TextPaint mTextPaint;
    private static final ThreadLocal sStringBuilder;

    static {
        DefaultGlyphChecker.sStringBuilder = new ThreadLocal();
    }

    DefaultGlyphChecker() {
        super();
        TextPaint v0 = new TextPaint();
        this.mTextPaint = v0;
        v0.setTextSize(10f);
    }

    private static StringBuilder getStringBuilder() {
        ThreadLocal v0 = DefaultGlyphChecker.sStringBuilder;
        if(v0.get() == null) {
            v0.set(new StringBuilder());
        }

        return v0.get();
    }

    public boolean hasGlyph(CharSequence arg2, int arg3, int arg4, int arg5) {
        StringBuilder v5 = DefaultGlyphChecker.getStringBuilder();
        v5.setLength(0);
        while(arg3 < arg4) {
            v5.append(arg2.charAt(arg3));
            ++arg3;
        }

        return PaintCompat.hasGlyph(this.mTextPaint, v5.toString());
    }
}

