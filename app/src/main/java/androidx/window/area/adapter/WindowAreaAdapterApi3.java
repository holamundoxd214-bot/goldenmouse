package androidx.window.area.adapter;

import androidx.window.area.WindowAreaCapability$Status;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t¨\u0006\n"}, d2={"Landroidx/window/area/adapter/WindowAreaAdapterApi3;", "", "<init>", "()V", "translate", "Landroidx/window/area/WindowAreaCapability$Status;", "status", "", "sessionActive", "", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowAreaAdapterApi3 {
    public static final WindowAreaAdapterApi3 INSTANCE;

    static {
        WindowAreaAdapterApi3.INSTANCE = new WindowAreaAdapterApi3();
    }

    private WindowAreaAdapterApi3() {
        super();
    }

    public final Status translate(int arg1, boolean arg2) {
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

            if(arg2) {
                return Status.WINDOW_AREA_STATUS_ACTIVE;
            }

            return Status.WINDOW_AREA_STATUS_UNAVAILABLE;
        }

        return Status.WINDOW_AREA_STATUS_UNSUPPORTED;
    }
}

