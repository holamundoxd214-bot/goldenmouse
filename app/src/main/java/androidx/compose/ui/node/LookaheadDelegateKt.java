package androidx.compose.ui.node;

import androidx.compose.ui.internal.InlineClassHelperKt;
import kotlin.Metadata;

@Metadata(d1={"\u0000\u001A\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0004\u001A\u0019\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0001H\u0080\b\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0007\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\t\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\n\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u000B\u001A\u00020\bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2={"MaxLayoutDimension", "", "MaxLayoutMask", "checkMeasuredSize", "", "width", "height", "AccessNoChange", "", "AccessChanged", "AccessNotSet", "AccessNewValue", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class LookaheadDelegateKt {
    private static final byte AccessChanged = 1;
    private static final byte AccessNewValue = 3;
    private static final byte AccessNoChange = 0;
    private static final byte AccessNotSet = 2;
    private static final int MaxLayoutDimension = 0xFFFFFF;
    private static final int MaxLayoutMask = 0xFF000000;

    public static final void checkMeasuredSize(int arg2, int arg3) {
        int v0 = 0xFF000000;
        v0 = (arg2 & v0) != 0 || (v0 & arg3) != 0 ? 0 : 1;
        if(v0 == 0) {
            InlineClassHelperKt.throwIllegalStateException("Size(" + arg2 + " x " + arg3 + ") is out of range. Each dimension must be between 0 and 16777215.");
        }
    }
}

