package kotlinx.coroutines.debug.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.Symbol;

@Metadata(d1={"\u0000$\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0001\n\u0000\u001A\u000E\u0010\b\u001A\u00020\u0006*\u0004\u0018\u00010\tH\u0002\u001A\b\u0010\n\u001A\u00020\u000BH\u0002\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0005\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"MAGIC", "", "MIN_CAPACITY", "REHASH", "Lkotlinx/coroutines/internal/Symbol;", "MARKED_NULL", "Lkotlinx/coroutines/debug/internal/Marked;", "MARKED_TRUE", "mark", "", "noImpl", "", "kotlinx-coroutines-core"}, k=2, mv={2, 1, 0}, xi=0x30) public final class ConcurrentWeakMapKt {
    private static final int MAGIC = -1640531527;
    private static final Marked MARKED_NULL = null;
    private static final Marked MARKED_TRUE = null;
    private static final int MIN_CAPACITY = 16;
    private static final Symbol REHASH;

    static {
        ConcurrentWeakMapKt.REHASH = new Symbol("REHASH");
        ConcurrentWeakMapKt.MARKED_NULL = new Marked(null);
        ConcurrentWeakMapKt.MARKED_TRUE = new Marked(Boolean.valueOf(true));
    }

    public static final Symbol access$getREHASH$p() {
        return ConcurrentWeakMapKt.REHASH;
    }

    public static final Marked access$mark(Object arg0) {
        return ConcurrentWeakMapKt.mark(arg0);
    }

    public static final Void access$noImpl() {
        return ConcurrentWeakMapKt.noImpl();
    }

    private static final Marked mark(Object arg1) {
        if(arg1 == null) {
            return ConcurrentWeakMapKt.MARKED_NULL;
        }

        if(Intrinsics.areEqual(arg1, Boolean.valueOf(true))) {
            return ConcurrentWeakMapKt.MARKED_TRUE;
        }

        return new Marked(arg1);
    }

    private static final Void noImpl() {
        throw new UnsupportedOperationException("not implemented");
    }
}

