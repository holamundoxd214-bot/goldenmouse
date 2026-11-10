package kotlin.internal;

import kotlin.Metadata;
import kotlin.UInt;
import kotlin.ULong;

@Metadata(d1={"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00012\u0006\u0010\u0003\u001A\u00020\u00012\u0006\u0010\u0004\u001A\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0004\b\u0005\u0010\u0006\u001A)\u0010\u0000\u001A\u00020\u00072\u0006\u0010\u0002\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00072\u0006\u0010\u0004\u001A\u00020\u0007H\u0082\u0080\u0004¢\u0006\u0004\b\b\u0010\t\u001A)\u0010\n\u001A\u00020\u00012\u0006\u0010\u000B\u001A\u00020\u00012\u0006\u0010\f\u001A\u00020\u00012\u0006\u0010\r\u001A\u00020\u000EH\u0081\u0080\u0004¢\u0006\u0004\b\u000F\u0010\u0006\u001A)\u0010\n\u001A\u00020\u00072\u0006\u0010\u000B\u001A\u00020\u00072\u0006\u0010\f\u001A\u00020\u00072\u0006\u0010\r\u001A\u00020\u0010H\u0081\u0080\u0004¢\u0006\u0004\b\u0011\u0010\t¨\u0006\u0012"}, d2={"differenceModulo", "Lkotlin/UInt;", "a", "b", "c", "differenceModulo-WZ9TVnA", "(III)I", "Lkotlin/ULong;", "differenceModulo-sambcqE", "(JJJ)J", "getProgressionLastElement", "start", "end", "step", "", "getProgressionLastElement-Nkh28Cs", "", "getProgressionLastElement-7ftBX0g", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class UProgressionUtilKt {
    private static final int differenceModulo-WZ9TVnA(int arg1, int arg2, int arg3) {
        arg1 = Integer.remainderUnsigned(arg1, arg3);
        arg2 = Integer.remainderUnsigned(arg2, arg3);
        int v0 = Integer.compareUnsigned(arg1, arg2);
        arg1 = UInt.constructor-impl(arg1 - arg2);
        if(v0 >= 0) {
            return arg1;
        }

        return UInt.constructor-impl(arg1 + arg3);
    }

    private static final long differenceModulo-sambcqE(long arg1, long arg3, long arg5) {
        arg1 = Long.remainderUnsigned(arg1, arg5);
        arg3 = Long.remainderUnsigned(arg3, arg5);
        int v0 = Long.compareUnsigned(arg1, arg3);
        arg1 = ULong.constructor-impl(arg1 - arg3);
        if(v0 >= 0) {
            return arg1;
        }

        return ULong.constructor-impl(arg1 + arg5);
    }

    public static final long getProgressionLastElement-7ftBX0g(long arg8, long arg10, long arg12) {
        int v0 = Long.compare(arg12, 0);
        if(v0 <= 0) {
            long v6 = arg10;
            arg10 = arg8;
            arg8 = v6;
            if(v0 < 0) {
                if(Long.compareUnsigned(arg10, arg8) <= 0) {
                    return arg8;
                }

                goto label_22;
            }
            else {
                goto label_30;
            }
        }
        else if(Long.compareUnsigned(arg8, arg10) >= 0) {
            arg8 = arg10;
        }
        else {
            return ULong.constructor-impl(arg10 - UProgressionUtilKt.differenceModulo-sambcqE(arg10, arg8, ULong.constructor-impl(arg12)));
        }

        return arg8;
    label_22:
        return ULong.constructor-impl(arg8 + UProgressionUtilKt.differenceModulo-sambcqE(arg10, arg8, ULong.constructor-impl(-arg12)));
    label_30:
        throw new IllegalArgumentException("Step is zero.");
    }

    public static final int getProgressionLastElement-Nkh28Cs(int arg1, int arg2, int arg3) {
        if(arg3 > 0) {
            if(Integer.compareUnsigned(arg1, arg2) >= 0) {
            }
            else {
                return UInt.constructor-impl(arg2 - UProgressionUtilKt.differenceModulo-WZ9TVnA(arg2, arg1, UInt.constructor-impl(arg3)));
            }
        }
        else if(arg3 < 0) {
            if(Integer.compareUnsigned(arg1, arg2) <= 0) {
                return arg2;
            }

            goto label_13;
        }
        else {
            goto label_19;
        }

        return arg2;
    label_13:
        return UInt.constructor-impl(arg2 + UProgressionUtilKt.differenceModulo-WZ9TVnA(arg1, arg2, UInt.constructor-impl(-arg3)));
    label_19:
        throw new IllegalArgumentException("Step is zero.");
    }
}

