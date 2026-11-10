package com.TryJeanPc.goldenmouse.cursor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\t\u001A\u00020\nJ&\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000E2\u0006\u0010\u000F\u001A\u00020\u000E2\u0006\u0010\u0010\u001A\u00020\u00052\u0006\u0010\u0011\u001A\u00020\bR\u0012\u0010\u0004\u001A\u0004\u0018\u00010\u0005X\u0082\u000E¢\u0006\u0004\n\u0002\u0010\u0006R\u0010\u0010\u0007\u001A\u0004\u0018\u00010\bX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/CursorMotion;", "", "<init>", "()V", "lastTimestampNanos", "", "Ljava/lang/Long;", "lastOptions", "Lcom/TryJeanPc/goldenmouse/cursor/CursorMotionSettings$Options;", "reset", "", "gain", "", "dx", "", "dy", "timestampNanos", "options", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class CursorMotion {
    public static final int $stable = 8;
    private Options lastOptions;
    private Long lastTimestampNanos;

    static {
    }

    public CursorMotion() {
        super();
    }

    public final float gain(int arg8, int arg9, long arg10, Options arg12) {
        float v0_1;
        Intrinsics.checkNotNullParameter(arg12, "options");
        if(!Intrinsics.areEqual(arg12, this.lastOptions)) {
            this.reset();
        }

        this.lastOptions = arg12;
        int v0 = RangesKt.coerceIn(arg12.getSpeedPercent(), 0, 100);
        float v1 = 50f;
        int v2 = 50;
        if(v0 <= v2) {
            v0_1 = (((float)v0)) * 0.9f / v1;
            v1 = 0.1f;
        }
        else {
            v0_1 = (((float)(v0 - v2))) / v1;
            v1 = 1f;
        }

        v0_1 += v1;
        if(arg8 != 0 || arg9 != 0) {
            Long v1_1 = this.lastTimestampNanos;
            this.lastTimestampNanos = Long.valueOf(arg10);
            if(arg12.getAcceleration()) {
                if(v1_1 == null) {
                }
                else {
                    arg10 -= v1_1.longValue();
                    if(arg10 > 0) {
                        if(arg10 > 100000000) {
                        }
                        else {
                            double v7 = RangesKt.coerceIn((Math.hypot(((double)arg8), ((double)arg9)) / ((((double)RangesKt.coerceAtLeast(arg10, 1000000))) / 1000000000) - 300) / 2700, 0, 1);
                            v0_1 *= ((float)(v7 * v7 * (3 - v7 * 2) + 1));
                        }
                    }
                }
            }
        }
        else {
        }

        return v0_1;
    }

    public final void reset() {
        this.lastTimestampNanos = null;
        this.lastOptions = null;
    }
}

