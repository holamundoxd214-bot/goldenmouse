package kotlin;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000E\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u0016\u0010\u0003\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u0016\u0010\u0004\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u0016\u0010\u0005\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u0016\u0010\u0006\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008A\u0004\u001A\u000E\u0010\u0007\u001A\u00020\u0001*\u00020\u0001H\u0087\u008A\u0004\u001A\u000E\u0010\b\u001A\u00020\u0001*\u00020\u0001H\u0087\u008A\u0004\u001A\u000E\u0010\t\u001A\u00020\u0001*\u00020\u0001H\u0087\u008A\u0004\u001A\u000E\u0010\n\u001A\u00020\u0001*\u00020\u0001H\u0087\u0088\u0004\u001A\u0016\u0010\u000B\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008C\u0004\u001A\u0016\u0010\f\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008C\u0004\u001A\u0016\u0010\r\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001A\u00020\u0001H\u0087\u008C\u0004\u001A\u0016\u0010\u000E\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0010H\u0087\u008C\u0004\u001A\u0016\u0010\u0011\u001A\u00020\u0001*\u00020\u00012\u0006\u0010\u000F\u001A\u00020\u0010H\u0087\u008C\u0004\u001A\u000E\u0010\u0012\u001A\u00020\u0001*\u00020\u0010H\u0087\u0088\u0004\u001A\u000E\u0010\u0012\u001A\u00020\u0001*\u00020\u0013H\u0087\u0088\u0004\u001A\u000E\u0010\u0014\u001A\u00020\u0015*\u00020\u0001H\u0087\u0088\u0004\u001A\"\u0010\u0014\u001A\u00020\u0015*\u00020\u00012\b\b\u0002\u0010\u0016\u001A\u00020\u00102\b\b\u0002\u0010\u0017\u001A\u00020\u0018H\u0087\u0088\u0004¨\u0006\u0019"}, d2={"plus", "Ljava/math/BigInteger;", "other", "minus", "times", "div", "rem", "unaryMinus", "inc", "dec", "inv", "and", "or", "xor", "shl", "n", "", "shr", "toBigInteger", "", "toBigDecimal", "Ljava/math/BigDecimal;", "scale", "mathContext", "Ljava/math/MathContext;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/NumbersKt") class NumbersKt__BigIntegersKt extends NumbersKt__BigDecimalsKt {
    public NumbersKt__BigIntegersKt() {
        super();
    }

    private static final BigInteger and(BigInteger arg1, BigInteger arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.and(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "and(...)");
        return arg1;
    }

    private static final BigInteger dec(BigInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.subtract(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(arg1, "subtract(...)");
        return arg1;
    }

    private static final BigInteger div(BigInteger arg1, BigInteger arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.divide(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "divide(...)");
        return arg1;
    }

    private static final BigInteger inc(BigInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.add(BigInteger.ONE);
        Intrinsics.checkNotNullExpressionValue(arg1, "add(...)");
        return arg1;
    }

    private static final BigInteger inv(BigInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.not();
        Intrinsics.checkNotNullExpressionValue(arg1, "not(...)");
        return arg1;
    }

    private static final BigInteger minus(BigInteger arg1, BigInteger arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.subtract(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "subtract(...)");
        return arg1;
    }

    private static final BigInteger or(BigInteger arg1, BigInteger arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.or(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "or(...)");
        return arg1;
    }

    private static final BigInteger plus(BigInteger arg1, BigInteger arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.add(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "add(...)");
        return arg1;
    }

    private static final BigInteger rem(BigInteger arg1, BigInteger arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.remainder(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "remainder(...)");
        return arg1;
    }

    private static final BigInteger shl(BigInteger arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.shiftLeft(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "shiftLeft(...)");
        return arg1;
    }

    private static final BigInteger shr(BigInteger arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.shiftRight(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "shiftRight(...)");
        return arg1;
    }

    private static final BigInteger times(BigInteger arg1, BigInteger arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.multiply(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "multiply(...)");
        return arg1;
    }

    private static final BigDecimal toBigDecimal(BigInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new BigDecimal(arg1);
    }

    private static final BigDecimal toBigDecimal(BigInteger arg1, int arg2, MathContext arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "mathContext");
        return new BigDecimal(arg1, arg2, arg3);
    }

    static BigDecimal toBigDecimal$default(BigInteger arg0, int arg1, MathContext arg2, int arg3, Object arg4) {
        if((arg3 & 2) != 0) {
            arg2 = MathContext.UNLIMITED;
            Intrinsics.checkNotNullExpressionValue(arg2, "UNLIMITED");
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "mathContext");
        return new BigDecimal(arg0, 0, arg2);
    }

    private static final BigInteger toBigInteger(int arg2) {
        BigInteger v2 = BigInteger.valueOf(((long)arg2));
        Intrinsics.checkNotNullExpressionValue(v2, "valueOf(...)");
        return v2;
    }

    private static final BigInteger toBigInteger(long arg0) {
        BigInteger v0 = BigInteger.valueOf(arg0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        return v0;
    }

    private static final BigInteger unaryMinus(BigInteger arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        arg1 = arg1.negate();
        Intrinsics.checkNotNullExpressionValue(arg1, "negate(...)");
        return arg1;
    }

    private static final BigInteger xor(BigInteger arg1, BigInteger arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "other");
        arg1 = arg1.xor(arg2);
        Intrinsics.checkNotNullExpressionValue(arg1, "xor(...)");
        return arg1;
    }
}

