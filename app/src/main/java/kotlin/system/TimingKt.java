package kotlin.system;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001A(\u0010\u0000\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001A(\u0010\u0005\u001A\u00020\u00012\f\u0010\u0002\u001A\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, d2={"measureTimeMillis", "", "block", "Lkotlin/Function0;", "", "measureNanoTime", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class TimingKt {
    public static final long measureNanoTime(Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "block");
        long v0 = System.nanoTime();
        arg4.invoke();
        return System.nanoTime() - v0;
    }

    public static final long measureTimeMillis(Function0 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "block");
        long v0 = System.currentTimeMillis();
        arg4.invoke();
        return System.currentTimeMillis() - v0;
    }
}

