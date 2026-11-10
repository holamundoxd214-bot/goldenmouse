package kotlin.sequences;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001F\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A,\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0086\u0080\u0004\u001AE\u0010\u0005\u001A\u0002H\u0006\"\u0010\b\u0000\u0010\u0006*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0007\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010\b\u001A\u0002H\u00062\f\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\u0080\b¢\u0006\u0002\u0010\t\u001A*\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\u000B\"\u000E\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r*\b\u0012\u0004\u0012\u0002H\f0\u0001H\u0086\u0080\u0004\u001A<\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\f0\u000B\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001A\u0010\u000E\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u000Fj\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0010H\u0086\u0080\u0004\u001A\u001B\u0010\u0011\u001A\u0004\u0018\u00010\u0012*\b\u0012\u0004\u0012\u00020\u00120\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0013\u001A\u001B\u0010\u0011\u001A\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u00020\u00140\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0015\u001A+\u0010\u0011\u001A\u0004\u0018\u0001H\f\"\u000E\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r*\b\u0012\u0004\u0012\u0002H\f0\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0016\u001AH\u0010\u0017\u001A\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f\"\u000E\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00020\u0019H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001A\u001A=\u0010\u001B\u001A\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001A\u0010\u000E\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u000Fj\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0010H\u0087\u0080\u0004¢\u0006\u0002\u0010\u001C\u001A\u001B\u0010\u001D\u001A\u0004\u0018\u00010\u0012*\b\u0012\u0004\u0012\u00020\u00120\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0013\u001A\u001B\u0010\u001D\u001A\u0004\u0018\u00010\u0014*\b\u0012\u0004\u0012\u00020\u00140\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0015\u001A+\u0010\u001D\u001A\u0004\u0018\u0001H\f\"\u000E\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\r*\b\u0012\u0004\u0012\u0002H\f0\u0001H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0016\u001AH\u0010\u001E\u001A\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f\"\u000E\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\r*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u00020\u0019H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001A\u001A=\u0010\u001F\u001A\u0004\u0018\u0001H\f\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u001A\u0010\u000E\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\f0\u000Fj\n\u0012\u0006\b\u0000\u0012\u0002H\f`\u0010H\u0087\u0080\u0004¢\u0006\u0002\u0010\u001C\u001A6\u0010 \u001A\u00020!\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020!0\u0019H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b\"\u001A6\u0010 \u001A\u00020#\"\u0004\b\u0000\u0010\f*\b\u0012\u0004\u0012\u0002H\f0\u00012\u0012\u0010\u0018\u001A\u000E\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020#0\u0019H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b$\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006%"}, d2={"filterIsInstance", "Lkotlin/sequences/Sequence;", "R", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Lkotlin/sequences/Sequence;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "toSortedSet", "Ljava/util/SortedSet;", "T", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "max", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Double;", "", "(Lkotlin/sequences/Sequence;)Ljava/lang/Float;", "(Lkotlin/sequences/Sequence;)Ljava/lang/Comparable;", "maxBy", "selector", "Lkotlin/Function1;", "(Lkotlin/sequences/Sequence;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxWith", "(Lkotlin/sequences/Sequence;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/sequences/SequencesKt") class SequencesKt___SequencesJvmKt extends SequencesKt__SequencesKt {
    public static boolean $r8$lambda$WeyGZ8R6LXB0qgrMNVCUE2jdcHA(Class arg0, Object arg1) {
        return SequencesKt___SequencesJvmKt.filterIsInstance$lambda$0$SequencesKt___SequencesJvmKt(arg0, arg1);
    }

    public SequencesKt___SequencesJvmKt() {
        super();
    }

    public static final Sequence filterIsInstance(Sequence arg1, Class arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "klass");
        arg1 = SequencesKt.filter(arg1, new SequencesKt___SequencesJvmKt$$ExternalSyntheticLambda0(arg2));
        Intrinsics.checkNotNull(arg1, "null cannot be cast to non-null type kotlin.sequences.Sequence<R of kotlin.sequences.SequencesKt___SequencesJvmKt.filterIsInstance>");
        return arg1;
    }

    private static final boolean filterIsInstance$lambda$0$SequencesKt___SequencesJvmKt(Class arg0, Object arg1) {
        return arg0.isInstance(arg1);
    }

    @IgnorableReturnValue public static final Collection filterIsInstanceTo(Sequence arg2, Collection arg3, Class arg4) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "destination");
        Intrinsics.checkNotNullParameter(arg4, "klass");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            Object v0 = v2.next();
            if(!arg4.isInstance(v0)) {
                continue;
            }

            arg3.add(v0);
        }

        return arg3;
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Comparable max(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.maxOrNull(arg1);
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Double max(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.maxOrNull(arg1);
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Float max(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.maxOrNull(arg1);
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Object maxBy(Sequence arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        Iterator v5 = arg5.iterator();
        if(!v5.hasNext()) {
            return null;
        }

        Object v0 = v5.next();
        if(!v5.hasNext()) {
            return v0;
        }

        Object v1 = arg6.invoke(v0);
        do {
            Object v2 = v5.next();
            Object v3 = arg6.invoke(v2);
            if(((Comparable)v1).compareTo(v3) < 0) {
                v0 = v2;
                v1 = v3;
            }
        }
        while(v5.hasNext());

        return v0;
    }

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Object maxWith(Sequence arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return SequencesKt.maxWithOrNull(arg1, arg2);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Comparable min(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.minOrNull(arg1);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Double min(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.minOrNull(arg1);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Float min(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.minOrNull(arg1);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Object minBy(Sequence arg5, Function1 arg6) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        Iterator v5 = arg5.iterator();
        if(!v5.hasNext()) {
            return null;
        }

        Object v0 = v5.next();
        if(!v5.hasNext()) {
            return v0;
        }

        Object v1 = arg6.invoke(v0);
        do {
            Object v2 = v5.next();
            Object v3 = arg6.invoke(v2);
            if(((Comparable)v1).compareTo(v3) > 0) {
                v0 = v2;
                v1 = v3;
            }
        }
        while(v5.hasNext());

        return v0;
    }

    @Deprecated(message="Use minWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Object minWith(Sequence arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return SequencesKt.minWithOrNull(arg1, arg2);
    }

    private static final BigDecimal sumOfBigDecimal(Sequence arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "selector");
        BigDecimal v0 = BigDecimal.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            v0 = v0.add(arg3.invoke(v2.next()));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    private static final BigInteger sumOfBigInteger(Sequence arg2, Function1 arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "selector");
        BigInteger v0 = BigInteger.valueOf(0);
        Intrinsics.checkNotNullExpressionValue(v0, "valueOf(...)");
        Iterator v2 = arg2.iterator();
        while(v2.hasNext()) {
            v0 = v0.add(arg3.invoke(v2.next()));
            Intrinsics.checkNotNullExpressionValue(v0, "add(...)");
        }

        return v0;
    }

    public static final SortedSet toSortedSet(Sequence arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SequencesKt.toCollection(arg1, new TreeSet());
    }

    public static final SortedSet toSortedSet(Sequence arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return SequencesKt.toCollection(arg1, new TreeSet(arg2));
    }
}

