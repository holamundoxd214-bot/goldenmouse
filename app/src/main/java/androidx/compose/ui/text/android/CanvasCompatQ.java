package androidx.compose.ui.text.android;

import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.RenderNode;
import android.graphics.text.MeasuredText;
import kotlin.Metadata;

@Metadata(d1={"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u000E\u0010\b\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007J\u0016\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BJ\u001E\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000EJ\u001E\u0010\t\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000B2\u0006\u0010\r\u001A\u00020\u000EJF\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00132\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u0019J6\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u001A\u001A\u00020\u001B2\u0006\u0010\u0015\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u001B2\u0006\u0010\u0018\u001A\u00020\u0019JV\u0010\u001D\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u001E\u001A\u00020\u001F2\u0006\u0010 \u001A\u00020\f2\u0006\u0010!\u001A\u00020\f2\u0006\u0010\"\u001A\u00020\f2\u0006\u0010#\u001A\u00020\f2\u0006\u0010$\u001A\u00020\u00132\u0006\u0010%\u001A\u00020\u00132\u0006\u0010&\u001A\u00020\'2\u0006\u0010\u0018\u001A\u00020\u0019J\u0016\u0010(\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010)\u001A\u00020*¨\u0006+"}, d2={"Landroidx/compose/ui/text/android/CanvasCompatQ;", "", "<init>", "()V", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "disableZ", "drawColor", "color", "", "", "mode", "Landroid/graphics/BlendMode;", "drawDoubleRoundRect", "outer", "Landroid/graphics/RectF;", "outerRx", "", "outerRy", "inner", "innerRx", "innerRy", "paint", "Landroid/graphics/Paint;", "outerRadii", "", "innerRadii", "drawTextRun", "text", "Landroid/graphics/text/MeasuredText;", "start", "end", "contextStart", "contextEnd", "x", "y", "isRtl", "", "drawRenderNode", "renderNode", "Landroid/graphics/RenderNode;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class CanvasCompatQ {
    public static final CanvasCompatQ INSTANCE;

    static {
        CanvasCompatQ.INSTANCE = new CanvasCompatQ();
    }

    private CanvasCompatQ() {
        super();
    }

    public final void disableZ(Canvas arg1) {
        arg1.disableZ();
    }

    public final void drawColor(Canvas arg1, int arg2, BlendMode arg3) {
        arg1.drawColor(arg2, arg3);
    }

    public final void drawColor(Canvas arg1, long arg2) {
        arg1.drawColor(arg2);
    }

    public final void drawColor(Canvas arg1, long arg2, BlendMode arg4) {
        arg1.drawColor(arg2, arg4);
    }

    public final void drawDoubleRoundRect(Canvas arg1, RectF arg2, float arg3, float arg4, RectF arg5, float arg6, float arg7, Paint arg8) {
        arg1.drawDoubleRoundRect(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public final void drawDoubleRoundRect(Canvas arg1, RectF arg2, float[] arg3, RectF arg4, float[] arg5, Paint arg6) {
        arg1.drawDoubleRoundRect(arg2, arg3, arg4, arg5, arg6);
    }

    public final void drawRenderNode(Canvas arg1, RenderNode arg2) {
        arg1.drawRenderNode(arg2);
    }

    public final void drawTextRun(Canvas arg1, MeasuredText arg2, int arg3, int arg4, int arg5, int arg6, float arg7, float arg8, boolean arg9, Paint arg10) {
        arg1.drawTextRun(arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9, arg10);
    }

    public final void enableZ(Canvas arg1) {
        arg1.enableZ();
    }
}

