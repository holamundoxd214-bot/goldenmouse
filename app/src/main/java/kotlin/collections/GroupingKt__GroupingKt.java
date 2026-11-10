package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000@\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\u001A\u009F\u0001\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052b\u0010\u0006\u001A^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\u0088\u0004ø\u0001\u0000\u001A¸\u0001\u0010\u000F\u001A\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001A\u0002H\u00102b\u0010\u0006\u001A^\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u0001H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000E\u0012\u0004\u0012\u0002H\u00030\u0007H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u001AÀ\u0001\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u000526\u0010\u0015\u001A2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00162K\u0010\u0006\u001AG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0017H\u0087\u0088\u0004ø\u0001\u0000\u001AÙ\u0001\u0010\u0018\u001A\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001A\u0002H\u001026\u0010\u0015\u001A2\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u00162K\u0010\u0006\u001AG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0017H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001A\u0080\u0001\u0010\u0014\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u001A\u001A\u0002H\u000326\u0010\u0006\u001A2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0016H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001B\u001A\u0094\u0001\u0010\u0018\u001A\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0004\b\u0002\u0010\u0003\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0011*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001A\u0002H\u00102\u0006\u0010\u001A\u001A\u0002H\u000326\u0010\u0006\u001A2\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u00030\u0016H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001C\u001A\u008C\u0001\u0010\u001D\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001E0\u0001\"\u0004\b\u0000\u0010\u001E\"\b\b\u0001\u0010\u0004*\u0002H\u001E\"\u0004\b\u0002\u0010\u0002*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052K\u0010\u0006\u001AG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u001E¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u001E0\u0017H\u0087\u0088\u0004ø\u0001\u0000\u001A¥\u0001\u0010\u001F\u001A\u0002H\u0010\"\u0004\b\u0000\u0010\u001E\"\b\b\u0001\u0010\u0004*\u0002H\u001E\"\u0004\b\u0002\u0010\u0002\"\u0016\b\u0003\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001E0\u0011*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001A\u0002H\u00102K\u0010\u0006\u001AG\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u001E¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000B\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u0002H\u001E0\u0017H\u0087\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010 \u001AK\u0010!\u001A\u0002H\u0010\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0002\"\u0016\b\u0002\u0010\u0010*\u0010\u0012\u0006\b\u0000\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\"0\u0011*\u000E\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0012\u001A\u0002H\u0010H\u0087\u0080\u0004¢\u0006\u0002\u0010#\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$"}, d2={"aggregate", "", "K", "R", "T", "Lkotlin/collections/Grouping;", "operation", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", "first", "aggregateTo", "M", "", "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", "S", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/GroupingKt") class GroupingKt__GroupingKt extends GroupingKt__GroupingJVMKt {
    public GroupingKt__GroupingKt() {
        super();
    }

    public static final Map aggregate(Grouping arg6, Function4 arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "operation");
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v1 = arg6.sourceIterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            Object v3 = arg6.keyOf(v2);
            Object v4 = ((Map)v0).get(v3);
            boolean v5 = v4 != null || (((Map)v0).containsKey(v3)) ? false : true;
            ((Map)v0).put(v3, arg7.invoke(v3, v4, v2, Boolean.valueOf(v5)));
        }

        return ((Map)v0);
    }

    public static final Map aggregateTo(Grouping arg5, Map arg6, Function4 arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "destination");
        Intrinsics.checkNotNullParameter(arg7, "operation");
        Iterator v0 = arg5.sourceIterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = arg5.keyOf(v1);
            Object v3 = arg6.get(v2);
            boolean v4 = v3 != null || (arg6.containsKey(v2)) ? false : true;
            arg6.put(v2, arg7.invoke(v2, v3, v1, Boolean.valueOf(v4)));
        }

        return arg6;
    }

    public static final Map eachCountTo(Grouping arg7, Map arg8) {
        Intrinsics.checkNotNullParameter(arg7, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "destination");
        Integer v1 = Integer.valueOf(0);
        Iterator v2 = arg7.sourceIterator();
        while(v2.hasNext()) {
            Object v3 = arg7.keyOf(v2.next());
            Object v4 = arg8.get(v3);
            int v6 = v4 != null || (arg8.containsKey(v3)) ? 0 : 1;
            if(v6 != 0) {
                Integer v4_1 = v1;
            }

            arg8.put(v3, Integer.valueOf(((Number)v4).intValue() + 1));
        }

        return arg8;
    }

    public static final Map fold(Grouping arg6, Object arg7, Function2 arg8) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg8, "operation");
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v1 = arg6.sourceIterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            Object v3 = arg6.keyOf(v2);
            Object v4 = ((Map)v0).get(v3);
            int v5 = v4 != null || (((Map)v0).containsKey(v3)) ? 0 : 1;
            if(v5 != 0) {
                v4 = arg7;
            }

            ((Map)v0).put(v3, arg8.invoke(v4, v2));
        }

        return ((Map)v0);
    }

    public static final Map fold(Grouping arg6, Function2 arg7, Function3 arg8) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "initialValueSelector");
        Intrinsics.checkNotNullParameter(arg8, "operation");
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v1 = arg6.sourceIterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            Object v3 = arg6.keyOf(v2);
            Object v4 = ((Map)v0).get(v3);
            int v5 = v4 != null || (((Map)v0).containsKey(v3)) ? 0 : 1;
            if(v5 != 0) {
                v4 = arg7.invoke(v3, v2);
            }

            ((Map)v0).put(v3, arg8.invoke(v3, v4, v2));
        }

        return ((Map)v0);
    }

    public static final Map foldTo(Grouping arg5, Map arg6, Object arg7, Function2 arg8) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "destination");
        Intrinsics.checkNotNullParameter(arg8, "operation");
        Iterator v0 = arg5.sourceIterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = arg5.keyOf(v1);
            Object v3 = arg6.get(v2);
            int v4 = v3 != null || (arg6.containsKey(v2)) ? 0 : 1;
            if(v4 != 0) {
                v3 = arg7;
            }

            arg6.put(v2, arg8.invoke(v3, v1));
        }

        return arg6;
    }

    public static final Map foldTo(Grouping arg5, Map arg6, Function2 arg7, Function3 arg8) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "destination");
        Intrinsics.checkNotNullParameter(arg7, "initialValueSelector");
        Intrinsics.checkNotNullParameter(arg8, "operation");
        Iterator v0 = arg5.sourceIterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = arg5.keyOf(v1);
            Object v3 = arg6.get(v2);
            int v4 = v3 != null || (arg6.containsKey(v2)) ? 0 : 1;
            if(v4 != 0) {
                v3 = arg7.invoke(v2, v1);
            }

            arg6.put(v2, arg8.invoke(v2, v3, v1));
        }

        return arg6;
    }

    public static final Map reduce(Grouping arg6, Function3 arg7) {
        Intrinsics.checkNotNullParameter(arg6, "<this>");
        Intrinsics.checkNotNullParameter(arg7, "operation");
        LinkedHashMap v0 = new LinkedHashMap();
        Iterator v1 = arg6.sourceIterator();
        while(v1.hasNext()) {
            Object v2 = v1.next();
            Object v3 = arg6.keyOf(v2);
            Object v4 = ((Map)v0).get(v3);
            int v5 = v4 != null || (((Map)v0).containsKey(v3)) ? 0 : 1;
            if(v5 != 0) {
            }
            else {
                v2 = arg7.invoke(v3, v4, v2);
            }

            ((Map)v0).put(v3, v2);
        }

        return ((Map)v0);
    }

    public static final Map reduceTo(Grouping arg5, Map arg6, Function3 arg7) {
        Intrinsics.checkNotNullParameter(arg5, "<this>");
        Intrinsics.checkNotNullParameter(arg6, "destination");
        Intrinsics.checkNotNullParameter(arg7, "operation");
        Iterator v0 = arg5.sourceIterator();
        while(v0.hasNext()) {
            Object v1 = v0.next();
            Object v2 = arg5.keyOf(v1);
            Object v3 = arg6.get(v2);
            int v4 = v3 != null || (arg6.containsKey(v2)) ? 0 : 1;
            if(v4 != 0) {
            }
            else {
                v1 = arg7.invoke(v2, v3, v1);
            }

            arg6.put(v2, v1);
        }

        return arg6;
    }
}

