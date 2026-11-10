package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\bÂ\u0002\u0018\u00002\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0003\u0010\u0004J\u001C\u0010\u0005\u001A\u00020\u00062\b\u0010\u0007\u001A\u0004\u0018\u00010\u00022\b\u0010\b\u001A\u0004\u0018\u00010\u0002H\u0016J\b\u0010\t\u001A\u00020\nH\u0016¨\u0006\u000B"}, d2={"Landroidx/compose/runtime/StructuralEqualityPolicy;", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "", "<init>", "()V", "equivalent", "", "a", "b", "toString", "", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) final class StructuralEqualityPolicy implements SnapshotMutationPolicy {
    public static final StructuralEqualityPolicy INSTANCE;

    static {
        StructuralEqualityPolicy.INSTANCE = new StructuralEqualityPolicy();
    }

    private StructuralEqualityPolicy() {
        super();
    }

    public boolean equivalent(Object arg1, Object arg2) {
        return Intrinsics.areEqual(arg1, arg2);
    }

    public String toString() {
        return "StructuralEqualityPolicy";
    }
}

