package androidx.emoji2.text;

import android.graphics.Canvas;
import android.graphics.Paint$Style;
import android.graphics.Paint;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.MetricAffectingSpan;

public final class TypefaceEmojiSpan extends EmojiSpan {
    private TextPaint mWorkingPaint;
    private static Paint sDebugPaint;

    public TypefaceEmojiSpan(TypefaceEmojiRasterizer arg1) {
        super(arg1);
    }

    private TextPaint applyCharacterSpanStyles(CharSequence arg3, int arg4, int arg5, Paint arg6) {
        TextPaint v1 = null;
        if((arg3 instanceof Spanned)) {
            Object[] v3 = ((Spanned)arg3).getSpans(arg4, arg5, CharacterStyle.class);
            if(v3.length != 0) {
                arg5 = 0;
                if(v3.length == 1 && v3[0] == this) {
                    goto label_29;
                }

                TextPaint v4 = this.mWorkingPaint;
                if(v4 == null) {
                    v4 = new TextPaint();
                    this.mWorkingPaint = v4;
                }

                v4.set(arg6);
                while(arg5 < v3.length) {
                    Object v2 = v3[arg5];
                    if(!(v2 instanceof MetricAffectingSpan)) {
                        ((CharacterStyle)v2).updateDrawState(v4);
                    }

                    ++arg5;
                }

                return v4;
            }

        label_29:
            if((arg6 instanceof TextPaint)) {
                return arg6;
            }

            return v1;
        }

        if((arg6 instanceof TextPaint)) {
            return arg6;
        }

        return v1;
    }

    public void draw(Canvas arg11, CharSequence arg12, int arg13, int arg14, float arg15, int arg16, int arg17, int arg18, Paint arg19) {
        int v0 = arg16;
        int v1 = arg18;
        Paint v2 = arg19;
        TextPaint v5 = this.applyCharacterSpanStyles(arg12, arg13, arg14, v2);
        if(v5 != null && v5.bgColor != 0) {
            this.drawBackground(arg11, v5, arg15, arg15 + (((float)this.getWidth())), ((float)v0), ((float)v1));
        }

        TextPaint v12 = v5;
        if(EmojiCompat.get().isEmojiSpanIndicatorEnabled()) {
            arg11.drawRect(arg15, ((float)v0), arg15 + (((float)this.getWidth())), ((float)v1), TypefaceEmojiSpan.getDebugPaint());
        }

        TypefaceEmojiRasterizer v10 = this.getTypefaceRasterizer();
        float v13 = ((float)arg17);
        if(v12 != null) {
        }
        else {
            Paint v12_1 = v2;
        }

        v10.draw(arg11, arg15, v13, ((Paint)v12));
    }

    void drawBackground(Canvas arg4, TextPaint arg5, float arg6, float arg7, float arg8, float arg9) {
        int v3 = arg5.getColor();
        Paint$Style v0 = arg5.getStyle();
        arg5.setColor(arg5.bgColor);
        arg5.setStyle(Paint$Style.FILL);
        arg4.drawRect(arg6, arg8, arg7, arg9, arg5);
        arg5.setStyle(v0);
        arg5.setColor(v3);
    }

    private static Paint getDebugPaint() {
        if(TypefaceEmojiSpan.sDebugPaint == null) {
            TextPaint v0 = new TextPaint();
            TypefaceEmojiSpan.sDebugPaint = ((Paint)v0);
            ((Paint)v0).setColor(EmojiCompat.get().getEmojiSpanIndicatorColor());
            TypefaceEmojiSpan.sDebugPaint.setStyle(Paint$Style.FILL);
        }

        return TypefaceEmojiSpan.sDebugPaint;
    }
}

