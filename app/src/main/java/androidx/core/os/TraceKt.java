package androidx.core.os;

import android.os.Trace;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0012\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A-\u0010\u0000\u001A\u0002H\u0001\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0002\u001A\u00020\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007"}, d2={"trace", "T", "sectionName", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class TraceKt {
    @Deprecated(message="Use androidx.tracing.Trace instead", replaceWith="<_subannotation>") public static final Object trace(String arg1, Function0 arg2) {
        Object v1_1;
        Intrinsics.checkNotNullParameter(arg1, "sectionName");
        Intrinsics.checkNotNullParameter(arg2, "block");
        Trace.beginSection(arg1);
        try {
            v1_1 = arg2.invoke();
        }
        catch(Throwable v1) {
            Trace.endSection();
            throw v1;
        }

        Trace.endSection();
        return v1_1;
    }
}

