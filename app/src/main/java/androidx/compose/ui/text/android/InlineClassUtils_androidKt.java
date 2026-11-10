package androidx.compose.ui.text.android;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\u001A\u0019\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0080\b\u001A\u0011\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0001H\u0080\b\u001A\u0011\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0001H\u0080\b¨\u0006\b"}, d2={"packInts", "", "val1", "", "val2", "unpackInt1", "value", "unpackInt2", "ui-text"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InlineClassUtils_androidKt {
    public static final long packInts(int arg4, int arg5) {
        return (((long)arg5)) & 0xFFFFFFFFL | (((long)arg4)) << 0x20;
    }

    public static final int unpackInt1(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public static final int unpackInt2(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }
}

