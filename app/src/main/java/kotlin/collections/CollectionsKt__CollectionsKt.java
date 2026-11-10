package kotlin.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;

@Metadata(d1={"\u0000\u008E\u0001\n\u0000\n\u0002\u0010\u001E\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001C\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000F\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\u001A1\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0006\u001A\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002H\u0086\u0080\u0004\u001A/\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000B\u001A\u0016\u0010\t\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004\u001A%\u0010\u000E\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u000Fj\b\u0012\u0004\u0012\u0002H\u0002`\u0010\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0011\u001A/\u0010\f\u001A\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u00022\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000B\u001A9\u0010\u000E\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u000Fj\b\u0012\u0004\u0012\u0002H\u0002`\u0010\"\u0004\b\u0000\u0010\u00022\u0012\u0010\n\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0012\u001A)\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\b\b\u0000\u0010\u0002*\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u0001H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0016\u001A7\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\b\b\u0000\u0010\u0002*\u00020\u00142\u0016\u0010\n\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00020\u0003\"\u0004\u0018\u0001H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000B\u001AD\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0018\u001A\u00020\u00192!\u0010\u001A\u001A\u001D\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001C\u0012\b\b\u001D\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u0002H\u00020\u001BH\u0087\u0088\u0004ø\u0001\u0000\u001AD\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00020\r\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0018\u001A\u00020\u00192!\u0010\u001A\u001A\u001D\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001C\u0012\b\b\u001D\u0012\u0004\b\b(\u001E\u0012\u0004\u0012\u0002H\u00020\u001BH\u0087\u0088\u0004ø\u0001\u0000\u001AG\u0010 \u001A\b\u0012\u0004\u0012\u0002H!0\b\"\u0004\b\u0000\u0010!2\u001F\b\u0001\u0010\"\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0\r\u0012\u0004\u0012\u00020#0\u001B¢\u0006\u0002\b$H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001AO\u0010 \u001A\b\u0012\u0004\u0012\u0002H!0\b\"\u0004\b\u0000\u0010!2\u0006\u0010%\u001A\u00020\u00192\u001F\b\u0001\u0010\"\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H!0\r\u0012\u0004\u0012\u00020#0\u001B¢\u0006\u0002\b$H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\u001A\u0010-\u001A\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u0088\u0004\u001A-\u0010.\u001A\u00020\u0005\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004\u0082\u0002\u000E\n\f\b\u0000\u0012\u0002\u0018\u0001\u001A\u0004\b\u0003\u0010\u0000\u001A\"\u0010/\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004\u001A\"\u0010/\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\bH\u0087\u0088\u0004\u001AI\u00100\u001A\u0002H1\"\u0010\b\u0000\u00102*\u0006\u0012\u0002\b\u00030\u0001*\u0002H1\"\u0004\b\u0001\u00101*\u0002H22\f\u00103\u001A\b\u0012\u0004\u0012\u0002H104H\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u00105\u001A-\u00106\u001A\u00020\u0005\"\t\b\u0000\u0010\u0002¢\u0006\u0002\b7*\b\u0012\u0004\u0012\u0002H\u00020\u00012\f\u0010\n\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u0088\u0004\u001A(\u00108\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u0002092\u0006\u0010:\u001A\u00020;H\u0087\u0080\u0004\u001A \u0010<\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0080\u0080\u0004\u001AI\u0010=\u001A\u00020\u0019\"\u000E\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020>*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\b2\b\u0010\u0015\u001A\u0004\u0018\u0001H\u00022\b\b\u0002\u0010?\u001A\u00020\u00192\b\b\u0002\u0010@\u001A\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0002\u0010A\u001AW\u0010=\u001A\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\u0006\u0010\u0015\u001A\u0002H\u00022\u001A\u0010B\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020Cj\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`D2\b\b\u0002\u0010?\u001A\u00020\u00192\b\b\u0002\u0010@\u001A\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0002\u0010E\u001Ah\u0010F\u001A\u00020\u0019\"\u0004\b\u0000\u0010\u0002\"\u000E\b\u0001\u0010G*\b\u0012\u0004\u0012\u0002HG0>*\b\u0012\u0004\u0012\u0002H\u00020\b2\b\u0010H\u001A\u0004\u0018\u0001HG2\b\b\u0002\u0010?\u001A\u00020\u00192\b\b\u0002\u0010@\u001A\u00020\u00192\u0016\b\u0004\u0010I\u001A\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001HG0\u001BH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010J\u001AB\u0010=\u001A\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b2\b\b\u0002\u0010?\u001A\u00020\u00192\b\b\u0002\u0010@\u001A\u00020\u00192\u0012\u0010K\u001A\u000E\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00190\u001BH\u0086\u0080\u0004\u001A\'\u0010L\u001A\u00020#2\u0006\u0010\u0018\u001A\u00020\u00192\u0006\u0010?\u001A\u00020\u00192\u0006\u0010@\u001A\u00020\u0019H\u0082\u0080\u0004¢\u0006\u0002\bM\u001A\n\u0010N\u001A\u00020#H\u0081\u0080\u0004\u001A\n\u0010O\u001A\u00020#H\u0081\u0080\u0004\u001A#\u0010P\u001A\n\u0012\u0006\u0012\u0004\u0018\u00010\u00140\u00032\n\u0010Q\u001A\u0006\u0012\u0002\b\u00030\u0001H\u0080\u0080\u0004¢\u0006\u0002\u0010R\u001A5\u0010P\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\u0004\b\u0000\u0010\u00022\n\u0010Q\u001A\u0006\u0012\u0002\b\u00030\u00012\f\u0010S\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0003H\u0080\u0080\u0004¢\u0006\u0002\u0010T\"\u001D\u0010&\u001A\u00020\'*\u0006\u0012\u0002\b\u00030\u00018FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b(\u0010)\"%\u0010*\u001A\u00020\u0019\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\b8FX\u0086\u0084\b¢\u0006\u0006\u001A\u0004\b+\u0010,\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006U"}, d2={"asCollection", "", "T", "", "isVarargs", "", "([Ljava/lang/Object;Z)Ljava/util/Collection;", "emptyList", "", "listOf", "elements", "([Ljava/lang/Object;)Ljava/util/List;", "mutableListOf", "", "arrayListOf", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "()Ljava/util/ArrayList;", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "listOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/List;", "List", "size", "", "init", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "index", "MutableList", "buildList", "E", "builderAction", "", "Lkotlin/ExtensionFunctionType;", "capacity", "indices", "Lkotlin/ranges/IntRange;", "getIndices", "(Ljava/util/Collection;)Lkotlin/ranges/IntRange;", "lastIndex", "getLastIndex", "(Ljava/util/List;)I", "isNotEmpty", "isNullOrEmpty", "orEmpty", "ifEmpty", "R", "C", "defaultValue", "Lkotlin/Function0;", "(Ljava/util/Collection;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "containsAll", "Lkotlin/internal/OnlyInputTypes;", "shuffled", "", "random", "Lkotlin/random/Random;", "optimizeReadOnlyList", "binarySearch", "", "fromIndex", "toIndex", "(Ljava/util/List;Ljava/lang/Comparable;II)I", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/List;Ljava/lang/Object;Ljava/util/Comparator;II)I", "binarySearchBy", "K", "key", "selector", "(Ljava/util/List;Ljava/lang/Comparable;IILkotlin/jvm/functions/Function1;)I", "comparison", "rangeCheck", "rangeCheck$CollectionsKt__CollectionsKt", "throwIndexOverflow", "throwCountOverflow", "collectionToArrayCommonImpl", "collection", "(Ljava/util/Collection;)[Ljava/lang/Object;", "array", "(Ljava/util/Collection;[Ljava/lang/Object;)[Ljava/lang/Object;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/CollectionsKt") class CollectionsKt__CollectionsKt extends CollectionsKt__CollectionsJVMKt {
    public CollectionsKt__CollectionsKt() {
        super();
    }

    private static final List List(int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "init");
        ArrayList v0 = new ArrayList(arg3);
        int v1;
        for(v1 = 0; v1 < arg3; ++v1) {
            v0.add(arg4.invoke(Integer.valueOf(v1)));
        }

        return ((List)v0);
    }

    private static final List MutableList(int arg3, Function1 arg4) {
        Intrinsics.checkNotNullParameter(arg4, "init");
        ArrayList v0 = new ArrayList(arg3);
        int v1;
        for(v1 = 0; v1 < arg3; ++v1) {
            v0.add(arg4.invoke(Integer.valueOf(v1)));
        }

        return ((List)v0);
    }

    private static final ArrayList arrayListOf() {
        return new ArrayList();
    }

    public static final ArrayList arrayListOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        if(arg2.length == 0) {
            return new ArrayList();
        }

        return new ArrayList(CollectionsKt.asCollection(arg2, true));
    }

    public static final Collection asCollection(Object[] arg1, boolean arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return new ArrayAsCollection(arg1, arg2);
    }

    public static Collection asCollection$default(Object[] arg0, boolean arg1, int arg2, Object arg3) {
        return CollectionsKt.asCollection(arg0, false);
    }

    public static final int binarySearch(List arg2, int arg3, int arg4, Function1 arg5) {
        int v0;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "comparison");
        CollectionsKt__CollectionsKt.rangeCheck$CollectionsKt__CollectionsKt(arg2.size(), arg3, arg4);
        --arg4;
        while(true) {
            if(arg3 > arg4) {
                goto label_20;
            }

            v0 = arg3 + arg4 >>> 1;
            int v1 = arg5.invoke(arg2.get(v0)).intValue();
            if(v1 < 0) {
                arg3 = v0 + 1;
                continue;
            }

            if(v1 <= 0) {
                return v0;
            }

            arg4 = v0 - 1;
        }

        return v0;
    label_20:
        return -(arg3 + 1);
    }

    public static final int binarySearch(List arg2, Comparable arg3, int arg4, int arg5) {
        int v0;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        CollectionsKt__CollectionsKt.rangeCheck$CollectionsKt__CollectionsKt(arg2.size(), arg4, arg5);
        --arg5;
        while(true) {
            if(arg4 > arg5) {
                goto label_17;
            }

            v0 = arg4 + arg5 >>> 1;
            int v1 = ComparisonsKt.compareValues(arg2.get(v0), arg3);
            if(v1 < 0) {
                arg4 = v0 + 1;
                continue;
            }

            if(v1 <= 0) {
                return v0;
            }

            arg5 = v0 - 1;
        }

        return v0;
    label_17:
        return -(arg4 + 1);
    }

    public static final int binarySearch(List arg2, Object arg3, Comparator arg4, int arg5, int arg6) {
        int v0;
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "comparator");
        CollectionsKt__CollectionsKt.rangeCheck$CollectionsKt__CollectionsKt(arg2.size(), arg5, arg6);
        --arg6;
        while(true) {
            if(arg5 > arg6) {
                goto label_19;
            }

            v0 = arg5 + arg6 >>> 1;
            int v1 = arg4.compare(arg2.get(v0), arg3);
            if(v1 < 0) {
                arg5 = v0 + 1;
                continue;
            }

            if(v1 <= 0) {
                return v0;
            }

            arg6 = v0 - 1;
        }

        return v0;
    label_19:
        return -(arg5 + 1);
    }

    public static int binarySearch$default(List arg0, int arg1, int arg2, Function1 arg3, int arg4, Object arg5) {
        if((arg4 & 2) != 0) {
            arg2 = arg0.size();
        }

        return CollectionsKt.binarySearch(arg0, 0, arg2, arg3);
    }

    public static int binarySearch$default(List arg0, Comparable arg1, int arg2, int arg3, int arg4, Object arg5) {
        if((arg4 & 4) != 0) {
            arg3 = arg0.size();
        }

        return CollectionsKt.binarySearch(arg0, arg1, 0, arg3);
    }

    public static int binarySearch$default(List arg0, Object arg1, Comparator arg2, int arg3, int arg4, int arg5, Object arg6) {
        if((arg5 & 8) != 0) {
            arg4 = arg0.size();
        }

        return CollectionsKt.binarySearch(arg0, arg1, arg2, 0, arg4);
    }

    public static final int binarySearchBy(List arg1, Comparable arg2, int arg3, int arg4, Function1 arg5) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg5, "selector");
        return CollectionsKt.binarySearch(arg1, arg3, arg4, new CollectionsKt__CollectionsKt$binarySearchBy$1(arg5, arg2));
    }

    public static int binarySearchBy$default(List arg0, Comparable arg1, int arg2, int arg3, Function1 arg4, int arg5, Object arg6) {
        if((arg5 & 4) != 0) {
            arg3 = arg0.size();
        }

        Intrinsics.checkNotNullParameter(arg0, "<this>");
        Intrinsics.checkNotNullParameter(arg4, "selector");
        return CollectionsKt.binarySearch(arg0, 0, arg3, new CollectionsKt__CollectionsKt$binarySearchBy$1(arg4, arg1));
    }

    private static final List buildList(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        List v1 = CollectionsKt.createListBuilder(arg1);
        arg2.invoke(v1);
        return CollectionsKt.build(v1);
    }

    private static final List buildList(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        List v0 = CollectionsKt.createListBuilder();
        arg1.invoke(v0);
        return CollectionsKt.build(v0);
    }

    public static final Object[] collectionToArrayCommonImpl(Collection arg4) {
        Intrinsics.checkNotNullParameter(arg4, "collection");
        int v1 = 0;
        if(arg4.isEmpty()) {
            return new Object[0];
        }

        Object[] v0 = new Object[arg4.size()];
        Iterator v4 = arg4.iterator();
        while(v4.hasNext()) {
            v0[v1] = v4.next();
            ++v1;
        }

        return v0;
    }

    public static final Object[] collectionToArrayCommonImpl(Collection arg4, Object[] arg5) {
        Intrinsics.checkNotNullParameter(arg4, "collection");
        Intrinsics.checkNotNullParameter(arg5, "array");
        int v1 = 0;
        if(arg4.isEmpty()) {
            return CollectionsKt.terminateCollectionToArray(0, arg5);
        }

        if(arg5.length < arg4.size()) {
            arg5 = ArraysKt.arrayOfNulls(arg5, arg4.size());
        }

        Iterator v0 = arg4.iterator();
        while(v0.hasNext()) {
            arg5[v1] = v0.next();
            ++v1;
        }

        return CollectionsKt.terminateCollectionToArray(arg4.size(), arg5);
    }

    private static final boolean containsAll(Collection arg1, Collection arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return arg1.containsAll(arg2);
    }

    public static final List emptyList() {
        return EmptyList.INSTANCE;
    }

    public static final IntRange getIndices(Collection arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        return new IntRange(0, arg2.size() - 1);
    }

    public static final int getLastIndex(List arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.size() - 1;
    }

    private static final Object ifEmpty(Collection arg1, Function0 arg2) {
        Object v1;
        Intrinsics.checkNotNullParameter(arg2, "defaultValue");
        if(arg1.isEmpty()) {
            v1 = arg2.invoke();
        }

        return ((Collection)v1);
    }

    private static final boolean isNotEmpty(Collection arg1) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        return arg1.isEmpty() ^ 1;
    }

    private static final boolean isNullOrEmpty(Collection arg0) {
        if(arg0 != null) {
            if(arg0.isEmpty()) {
            }
            else {
                return 0;
            }
        }

        return 1;
    }

    private static final List listOf() {
        return CollectionsKt.emptyList();
    }

    public static final List listOf(Object[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        if(arg1.length > 0) {
            return ArraysKt.asList(arg1);
        }

        return CollectionsKt.emptyList();
    }

    public static final List listOfNotNull(Object arg0) {
        if(arg0 != null) {
            return CollectionsKt.listOf(arg0);
        }

        return CollectionsKt.emptyList();
    }

    public static final List listOfNotNull(Object[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        return ArraysKt.filterNotNull(arg1);
    }

    private static final List mutableListOf() {
        return new ArrayList();
    }

    public static final List mutableListOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        if(arg2.length == 0) {
            return new ArrayList();
        }

        return new ArrayList(CollectionsKt.asCollection(arg2, true));
    }

    public static final List optimizeReadOnlyList(List arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v0 = arg2.size();
        if(v0 != 0) {
            if(v0 != 1) {
                return arg2;
            }

            return CollectionsKt.listOf(arg2.get(0));
        }

        return CollectionsKt.emptyList();
    }

    private static final Collection orEmpty(Collection arg0) {
        List v0;
        if(arg0 == null) {
            v0 = CollectionsKt.emptyList();
        }

        return ((Collection)v0);
    }

    private static final List orEmpty(List arg0) {
        if(arg0 == null) {
            arg0 = CollectionsKt.emptyList();
        }

        return arg0;
    }

    private static final void rangeCheck$CollectionsKt__CollectionsKt(int arg3, int arg4, int arg5) {
        String v0 = ").";
        String v1 = "fromIndex (";
        if(arg4 <= arg5) {
            if(arg4 >= 0) {
                if(arg5 <= arg3) {
                    return;
                }

                throw new IndexOutOfBoundsException("toIndex (" + arg5 + ") is greater than size (" + arg3 + v0);
            }

            throw new IndexOutOfBoundsException(v1 + arg4 + ") is less than zero.");
        }

        throw new IllegalArgumentException(v1 + arg4 + ") is greater than toIndex (" + arg5 + v0);
    }

    public static final List shuffled(Iterable arg1, Random arg2) {
        Intrinsics.checkNotNullParameter(arg1, "<this>");
        Intrinsics.checkNotNullParameter(arg2, "random");
        List v1 = CollectionsKt.toMutableList(arg1);
        CollectionsKt.shuffle(v1, arg2);
        return v1;
    }

    public static final void throwCountOverflow() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static final void throwIndexOverflow() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}

