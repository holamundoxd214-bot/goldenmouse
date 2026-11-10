package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000*\n\u0000\n\u0002\u0010\u001C\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A/\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\u0088\u0004ø\u0001\u0000\u001A!\u0010\u0006\u001A\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0081\u0080\u0004¢\u0006\u0002\u0010\b\u001A\"\u0010\t\u001A\u00020\u0007\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\n\u001A\u00020\u0007H\u0081\u0080\u0004\u001A&\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\f\"\u0004\b\u0000\u0010\u0002*\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001H\u0086\u0080\u0004\u001AD\u0010\r\u001A\u001A\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000F0\f0\u000E\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u000F*\u0014\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u000F0\u000E0\u0001H\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2={"Iterable", "", "T", "iterator", "Lkotlin/Function0;", "", "collectionSizeOrNull", "", "(Ljava/lang/Iterable;)Ljava/lang/Integer;", "collectionSizeOrDefault", "default", "flatten", "", "unzip", "Lkotlin/Pair;", "R", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/CollectionsKt") class CollectionsKt__IterablesKt extends CollectionsKt__CollectionsKt {
    public CollectionsKt__IterablesKt() {
        super();
    }

    private static final Iterable Iterable(Function0 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "iterator");
        return new CollectionsKt__IterablesKt$Iterable$1(arg1);
    }

    public static final int collectionSizeOrDefault(Iterable arg1, int arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof Collection)) {
            return ((Collection)arg1).size();
        }

        return arg2;
    }

    public static final Integer collectionSizeOrNull(Iterable arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        if((arg1 instanceof Collection)) {
            return Integer.valueOf(((Collection)arg1).size());
        }

        return null;
    }

    public static final List flatten(Iterable arg3) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        ArrayList v0 = new ArrayList();
        Iterator v3 = arg3.iterator();
        while(v3.hasNext()) {
            CollectionsKt.addAll(v0, v3.next());
        }

        return ((List)v0);
    }

    public static final Pair unzip(Iterable arg4) {
        Intrinsics.checkNotNullParameter(arg4, "<this>");
        int v0 = CollectionsKt.collectionSizeOrDefault(arg4, 10);
        ArrayList v1 = new ArrayList(v0);
        ArrayList v2 = new ArrayList(v0);
        Iterator v4 = arg4.iterator();
        while(v4.hasNext()) {
            Object v0_1 = v4.next();
            v1.add(((Pair)v0_1).getFirst());
            v2.add(((Pair)v0_1).getSecond());
        }

        return TuplesKt.to(v1, v2);
    }
}

