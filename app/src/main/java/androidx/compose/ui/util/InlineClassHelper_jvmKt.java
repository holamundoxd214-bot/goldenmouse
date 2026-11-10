package androidx.compose.ui.util;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\u0010\t\n\u0002\b\u0002\u001A\u0011\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0086\b\u001A\u0011\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0002\u001A\u00020\u0006H\u0086\b\u001A\r\u0010\u0007\u001A\u00020\u0003*\u00020\u0001H\u0086\b\u001A\r\u0010\u0007\u001A\u00020\u0003*\u00020\u0005H\u0086\b¨\u0006\b"}, d2={"floatFromBits", "", "bits", "", "doubleFromBits", "", "", "fastRoundToInt", "ui-util"}, k=2, mv={2, 0, 0}, xi=0x30) public final class InlineClassHelper_jvmKt {
    public static final double doubleFromBits(long arg0) {
        return Double.longBitsToDouble(arg0);
    }

    public static final int fastRoundToInt(double arg0) {
        return ((int)Math.round(arg0));
    }

    public static final int fastRoundToInt(float arg0) {
        return Math.round(arg0);
    }

    public static final float floatFromBits(int arg0) {
        return Float.intBitsToFloat(arg0);
    }
}

