package com.TryJeanPc.goldenmouse.ui;

import kotlin.Metadata;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\u00052\u0006\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\fR\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\r"}, d2={"Lcom/TryJeanPc/goldenmouse/ui/BlueMagicIndicatorSweep;", "", "<init>", "()V", "DURATION_MS", "", "progressAt", "", "elapsedMs", "start", "reading", "ram", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class BlueMagicIndicatorSweep {
    public static final int $stable = 0;
    public static final long DURATION_MS = 2600;
    public static final BlueMagicIndicatorSweep INSTANCE;

    static {
        BlueMagicIndicatorSweep.INSTANCE = new BlueMagicIndicatorSweep();
    }

    private BlueMagicIndicatorSweep() {
        super();
    }

    public final float progressAt(long arg8, float arg10, float arg11, boolean arg12) {
        long v7 = RangesKt.coerceAtLeast(arg8, 0);
        float v0 = 1f;
        arg11 = RangesKt.coerceIn(arg11, 0f, v0);
        long v1 = 1500;
        long v3 = arg12 ? 2000 : v1;
        if(v7 < 500) {
            return RangesKt.coerceIn(arg10, 0f, v0) * (v0 - BlueMagicModeAnimation.INSTANCE.easeOut$app((((float)v7)) / 500f));
        }

        long v5 = 900;
        if(v7 < v5) {
            return 0;
        }

        arg10 = 600f;
        if(Long.compare(v7, v1) < 0) {
            return BlueMagicModeAnimation.INSTANCE.easeOut$app((((float)(v7 - v5))) / arg10);
        }

        if(v7 < v3) {
            return v0;
        }

        if(v7 < 600 + v3) {
            arg11 = (arg11 - v0) * BlueMagicModeAnimation.INSTANCE.easeOut$app((((float)(v7 - v3))) / arg10) + v0;
        }

        return arg11;
    }
}

