package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.RectF;
import kotlin.Metadata;

@Metadata(d1={"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BJ.\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\r2\u0006\u0010\u000F\u001A\u00020\r2\u0006\u0010\u0010\u001A\u00020\r¨\u0006\u0011"}, d2={"Landroidx/compose/ui/text/android/CanvasCompatR;", "", "<init>", "()V", "quickReject", "", "canvas", "Landroid/graphics/Canvas;", "rect", "Landroid/graphics/RectF;", "path", "Landroid/graphics/Path;", "left", "", "top", "right", "bottom", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class CanvasCompatR {
    public static final CanvasCompatR INSTANCE;

    static {
        CanvasCompatR.INSTANCE = new CanvasCompatR();
    }

    private CanvasCompatR() {
        super();
    }

    public final boolean quickReject(Canvas arg1, float arg2, float arg3, float arg4, float arg5) {
        return arg1.quickReject(arg2, arg3, arg4, arg5);
    }

    public final boolean quickReject(Canvas arg1, Path arg2) {
        return arg1.quickReject(arg2);
    }

    public final boolean quickReject(Canvas arg1, RectF arg2) {
        return arg1.quickReject(arg2);
    }
}

