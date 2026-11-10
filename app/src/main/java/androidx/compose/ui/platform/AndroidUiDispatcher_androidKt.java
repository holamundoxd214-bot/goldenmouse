package androidx.compose.ui.platform;

import android.os.Looper;
import kotlin.Metadata;

@Metadata(d1={"\u0000\b\n\u0000\n\u0002\u0010\u000B\n\u0000\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0002¨\u0006\u0002"}, d2={"isMainThread", "", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class AndroidUiDispatcher_androidKt {
    public static final boolean access$isMainThread() {
        return AndroidUiDispatcher_androidKt.isMainThread();
    }

    private static final boolean isMainThread() {
        if(Looper.myLooper() == Looper.getMainLooper()) {
            return 1;
        }

        return 0;
    }
}

