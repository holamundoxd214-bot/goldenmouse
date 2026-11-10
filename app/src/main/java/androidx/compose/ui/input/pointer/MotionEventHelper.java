package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¢\u0006\u0004\b\n\u0010\u000B¨\u0006\f"}, d2={"Landroidx/compose/ui/input/pointer/MotionEventHelper;", "", "<init>", "()V", "toRawOffset", "Landroidx/compose/ui/geometry/Offset;", "motionEvent", "Landroid/view/MotionEvent;", "index", "", "toRawOffset-dBAh8RU", "(Landroid/view/MotionEvent;I)J", "ui"}, k=1, mv={2, 0, 0}, xi=0x30) final class MotionEventHelper {
    public static final MotionEventHelper INSTANCE;

    static {
        MotionEventHelper.INSTANCE = new MotionEventHelper();
    }

    private MotionEventHelper() {
        super();
    }

    public final long toRawOffset-dBAh8RU(MotionEvent arg5, int arg6) {
        return Offset.constructor-impl((((long)Float.floatToRawIntBits(arg5.getRawY(arg6)))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg5.getRawX(arg6)))) << 0x20);
    }
}

