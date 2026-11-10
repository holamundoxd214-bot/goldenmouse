package kotlin;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u0016\u0010\u0003\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u0016\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u0016\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u0016\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u000E\u0010\u0007\u001A\u00020\u0001*\u00020\u0001H\u0087\u008A\u0004\u001A\u000E\u0010\b\u001A\u00020\u0001*\u00020\u0001H\u0087\u008A\u0004\u001A\u000E\u0010\t\u001A\u00020\u0001*\u00020\u0001H\u0087\u008A\u0004\u001A\u000E\u0010\n\u001A\u00020\u0001*\u00020\u000BH\u0087\u0088\u0004\u001A\u0016\u0010\n\u001A\u00020\u0001*\u00020\u000B2\u0006\u0010\f\u001A\u00020\rH\u0087\u0088\u0004\u001A\u000E\u0010\n\u001A\u00020\u0001*\u00020\u000EH\u0087\u0088\u0004\u001A\u0016\u0010\n\u001A\u00020\u0001*\u00020\u000E2\u0006\u0010\f\u001A\u00020\rH\u0087\u0088\u0004\u001A\u000E\u0010\n\u001A\u00020\u0001*\u00020\u000FH\u0087\u0088\u0004\u001A\u0016\u0010\n\u001A\u00020\u0001*\u00020\u000F2\u0006\u0010\f\u001A\u00020\rH\u0087\u0088\u0004\u001A\u000E\u0010\n\u001A\u00020\u0001*\u00020\u0010H\u0087\u0088\u0004\u001A\u0016\u0010\n\u001A\u00020\u0001*\u00020\u00102\u0006\u0010\f\u001A\u00020\rH\u0087\u0088\u0004¨\u0006\u0011"}, d2={"plus", "Ljava/math/BigDecimal;", "other", "minus", "times", "div", "rem", "unaryMinus", "inc", "dec", "toBigDecimal", "", "mathContext", "Ljava/math/MathContext;", "", "", "", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/NumbersKt") class NumbersKt__BigDecimalsKt {
    public NumbersKt__BigDecimalsKt() {
        super();
    }

    private static final BigDecimal dec(BigDecimal arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.subtract(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(arg1, "subtract(...)");
        return arg1;
    }

    private static final BigDecimal div(BigDecimal arg1, BigDecimal arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.divide(arg2, RoundingMode.HALF_EVEN);
        Intrinsics.checkNotNullExpressionValue(arg1, "divide(...)");
        return arg1;
    }

    private static final BigDecimal inc(BigDecimal arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.add(BigDecimal.ONE);
        Intrinsics.checkNotNullExpressionValue(arg1, "add(...)");
        return arg1;
    }

    private static final BigDecimal minus(BigDecimal arg1, BigDecimal arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.subtract(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "subtract(...)");
        return arg1;
    }

    private static final BigDecimal plus(BigDecimal arg1, BigDecimal arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.add(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "add(...)");
        return arg1;
    }

    private static final BigDecimal rem(BigDecimal arg1, BigDecimal arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.remainder(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "remainder(...)");
        return arg1;
    }

    private static final BigDecimal times(BigDecimal arg1, BigDecimal arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.multiply(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "multiply(...)");
        return arg1;
    }

    private static final BigDecimal toBigDecimal(double arg1) {
        return new BigDecimal(String.valueOf(arg1));
    }

    private static final BigDecimal toBigDecimal(double arg1, MathContext arg3) {
        Intrinsics.checkNotNullParameter(arg3, "mathContext");
        return new BigDecimal(String.valueOf(arg1), arg3);
    }

    private static final BigDecimal toBigDecimal(float arg1) {
        return new BigDecimal(String.valueOf(arg1));
    }

    private static final BigDecimal toBigDecimal(float arg1, MathContext arg2) {
        Intrinsics.checkNotNullParameter(arg2, "mathContext");
        return new BigDecimal(String.valueOf(arg1), arg2);
    }

    private static final BigDecimal toBigDecimal(int arg2) {
        BigDecimal v2 = BigDecimal.valueOf(((long)arg2));
        Intrinsics.checkNotNullExpressionValue(v2, "valueOf(...)");
        return v2;
    }

    private static final BigDecimal toBigDecimal(int arg1, MathContext arg2) {
        Intrinsics.checkNotNullParameter(arg2, "mathContext");
        return new BigDecimal(arg1, arg2);
    }

    private static final BigDecimal toBigDecimal(long arg0) {
        BigDecimal v0 = BigDecimal.valueOf(arg0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        return v0;
    }

    private static final BigDecimal toBigDecimal(long arg1, MathContext arg3) {
        Intrinsics.checkNotNullParameter(arg3, "mathContext");
        return new BigDecimal(arg1, arg3);
    }

    private static final BigDecimal unaryMinus(BigDecimal arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.negate();
        Intrinsics.checkNotNullExpressionValue(arg1, "negate(...)");
        return arg1;
    }
}

