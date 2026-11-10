package kotlin.text;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000B\n\u0000\n\u0002\u0010\f\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A\u0016\u0010\u0000\u001A\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001A\u00020\u0004H\u0087\u0088\u0004\u001A\u0014\u0010\u0005\u001A\b\u0012\u0004\u0012\u00020\u00010\u0006*\u00020\u0002H\u0086\u0080\u0004\u001A\u0015\u0010\u0007\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001A<\u0010\t\u001A\u0004\u0018\u00010\u0001\"\u000E\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000B*\u00020\u00022\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\n0\rH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u000E\u001A1\u0010\u000F\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u001A\u0010\u0010\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010\u0011j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0012H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0013\u001A\u0015\u0010\u0014\u001A\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\b\u001A<\u0010\u0015\u001A\u0004\u0018\u00010\u0001\"\u000E\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000B*\u00020\u00022\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H\n0\rH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u000E\u001A1\u0010\u0016\u001A\u0004\u0018\u00010\u0001*\u00020\u00022\u001A\u0010\u0010\u001A\u0016\u0012\u0006\b\u0000\u0012\u00020\u00010\u0011j\n\u0012\u0006\b\u0000\u0012\u00020\u0001`\u0012H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0013\u001A*\u0010\u0017\u001A\u00020\u0018*\u00020\u00022\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00180\rH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b\u0019\u001A*\u0010\u0017\u001A\u00020\u001A*\u00020\u00022\u0012\u0010\f\u001A\u000E\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u001A0\rH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b\u001B\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001C"}, d2={"elementAt", "", "", "index", "", "toSortedSet", "Ljava/util/SortedSet;", "max", "(Ljava/lang/CharSequence;)Ljava/lang/Character;", "maxBy", "R", "", "selector", "Lkotlin/Function1;", "(Ljava/lang/CharSequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Character;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/lang/CharSequence;Ljava/util/Comparator;)Ljava/lang/Character;", "min", "minBy", "minWith", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/text/StringsKt") class StringsKt___StringsJvmKt extends StringsKt__StringsKt {
    public StringsKt___StringsJvmKt() {
        super();
    }

    private static final char elementAt(CharSequence arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.charAt(arg2);
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Character max(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.maxOrNull(arg1);
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Character maxBy(CharSequence arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "selector");
        if(arg7.length() == 0) {
            return null;
        }

        char v0 = arg7.charAt(0);
        int v1 = StringsKt.getLastIndex(arg7);
        if(v1 == 0) {
            return Character.valueOf(v0);
        }

        Object v2 = arg8.invoke(Character.valueOf(v0));
        int v3 = 1;
        if(1 <= v1) {
            while(true) {
                char v4 = arg7.charAt(v3);
                Object v5 = arg8.invoke(Character.valueOf(v4));
                if(((Comparable)v2).compareTo(v5) < 0) {
                    v0 = v4;
                    v2 = v5;
                }

                if(v3 == v1) {
                    break;
                }

                ++v3;
            }
        }

        return Character.valueOf(v0);
    }

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Character maxWith(CharSequence arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return StringsKt.maxWithOrNull(arg1, arg2);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Character min(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.minOrNull(arg1);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Character minBy(CharSequence arg7, Function1 arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "selector");
        if(arg7.length() == 0) {
            return null;
        }

        char v0 = arg7.charAt(0);
        int v1 = StringsKt.getLastIndex(arg7);
        if(v1 == 0) {
            return Character.valueOf(v0);
        }

        Object v2 = arg8.invoke(Character.valueOf(v0));
        int v3 = 1;
        if(1 <= v1) {
            while(true) {
                char v4 = arg7.charAt(v3);
                Object v5 = arg8.invoke(Character.valueOf(v4));
                if(((Comparable)v2).compareTo(v5) > 0) {
                    v0 = v4;
                    v2 = v5;
                }

                if(v3 == v1) {
                    break;
                }

                ++v3;
            }
        }

        return Character.valueOf(v0);
    }

    @Deprecated(message="Use minWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Character minWith(CharSequence arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return StringsKt.minWithOrNull(arg1, arg2);
    }

    private static final BigDecimal sumOfBigDecimal(CharSequence arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "selector");
        BigDecimal v0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1;
        for(v1 = 0; v1 < arg3.length(); ++v1) {
            v0 = v0.add(arg4.invoke(Character.valueOf(arg3.charAt(v1))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    private static final BigInteger sumOfBigInteger(CharSequence arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "selector");
        BigInteger v0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        int v1;
        for(v1 = 0; v1 < arg3.length(); ++v1) {
            v0 = v0.add(arg4.invoke(Character.valueOf(arg3.charAt(v1))));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    public static final SortedSet toSortedSet(CharSequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return StringsKt.toCollection(arg1, new TreeSet());
    }
}

