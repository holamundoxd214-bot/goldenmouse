package kotlin.ranges;

import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000F\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000B\n\u0000\n\u0002\u0010\u001C\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0004\n\u0000\u001A1\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001A\u0002H\u0002H\u0086\u0082\u0004¢\u0006\u0002\u0010\u0005\u001A1\u0010\u0006\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0007\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003*\u0002H\u00022\u0006\u0010\u0004\u001A\u0002H\u0002H\u0087\u0082\u0004¢\u0006\u0002\u0010\b\u001A\u001C\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\n0\t*\u00020\n2\u0006\u0010\u0004\u001A\u00020\nH\u0087\u0082\u0004\u001A\u001C\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\n0\u0007*\u00020\n2\u0006\u0010\u0004\u001A\u00020\nH\u0087\u0082\u0004\u001A\u001C\u0010\u0000\u001A\b\u0012\u0004\u0012\u00020\u000B0\t*\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u000BH\u0087\u0082\u0004\u001A\u001C\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u000B0\u0007*\u00020\u000B2\u0006\u0010\u0004\u001A\u00020\u000BH\u0087\u0082\u0004\u001AG\u0010\f\u001A\u00020\r\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0018\b\u0001\u0010\u000E*\b\u0012\u0004\u0012\u0002H\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u000F*\u0002H\u000E2\b\u0010\u0010\u001A\u0004\u0018\u0001H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010\u0011\u001AA\u0010\f\u001A\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u0012\"\u0018\b\u0001\u0010\u000E*\b\u0012\u0004\u0012\u0002H\u00020\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u000F*\u0002H\u000E2\b\u0010\u0010\u001A\u0004\u0018\u0001H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010\u0013\u001AG\u0010\f\u001A\u00020\r\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0018\b\u0001\u0010\u000E*\b\u0012\u0004\u0012\u0002H\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u000F*\u0002H\u000E2\b\u0010\u0010\u001A\u0004\u0018\u0001H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010\u0014\u001AA\u0010\f\u001A\u00020\r\"\b\b\u0000\u0010\u0002*\u00020\u0012\"\u0018\b\u0001\u0010\u000E*\b\u0012\u0004\u0012\u0002H\u00020\u0007*\b\u0012\u0004\u0012\u0002H\u00020\u000F*\u0002H\u000E2\b\u0010\u0010\u001A\u0004\u0018\u0001H\u0002H\u0087\u008A\u0004¢\u0006\u0002\u0010\u0015\u001A\u001A\u0010\u0016\u001A\u00020\u00172\u0006\u0010\u0018\u001A\u00020\r2\u0006\u0010\u0019\u001A\u00020\u001AH\u0080\u0080\u0004¨\u0006\u001B"}, d2={"rangeTo", "Lkotlin/ranges/ClosedRange;", "T", "", "that", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/ClosedRange;", "rangeUntil", "Lkotlin/ranges/OpenEndRange;", "(Ljava/lang/Comparable;Ljava/lang/Comparable;)Lkotlin/ranges/OpenEndRange;", "Lkotlin/ranges/ClosedFloatingPointRange;", "", "", "contains", "", "R", "", "element", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Comparable;)Z", "", "(Lkotlin/ranges/ClosedRange;Ljava/lang/Object;)Z", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Comparable;)Z", "(Lkotlin/ranges/OpenEndRange;Ljava/lang/Object;)Z", "checkStepIsPositive", "", "isPositive", "step", "", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/ranges/RangesKt") class RangesKt__RangesKt {
    public RangesKt__RangesKt() {
        super();
    }

    public static final void checkStepIsPositive(boolean arg2, Number arg3) {
        Intrinsics.checkNotNullParameter(arg3, "step");
        if(arg2) {
            return;
        }

        throw new IllegalArgumentException("Step must be positive, was: " + arg3 + '.');
    }

    private static final boolean contains(ClosedRange arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 != null && (arg1.contains(arg2))) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="The signature violates type safety guarantees") @DeprecatedSinceKotlin(hiddenSince="2.3") private static final boolean contains(ClosedRange arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 != null && (arg1.contains(((Comparable)arg2)))) {
            return 1;
        }

        return 0;
    }

    private static final boolean contains(OpenEndRange arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 != null && (arg1.contains(arg2))) {
            return 1;
        }

        return 0;
    }

    @Deprecated(message="The signature violates type safety guarantees") @DeprecatedSinceKotlin(hiddenSince="2.3") private static final boolean contains(OpenEndRange arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if(arg2 != null && (arg1.contains(((Comparable)arg2)))) {
            return 1;
        }

        return 0;
    }

    public static final ClosedFloatingPointRange rangeTo(double arg1, double arg3) {
        return new ClosedDoubleRange(arg1, arg3);
    }

    public static final ClosedFloatingPointRange rangeTo(float arg1, float arg2) {
        return new ClosedFloatRange(arg1, arg2);
    }

    public static final ClosedRange rangeTo(Comparable arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "that");
        return new ComparableRange(arg1, arg2);
    }

    public static final OpenEndRange rangeUntil(double arg1, double arg3) {
        return new OpenEndDoubleRange(arg1, arg3);
    }

    public static final OpenEndRange rangeUntil(float arg1, float arg2) {
        return new OpenEndFloatRange(arg1, arg2);
    }

    public static final OpenEndRange rangeUntil(Comparable arg1, Comparable arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "that");
        return new ComparableOpenEndRange(arg1, arg2);
    }
}

