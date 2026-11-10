package androidx.window.area.adapter;

import androidx.window.area.WindowAreaCapability$Status;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u0007¨\u0006\b"}, d2={"Landroidx/window/area/adapter/WindowAreaAdapterApi4;", "", "<init>", "()V", "translate", "Landroidx/window/area/WindowAreaCapability$Status;", "status", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowAreaAdapterApi4 {
    public static final WindowAreaAdapterApi4 INSTANCE;

    static {
        WindowAreaAdapterApi4.INSTANCE = new WindowAreaAdapterApi4();
    }

    private WindowAreaAdapterApi4() {
        super();
    }

    public final Status translate(int arg1) {
        if(arg1 != 0) {
            if(arg1 != 1) {
                if(arg1 != 2) {
                    if(arg1 != 3) {
                        return Status.WINDOW_AREA_STATUS_UNSUPPORTED;
                    }

                    return Status.WINDOW_AREA_STATUS_ACTIVE;
                }

                return Status.WINDOW_AREA_STATUS_AVAILABLE;
            }

            return Status.WINDOW_AREA_STATUS_UNAVAILABLE;
        }

        return Status.WINDOW_AREA_STATUS_UNSUPPORTED;
    }
}

