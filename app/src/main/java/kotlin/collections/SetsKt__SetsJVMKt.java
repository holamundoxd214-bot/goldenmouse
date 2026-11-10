package kotlin.collections;

import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.collections.builders.SetBuilder;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1={"\u0000>\n\u0000\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001A#\u0010\u0000\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001A\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001A8\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u001D\u0010\u0007\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000BH\u0081\u0088\u0004ø\u0001\u0000\u001A@\u0010\u0005\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\u0006\u0010\f\u001A\u00020\r2\u001D\u0010\u0007\u001A\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00060\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000BH\u0081\u0088\u0004ø\u0001\u0000\u001A\u0016\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u0006H\u0081\u0080\u0004\u001A\u001E\u0010\u000E\u001A\b\u0012\u0004\u0012\u0002H\u00060\t\"\u0004\b\u0000\u0010\u00062\u0006\u0010\f\u001A\u00020\rH\u0081\u0080\u0004\u001A$\u0010\u000F\u001A\b\u0012\u0004\u0012\u0002H\u00060\u0001\"\u0004\b\u0000\u0010\u00062\f\u0010\u0010\u001A\b\u0012\u0004\u0012\u0002H\u00060\tH\u0081\u0080\u0004\u001A/\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u00022\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0014\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0015\u001AK\u0010\u0011\u001A\b\u0012\u0004\u0012\u0002H\u00020\u0012\"\u0004\b\u0000\u0010\u00022\u001A\u0010\u0016\u001A\u0016\u0012\u0006\b\u0000\u0012\u0002H\u00020\u0017j\n\u0012\u0006\b\u0000\u0012\u0002H\u0002`\u00182\u0012\u0010\u0013\u001A\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0014\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0019\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001A"}, d2={"setOf", "", "T", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "buildSetInternal", "E", "builderAction", "Lkotlin/Function1;", "", "", "Lkotlin/ExtensionFunctionType;", "capacity", "", "createSetBuilder", "build", "builder", "sortedSetOf", "Ljava/util/TreeSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, k=5, mv={2, 3, 0}, xi=49, xs="kotlin/collections/SetsKt") class SetsKt__SetsJVMKt {
    public SetsKt__SetsJVMKt() {
        super();
    }

    public static final Set build(Set arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builder");
        return ((SetBuilder)arg1).build();
    }

    private static final Set buildSetInternal(int arg1, Function1 arg2) {
        Intrinsics.checkNotNullParameter(arg2, "builderAction");
        Set v1 = SetsKt.createSetBuilder(arg1);
        arg2.invoke(v1);
        return SetsKt.build(v1);
    }

    private static final Set buildSetInternal(Function1 arg1) {
        Intrinsics.checkNotNullParameter(arg1, "builderAction");
        Set v0 = SetsKt.createSetBuilder();
        arg1.invoke(v0);
        return SetsKt.build(v0);
    }

    public static final Set createSetBuilder() {
        return new SetBuilder();
    }

    public static final Set createSetBuilder(int arg1) {
        return new SetBuilder(arg1);
    }

    public static final Set setOf(Object arg1) {
        Set v1 = Collections.singleton(arg1);
        Intrinsics.checkNotNullExpressionValue(v1, "singleton(...)");
        return v1;
    }

    public static final TreeSet sortedSetOf(Comparator arg1, Object[] arg2) {
        Intrinsics.checkNotNullParameter(arg1, "comparator");
        Intrinsics.checkNotNullParameter(arg2, "elements");
        return ArraysKt.toCollection(arg2, new TreeSet(arg1));
    }

    public static final TreeSet sortedSetOf(Object[] arg1) {
        Intrinsics.checkNotNullParameter(arg1, "elements");
        return ArraysKt.toCollection(arg1, new TreeSet());
    }
}

