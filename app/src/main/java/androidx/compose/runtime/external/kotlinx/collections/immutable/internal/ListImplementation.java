package androidx.compose.runtime.external.kotlinx.collections.immutable.internal;

import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u001E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001D\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0001¢\u0006\u0002\b\tJ\u001D\u0010\n\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0001¢\u0006\u0002\b\u000BJ%\u0010\f\u001A\u00020\u00052\u0006\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u0007H\u0001¢\u0006\u0002\b\u000FJ\u0019\u0010\u0010\u001A\u00020\u00072\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0013J%\u0010\u0014\u001A\u00020\u00152\n\u0010\u0011\u001A\u0006\u0012\u0002\b\u00030\u00122\n\u0010\u0016\u001A\u0006\u0012\u0002\b\u00030\u0012H\u0001¢\u0006\u0002\b\u0017¨\u0006\u0018"}, d2={"Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/ListImplementation;", "", "<init>", "()V", "checkElementIndex", "", "index", "", "size", "checkElementIndex$runtime", "checkPositionIndex", "checkPositionIndex$runtime", "checkRangeIndexes", "fromIndex", "toIndex", "checkRangeIndexes$runtime", "orderedHashCode", "c", "", "orderedHashCode$runtime", "orderedEquals", "", "other", "orderedEquals$runtime", "runtime"}, k=1, mv={2, 1, 0}, xi=0x30) public final class ListImplementation {
    public static final int $stable;
    public static final ListImplementation INSTANCE;

    static {
        ListImplementation.INSTANCE = new ListImplementation();
    }

    private ListImplementation() {
        super();
    }

    @JvmStatic public static final void checkElementIndex$runtime(int arg3, int arg4) {
        if(arg3 >= 0 && arg3 < arg4) {
            return;
        }

        throw new IndexOutOfBoundsException("index: " + arg3 + ", size: " + arg4);
    }

    @JvmStatic public static final void checkPositionIndex$runtime(int arg3, int arg4) {
        if(arg3 >= 0 && arg3 <= arg4) {
            return;
        }

        throw new IndexOutOfBoundsException("index: " + arg3 + ", size: " + arg4);
    }

    @JvmStatic public static final void checkRangeIndexes$runtime(int arg3, int arg4, int arg5) {
        String v0 = "fromIndex: ";
        if(arg3 >= 0 && arg4 <= arg5) {
            if(arg3 <= arg4) {
                return;
            }
            else {
                throw new IllegalArgumentException(v0 + arg3 + " > toIndex: " + arg4);
            }
        }

        throw new IndexOutOfBoundsException(v0 + arg3 + ", toIndex: " + arg4 + ", size: " + arg5);
    }

    @JvmStatic public static final boolean orderedEquals$runtime(Collection arg3, Collection arg4) {
        if(arg3.size() != arg4.size()) {
            return 0;
        }

        Iterator v4 = arg4.iterator();
        Iterator v3 = arg3.iterator();
        do {
            if(!v3.hasNext()) {
                return 1;
            }
        }
        while(Intrinsics.areEqual(v3.next(), v4.next()));

        return 0;
    }

    @JvmStatic public static final int orderedHashCode$runtime(Collection arg2) {
        Iterator v2 = arg2.iterator();
        int v0;
        for(v0 = 1; v2.hasNext(); v0 += v1_1) {
            Object v1 = v2.next();
            v0 *= 0x1F;
            int v1_1 = v1 != null ? v1.hashCode() : 0;
        }

        return v0;
    }
}

