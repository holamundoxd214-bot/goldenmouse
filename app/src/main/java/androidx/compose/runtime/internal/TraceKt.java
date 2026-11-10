package androidx.compose.runtime.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

@Metadata(d1={"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A*\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2={"trace", "T", "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TraceKt {
    public static final Object trace(String arg1, Function0 arg2) {
        Object v2_1;
        Object v1 = Trace.INSTANCE.beginSection(arg1);
        try {
            v2_1 = arg2.invoke();
        }
        catch(Throwable v2) {
            Trace.INSTANCE.endSection(v1);
            throw v2;
        }

        Trace.INSTANCE.endSection(v1);
        return v2_1;
    }
}

