package kotlin.collections;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.IgnorableReturnValue;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001F\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A,\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\u0080\u0004\u001AE\u0010\u0006\u001A\u0002H\u0007\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\b\"\u0004\b\u0001\u0010\u0002*\u0006\u0012\u0002\b\u00030\u00032\u0006\u0010\t\u001A\u0002H\u00072\f\u0010\u0004\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\u0080\b¢\u0006\u0002\u0010\n\u001A\u001A\u0010\u000B\u001A\u00020\f\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u000EH\u0086\u0080\u0004\u001A*\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\r0\u0010\"\u000E\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u0011*\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0086\u0080\u0004\u001A<\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\r0\u0010\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00032\u001A\u0010\u0012\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0013j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0014H\u0086\u0080\u0004\u001A\u001B\u0010\u0015\u001A\u0004\u0018\u00010\u0016*\b\u0012\u0004\u0012\u00020\u00160\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0017\u001A\u001B\u0010\u0015\u001A\u0004\u0018\u00010\u0018*\b\u0012\u0004\u0012\u00020\u00180\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0019\u001A+\u0010\u0015\u001A\u0004\u0018\u0001H\r\"\u000E\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u0011*\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u001A\u001AH\u0010\u001B\u001A\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r\"\u000E\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011*\b\u0012\u0004\u0012\u0002H\r0\u00032\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020\u001DH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001E\u001A=\u0010\u001F\u001A\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00032\u001A\u0010\u0012\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0013j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0014H\u0087\u0080\u0004¢\u0006\u0002\u0010 \u001A\u001B\u0010!\u001A\u0004\u0018\u00010\u0016*\b\u0012\u0004\u0012\u00020\u00160\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0017\u001A\u001B\u0010!\u001A\u0004\u0018\u00010\u0018*\b\u0012\u0004\u0012\u00020\u00180\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0019\u001A+\u0010!\u001A\u0004\u0018\u0001H\r\"\u000E\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u0011*\b\u0012\u0004\u0012\u0002H\r0\u0003H\u0087\u0080\u0004¢\u0006\u0002\u0010\u001A\u001AH\u0010\"\u001A\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r\"\u000E\b\u0001\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0011*\b\u0012\u0004\u0012\u0002H\r0\u00032\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u00020\u001DH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001E\u001A=\u0010#\u001A\u0004\u0018\u0001H\r\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00032\u001A\u0010\u0012\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\r0\u0013j\n\u0012\u0006\b\u0000\u0012\u0002H\r`\u0014H\u0087\u0080\u0004¢\u0006\u0002\u0010 \u001A6\u0010$\u001A\u00020%\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00032\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020%0\u001DH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b&\u001A6\u0010$\u001A\u00020\'\"\u0004\b\u0000\u0010\r*\b\u0012\u0004\u0012\u0002H\r0\u00032\u0012\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\'0\u001DH\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\b(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2={"filterIsInstance", "", "R", "", "klass", "Ljava/lang/Class;", "filterIsInstanceTo", "C", "", "destination", "(Ljava/lang/Iterable;Ljava/util/Collection;Ljava/lang/Class;)Ljava/util/Collection;", "reverse", "", "T", "", "toSortedSet", "Ljava/util/SortedSet;", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "max", "", "(Ljava/lang/Iterable;)Ljava/lang/Double;", "", "(Ljava/lang/Iterable;)Ljava/lang/Float;", "(Ljava/lang/Iterable;)Ljava/lang/Comparable;", "maxBy", "selector", "Lkotlin/Function1;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "maxWith", "(Ljava/lang/Iterable;Ljava/util/Comparator;)Ljava/lang/Object;", "min", "minBy", "minWith", "sumOf", "Ljava/math/BigDecimal;", "sumOfBigDecimal", "Ljava/math/BigInteger;", "sumOfBigInteger", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/CollectionsKt") class CollectionsKt___CollectionsJvmKt extends CollectionsKt__ReversedViewsKt {
    public CollectionsKt___CollectionsJvmKt() {
        super();
    }

    public static final List filterIsInstance(Iterable arg1, Class arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "klass");
        return CollectionsKt.filterIsInstanceTo(arg1, new ArrayList(), arg2);
    }

    @IgnorableReturnValue public static final Collection filterIsInstanceTo(Iterable arg2, Collection arg3, Class arg4) {
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

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Comparable max(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return CollectionsKt.maxOrNull(arg1);
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Double max(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return CollectionsKt.maxOrNull(arg1);
    }

    @Deprecated(message="Use maxOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Float max(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return CollectionsKt.maxOrNull(arg1);
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Object maxBy(Iterable arg5, Function1 arg6) {
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

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Object maxWith(Iterable arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return CollectionsKt.maxWithOrNull(arg1, arg2);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Comparable min(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return CollectionsKt.minOrNull(arg1);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Double min(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return CollectionsKt.minOrNull(arg1);
    }

    @Deprecated(message="Use minOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Float min(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return CollectionsKt.minOrNull(arg1);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Object minBy(Iterable arg5, Function1 arg6) {
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

    @Deprecated(message="Use minWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Object minWith(Iterable arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return CollectionsKt.minWithOrNull(arg1, arg2);
    }

    public static final void reverse(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Collections.reverse(arg1);
    }

    private static final BigDecimal sumOfBigDecimal(Iterable arg2, Function1 arg3) {
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

    private static final BigInteger sumOfBigInteger(Iterable arg2, Function1 arg3) {
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

    public static final SortedSet toSortedSet(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return CollectionsKt.toCollection(arg1, new TreeSet());
    }

    public static final SortedSet toSortedSet(Iterable arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return CollectionsKt.toCollection(arg1, new TreeSet(arg2));
    }
}

