package androidx.window.area;

import androidx.window.extensions.area.WindowAreaComponent;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\u0006\u001A\u00020\u0007H\u0016R\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2={"Landroidx/window/area/RearDisplaySessionImpl;", "Landroidx/window/area/WindowAreaSession;", "windowAreaComponent", "Landroidx/window/extensions/area/WindowAreaComponent;", "<init>", "(Landroidx/window/extensions/area/WindowAreaComponent;)V", "close", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class RearDisplaySessionImpl implements WindowAreaSession {
    private final WindowAreaComponent windowAreaComponent;

    public RearDisplaySessionImpl(WindowAreaComponent arg2) {
        Intrinsics.checkNotNullParameter(arg2, "windowAreaComponent");
        super();
        this.windowAreaComponent = arg2;
    }

    public void close() {
        this.windowAreaComponent.endRearDisplaySession();
    }
}

