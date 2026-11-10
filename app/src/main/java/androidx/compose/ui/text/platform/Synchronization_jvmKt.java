package androidx.compose.ui.text.platform;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0015\u0010\u0000\u001A\u00020\u00012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003H\u0080\b\u001A7\u0010\u0004\u001A\u0002H\u0005\"\u0004\b\u0000\u0010\u00052\u0006\u0010\u0006\u001A\u00020\u00012\f\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00050\bH\u0081\b\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\t¨\u0006\n"}, d2={"makeSynchronizedObject", "Landroidx/compose/ui/text/platform/SynchronizedObject;", "ref", "", "synchronized", "R", "lock", "block", "Lkotlin/Function0;", "(Landroidx/compose/ui/text/platform/SynchronizedObject;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class Synchronization_jvmKt {
    public static final SynchronizedObject makeSynchronizedObject(Object arg0) {
        return new SynchronizedObject();
    }

    public static SynchronizedObject makeSynchronizedObject$default(Object arg0, int arg1, Object arg2) {
        return new SynchronizedObject();
    }

    public static final Object synchronized(SynchronizedObject arg0, Function0 arg1) {
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

