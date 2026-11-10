package androidx.core.os;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u001A4\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u00042\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u000E\b\u0004\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u001A4\u0010\n\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u00042\n\b\u0002\u0010\u0005\u001A\u0004\u0018\u00010\u00062\u000E\b\u0004\u0010\u0007\u001A\b\u0012\u0004\u0012\u00020\t0\bH\u0086\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2={"postDelayed", "Ljava/lang/Runnable;", "Landroid/os/Handler;", "delayInMillis", "", "token", "", "action", "Lkotlin/Function0;", "", "postAtTime", "uptimeMillis", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class HandlerKt {
    public static final Runnable postAtTime(Handler arg1, long arg2, Object arg4, Function0 arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        HandlerKt$postAtTime$runnable$1 v0 = new HandlerKt$postAtTime$runnable$1(arg5);
        arg1.postAtTime(((Runnable)v0), arg4, arg2);
        return ((Runnable)v0);
    }

    public static Runnable postAtTime$default(Handler arg0, long arg1, Object arg3, Function0 arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg3 = null;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "action");
        HandlerKt$postAtTime$runnable$1 v5 = new HandlerKt$postAtTime$runnable$1(arg4);
        arg0.postAtTime(((Runnable)v5), arg3, arg1);
        return ((Runnable)v5);
    }

    public static final Runnable postDelayed(Handler arg1, long arg2, Object arg4, Function0 arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "action");
        HandlerKt$postDelayed$runnable$1 v0 = new HandlerKt$postDelayed$runnable$1(arg5);
        if(arg4 == null) {
            arg1.postDelayed(((Runnable)v0), arg2);
            return ((Runnable)v0);
        }

        HandlerCompat.postDelayed(arg1, ((Runnable)v0), arg4, arg2);
        return ((Runnable)v0);
    }

    public static Runnable postDelayed$default(Handler arg0, long arg1, Object arg3, Function0 arg4, int arg5, Object arg6) {
        if((arg5 & 2) != 0) {
            arg3 = null;
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "action");
        HandlerKt$postDelayed$runnable$1 v5 = new HandlerKt$postDelayed$runnable$1(arg4);
        if(0 == 0) {
            arg0.postDelayed(((Runnable)v5), arg1);
            return ((Runnable)v5);
        }

        HandlerCompat.postDelayed(arg0, ((Runnable)v5), arg3, arg1);
        return ((Runnable)v5);
    }
}

