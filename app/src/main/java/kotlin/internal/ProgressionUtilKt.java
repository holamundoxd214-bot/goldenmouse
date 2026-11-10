package kotlin.internal;

import kotlin.Metadata;

@Metadata(d1={"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0007\u001A\u001A\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u0001H\u0082\u0080\u0004\u001A\u001A\u0010\u0000\u001A\u00020\u00042\u0006\u0010\u0002\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0004H\u0082\u0080\u0004\u001A\"\u0010\u0005\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0001H\u0082\u0080\u0004\u001A\"\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0002\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0082\u0080\u0004\u001A\"\u0010\u0007\u001A\u00020\u00012\u0006\u0010\b\u001A\u00020\u00012\u0006\u0010\t\u001A\u00020\u00012\u0006\u0010\n\u001A\u00020\u0001H\u0081\u0080\u0004\u001A\"\u0010\u0007\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u00042\u0006\u0010\t\u001A\u00020\u00042\u0006\u0010\n\u001A\u00020\u0004H\u0081\u0080\u0004¨\u0006\u000B"}, d2={"mod", "", "a", "b", "", "differenceModulo", "c", "getProgressionLastElement", "start", "end", "step", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class ProgressionUtilKt {
    private static final int differenceModulo(int arg0, int arg1, int arg2) {
        return ProgressionUtilKt.mod(ProgressionUtilKt.mod(arg0, arg2) - ProgressionUtilKt.mod(arg1, arg2), arg2);
    }

    private static final long differenceModulo(long arg0, long arg2, long arg4) {
        return ProgressionUtilKt.mod(ProgressionUtilKt.mod(arg0, arg4) - ProgressionUtilKt.mod(arg2, arg4), arg4);
    }

    public static final int getProgressionLastElement(int arg0, int arg1, int arg2) {
        if(arg2 > 0) {
            if(arg0 >= arg1) {
            }
            else {
                return arg1 - ProgressionUtilKt.differenceModulo(arg1, arg0, arg2);
            }
        }
        else if(arg2 < 0) {
            if(arg0 <= arg1) {
                return arg1;
            }

            goto label_9;
        }
        else {
            goto label_13;
        }

        return arg1;
    label_9:
        return arg1 + ProgressionUtilKt.differenceModulo(arg0, arg1, -arg2);
    label_13:
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final long getProgressionLastElement(long arg4, long arg6, long arg8) {
        int v0 = Long.compare(arg8, 0);
        if(v0 <= 0) {
            long v2 = arg6;
            arg6 = arg4;
            arg4 = v2;
            if(v0 < 0) {
                if(arg6 <= arg4) {
                    return arg4;
                }

                goto label_18;
            }
            else {
                goto label_25;
            }
        }
        else if(arg4 >= arg6) {
            arg4 = arg6;
        }
        else {
            return arg6 - ProgressionUtilKt.differenceModulo(arg6, arg4, arg8);
        }

        return arg4;
    label_18:
        return arg4 + ProgressionUtilKt.differenceModulo(arg6, arg4, -arg8);
    label_25:
        throw new IllegalArgumentException("Step is zero.");
    }

    private static final int mod(int arg0, int arg1) {
        arg0 %= arg1;
        if(arg0 >= 0) {
            return arg0;
        }

        return arg0 + arg1;
    }

    private static final long mod(long arg2, long arg4) {
        arg2 %= arg4;
        if(arg2 >= 0) {
            return arg2;
        }

        return arg2 + arg4;
    }
}

