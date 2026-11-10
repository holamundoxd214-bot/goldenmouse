package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map$Entry;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1={"\u0000&\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010&\n\u0000\u001A2\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\u0080\u0004\u001A[\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\b0\u0007\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\t\"\u0004\b\u0002\u0010\b*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\u00072\u001E\u0010\n\u001A\u001A\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\t0\f\u0012\u0004\u0012\u0002H\b0\u000BH\u0081\u0088\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2={"eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/GroupingKt") class GroupingKt__GroupingJVMKt {
    public GroupingKt__GroupingJVMKt() {
        super();
    }

    public static final Map eachCount(Grouping arg6) {
        IntRef v3_1;
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v1 = arg6.sourceIterator();
        while(v1.hasNext()) {
            Object v2 = arg6.keyOf(v1.next());
            Object v3 = ((Map)v0).get(v2);
            int v5 = v3 != null || (((Map)v0).containsKey(v2)) ? 0 : 1;
            if(v5 != 0) {
                v3_1 = new IntRef();
            }

            ++v3_1.element;
            ((Map)v0).put(v2, v3_1);
        }

        Iterator v6 = ((Map)v0).entrySet().iterator();
        while(v6.hasNext()) {
            Object v1_1 = v6.next();
            Intrinsics.checkNotNull(v1_1, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            TypeIntrinsics.asMutableMapEntry(v1_1).setValue(Integer.valueOf(((Map$Entry)v1_1).getValue().element));
        }

        return TypeIntrinsics.asMutableMap(v0);
    }

    private static final Map mapValuesInPlace(Map arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg3, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "f");
        Iterator v0 = arg3.entrySet().iterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Intrinsics.checkNotNull(v1, "null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace, R of kotlin.collections.GroupingKt__GroupingJVMKt.mapValuesInPlace>");
            TypeIntrinsics.asMutableMapEntry(v1).setValue(arg4.invoke(v1));
        }

        return TypeIntrinsics.asMutableMap(arg3);
    }
}

