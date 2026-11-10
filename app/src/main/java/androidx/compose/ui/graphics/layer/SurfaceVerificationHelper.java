package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.view.Surface;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/compose/ui/graphics/layer/SurfaceVerificationHelper;", "", "<init>", "()V", "lockHardwareCanvas", "Landroid/graphics/Canvas;", "surface", "Landroid/view/Surface;", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) final class SurfaceVerificationHelper {
    public static final SurfaceVerificationHelper INSTANCE;

    static {
        SurfaceVerificationHelper.INSTANCE = new SurfaceVerificationHelper();
    }

    private SurfaceVerificationHelper() {
        super();
    }

    public final Canvas lockHardwareCanvas(Surface arg1) {
        return arg1.lockHardwareCanvas();
    }
}

