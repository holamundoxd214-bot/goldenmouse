package kotlin.time;

import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\u001A\u000E\u0010\u0000\u001A\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004\u001A\u000E\u0010\u0003\u001A\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004\u001A\"\u0010\u0004\u001A\u00020\u00052\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0081\u0080\u0004\u001A\"\u0010\t\u001A\u00020\n2\u0006\u0010\u0006\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0081\u0080\u0004\u001A\"\u0010\u0004\u001A\u00020\n2\u0006\u0010\u0006\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00022\u0006\u0010\b\u001A\u00020\u0002H\u0081\u0080\u0004¨\u0006\u000B"}, d2={"toTimeUnit", "Ljava/util/concurrent/TimeUnit;", "Lkotlin/time/DurationUnit;", "toDurationUnit", "convertDurationUnit", "", "value", "sourceUnit", "targetUnit", "convertDurationUnitOverflow", "", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/time/DurationUnitKt") class DurationUnitKt__DurationUnitJvmKt {
    @Metadata(k=3, mv={2, 3, 0}, xi=0x30) public final class WhenMappings {
        static {
            int[] v0 = new int[TimeUnit.values().length];
            try {
                v0[TimeUnit.NANOSECONDS.ordinal()] = 1;
                goto label_7;
            }
            catch(NoSuchFieldError ) {
                try {
                label_7:
                    v0[TimeUnit.MICROSECONDS.ordinal()] = 2;
                    goto label_11;
                }
                catch(NoSuchFieldError ) {
                    try {
                    label_11:
                        v0[TimeUnit.MILLISECONDS.ordinal()] = 3;
                        goto label_15;
                    }
                    catch(NoSuchFieldError ) {
                        try {
                        label_15:
                            v0[TimeUnit.SECONDS.ordinal()] = 4;
                            goto label_19;
                        }
                        catch(NoSuchFieldError ) {
                            try {
                            label_19:
                                v0[TimeUnit.MINUTES.ordinal()] = 5;
                                goto label_23;
                            }
                            catch(NoSuchFieldError ) {
                                try {
                                label_23:
                                    v0[TimeUnit.HOURS.ordinal()] = 6;
                                    goto label_27;
                                }
                                catch(NoSuchFieldError ) {
                                    try {
                                    label_27:
                                        v0[TimeUnit.DAYS.ordinal()] = 7;
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

    public DurationUnitKt__DurationUnitJvmKt() {
        super();
    }

    public static final double convertDurationUnit(double arg6, DurationUnit arg8, DurationUnit arg9) {
        Intrinsics.checkNotNullParameter(arg8, "sourceUnit");
        Intrinsics.checkNotNullParameter(arg9, "targetUnit");
        long v2 = 1;
        long v0 = arg9.getTimeUnit$kotlin_stdlib().convert(v2, arg8.getTimeUnit$kotlin_stdlib());
        if(v0 > 0) {
            return arg6 * (((double)v0));
        }

        return arg6 / (((double)arg8.getTimeUnit$kotlin_stdlib().convert(v2, arg9.getTimeUnit$kotlin_stdlib())));
    }

    public static final long convertDurationUnit(long arg1, DurationUnit arg3, DurationUnit arg4) {
        Intrinsics.checkNotNullParameter(arg3, "sourceUnit");
        Intrinsics.checkNotNullParameter(arg4, "targetUnit");
        return arg4.getTimeUnit$kotlin_stdlib().convert(arg1, arg3.getTimeUnit$kotlin_stdlib());
    }

    public static final long convertDurationUnitOverflow(long arg1, DurationUnit arg3, DurationUnit arg4) {
        Intrinsics.checkNotNullParameter(arg3, "sourceUnit");
        Intrinsics.checkNotNullParameter(arg4, "targetUnit");
        return arg4.getTimeUnit$kotlin_stdlib().convert(arg1, arg3.getTimeUnit$kotlin_stdlib());
    }

    public static final DurationUnit toDurationUnit(TimeUnit arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        switch(WhenMappings.$EnumSwitchMapping$0[arg1.ordinal()]) {
            case 1: {
                goto label_21;
            }
            case 2: {
                goto label_19;
            }
            case 3: {
                goto label_17;
            }
            case 4: {
                goto label_15;
            }
            case 5: {
                goto label_13;
            }
            case 6: {
                goto label_11;
            }
            case 7: {
                goto label_9;
            }
        }

        throw new NoWhenBranchMatchedException();
    label_17:
        return DurationUnit.MILLISECONDS;
    label_19:
        return DurationUnit.MICROSECONDS;
    label_21:
        return DurationUnit.NANOSECONDS;
    label_9:
        return DurationUnit.DAYS;
    label_11:
        return DurationUnit.HOURS;
    label_13:
        return DurationUnit.MINUTES;
    label_15:
        return DurationUnit.SECONDS;
    }

    public static final TimeUnit toTimeUnit(DurationUnit arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.getTimeUnit$kotlin_stdlib();
    }
}

