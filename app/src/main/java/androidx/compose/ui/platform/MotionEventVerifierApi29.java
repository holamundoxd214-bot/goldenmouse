package androidx.compose.ui.platform;

import android.view.MotionEvent;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tH\u0007¨\u0006\n"}, d2={"Landroidx/compose/ui/platform/MotionEventVerifierApi29;", "", "<init>", "()V", "isValidMotionEvent", "", "event", "Landroid/view/MotionEvent;", "index", "", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class MotionEventVerifierApi29 {
    public static final MotionEventVerifierApi29 INSTANCE;

    static {
        MotionEventVerifierApi29.INSTANCE = new MotionEventVerifierApi29();
    }

    private MotionEventVerifierApi29() {
        super();
    }

    public final boolean isValidMotionEvent(MotionEvent arg3, int arg4) {
        int v0 = 0x7FFFFFFF;
        int v1 = 0x7F800000;
        if((Float.floatToRawIntBits(arg3.getRawX(arg4)) & v0) < v1 && (Float.floatToRawIntBits(arg3.getRawY(arg4)) & v0) < v1) {
            return 1;
        }

        return 0;
    }
}

