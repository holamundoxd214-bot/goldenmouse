package androidx.compose.foundation.shape;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001A\u0017\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0007¢\u0006\u0004\b\u0004\u0010\u0005\u001A\u0010\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0006H\u0007\u001A\u0012\u0010\u0000\u001A\u00020\u00012\b\b\u0001\u0010\u0007\u001A\u00020\bH\u0007\"\u001C\u0010\t\u001A\u00020\u00018\u0006X\u0087\u0004¢\u0006\u000E\n\u0000\u0012\u0004\b\n\u0010\u000B\u001A\u0004\b\f\u0010\r¨\u0006\u000E"}, d2={"CornerSize", "Landroidx/compose/foundation/shape/CornerSize;", "size", "Landroidx/compose/ui/unit/Dp;", "CornerSize-0680j_4", "(F)Landroidx/compose/foundation/shape/CornerSize;", "", "percent", "", "ZeroCornerSize", "getZeroCornerSize$annotations", "()V", "getZeroCornerSize", "()Landroidx/compose/foundation/shape/CornerSize;", "foundation"}, k=2, mv={2, 0, 0}, xi=0x30) public final class CornerSizeKt {
    private static final CornerSize ZeroCornerSize;

    static {
        CornerSizeKt.ZeroCornerSize = new CornerSizeKt$ZeroCornerSize$1();
    }

    public static final CornerSize CornerSize(float arg1) {
        return new PxCornerSize(arg1);
    }

    public static final CornerSize CornerSize(int arg1) {
        return new PercentCornerSize(((float)arg1));
    }

    public static final CornerSize CornerSize-0680j_4(float arg2) {
        return new DpCornerSize(arg2, null);
    }

    public static final CornerSize getZeroCornerSize() {
        return CornerSizeKt.ZeroCornerSize;
    }

    public static void getZeroCornerSize$annotations() {
    }
}

