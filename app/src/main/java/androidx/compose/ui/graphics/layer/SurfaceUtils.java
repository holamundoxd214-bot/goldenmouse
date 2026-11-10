package androidx.compose.ui.graphics.layer;

import android.graphics.Canvas;
import android.view.Surface;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007J\u0006\u0010\f\u001A\u00020\u0007J\n\u0010\r\u001A\u0004\u0018\u00010\u0005H\u0003J\u0010\u0010\u000E\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0003R\u0010\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2={"Landroidx/compose/ui/graphics/layer/SurfaceUtils;", "", "<init>", "()V", "lockHardwareCanvasMethod", "Ljava/lang/reflect/Method;", "hasRetrievedMethod", "", "lockCanvas", "Landroid/graphics/Canvas;", "surface", "Landroid/view/Surface;", "isLockHardwareCanvasAvailable", "resolveLockHardwareCanvasMethod", "lockCanvasFallback", "ui-graphics"}, k=1, mv={2, 0, 0}, xi=0x30) public final class SurfaceUtils {
    public static final int $stable;
    public static final SurfaceUtils INSTANCE;
    private static boolean hasRetrievedMethod;
    private static Method lockHardwareCanvasMethod;

    static {
        SurfaceUtils.INSTANCE = new SurfaceUtils();
        SurfaceUtils.$stable = 8;
    }

    private SurfaceUtils() {
        super();
    }

    public final boolean isLockHardwareCanvasAvailable() {
        return 1;
    }

    public final Canvas lockCanvas(Surface arg1) {
        return SurfaceVerificationHelper.INSTANCE.lockHardwareCanvas(arg1);
    }

    private final Canvas lockCanvasFallback(Surface arg2) {
        Method v1 = this.resolveLockHardwareCanvasMethod();
        if(v1 != null) {
            Object v1_1 = v1.invoke(arg2);
            Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type android.graphics.Canvas");
            return ((Canvas)v1_1);
        }

        return arg2.lockCanvas(null);
    }

    private final Method resolveLockHardwareCanvasMethod() {
        Method v0;
        __monitor_enter(this);
        try {
            v0 = SurfaceUtils.lockHardwareCanvasMethod;
            if(SurfaceUtils.hasRetrievedMethod) {
                goto label_17;
            }

            SurfaceUtils.hasRetrievedMethod = true;
            Method v1 = Surface.class.getDeclaredMethod("lockHardwareCanvas");
            v1.setAccessible(true);
            SurfaceUtils.lockHardwareCanvasMethod = v1;
            v0 = v1;
        }
        catch(Throwable ) {
            v0 = null;
            try {
                SurfaceUtils.lockHardwareCanvasMethod = v0;
            }
            catch(Throwable v0_1) {
                __monitor_exit(this);
                throw v0_1;
            }
        }

    label_17:
        __monitor_exit(this);
        return v0;
    }
}

