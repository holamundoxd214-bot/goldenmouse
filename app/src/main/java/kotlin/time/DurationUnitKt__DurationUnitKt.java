package kotlin.time;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1={"\u0000\u0018\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000E\n\u0000\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0004H\u0080\u0080\u0004\u001A\u001B\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u0007\u001A\u000E\u0010\u000B\u001A\u00020\f*\u00020\u0004H\u0081\u0080\u0004\"\u0019\u0010\b\u001A\u00020\u0001*\u00020\u00048BX\u0082\u0084\b¢\u0006\u0006\u001A\u0004\b\t\u0010\n¨\u0006\r"}, d2={"convertDurationUnitToMilliseconds", "", "value", "unit", "Lkotlin/time/DurationUnit;", "multiplyNonNegativeWithoutOverflow", "other", "multiplyNonNegativeWithoutOverflow$DurationUnitKt__DurationUnitKt", "millisMultiplier", "getMillisMultiplier$DurationUnitKt__DurationUnitKt", "(Lkotlin/time/DurationUnit;)J", "shortName", "", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/time/DurationUnitKt") class DurationUnitKt__DurationUnitKt extends DurationUnitKt__DurationUnitJvmKt {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[DurationUnit.values().length];
            try {
                v0[DurationUnit.DAYS.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[DurationUnit.HOURS.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[DurationUnit.MINUTES.ordinal()] = 3;
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
                                v0[DurationUnit.MILLISECONDS.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[DurationUnit.NANOSECONDS.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[DurationUnit.MICROSECONDS.ordinal()] = 7;
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

    public DurationUnitKt__DurationUnitKt() {
        super();
    }

    public static final long convertDurationUnitToMilliseconds(long arg2, DurationUnit arg4) {
        Intrinsics.checkNotNullParameter(arg4, "unit");
        return DurationUnitKt__DurationUnitKt.multiplyNonNegativeWithoutOverflow$DurationUnitKt__DurationUnitKt(arg2, DurationUnitKt__DurationUnitKt.getMillisMultiplier$DurationUnitKt__DurationUnitKt(arg4));
    }

    private static final long getMillisMultiplier$DurationUnitKt__DurationUnitKt(DurationUnit arg3) {
        int v0 = WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()];
        if(v0 != 1) {
            if(v0 != 2) {
                if(v0 != 3) {
                    if(v0 != 4) {
                        if(v0 == 5) {
                            return 1;
                        }

                        throw new IllegalStateException("Wrong unit for millisMultiplier: " + arg3.toString());
                    }

                    return 1000;
                }

                return 60000;
            }

            return 3600000;
        }

        return 86400000;
    }

    private static final long multiplyNonNegativeWithoutOverflow$DurationUnitKt__DurationUnitKt(long arg5, long arg7) {
        long v0 = 0;
        if(arg5 == v0) {
            return v0;
        }

        v0 = 1;
        long v3 = 0x3FFFFFFFFFFFFFFFL;
        if(Long.compare(arg5, v0) == 0) {
            return RangesKt.coerceAtMost(arg7, v3);
        }

        if(arg7 == v0) {
            return RangesKt.coerceAtMost(arg5, v3);
        }

        int v0_1 = 0x80 - Long.numberOfLeadingZeros(arg5) - Long.numberOfLeadingZeros(arg7);
        int v1 = 0x3F;
        if(v0_1 < v1) {
            return arg5 * arg7;
        }

        if(v0_1 > v1) {
            return v3;
        }

        return RangesKt.coerceAtMost(arg5 * arg7, v3);
    }

    public static final String shortName(DurationUnit arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[arg3.ordinal()]) {
            case 1: {
                return "d";
            }
            case 2: {
                return "h";
            }
            case 3: {
                return "m";
            }
            case 4: {
                return "s";
            }
            case 5: {
                return "ms";
            }
            case 6: {
                return "ns";
            }
            case 7: {
                return "us";
            }
        }

        throw new IllegalStateException("Unknown unit: " + arg3.toString());
        return "ns";
    }
}

