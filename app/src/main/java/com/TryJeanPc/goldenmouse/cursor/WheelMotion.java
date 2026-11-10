package com.TryJeanPc.goldenmouse.cursor;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u000B\u001A\u00020\fJ&\u0010\r\u001A\u00020\u00072\u0006\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u00102\u0006\u0010\u0011\u001A\u00020\u00072\u0006\u0010\u0012\u001A\u00020\nR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082\u000E¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u000E¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/cursor/WheelMotion;", "", "<init>", "()V", "remainder", "", "previousPercent", "", "previousDirection", "previousContext", "", "reset", "", "pixels", "ticks", "pixelsPerNotch", "", "percent", "context", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class WheelMotion {
    public static final int $stable = 8;
    private long previousContext;
    private int previousDirection;
    private int previousPercent;
    private double remainder;

    static {
    }

    public WheelMotion() {
        super();
        this.previousPercent = -1;
        this.previousContext = -9223372036854775808L;
    }

    public final int pixels(int arg5, float arg6, int arg7, long arg8) {
        if(arg5 == 0) {
            return 0;
        }

        arg7 = RangesKt.coerceIn(arg7, 0, 100);
        int v0 = Intrinsics.compare(arg5, 0);
        if(arg7 != this.previousPercent || arg8 != this.previousContext || v0 != 0 && v0 != this.previousDirection) {
            this.reset();
        }

        this.previousPercent = arg7;
        this.previousContext = arg8;
        this.previousDirection = v0;
        double v8 = 50;
        v0 = 50;
        double v2 = arg7 <= v0 ? (((double)arg7)) * 0.9 / v8 + 0.1 : (((double)(arg7 - v0))) / v8 + 1;
        double v7 = (((double)arg5)) * (((double)arg6)) * v2 + this.remainder;
        arg5 = ((int)(Math.signum(v7) * 1.000000E-09 + v7));
        v7 -= ((double)arg5);
        if(Math.abs(v7) < 1.000000E-09) {
            v7 = 0;
        }

        this.remainder = v7;
        return arg5;
    }

    public final void reset() {
        this.remainder = 0;
        this.previousPercent = -1;
        this.previousDirection = 0;
        this.previousContext = -9223372036854775808L;
    }
}

