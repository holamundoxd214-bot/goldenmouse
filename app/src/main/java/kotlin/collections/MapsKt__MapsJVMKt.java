package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Map$Entry;
import java.util.Map;
import java.util.Properties;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentMap;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.builders.MapBuilder;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000b\n\u0000\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000E\n\u0002\b\u0006\u001A6\u0010\u0000\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0004\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004\u001AJ\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032#\u0010\u0007\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000BH\u0081\u0088\u0004ø\u0001\u0000\u001AR\u0010\u0006\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\f\u001A\u00020\r2#\u0010\u0007\u001A\u001F\u0012\u0010\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000BH\u0081\u0088\u0004ø\u0001\u0000\u001A\"\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003H\u0081\u0080\u0004\u001A*\u0010\u000E\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\t\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\f\u001A\u00020\rH\u0081\u0080\u0004\u001A6\u0010\u000F\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0012\u0010\u0010\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\tH\u0081\u0080\u0004\u001AD\u0010\u0011\u001A\u0002H\u0003\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00122\u0006\u0010\u0013\u001A\u0002H\u00022\f\u0010\u0014\u001A\b\u0012\u0004\u0012\u0002H\u00030\u0015H\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001A>\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0018\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0019\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0086\u0080\u0004\u001AD\u0010\u0017\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00012\u000E\u0010\u001A\u001A\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u001BH\u0086\u0080\u0004\u001A]\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0018\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0019\"\u0004\b\u0001\u0010\u00032*\u0010\u001D\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u001E\"\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0086\u0080\u0004¢\u0006\u0002\u0010\u001F\u001Ac\u0010\u001C\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0018\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u000E\u0010\u001A\u001A\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\u001B2*\u0010\u001D\u001A\u0016\u0012\u0012\b\u0001\u0012\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u001E\"\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0005H\u0087\u0080\u0004¢\u0006\u0002\u0010 \u001A\u001A\u0010!\u001A\u00020\"*\u000E\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020#0\u0001H\u0087\u0088\u0004\u001A2\u0010$\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0081\u0088\u0004\u001A4\u0010%\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\u0010\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u0001H\u0080\u0080\u0004\u001A\u0012\u0010&\u001A\u00020\r2\u0006\u0010\'\u001A\u00020\rH\u0081\u0080\u0004\"\u000F\u0010(\u001A\u00020\rX\u0082Ô\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2={"mapOf", "", "K", "V", "pair", "Lkotlin/Pair;", "buildMapInternal", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "createMapBuilder", "build", "builder", "getOrPut", "Ljava/util/concurrent/ConcurrentMap;", "key", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/concurrent/ConcurrentMap;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toSortedMap", "Ljava/util/SortedMap;", "", "comparator", "Ljava/util/Comparator;", "sortedMapOf", "pairs", "", "([Lkotlin/Pair;)Ljava/util/SortedMap;", "(Ljava/util/Comparator;[Lkotlin/Pair;)Ljava/util/SortedMap;", "toProperties", "Ljava/util/Properties;", "", "toSingletonMapOrSelf", "toSingletonMap", "mapCapacity", "expectedSize", "INT_MAX_POWER_OF_TWO", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/MapsKt") class MapsKt__MapsJVMKt extends MapsKt__MapWithDefaultKt {
    private static final int INT_MAX_POWER_OF_TWO = 0x40000000;

    public MapsKt__MapsJVMKt() {
        super();
    }

    public static final Map build(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builder");
        return ((MapBuilder)arg1).build();
    }

    private static final Map buildMapInternal(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        Map v1 = MapsKt.createMapBuilder(arg1);
        arg2.invoke(v1);
        return MapsKt.build(v1);
    }

    private static final Map buildMapInternal(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        Map v0 = MapsKt.createMapBuilder();
        arg1.invoke(v0);
        return MapsKt.build(v0);
    }

    public static final Map createMapBuilder() {
        return new MapBuilder();
    }

    public static final Map createMapBuilder(int arg1) {
        return new MapBuilder(arg1);
    }

    public static final Object getOrPut(ConcurrentMap arg1, Object arg2, Function0 arg3) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg3, "defaultValue");
        Object v0 = arg1.get(arg2);
        if(v0 == null) {
            Object v3 = arg3.invoke();
            Object v1 = arg1.putIfAbsent(arg2, v3);
            if(v1 == null) {
                return v3;
            }

            return v1;
        }

        return v0;
    }

    public static final int mapCapacity(int arg1) {
        if(arg1 < 0) {
            return arg1;
        }

        if(arg1 < 3) {
            return arg1 + 1;
        }

        if(arg1 < 0x40000000) {
            return ((int)((((float)arg1)) / 0.75f + 1f));
        }

        return 0x7FFFFFFF;
    }

    public static final Map mapOf(Pair arg1) {
        Intrinsics.checkNotNullParameter(arg1, "pair");
        Map v1 = Collections.singletonMap(arg1.getFirst(), arg1.getSecond());
        Intrinsics.checkNotNullExpressionValue(v1, "singletonMap(...)");
        return v1;
    }

    public static final SortedMap sortedMapOf(Comparator arg1, Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "comparator");
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        TreeMap v0 = new TreeMap(arg1);
        MapsKt.putAll(v0, arg2);
        return ((SortedMap)v0);
    }

    public static final SortedMap sortedMapOf(Pair[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "pairs");
        TreeMap v0 = new TreeMap();
        MapsKt.putAll(v0, arg2);
        return ((SortedMap)v0);
    }

    private static final Properties toProperties(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Properties v0 = new Properties();
        v0.putAll(arg1);
        return v0;
    }

    public static final Map toSingletonMap(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Object v1 = arg1.entrySet().iterator().next();
        arg1 = Collections.singletonMap(((Map$Entry)v1).getKey(), ((Map$Entry)v1).getValue());
        Intrinsics.checkNotNullExpressionValue(arg1, "with(...)");
        return arg1;
    }

    private static final Map toSingletonMapOrSelf(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return MapsKt.toSingletonMap(arg1);
    }

    public static final SortedMap toSortedMap(Map arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new TreeMap(arg1);
    }

    public static final SortedMap toSortedMap(Map arg1, Comparator arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "comparator");
        TreeMap v0 = new TreeMap(arg2);
        v0.putAll(arg1);
        return ((SortedMap)v0);
    }
}

