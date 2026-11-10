package kotlin.time;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000,\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u0006\n\u0000\u001A\u0012\u0010\t\u001A\u00020\u00072\u0006\u0010\n\u001A\u00020\u000BH\u0082\u0080\u0004\u001A\u001A\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\n\u001A\u00020\u000BH\u0080\u0080\u0004\"\u0015\u0010\u0000\u001A\u00020\u0001X\u0080\u0084\b¢\u0006\b\n\u0000\u001A\u0004\b\u0002\u0010\u0003\"\u001D\u0010\u0004\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\b¨\u0006\u0010"}, d2={"durationAssertionsEnabled", "", "getDurationAssertionsEnabled", "()Z", "precisionFormats", "", "Ljava/lang/ThreadLocal;", "Ljava/text/DecimalFormat;", "[Ljava/lang/ThreadLocal;", "createFormatForDecimals", "decimals", "", "formatToExactDecimals", "", "value", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class DurationJvmKt {
    private static final boolean durationAssertionsEnabled;
    private static final ThreadLocal[] precisionFormats;

    static {
        int v0 = 0;
        DurationJvmKt.durationAssertionsEnabled = false;
        int v1 = 4;
        ThreadLocal[] v2 = new ThreadLocal[v1];
        while(v0 < v1) {
            v2[v0] = new ThreadLocal();
            ++v0;
        }

        DurationJvmKt.precisionFormats = v2;
    }

    private static final DecimalFormat createFormatForDecimals(int arg2) {
        DecimalFormat v0 = new DecimalFormat("0");
        if(arg2 > 0) {
            v0.setMinimumFractionDigits(arg2);
        }

        v0.setRoundingMode(RoundingMode.HALF_UP);
        return v0;
    }

    public static final String formatToExactDecimals(double arg2, int arg4) {
        DecimalFormat v1_1;
        ThreadLocal[] v0 = DurationJvmKt.precisionFormats;
        if(arg4 < v0.length) {
            ThreadLocal v0_1 = v0[arg4];
            Object v1 = v0_1.get();
            if(v1 == null) {
                v1_1 = DurationJvmKt.createFormatForDecimals(arg4);
                v0_1.set(v1_1);
            }
        }
        else {
            v1_1 = DurationJvmKt.createFormatForDecimals(arg4);
        }

        String v2 = v1_1.format(arg2);
        Intrinsics.checkNotNullExpressionValue(v2, "format(...)");
        return v2;
    }

    public static final boolean getDurationAssertionsEnabled() {
        return DurationJvmKt.durationAssertionsEnabled;
    }
}

