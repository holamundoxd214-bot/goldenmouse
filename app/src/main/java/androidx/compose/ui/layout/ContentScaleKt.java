package androidx.compose.ui.layout;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001A\u001F\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\u0005\u0010\u0006\u001A\u001F\u0010\u0007\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0002¢\u0006\u0004\b\b\u0010\u0006\u001A \u0010\t\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0082\b¢\u0006\u0004\b\n\u0010\u0006\u001A \u0010\u000B\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u0003H\u0082\b¢\u0006\u0004\b\f\u0010\u0006¨\u0006\r"}, d2={"computeFillMaxDimension", "", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeFillMaxDimension-iLBOSCw", "(JJ)F", "computeFillMinDimension", "computeFillMinDimension-iLBOSCw", "computeFillWidth", "computeFillWidth-iLBOSCw", "computeFillHeight", "computeFillHeight-iLBOSCw", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class ContentScaleKt {
    public static final float access$computeFillMaxDimension-iLBOSCw(long arg0, long arg2) {
        return ContentScaleKt.computeFillMaxDimension-iLBOSCw(arg0, arg2);
    }

    public static final float access$computeFillMinDimension-iLBOSCw(long arg0, long arg2) {
        return ContentScaleKt.computeFillMinDimension-iLBOSCw(arg0, arg2);
    }

    private static final float computeFillHeight-iLBOSCw(long arg2, long arg4) {
        return Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(arg2 & 0xFFFFFFFFL)));
    }

    private static final float computeFillMaxDimension-iLBOSCw(long arg4, long arg6) {
        return Math.max(Float.intBitsToFloat(((int)(arg6 >> 0x20))) / Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))));
    }

    private static final float computeFillMinDimension-iLBOSCw(long arg4, long arg6) {
        return Math.min(Float.intBitsToFloat(((int)(arg6 >> 0x20))) / Float.intBitsToFloat(((int)(arg4 >> 0x20))), Float.intBitsToFloat(((int)(arg6 & 0xFFFFFFFFL))) / Float.intBitsToFloat(((int)(arg4 & 0xFFFFFFFFL))));
    }

    private static final float computeFillWidth-iLBOSCw(long arg1, long arg3) {
        return Float.intBitsToFloat(((int)(arg3 >> 0x20))) / Float.intBitsToFloat(((int)(arg1 >> 0x20)));
    }
}

