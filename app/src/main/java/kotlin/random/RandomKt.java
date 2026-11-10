package kotlin.random;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlin.ranges.LongRange;

@Metadata(d1={"\u0000:\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000E\n\u0002\u0010\u0000\n\u0000\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0003H\u0087\u0080\u0004\u001A\u0012\u0010\u0000\u001A\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0004H\u0087\u0080\u0004\u001A\u0016\u0010\u0005\u001A\u00020\u0003*\u00020\u00012\u0006\u0010\u0006\u001A\u00020\u0007H\u0087\u0080\u0004\u001A\u0016\u0010\b\u001A\u00020\u0004*\u00020\u00012\u0006\u0010\u0006\u001A\u00020\tH\u0087\u0080\u0004\u001A\u0012\u0010\n\u001A\u00020\u00032\u0006\u0010\u000B\u001A\u00020\u0003H\u0080\u0080\u0004\u001A\u0016\u0010\f\u001A\u00020\u0003*\u00020\u00032\u0006\u0010\r\u001A\u00020\u0003H\u0080\u0080\u0004\u001A\u001A\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00032\u0006\u0010\u0011\u001A\u00020\u0003H\u0080\u0080\u0004\u001A\u001A\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0004H\u0080\u0080\u0004\u001A\u001A\u0010\u000E\u001A\u00020\u000F2\u0006\u0010\u0010\u001A\u00020\u00122\u0006\u0010\u0011\u001A\u00020\u0012H\u0080\u0080\u0004\u001A\u001A\u0010\u0013\u001A\u00020\u00142\u0006\u0010\u0010\u001A\u00020\u00152\u0006\u0010\u0011\u001A\u00020\u0015H\u0080\u0080\u0004¨\u0006\u0016"}, d2={"Random", "Lkotlin/random/Random;", "seed", "", "", "nextInt", "range", "Lkotlin/ranges/IntRange;", "nextLong", "Lkotlin/ranges/LongRange;", "fastLog2", "value", "takeUpperBits", "bitCount", "checkRangeBounds", "", "from", "until", "", "boundsErrorMessage", "", "", "kotlin-stdlib"}, k=2, mv={2, 3, 0}, xi=0x30) public final class RandomKt {
    public static final Random Random(int arg2) {
        return new XorWowRandom(arg2, arg2 >> 0x1F);
    }

    public static final Random Random(long arg3) {
        return new XorWowRandom(((int)arg3), ((int)(arg3 >> 0x20)));
    }

    public static final String boundsErrorMessage(Object arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "from");
        Intrinsics.checkNotNullParameter(arg3, "until");
        return "Random range is empty: [" + arg2 + ", " + arg3 + ").";
    }

    public static final void checkRangeBounds(double arg1, double arg3) {
        if(arg3 > arg1) {
            return;
        }

        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(Double.valueOf(arg1), Double.valueOf(arg3)).toString());
    }

    public static final void checkRangeBounds(int arg0, int arg1) {
        if(arg1 > arg0) {
            return;
        }

        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(Integer.valueOf(arg0), Integer.valueOf(arg1)).toString());
    }

    public static final void checkRangeBounds(long arg1, long arg3) {
        if(arg3 > arg1) {
            return;
        }

        throw new IllegalArgumentException(RandomKt.boundsErrorMessage(Long.valueOf(arg1), Long.valueOf(arg3)).toString());
    }

    public static final int fastLog2(int arg0) {
        return 0x1F - Integer.numberOfLeadingZeros(arg0);
    }

    public static final int nextInt(Random arg2, IntRange arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "range");
        if(!arg3.isEmpty()) {
            if(arg3.getLast() < 0x7FFFFFFF) {
                return arg2.nextInt(arg3.getFirst(), arg3.getLast() + 1);
            }

            if(arg3.getFirst() > 0x80000000) {
                return arg2.nextInt(arg3.getFirst() - 1, arg3.getLast()) + 1;
            }

            return arg2.nextInt();
        }

        throw new IllegalArgumentException("Cannot get random in empty range: " + arg3);
    }

    public static final long nextLong(Random arg7, LongRange arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "range");
        if(!arg8.isEmpty()) {
            long v1 = 1;
            if(Long.compare(arg8.getLast(), 0x7FFFFFFFFFFFFFFFL) < 0) {
                return arg7.nextLong(arg8.getFirst(), arg8.getLast() + v1);
            }

            if(arg8.getFirst() > -9223372036854775808L) {
                return arg7.nextLong(arg8.getFirst() - v1, arg8.getLast()) + v1;
            }

            return arg7.nextLong();
        }

        throw new IllegalArgumentException("Cannot get random in empty range: " + arg8);
    }

    public static final int takeUpperBits(int arg1, int arg2) {
        return arg1 >>> 0x20 - arg2 & -arg2 >> 0x1F;
    }
}

