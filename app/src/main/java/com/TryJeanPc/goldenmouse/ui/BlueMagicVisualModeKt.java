package com.TryJeanPc.goldenmouse.ui;

import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\u001A \u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0005H\u0000¨\u0006\u0006"}, d2={"blendBlueMagicColor", "", "from", "to", "fraction", "", "app"}, k=2, mv={2, 2, 0}, xi=0x30) public final class BlueMagicVisualModeKt {
    public static final int blendBlueMagicColor(int arg3, int arg4, float arg5) {
        arg5 = RangesKt.coerceIn(arg5, 0f, 1f);
        return BlueMagicVisualModeKt.blendBlueMagicColor$channel(arg3, arg4, arg5, 0) | (BlueMagicVisualModeKt.blendBlueMagicColor$channel(arg3, arg4, arg5, 24) << 24 | BlueMagicVisualModeKt.blendBlueMagicColor$channel(arg3, arg4, arg5, 16) << 16 | BlueMagicVisualModeKt.blendBlueMagicColor$channel(arg3, arg4, arg5, 8) << 8);
    }

    private static final int blendBlueMagicColor$channel(int arg0, int arg1, float arg2, int arg3) {
        arg0 = arg0 >>> arg3 & 0xFF;
        return MathKt.roundToInt((((float)arg0)) + (((float)((arg1 >>> arg3 & 0xFF) - arg0))) * arg2);
    }
}

