package kotlin.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000N\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001A\u0016\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0086\u0080\u0004\u001A/\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0006\u001A\u0016\u0010\u0003\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004\u001A\u0016\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004\u001A/\u0010\u0007\u001A\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0006\u001A%\u0010\t\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\nj\b\u0012\u0004\u0012\u0002H\u0002`\u000B\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\f\u001A9\u0010\t\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\nj\b\u0012\u0004\u0012\u0002H\u0002`\u000B\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\r\u001A%\u0010\u000E\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u000Fj\b\u0012\u0004\u0012\u0002H\u0002`\u0010\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004¢\u0006\u0002\u0010\u0011\u001A9\u0010\u000E\u001A\u0012\u0012\u0004\u0012\u0002H\u00020\u000Fj\b\u0012\u0004\u0012\u0002H\u0002`\u0010\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0004\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0005\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0012\u001A)\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00142\b\u0010\u0015\u001A\u0004\u0018\u0001H\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0016\u001A7\u0010\u0013\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00142\u0016\u0010\u0004\u001A\f\u0012\b\b\u0001\u0012\u0004\u0018\u0001H\u00020\u0005\"\u0004\u0018\u0001H\u0002H\u0087\u0080\u0004¢\u0006\u0002\u0010\u0006\u001AG\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00180\u0001\"\u0004\b\u0000\u0010\u00182\u001F\b\u0001\u0010\u0019\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\b\u0012\u0004\u0012\u00020\u001B0\u001A¢\u0006\u0002\b\u001CH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001AO\u0010\u0017\u001A\b\u0012\u0004\u0012\u0002H\u00180\u0001\"\u0004\b\u0000\u0010\u00182\u0006\u0010\u001D\u001A\u00020\u001E2\u001F\b\u0001\u0010\u0019\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00180\b\u0012\u0004\u0012\u00020\u001B0\u001A¢\u0006\u0002\b\u001CH\u0087\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001A\"\u0010\u001F\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004\u001A \u0010 \u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!"}, d2={"emptySet", "", "T", "setOf", "elements", "", "([Ljava/lang/Object;)Ljava/util/Set;", "mutableSetOf", "", "hashSetOf", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "()Ljava/util/HashSet;", "([Ljava/lang/Object;)Ljava/util/HashSet;", "linkedSetOf", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "()Ljava/util/LinkedHashSet;", "([Ljava/lang/Object;)Ljava/util/LinkedHashSet;", "setOfNotNull", "", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "buildSet", "E", "builderAction", "Lkotlin/Function1;", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "orEmpty", "optimizeReadOnlySet", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/SetsKt") class SetsKt__SetsKt extends SetsKt__SetsJVMKt {
    public SetsKt__SetsKt() {
        super();
    }

    private static final Set buildSet(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        Set v1 = SetsKt.createSetBuilder(arg1);
        arg2.invoke(v1);
        return SetsKt.build(v1);
    }

    private static final Set buildSet(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        Set v0 = SetsKt.createSetBuilder();
        arg1.invoke(v0);
        return SetsKt.build(v0);
    }

    public static final Set emptySet() {
        return EmptySet.INSTANCE;
    }

    private static final HashSet hashSetOf() {
        return new HashSet();
    }

    public static final HashSet hashSetOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return ArraysKt.toCollection(arg2, new HashSet(MapsKt.mapCapacity(arg2.length)));
    }

    private static final LinkedHashSet linkedSetOf() {
        return new LinkedHashSet();
    }

    public static final LinkedHashSet linkedSetOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return ArraysKt.toCollection(arg2, new LinkedHashSet(MapsKt.mapCapacity(arg2.length)));
    }

    private static final Set mutableSetOf() {
        return new LinkedHashSet();
    }

    public static final Set mutableSetOf(Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return ArraysKt.toCollection(arg2, new LinkedHashSet(MapsKt.mapCapacity(arg2.length)));
    }

    public static final Set optimizeReadOnlySet(Set arg2) {
        Intrinsics.checkNotNullParameter(arg2, "<this>");
        int v0 = arg2.size();
        if(v0 != 0) {
            if(v0 != 1) {
                return arg2;
            }

            return SetsKt.setOf(arg2.iterator().next());
        }

        return SetsKt.emptySet();
    }

    private static final Set orEmpty(Set arg0) {
        if(arg0 == null) {
            arg0 = SetsKt.emptySet();
        }

        return arg0;
    }

    private static final Set setOf() {
        return SetsKt.emptySet();
    }

    public static final Set setOf(Object[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        return ArraysKt.toSet(arg1);
    }

    public static final Set setOfNotNull(Object arg0) {
        if(arg0 != null) {
            return SetsKt.setOf(arg0);
        }

        return SetsKt.emptySet();
    }

    public static final Set setOfNotNull(Object[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        return ArraysKt.filterNotNullTo(arg1, new LinkedHashSet());
    }
}

