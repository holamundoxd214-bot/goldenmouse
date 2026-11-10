package androidx.compose.runtime;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000B\n\u0002\b\t\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u001D\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00028\u00002\u0006\u0010\u0006\u001A\u00028\u0000H&¢\u0006\u0002\u0010\u0007J\'\u0010\b\u001A\u0004\u0018\u00018\u00002\u0006\u0010\t\u001A\u00028\u00002\u0006\u0010\n\u001A\u00028\u00002\u0006\u0010\u000B\u001A\u00028\u0000H\u0016¢\u0006\u0002\u0010\fø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\rÀ\u0006\u0003"}, d2={"Landroidx/compose/runtime/SnapshotMutationPolicy;", "T", "", "equivalent", "", "a", "b", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "merge", "previous", "current", "applied", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public interface SnapshotMutationPolicy {
    @Metadata(k=3, mv={2, 1, 0}, xi=0x30) public final class DefaultImpls {
        @Deprecated public static Object merge(SnapshotMutationPolicy arg0, Object arg1, Object arg2, Object arg3) {
            return arg0.merge(arg1, arg2, arg3);
        }
    }

    static Object access$merge$jd(SnapshotMutationPolicy arg0, Object arg1, Object arg2, Object arg3) {
        return super.merge(arg1, arg2, arg3);
    }

    boolean equivalent(Object arg1, Object arg2);

    default Object merge(Object arg1, Object arg2, Object arg3) {
        return null;
    }
}

