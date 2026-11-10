package androidx.window.area.adapter;

import androidx.window.area.WindowAreaCapability$Status;
import androidx.window.core.ExtensionsUtil;
import kotlin.Metadata;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J)\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\b\b\u0002\u0010\b\u001A\u00020\t2\b\b\u0002\u0010\n\u001A\u00020\u0007H\u0000¢\u0006\u0002\b\u000B¨\u0006\f"}, d2={"Landroidx/window/area/adapter/WindowAreaAdapter;", "", "<init>", "()V", "translate", "Landroidx/window/area/WindowAreaCapability$Status;", "status", "", "sessionActive", "", "vendorApiLevel", "translate$window_release", "window_release"}, k=1, mv={2, 0, 0}, xi=0x30) public final class WindowAreaAdapter {
    public static final WindowAreaAdapter INSTANCE;

    static {
        WindowAreaAdapter.INSTANCE = new WindowAreaAdapter();
    }

    private WindowAreaAdapter() {
        super();
    }

    public final Status translate$window_release(int arg1, boolean arg2, int arg3) {
        if(arg3 <= 3) {
            return WindowAreaAdapterApi3.INSTANCE.translate(arg1, arg2);
        }

        return WindowAreaAdapterApi4.INSTANCE.translate(arg1);
    }

    public static Status translate$window_release$default(WindowAreaAdapter arg0, int arg1, boolean arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = ExtensionsUtil.INSTANCE.getSafeVendorApiLevel();
        }

        return arg0.translate$window_release(arg1, false, arg3);
    }
}

