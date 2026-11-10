package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u000F\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001A6\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001A\u0010\u0004\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0005j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0006H\u0087\u0088\u0004\u001A7\u0010\u0000\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0018\u0010\u0007\u001A\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\t0\bH\u0087\u0088\u0004ø\u0001\u0000\u001A$\u0010\u0000\u001A\u00020\u0001\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\n*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0086\u0080\u0004\u001A6\u0010\u000B\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u001A\u0010\u0004\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0005j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u0006H\u0086\u0080\u0004\u001A\'\u0010\f\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\r\u001A\u0002H\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\u000E\u001A\u001A\u0010\u000F\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0087\u0088\u0004\u001A\"\u0010\u000F\u001A\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0010\u001A\u00020\u0011H\u0087\u0088\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2={"sort", "", "T", "", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "comparison", "Lkotlin/Function2;", "", "", "sortWith", "fill", "value", "(Ljava/util/List;Ljava/lang/Object;)V", "shuffle", "random", "Ljava/util/Random;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/CollectionsKt") class CollectionsKt__MutableCollectionsJVMKt extends CollectionsKt__IteratorsKt {
    public CollectionsKt__MutableCollectionsJVMKt() {
        super();
    }

    private static final void fill(List arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Collections.fill(arg1, arg2);
    }

    private static final void shuffle(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Collections.shuffle(arg1);
    }

    private static final void shuffle(List arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        Collections.shuffle(arg1, arg2);
    }

    public static final void sort(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        if(arg2.size() > 1) {
            Collections.sort(arg2);
        }
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use sortWith(comparator) instead.", replaceWith="<_subannotation>") private static final void sort(List arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        throw new NotImplementedError(null, 1, null);
    }

    @Deprecated(level=DeprecationLevel.ERROR, message="Use sortWith(Comparator(comparison)) instead.", replaceWith="<_subannotation>") private static final void sort(List arg1, Function2 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparison");
        throw new NotImplementedError(null, 1, null);
    }

    public static final void sortWith(List arg2, Comparator arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "comparator");
        if(arg2.size() > 1) {
            Collections.sort(arg2, arg3);
        }
    }
}

