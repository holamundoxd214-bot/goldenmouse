package androidx.compose.ui.text.android;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import kotlin.Metadata;

@Metadata(d1={"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tJ\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\nJ.\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\f2\u0006\u0010\u000E\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\fJ.\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u00102\u0006\u0010\r\u001A\u00020\u00102\u0006\u0010\u000E\u001A\u00020\u00102\u0006\u0010\u000F\u001A\u00020\u0010J\u0016\u0010\u0011\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\u0013¨\u0006\u0014"}, d2={"Landroidx/compose/ui/text/android/CanvasCompatO;", "", "<init>", "()V", "clipOutRect", "", "canvas", "Landroid/graphics/Canvas;", "rect", "Landroid/graphics/RectF;", "Landroid/graphics/Rect;", "left", "", "top", "right", "bottom", "", "clipOutPath", "path", "Landroid/graphics/Path;", "ui-text"}, k=1, mv={2, 0, 0}, xi=0x30) final class CanvasCompatO {
    public static final CanvasCompatO INSTANCE;

    static {
        CanvasCompatO.INSTANCE = new CanvasCompatO();
    }

    private CanvasCompatO() {
        super();
    }

    public final boolean clipOutPath(Canvas arg1, Path arg2) {
        return arg1.clipOutPath(arg2);
    }

    public final boolean clipOutRect(Canvas arg1, float arg2, float arg3, float arg4, float arg5) {
        return arg1.clipOutRect(arg2, arg3, arg4, arg5);
    }

    public final boolean clipOutRect(Canvas arg1, int arg2, int arg3, int arg4, int arg5) {
        return arg1.clipOutRect(arg2, arg3, arg4, arg5);
    }

    public final boolean clipOutRect(Canvas arg1, Rect arg2) {
        return arg1.clipOutRect(arg2);
    }

    public final boolean clipOutRect(Canvas arg1, RectF arg2) {
        return arg1.clipOutRect(arg2);
    }
}

