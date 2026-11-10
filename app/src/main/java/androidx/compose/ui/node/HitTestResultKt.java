package androidx.compose.ui.node;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\u001A\'\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\b\b\u0002\u0010\t\u001A\u00020\bH\u0002¢\u0006\u0002\u0010\n\"\u000E\u0010\u0000\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000E\u0010\u0002\u001A\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000B"}, d2={"IS_IN_LAYER", "", "IS_IN_EXPANDED_BOUNDS", "DistanceAndFlags", "Landroidx/compose/ui/node/DistanceAndFlags;", "distance", "", "isInLayer", "", "isInExpandedBounds", "(FZZ)J", "ui"}, k=2, mv={2, 0, 0}, xi=0x30) public final class HitTestResultKt {
    private static final long IS_IN_EXPANDED_BOUNDS = 2;
    private static final long IS_IN_LAYER = 1;

    private static final long DistanceAndFlags(float arg4, boolean arg5, boolean arg6) {
        long v0 = ((long)Float.floatToRawIntBits(arg4));
        long v2 = 0;
        long v4 = arg5 ? 1 : v2;
        if(arg6) {
            v2 = 2;
        }

        return DistanceAndFlags.constructor-impl((v4 | v2) & 0xFFFFFFFFL | v0 << 0x20);
    }

    static long DistanceAndFlags$default(float arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        return HitTestResultKt.DistanceAndFlags(arg0, arg1, false);
    }

    public static final long access$DistanceAndFlags(float arg0, boolean arg1, boolean arg2) {
        return HitTestResultKt.DistanceAndFlags(arg0, arg1, arg2);
    }
}

