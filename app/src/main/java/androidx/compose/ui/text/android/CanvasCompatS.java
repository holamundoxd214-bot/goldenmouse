package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.fonts.Font;
import kotlin.Metadata;

@Metadata(d1={"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J(\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000B2\b\u0010\f\u001A\u0004\u0018\u00010\rJ(\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000E2\b\u0010\f\u001A\u0004\u0018\u00010\rJF\u0010\u000F\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0010\u001A\u00020\u00112\u0006\u0010\u0012\u001A\u00020\u00132\u0006\u0010\u0014\u001A\u00020\u00152\u0006\u0010\u0016\u001A\u00020\u00132\u0006\u0010\u0017\u001A\u00020\u00132\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010\f\u001A\u00020\r¨\u0006\u001A"}, d2={"Landroidx/compose/ui/text/android/CanvasCompatS;", "", "<init>", "()V", "drawPatch", "", "canvas", "Landroid/graphics/Canvas;", "patch", "Landroid/graphics/NinePatch;", "dst", "Landroid/graphics/Rect;", "paint", "Landroid/graphics/Paint;", "Landroid/graphics/RectF;", "drawGlyphs", "glyphIds", "", "glyphIdOffset", "", "positions", "", "positionOffset", "glyphCount", "font", "Landroid/graphics/fonts/Font;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class CanvasCompatS {
    public static final CanvasCompatS INSTANCE;

    static {
        CanvasCompatS.INSTANCE = new CanvasCompatS();
    }

    private CanvasCompatS() {
        super();
    }

    public final void drawGlyphs(Canvas arg1, int[] arg2, int arg3, float[] arg4, int arg5, int arg6, Font arg7, Paint arg8) {
        arg1.drawGlyphs(arg2, arg3, arg4, arg5, arg6, arg7, arg8);
    }

    public final void drawPatch(Canvas arg1, NinePatch arg2, Rect arg3, Paint arg4) {
        arg1.drawPatch(arg2, arg3, arg4);
    }

    public final void drawPatch(Canvas arg1, NinePatch arg2, RectF arg3, Paint arg4) {
        arg1.drawPatch(arg2, arg3, arg4);
    }
}

