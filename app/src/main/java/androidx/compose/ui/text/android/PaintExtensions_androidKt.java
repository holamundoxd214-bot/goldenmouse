package androidx.compose.ui.text.android;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.style.MetricAffectingSpan;
import kotlin.Metadata;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A$\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\u0006H\u0000\u001A\u0014\u0010\b\u001A\u00020\t*\u00020\u00012\u0006\u0010\n\u001A\u00020\u0001H\u0002\u001A$\u0010\u000B\u001A\u00020\u0001*\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u0006H\u0001\u001A,\u0010\u000F\u001A\u00020\t*\u00020\f2\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\r\u001A\u00020\u00062\u0006\u0010\u000E\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u0001H\u0002¨\u0006\u0010"}, d2={"getCharSequenceBounds", "Landroid/graphics/Rect;", "Landroid/text/TextPaint;", "text", "", "startInclusive", "", "endExclusive", "extendWith", "", "rect", "getStringBounds", "Landroid/graphics/Paint;", "start", "end", "fillStringBounds", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class PaintExtensions_androidKt {
    private static final void extendWith(Rect arg2, Rect arg3) {
        arg2.right += arg3.width();
        arg2.top = Math.min(arg2.top, arg3.top);
        arg2.bottom = Math.max(arg2.bottom, arg3.bottom);
    }

    private static final void fillStringBounds(Paint arg2, CharSequence arg3, int arg4, int arg5, Rect arg6) {
        if(Build$VERSION.SDK_INT >= 29) {
            Paint29.getTextBounds(arg2, arg3, arg4, arg5, arg6);
            return;
        }

        arg2.getTextBounds(arg3.toString(), arg4, arg5, arg6);
    }

    public static final Rect getCharSequenceBounds(TextPaint arg12, CharSequence arg13, int arg14, int arg15) {
        Class v0 = MetricAffectingSpan.class;
        if((arg13 instanceof Spanned)) {
            CharSequence v1 = arg13;
            if(!SpannedExtensions_androidKt.hasSpan(((Spanned)v1), v0, arg14, arg15)) {
            }
            else {
                Rect v2 = new Rect();
                Rect v3 = new Rect();
                TextPaint v4 = new TextPaint();
                while(arg14 < arg15) {
                    int v5 = ((Spanned)v1).nextSpanTransition(arg14, arg15, v0);
                    Object[] v6 = ((Spanned)v1).getSpans(arg14, v5, v0);
                    v4.set(arg12);
                    int v7 = v6.length;
                    int v8;
                    for(v8 = 0; v8 < v7; ++v8) {
                        Object v9 = v6[v8];
                        if(((Spanned)v1).getSpanStart(v9) != ((Spanned)v1).getSpanEnd(v9)) {
                            ((MetricAffectingSpan)v9).updateMeasureState(v4);
                        }
                    }

                    PaintExtensions_androidKt.fillStringBounds(v4, arg13, arg14, v5, v3);
                    PaintExtensions_androidKt.extendWith(v2, v3);
                    arg14 = v5;
                }

                return v2;
            }
        }

        return PaintExtensions_androidKt.getStringBounds(((Paint)arg12), arg13, arg14, arg15);
    }

    public static final Rect getStringBounds(Paint arg1, CharSequence arg2, int arg3, int arg4) {
        Rect v0 = new Rect();
        PaintExtensions_androidKt.fillStringBounds(arg1, arg2, arg3, arg4, v0);
        return v0;
    }
}

