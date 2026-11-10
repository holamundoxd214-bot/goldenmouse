package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;

@Metadata(d1={"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0005\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0007\u001A\u001B\u0010\u0000\u001A\u00020\u0001*\u00020\b2\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0080\u0004¢\u0006\u0002\u0010\t\u001A\u001D\u0010\n\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u000B\u001A\u00020\u0001H\u0087\u008A\u0004¢\u0006\u0004\b\f\u0010\r\u001A\u001D\u0010\n\u001A\u00020\u0001*\u00020\b2\u0006\u0010\u000B\u001A\u00020\u0001H\u0087\u008A\u0004¢\u0006\u0004\b\u000E\u0010\u000F\u001A)\u0010\u0010\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0013\u001A\u00020\u00142\b\b\u0002\u0010\u0015\u001A\u00020\u0014H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0016\u001A\'\u0010\u0017\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u00022\u0006\u0010\u0015\u001A\u00020\u0014H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0019\u001A/\u0010\u001A\u001A\u00020\u00012\u0006\u0010\u0011\u001A\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u00022\u0006\u0010\u001B\u001A\u00020\u00142\u0006\u0010\u0015\u001A\u00020\u0014H\u0082\u0080\u0004¢\u0006\u0002\u0010\u001C\u001A\u0016\u0010\u001D\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u001E\u001A\u00020\u0006H\u0082\u0080\u0004\u001A\u000E\u0010\u001F\u001A\u00020\u0014*\u00020\u0006H\u0083\u0088\u0004\u001A\u000E\u0010 \u001A\u00020\u0014*\u00020\u0006H\u0083\u0088\u0004\u001A\u001A\u0010!\u001A\u00020\u00142\u0006\u0010\"\u001A\u00020\u00062\u0006\u0010#\u001A\u00020\u0006H\u0083\u0088\u0004\u001A&\u0010$\u001A\u00020\u0006*\u00020\u00122\u0006\u0010\u0018\u001A\u00020\u00022\u0006\u0010%\u001A\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0082\u0080\u0004\u001A\u0016\u0010&\u001A\u00020\u0006*\u00020\u00062\u0006\u0010\u0003\u001A\u00020\u0004H\u0082\u0080\u0004\u001A!\u0010\'\u001A\u00020\u00012\u0006\u0010\u0015\u001A\u00020\u00142\b\b\u0002\u0010(\u001A\u00020\u0012H\u0083\u0088\u0004¢\u0006\u0002\u0010)\u001A\'\u0010*\u001A\u0004\u0018\u00010\u0001*\u00020\u00012\u000E\u0010+\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010,H\u0082\u0088\u0004¢\u0006\u0004\b-\u0010.\u001A\u0018\u0010/\u001A\u0004\u0018\u00010\u0004*\u00020\u00122\u0006\u00100\u001A\u00020\u0002H\u0082\u0080\u0004\u001A\u0018\u00101\u001A\u0004\u0018\u00010\u0004*\u00020\u00122\u0006\u00100\u001A\u00020\u0002H\u0082\u0080\u0004\u001A\u000E\u0010=\u001A\u00020\u0006*\u00020\u0006H\u0083\u0088\u0004\u001A\u000E\u0010=\u001A\u00020\u0002*\u00020\u0002H\u0083\u0088\u0004\u001A\u0012\u0010J\u001A\u00020\u00062\u0006\u0010K\u001A\u00020\u0006H\u0082\u0080\u0004\u001A\u0012\u0010L\u001A\u00020\u00062\u0006\u0010M\u001A\u00020\u0006H\u0082\u0080\u0004\u001A\u0017\u0010N\u001A\u00020\u00012\u0006\u0010O\u001A\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0002\u0010P\u001A\u0017\u0010Q\u001A\u00020\u00012\u0006\u0010R\u001A\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0002\u0010P\u001A\u001F\u0010S\u001A\u00020\u00012\u0006\u0010T\u001A\u00020\u00062\u0006\u0010U\u001A\u00020\u0002H\u0082\u0080\u0004¢\u0006\u0002\u0010V\u001A\u0017\u0010W\u001A\u00020\u00012\u0006\u0010K\u001A\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0002\u0010P\u001A\u0017\u0010X\u001A\u00020\u00012\u0006\u0010M\u001A\u00020\u0006H\u0082\u0080\u0004¢\u0006\u0002\u0010P\"\u001F\u00102\u001A\u00020\b*\u00020\u00048BX\u0082\u0084\b¢\u0006\f\u0012\u0004\b3\u00104\u001A\u0004\b5\u00106\"\u0019\u00107\u001A\u00020\u0006*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b8\u00109\"\u0019\u0010:\u001A\u00020\u0002*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b;\u0010<\"\u000F\u0010>\u001A\u00020\u0002X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010?\u001A\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010@\u001A\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010A\u001A\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010B\u001A\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010C\u001A\u00020\u0006X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010D\u001A\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010E\u001A\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010F\u001A\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010G\u001A\u00020\u0006X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010H\u001A\u00020\u0012X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000F\u0010I\u001A\u00020\u0002X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006Y"}, d2={"toDuration", "Lkotlin/time/Duration;", "", "unit", "Lkotlin/time/DurationUnit;", "(ILkotlin/time/DurationUnit;)J", "", "(JLkotlin/time/DurationUnit;)J", "", "(DLkotlin/time/DurationUnit;)J", "times", "duration", "times-mvk6XK0", "(IJ)J", "times-kIfJnKk", "(DJ)J", "parseDuration", "value", "", "strictIso", "", "throwException", "(Ljava/lang/String;ZZ)J", "parseIsoStringFormat", "startIndex", "(Ljava/lang/String;IZ)J", "parseDefaultStringFormat", "hasSign", "(Ljava/lang/String;IZZ)J", "addMillisWithoutOverflow", "other", "isInfiniteMillis", "isFiniteMillis", "sameSign", "a", "b", "parseFractionFallback", "endIndex", "fractionDigitsToNanos", "handleError", "message", "(ZLjava/lang/String;)J", "onInvalid", "block", "Lkotlin/Function0;", "onInvalid-ge6A_vg", "(JLkotlin/jvm/functions/Function0;)Lkotlin/time/Duration;", "defaultDurationUnitByShortNameOrNull", "start", "isoDurationUnitByShortNameOrNull", "fractionMultiplier", "getFractionMultiplier$annotations", "(Lkotlin/time/DurationUnit;)V", "getFractionMultiplier", "(Lkotlin/time/DurationUnit;)D", "fallbackFractionMultiplier", "getFallbackFractionMultiplier", "(Lkotlin/time/DurationUnit;)J", "shortNameLength", "getShortNameLength", "(Lkotlin/time/DurationUnit;)I", "multiplyBy10", "NANOS_IN_MILLIS", "MICROS_IN_MILLIS", "NANOS_IN_MICROS", "MAX_NANOS", "MAX_MILLIS", "MAX_NANOS_IN_MILLIS", "MILLIS_IN_SECOND", "MILLIS_IN_MINUTE", "MILLIS_IN_HOUR", "MILLIS_IN_DAY", "INFINITY_STRING", "FRACTION_LIMIT", "nanosToMillis", "nanos", "millisToNanos", "millis", "durationOfNanos", "normalNanos", "(J)J", "durationOfMillis", "normalMillis", "durationOf", "normalValue", "unitDiscriminator", "(JI)J", "durationOfNanosNormalized", "durationOfMillisNormalized", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class DurationKt {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[DurationUnit.values().length];
            try {
                v0[DurationUnit.MICROSECONDS.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[DurationUnit.NANOSECONDS.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[DurationUnit.MILLISECONDS.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[DurationUnit.SECONDS.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[DurationUnit.MINUTES.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[DurationUnit.HOURS.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[DurationUnit.DAYS.ordinal()] = 7;
                                        goto label_31;
                                    }
                                    catch(NoSuchFieldError ) {
                                    label_31:
                                        WhenMappings.$EnumSwitchMapping$0 = v0;
                                        return;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final int FRACTION_LIMIT = 15;
    private static final String INFINITY_STRING = "Infinity";
    public static final long MAX_MILLIS = 0x3FFFFFFFFFFFFFFFL;
    public static final long MAX_NANOS = 0x3FFFFFFFFFFA14BFL;
    private static final long MAX_NANOS_IN_MILLIS = 4611686018426L;
    public static final long MICROS_IN_MILLIS = 1000;
    public static final long MILLIS_IN_DAY = 86400000;
    public static final long MILLIS_IN_HOUR = 3600000;
    public static final long MILLIS_IN_MINUTE = 60000;
    public static final long MILLIS_IN_SECOND = 1000;
    public static final long NANOS_IN_MICROS = 1000;
    public static final int NANOS_IN_MILLIS = 1000000;

    public static final long access$addMillisWithoutOverflow(long arg0, long arg2) {
        return DurationKt.addMillisWithoutOverflow(arg0, arg2);
    }

    public static final long access$durationOf(long arg0, int arg2) {
        return DurationKt.durationOf(arg0, arg2);
    }

    public static final long access$durationOfMillis(long arg0) {
        return DurationKt.durationOfMillis(arg0);
    }

    public static final long access$durationOfMillisNormalized(long arg0) {
        return DurationKt.durationOfMillisNormalized(arg0);
    }

    public static final long access$durationOfNanos(long arg0) {
        return DurationKt.durationOfNanos(arg0);
    }

    public static final long access$durationOfNanosNormalized(long arg0) {
        return DurationKt.durationOfNanosNormalized(arg0);
    }

    public static final long access$millisToNanos(long arg0) {
        return DurationKt.millisToNanos(arg0);
    }

    public static final long access$nanosToMillis(long arg0) {
        return DurationKt.nanosToMillis(arg0);
    }

    public static final long access$parseDuration(String arg0, boolean arg1, boolean arg2) {
        return DurationKt.parseDuration(arg0, arg1, arg2);
    }

    private static final long addMillisWithoutOverflow(long arg7, long arg9) {
        long v0 = 0x3FFFFFFFFFFFFFFFL;
        long v3 = -4611686018427387903L;
        if(Long.compare(arg7, v0) != 0) {
            if(arg7 == v3) {
            }
            else {
                if(arg9 != v0) {
                    if(arg9 == v3) {
                    }
                    else {
                        return RangesKt.coerceIn(arg7 + arg9, -4611686018427387903L, 0x3FFFFFFFFFFFFFFFL);
                    }
                }

                return arg9;
            }
        }

        if(v3 < arg9 && arg9 < v0) {
            return arg7;
        }

        if((arg9 ^ arg7) >= 0) {
            return arg7;
        }

        return 0x7FFFFFFFFFFFC0DEL;
    }

    private static final DurationUnit defaultDurationUnitByShortNameOrNull(String arg3, int arg4) {
        int v0 = arg3.charAt(arg4);
        int v3 = arg4 < StringsKt.getLastIndex(arg3) ? arg3.charAt(arg4 + 1) : 0;
        if(v0 != 100) {
            if(v0 != 104) {
                arg4 = 0x73;
                if(v0 != arg4) {
                    DurationUnit v2 = null;
                    if(v0 != 0x75) {
                        if(v0 != 109) {
                            if(v0 != 110) {
                                return v2;
                            }

                            if(v3 == arg4) {
                                return DurationUnit.NANOSECONDS;
                            }

                            return v2;
                        }

                        if(v3 == arg4) {
                            return DurationUnit.MILLISECONDS;
                        }

                        return DurationUnit.MINUTES;
                    }

                    if(v3 == arg4) {
                        return DurationUnit.MICROSECONDS;
                    }

                    return v2;
                }

                return DurationUnit.SECONDS;
            }

            return DurationUnit.HOURS;
        }

        return DurationUnit.DAYS;
    }

    private static final long durationOf(long arg3, int arg5) {
        return Duration.Companion.fromRawValue-UwyO8pc$kotlin_stdlib((arg3 << 1) + (((long)arg5)));
    }

    private static final long durationOfMillis(long arg3) {
        return Duration.Companion.fromRawValue-UwyO8pc$kotlin_stdlib((arg3 << 1) + 1);
    }

    private static final long durationOfMillisNormalized(long arg6) {
        if(-4611686018426L <= arg6 && arg6 < 4611686018427L) {
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(arg6));
        }

        return DurationKt.durationOfMillis(RangesKt.coerceIn(arg6, -4611686018427387903L, 0x3FFFFFFFFFFFFFFFL));
    }

    private static final long durationOfNanos(long arg2) {
        return Duration.Companion.fromRawValue-UwyO8pc$kotlin_stdlib(arg2 << 1);
    }

    private static final long durationOfNanosNormalized(long arg2) {
        if(-4611686018426999999L <= arg2 && arg2 < 0x3FFFFFFFFFFA14C0L) {
            return DurationKt.durationOfNanos(arg2);
        }

        return DurationKt.durationOfMillis(DurationKt.nanosToMillis(arg2));
    }

    private static final long fractionDigitsToNanos(long arg2, DurationUnit arg4) {
        return MathKt.roundToLong((((double)arg2)) * DurationKt.getFractionMultiplier(arg4));
    }

    private static final long getFallbackFractionMultiplier(DurationUnit arg3) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
        if(v0 != 5) {
            if(v0 != 6) {
                if(v0 == 7) {
                    return 86400000000000L;
                }

                throw new IllegalStateException("Invalid unit: " + arg3 + " for fallback fraction multiplier".toString());
            }

            return 3600000000000L;
        }

        return 60000000000L;
    }

    private static final double getFractionMultiplier(DurationUnit arg3) {
        switch(WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()]) {
            case 1: {
                return 1.000000E-12;
            }
            case 2: {
                return 1.000000E-15;
            }
            case 3: {
                return 1.000000E-09;
            }
            case 4: {
                return 0.000001;
            }
            case 5: {
                return 0.00006;
            }
            case 6: {
                return 0.0036;
            }
            case 7: {
                return 0.0864;
            }
        }

        throw new IllegalStateException("Unknown unit: " + arg3.toString());
        return 0.00006;
    }

    private static void getFractionMultiplier$annotations(DurationUnit arg0) {
    }

    private static final int getShortNameLength(DurationUnit arg3) {
        int v3 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
        int v0 = 2;
        if(v3 != 1 && v3 != v0 && v3 != 3) {
            return 1;
        }

        return v0;
    }

    private static final long handleError(boolean arg0, String arg1) {
        if(!arg0) {
            return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
        }

        throw new IllegalArgumentException(arg1);
    }

    static long handleError$default(boolean arg0, String arg1, int arg2, Object arg3) {
        if((arg2 & 2) != 0) {
            arg1 = "";
        }

        if(!arg0) {
            return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
        }

        throw new IllegalArgumentException(arg1);
    }

    private static final boolean isFiniteMillis(long arg2) {
        if(-4611686018427387903L < arg2 && arg2 < 0x3FFFFFFFFFFFFFFFL) {
            return 1;
        }

        return 0;
    }

    private static final boolean isInfiniteMillis(long arg2) {
        if(arg2 != 0x3FFFFFFFFFFFFFFFL) {
            if(arg2 == -4611686018427387903L) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final DurationUnit isoDurationUnitByShortNameOrNull(String arg0, int arg1) {
        int v0 = arg0.charAt(arg1);
        if(v0 != 68) {
            if(v0 != 72) {
                if(v0 != 77) {
                    if(v0 != 83) {
                        return null;
                    }

                    return DurationUnit.SECONDS;
                }

                return DurationUnit.MINUTES;
            }

            return DurationUnit.HOURS;
        }

        return DurationUnit.DAYS;
    }

    private static final long millisToNanos(long arg2) {
        return arg2 * 1000000;
    }

    private static final int multiplyBy10(int arg1) {
        return (arg1 << 3) + (arg1 << 1);
    }

    private static final long multiplyBy10(long arg3) {
        return (arg3 << 3) + (arg3 << 1);
    }

    private static final long nanosToMillis(long arg2) {
        return arg2 / 1000000;
    }

    private static final Duration onInvalid-ge6A_vg(long arg2, Function0 arg4) {
        if(Duration.equals-impl0(arg2, Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib())) {
            return arg4.invoke();
        }

        return Duration.box-impl(arg2);
    }

    private static final long parseDefaultStringFormat(String arg25, int arg26, boolean arg27, boolean arg28) {
        int v24;
        long v2_1;
        int v22;
        int v11;
        int v10_1;
        long v19;
        int v18;
        int v14;
        String v3;
        int v15;
        int v13;
        int v4;
        String v0 = arg25;
        int v1 = v0.length();
        int v2 = (((int)arg27)) ^ 1;
        if(!arg27 || arg25.charAt(arg26) != 40 || v0.charAt(v1 - 1) != 41) {
            v4 = v2;
            v2 = arg26;
        }
        else {
            v2 = arg26 + 1;
            --v1;
            if(v2 != v1) {
                v4 = 1;
            }
            else if(!arg28) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }
            else {
                throw new IllegalArgumentException("No components");
            }
        }

        DurationUnit v7 = null;
        long v8 = 0;
        long v10 = 0;
        int v12;
        for(v12 = 1; true; v12 = 0) {
        label_30:
            if(v2 >= v1) {
                goto label_307;
            }

            if(v12 == 0 && v4 != 0) {
                while(v2 < v0.length()) {
                    if(v0.charAt(v2) != 0x20) {
                        break;
                    }

                    ++v2;
                }
            }

            LongParser v12_1 = LongParser.Companion.getDefault();
            if(LongParser.access$getAllowSign$p(v12_1)) {
                v13 = v0.charAt(v2);
                if(v13 != 43 && v13 != 45) {
                    goto label_52;
                }

                v13 = v2 + 1;
            }
            else {
            label_52:
                v13 = v2;
            }

            while(true) {
                v15 = 0x30;
                if(v13 < v0.length() && v0.charAt(v13) == v15) {
                    ++v13;
                    continue;
                }

                break;
            }

            long v5 = 0;
            while(true) {
                v3 = "";
                v15 = 58;
                if(v13 < v0.length()) {
                    v14 = v0.charAt(v13);
                    v18 = v4;
                    if(0x30 <= v14 && v14 < v15) {
                        v14 += 0xFFFFFFD0;
                        if(v5 <= LongParser.access$getOverflowThreshold$p(v12_1)) {
                            v19 = v10;
                            if(Long.compare(v5, LongParser.access$getOverflowThreshold$p(v12_1)) == 0 && (((long)v14)) > LongParser.access$getLastDigitMax$p(v12_1)) {
                                goto label_93;
                            }

                            v5 = (((long)v14)) + ((v5 << 3) + (v5 << 1));
                            ++v13;
                            v4 = v18;
                            v10 = v19;
                            continue;
                        }

                        goto label_93;
                    }
                }
                else {
                    break;
                }

                goto label_109;
            }

            v18 = v4;
        label_109:
            v19 = v10;
            if(v13 != v2 && v13 != v1) {
                v2 = v0.charAt(v13) == 46 ? 1 : 0;
                if(v2 != 0) {
                    v4 = v13 + 1;
                    v10_1 = Math.min(v13 + 7, v0.length());
                    v11 = v4;
                    v14 = 0;
                    goto label_126;
                }
                else {
                    v22 = v2;
                    v4 = -1;
                    v2_1 = 0;
                }

                goto label_211;
            }

            if(!arg28) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }
            else {
                throw new IllegalArgumentException(v3);
                while(true) {
                label_126:
                    if(v11 < v10_1) {
                        v12 = v0.charAt(v11);
                        v22 = v2;
                        if(0x30 <= v12 && v12 < v15) {
                            v14 = (v14 << 3) + (v14 << 1) + (v12 - 0x30);
                            ++v11;
                            v2 = v22;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_141;
                }

                v22 = v2;
            label_141:
                v2 = 6 - (v11 - v4);
                for(v10_1 = 0; v10_1 < v2; ++v10_1) {
                    v14 = (v14 << 1) + (v14 << 3);
                }

                v2 = Math.min(v11 + 9, v0.length());
                v10_1 = v11;
                v12 = 0;
                while(true) {
                    if(v10_1 < v2) {
                        int v23 = v2;
                        v2 = v0.charAt(v10_1);
                        v24 = v10_1;
                        if(0x30 <= v2 && v2 < v15) {
                            v12 = (v12 << 3) + (v12 << 1) + (v2 - 0x30);
                            v10_1 = v24 + 1;
                            v2 = v23;
                            continue;
                        }
                    }
                    else {
                        break;
                    }

                    goto label_171;
                }

                v24 = v10_1;
            label_171:
                v2 = 9 - (v24 - v11);
                for(v10_1 = 0; v10_1 < v2; ++v10_1) {
                    v12 = (v12 << 1) + (v12 << 3);
                }

                for(v10_1 = v24; v10_1 < v0.length(); ++v10_1) {
                    v2 = v0.charAt(v10_1);
                    if(0x30 > v2) {
                        break;
                    }

                    if(v2 >= v15) {
                        break;
                    }
                }

                if(v10_1 != v4) {
                    if(v10_1 == v1) {
                    }
                    else {
                        v2_1 = (((long)v14)) * 1000000000 + (((long)v12));
                        v4 = v13;
                        v13 = v10_1;
                        goto label_211;
                    }
                }

                if(!arg28) {
                    return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
                }

                throw new IllegalArgumentException(v3);
            }

        label_211:
            DurationUnit v10_2 = DurationKt.defaultDurationUnitByShortNameOrNull(v0, v13);
            if(v10_2 == null) {
                v0 = "Unknown duration unit short name: " + v0.charAt(v13);
                if(!arg28) {
                    return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
                }

                throw new IllegalArgumentException(v0);
            }

            if(v7 != null && v7.compareTo(v10_2) <= 0) {
                if(!arg28) {
                    return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
                }
                else {
                    throw new IllegalArgumentException("Unexpected order of duration components");
                }
            }

            int v7_1 = WhenMappings.$EnumSwitchMapping$0[v10_2.ordinal()];
            if(v7_1 == 1) {
                long v14_1 = 1000;
                v8 += v5 / v14_1;
                if(v8 <= 4611686018426L) {
                    v5 = v5 % v14_1 * v14_1;
                label_254:
                    v19 = v5;
                }
            }
            else if(v7_1 != 2) {
                v8 = DurationKt.addMillisWithoutOverflow(v8, DurationUnitKt.convertDurationUnitToMilliseconds(v5, v10_2));
            }
            else {
                v8 += v5 / 1000000;
                v5 = v19 + v5 % 1000000;
                goto label_254;
            }

            int v5_1 = DurationKt.getShortNameLength(v10_2) + v13;
            if(v22 != 0) {
                if(v5_1 < v1) {
                    if(!arg28) {
                        return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
                    }

                    throw new IllegalArgumentException("Fractional component must be last");
                }

                v2_1 = v10_2.compareTo(DurationUnit.MINUTES) < 0 || v5_1 - v4 <= 15 ? DurationKt.fractionDigitsToNanos(v2_1, v10_2) : DurationKt.parseFractionFallback(v0, v4, v5_1 - DurationKt.getShortNameLength(v10_2), v10_2);
                v7 = v10_2;
                v4 = v18;
                v12 = 0;
                v10 = v19 + v2_1;
                v2 = v5_1;
                goto label_30;
            }

            v2 = v5_1;
            v7 = v10_2;
            v4 = v18;
            v10 = v19;
        }

    label_93:
        while(v13 < v0.length()) {
            v1 = v0.charAt(v13);
            if(0x30 > v1) {
                break;
            }

            if(v1 >= v15) {
                break;
            }

            ++v13;
        }

        if(!arg28) {
            return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
        }

        throw new IllegalArgumentException(v3);
    label_307:
        return Duration.plus-LRDsOJo(DurationKt.toDuration(v8, DurationUnit.MILLISECONDS), DurationKt.toDuration(v10, DurationUnit.NANOSECONDS));
    }

    private static final long parseDuration(String arg10, boolean arg11, boolean arg12) {
        long v10;
        int v5;
        if(arg10.length() == 0) {
            if(!arg12) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }

            throw new IllegalArgumentException("The string is empty");
        }

        boolean v0 = false;
        int v1 = arg10.charAt(0);
        if(v1 != 43) {
            v1 = v1 != 45 ? 0 : 1;
            v5 = v1;
        }
        else {
            v1 = 0;
            v5 = 1;
        }

        if(v5 > 0) {
            v0 = true;
        }

        if(arg10.length() <= v5) {
            if(!arg12) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }

            throw new IllegalArgumentException("No components");
        }

        if(arg10.charAt(v5) == 80) {
            v10 = DurationKt.parseIsoStringFormat(arg10, v5 + 1, arg12);
        }
        else if(!arg11) {
            String v4 = arg10;
            v10 = StringsKt.regionMatches(v4, v5, "Infinity", 0, Math.max(arg10.length() - v5, 8), true) ? Duration.Companion.getINFINITE-UwyO8pc() : DurationKt.parseDefaultStringFormat(v4, v5, v0, arg12);
        }
        else if(!arg12) {
            return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
        }
        else {
            throw new IllegalArgumentException("");
        }

        if(v1 != 0 && !Duration.equals-impl0(v10, Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib())) {
            v10 = Duration.unaryMinus-UwyO8pc(v10);
        }

        return v10;
    }

    static long parseDuration$default(String arg0, boolean arg1, boolean arg2, int arg3, Object arg4) {
        return DurationKt.parseDuration(arg0, arg1, true);
    }

    private static final long parseFractionFallback(String arg1, int arg2, int arg3, DurationUnit arg4) {
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type java.lang.String");
        arg1 = arg1.substring(arg2, arg3);
        Intrinsics.checkNotNullExpressionValue(arg1, "substring(...)");
        return MathKt.roundToLong(Double.parseDouble(arg1) * (((double)DurationKt.getFallbackFractionMultiplier(arg4))));
    }

    private static final long parseIsoStringFormat(String arg23, int arg24, boolean arg25) {
        int v19;
        int v14;
        int v15;
        int v5;
        int v12;
        String v0 = arg23;
        String v2 = "";
        int v3 = arg24;
        if(v3 == v0.length()) {
            if(!arg25) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }

            throw new IllegalArgumentException(v2);
        }

        DurationUnit v6 = null;
        long v7 = 0;
        long v9 = 0;
        int v11 = 0;
        while(true) {
        label_16:
            if(v3 >= v0.length()) {
                goto label_313;
            }

            v12 = v0.charAt(v3);
            if(v12 != 84) {
                goto label_35;
            }

            if(v11 == 0) {
                ++v3;
                if(v3 == v0.length()) {
                }
                else {
                    v11 = 1;
                    continue;
                }
            }

            break;
        }

        if(!arg25) {
            return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
        }

        throw new IllegalArgumentException(v2);
    label_35:
        LongParser v13 = LongParser.Companion.getIso();
        int v1 = 45;
        int v4 = 43;
        if(LongParser.access$getAllowSign$p(v13)) {
            v5 = v0.charAt(v3);
            if(v5 == v4) {
                v5 = v3 + 1;
                goto label_51;
            }
            else if(v5 != v1) {
                goto label_50;
            }
            else {
                v5 = v3 + 1;
                v15 = -1;
            }
        }
        else {
        label_50:
            v5 = v3;
        label_51:
            v15 = 1;
            goto label_53;
        label_313:
            return Duration.plus-LRDsOJo(DurationKt.toDuration(v7, DurationUnit.MILLISECONDS), DurationKt.toDuration(v9, DurationUnit.NANOSECONDS));
        }

        while(true) {
        label_53:
            v1 = 0x30;
            if(v5 < v0.length() && v0.charAt(v5) == v1) {
                ++v5;
                continue;
            }

            break;
        }

        long v17 = 0;
        while(true) {
            v4 = 58;
            if(v5 < v0.length()) {
                v14 = v0.charAt(v5);
                if(v1 > v14) {
                    goto label_126;
                }
                else if(v14 < v4) {
                    v14 += 0xFFFFFFD0;
                    if(v17 <= LongParser.access$getOverflowThreshold$p(v13)) {
                        if(v17 == LongParser.access$getOverflowThreshold$p(v13)) {
                            v19 = v5;
                            if((((long)v14)) > LongParser.access$getLastDigitMax$p(v13)) {
                                goto label_92;
                            }
                        }
                        else {
                            v19 = v5;
                        }

                        v17 = (v17 << 3) + (v17 << 1) + (((long)v14));
                        v5 = v19 + 1;
                        v2 = v2;
                        v1 = 0x30;
                        continue;
                    }
                    else {
                        break;
                    }
                }
                else {
                    goto label_126;
                }
            }
            else {
                goto label_126;
            }

            goto label_141;
        }

        v19 = v5;
    label_92:
        String v21 = v2;
        v5 = v19;
        goto label_94;
    label_126:
        String v1_1 = v2;
        v5 = v5;
        if(v5 != v0.length()) {
            v14 = v12 == 43 || v12 == 45 ? 1 : 0;
            if(v5 != v3 + v14) {
                goto label_141;
            }
        }

        if(!arg25) {
            return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
        }

        throw new IllegalArgumentException(v1_1);
    label_94:
        while(v5 < v0.length()) {
            v1 = v0.charAt(v5);
            if(0x30 > v1) {
                break;
            }

            if(v1 >= 58) {
                break;
            }

            ++v5;
        }

        if(v5 != v0.length()) {
            v14 = v12 == 43 || v12 == 45 ? 1 : 0;
            if(v5 == v3 + v14) {
                goto label_118;
            }

            v17 = LongParser.access$getOverflowLimit$p(v13);
            v1_1 = v21;
            goto label_141;
        }

    label_118:
        if(!arg25) {
            return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
        }

        throw new IllegalArgumentException(v21);
    label_141:
        long v2_1 = v17;
        if(v0.charAt(v5) == 46) {
            v4 = v5 + 1;
            v5 = Math.min(v5 + 7, v0.length());
            int v9_1 = v4;
            int v10 = 0;
            while(v9_1 < v5) {
                v12 = v0.charAt(v9_1);
                if(0x30 > v12) {
                    break;
                }

                if(v12 >= 58) {
                    break;
                }

                v10 = (v10 << 3) + (v10 << 1) + (v12 - 0x30);
                ++v9_1;
            }

            v5 = 6 - (v9_1 - v4);
            for(v12 = 0; v12 < v5; ++v12) {
                v10 = (v10 << 1) + (v10 << 3);
            }

            v5 = Math.min(v9_1 + 9, v0.length());
            v12 = v9_1;
            int v13_1 = 0;
            while(v12 < v5) {
                v14 = v0.charAt(v12);
                arg24 = v5;
                if(0x30 > v14) {
                    break;
                }

                if(v14 >= 58) {
                    break;
                }

                v13_1 = (v13_1 << 3) + (v13_1 << 1) + (v14 - 0x30);
                ++v12;
                v5 = arg24;
            }

            v5 = 9 - (v12 - v9_1);
            for(v9_1 = 0; v9_1 < v5; ++v9_1) {
                v13_1 = (v13_1 << 1) + (v13_1 << 3);
            }

            for(v5 = v12; v5 < v0.length(); ++v5) {
                v9_1 = v0.charAt(v5);
                if(0x30 > v9_1) {
                    break;
                }

                if(v9_1 >= 58) {
                    break;
                }
            }

            if(v5 != v4 && v5 != v0.length()) {
                if(v0.charAt(v5) != 83) {
                }
                else {
                    v9 = (((long)v15)) * DurationKt.fractionDigitsToNanos((((long)v10)) * 1000000000 + (((long)v13_1)), DurationUnit.SECONDS);
                    goto label_238;
                }
            }

            if(!arg25) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }

            throw new IllegalArgumentException(v1_1);
        }

    label_238:
        DurationUnit v4_1 = DurationKt.isoDurationUnitByShortNameOrNull(v0, v5);
        if(v4_1 == null) {
            v0 = "Unknown duration unit short name: " + v0.charAt(v5);
            if(!arg25) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }

            throw new IllegalArgumentException(v0);
        }

        if(v6 != null && v6.compareTo(v4_1) <= 0) {
            if(!arg25) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }
            else {
                throw new IllegalArgumentException("Unexpected order of duration components");
            }
        }

        if(v4_1 == DurationUnit.DAYS) {
            if(v11 == 0) {
                v7 = (((long)v15)) * DurationUnitKt.convertDurationUnitToMilliseconds(v2_1, v4_1);
            }
            else if(!arg25) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }
            else {
                throw new IllegalArgumentException(v1_1);
            }
        }
        else if(v11 != 0) {
            v2_1 = DurationKt.addMillisWithoutOverflow(v7, (((long)v15)) * DurationUnitKt.convertDurationUnitToMilliseconds(v2_1, v4_1));
            if(v2_1 != 0x7FFFFFFFFFFFC0DEL) {
                v7 = v2_1;
            }
            else if(!arg25) {
                return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
            }
            else {
                throw new IllegalArgumentException(v1_1);
            }
        }
        else if(!arg25) {
            return Duration.Companion.getINVALID-UwyO8pc$kotlin_stdlib();
        }
        else {
            throw new IllegalArgumentException(v1_1);
        }

        v3 = v5 + 1;
        v2 = v1_1;
        v6 = v4_1;
        goto label_16;
    }

    private static final boolean sameSign(long arg0, long arg2) {
        if((arg0 ^ arg2) >= 0) {
            return 1;
        }

        return 0;
    }

    private static final long times-kIfJnKk(double arg0, long arg2) {
        return Duration.times-UwyO8pc(arg2, arg0);
    }

    private static final long times-mvk6XK0(int arg0, long arg1) {
        return Duration.times-UwyO8pc(arg1, arg0);
    }

    public static final long toDuration(double arg4, DurationUnit arg6) {
        Intrinsics.checkNotNullParameter(arg6, "unit");
        double v0 = DurationUnitKt.convertDurationUnit(arg4, arg6, DurationUnit.NANOSECONDS);
        if(!Double.isNaN(v0)) {
            long v0_1 = MathKt.roundToLong(v0);
            if(-4611686018426999999L <= v0_1 && v0_1 < 0x3FFFFFFFFFFA14C0L) {
                return DurationKt.durationOfNanos(v0_1);
            }

            return DurationKt.durationOfMillisNormalized(MathKt.roundToLong(DurationUnitKt.convertDurationUnit(arg4, arg6, DurationUnit.MILLISECONDS)));
        }

        throw new IllegalArgumentException("Duration value cannot be NaN.".toString());
    }

    public static final long toDuration(int arg2, DurationUnit arg3) {
        Intrinsics.checkNotNullParameter(arg3, "unit");
        if(arg3.compareTo(DurationUnit.SECONDS) <= 0) {
            return DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(((long)arg2), arg3, DurationUnit.NANOSECONDS));
        }

        return DurationKt.toDuration(((long)arg2), arg3);
    }

    public static final long toDuration(long arg7, DurationUnit arg9) {
        Intrinsics.checkNotNullParameter(arg9, "unit");
        long v0 = DurationUnitKt.convertDurationUnitOverflow(0x3FFFFFFFFFFA14BFL, DurationUnit.NANOSECONDS, arg9);
        if(-v0 <= arg7 && arg7 <= v0) {
            return DurationKt.durationOfNanos(DurationUnitKt.convertDurationUnitOverflow(arg7, arg9, DurationUnit.NANOSECONDS));
        }

        if(arg9.compareTo(DurationUnit.MILLISECONDS) >= 0) {
            return DurationKt.durationOfMillis((((long)MathKt.getSign(arg7))) * DurationUnitKt.convertDurationUnitToMilliseconds(Math.abs(RangesKt.coerceAtLeast(arg7, -9223372036854775807L)), arg9));
        }

        return DurationKt.durationOfMillis(RangesKt.coerceIn(DurationUnitKt.convertDurationUnit(arg7, arg9, DurationUnit.MILLISECONDS), -4611686018427387903L, 0x3FFFFFFFFFFFFFFFL));
    }
}

