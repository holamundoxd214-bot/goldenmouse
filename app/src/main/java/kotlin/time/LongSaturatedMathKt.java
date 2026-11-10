package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001E\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000B\n\u0000\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0080\u0080\u0004¢\u0006\u0004\b\u0007\u0010\b\u001A)\u0010\t\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\n\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0004\b\u000B\u0010\f\u001A)\u0010\r\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0005\u001A\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0004\b\u000E\u0010\b\u001A\u0017\u0010\u000F\u001A\u00020\u00062\u0006\u0010\u0002\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0010\u001A\'\u0010\u0011\u001A\u00020\u00062\u0006\u0010\u0012\u001A\u00020\u00012\u0006\u0010\u0013\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001A\'\u0010\u0015\u001A\u00020\u00062\u0006\u0010\u0016\u001A\u00020\u00012\u0006\u0010\u0017\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001A\'\u0010\u0018\u001A\u00020\u00062\u0006\u0010\u0019\u001A\u00020\u00012\u0006\u0010\u001A\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0014\u001A\u000E\u0010\u001B\u001A\u00020\u001C*\u00020\u0001H\u0080\u0088\u0004¨\u0006\u001D"}, d2={"saturatingAdd", "", "value", "unit", "Lkotlin/time/DurationUnit;", "duration", "Lkotlin/time/Duration;", "saturatingAdd-NuflL3o", "(JLkotlin/time/DurationUnit;J)J", "checkInfiniteSumDefined", "durationInUnit", "checkInfiniteSumDefined-PjuGub4", "(JJJ)J", "saturatingAddInHalves", "saturatingAddInHalves-NuflL3o", "infinityOfSign", "(J)J", "saturatingDiff", "valueNs", "origin", "(JJLkotlin/time/DurationUnit;)J", "saturatingOriginsDiff", "origin1", "origin2", "saturatingFiniteDiff", "value1", "value2", "isSaturated", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class LongSaturatedMathKt {
    private static final long checkInfiniteSumDefined-PjuGub4(long arg0, long arg2, long arg4) {
        if(Duration.isInfinite-impl(arg2)) {
            if((arg0 ^ arg4) >= 0) {
            }
            else {
                throw new IllegalArgumentException("Summing infinities of different signs");
            }
        }

        return arg0;
    }

    private static final long infinityOfSign(long arg2) {
        if(arg2 < 0) {
            return Duration.Companion.getNEG_INFINITE-UwyO8pc$kotlin_stdlib();
        }

        return Duration.Companion.getINFINITE-UwyO8pc();
    }

    public static final boolean isSaturated(long arg2) {
        if((arg2 - 1 | 1) == 0x7FFFFFFFFFFFFFFFL) {
            return 1;
        }

        return 0;
    }

    public static final long saturatingAdd-NuflL3o(long arg11, DurationUnit arg13, long arg14) {
        Intrinsics.checkNotNullParameter(arg13, "unit");
        long v5 = Duration.toLong-impl(arg14, arg13);
        long v7 = 1;
        long v9 = 0x7FFFFFFFFFFFFFFFL;
        if((arg11 - v7 | v7) == v9) {
            return LongSaturatedMathKt.checkInfiniteSumDefined-PjuGub4(arg11, arg14, v5);
        }

        long v1 = arg11;
        long v3 = arg14;
        if((v5 - v7 | v7) == v9) {
            return LongSaturatedMathKt.saturatingAddInHalves-NuflL3o(v1, arg13, v3);
        }

        arg11 = v1 + v5;
        v3 = 0;
        if(((v1 ^ arg11) & (v5 ^ arg11)) < v3) {
            if(v1 < v3) {
                return -9223372036854775808L;
            }

            return v9;
        }

        return arg11;
    }

    private static final long saturatingAddInHalves-NuflL3o(long arg8, DurationUnit arg10, long arg11) {
        long v0 = Duration.div-UwyO8pc(arg11, 2);
        long v2 = Duration.toLong-impl(v0, arg10);
        if((1 | v2 - 1) == 0x7FFFFFFFFFFFFFFFL) {
            return v2;
        }

        return LongSaturatedMathKt.saturatingAdd-NuflL3o(LongSaturatedMathKt.saturatingAdd-NuflL3o(arg8, arg10, v0), arg10, Duration.minus-LRDsOJo(arg11, v0));
    }

    public static final long saturatingDiff(long arg4, long arg6, DurationUnit arg8) {
        Intrinsics.checkNotNullParameter(arg8, "unit");
        if((1 | arg6 - 1) == 0x7FFFFFFFFFFFFFFFL) {
            return Duration.unaryMinus-UwyO8pc(LongSaturatedMathKt.infinityOfSign(arg6));
        }

        return LongSaturatedMathKt.saturatingFiniteDiff(arg4, arg6, arg8);
    }

    private static final long saturatingFiniteDiff(long arg6, long arg8, DurationUnit arg10) {
        long v0 = arg6 - arg8;
        if(((v0 ^ arg6) & ~(v0 ^ arg8)) < 0) {
            if(arg10.compareTo(DurationUnit.MILLISECONDS) < 0) {
                v0 = DurationUnitKt.convertDurationUnit(1, DurationUnit.MILLISECONDS, arg10);
                return Duration.plus-LRDsOJo(DurationKt.toDuration(arg6 / v0 - arg8 / v0, DurationUnit.MILLISECONDS), DurationKt.toDuration(arg6 % v0 - arg8 % v0, arg10));
            }

            return Duration.unaryMinus-UwyO8pc(LongSaturatedMathKt.infinityOfSign(v0));
        }

        return DurationKt.toDuration(v0, arg10);
    }

    public static final long saturatingOriginsDiff(long arg6, long arg8, DurationUnit arg10) {
        Intrinsics.checkNotNullParameter(arg10, "unit");
        long v0 = 1;
        long v4 = 0x7FFFFFFFFFFFFFFFL;
        if((arg8 - v0 | v0) == v4) {
            if(arg6 == arg8) {
                return Duration.Companion.getZERO-UwyO8pc();
            }

            return Duration.unaryMinus-UwyO8pc(LongSaturatedMathKt.infinityOfSign(arg8));
        }

        if((v0 | arg6 - v0) == v4) {
            return LongSaturatedMathKt.infinityOfSign(arg6);
        }

        return LongSaturatedMathKt.saturatingFiniteDiff(arg6, arg8, arg10);
    }
}

