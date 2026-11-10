package kotlin.collections;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecatedSinceKotlin;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000(\n\u0000\n\u0002\u0010&\n\u0002\b\u0003\n\u0002\u0010\u000F\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001Ai\u0010\u0000\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u001E\u0010\u0007\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0004\u0012\u0002H\u00040\bH\u0087\u0088\u0004ø\u0001\u0000\u001Aj\u0010\t\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000622\u0010\n\u001A.\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\u000Bj\u0016\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001`\fH\u0087\u0088\u0004\u001Ai\u0010\r\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003\"\u000E\b\u0002\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0005*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00062\u001E\u0010\u0007\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\u0012\u0004\u0012\u0002H\u00040\bH\u0087\u0088\u0004ø\u0001\u0000\u001Aj\u0010\u000E\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0003\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u000622\u0010\n\u001A.\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00010\u000Bj\u0016\u0012\u0012\b\u0000\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001`\fH\u0087\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000F"}, d2={"maxBy", "", "K", "V", "R", "", "", "selector", "Lkotlin/Function1;", "maxWith", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "minBy", "minWith", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/MapsKt") class MapsKt___MapsJvmKt extends MapsKt__MapsKt {
    public MapsKt___MapsJvmKt() {
        super();
    }

    @Deprecated(message="Use maxByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final Map$Entry maxBy(Map arg5, Function1 arg6) {
        Map$Entry v5_1;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        Iterator v5 = arg5.entrySet().iterator();
        if(!v5.hasNext()) {
            v5_1 = null;
        }
        else {
            Object v0 = v5.next();
            if(v5.hasNext()) {
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
            }

            Object v5_2 = v0;
        }

        return v5_1;
    }

    @Deprecated(message="Use maxWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") private static final Map$Entry maxWith(Map arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return CollectionsKt.maxWithOrNull(arg1.entrySet(), arg2);
    }

    @Deprecated(message="Use minByOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Map$Entry minBy(Map arg5, Function1 arg6) {
        Map$Entry v5_1;
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "selector");
        Iterator v5 = arg5.entrySet().iterator();
        if(!v5.hasNext()) {
            v5_1 = null;
        }
        else {
            Object v0 = v5.next();
            if(v5.hasNext()) {
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
            }

            Object v5_2 = v0;
        }

        return v5_1;
    }

    @Deprecated(message="Use minWithOrNull instead.", replaceWith="<_subannotation>") @DeprecatedSinceKotlin(errorSince="1.5", hiddenSince="1.6", warningSince="1.4") public static final Map$Entry minWith(Map arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        return CollectionsKt.minWithOrNull(arg1.entrySet(), arg2);
    }
}

