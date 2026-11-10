package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import kotlin.Metadata;

@Metadata(d1={"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0002\b\u0005\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JV\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000B2\u0006\u0010\u000E\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015JV\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00162\u0006\u0010\u0017\u001A\u00020\u000B2\u0006\u0010\u0018\u001A\u00020\u000B2\u0006\u0010\u0019\u001A\u00020\u000B2\u0006\u0010\u001A\u001A\u00020\u000B2\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00102\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u0015¨\u0006\u001B"}, d2={"Landroidx/compose/ui/text/android/CanvasCompatM;", "", "<init>", "()V", "drawTextRun", "", "canvas", "Landroid/graphics/Canvas;", "text", "", "index", "", "count", "contextIndex", "contextCount", "x", "", "y", "isRtl", "", "paint", "Landroid/graphics/Paint;", "", "start", "end", "contextStart", "contextEnd", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class CanvasCompatM {
    public static final CanvasCompatM INSTANCE;

    static {
        CanvasCompatM.INSTANCE = new CanvasCompatM();
    }

    private CanvasCompatM() {
        super();
    }

    public final void drawTextRun(Canvas arg1, CharSequence arg2, int arg3, int arg4, int arg5, int arg6, float arg7, float arg8, boolean arg9, Paint arg10) {
        arg1.drawTextRun(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public final void drawTextRun(Canvas arg1, char[] arg2, int arg3, int arg4, int arg5, int arg6, float arg7, float arg8, boolean arg9, Paint arg10) {
        arg1.drawTextRun(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }
}

