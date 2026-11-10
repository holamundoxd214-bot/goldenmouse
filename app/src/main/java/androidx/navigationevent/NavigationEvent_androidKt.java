package androidx.navigationevent;

import android.os.Build$VERSION;
import android.window.BackEvent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0001¨\u0006\u0004"}, d2={"NavigationEvent", "Landroidx/navigationevent/NavigationEvent;", "backEvent", "Landroid/window/BackEvent;", "navigationevent"}, k=2, mv={2, 0, 0}, xi=0x30) public final class NavigationEvent_androidKt {
    public static final NavigationEvent NavigationEvent(BackEvent arg8) {
        Intrinsics.checkNotNullParameter(arg8, "backEvent");
        float v4 = arg8.getTouchX();
        float v5 = arg8.getTouchY();
        float v3 = arg8.getProgress();
        int v2 = arg8.getSwipeEdge();
        long v0 = Build$VERSION.SDK_INT >= 36 ? arg8.getFrameTimeMillis() : 0;
        return new NavigationEvent(v2, v3, v4, v5, v0);
    }
}

