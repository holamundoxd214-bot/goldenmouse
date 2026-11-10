package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.CharsKt;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u001A\u0015\u0010\u0002\u001A\u00060\u0001j\u0002`\u0003*\u00060\u0001j\u0002`\u0003H\u0086\b\u001A\u0019\u0010\u0004\u001A\u00020\u0005*\u00060\u0001j\u0002`\u00032\u0006\u0010\u0006\u001A\u00020\u0007H\u0086\b\u001A\u0011\u0010\u0000\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u0007H\u0080\b\u001A!\u0010\t\u001A\u00020\u0001*\u00060\u0001j\u0002`\u00032\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0007H\u0080\b\u001A!\u0010\f\u001A\u00020\u0001*\u00060\u0001j\u0002`\u00032\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0007H\u0080\b\u001A!\u0010\r\u001A\u00020\u0001*\u00060\u0001j\u0002`\u00032\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u0007H\u0080\b\u001A%\u0010\r\u001A\u00020\u0001*\u00060\u0001j\u0002`\u00032\n\u0010\n\u001A\u00060\u0001j\u0002`\u00032\u0006\u0010\u000B\u001A\u00020\u0007H\u0080\b\"\u000E\u0010\u000E\u001A\u00020\u0007X\u0080T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000F\u001A\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000*\n\u0010\u0000\"\u00020\u00012\u00020\u0001¨\u0006\u0010"}, d2={"CompositeKeyHashCode", "", "toLong", "Landroidx/compose/runtime/CompositeKeyHashCode;", "toString", "", "radix", "", "initial", "compoundWith", "segment", "shift", "unCompoundWith", "bottomUpCompoundWith", "CompositeKeyHashSizeBits", "EmptyCompositeKeyHashCode", "runtime"}, k=2, mv={2, 1, 0}, xi=0x30) public final class CompositeKeyHashCode_jvmKt {
    public static final int CompositeKeyHashSizeBits = 0x40;
    public static final long EmptyCompositeKeyHashCode;

    public static final long CompositeKeyHashCode(int arg2) {
        return ((long)arg2);
    }

    public static final long bottomUpCompoundWith(long arg2, int arg4, int arg5) {
        return arg2 ^ Long.rotateLeft(((long)arg4), arg5);
    }

    public static final long bottomUpCompoundWith(long arg0, long arg2, int arg4) {
        return arg0 ^ Long.rotateLeft(arg2, arg4);
    }

    public static final long compoundWith(long arg0, int arg2, int arg3) {
        return Long.rotateLeft(arg0, arg3) ^ (((long)arg2));
    }

    public static final long toLong(long arg0) {
        return arg0;
    }

    public static final String toString(long arg0, int arg2) {
        String v0 = Long.toString(arg0, CharsKt.checkRadix(arg2));
        Intrinsics.checkNotNullExpressionValue(v0, "toString(...)");
        return v0;
    }

    public static final long unCompoundWith(long arg2, int arg4, int arg5) {
        return Long.rotateRight(arg2 ^ (((long)arg4)), arg5);
    }
}

