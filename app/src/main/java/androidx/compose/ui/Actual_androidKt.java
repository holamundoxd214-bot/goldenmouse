package androidx.compose.ui;

import android.os.Handler;
import android.os.Looper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001A\b\u0010\u0000\u001A\u00020\u0001H\u0000\u001A\u001E\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0000\u001A\u0012\u0010\n\u001A\u00020\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0005H\u0000\"\u000E\u0010\u0002\u001A\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"currentTimeMillis", "", "handler", "Landroid/os/Handler;", "postDelayed", "", "delayMillis", "block", "Lkotlin/Function0;", "", "removePost", "token", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Actual_androidKt {
    private static final Handler handler;

    static {
        Actual_androidKt.handler = new Handler(Looper.getMainLooper());
    }

    public static final long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static final Object postDelayed(long arg1, Function0 arg3) {
        Actual_androidKt$$ExternalSyntheticLambda0 v0 = new Actual_androidKt$$ExternalSyntheticLambda0(arg3);
        Actual_androidKt.handler.postDelayed(((Runnable)v0), arg1);
        return v0;
    }

    static final void postDelayed$lambda$0(Function0 arg0) {
        arg0.invoke();
    }

    public static final void removePost(Object arg1) {
        Object v0 = (arg1 instanceof Runnable) ? arg1 : null;
        if(v0 == null) {
            return;
        }

        Actual_androidKt.handler.removeCallbacks(((Runnable)arg1));
    }
}

