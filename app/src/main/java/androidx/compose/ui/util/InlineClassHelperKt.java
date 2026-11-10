package androidx.compose.ui.util;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u0019\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0086\b\u001A\u0011\u0010\u0005\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0001H\u0086\b\u001A\u0011\u0010\u0007\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0001H\u0086\b\u001A\u0011\u0010\b\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0001H\u0086\b\u001A\u0011\u0010\t\u001A\u00020\u00032\u0006\u0010\u0006\u001A\u00020\u0001H\u0086\b\u001A\u0019\u0010\n\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u000BH\u0086\b\u001A\u0011\u0010\f\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u0001H\u0086\b\u001A\u0011\u0010\r\u001A\u00020\u000B2\u0006\u0010\u0006\u001A\u00020\u0001H\u0086\b¨\u0006\u000E"}, d2={"packFloats", "", "val1", "", "val2", "unpackFloat1", "value", "unpackAbsFloat1", "unpackFloat2", "unpackAbsFloat2", "packInts", "", "unpackInt1", "unpackInt2", "ui-util"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InlineClassHelperKt {
    public static final long packFloats(float arg4, float arg5) {
        return (((long)Float.floatToRawIntBits(arg5))) & 0xFFFFFFFFL | (((long)Float.floatToRawIntBits(arg4))) << 0x20;
    }

    public static final long packInts(int arg4, int arg5) {
        return (((long)arg5)) & 0xFFFFFFFFL | (((long)arg4)) << 0x20;
    }

    public static final float unpackAbsFloat1(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 >> 0x20 & 0x7FFFFFFF)));
    }

    public static final float unpackAbsFloat2(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0x7FFFFFFF)));
    }

    public static final float unpackFloat1(long arg1) {
        return Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }

    public static final float unpackFloat2(long arg2) {
        return Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    public static final int unpackInt1(long arg1) {
        return ((int)(arg1 >> 0x20));
    }

    public static final int unpackInt2(long arg2) {
        return ((int)(arg2 & 0xFFFFFFFFL));
    }
}

