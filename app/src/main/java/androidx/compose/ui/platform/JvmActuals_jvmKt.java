package androidx.compose.ui.platform;

import java.util.Arrays;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001A\u001A\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00052\b\u0010\u0006\u001A\u0004\u0018\u00010\u0003H\u0000\u001A\f\u0010\u0007\u001A\u00020\u0005*\u00020\u0005H\u0000\u001A0\u0010\b\u001A\u0002H\t\"\u0004\b\u0000\u0010\t2\n\u0010\n\u001A\u00060\u0005j\u0002`\u000B2\f\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\t0\rH\u0081\b¢\u0006\u0004\b\u000E\u0010\u000F*\f\b\u0000\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0010"}, d2={"AtomicInt", "Ljava/util/concurrent/atomic/AtomicInteger;", "simpleIdentityToString", "", "obj", "", "name", "nativeClass", "oldSynchronized", "R", "lock", "Landroidx/compose/ui/platform/SynchronizedObject;", "block", "Lkotlin/Function0;", "synchronized", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class JvmActuals_jvmKt {
    public static final Object nativeClass(Object arg0) {
        return arg0.getClass();
    }

    public static final String simpleIdentityToString(Object arg1, String arg2) {
        if(arg2 == null) {
            arg2 = arg1.getClass().isAnonymousClass() ? arg1.getClass().getName() : arg1.getClass().getSimpleName();
        }

        StringBuilder v2 = new StringBuilder().append(arg2).append('@');
        String v1 = String.format("%07x", Arrays.copyOf(new Object[]{Integer.valueOf(System.identityHashCode(arg1))}, 1));
        Intrinsics.checkNotNullExpressionValue(v1, "format(...)");
        return v2.append(v1).toString();
    }

    @Deprecated(level=DeprecationLevel.HIDDEN, message="not expected to be referenced directly as the old version had to be inlined") public static final Object synchronized(Object arg0, Function0 arg1) {
        Object v1_1;
        __monitor_enter(arg0);
        try {
            v1_1 = arg1.invoke();
        }
        catch(Throwable v1) {
            __monitor_exit(arg0);
            throw v1;
        }

        __monitor_exit(arg0);
        return v1_1;
    }
}

