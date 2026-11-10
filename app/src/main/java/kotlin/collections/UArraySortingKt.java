package kotlin.collections;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.UIntArray;
import kotlin.ULongArray;
import kotlin.UShortArray;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u00000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007\u001A)\u0010\b\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\n\u0010\u000B\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\f2\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\r\u0010\u000E\u001A)\u0010\b\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\f2\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u000F\u0010\u0010\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0012\u0010\u0013\u001A)\u0010\b\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u00112\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015\u001A)\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u00162\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0018\u001A)\u0010\b\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u00162\u0006\u0010\u0004\u001A\u00020\u00012\u0006\u0010\u0005\u001A\u00020\u0001H\u0083\u0080\u0004¢\u0006\u0004\b\u0019\u0010\u001A\u001A)\u0010\u001B\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u00032\u0006\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u001E\u0010\u000B\u001A)\u0010\u001B\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\f2\u0006\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b\u001F\u0010\u0010\u001A)\u0010\u001B\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u00112\u0006\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b \u0010\u0015\u001A)\u0010\u001B\u001A\u00020\t2\u0006\u0010\u0002\u001A\u00020\u00162\u0006\u0010\u001C\u001A\u00020\u00012\u0006\u0010\u001D\u001A\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0004\b!\u0010\u001A¨\u0006\""}, d2={"partition", "", "array", "Lkotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "quickSort", "", "quickSort-4UcCI2c", "([BII)V", "Lkotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lkotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lkotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class UArraySortingKt {
    private static final int partition--nroSd4(long[] arg6, int arg7, int arg8) {
        long v0 = ULongArray.get-s-VKNKU(arg6, (arg7 + arg8) / 2);
        while(arg7 <= arg8) {
            while(Long.compareUnsigned(ULongArray.get-s-VKNKU(arg6, arg7), v0) < 0) {
                ++arg7;
            }

            while(Long.compareUnsigned(ULongArray.get-s-VKNKU(arg6, arg8), v0) > 0) {
                --arg8;
            }

            if(arg7 > arg8) {
                continue;
            }

            long v2 = ULongArray.get-s-VKNKU(arg6, arg7);
            ULongArray.set-k8EXiF4(arg6, arg7, ULongArray.get-s-VKNKU(arg6, arg8));
            ULongArray.set-k8EXiF4(arg6, arg8, v2);
            ++arg7;
            --arg8;
        }

        return arg7;
    }

    private static final int partition-4UcCI2c(byte[] arg3, int arg4, int arg5) {
        int v0 = UByteArray.get-w2LRezQ(arg3, (arg4 + arg5) / 2);
        while(arg4 <= arg5) {
            while(true) {
                int v2 = v0 & 0xFF;
                if(Intrinsics.compare(UByteArray.get-w2LRezQ(arg3, arg4) & 0xFF, v2) < 0) {
                    ++arg4;
                    continue;
                }

                break;
            }

            while(Intrinsics.compare(UByteArray.get-w2LRezQ(arg3, arg5) & 0xFF, v2) > 0) {
                --arg5;
            }

            if(arg4 > arg5) {
                continue;
            }

            byte v1 = UByteArray.get-w2LRezQ(arg3, arg4);
            UByteArray.set-VurrAj0(arg3, arg4, UByteArray.get-w2LRezQ(arg3, arg5));
            UByteArray.set-VurrAj0(arg3, arg5, v1);
            ++arg4;
            --arg5;
        }

        return arg4;
    }

    private static final int partition-Aa5vz7o(short[] arg4, int arg5, int arg6) {
        int v0 = UShortArray.get-Mh2AYeg(arg4, (arg5 + arg6) / 2);
        while(arg5 <= arg6) {
            while(true) {
                int v2 = 0xFFFF;
                int v3 = v0 & v2;
                if(Intrinsics.compare(UShortArray.get-Mh2AYeg(arg4, arg5) & v2, v3) < 0) {
                    ++arg5;
                    continue;
                }

                break;
            }

            while(Intrinsics.compare(UShortArray.get-Mh2AYeg(arg4, arg6) & v2, v3) > 0) {
                --arg6;
            }

            if(arg5 > arg6) {
                continue;
            }

            short v1 = UShortArray.get-Mh2AYeg(arg4, arg5);
            UShortArray.set-01HTLdE(arg4, arg5, UShortArray.get-Mh2AYeg(arg4, arg6));
            UShortArray.set-01HTLdE(arg4, arg6, v1);
            ++arg5;
            --arg6;
        }

        return arg5;
    }

    private static final int partition-oBK06Vg(int[] arg3, int arg4, int arg5) {
        int v0 = UIntArray.get-pVg5ArA(arg3, (arg4 + arg5) / 2);
        while(arg4 <= arg5) {
            while(Integer.compareUnsigned(UIntArray.get-pVg5ArA(arg3, arg4), v0) < 0) {
                ++arg4;
            }

            while(Integer.compareUnsigned(UIntArray.get-pVg5ArA(arg3, arg5), v0) > 0) {
                --arg5;
            }

            if(arg4 > arg5) {
                continue;
            }

            int v1 = UIntArray.get-pVg5ArA(arg3, arg4);
            UIntArray.set-VXSXFK8(arg3, arg4, UIntArray.get-pVg5ArA(arg3, arg5));
            UIntArray.set-VXSXFK8(arg3, arg5, v1);
            ++arg4;
            --arg5;
        }

        return arg4;
    }

    private static final void quickSort--nroSd4(long[] arg2, int arg3, int arg4) {
        int v0 = UArraySortingKt.partition--nroSd4(arg2, arg3, arg4);
        int v1 = v0 - 1;
        if(arg3 < v1) {
            UArraySortingKt.quickSort--nroSd4(arg2, arg3, v1);
        }

        if(v0 < arg4) {
            UArraySortingKt.quickSort--nroSd4(arg2, v0, arg4);
        }
    }

    private static final void quickSort-4UcCI2c(byte[] arg2, int arg3, int arg4) {
        int v0 = UArraySortingKt.partition-4UcCI2c(arg2, arg3, arg4);
        int v1 = v0 - 1;
        if(arg3 < v1) {
            UArraySortingKt.quickSort-4UcCI2c(arg2, arg3, v1);
        }

        if(v0 < arg4) {
            UArraySortingKt.quickSort-4UcCI2c(arg2, v0, arg4);
        }
    }

    private static final void quickSort-Aa5vz7o(short[] arg2, int arg3, int arg4) {
        int v0 = UArraySortingKt.partition-Aa5vz7o(arg2, arg3, arg4);
        int v1 = v0 - 1;
        if(arg3 < v1) {
            UArraySortingKt.quickSort-Aa5vz7o(arg2, arg3, v1);
        }

        if(v0 < arg4) {
            UArraySortingKt.quickSort-Aa5vz7o(arg2, v0, arg4);
        }
    }

    private static final void quickSort-oBK06Vg(int[] arg2, int arg3, int arg4) {
        int v0 = UArraySortingKt.partition-oBK06Vg(arg2, arg3, arg4);
        int v1 = v0 - 1;
        if(arg3 < v1) {
            UArraySortingKt.quickSort-oBK06Vg(arg2, arg3, v1);
        }

        if(v0 < arg4) {
            UArraySortingKt.quickSort-oBK06Vg(arg2, v0, arg4);
        }
    }

    public static final void sortArray--nroSd4(long[] arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        UArraySortingKt.quickSort--nroSd4(arg1, arg2, arg3 - 1);
    }

    public static final void sortArray-4UcCI2c(byte[] arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        UArraySortingKt.quickSort-4UcCI2c(arg1, arg2, arg3 - 1);
    }

    public static final void sortArray-Aa5vz7o(short[] arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        UArraySortingKt.quickSort-Aa5vz7o(arg1, arg2, arg3 - 1);
    }

    public static final void sortArray-oBK06Vg(int[] arg1, int arg2, int arg3) {
        Intrinsics.checkNotNullParameter(arg1, "array");
        UArraySortingKt.quickSort-oBK06Vg(arg1, arg2, arg3 - 1);
    }
}

