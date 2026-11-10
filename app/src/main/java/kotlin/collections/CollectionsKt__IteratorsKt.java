package kotlin.collections;

import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000\u001C\n\u0000\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001A \u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u008A\u0004\u001A&\u0010\u0003\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0080\u0004\u001A1\u0010\u0005\u001A\u00020\u0006\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0007\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00060\bH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\t"}, d2={"iterator", "", "T", "withIndex", "Lkotlin/collections/IndexedValue;", "forEach", "", "operation", "Lkotlin/Function1;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/CollectionsKt") class CollectionsKt__IteratorsKt extends CollectionsKt__IteratorsJVMKt {
    public CollectionsKt__IteratorsKt() {
        super();
    }

    public static final void forEach(Iterator arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "operation");
        while(arg1.hasNext()) {
            arg2.invoke(arg1.next());
        }
    }

    private static final Iterator iterator(Iterator arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1;
    }

    public static final Iterator withIndex(Iterator arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new IndexingIterator(arg1);
    }
}

