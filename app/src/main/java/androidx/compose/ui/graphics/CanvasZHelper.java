package androidx.compose.ui.graphics;

import android.graphics.Canvas;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2={"Landroidx/compose/ui/graphics/CanvasZHelper;", "", "<init>", "()V", "enableZ", "", "canvas", "Landroid/graphics/Canvas;", "enable", "", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class CanvasZHelper {
    public static final CanvasZHelper INSTANCE;

    static {
        CanvasZHelper.INSTANCE = new CanvasZHelper();
    }

    private CanvasZHelper() {
        super();
    }

    public final void enableZ(Canvas arg1, boolean arg2) {
        if(arg2) {
            arg1.enableZ();
            return;
        }

        arg1.disableZ();
    }
}

