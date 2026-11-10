package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A\u0012\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001A\u0012\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001A\u0012\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002¨\u0006\u0005"}, d2={"referentialEqualityPolicy", "Landroidx/compose/runtime/SnapshotMutationPolicy;", "T", "structuralEqualityPolicy", "neverEqualPolicy", "runtime"}, k=5, mv={2, 1, 0}, xi=0x30, xs="androidx/compose/runtime/SnapshotStateKt") final class SnapshotStateKt__SnapshotMutationPolicyKt {
    public static final SnapshotMutationPolicy neverEqualPolicy() {
        NeverEqualPolicy v0 = NeverEqualPolicy.INSTANCE;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.SnapshotStateKt__SnapshotMutationPolicyKt.neverEqualPolicy>");
        return ((SnapshotMutationPolicy)v0);
    }

    public static final SnapshotMutationPolicy referentialEqualityPolicy() {
        ReferentialEqualityPolicy v0 = ReferentialEqualityPolicy.INSTANCE;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.SnapshotStateKt__SnapshotMutationPolicyKt.referentialEqualityPolicy>");
        return ((SnapshotMutationPolicy)v0);
    }

    public static final SnapshotMutationPolicy structuralEqualityPolicy() {
        StructuralEqualityPolicy v0 = StructuralEqualityPolicy.INSTANCE;
        Intrinsics.checkNotNull(v0, "null cannot be cast to non-null type androidx.compose.runtime.SnapshotMutationPolicy<T of androidx.compose.runtime.SnapshotStateKt__SnapshotMutationPolicyKt.structuralEqualityPolicy>");
        return ((SnapshotMutationPolicy)v0);
    }
}

