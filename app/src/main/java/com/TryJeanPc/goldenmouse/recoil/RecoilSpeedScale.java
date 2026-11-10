package com.TryJeanPc.goldenmouse.recoil;

import java.math.BigDecimal;
import kotlin.Metadata;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000B\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u0007J\u000E\u0010\r\u001A\u00020\u00052\u0006\u0010\f\u001A\u00020\u0007J\u000E\u0010\u000E\u001A\u00020\u00072\u0006\u0010\u000F\u001A\u00020\u0005J\u0016\u0010\u0010\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u00072\u0006\u0010\u0011\u001A\u00020\u0012R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2={"Lcom/TryJeanPc/goldenmouse/recoil/RecoilSpeedScale;", "", "<init>", "()V", "MAX_PROGRESS", "", "LOW_GAIN", "", "MAX_GAIN", "decimalStep", "Ljava/math/BigDecimal;", "toInternal", "value", "toProgress", "fromProgress", "progress", "adjustVertical", "increase", "", "app"}, k=1, mv={2, 2, 0}, xi=0x30) public final class RecoilSpeedScale {
    public static final int $stable = 0;
    public static final RecoilSpeedScale INSTANCE = null;
    private static final double LOW_GAIN = 5;
    private static final double MAX_GAIN = 20;
    public static final int MAX_PROGRESS = 1000;
    private static final BigDecimal decimalStep;

    static {
        RecoilSpeedScale.INSTANCE = new RecoilSpeedScale();
        RecoilSpeedScale.decimalStep = new BigDecimal("0.1");
        RecoilSpeedScale.$stable = 8;
    }

    private RecoilSpeedScale() {
        super();
    }

    public final double adjustVertical(double arg5, boolean arg7) {
        if(Math.abs(arg5) <= 1.797693E+308 && 0 <= arg5 && arg5 <= 100) {
            BigDecimal v4 = BigDecimal.valueOf(arg5);
            BigDecimal v5 = RecoilSpeedScale.decimalStep;
            if(arg7) {
            }
            else {
                v5 = v5.negate();
            }

            return RangesKt.coerceIn(v4.add(v5), BigDecimal.ZERO, BigDecimal.valueOf(100)).doubleValue();
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final double fromProgress(int arg3) {
        if(-1000 <= arg3 && arg3 < 1001) {
            return (((double)arg3)) / 10;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final double toInternal(double arg5) {
        if(Math.abs(arg5) <= 1.797693E+308 && -100 <= arg5) {
            double v0 = 100;
            if(arg5 <= v0) {
                double v2 = 0;
                if(arg5 == v2) {
                    return v2;
                }
                else {
                    v0 = arg5 / v0;
                    return arg5 * (15 * v0 * v0 + 5);
                }
            }
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    public final int toProgress(double arg5) {
        if(Math.abs(arg5) <= 1.797693E+308 && -100 <= arg5 && arg5 <= 100) {
            int v4 = MathKt.roundToInt(Math.abs(arg5) * 10);
            if(arg5 < 0) {
                v4 = -v4;
            }

            return v4;
        }

        throw new IllegalArgumentException("Failed requirement.".toString());
    }
}

