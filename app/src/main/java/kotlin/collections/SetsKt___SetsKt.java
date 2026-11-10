package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u001C\n\u0002\u0018\u0002\n\u0002\b\u0004\u001A-\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001A\u0002H\u0002H\u0086\u0082\u0004¢\u0006\u0002\u0010\u0004\u001A5\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000E\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0082\u0004¢\u0006\u0002\u0010\u0007\u001A.\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0082\u0004\u001A.\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0082\u0004\u001A-\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001A\u0002H\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0004\u001A-\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001A\u0002H\u0002H\u0086\u0082\u0004¢\u0006\u0002\u0010\u0004\u001A5\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u000E\u0010\u0005\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0006H\u0086\u0082\u0004¢\u0006\u0002\u0010\u0007\u001A.\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\bH\u0086\u0082\u0004\u001A.\u0010\u000B\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086\u0082\u0004\u001A-\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0003\u001A\u0002H\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0004¨\u0006\r"}, d2={"minus", "", "T", "element", "(Ljava/util/Set;Ljava/lang/Object;)Ljava/util/Set;", "elements", "", "(Ljava/util/Set;[Ljava/lang/Object;)Ljava/util/Set;", "", "Lkotlin/sequences/Sequence;", "minusElement", "plus", "plusElement", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/SetsKt") class SetsKt___SetsKt extends SetsKt__SetsKt {
    public SetsKt___SetsKt() {
        super();
    }

    public static final Set minus(Set arg3, Iterable arg4) {
        LinkedHashSet v0;
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "elements");
        Collection v4 = CollectionsKt.convertToListIfNotCollection(arg4);
        if(v4.isEmpty()) {
            return CollectionsKt.toSet(((Iterable)arg3));
        }

        if((v4 instanceof Set)) {
            v0 = new LinkedHashSet();
            Iterator v3 = ((Iterable)arg3).iterator();
            while(v3.hasNext()) {
                Object v1 = v3.next();
                if(v4.contains(v1)) {
                    continue;
                }

                ((Collection)v0).add(v1);
            }

            return ((Set)v0);
        }

        v0 = new LinkedHashSet(((Collection)arg3));
        v0.removeAll(v4);
        return ((Set)v0);
    }

    public static final Set minus(Set arg6, Object arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        LinkedHashSet v0 = new LinkedHashSet(MapsKt.mapCapacity(arg6.size()));
        Iterator v6 = ((Iterable)arg6).iterator();
        int v2 = 0;
        while(v6.hasNext()) {
            Object v3 = v6.next();
            int v4 = 1;
            if(v2 == 0 && (Intrinsics.areEqual(v3, arg7))) {
                v2 = 1;
                v4 = 0;
            }

            if(v4 == 0) {
                continue;
            }

            ((Collection)v0).add(v3);
        }

        return ((Set)v0);
    }

    public static final Set minus(Set arg1, Sequence arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        LinkedHashSet v0 = new LinkedHashSet(((Collection)arg1));
        CollectionsKt.removeAll(v0, arg2);
        return ((Set)v0);
    }

    public static final Set minus(Set arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        LinkedHashSet v0 = new LinkedHashSet(((Collection)arg1));
        CollectionsKt.removeAll(v0, arg2);
        return ((Set)v0);
    }

    private static final Set minusElement(Set arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SetsKt.minus(arg1, arg2);
    }

    public static final Set plus(Set arg2, Iterable arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "elements");
        Integer v0 = CollectionsKt.collectionSizeOrNull(arg3);
        int v1 = v0 != null ? arg2.size() + ((Number)v0).intValue() : arg2.size() * 2;
        LinkedHashSet v1_1 = new LinkedHashSet(MapsKt.mapCapacity(v1));
        v1_1.addAll(((Collection)arg2));
        CollectionsKt.addAll(v1_1, arg3);
        return ((Set)v1_1);
    }

    public static final Set plus(Set arg2, Object arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        LinkedHashSet v0 = new LinkedHashSet(MapsKt.mapCapacity(arg2.size() + 1));
        v0.addAll(((Collection)arg2));
        v0.add(arg3);
        return ((Set)v0);
    }

    public static final Set plus(Set arg2, Sequence arg3) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "elements");
        LinkedHashSet v0 = new LinkedHashSet(MapsKt.mapCapacity(arg2.size() * 2));
        v0.addAll(((Collection)arg2));
        CollectionsKt.addAll(v0, arg3);
        return ((Set)v0);
    }

    public static final Set plus(Set arg3, Object[] arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "elements");
        LinkedHashSet v0 = new LinkedHashSet(MapsKt.mapCapacity(arg3.size() + arg4.length));
        v0.addAll(((Collection)arg3));
        CollectionsKt.addAll(v0, arg4);
        return ((Set)v0);
    }

    private static final Set plusElement(Set arg1, Object arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return SetsKt.plus(arg1, arg2);
    }
}

