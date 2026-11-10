package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\b\u001A\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00070\u0006\"\u0004\b\u0000\u0010\u0007H\u0000\u001A\u001F\u0010\b\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\n0\t2\b\u0010\u000B\u001A\u0004\u0018\u00010\nH\u0000¢\u0006\u0002\u0010\f\u001A\u0018\u0010\r\u001A\u00020\u00012\u0006\u0010\u000E\u001A\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0001H\u0000\u001A\u0010\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u0001H\u0000\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0003\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0004\u001A\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"MAX_BUFFER_SIZE", "", "LOG_MAX_BUFFER_SIZE", "MAX_BUFFER_SIZE_MINUS_ONE", "MUTABLE_BUFFER_SIZE", "persistentVectorOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentList;", "E", "presizedBufferWith", "", "", "element", "(Ljava/lang/Object;)[Ljava/lang/Object;", "indexSegment", "index", "shift", "rootSize", "vectorSize", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class UtilsKt {
    public static final int LOG_MAX_BUFFER_SIZE = 5;
    public static final int MAX_BUFFER_SIZE = 0x20;
    public static final int MAX_BUFFER_SIZE_MINUS_ONE = 0x1F;
    public static final int MUTABLE_BUFFER_SIZE = 33;

    public static final int indexSegment(int arg0, int arg1) {
        return arg0 >> arg1 & 0x1F;
    }

    public static final PersistentList persistentVectorOf() {
        return SmallPersistentVector.Companion.getEMPTY();
    }

    public static final Object[] presizedBufferWith(Object arg2) {
        Object[] v0 = new Object[0x20];
        v0[0] = arg2;
        return v0;
    }

    public static final int rootSize(int arg0) {
        return arg0 - 1 & 0xFFFFFFE0;
    }
}

