package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001A\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\b\u001A\u00020\t2\b\u0010\n\u001A\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000B\u001A\u00020\fH\u0016R\u0014\u0010\u0002\u001A\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001A\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2={"Landroidx/compose/runtime/CompositionLocalContext;", "", "compositionLocals", "Landroidx/compose/runtime/PersistentCompositionLocalMap;", "<init>", "(Landroidx/compose/runtime/PersistentCompositionLocalMap;)V", "getCompositionLocals$runtime", "()Landroidx/compose/runtime/PersistentCompositionLocalMap;", "equals", "", "other", "hashCode", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class CompositionLocalContext {
    public static final int $stable;
    private final PersistentCompositionLocalMap compositionLocals;

    static {
    }

    public CompositionLocalContext(PersistentCompositionLocalMap arg1) {
        super();
        this.compositionLocals = arg1;
    }

    public boolean equals(Object arg2) {
        if(((arg2 instanceof CompositionLocalContext)) && (Intrinsics.areEqual(((CompositionLocalContext)arg2).compositionLocals, this.compositionLocals))) {
            return 1;
        }

        return 0;
    }

    public final PersistentCompositionLocalMap getCompositionLocals$runtime() {
        return this.compositionLocals;
    }

    public int hashCode() {
        return this.compositionLocals.hashCode();
    }
}

